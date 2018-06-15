package com.tmax.flowengine.flow.graph;

import com.tmax.flowengine.flow.Flow;
import com.tmax.flowengine.meta.flowgraph.Condition;
import com.tmax.flowengine.meta.flowgraph.FlowEdgeMeta;
import com.tmax.proobject.engine.waitobject.WaitObject;

public class FlowEdge {
    private FlowEdgeMeta    meta;
    private FlowNode        nextNode;
    private WaitObject      waitObject;
    
    
    public FlowEdge(FlowEdgeMeta meta) {
        this.meta   = meta;
        waitObject  = new WaitObject();
        waitObject.setAsyncMode();
    }
    
    public boolean next(Flow flow) {
        boolean conditionSatisfied = true;
        
        if(meta.getConditions() != null) {
            for(Condition condition : meta.getConditions().getCondition()) {
//                if(condition is not satisfied) {
//                    conditionSatisfied = false;
//                }
            }
        }
        
        if(conditionSatisfied) {
            waitObject.set(true);
        }
        
        return conditionSatisfied;
    }

    public int getNextNodeId() {
        return meta.getNextNode();
    }

    public FlowNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(FlowNode nextNode) {
        this.nextNode   = nextNode;
    }
    
    public WaitObject getWaitObject() {
        return waitObject;
    }
}
