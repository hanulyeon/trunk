package com.tmax.flowengine.flow.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.tmax.flowengine.flow.Flow;
import com.tmax.flowengine.meta.flowgraph.FlowEdgeMeta;
import com.tmax.flowengine.meta.flowgraph.FlowEdgeMetaContainer;
import com.tmax.flowengine.meta.flowgraph.FlowGraphMeta;
import com.tmax.flowengine.meta.flowgraph.FlowNodeMeta;
import com.tmax.flowengine.meta.flowgraph.FlowNodeMetaContainer;
import com.tmax.flowengine.meta.flowgraph.activity.ActivityBlock;
import com.tmax.flowengine.meta.flowgraph.activity.ActivityLogging;
import com.tmax.proobject.model.event.UserContext;

public class FlowGraph implements Cloneable {
    private FlowGraphMeta           meta;
    private FlowNode                head;
    private Map<Integer, FlowNode>  nodes;
    private Map<Integer, FlowEdge>  edges;
    private Map<Integer, FlowGroup> groups; //map(groupid,flowgroup)
    
    
    public FlowGraph(FlowGraphMeta meta) {
        this.meta   = meta;
        
        nodes = new HashMap<>();
        if(meta.getNodes() != null) {
            for(FlowNodeMeta nodeMeta : meta.getNodes().getNode()) {
                nodes.put(nodeMeta.getId(), new FlowNode(nodeMeta));
            }
        }

        edges = new HashMap<>();
        if(meta.getEdges() != null) {
            for(FlowEdgeMeta edgeMeta : meta.getEdges().getEdge()) {
                edges.put(edgeMeta.getId(), new FlowEdge(edgeMeta));
            }
        }
        
        // * Node 에서 Edge 를 연결한다.
        for(FlowNode node : nodes.values()) {
            for(Integer edgeId : node.getFromEdgeIds()) {
                FlowEdge edge = edges.get(edgeId);
                node.addFromEdge(edge);
            }
            
            for(Integer edgeId : node.getToEdgeIds()) {
                FlowEdge edge = edges.get(edgeId);
                node.addToEdge(edge);
            }
            
            node.initWaitObject();
        }
        
        // * Edge 에서 Node 를 연결한다.
        for(FlowEdge edge : edges.values()) {
            edge.setNextNode(nodes.get(edge.getNextNodeId()));
        }
        head    = nodes.get(0);
    }
    
