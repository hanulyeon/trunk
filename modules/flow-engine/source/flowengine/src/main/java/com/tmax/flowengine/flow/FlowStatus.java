package com.tmax.flowengine.flow;

import java.util.LinkedList;
import java.util.Queue;

import com.tmax.flowengine.flow.graph.FlowNode;

public class FlowStatus {
    private FlowNode        currentNode;
    private Queue<FlowNode> readyNodes;
    
    
    public FlowStatus() {
        readyNodes  = new LinkedList<>();
    }
    
    public void readyFlowNode(FlowNode node) {
        readyNodes.add(node);
    }
    
    public void finishFlowNode() {
        currentNode = readyNodes.poll();
    }

    public FlowNode getCurrentFlows() {
        return currentNode;
    }
    
    public Queue<FlowNode> getReadyFlow() {
        return readyNodes;
    }
}
