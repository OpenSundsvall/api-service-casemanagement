
package v2.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the v2.datacontracts.minutmiljo.api.ecos package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _RegisterDocumentCaseSvcDtoV2_QNAME = new QName("urn:Ecos.API.MinutMiljo.DataContracts.V2", "RegisterDocumentCaseSvcDtoV2");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: v2.datacontracts.minutmiljo.api.ecos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegisterDocumentCaseSvcDtoV2 }
     * 
     */
    public RegisterDocumentCaseSvcDtoV2 createRegisterDocumentCaseSvcDtoV2() {
        return new RegisterDocumentCaseSvcDtoV2();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterDocumentCaseSvcDtoV2 }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterDocumentCaseSvcDtoV2 }{@code >}
     */
    @XmlElementDecl(namespace = "urn:Ecos.API.MinutMiljo.DataContracts.V2", name = "RegisterDocumentCaseSvcDtoV2")
    public JAXBElement<RegisterDocumentCaseSvcDtoV2> createRegisterDocumentCaseSvcDtoV2(RegisterDocumentCaseSvcDtoV2 value) {
        return new JAXBElement<RegisterDocumentCaseSvcDtoV2>(_RegisterDocumentCaseSvcDtoV2_QNAME, RegisterDocumentCaseSvcDtoV2 .class, null, value);
    }

}
