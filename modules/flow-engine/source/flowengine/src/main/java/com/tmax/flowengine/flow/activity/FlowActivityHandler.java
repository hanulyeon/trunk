package com.tmax.flowengine.flow.activity;

import com.tmax.flowengine.flow.Flow;
import com.tmax.flowengine.flow.control.FlowControlEvent;
import com.tmax.flowengine.flow.graph.FlowNode;
import com.tmax.proobject.model.event.Event;
import com.tmax.proobject.model.event.UserContext;

public abstract class FlowActivityHandler {
    private FlowNode            currentNode;
    private Flow                currentFlow;
    private FlowControlEvent    currentEvent;
    private UserContext         currentUserContext;
    
    
    public abstract boolean onActivity(FlowNode node, Flow flow, UserContext userContext) throws Throwable;
    
    
    
    
    private void setCurrentHandlingInfo(FlowNode currentNode, Flow currentFlow, FlowControlEvent currentEvent, UserContext currentUserContext) {
        this.currentNode        = currentNode;
        this.currentFlow        = currentFlow;
        this.currentEvent       = currentEvent;
        this.currentUserContext = currentUserContext;
    }
    
    public boolean handleActivity(FlowNode node, Flow flow, FlowControlEvent event, UserContext userContext) throws Throwable {
        setCurrentHandlingInfo(node, flow, event, userContext);
        try {
            return onActivity(node, flow, userContext);
        } finally {
            setCurrentHandlingInfo(null, null, null, null);
        }
    }
    
    public boolean handleActivityWithResponseEvent(Event responseEvent, FlowNode node, Flow flow, FlowControlEvent event, UserContext userContext) throws Throwable {
        try {
            return onActivityWithResponseEvent(responseEvent, node, flow, userContext);
        } finally {
            setCurrentHandlingInfo(null, null, null, null);
        }
    }

    
    public boolean onActivityWithResponseEvent(Event responseEvent, FlowNode node, Flow flow, UserContext userContext) throws Throwable {
        return true;
    }
    
    public FlowNode getCurrentNode() {
        return currentNode;
    }
    
    public Flow getCurrentFlow() {
        return currentFlow;
    }
    
    public FlowControlEvent getCurrentEvent() {
        return currentEvent;
    }
    
    public UserContext getCurrentUserContext() {
        return currentUserContext;
    }
}
