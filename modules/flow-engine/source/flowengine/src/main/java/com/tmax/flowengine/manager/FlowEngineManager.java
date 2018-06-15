package com.tmax.flowengine.manager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import com.tmax.flowengine.adapter.AdapterManager;
import com.tmax.flowengine.config.FlowEngineParameter;
import com.tmax.flowengine.flow.Flow;
import com.tmax.flowengine.flow.activity.FlowActivityExecutor;
import com.tmax.flowengine.flow.control.FlowControlEvent;
import com.tmax.flowengine.flow.control.FlowControlEventHandler;
import com.tmax.flowengine.flow.graph.FlowGraph;
import com.tmax.flowengine.meta.application.FlowApplicationMeta;
import com.tmax.flowengine.meta.application.RegisteredFlowInfo;
import com.tmax.flowengine.meta.application.RegisteredFlows;
import com.tmax.flowengine.meta.flow.FlowMeta;
import com.tmax.proobject.core.config.ProObjectPath;
import com.tmax.proobject.engine.ProObjectBootLoader;
import com.tmax.proobject.engine.application.ApplicationManager;
import com.tmax.proobject.engine.event.po.manager.SystemEventManager;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.EventLogger;
import com.tmax.proobject.meta.event.EventMeta;
import com.tmax.proobject.util.concurrency.ProObjectThread;

public class FlowEngineManager extends SystemEventManager {
    private static FlowEngineParameter      parameter;
    private static ProObjectLogger          logger;
    
    
    public static void boot() throws Throwable {
        registerSystemEventHandler(FlowControlEvent.EVENT_ID, new FlowControlEventHandler(FlowControlEvent.EVENT_ID));
        
        logger = EventLogger.getLogger();
        logger.info("====================== FlowEngine Booting ======================");
        logger.info(" version  : {0}", "7");
        logger.info(" License : standard");
        logger.info("===============================================================");
        
        FlowActivityExecutor.boot();

        logger.info(" FlowEngine is ready!");
        logger.info("===============================================================");
    }

    public static FlowEngineParameter getParameter() {
        return parameter;
    }
    
    public static FlowEngineManager getManager() {
        return getManager(ProObjectThread.getApplication());
    }
    
    public static FlowEngineManager getManager(String applicationName) {
        return (FlowEngineManager)SystemEventManager.getInstance(applicationName);
    }
    
    
    
    
    
    private AdapterManager          adapterManager;
    private Map<String,  FlowMeta>  flowMetas;  
    private Map<String,  FlowGraph> graphs;
    private Map<Long,    Flow>      flows;
    
    
    @SuppressWarnings("unchecked")
    public FlowEngineManager(String applicationName, boolean system) {
        super(applicationName, system);
        
        flowMetas       = new HashMap<>();
        graphs          = new HashMap<>();
        flows           = new HashMap<>();
        
        int adapterPort = -1;
        
        if(system == false) {
            File    applicationPath = new File(ProObjectPath.getApplicationConfigPath(applicationName), "flow.xml");
            if(applicationPath == null || applicationPath.exists() == false) {
                throw new RuntimeException("FLOW IS NOT EXIST!");
            }
            
            try {
                FlowApplicationMeta applicationMeta = ((JAXBElement<FlowApplicationMeta>)ProObjectBootLoader.loadConfiguration(applicationPath, FlowApplicationMeta.class.getPackage().getName(), ProObjectThread.getClassLoader())).getValue();
                RegisteredFlows     registeredFlows = applicationMeta.getFlows();
                File                flowMetaHome    = new File(ProObjectPath.getApplicationPath(applicationName), "flow");
                if(registeredFlows != null) {
                    for(RegisteredFlowInfo registeredFlow : registeredFlows.getFlow()) {
                        File        flowMetaFile    = new File(flowMetaHome, registeredFlow.getFlow()+".xml");
                        FlowMeta    flowMeta        =  ((JAXBElement<FlowMeta>)ProObjectBootLoader.loadConfiguration(flowMetaFile, FlowMeta.class.getPackage().getName(), ProObjectThread.getClassLoader())).getValue();
                        flowMetas.put(flowMeta.getName(), flowMeta);
                         
                        FlowGraph   flowGraph   = new FlowGraph(flowMeta.getGraph());
                        graphs.put(flowMeta.getName(), flowGraph);
                    }
                }
                
                if(applicationMeta.getAdapterPort() == null) {
                    throw new RuntimeException("Adapter Listening Port is not Initialized");
                }
                adapterPort = applicationMeta.getAdapterPort().intValue();
            } catch (Exception e) {
                throw new RuntimeException("UNMARSHAL FAILED!", e);
            }
        }
        
        adapterManager  = new AdapterManager(applicationName, adapterPort);
    }
    
    public void init(EventMeta eventMeta, ClassLoader classLoader) throws Exception {
        super.init(eventMeta, classLoader);
    }
    
    @Override
    public int getMaxEnginedManagedEventId() {
        return 511;
    }
    
    public Flow getFlow(String flowName) {
        FlowGraph   graph   = graphs.get(flowName);
        FlowMeta    meta    = flowMetas.get(flowName);
        Flow        flow    = new Flow(meta, graph.clone());
        
        return flow;
    }
    public Flow putFlow(String flowName, FlowGraph graph, FlowMeta meta) {
        graphs.put(flowName, graph);
        flowMetas.put(flowName, meta);
        Flow        flow    = new Flow(meta, graph.clone());
        
        return flow;
    }
    
    public Flow startFlow(long guid, String flowName) {
        Flow flow = getFlow(flowName);
        if(flows.put(guid, flow) == null) {
            return flow;
        }
        
        return null;
    }
    
    public Flow endFlow(long guid) {
        return flows.remove(guid);
    }

    public AdapterManager getAdapterManager() {
        return adapterManager;
    }

    public ClassLoader getClassLoader() {
        return ApplicationManager.getManager(getApplication()).getClassLoader();
    }
}
