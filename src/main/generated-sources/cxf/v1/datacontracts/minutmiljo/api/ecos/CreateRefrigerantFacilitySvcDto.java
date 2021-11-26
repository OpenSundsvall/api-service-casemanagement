
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CreateRefrigerantFacilitySvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CreateRefrigerantFacilitySvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Address" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FacilityAddressSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Apartment" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ApartmentSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Building" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}BuildingSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CreatedFromCaseId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Estate" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}EstateSvcDto"/&amp;gt;
 *         &amp;lt;element name="FacilityCollection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityStatusId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *         &amp;lt;element name="Location" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}LocationSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="RefrigerantUnits" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfRefrigerantUnitSvcDto"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateRefrigerantFacilitySvcDto", propOrder = {
    "address",
    "apartment",
    "building",
    "createdFromCaseId",
    "estate",
    "facilityCollection",
    "facilityStatusId",
    "location",
    "refrigerantUnits"
})
public class CreateRefrigerantFacilitySvcDto {

    @XmlElement(name = "Address", nillable = true)
    protected FacilityAddressSvcDto address;
    @XmlElement(name = "Apartment", nillable = true)
    protected ApartmentSvcDto apartment;
    @XmlElement(name = "Building", nillable = true)
    protected BuildingSvcDto building;
    @XmlElement(name = "CreatedFromCaseId", nillable = true)
    protected String createdFromCaseId;
    @XmlElement(name = "Estate", required = true, nillable = true)
    protected EstateSvcDto estate;
    @XmlElement(name = "FacilityCollection", nillable = true)
    protected String facilityCollection;
    @XmlElement(name = "FacilityStatusId", required = true)
    protected String facilityStatusId;
    @XmlElement(name = "Location", nillable = true)
    protected LocationSvcDto location;
    @XmlElement(name = "RefrigerantUnits", required = true, nillable = true)
    protected ArrayOfRefrigerantUnitSvcDto refrigerantUnits;

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
     * Gets the value of the facilityCollection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityCollection() {
        return facilityCollection;
    }

    /**
     * Sets the value of the facilityCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityCollection(String value) {
        this.facilityCollection = value;
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
     * Gets the value of the refrigerantUnits property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRefrigerantUnitSvcDto }
     *     
     */
    public ArrayOfRefrigerantUnitSvcDto getRefrigerantUnits() {
        return refrigerantUnits;
    }

    /**
     * Sets the value of the refrigerantUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRefrigerantUnitSvcDto }
     *     
     */
    public void setRefrigerantUnits(ArrayOfRefrigerantUnitSvcDto value) {
        this.refrigerantUnits = value;
    }

}
