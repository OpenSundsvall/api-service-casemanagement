
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for AddDocumentsToCaseSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="AddDocumentsToCaseSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="CaseId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DocumentStatusId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Documents" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfDocumentSvcDto"/&amp;gt;
 *         &amp;lt;element name="OccurrenceTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PerformedById" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SenderId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddDocumentsToCaseSvcDto", propOrder = {
    "caseId",
    "documentStatusId",
    "documents",
    "occurrenceTypeId",
    "performedById",
    "senderId"
})
public class AddDocumentsToCaseSvcDto {

    @XmlElement(name = "CaseId")
    protected String caseId;
    @XmlElement(name = "DocumentStatusId")
    protected String documentStatusId;
    @XmlElement(name = "Documents", required = true, nillable = true)
    protected ArrayOfDocumentSvcDto documents;
    @XmlElement(name = "OccurrenceTypeId")
    protected String occurrenceTypeId;
    @XmlElement(name = "PerformedById", nillable = true)
    protected String performedById;
    @XmlElement(name = "SenderId", nillable = true)
    protected String senderId;

    /**
     * Gets the value of the caseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * Sets the value of the caseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseId(String value) {
        this.caseId = value;
    }

    /**
     * Gets the value of the documentStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentStatusId() {
        return documentStatusId;
    }

    /**
     * Sets the value of the documentStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentStatusId(String value) {
        this.documentStatusId = value;
    }

    /**
     * Gets the value of the documents property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDocumentSvcDto }
     *     
     */
    public ArrayOfDocumentSvcDto getDocuments() {
        return documents;
    }

    /**
     * Sets the value of the documents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDocumentSvcDto }
     *     
     */
    public void setDocuments(ArrayOfDocumentSvcDto value) {
        this.documents = value;
    }

    /**
     * Gets the value of the occurrenceTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccurrenceTypeId() {
        return occurrenceTypeId;
    }

    /**
     * Sets the value of the occurrenceTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurrenceTypeId(String value) {
        this.occurrenceTypeId = value;
    }

    /**
     * Gets the value of the performedById property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerformedById() {
        return performedById;
    }

    /**
     * Sets the value of the performedById property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerformedById(String value) {
        this.performedById = value;
    }

    /**
     * Gets the value of the senderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * Sets the value of the senderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderId(String value) {
        this.senderId = value;
    }

}