    public FlowGraph groupingFlow(){
        Queue<FlowNode> nodeQueue = new LinkedList<FlowNode>();
        List<Integer> traveledNode = new ArrayList<Integer>();
        nodeQueue.add(head);
        groups = new HashMap<>();

        Map<Integer, Integer> groupById = new HashMap<Integer, Integer>();//map<nodeid,groupid>
        int groupSeq = -1;

        while(nodeQueue.isEmpty() == false){
            FlowNode curNode = nodeQueue.poll();
            FlowNodeMeta curMeta = curNode.getMeta();
            int curType = curMeta.getActivity().getType();
            int curId = curMeta.getId();
            
            if (traveledNode.contains(curId) == false) {
                traveledNode.add(curId);
                //FIXME : groupID finding
                Integer fromEdgeId = null;
                if(curNode.getFromEdgeIds().size() > 0){
                    fromEdgeId = curNode.getFromEdgeIds().get(0);
                }
                if(fromEdgeId == null){
                    //첫 노드라는 뜻(시작점)
                    groupSeq++; //group number increase
                    Map<Integer,FlowNode> otherNodes = new HashMap<Integer, FlowNode>();    //e다른그룹
                    otherNodes.put(curId, curNode);
                    
                    FlowGroup otherGroup = new FlowGroup(groupSeq,curType,otherNodes,edges);
                    groupById.put(curId, groupSeq);
                    groups.put(groupSeq, otherGroup);
                }
                else{
                    //fromEdgeId로 부터 전 노드의 ID를 구하는 부분 필요
                    //nodes중에 fromEdginId를 To로 가지고 있는 녀석의 Id
                    int beforeId = -1;
                    for(FlowNode node : nodes.values()){
                        if(node.getToEdgeIds().size()>0){
                            for(int toEdgeid : node.getToEdgeIds()){
                                if(toEdgeid == fromEdgeId){
                                    beforeId = node.getNodeId();
                                    break;
                                }
                            }
                        }
                    }
                     //= nodes.get(fromEdgeId).getMeta().getId();
                    int beforeType = nodes.get(beforeId).getMeta().getActivity().getType();
                    if(curType==beforeType){ //same group
                        int curGroupId = groupById.get(new Integer(beforeId));
                        groupById.put(curId, curGroupId);
                        //group 찾아서 노드 추가
                        FlowGroup curGroup = groups.get(curGroupId);
                        curGroup.getNodes().put(curId, curNode);
                    }
                    else    //other group
                    {
                        groupSeq++; //group number increase
                        Map<Integer,FlowNode> otherNodes = new HashMap<Integer, FlowNode>();
                        otherNodes.put(curId, curNode);
                        
                        int beforeGroup = groupById.get(beforeId);
                        FlowGroup otherGroup = new FlowGroup(groupSeq,curType,otherNodes,edges);
                        groupById.put(curId, groupSeq);
                        groups.put(groupSeq, otherGroup);
                        groups.get(beforeGroup).getToGroups().add(otherGroup);
                    }
                }
                for(Integer child : curNode.getToEdgeIds()){
                    nodeQueue.add(nodes.get(child));
                }
            }
        }
        //grouping done
        
        //TODO: 여기서 Grouping한 결과로 flow를 변경해보자
        FlowGraphMeta groupedFlowGraphMeta = new FlowGraphMeta();
        FlowEdgeMetaContainer groupedEdgeMetaContainer = new FlowEdgeMetaContainer();
        FlowNodeMetaContainer groupedNodeMetaContainer = new FlowNodeMetaContainer();
        int edgeseq = -1;
        
        //TODO : Group Type에 따라 다른 Acti?? 다 같은 OutBound??
        for(FlowGroup curGroup : groups.values()){
            ActivityLogging groupedActivity = new ActivityLogging(); 
            FlowNodeMeta groupedNodeMeta = new FlowNodeMeta();
            
            StringBuilder logSB = new StringBuilder();
            int curType =  curGroup.getType();
            
            //XXX:grouping nodes to one node
            for(FlowNode curNode : curGroup.getNodes().values()){
                ActivityLogging curActivity = (ActivityLogging) curNode.getMeta().getActivity();
                logSB.append(curActivity.getLog());
            }
            groupedActivity.setType(curType);
            groupedActivity.setLog(logSB.toString());
            
            groupedNodeMeta.setActivity(groupedActivity);
            groupedNodeMeta.setName("group");
            groupedNodeMeta.setId(curGroup.getId());
            
            //XXX:logic 검토
            for(FlowGroup itrGroup : groups.values()){
                for(FlowGroup togroup : itrGroup.getToGroups()){
                    if(togroup.getId() == curGroup.getId()){
                        groupedNodeMeta.getFrom().add(itrGroup.getId());
                    }
                }
            }
            
            for(FlowGroup toGroup : curGroup.getToGroups()){
                FlowEdgeMeta groupedEdgeMeta = new FlowEdgeMeta();
                edgeseq ++;
                groupedEdgeMeta.setId(edgeseq);
                groupedEdgeMeta.setNextNode(toGroup.getId());
                groupedNodeMeta.getTo().add(edgeseq);
                groupedEdgeMetaContainer.getEdge().add(groupedEdgeMeta);
            }
            groupedNodeMetaContainer.getNode().add(groupedNodeMeta);
            
        }
        groupedFlowGraphMeta.setNodes(groupedNodeMetaContainer);
        groupedFlowGraphMeta.setEdges(groupedEdgeMetaContainer);
        return new FlowGraph(groupedFlowGraphMeta);
    }        
    
    @Override
    public FlowGraph clone() {
        FlowGraph graph = new FlowGraph(meta);
        return graph;
    }

    public void initEventInfo(Flow flow, UserContext userContext) {
        for(FlowNode node : nodes.values()) {
            node.initEventInfo(flow, userContext);
        }
    }
    
    public FlowNode getHead() {
        return head;
    }
    
    public FlowGraphMeta getMeta()  {
        return meta;
    }
}
