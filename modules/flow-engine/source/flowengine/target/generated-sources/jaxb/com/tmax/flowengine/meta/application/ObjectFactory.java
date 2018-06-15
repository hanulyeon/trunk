//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2018.03.06 시간 12:56:24 PM KST 
//


package com.tmax.flowengine.meta.application;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tmax.flowengine.meta.application package. 
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

    private final static QName _FlowApplication_QNAME = new QName("http://www.tmax.co.kr/flowengine/application", "flow-application");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tmax.flowengine.meta.application
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FlowApplicationMeta }
     * 
     */
    public FlowApplicationMeta createFlowApplicationMeta() {
        return new FlowApplicationMeta();
    }

    /**
     * Create an instance of {@link RegisteredFlows }
     * 
     */
    public RegisteredFlows createRegisteredFlows() {
        return new RegisteredFlows();
    }

    /**
     * Create an instance of {@link RegisteredFlowInfo }
     * 
     */
    public RegisteredFlowInfo createRegisteredFlowInfo() {
        return new RegisteredFlowInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FlowApplicationMeta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tmax.co.kr/flowengine/application", name = "flow-application")
    public JAXBElement<FlowApplicationMeta> createFlowApplication(FlowApplicationMeta value) {
        return new JAXBElement<FlowApplicationMeta>(_FlowApplication_QNAME, FlowApplicationMeta.class, null, value);
    }

}
