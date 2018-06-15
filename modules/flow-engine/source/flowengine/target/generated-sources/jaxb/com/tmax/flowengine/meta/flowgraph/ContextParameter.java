//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2018.03.06 시간 12:56:24 PM KST 
//


package com.tmax.flowengine.meta.flowgraph;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>context-parameter complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="context-parameter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="field" type="{http://www.tmax.co.kr/flowengine/flowgraph}context-field" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="dto" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "context-parameter", propOrder = {
    "field"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
public class ContextParameter {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected List<ContextField> field;
    @XmlAttribute(name = "dto")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    protected String dto;

    /**
     * Gets the value of the field property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the field property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContextField }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public List<ContextField> getField() {
        if (field == null) {
            field = new ArrayList<ContextField>();
        }
        return this.field;
    }

    /**
     * dto 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public String getDto() {
        return dto;
    }

    /**
     * dto 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
    public void setDto(String value) {
        this.dto = value;
    }

}
