//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.26 at 04:02:37 PM MSK 
//


package org.dmwm.universal.core.data.xsds;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExtensionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExtensionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GZ"/>
 *     &lt;enumeration value="ZIP"/>
 *     &lt;enumeration value="PLAIN"/>
 *     &lt;enumeration value="RAR"/>
 *     &lt;enumeration value="PNG"/>
 *     &lt;enumeration value="JPEG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExtensionType")
@XmlEnum
public enum ExtensionType {

    GZ,
    ZIP,
    PLAIN,
    RAR,
    PNG,
    JPEG;

    public String value() {
        return name();
    }

    public static ExtensionType fromValue(String v) {
        return valueOf(v);
    }

}
