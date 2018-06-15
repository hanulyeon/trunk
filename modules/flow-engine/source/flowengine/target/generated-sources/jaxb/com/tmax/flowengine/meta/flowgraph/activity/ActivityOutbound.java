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
import javax.xml.bind.annotation.XmlType;
import com.tmax.flowengine.meta.flowgraph.ActivityMeta;


/**
 * <p>activity-outbound complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="activity-outbound"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.tmax.co.kr/flowengine/flowgraph}activity-meta"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sync" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="adapter" type="{http://www.tmax.co.kr/flowengine/flowgraph/activity}outbound-adapter-info" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activity-outbound", propOrder = {
    "sync",
    "adapter"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
public class ActivityOutbound
    extends ActivityMeta
{

    @XmlElement(defaultValue = "true")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected boolean sync;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected OutboundAdapterInfo adapter;

    /**
     * sync 속성의 값을 가져옵니다.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public boolean isSync() {
        return sync;
    }

    /**
     * sync 속성의 값을 설정합니다.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setSync(boolean value) {
        this.sync = value;
    }

    /**
     * adapter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link OutboundAdapterInfo }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public OutboundAdapterInfo getAdapter() {
        return adapter;
    }

    /**
     * adapter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link OutboundAdapterInfo }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setAdapter(OutboundAdapterInfo value) {
        this.adapter = value;
    }

}
