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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import com.tmax.flowengine.meta.flowgraph.activity.ActivityBlock;
import com.tmax.flowengine.meta.flowgraph.activity.ActivityLogging;
import com.tmax.flowengine.meta.flowgraph.activity.ActivityOutbound;
import com.tmax.flowengine.meta.flowgraph.activity.ActivityWait;
import com.tmax.flowengine.meta.flowgraph.activity.TestsCls;


/**
 * <p>activity-meta complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="activity-meta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="input" type="{http://www.tmax.co.kr/flowengine/flowgraph}context-parameter" minOccurs="0"/&gt;
 *         &lt;element name="output" type="{http://www.tmax.co.kr/flowengine/flowgraph}context-parameter" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activity-meta", propOrder = {
    "type",
    "input",
    "output"
})
@XmlSeeAlso({
    ActivityOutbound.class,
    ActivityLogging.class,
    ActivityBlock.class,
    ActivityWait.class,
    TestsCls.class
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
public class ActivityMeta {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected int type;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected ContextParameter input;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected ContextParameter output;

    /**
     * type 속성의 값을 가져옵니다.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public int getType() {
        return type;
    }

    /**
     * type 속성의 값을 설정합니다.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setType(int value) {
        this.type = value;
    }

    /**
     * input 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ContextParameter }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public ContextParameter getInput() {
        return input;
    }

    /**
     * input 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextParameter }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setInput(ContextParameter value) {
        this.input = value;
    }

    /**
     * output 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ContextParameter }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public ContextParameter getOutput() {
        return output;
    }

    /**
     * output 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextParameter }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setOutput(ContextParameter value) {
        this.output = value;
    }

}
