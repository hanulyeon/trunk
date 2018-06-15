//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2018.03.06 시간 12:56:24 PM KST 
//


package com.tmax.flowengine.meta.flowgraph.activity;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>outbound-adapter-info complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="outbound-adapter-info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="type" type="{http://www.tmax.co.kr/flowengine/flowgraph/activity}adapter-type"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outbound-adapter-info", propOrder = {
    "type",
    "name",
    "ip",
    "port"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
public class OutboundAdapterInfo {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected AdapterType type;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected String name;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected String ip;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected int port;

    /**
     * type 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AdapterType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public AdapterType getType() {
        return type;
    }

    /**
     * type 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AdapterType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setType(AdapterType value) {
        this.type = value;
    }

    /**
     * name 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public String getName() {
        return name;
    }

    /**
     * name 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setName(String value) {
        this.name = value;
    }

    /**
     * ip 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public String getIp() {
        return ip;
    }

    /**
     * ip 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setIp(String value) {
        this.ip = value;
    }

    /**
     * port 속성의 값을 가져옵니다.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public int getPort() {
        return port;
    }

    /**
     * port 속성의 값을 설정합니다.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setPort(int value) {
        this.port = value;
    }

}
