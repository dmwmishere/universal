//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.23 at 06:11:54 PM MSK 
//


package org.dmwm.universal.core.data.xsds;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.dmwm.universal.sys1.data.xsds package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Memerq_QNAME = new QName("http://www.example.org/dataTypes", "memerq");
    private final static QName _Meme_QNAME = new QName("http://www.example.org/dataTypes", "meme");
    private final static QName _Memers_QNAME = new QName("http://www.example.org/dataTypes", "memers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.dmwm.universal.sys1.data.xsds
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Memedesc }
     * 
     */
    public Memedesc createMemedesc() {
        return new Memedesc();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link Extensions }
     * 
     */
    public Extensions createExtensions() {
        return new Extensions();
    }

    /**
     * Create an instance of {@link TFileType }
     * 
     */
    public TFileType createTFileType() {
        return new TFileType();
    }

    /**
     * Create an instance of {@link MemeInfoType }
     * 
     */
    public MemeInfoType createMemeInfoType() {
        return new MemeInfoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Memedesc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/dataTypes", name = "memerq")
    public JAXBElement<Memedesc> createMemerq(Memedesc value) {
        return new JAXBElement<Memedesc>(_Memerq_QNAME, Memedesc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Memedesc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/dataTypes", name = "meme")
    public JAXBElement<Memedesc> createMeme(Memedesc value) {
        return new JAXBElement<Memedesc>(_Meme_QNAME, Memedesc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/dataTypes", name = "memers")
    public JAXBElement<Response> createMemers(Response value) {
        return new JAXBElement<Response>(_Memers_QNAME, Response.class, null, value);
    }

}
