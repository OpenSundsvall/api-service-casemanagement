
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CreateFoodFacilitySvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CreateFoodFacilitySvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Address" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FacilityAddressSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Apartment" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ApartmentSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Building" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}BuildingSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Case" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="EstateDesignation" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}EstateSvcDto"/&amp;gt;
 *         &amp;lt;element name="FacilityCollectionName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="HandlingOfficer" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="HandlingOfficerGroup" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Location" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}LocationSvcDto" minOccurs="0"/&amp;gt;
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
@XmlType(name = "CreateFoodFacilitySvcDto", propOrder = {
    "address",
    "apartment",
    "building",
    "_case",
    "estateDesignation",
    "facilityCollectionName",
    "handlingOfficer",
    "handlingOfficerGroup",
    "location",
    "note"
})
public class CreateFoodFacilitySvcDto {

    @XmlElement(name = "Address", nillable = true)
    protected FacilityAddressSvcDto address;
    @XmlElement(name = "Apartment", nillable = true)
    protected ApartmentSvcDto apartment;
    @XmlElement(name = "Building", nillable = true)
    protected BuildingSvcDto building;
    @XmlElement(name = "Case", nillable = true)
    protected String _case;
    @XmlElement(name = "EstateDesignation", required = true, nillable = true)
    protected EstateSvcDto estateDesignation;
    @XmlElement(name = "FacilityCollectionName", required = true, nillable = true)
    protected String facilityCollectionName;
    @XmlElement(name = "HandlingOfficer", nillable = true)
    protected String handlingOfficer;
    @XmlElement(name = "HandlingOfficerGroup", nillable = true)
    protected String handlingOfficerGroup;
    @XmlElement(name = "Location", nillable = true)
    protected LocationSvcDto location;
    @XmlElement(name = "Note", nillable = true)
    protected String note;

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
     * Gets the value of the apartment property.
     * 
     * @return
     *     possible object is
     *     {@link ApartmentSvcDto }
     *     
     */
    public ApartmentSvcDto getApartment() {
        return apartment;
    }

    /**
     * Sets the value of the apartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApartmentSvcDto }
     *     
     */
    public void setApartment(ApartmentSvcDto value) {
        this.apartment = value;
    }

    /**
     * Gets the value of the building property.
     * 
     * @return
     *     possible object is
     *     {@link BuildingSvcDto }
     *     
     */
    public BuildingSvcDto getBuilding() {
        return building;
    }

    /**
     * Sets the value of the building property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuildingSvcDto }
     *     
     */
    public void setBuilding(BuildingSvcDto value) {
        this.building = value;
    }

    /**
     * Gets the value of the case property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCase() {
        return _case;
    }

    /**
     * Sets the value of the case property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCase(String value) {
        this._case = value;
    }

    /**
     * Gets the value of the estateDesignation property.
     * 
     * @return
     *     possible object is
     *     {@link EstateSvcDto }
     *     
     */
    public EstateSvcDto getEstateDesignation() {
        return estateDesignation;
    }

    /**
     * Sets the value of the estateDesignation property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstateSvcDto }
     *     
     */
    public void setEstateDesignation(EstateSvcDto value) {
        this.estateDesignation = value;
    }

    /**
     * Gets the value of the facilityCollectionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityCollectionName() {
        return facilityCollectionName;
    }

    /**
     * Sets the value of the facilityCollectionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityCollectionName(String value) {
        this.facilityCollectionName = value;
    }

    /**
     * Gets the value of the handlingOfficer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandlingOfficer() {
        return handlingOfficer;
    }

    /**
     * Sets the value of the handlingOfficer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandlingOfficer(String value) {
        this.handlingOfficer = value;
    }

    /**
     * Gets the value of the handlingOfficerGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandlingOfficerGroup() {
        return handlingOfficerGroup;
    }

    /**
     * Sets the value of the handlingOfficerGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandlingOfficerGroup(String value) {
        this.handlingOfficerGroup = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationSvcDto }
     *     
     */
    public LocationSvcDto getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationSvcDto }
     *     
     */
    public void setLocation(LocationSvcDto value) {
        this.location = value;
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
