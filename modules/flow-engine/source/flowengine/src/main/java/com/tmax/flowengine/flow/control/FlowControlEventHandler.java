package com.tmax.flowengine.flow.control;

import com.tmax.flowengine.flow.Flow;
import com.tmax.flowengine.flow.activity.FlowActivityExecutor;
import com.tmax.flowengine.flow.graph.FlowNode;
import com.tmax.flowengine.manager.FlowManager;
import com.tmax.proobject.logger.application.EventLogger;
import com.tmax.proobject.model.event.Event;
import com.tmax.proobject.model.event.EventHandler;
import com.tmax.proobject.model.event.UserContext;

public class FlowControlEventHandler extends EventHandler {
    public FlowControlEventHandler(int eventType) {
        super(eventType);
    }
    
    @Override
    public void onEvent(Event event, UserContext userContext) throws Throwable {
        FlowControlEvent    flowEvent   = (FlowControlEvent)event;
        Flow                flow        = flowEvent.getFlow();
        
        switch(flowEvent.getStatus()) {
            case CREATED :
            {
                flow.getStatus().readyFlowNode(flowEvent.getReadyNode());
                flow.getStatus().finishFlowNode();
                processFlow(flowEvent, null, userContext);
                break;
            }
            case NODE_READY :
            {
                flow.getStatus().readyFlowNode(flowEvent.getReadyNode());
                processFlow(flowEvent, null, userContext);
               // FlowManager.endFlow(userContext);
                break;
            }
            default :
                break;
        }
    }
    
    @Override
    public boolean onResponseEvent(Event event, Event responseEvent, UserContext userContext) throws Throwable {
        FlowControlEvent flowEvent = (FlowControlEvent)event;
        processFlow(flowEvent, responseEvent, userContext);
        
        return false;
    }
    
    public void processFlow(FlowControlEvent flowEvent, Event responseEvent, UserContext userContext) throws Throwable {
        Flow        flow        = flowEvent.getFlow();
        FlowNode    currentNode = flow.getStatus().getCurrentFlows();
        
        if(currentNode == null) {
            flow.getStatus().finishFlowNode();
            currentNode = flow.getStatus().getCurrentFlows();
        }

        /* TODO : 위의 currentNode를 Nodes로 바꾸고 여러 노드를 수행할 수 있음을 인지한 후
         * 여기서 한번 activated 노드 중 어떤 노드의 acti를 수행할 지 거르면 될거같은데? 
         * execute 완료 후에도 바로 finish 하는게 아니고 Node 상태를 변경할 수 있도록 즉 endflow 말고
         * 예를 들면 processing flow 같은걸 만들어서 status 유지(activated)
         * */

        try {
            boolean flowNodeCompleted = FlowActivityExecutor.executeFlow(flow, currentNode, flowEvent, responseEvent,userContext);
            if (flowNodeCompleted) {
                if (currentNode.next(flow) == false) {
                    FlowManager.endFlow(userContext);
                }
                else {
                    flow.getStatus().finishFlowNode();
                }
            }
        }
        catch (Throwable e) {
            EventLogger.getLogger().severe("ExecutingActivity is failed", e);
            FlowManager.endFlow(userContext, e);
        }
    }
}
