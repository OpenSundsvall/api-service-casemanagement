
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for DocumentListItemSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DocumentListItemSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="DecisionBases" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfDecisionBasisSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DocumentClassificationTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DocumentId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DocumentKindId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DocumentStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DocumentTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IsMainDecision" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentListItemSvcDto", propOrder = {
    "decisionBases",
    "documentClassificationTypeDescription",
    "documentId",
    "documentKindId",
    "documentStatus",
    "documentTypeId",
    "filename",
    "isMainDecision",
    "note"
})
public class DocumentListItemSvcDto {

    @XmlElement(name = "DecisionBases", nillable = true)
    protected ArrayOfDecisionBasisSvcDto decisionBases;
    @XmlElement(name = "DocumentClassificationTypeDescription", nillable = true)
    protected String documentClassificationTypeDescription;
    @XmlElement(name = "DocumentId", nillable = true)
    protected String documentId;
    @XmlElement(name = "DocumentKindId")
    protected String documentKindId;
    @XmlElement(name = "DocumentStatus", nillable = true)
    protected String documentStatus;
    @XmlElement(name = "DocumentTypeId")
    protected String documentTypeId;
    @XmlElement(name = "Filename", nillable = true)
    protected String filename;
    @XmlElement(name = "IsMainDecision")
    protected Boolean isMainDecision;
    @XmlElement(name = "Note", nillable = true)
    protected String note;

    /**
     * Gets the value of the decisionBases property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDecisionBasisSvcDto }
     *     
     */
    public ArrayOfDecisionBasisSvcDto getDecisionBases() {
        return decisionBases;
    }

    /**
     * Sets the value of the decisionBases property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDecisionBasisSvcDto }
     *     
     */
    public void setDecisionBases(ArrayOfDecisionBasisSvcDto value) {
        this.decisionBases = value;
    }

    /**
     * Gets the value of the documentClassificationTypeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentClassificationTypeDescription() {
        return documentClassificationTypeDescription;
    }

    /**
     * Sets the value of the documentClassificationTypeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentClassificationTypeDescription(String value) {
        this.documentClassificationTypeDescription = value;
    }

    /**
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentId(String value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the documentKindId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentKindId() {
        return documentKindId;
    }

    /**
     * Sets the value of the documentKindId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentKindId(String value) {
        this.documentKindId = value;
    }

    /**
     * Gets the value of the documentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentStatus() {
        return documentStatus;
    }

    /**
     * Sets the value of the documentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentStatus(String value) {
        this.documentStatus = value;
    }

    /**
     * Gets the value of the documentTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentTypeId() {
        return documentTypeId;
    }

    /**
     * Sets the value of the documentTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentTypeId(String value) {
        this.documentTypeId = value;
    }

    /**
     * Gets the value of the filename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the value of the filename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilename(String value) {
        this.filename = value;
    }

    /**
     * Gets the value of the isMainDecision property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsMainDecision() {
        return isMainDecision;
    }

    /**
     * Sets the value of the isMainDecision property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsMainDecision(Boolean value) {
        this.isMainDecision = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

}
