
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CaseSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CaseSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="CaseId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CaseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CaseSubtitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CaseSubtitleFree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Documents" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfDocumentListItemSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="EstateAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="EstateDesignation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Occurrences" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfOccurrenceListItemSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ProcessTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseSvcDto", propOrder = {
    "caseId",
    "caseNumber",
    "caseSubtitle",
    "caseSubtitleFree",
    "documents",
    "estateAddress",
    "estateDesignation",
    "occurrences",
    "processTypeName"
})
public class CaseSvcDto {

    @XmlElement(name = "CaseId", nillable = true)
    protected String caseId;
    @XmlElement(name = "CaseNumber", nillable = true)
    protected String caseNumber;
    @XmlElement(name = "CaseSubtitle", nillable = true)
    protected String caseSubtitle;
    @XmlElement(name = "CaseSubtitleFree", nillable = true)
    protected String caseSubtitleFree;
    @XmlElement(name = "Documents", nillable = true)
    protected ArrayOfDocumentListItemSvcDto documents;
    @XmlElement(name = "EstateAddress", nillable = true)
    protected String estateAddress;
    @XmlElement(name = "EstateDesignation", nillable = true)
    protected String estateDesignation;
    @XmlElement(name = "Occurrences", nillable = true)
    protected ArrayOfOccurrenceListItemSvcDto occurrences;
    @XmlElement(name = "ProcessTypeName", nillable = true)
    protected String processTypeName;

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
     * Gets the value of the caseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseNumber() {
        return caseNumber;
    }

    /**
     * Sets the value of the caseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseNumber(String value) {
        this.caseNumber = value;
    }

    /**
     * Gets the value of the caseSubtitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseSubtitle() {
        return caseSubtitle;
    }

    /**
     * Sets the value of the caseSubtitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseSubtitle(String value) {
        this.caseSubtitle = value;
    }

    /**
     * Gets the value of the caseSubtitleFree property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseSubtitleFree() {
        return caseSubtitleFree;
    }

    /**
     * Sets the value of the caseSubtitleFree property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseSubtitleFree(String value) {
        this.caseSubtitleFree = value;
    }

    /**
     * Gets the value of the documents property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDocumentListItemSvcDto }
     *     
     */
    public ArrayOfDocumentListItemSvcDto getDocuments() {
        return documents;
    }

    /**
     * Sets the value of the documents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDocumentListItemSvcDto }
     *     
     */
    public void setDocuments(ArrayOfDocumentListItemSvcDto value) {
        this.documents = value;
    }

    /**
     * Gets the value of the estateAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstateAddress() {
        return estateAddress;
    }

    /**
     * Sets the value of the estateAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstateAddress(String value) {
        this.estateAddress = value;
    }

    /**
     * Gets the value of the estateDesignation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstateDesignation() {
        return estateDesignation;
    }

    /**
     * Sets the value of the estateDesignation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstateDesignation(String value) {
        this.estateDesignation = value;
    }

    /**
     * Gets the value of the occurrences property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOccurrenceListItemSvcDto }
     *     
     */
    public ArrayOfOccurrenceListItemSvcDto getOccurrences() {
        return occurrences;
    }

    /**
     * Sets the value of the occurrences property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOccurrenceListItemSvcDto }
     *     
     */
    public void setOccurrences(ArrayOfOccurrenceListItemSvcDto value) {
        this.occurrences = value;
    }

    /**
     * Gets the value of the processTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessTypeName() {
        return processTypeName;
    }

    /**
     * Sets the value of the processTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessTypeName(String value) {
        this.processTypeName = value;
    }

}
