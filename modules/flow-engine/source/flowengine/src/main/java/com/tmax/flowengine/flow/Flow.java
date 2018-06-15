package com.tmax.flowengine.flow;

import com.tmax.flowengine.flow.graph.FlowGraph;
import com.tmax.flowengine.meta.flow.FlowMeta;
import com.tmax.proobject.model.event.UserContext;

public class Flow {
    private String      application;
    private FlowMeta    meta;
    private FlowStatus  status;
    private FlowContext context;
    private FlowGraph   graph;
    
    
    public Flow(FlowMeta meta, FlowGraph graph) {
        this.meta   = meta;
        
        status      = new FlowStatus();
        context     = new FlowContext(meta.getContext());
        this.graph  = graph;
    }

    public void startFlow(UserContext userContext) {
        application = userContext.getRequestContext().getRequest().getApplication();
        getGraph().initEventInfo(this, userContext);
    }
    
    public String getApplication() {
        return application;
    }
    
    public FlowMeta getMeta() {
        return meta;
    }
    
    public FlowStatus getStatus() {
        return status;
    }
    
    public FlowContext getContext() {
        return context;
    }
    
    public FlowGraph getGraph() {
        return graph;
    }
}
