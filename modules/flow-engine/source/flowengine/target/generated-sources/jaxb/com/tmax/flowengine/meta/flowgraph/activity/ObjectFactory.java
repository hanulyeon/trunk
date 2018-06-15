//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2018.03.06 시간 12:56:24 PM KST 
//


package com.tmax.flowengine.meta.flowgraph.activity;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tmax.flowengine.meta.flowgraph.activity package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tmax.flowengine.meta.flowgraph.activity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OutboundAdapterInfo }
     * 
     */
    public OutboundAdapterInfo createOutboundAdapterInfo() {
        return new OutboundAdapterInfo();
    }

    /**
     * Create an instance of {@link ActivityOutbound }
     * 
     */
    public ActivityOutbound createActivityOutbound() {
        return new ActivityOutbound();
    }

    /**
     * Create an instance of {@link ActivityLogging }
     * 
     */
    public ActivityLogging createActivityLogging() {
        return new ActivityLogging();
    }

    /**
     * Create an instance of {@link ActivityBlock }
     * 
     */
    public ActivityBlock createActivityBlock() {
        return new ActivityBlock();
    }

    /**
     * Create an instance of {@link ActivityWait }
     * 
     */
    public ActivityWait createActivityWait() {
        return new ActivityWait();
    }

}
