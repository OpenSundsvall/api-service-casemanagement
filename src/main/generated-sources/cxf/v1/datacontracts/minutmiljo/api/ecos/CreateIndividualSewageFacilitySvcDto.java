
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CreateIndividualSewageFacilitySvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CreateIndividualSewageFacilitySvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="AccommodationTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Address" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FacilityAddressSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CreatedFromCaseId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Estate" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}EstateSvcDto"/&amp;gt;
 *         &amp;lt;element name="FacilityStatusId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *         &amp;lt;element name="Note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="OnGrantLand" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="ProtectionLevelApprovedEnvironmentId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ProtectionLevelApprovedHealthId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PurificationSteps" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfPurificationStepSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="WasteWaterInboundId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="WastewaterApprovedForId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateIndividualSewageFacilitySvcDto", propOrder = {
    "accommodationTypeId",
    "address",
    "createdFromCaseId",
    "estate",
    "facilityStatusId",
    "note",
    "onGrantLand",
    "protectionLevelApprovedEnvironmentId",
    "protectionLevelApprovedHealthId",
    "purificationSteps",
    "wasteWaterInboundId",
    "wastewaterApprovedForId"
})
public class CreateIndividualSewageFacilitySvcDto {

    @XmlElement(name = "AccommodationTypeId", nillable = true)
    protected String accommodationTypeId;
    @XmlElement(name = "Address", nillable = true)
    protected FacilityAddressSvcDto address;
    @XmlElement(name = "CreatedFromCaseId", nillable = true)
    protected String createdFromCaseId;
    @XmlElement(name = "Estate", required = true, nillable = true)
    protected EstateSvcDto estate;
    @XmlElement(name = "FacilityStatusId", required = true)
    protected String facilityStatusId;
    @XmlElement(name = "Note", nillable = true)
    protected String note;
    @XmlElement(name = "OnGrantLand")
    protected boolean onGrantLand;
    @XmlElement(name = "ProtectionLevelApprovedEnvironmentId", nillable = true)
    protected String protectionLevelApprovedEnvironmentId;
    @XmlElement(name = "ProtectionLevelApprovedHealthId", nillable = true)
    protected String protectionLevelApprovedHealthId;
    @XmlElement(name = "PurificationSteps", nillable = true)
    protected ArrayOfPurificationStepSvcDto purificationSteps;
    @XmlElement(name = "WasteWaterInboundId", nillable = true)
    protected String wasteWaterInboundId;
    @XmlElement(name = "WastewaterApprovedForId", nillable = true)
    protected String wastewaterApprovedForId;

    /**
     * Gets the value of the accommodationTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccommodationTypeId() {
        return accommodationTypeId;
    }

    /**
     * Sets the value of the accommodationTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccommodationTypeId(String value) {
        this.accommodationTypeId = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityAddressSvcDto }
     *     
     */
    public FacilityAddressSvcDto getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityAddressSvcDto }
     *     
     */
    public void setAddress(FacilityAddressSvcDto value) {
        this.address = value;
    }

    /**
     * Gets the value of the createdFromCaseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedFromCaseId() {
        return createdFromCaseId;
    }

    /**
     * Sets the value of the createdFromCaseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedFromCaseId(String value) {
        this.createdFromCaseId = value;
    }

    /**
     * Gets the value of the estate property.
     * 
     * @return
     *     possible object is
     *     {@link EstateSvcDto }
     *     
     */
    public EstateSvcDto getEstate() {
        return estate;
    }

    /**
     * Sets the value of the estate property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstateSvcDto }
     *     
     */
    public void setEstate(EstateSvcDto value) {
        this.estate = value;
    }

    /**
     * Gets the value of the facilityStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityStatusId() {
        return facilityStatusId;
    }

    /**
     * Sets the value of the facilityStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityStatusId(String value) {
        this.facilityStatusId = value;
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

    /**
     * Gets the value of the onGrantLand property.
     * 
     */
    public boolean isOnGrantLand() {
        return onGrantLand;
    }

    /**
     * Sets the value of the onGrantLand property.
     * 
     */
    public void setOnGrantLand(boolean value) {
        this.onGrantLand = value;
    }

    /**
     * Gets the value of the protectionLevelApprovedEnvironmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtectionLevelApprovedEnvironmentId() {
        return protectionLevelApprovedEnvironmentId;
    }

    /**
     * Sets the value of the protectionLevelApprovedEnvironmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtectionLevelApprovedEnvironmentId(String value) {
        this.protectionLevelApprovedEnvironmentId = value;
    }

    /**
     * Gets the value of the protectionLevelApprovedHealthId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtectionLevelApprovedHealthId() {
        return protectionLevelApprovedHealthId;
    }

    /**
     * Sets the value of the protectionLevelApprovedHealthId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtectionLevelApprovedHealthId(String value) {
        this.protectionLevelApprovedHealthId = value;
    }

    /**
     * Gets the value of the purificationSteps property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPurificationStepSvcDto }
     *     
     */
    public ArrayOfPurificationStepSvcDto getPurificationSteps() {
        return purificationSteps;
    }

    /**
     * Sets the value of the purificationSteps property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPurificationStepSvcDto }
     *     
     */
    public void setPurificationSteps(ArrayOfPurificationStepSvcDto value) {
        this.purificationSteps = value;
    }

    /**
     * Gets the value of the wasteWaterInboundId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWasteWaterInboundId() {
        return wasteWaterInboundId;
    }

    /**
     * Sets the value of the wasteWaterInboundId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWasteWaterInboundId(String value) {
        this.wasteWaterInboundId = value;
    }

    /**
     * Gets the value of the wastewaterApprovedForId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWastewaterApprovedForId() {
        return wastewaterApprovedForId;
    }

    /**
     * Sets the value of the wastewaterApprovedForId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWastewaterApprovedForId(String value) {
        this.wastewaterApprovedForId = value;
    }

}
