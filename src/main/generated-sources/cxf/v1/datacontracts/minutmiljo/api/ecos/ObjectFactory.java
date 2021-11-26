
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the v1.datacontracts.minutmiljo.api.ecos package. 
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

    private final static QName _ArrayOfDocumentSvcDto_QNAME = new QName("urn:Ecos.API.MinutMiljo.DataContracts.V1", "ArrayOfDocumentSvcDto");
    private final static QName _DocumentSvcDto_QNAME = new QName("urn:Ecos.API.MinutMiljo.DataContracts.V1", "DocumentSvcDto");
    private final static QName _ArrayOfExternalCaseSvcDto_QNAME = new QName("urn:Ecos.API.MinutMiljo.DataContracts.V1", "ArrayOfExternalCaseSvcDto");
    private final static QName _ExternalCaseSvcDto_QNAME = new QName("urn:Ecos.API.MinutMiljo.DataContracts.V1", "ExternalCaseSvcDto");
    private final static QName _ArrayOfRegisterDocumentPartyRoleDto_QNAME = new QName("urn:Ecos.API.MinutMiljo.DataContracts.V1", "ArrayOfRegisterDocumentPartyRoleDto");
    private final static QName _RegisterDocumentPartyRoleDto_QNAME = new QName("urn:Ecos.API.MinutMiljo.DataContracts.V1", "RegisterDocumentPartyRoleDto");
    private final static QName _RegisterDocumentCaseResultSvcDto_QNAME = new QName("urn:Ecos.API.MinutMiljo.DataContracts.V1", "RegisterDocumentCaseResultSvcDto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: v1.datacontracts.minutmiljo.api.ecos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegisterDocumentCaseResultSvcDto }
     * 
     */
    public RegisterDocumentCaseResultSvcDto createRegisterDocumentCaseResultSvcDto() {
        return new RegisterDocumentCaseResultSvcDto();
    }

    /**
     * Create an instance of {@link ArrayOfDocumentSvcDto }
     * 
     */
    public ArrayOfDocumentSvcDto createArrayOfDocumentSvcDto() {
        return new ArrayOfDocumentSvcDto();
    }

    /**
     * Create an instance of {@link DocumentSvcDto }
     * 
     */
    public DocumentSvcDto createDocumentSvcDto() {
        return new DocumentSvcDto();
    }

    /**
     * Create an instance of {@link ArrayOfExternalCaseSvcDto }
     * 
     */
    public ArrayOfExternalCaseSvcDto createArrayOfExternalCaseSvcDto() {
        return new ArrayOfExternalCaseSvcDto();
    }

    /**
     * Create an instance of {@link ExternalCaseSvcDto }
     * 
     */
    public ExternalCaseSvcDto createExternalCaseSvcDto() {
        return new ExternalCaseSvcDto();
    }

    /**
     * Create an instance of {@link ArrayOfRegisterDocumentPartyRoleDto }
     * 
     */
    public ArrayOfRegisterDocumentPartyRoleDto createArrayOfRegisterDocumentPartyRoleDto() {
        return new ArrayOfRegisterDocumentPartyRoleDto();
    }

    /**
     * Create an instance of {@link RegisterDocumentPartyRoleDto }
     * 
     */
    public RegisterDocumentPartyRoleDto createRegisterDocumentPartyRoleDto() {
        return new RegisterDocumentPartyRoleDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDocumentSvcDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfDocumentSvcDto }{@code >}
     */
    @XmlElementDecl(namespace = "urn:Ecos.API.MinutMiljo.DataContracts.V1", name = "ArrayOfDocumentSvcDto")
    public JAXBElement<ArrayOfDocumentSvcDto> createArrayOfDocumentSvcDto(ArrayOfDocumentSvcDto value) {
        return new JAXBElement<ArrayOfDocumentSvcDto>(_ArrayOfDocumentSvcDto_QNAME, ArrayOfDocumentSvcDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentSvcDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentSvcDto }{@code >}
     */
    @XmlElementDecl(namespace = "urn:Ecos.API.MinutMiljo.DataContracts.V1", name = "DocumentSvcDto")
    public JAXBElement<DocumentSvcDto> createDocumentSvcDto(DocumentSvcDto value) {
        return new JAXBElement<DocumentSvcDto>(_DocumentSvcDto_QNAME, DocumentSvcDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfExternalCaseSvcDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfExternalCaseSvcDto }{@code >}
     */
    @XmlElementDecl(namespace = "urn:Ecos.API.MinutMiljo.DataContracts.V1", name = "ArrayOfExternalCaseSvcDto")
    public JAXBElement<ArrayOfExternalCaseSvcDto> createArrayOfExternalCaseSvcDto(ArrayOfExternalCaseSvcDto value) {
        return new JAXBElement<ArrayOfExternalCaseSvcDto>(_ArrayOfExternalCaseSvcDto_QNAME, ArrayOfExternalCaseSvcDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExternalCaseSvcDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExternalCaseSvcDto }{@code >}
     */
    @XmlElementDecl(namespace = "urn:Ecos.API.MinutMiljo.DataContracts.V1", name = "ExternalCaseSvcDto")
    public JAXBElement<ExternalCaseSvcDto> createExternalCaseSvcDto(ExternalCaseSvcDto value) {
        return new JAXBElement<ExternalCaseSvcDto>(_ExternalCaseSvcDto_QNAME, ExternalCaseSvcDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRegisterDocumentPartyRoleDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRegisterDocumentPartyRoleDto }{@code >}
     */
    @XmlElementDecl(namespace = "urn:Ecos.API.MinutMiljo.DataContracts.V1", name = "ArrayOfRegisterDocumentPartyRoleDto")
    public JAXBElement<ArrayOfRegisterDocumentPartyRoleDto> createArrayOfRegisterDocumentPartyRoleDto(ArrayOfRegisterDocumentPartyRoleDto value) {
        return new JAXBElement<ArrayOfRegisterDocumentPartyRoleDto>(_ArrayOfRegisterDocumentPartyRoleDto_QNAME, ArrayOfRegisterDocumentPartyRoleDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterDocumentPartyRoleDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterDocumentPartyRoleDto }{@code >}
     */
    @XmlElementDecl(namespace = "urn:Ecos.API.MinutMiljo.DataContracts.V1", name = "RegisterDocumentPartyRoleDto")
    public JAXBElement<RegisterDocumentPartyRoleDto> createRegisterDocumentPartyRoleDto(RegisterDocumentPartyRoleDto value) {
        return new JAXBElement<RegisterDocumentPartyRoleDto>(_RegisterDocumentPartyRoleDto_QNAME, RegisterDocumentPartyRoleDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterDocumentCaseResultSvcDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterDocumentCaseResultSvcDto }{@code >}
     */
    @XmlElementDecl(namespace = "urn:Ecos.API.MinutMiljo.DataContracts.V1", name = "RegisterDocumentCaseResultSvcDto")
    public JAXBElement<RegisterDocumentCaseResultSvcDto> createRegisterDocumentCaseResultSvcDto(RegisterDocumentCaseResultSvcDto value) {
        return new JAXBElement<RegisterDocumentCaseResultSvcDto>(_RegisterDocumentCaseResultSvcDto_QNAME, RegisterDocumentCaseResultSvcDto.class, null, value);
    }

}
