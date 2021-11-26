
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CreateHeatPumpFacilitySvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CreateHeatPumpFacilitySvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Address" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FacilityAddressSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Apartment" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ApartmentSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Building" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}BuildingSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CreatedFromCaseId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Estate" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}EstateSvcDto"/&amp;gt;
 *         &amp;lt;element name="FacilityStatusId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *         &amp;lt;element name="Location" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}LocationSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Manufacturer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PowerConsumption" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PowerOutput" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateHeatPumpFacilitySvcDto", propOrder = {
    "address",
    "apartment",
    "building",
    "createdFromCaseId",
    "estate",
    "facilityStatusId",
    "location",
    "manufacturer",
    "model",
    "powerConsumption",
    "powerOutput"
})
@XmlSeeAlso({
    CreateHeatPumpFacilityWithHeatTransferFluidSvcDto.class,
    CreateAirHeatingFacilitySvcDto.class
})
public class CreateHeatPumpFacilitySvcDto {

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
    @XmlElement(name = "FacilityStatusId", required = true)
    protected String facilityStatusId;
    @XmlElement(name = "Location", nillable = true)
    protected LocationSvcDto location;
    @XmlElement(name = "Manufacturer", nillable = true)
    protected String manufacturer;
    @XmlElement(name = "Model", nillable = true)
    protected String model;
    @XmlElement(name = "PowerConsumption", nillable = true)
    protected Double powerConsumption;
    @XmlElement(name = "PowerOutput", nillable = true)
    protected Double powerOutput;

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
     * Gets the value of the manufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the value of the manufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the powerConsumption property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPowerConsumption() {
        return powerConsumption;
    }

    /**
     * Sets the value of the powerConsumption property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPowerConsumption(Double value) {
        this.powerConsumption = value;
    }

    /**
     * Gets the value of the powerOutput property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPowerOutput() {
        return powerOutput;
    }

    /**
     * Sets the value of the powerOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPowerOutput(Double value) {
        this.powerOutput = value;
    }

}
