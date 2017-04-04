
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
 *         &lt;element name="GetSampleObjectResult" type="{http://smartbear.com}SampleTestClass" minOccurs="0"/&gt;
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
    "getSampleObjectResult"
})
@XmlRootElement(name = "GetSampleObjectResponse")
public class GetSampleObjectResponse {

    @XmlElement(name = "GetSampleObjectResult")
    protected SampleTestClass getSampleObjectResult;

    /**
     * Gets the value of the getSampleObjectResult property.
     * 
     * @return
     *     possible object is
     *     {@link SampleTestClass }
     *     
     */
    public SampleTestClass getGetSampleObjectResult() {
        return getSampleObjectResult;
    }

    /**
     * Sets the value of the getSampleObjectResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SampleTestClass }
     *     
     */
    public void setGetSampleObjectResult(SampleTestClass value) {
        this.getSampleObjectResult = value;
    }

}
