//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.23 at 06:11:54 PM MSK 
//


package org.dmwm.universal.core.data.xsds;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RqUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RqTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="MemeInfo" type="{http://www.example.org/dataTypes}MemeInfoType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = {
    "rqUID",
    "rqTime",
    "memeInfo"
})
public class Response {

    @XmlElement(name = "RqUID", required = true)
    protected String rqUID;
    @XmlElement(name = "RqTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rqTime;
    @XmlElement(name = "MemeInfo", required = true)
    protected MemeInfoType memeInfo;

    /**
     * Gets the value of the rqUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRqUID() {
        return rqUID;
    }

    /**
     * Sets the value of the rqUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRqUID(String value) {
        this.rqUID = value;
    }

    /**
     * Gets the value of the rqTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRqTime() {
        return rqTime;
    }

    /**
     * Sets the value of the rqTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRqTime(XMLGregorianCalendar value) {
        this.rqTime = value;
    }

    /**
     * Gets the value of the memeInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MemeInfoType }
     *     
     */
    public MemeInfoType getMemeInfo() {
        return memeInfo;
    }

    /**
     * Sets the value of the memeInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MemeInfoType }
     *     
     */
    public void setMemeInfo(MemeInfoType value) {
        this.memeInfo = value;
    }

}
