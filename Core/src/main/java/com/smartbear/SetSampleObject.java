
package com.smartbear;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="obj" type="{http://smartbear.com}SampleTestClass" minOccurs="0"/&gt;
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
    "obj"
})
@XmlRootElement(name = "SetSampleObject")
public class SetSampleObject {

    protected SampleTestClass obj;

    /**
     * Gets the value of the obj property.
     * 
     * @return
     *     possible object is
     *     {@link SampleTestClass }
     *     
     */
    public SampleTestClass getObj() {
        return obj;
    }

    /**
     * Sets the value of the obj property.
     * 
     * @param value
     *     allowed object is
     *     {@link SampleTestClass }
     *     
     */
    public void setObj(SampleTestClass value) {
        this.obj = value;
    }

}
