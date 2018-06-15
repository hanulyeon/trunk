package com.tmax.flowengine.flow.activity.outbound;

import java.util.logging.Level;

import com.tmax.flowengine.adapter.AdapterManager;
import com.tmax.flowengine.adapter.dto.FlowEngineMessage;
import com.tmax.flowengine.exception.FlowEngineExceptionCode;
import com.tmax.flowengine.flow.Flow;
import com.tmax.flowengine.flow.activity.FlowActivityHandler;
import com.tmax.flowengine.flow.graph.FlowNode;
import com.tmax.flowengine.flow.mapping.VariableMapper;
import com.tmax.flowengine.meta.flowgraph.activity.ActivityOutbound;
import com.tmax.flowengine.meta.flowgraph.activity.AdapterType;
import com.tmax.flowengine.meta.flowgraph.activity.OutboundAdapterInfo;
import com.tmax.proobject.core.exception.ProObjectRuntimeException;
import com.tmax.proobject.engine.event.channel.ChannelEventManager;
import com.tmax.proobject.engine.promapper.ProMapperUtil;
import com.tmax.proobject.engine.promapper.ProMapperUtil.MarshalResult;
import com.tmax.proobject.logger.application.EventLogger;
import com.tmax.proobject.model.channelevent.ChannelHandlable;
import com.tmax.proobject.model.dataobject.DataObject;
import com.tmax.proobject.model.event.Event;
import com.tmax.proobject.model.event.UserContext;
import com.tmax.proobject.model.promapper.ProMapperMessageType;
import com.tmax.proobject.network.event.ChannelWriteEvent;
import com.tmax.proobject.util.StringUtil;

public class ActivityOutboundHandler extends FlowActivityHandler {
    @Override
    public boolean onActivity(FlowNode node, Flow flow, UserContext userContext) throws Throwable {
        ActivityOutbound        outbound    = (ActivityOutbound)node.getMeta().getActivity();
        OutboundAdapterInfo     adapterInfo = outbound.getAdapter();
        AdapterType             adapterType = adapterInfo.getType();
        ChannelHandlable        handler     = null;
        
        if(StringUtil.isNotEmpty(adapterInfo.getName())) {
            handler = AdapterManager.getAdapter(adapterType, adapterInfo.getName());
        } else {
            handler = AdapterManager.getAdapter(adapterType, adapterInfo.getIp(), adapterInfo.getPort());
        }
        
        if(handler == null) {
            throw new ProObjectRuntimeException(FlowEngineExceptionCode.ADAPTER_NOT_CONNECTED);
        }
        
        DataObject          dataObject  = null;
        ChannelWriteEvent   writeEvent  = null;
        FlowEngineMessage   message     = new FlowEngineMessage();
        if(outbound.getInput() != null) {
            dataObject = VariableMapper.mapToDataObject(flow.getContext(), outbound.getInput());
        }
        
        message.setGuid(userContext.getGUID());
        message.setFlowId(flow.getMeta().getId());
        message.setSync(outbound.isSync());
        
        if(dataObject != null) {
            writeEvent      = new ChannelWriteEvent(handler, outbound.getInput());
            byte[]  bytes   = "".getBytes();
            
            if(dataObject != null) {
                MarshalResult result = (MarshalResult)ProMapperUtil.marshalDataObject(flow.getApplication(), dataObject, ProMapperMessageType.JSON);
                bytes = (byte[])result.getResultObject();
                message.setMessage(new String(bytes, "UTF-8"));
            }
        }
        
        writeEvent = new ChannelWriteEvent(handler, message);
        ChannelEventManager.postChannelEvent(writeEvent, getCurrentEvent(), getCurrentUserContext());
            
        if(outbound.isSync()) {
            // * Sync 상황이면 다음 Flow 로 넘어가면 안된다.
            return false;
        }
        
        return true;
    }
    
    @Override
    public boolean onActivityWithResponseEvent(Event responseEvent, FlowNode node, Flow flow, UserContext userContext) throws Throwable {
        AdapterResponseEvent response = (AdapterResponseEvent)responseEvent;
        ActivityOutbound outbound = (ActivityOutbound)node.getMeta().getActivity();
        if(response.hasException()) {
            throw response.getException();
        }
        
        if(outbound.getOutput() != null) {
            // * Debugging 용 DataObject...
            DataObject dataObject = VariableMapper.mapFromDataObject(response.getMessage().getBytes(), flow.getContext(), outbound.getOutput());
            if(EventLogger.getLogger().isLoggable(Level.FINER)) {
                EventLogger.getLogger().finer(dataObject.toString());
            }
        }
        
        return true;
    }
}
