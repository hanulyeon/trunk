//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2018.03.06 시간 12:56:24 PM KST 
//


package com.tmax.flowengine.meta.flow.context;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>flow-variable-type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="flow-variable-type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="string"/&gt;
 *     &lt;enumeration value="boolean"/&gt;
 *     &lt;enumeration value="byte"/&gt;
 *     &lt;enumeration value="int"/&gt;
 *     &lt;enumeration value="short"/&gt;
 *     &lt;enumeration value="long"/&gt;
 *     &lt;enumeration value="float"/&gt;
 *     &lt;enumeration value="byte"/&gt;
 *     &lt;enumeration value="double"/&gt;
 *     &lt;enumeration value="BigInteger"/&gt;
 *     &lt;enumeration value="BigDecimal"/&gt;
 *     &lt;enumeration value="Date"/&gt;
 *     &lt;enumeration value="Timestamp"/&gt;
 *     &lt;enumeration value="Object"/&gt;
 *     &lt;enumeration value="UserDefined"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "flow-variable-type")
@XmlEnum
@Generated(value = "com.sun.tools.xjc.Driver", date = "2018-03-06T12:56:24+09:00", comments = "JAXB RI v2.2.11")
public enum FlowVariableType {

    @XmlEnumValue("string")
    STRING("string"),
    @XmlEnumValue("boolean")
    BOOLEAN("boolean"),
    @XmlEnumValue("byte")
    BYTE("byte"),
    @XmlEnumValue("int")
    INT("int"),
    @XmlEnumValue("short")
    SHORT("short"),
    @XmlEnumValue("long")
    LONG("long"),
    @XmlEnumValue("float")
    FLOAT("float"),
    @XmlEnumValue("double")
    DOUBLE("double"),
    @XmlEnumValue("BigInteger")
    BIG_INTEGER("BigInteger"),
    @XmlEnumValue("BigDecimal")
    BIG_DECIMAL("BigDecimal"),
    @XmlEnumValue("Date")
    DATE("Date"),
    @XmlEnumValue("Timestamp")
    TIMESTAMP("Timestamp"),
    @XmlEnumValue("Object")
    OBJECT("Object"),
    @XmlEnumValue("UserDefined")
    USER_DEFINED("UserDefined");
    private final String value;

    FlowVariableType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FlowVariableType fromValue(String v) {
        for (FlowVariableType c: FlowVariableType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
