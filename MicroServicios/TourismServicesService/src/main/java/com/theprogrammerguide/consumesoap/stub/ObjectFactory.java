//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.11.13 a las 11:08:41 PM COT 
//


package com.theprogrammerguide.consumesoap.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.theprogrammerguide.consumesoap.stub package. 
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

    private final static QName _TourismServiceSOAP_QNAME = new QName("http://services/xsd", "tourismServiceSOAP");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.theprogrammerguide.consumesoap.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TourismServiceSOAP }
     * 
     */
    public TourismServiceSOAP createTourismServiceSOAP() {
        return new TourismServiceSOAP();
    }

    /**
     * Create an instance of {@link GetSearchResponse }
     * 
     */
    public GetSearchResponse createGetSearchResponse() {
        return new GetSearchResponse();
    }

    /**
     * Create an instance of {@link GetSearchRequest }
     * 
     */
    public GetSearchRequest createGetSearchRequest() {
        return new GetSearchRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TourismServiceSOAP }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TourismServiceSOAP }{@code >}
     */
    @XmlElementDecl(namespace = "http://services/xsd", name = "tourismServiceSOAP")
    public JAXBElement<TourismServiceSOAP> createTourismServiceSOAP(TourismServiceSOAP value) {
        return new JAXBElement<TourismServiceSOAP>(_TourismServiceSOAP_QNAME, TourismServiceSOAP.class, null, value);
    }

}
