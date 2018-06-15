//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2018.03.06 시간 12:56:24 PM KST 
//


package com.tmax.flowengine.meta.flowgraph;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>flow-graph-meta complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="flow-graph-meta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nodes" type="{http://www.tmax.co.kr/flowengine/flowgraph}flow-node-meta-container" minOccurs="0"/&gt;
 *         &lt;element name="edges" type="{http://www.tmax.co.kr/flowengine/flowgraph}flow-edge-meta-container" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flow-graph-meta", propOrder = {
    "name",
    "nodes",
    "edges"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
public class FlowGraphMeta {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected String name;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected FlowNodeMetaContainer nodes;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected FlowEdgeMetaContainer edges;
    @XmlAttribute(name = "id")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected Integer id;

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
     * nodes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FlowNodeMetaContainer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public FlowNodeMetaContainer getNodes() {
        return nodes;
    }

    /**
     * nodes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FlowNodeMetaContainer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setNodes(FlowNodeMetaContainer value) {
        this.nodes = value;
    }

    /**
     * edges 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FlowEdgeMetaContainer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public FlowEdgeMetaContainer getEdges() {
        return edges;
    }

    /**
     * edges 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FlowEdgeMetaContainer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setEdges(FlowEdgeMetaContainer value) {
        this.edges = value;
    }

    /**
     * id 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public Integer getId() {
        return id;
    }

    /**
     * id 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setId(Integer value) {
        this.id = value;
    }

}
