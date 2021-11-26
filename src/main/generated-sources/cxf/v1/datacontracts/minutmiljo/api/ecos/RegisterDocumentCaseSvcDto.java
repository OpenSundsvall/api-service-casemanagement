
package v1.datacontracts.minutmiljo.api.ecos;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * &lt;p&gt;Java class for RegisterDocumentCaseSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RegisterDocumentCaseSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="CaseSubtitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CaseSubtitleFree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DiaryPlanId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Documents" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfDocumentSvcDto"/&amp;gt;
 *         &amp;lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ExternalCaseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="HandlingOfficerGroupId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="HandlingOfficerId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="OccurrenceNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="OccurrenceTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *         &amp;lt;element name="PartyRoles" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfRegisterDocumentPartyRoleDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ProcessTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *         &amp;lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisterDocumentCaseSvcDto", propOrder = {
    "caseSubtitle",
    "caseSubtitleFree",
    "diaryPlanId",
    "documents",
    "expirationDate",
    "externalCaseNumber",
    "handlingOfficerGroupId",
    "handlingOfficerId",
    "occurrenceNote",
    "occurrenceTypeId",
    "partyRoles",
    "processTypeId",
    "startDate"
})
public class RegisterDocumentCaseSvcDto {

    @XmlElement(name = "CaseSubtitle", nillable = true)
    protected String caseSubtitle;
    @XmlElement(name = "CaseSubtitleFree", nillable = true)
    protected String caseSubtitleFree;
    @XmlElement(name = "DiaryPlanId", nillable = true)
    protected String diaryPlanId;
    @XmlElement(name = "Documents", required = true, nillable = true)
    protected ArrayOfDocumentSvcDto documents;
    @XmlElement(name = "ExpirationDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime expirationDate;
    @XmlElement(name = "ExternalCaseNumber", nillable = true)
    protected String externalCaseNumber;
    @XmlElement(name = "HandlingOfficerGroupId", nillable = true)
    protected String handlingOfficerGroupId;
    @XmlElement(name = "HandlingOfficerId", nillable = true)
    protected String handlingOfficerId;
    @XmlElement(name = "OccurrenceNote", nillable = true)
    protected String occurrenceNote;
    @XmlElement(name = "OccurrenceTypeId", required = true)
    protected String occurrenceTypeId;
    @XmlElement(name = "PartyRoles", nillable = true)
    protected ArrayOfRegisterDocumentPartyRoleDto partyRoles;
    @XmlElement(name = "ProcessTypeId", required = true)
    protected String processTypeId;
    @XmlElement(name = "StartDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime startDate;

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
     * Gets the value of the diaryPlanId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiaryPlanId() {
        return diaryPlanId;
    }

    /**
     * Sets the value of the diaryPlanId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiaryPlanId(String value) {
        this.diaryPlanId = value;
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
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationDate(LocalDateTime value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the externalCaseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalCaseNumber() {
        return externalCaseNumber;
    }

    /**
     * Sets the value of the externalCaseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalCaseNumber(String value) {
        this.externalCaseNumber = value;
    }

    /**
     * Gets the value of the handlingOfficerGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandlingOfficerGroupId() {
        return handlingOfficerGroupId;
    }

    /**
     * Sets the value of the handlingOfficerGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandlingOfficerGroupId(String value) {
        this.handlingOfficerGroupId = value;
    }

    /**
     * Gets the value of the handlingOfficerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandlingOfficerId() {
        return handlingOfficerId;
    }

    /**
     * Sets the value of the handlingOfficerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandlingOfficerId(String value) {
        this.handlingOfficerId = value;
    }

    /**
     * Gets the value of the occurrenceNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccurrenceNote() {
        return occurrenceNote;
    }

    /**
     * Sets the value of the occurrenceNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurrenceNote(String value) {
        this.occurrenceNote = value;
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
     * Gets the value of the partyRoles property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRegisterDocumentPartyRoleDto }
     *     
     */
    public ArrayOfRegisterDocumentPartyRoleDto getPartyRoles() {
        return partyRoles;
    }

    /**
     * Sets the value of the partyRoles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRegisterDocumentPartyRoleDto }
     *     
     */
    public void setPartyRoles(ArrayOfRegisterDocumentPartyRoleDto value) {
        this.partyRoles = value;
    }

    /**
     * Gets the value of the processTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessTypeId() {
        return processTypeId;
    }

    /**
     * Sets the value of the processTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessTypeId(String value) {
        this.processTypeId = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(LocalDateTime value) {
        this.startDate = value;
    }

}
