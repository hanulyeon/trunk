package com.tmax.flowengine.flow.control;

import com.tmax.flowengine.flow.Flow;
import com.tmax.flowengine.flow.graph.FlowNode;
import com.tmax.proobject.model.event.Event;

public class FlowControlEvent extends Event {
    public enum Status {
        CREATED,
        NODE_READY,
    }
    
    public static final int EVENT_ID   =   256;
    
    
    
    
    
    private Status      status      = Status.CREATED;
    private Flow        flow;
    private FlowNode    readyNode;
    
    
    @Override
    public int getType() {
        return EVENT_ID;
    }
    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public FlowNode getReadyNode() {
        return readyNode;
    }

    public void setReadyNode(FlowNode readyNode) {
        this.readyNode = readyNode;
    }
    
    public Flow getFlow() {
        return flow;
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }
}
