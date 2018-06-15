package com.tmax.flowengine.jaxb;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.tmax.flowengine.flow.activity.ActivityType;
import com.tmax.flowengine.meta.application.FlowApplicationMeta;
import com.tmax.flowengine.meta.application.RegisteredFlowInfo;
import com.tmax.flowengine.meta.application.RegisteredFlows;
import com.tmax.flowengine.meta.flow.FlowMeta;
import com.tmax.flowengine.meta.flow.ObjectFactory;
import com.tmax.flowengine.meta.flow.context.FlowContextMeta;
import com.tmax.flowengine.meta.flow.context.FlowVariable;
import com.tmax.flowengine.meta.flow.context.FlowVariableContainer;
import com.tmax.flowengine.meta.flow.context.FlowVariableType;
import com.tmax.flowengine.meta.flowgraph.ContextField;
import com.tmax.flowengine.meta.flowgraph.ContextParameter;
import com.tmax.flowengine.meta.flowgraph.FlowEdgeMeta;
import com.tmax.flowengine.meta.flowgraph.FlowEdgeMetaContainer;
import com.tmax.flowengine.meta.flowgraph.FlowGraphMeta;
import com.tmax.flowengine.meta.flowgraph.FlowNodeMeta;
import com.tmax.flowengine.meta.flowgraph.FlowNodeMetaContainer;
import com.tmax.flowengine.meta.flowgraph.activity.ActivityLogging;
import com.tmax.flowengine.meta.flowgraph.activity.ActivityOutbound;
import com.tmax.flowengine.meta.flowgraph.activity.AdapterType;
import com.tmax.flowengine.meta.flowgraph.activity.OutboundAdapterInfo;
import com.tmax.proobject.engine.system.dto.SystemParameterChangeInfo;

public class TestApplicationAndFlow {
    public static void main(String args[]) throws Throwable {
        testFlowApplication();
        testFlowMeta();
    }
    
    public static void testFlowApplication() throws Throwable {
        try {
            JAXBContext         context     = JAXBContext.newInstance(FlowApplicationMeta.class);
            
            FlowApplicationMeta meta        = new FlowApplicationMeta();
            meta.setName("test");
            meta.setAdapterPort(2222);
            
            RegisteredFlows     flows       = new RegisteredFlows();
            {
                List<RegisteredFlowInfo>    flowInfos   = flows.getFlow();
                {
                    RegisteredFlowInfo          info        = new RegisteredFlowInfo();
                    info.setFlow("test");
                    flowInfos.add(info);
                }
            }
            
            meta.setFlows(flows);
            
            StringWriter        out         = new StringWriter();
            Marshaller          marshaller  = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,    Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING,            "UTF-8");
            marshaller.marshal((new com.tmax.flowengine.meta.application.ObjectFactory()).createFlowApplication(meta), out);
            System.out.println(out.toString());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        
    }
    
    public static void testFlowMeta() throws Throwable {
        try {
            JAXBContext         context     = JAXBContext.newInstance(FlowMeta.class);
            
            FlowMeta                flow    = new FlowMeta();
            FlowContextMeta         ctx     = new FlowContextMeta();
            FlowVariableContainer   var     = new FlowVariableContainer();
            FlowGraphMeta           graph   = new FlowGraphMeta();
            FlowNodeMetaContainer   nodes   = new FlowNodeMetaContainer();
            FlowEdgeMetaContainer   edges   = new FlowEdgeMetaContainer();
            {
                ctx.setVariables(var);
                {
                    FlowVariable field   = new FlowVariable();
                    field.setName("HAHA");
                    field.setType(FlowVariableType.OBJECT);
                    {
                        FlowVariableContainer inner = new FlowVariableContainer();
                        {
                            FlowVariable innerField = new FlowVariable();
                            innerField.setName("HAHA");
                            innerField.setType(FlowVariableType.BOOLEAN);
                            innerField.setDefault("true");
                            inner.getVariable().add(innerField);
                        }
                        field.setVariable(inner);
                    }
                    var.getVariable().add(field);
                }
            }
            flow.setContext(ctx);
            
            graph.setNodes(nodes);
            graph.setEdges(edges);
            {
                FlowNodeMeta        node        = new FlowNodeMeta();
                ActivityOutbound    activity    = new ActivityOutbound();
                activity.setType(ActivityType.OUTBOUND.toInt());
                activity.setSync(true);
                ContextParameter    input       = new ContextParameter();
                ContextField        inputField  = new ContextField();
                inputField.setName("HAHA.HAHA");
                inputField.setDtoField("reload");
                input.setDto(SystemParameterChangeInfo.class.getName());
                input.getField().add(inputField);
                activity.setInput(input);
                ContextParameter    output      = new ContextParameter();
                ContextField        outputField = new ContextField();
                outputField.setName("HAHA.HAHA");
                outputField.setDtoField("reload");
                output.setDto(SystemParameterChangeInfo.class.getName());
                output.getField().add(outputField);
                activity.setOutput(output);
                OutboundAdapterInfo adapter     = new OutboundAdapterInfo();
                adapter.setType(AdapterType.TEST);
                adapter.setName("testAdapter");
                activity.setAdapter(adapter);
                
                node.setId(0);
                node.setActivity(activity);
                {
                    node.getTo().add(0);
                    
                    FlowEdgeMeta edge = new FlowEdgeMeta();
                    edge.setId(0);
                    edge.setNextNode(1);
                    edges.getEdge().add(edge);
                }
                nodes.getNode().add(node);
            }
            {
                FlowNodeMeta        node        = new FlowNodeMeta();
                ActivityLogging     activity    = new ActivityLogging();
                activity.setType(ActivityType.LOGGING.toInt());
                activity.setLog("SUCCESS!");
                
                node.setId(1);
                node.setActivity(activity);
                node.getFrom().add(0);
                
                nodes.getNode().add(node);
            }
            flow.setGraph(graph);
            
            flow.setId(1);
            flow.setName("test");
            
            StringWriter        out         = new StringWriter();
            Marshaller          marshaller  = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,    Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING,            "UTF-8");
            marshaller.marshal((new ObjectFactory()).createFlow(flow), out);
            System.out.println(out.toString());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
