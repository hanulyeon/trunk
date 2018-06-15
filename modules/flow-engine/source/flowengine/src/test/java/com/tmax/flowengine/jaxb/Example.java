package com.tmax.flowengine.jaxb;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.tmax.flowengine.meta.application.FlowApplicationMeta;
import com.tmax.flowengine.meta.application.RegisteredFlowInfo;
import com.tmax.flowengine.meta.application.RegisteredFlows;
import com.tmax.flowengine.meta.flow.FlowMeta;
import com.tmax.flowengine.meta.flow.ObjectFactory;
import com.tmax.flowengine.meta.flow.context.FlowContextMeta;
import com.tmax.flowengine.meta.flow.context.FlowVariable;
import com.tmax.flowengine.meta.flow.context.FlowVariableContainer;
import com.tmax.flowengine.meta.flow.context.FlowVariableType;
import com.tmax.flowengine.meta.flowgraph.Conditions;
import com.tmax.flowengine.meta.flowgraph.FlowEdgeMeta;
import com.tmax.flowengine.meta.flowgraph.FlowEdgeMetaContainer;
import com.tmax.flowengine.meta.flowgraph.FlowGraphMeta;
import com.tmax.flowengine.meta.flowgraph.FlowNodeMeta;
import com.tmax.flowengine.meta.flowgraph.FlowNodeMetaContainer;
import com.tmax.flowengine.meta.flowgraph.activity.ActivityOutbound;
import com.tmax.flowengine.meta.flowgraph.condition.ConditionTimeout;
import com.tmax.proobject.engine.waitobject.WaitObject;

public class Example {
    public static void main(String args[]) throws Throwable {
        testFlowApplication();
        testFlowMeta();
    }
    
    public static void testFlowApplication() throws Throwable {
        try {
            JAXBContext         context     = JAXBContext.newInstance(FlowApplicationMeta.class);
            
            FlowApplicationMeta meta        = new FlowApplicationMeta();
            meta.setName("test");
            
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
                            innerField.setType(FlowVariableType.INT);
                            innerField.setDefault("100");
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
//                ChannelMeta         channel     = new ChannelMeta();
//                channel.setChannelHandler("ABCD");
//                channel.setIp("localhost");
//                channel.setPort(100);
                
                activity.setType(10);
                activity.setSync(true);
//                acvitity.setChannel(channel);
                
                node.setId(1);
                node.setActivity(activity);
                {
                    FlowEdgeMeta        edge    = new FlowEdgeMeta();
                    Conditions          conds   = new Conditions();
                    ConditionTimeout    cond    = new ConditionTimeout();
                    cond.setTimeout(1000);
                    cond.setType(10);
                    conds.getCondition().add(cond);
                    
                    edge.setNextNode(2);
                    edge.setId(1);
                    edge.setConditions(conds);
                    
                    node.getTo().add(edge.getId());
                    
                    edges.getEdge().add(edge);
                }
                nodes.getNode().add(node);
            }
            {
                FlowNodeMeta        node        = new FlowNodeMeta();
                ActivityOutbound    activity    = new ActivityOutbound();
                activity.setType(10);
                
                node.setId(2);
                node.setActivity(activity);
                node.getFrom().add(1);
                
                nodes.getNode().add(node);
            }
            flow.setGraph(graph);
            
            StringWriter        out         = new StringWriter();
            Marshaller          marshaller  = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,    Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING,            "UTF-8");
            marshaller.marshal((new ObjectFactory()).createFlow(flow), out);
            System.out.println(out.toString());
            
            Unmarshaller            unmarshaller    = context.createUnmarshaller();
            JAXBElement<FlowMeta>   root            = unmarshaller.unmarshal(new StreamSource(new StringReader(out.toString())), FlowMeta.class);
            FlowMeta                meta            = root.getValue();
//            Flow                    flowInst        = new Flow(meta);
//            System.out.println(meta);
            
            WaitObject or = WaitObject.Or(new WaitObject[]{});
            or.get();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
