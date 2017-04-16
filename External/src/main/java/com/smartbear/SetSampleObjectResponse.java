
package com.smartbear;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SetSampleObjectResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "setSampleObjectResult"
})
@XmlRootElement(name = "SetSampleObjectResponse")
public class SetSampleObjectResponse {

    @XmlElement(name = "SetSampleObjectResult")
    protected String setSampleObjectResult;

    /**
     * Gets the value of the setSampleObjectResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSetSampleObjectResult() {
        return setSampleObjectResult;
    }

    /**
     * Sets the value of the setSampleObjectResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSetSampleObjectResult(String value) {
        this.setSampleObjectResult = value;
    }

}
