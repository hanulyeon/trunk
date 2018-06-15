package com.tmax.flowengine.flow.activity.block;

import com.tmax.flowengine.flow.Flow;
import com.tmax.flowengine.flow.activity.FlowActivityHandler;
import com.tmax.flowengine.flow.control.FlowControlEvent;
import com.tmax.flowengine.flow.control.FlowControlEvent.Status;
import com.tmax.flowengine.flow.graph.FlowNode;
import com.tmax.flowengine.manager.FlowEngineManager;
import com.tmax.flowengine.manager.FlowManager;
import com.tmax.flowengine.meta.flowgraph.ActivityMeta;
import com.tmax.flowengine.meta.flowgraph.activity.ActivityBlock;
import com.tmax.proobject.engine.event.channel.ChannelEventManager;
import com.tmax.proobject.engine.servicemanager.ServiceManager;
import com.tmax.proobject.model.event.UserContext;
import com.tmax.proobject.model.network.ProObjectRequest;
import com.tmax.proobject.model.session.ProObjectSession;
import com.tmax.proobject.util.StringUtil;

public class ActivityBlockHandler extends FlowActivityHandler {
    private Flow            innerFlow;
    private ActivityMeta    innerActivity;
    private int             concurrencyCount;
    
    
    @Override
    public boolean onActivity(FlowNode node, Flow flow, UserContext userContext) throws Throwable {
        ActivityBlock activity = (ActivityBlock)node.getMeta().getActivity();
        
        if(StringUtil.isNotEmpty(activity.getFlowName())) {
            innerFlow = FlowEngineManager.getManager(flow.getApplication()).getFlow(activity.getFlowName());
        } else if(activity.getActivity() != null) {
            innerActivity   = activity.getActivity();
        } else {
            //throw new RuntimeException("NO DATA IN BLOCK!");
        }
        // * 내부 Flow 를 여기서 여러 개 동시에 돌리거나, Activity 를 동시에 돌리고 컨트롤 하는 동작을 처리해주세요 ('-') 화이팅...
        
        

        String ip = userContext.getRequestContext().getRequester().getIPAddress();
        int port = userContext.getRequestContext().getRequester().getPort();
        ProObjectRequest requestInfo = userContext.getRequestContext().getRequest();
        ProObjectSession session = userContext.getRequestContext().getSession();
        
        FlowManager.startFlow(ip, port, requestInfo, session , "b1");
        
        return true;
    }
}
