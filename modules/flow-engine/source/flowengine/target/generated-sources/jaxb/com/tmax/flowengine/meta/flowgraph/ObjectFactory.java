//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2018.03.06 시간 12:56:24 PM KST 
//


package com.tmax.flowengine.meta.flowgraph;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tmax.flowengine.meta.flowgraph package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tmax.flowengine.meta.flowgraph
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FlowGraphMeta }
     * 
     */
    public FlowGraphMeta createFlowGraphMeta() {
        return new FlowGraphMeta();
    }

    /**
     * Create an instance of {@link FlowNodeMetaContainer }
     * 
     */
    public FlowNodeMetaContainer createFlowNodeMetaContainer() {
        return new FlowNodeMetaContainer();
    }

    /**
     * Create an instance of {@link FlowNodeMeta }
     * 
     */
    public FlowNodeMeta createFlowNodeMeta() {
        return new FlowNodeMeta();
    }

    /**
     * Create an instance of {@link BlockMeta }
     * 
     */
    public BlockMeta createBlockMeta() {
        return new BlockMeta();
    }

    /**
     * Create an instance of {@link FlowEdgeMetaContainer }
     * 
     */
    public FlowEdgeMetaContainer createFlowEdgeMetaContainer() {
        return new FlowEdgeMetaContainer();
    }

    /**
     * Create an instance of {@link FlowEdgeMeta }
     * 
     */
    public FlowEdgeMeta createFlowEdgeMeta() {
        return new FlowEdgeMeta();
    }

    /**
     * Create an instance of {@link ActivityMeta }
     * 
     */
    public ActivityMeta createActivityMeta() {
        return new ActivityMeta();
    }

    /**
     * Create an instance of {@link ContextParameter }
     * 
     */
    public ContextParameter createContextParameter() {
        return new ContextParameter();
    }

    /**
     * Create an instance of {@link ContextField }
     * 
     */
    public ContextField createContextField() {
        return new ContextField();
    }

    /**
     * Create an instance of {@link Conditions }
     * 
     */
    public Conditions createConditions() {
        return new Conditions();
    }

    /**
     * Create an instance of {@link Condition }
     * 
     */
    public Condition createCondition() {
        return new Condition();
    }

}
