package com.tmax.flowengine.channel.http;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;

import com.tmax.flowengine.flow.graph.FlowGraph;
import com.tmax.flowengine.manager.FlowEngineManager;
import com.tmax.flowengine.manager.FlowManager;
import com.tmax.flowengine.meta.application.FlowApplicationMeta;
import com.tmax.flowengine.meta.application.RegisteredFlowInfo;
import com.tmax.flowengine.meta.application.RegisteredFlows;
import com.tmax.flowengine.meta.flow.FlowMeta;
import com.tmax.proobject.core.config.ProObjectPath;
import com.tmax.proobject.engine.ProObjectBootLoader;
import com.tmax.proobject.engine.event.channel.ChannelEventManager;
import com.tmax.proobject.engine.event.channel.eventhandler.httpservlet.HttpServletEventHandler;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.ChannelEventLogger;
import com.tmax.proobject.model.event.UserContext;
import com.tmax.proobject.model.network.ProObjectRequest;
import com.tmax.proobject.model.session.ProObjectSession;
import com.tmax.proobject.util.concurrency.ProObjectThread;

public class FlowHttpChannelHandler extends HttpServletEventHandler {
    private ProObjectLogger  logger;
    
    
    public FlowHttpChannelHandler(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        super(request, response);
        logger = ChannelEventLogger.getLogger();
    }
    
    // * 요청받은 Servlet 을 받아들여 Service Recognition 으로 넘어간다.
    @Override
    public void handleHttpServletRequest() {
        try {
            ProObjectRequest    requestInfo = parseHttpRequestMessage();
            ProObjectSession    session     = ProObjectSession.getSession(getServletRequest().getSession().getId());
            
            
            // * TODO : 상수로 박혀있으나, Application 정보 확인 및 Flow 확인이 가능하도록 별도 처리가 필요합니다.
            //          Application 을 당장 확인할 수 없는 경우, 일단 Flow Application 으로 던지신 이후, Recognize Event 를 처리할 수 있도록 진행하여야 합니다.
            //          (Rule 해석이 필요함)
            //          Application 을 도중에 갈이끼우시려면 userContext.getRequestContext().getRequest().setApplication(APP_NAME) API 를 이용하시면 됩니다.
            
            String flowName = requestInfo.getUri().substring(1);
            //String applicationName = requestInfo.getApplication();
            //jaxb로 unmashell 해서 쓰려면 ProObjectBootLoader.getSystemClassLoader() 클래스 로더로 넣어주면 될듯
            String applicationName = "";
            try{
                flowName = requestInfo.getUri().substring(1);
                applicationName = "test";
                File flowMetaHome = new File(ProObjectPath.getApplicationPath(applicationName), "flow");
                File flowMetaFile = new File(flowMetaHome, flowName + ".xml");
                FlowMeta flowMeta = ((JAXBElement<FlowMeta>) ProObjectBootLoader.loadConfiguration(flowMetaFile, FlowMeta.class.getPackage().getName(), ProObjectBootLoader.getSystemClassLoader())).getValue();
                FlowGraph flowGraph = new FlowGraph(flowMeta.getGraph());
                
                FlowGraph groupedGraph = flowGraph.groupingFlow();
                
                flowName = groupedGraph.getMeta().getName();
                flowMeta.setGraph(groupedGraph.getMeta());
                flowMeta.setId(groupedGraph.getMeta().getId());
                flowMeta.setName(groupedGraph.getMeta().getName());
                
                FlowEngineManager.getManager(applicationName).putFlow(flowName, groupedGraph, flowMeta);
            }
            catch(Throwable e){
                System.out.println("test fail");
            }
            
            requestInfo.setApplication(applicationName);
            FlowManager.startFlow(getClientIp(), getClientPort(), requestInfo, session, flowName);
        } catch (Throwable e) {
            logger.severe("Exception is occured while handling request!", e);
            // * 바로 데이터를 써버린다.
            onWrite(null, e, null, -1);
        }
    }
}
