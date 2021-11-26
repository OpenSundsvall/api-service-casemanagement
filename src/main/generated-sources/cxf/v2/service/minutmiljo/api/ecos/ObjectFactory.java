
package v2.service.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the v2.service.minutmiljo.api.ecos package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: v2.service.minutmiljo.api.ecos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegisterDocument }
     * 
     */
    public RegisterDocument createRegisterDocument() {
        return new RegisterDocument();
    }

    /**
     * Create an instance of {@link RegisterDocumentResponse }
     * 
     */
    public RegisterDocumentResponse createRegisterDocumentResponse() {
        return new RegisterDocumentResponse();
    }

}
