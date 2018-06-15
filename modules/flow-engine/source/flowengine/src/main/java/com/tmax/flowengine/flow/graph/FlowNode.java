package com.tmax.flowengine.flow.graph;

import java.util.ArrayList;
import java.util.List;

import com.tmax.flowengine.flow.Flow;
import com.tmax.flowengine.flow.control.FlowControlEvent;
import com.tmax.flowengine.flow.control.FlowControlEvent.Status;
import com.tmax.flowengine.meta.flowgraph.FlowNodeMeta;
import com.tmax.proobject.engine.waitobject.WaitObject;
import com.tmax.proobject.model.event.UserContext;

public class FlowNode implements Cloneable {
    private FlowNodeMeta    meta;
    private List<FlowEdge>  toEdges;
    private List<FlowEdge>  fromEdges;
    private WaitObject      waitObject;
    
    
    public FlowNode(FlowNodeMeta meta) {
        this.meta   = meta;
        toEdges     = new ArrayList<>();
        fromEdges   = new ArrayList<>();
    }

    public void initWaitObject() {
        if(getMeta().getJoint() != null) {
            WaitObject[] waitObjects = new WaitObject[fromEdges.size()];
            for(int i=0; i<fromEdges.size(); i++) {
                FlowEdge edge   = fromEdges.get(i);
                waitObjects[i]  = edge.getWaitObject();
            }
            
            switch(getMeta().getJoint()) {
                case AND :
                {
                    setWaitObject(WaitObject.And(waitObjects));
                    break;
                }
                case OR :
                {
                    setWaitObject(WaitObject.Or(waitObjects));
                    break;
                }
                case XOR :
                    break;
                default :
                    break;
            }
        } else {
            if(fromEdges.size() == 1) {
                setWaitObject(fromEdges.get(0).getWaitObject());
            }
        }
    }
    
    public void initEventInfo(Flow flow, UserContext userContext) {
        // * Head 인 경우에는 WaitObject 가 없다.
        if(getWaitObject() != null) {
            FlowControlEvent controlEvent = new FlowControlEvent();
            controlEvent.setStatus(Status.NODE_READY);
            controlEvent.setFlow(flow);
            controlEvent.setReadyNode(this);
            
            getWaitObject().setRescheduleEvent(userContext, controlEvent);
        }
    }
    
    public boolean next(Flow flow) {
        if(toEdges.size() == 0) {
            return false;
        }
        
        boolean proceed = false;
        for(FlowEdge edge : toEdges) {
            boolean activated = edge.next(flow);
            
            if(proceed == false) {
                if(activated == true) {
                    proceed = true;
                }
            }
        }
        return proceed;
    }

    public List<Integer> getFromEdgeIds() {
        return meta.getFrom();
    }
    
    public List<Integer> getToEdgeIds() {
        return meta.getTo();
    }

    public void addFromEdge(FlowEdge edge) {
        fromEdges.add(edge);
    }
    
    public void addToEdge(FlowEdge edge) {
        toEdges.add(edge);
    }

    public FlowNodeMeta getMeta() {
        return meta;
    }
    
    public void setFlow(FlowNodeMeta meta) {
        this.meta = meta;
    }
    
    public int getNodeId() {
        return meta.getId();
    }
    
    public void setWaitObject(WaitObject waitObject) {
        this.waitObject = waitObject;
    }
    
    public WaitObject getWaitObject() {
        return waitObject;
    }
}
