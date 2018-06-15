package com.tmax.flowengine.adapter.channel;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;

import com.tmax.flowengine.adapter.AdapterManager;
import com.tmax.flowengine.adapter.dto.AdapterInfo;
import com.tmax.flowengine.adapter.dto.AdapterInfoMsgJson;
import com.tmax.flowengine.adapter.dto.FlowEngineMessage;
import com.tmax.flowengine.adapter.dto.FlowEngineMessageMsgJson;
import com.tmax.flowengine.adapter.protocol.AdapterHeader;
import com.tmax.flowengine.flow.activity.outbound.AdapterResponseEvent;
import com.tmax.flowengine.meta.flowgraph.activity.AdapterType;
import com.tmax.proobject.engine.event.channel.ChannelEventManager;
import com.tmax.proobject.logger.application.ChannelEventLogger;
import com.tmax.proobject.model.event.UserContext;
import com.tmax.proobject.network.eventhandler.socket.SocketChannelEventHandler;
import com.tmax.proobject.network.manager.ChannelManager;

public class AdapterChannelEventHandler extends SocketChannelEventHandler {
    private boolean                     readingHeader;
    private boolean                     readingBody;
    private FlowEngineMessageMsgJson    jsonConverter;
    private Map<Long, Long>             requestIdMap;
    //*************************************************************************************************************
    // * Status Variables.
    //*************************************************************************************************************
    private String                      instanceInfo;
    private AdapterInfo                 adapterInfo;
    private AdapterType                 adapterType;
    //*************************************************************************************************************
    // * 현재 처리중인 Reading 관련 Variables.
    //*************************************************************************************************************
    private ByteBuffer                  readHeaderBuffer;
    private ByteBuffer                  readBodyBuffer;
    private AdapterHeader               currentReadHeader;
    private byte[]                      currentReadBody;
    //*************************************************************************************************************
    // * 현재 처리중인 Writing 관련 Variables.
    //*************************************************************************************************************
    private Queue<ByteBuffer>           writeQueue;
    
    
    public AdapterChannelEventHandler() {
        readingHeader       = true;
        readingBody         = false;
        readHeaderBuffer    = ByteBuffer.allocateDirect(AdapterHeader.LENGTH);
        jsonConverter       = new FlowEngineMessageMsgJson();
        writeQueue          = new LinkedList<>();
        requestIdMap        = new HashMap<>();
        
        //TODO : config 읽어와서 module 연결
    }
    
    @Override
    public void onRead(AbstractSelectableChannel channel) {
        try {
            SocketChannel socket = (SocketChannel)channel;
            if(readingHeader) {
                if(readHeader(socket) == false) {
                    return;
                }
            }
            
            if(readingBody) {
                if(readBody(socket) == false) {
                    return;
                }
            }
            
            AdapterHeader.Type type = AdapterHeader.Type.fromShort(currentReadHeader.getType());
            if(adapterInfo == null && type != AdapterHeader.Type.HANDSHAKE) {
                throw new RuntimeException("ADAPTER NEEDS HANDSHAKING!");
            }
            
            switch(type) {
                case HANDSHAKE :
                {
                    AdapterInfoMsgJson infoMsg  = new AdapterInfoMsgJson();
                    adapterInfo                 = (AdapterInfo)infoMsg.unmarshal(currentReadBody);
                    adapterType                 = AdapterType.fromValue(adapterInfo.getType());
                    AdapterManager.registerAdapter(adapterType, this);
                    
                    if(ChannelEventLogger.getLogger().isLoggable(Level.INFO)) {
                        ChannelEventLogger.getLogger().info("{0} Regsitered", toString());
                    }
                    break;
                }
                case RESPONSE :
                {
                    FlowEngineMessage message = (FlowEngineMessage)jsonConverter.unmarshal(currentReadBody);
                    if(message.getSync() == true) {
                        AdapterResponseEvent response = new AdapterResponseEvent();
                        response.setMessage(message.getMessage());
                        
                        Long requestId = requestIdMap.remove(message.getFlowId());
                        if(requestId == null) {
                            // * 심각한 문제 상황.
                        }
                        ChannelEventManager.resumeEvent(requestId.longValue(), response);
                    } else {
                        // * 에러 상황.
                    }
                    break;
                }
                case REQUEST :
                {
                    FlowEngineMessage message = (FlowEngineMessage)jsonConverter.unmarshal(currentReadBody);
                    // * Flow 를 태울 수 있도록 조치하시면 됩니다.
//                    FlowManager.startFlow(...);
                    break;
                }
            }
            
            currentReadHeader           = null;
            currentReadBody             = null;
        } catch (Throwable e) {
            onError(channel, e);
        }
    }
    
