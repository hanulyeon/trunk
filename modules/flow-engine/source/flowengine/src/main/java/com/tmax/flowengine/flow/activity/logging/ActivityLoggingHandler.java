package com.tmax.flowengine.flow.activity.logging;

import com.tmax.flowengine.flow.Flow;
import com.tmax.flowengine.flow.activity.FlowActivityHandler;
import com.tmax.flowengine.flow.graph.FlowNode;
import com.tmax.flowengine.meta.flowgraph.activity.ActivityLogging;
import com.tmax.proobject.logger.application.EventLogger;
import com.tmax.proobject.model.event.UserContext;

public class ActivityLoggingHandler extends FlowActivityHandler {
    @Override
    public boolean onActivity(FlowNode node, Flow flow, UserContext userContext) throws Throwable {
        ActivityLogging activity = (ActivityLogging)node.getMeta().getActivity();
        EventLogger.getLogger().info(activity.getLog());
        
        return true;
    }
}
