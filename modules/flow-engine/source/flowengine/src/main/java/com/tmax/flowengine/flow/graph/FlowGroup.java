package com.tmax.flowengine.flow.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlowGroup {

    private int id;
    private int type;
    private Map<Integer, FlowNode>  nodes;
    private Map<Integer, FlowEdge>  edges;
    private List<FlowGroup> toGroups;
    
    
    public FlowGroup(int id, int type, Map<Integer, FlowNode> nodes,
            Map<Integer, FlowEdge> edges) {
        super();
        this.id = id;
        this.type = type;
        this.nodes = nodes;
        this.edges = edges;
        toGroups = new ArrayList<FlowGroup>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Map<Integer, FlowNode> getNodes() {
        return nodes;
    }

    public void setNodes(Map<Integer, FlowNode> nodes) {
        this.nodes = nodes;
    }

    public Map<Integer, FlowEdge> getEdges() {
        return edges;
    }

    public void setEdges(Map<Integer, FlowEdge> edges) {
        this.edges = edges;
    }

    public List<FlowGroup> getToGroups() {
        return toGroups;
    }

    public void setToGroups(List<FlowGroup> toGroups) {
        this.toGroups = toGroups;
    }
    
}
