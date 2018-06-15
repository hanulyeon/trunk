package com.tmax.flowengine.adapter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import com.tmax.flowengine.adapter.dto.AdapterInfo;
import com.tmax.flowengine.adapter.dto.AdapterInfoMsgJson;
import com.tmax.flowengine.adapter.dto.FlowEngineMessage;
import com.tmax.flowengine.adapter.dto.FlowEngineMessageMsgJson;
import com.tmax.flowengine.adapter.protocol.AdapterHeader;
import com.tmax.flowengine.meta.flowgraph.activity.AdapterType;

public class AdapterTestSec {
    public static void main(String[] args) {
        AdapterTestSec test = new AdapterTestSec();
        try {
            test.run();
        } catch (Throwable e) {
            System.out.println("exception");
            test.close();
        }
    }
    
    
    
    private SocketChannel   socket;
    
    
    public void run() throws Throwable {
        socket  = SocketChannel.open();
        socket.connect(new InetSocketAddress("127.0.0.1", 1818));
        
        AdapterInfo         adapterInfo         = new AdapterInfo();
        AdapterInfoMsgJson  adpaterSerializer   = new AdapterInfoMsgJson();
        adapterInfo.setType(AdapterType.TEST.toString());
        adapterInfo.setName("testAdapter2");
        adapterInfo.setId(2);
        byte[] body  = adpaterSerializer.marshal(adapterInfo);
        sendMessage(AdapterHeader.Type.HANDSHAKE, body);
        
        ByteBuffer buffer = ByteBuffer.allocateDirect(AdapterHeader.LENGTH);
        while(buffer.hasRemaining()) {
            socket.read(buffer);
        }
        buffer.flip();
        AdapterHeader requestHeader = new AdapterHeader();
        requestHeader.unpack(buffer);
        buffer = ByteBuffer.allocateDirect(requestHeader.getBodyLength());
        while(buffer.hasRemaining()) {
            socket.read(buffer);
        }
        buffer.flip();
        
        byte[] bytes = new byte[requestHeader.getBodyLength()];
        buffer.get(bytes);
                
        FlowEngineMessageMsgJson    jsonConverter   = new FlowEngineMessageMsgJson();
        FlowEngineMessage           message         = (FlowEngineMessage)jsonConverter.unmarshal(bytes);
        
        FlowEngineMessage           responseMessage = new FlowEngineMessage();
        responseMessage.setSync(true);
        responseMessage.setGuid(message.getGuid());
        responseMessage.setFlowId(message.getFlowId());
        responseMessage.setMessage("{\"reload\":false}");
        
        bytes = jsonConverter.marshal(responseMessage);
        sendMessage(AdapterHeader.Type.RESPONSE, bytes);
    }
    
    public void sendMessage(AdapterHeader.Type type, byte[] body) throws IOException {
        AdapterHeader   header  = new AdapterHeader();
        
        ByteBuffer      buffer  = ByteBuffer.allocateDirect(AdapterHeader.LENGTH + body.length);
        header.setMagicNumber(AdapterHeader.MAGIC_NUMBER);
        header.setType(type.toShort());
        header.setBodyLength(body.length);
        
        header.pack(buffer);
        buffer.put(body);
        buffer.flip();
        while(buffer.hasRemaining()) {
            socket.write(buffer);
        }
    }
    
    public void close() {
        try {
            socket.close();
        } catch (IOException ignore) { }
    }
}
