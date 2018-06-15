package com.tmax.flowengine.manager;

import com.tmax.flowengine.flow.Flow;
import com.tmax.flowengine.flow.control.FlowControlEvent;
import com.tmax.flowengine.flow.control.FlowControlEvent.Status;
import com.tmax.proobject.engine.event.channel.ChannelEventManager;
import com.tmax.proobject.model.event.UserContext;
import com.tmax.proobject.model.network.ProObjectRequest;
import com.tmax.proobject.model.session.ProObjectSession;
import com.tmax.proobject.network.event.ChannelWriteEvent;
import com.tmax.proobject.util.concurrency.ProObjectThread;

public class FlowManager {
    public static void startFlow(String ip, int port, ProObjectRequest requestInfo, ProObjectSession session, String flowName) {
        startFlow(FlowEngineManager.generateGUID(), ip, port, requestInfo, session, flowName);
    }
    
    @SuppressWarnings("deprecation")
    public static void startFlow(long guid, String ip, int port, ProObjectRequest requestInfo, ProObjectSession session, String flowName) {
        FlowControlEvent    control = new FlowControlEvent();
        Flow                flow    = FlowEngineManager.getManager(requestInfo.getApplication()).startFlow(guid, flowName);
        control.setFlow(flow);
        control.setStatus(Status.CREATED);
        control.setReadyNode(flow.getGraph().getHead());
        
        flow.startFlow(ChannelEventManager.startEvent(control, ip, port, guid, 0, 0, requestInfo, session));
    }
    
    public static void endFlow(UserContext userContext) {
        endFlow(userContext, null);
    }
    
    public static void endFlow(UserContext userContext, Throwable exception) {
        String  application = ProObjectThread.getApplication();
        FlowEngineManager.getManager(application).endFlow(userContext.getGUID());
        
        ChannelWriteEvent writeEvent = new ChannelWriteEvent(userContext.getRequestContext().getResponser().getChannelHandler(), exception);
        ChannelEventManager.postChannelEvent(writeEvent, userContext);
    }
}
