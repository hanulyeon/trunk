package com.tmax.flowengine.flow.activity;

import java.util.HashMap;
import java.util.Map;

import com.tmax.flowengine.flow.Flow;
import com.tmax.flowengine.flow.activity.block.ActivityBlockHandler;
import com.tmax.flowengine.flow.activity.logging.ActivityLoggingHandler;
import com.tmax.flowengine.flow.activity.outbound.ActivityOutboundHandler;
import com.tmax.flowengine.flow.control.FlowControlEvent;
import com.tmax.flowengine.flow.graph.FlowNode;
import com.tmax.proobject.model.event.Event;
import com.tmax.proobject.model.event.UserContext;

public class FlowActivityExecutor {
    public static Map<Integer, FlowActivityHandler> handlers    = new HashMap<>();
    
    
    public static void boot() throws Throwable {
        handlers.put(ActivityType.OUTBOUND.toInt(),     new ActivityOutboundHandler());
        handlers.put(ActivityType.LOGGING.toInt(),      new ActivityLoggingHandler());
        handlers.put(ActivityType.BLOCK.toInt(),      new ActivityLoggingHandler());
    }
    
    public static boolean executeFlow(Flow flow, FlowNode node, FlowControlEvent event, Event responseEvent, UserContext userContext) throws Throwable {
        FlowActivityHandler handler = handlers.get(node.getMeta().getActivity().getType());
        
        if(responseEvent == null) {
            return handler.handleActivity(node, flow, event, userContext);
        } else {
            return handler.handleActivityWithResponseEvent(responseEvent, node, flow, event, userContext);
        }
    }
}