    public boolean readHeader(SocketChannel socket) throws Throwable {
        if(readHeaderBuffer.hasRemaining()) {
            if(socket.read(readHeaderBuffer) <= 0) {
                throw new RuntimeException(toString() + " Can't read header message from adapter!");
            }
        }
        
        boolean end = readHeaderBuffer.hasRemaining() == false;
        if(end) {
            readingHeader       = false;
            readingBody         = true;
            currentReadHeader   = new AdapterHeader();
            
            readHeaderBuffer.flip();
            currentReadHeader.unpack(readHeaderBuffer);
            readHeaderBuffer.clear();
            
            readBodyBuffer  = ByteBuffer.allocate(currentReadHeader.getBodyLength());
        }
        
        return end;
    }
    
    public boolean readBody(SocketChannel socket) throws Throwable {
        if(readBodyBuffer.hasRemaining()) {
            if(socket.read(readBodyBuffer) <= 0) {
                throw new RuntimeException(toString() + " Can't read body message from adapter!");
            }
        }
        
        boolean end = readBodyBuffer.hasRemaining() == false;
        if(end) {
            readingHeader   = true;
            readingBody     = false;
            
            currentReadBody = new byte[currentReadHeader.getBodyLength()];
            
            readBodyBuffer.flip();
            readBodyBuffer.get(currentReadBody);
            
            readBodyBuffer = null;
        }
        
        return end;
    }
    
    @Override
    public void onWrite(AbstractSelectableChannel channel, Object data, UserContext userContext, long requestId) {
        try {
            FlowEngineMessage   message = (FlowEngineMessage)data;
            byte[]              bytes   = jsonConverter.marshal(message);
            
            AdapterHeader       header  = new AdapterHeader();
            header.setMagicNumber(AdapterHeader.MAGIC_NUMBER);
            header.setType(AdapterHeader.Type.REQUEST.toShort());
            header.setBodyLength(bytes.length);
            
            ByteBuffer writeBuffer = ByteBuffer.allocateDirect(AdapterHeader.LENGTH + bytes.length);
            header.pack(writeBuffer);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            
            writeQueue.add(writeBuffer);
            
            if(message.getSync() == true) {
                requestIdMap.put(message.getFlowId(), requestId);
            }
            
            ChannelManager.update(channel, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } catch (Throwable e) {
            onError(channel, e);
        }
    }

    @Override
    public void onWritable(AbstractSelectableChannel channel) {
        try {
            ByteBuffer currentWriteBuffer   = writeQueue.peek();
            if(currentWriteBuffer == null) {
           //     ChannelManager.update(channel, SelectionKey.OP_WRITE);
                return;
            }
            
            if(currentWriteBuffer.hasRemaining()) {
                SocketChannel socket = (SocketChannel)channel;
                socket.write(currentWriteBuffer);
            }
            
            if(currentWriteBuffer.hasRemaining() == false) {
                writeQueue.poll();
            }
        } catch (Throwable e) {
            onError(channel, e);
        }
    }
    
    @Override
    public void onError(AbstractSelectableChannel channel, Throwable error) {
        if(requestIdMap.size() > 0) {
            for(Long flowId : requestIdMap.keySet()) {
                Long requestId = requestIdMap.remove(flowId);
                
                if(requestId != null) {
                    AdapterResponseEvent response = new AdapterResponseEvent();
                    response.setException(error);
                    
                    try {
                        ChannelEventManager.resumeEvent(requestId.longValue(), response);
                    } catch (Throwable e) {
                        ChannelEventLogger.getLogger().severe("SEND RESPONSE IS FAILED", e);
                    }
                }
            }
        }
        super.onError(channel, error);
    }

    @Override
    public void onClose(AbstractSelectableChannel channel) {
        super.onClose(channel);
        
        AdapterManager.unregisterAdapter(this);
        
        if(ChannelEventLogger.getLogger().isLoggable(Level.INFO)) {
            ChannelEventLogger.getLogger().info("{0} Unregistered", toString());
        }
    }
    
    @Override
    public String toString() {
        if(instanceInfo == null) {
            String  type        = getType() == null ? "NONE" : getType().toString();
            String  remote      = "NOT-CONNECTED";
            String  localPort   = "NOT-CONNECTED";
            String  name        = getName();
            
            if(getChannel() != null || ((SocketChannel)getChannel()).isConnected() == true) {
                remote = getRemoteAddress().toString();
                localPort   = Integer.toString(((InetSocketAddress)getLocalAddress()).getPort());
            }
            
            instanceInfo = "[AdapterChannelEventHandler]["+type+"]["+name+":"+remote+"]["+localPort+"]";
        }
        return instanceInfo;
    }
    
    public String getName() {
        if(adapterInfo == null) {
            return "NONAME";
        }
        return adapterInfo.getName();
    }

    public AdapterType getType() {
        return adapterType;
    }
    
    public SocketAddress getLocalAddress() {
        try {
            InetSocketAddress   localAddress    = (InetSocketAddress)((SocketChannel)getChannel()).getLocalAddress();
            return localAddress;
        } catch (Throwable ignore) { }
        
        return null;
    }
}
