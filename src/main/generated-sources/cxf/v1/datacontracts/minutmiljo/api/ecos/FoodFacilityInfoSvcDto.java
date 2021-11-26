
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for FoodFacilityInfoSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FoodFacilityInfoSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="AddressStreetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="AddressStreetNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityCollectionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FoodInspectionResults" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfFoodInspectionSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Location" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}LocationSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Orientations" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfFoodFacilityOrientationSvcDto" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FoodFacilityInfoSvcDto", propOrder = {
    "addressStreetName",
    "addressStreetNumber",
    "facilityCollectionName",
    "facilityId",
    "facilityName",
    "foodInspectionResults",
    "location",
    "orientations"
})
public class FoodFacilityInfoSvcDto {

    @XmlElement(name = "AddressStreetName", nillable = true)
    protected String addressStreetName;
    @XmlElement(name = "AddressStreetNumber", nillable = true)
    protected String addressStreetNumber;
    @XmlElement(name = "FacilityCollectionName", nillable = true)
    protected String facilityCollectionName;
    @XmlElement(name = "FacilityId")
    protected String facilityId;
    @XmlElement(name = "FacilityName", nillable = true)
    protected String facilityName;
    @XmlElement(name = "FoodInspectionResults", nillable = true)
    protected ArrayOfFoodInspectionSvcDto foodInspectionResults;
    @XmlElement(name = "Location", nillable = true)
    protected LocationSvcDto location;
    @XmlElement(name = "Orientations", nillable = true)
    protected ArrayOfFoodFacilityOrientationSvcDto orientations;

    /**
     * Gets the value of the addressStreetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressStreetName() {
        return addressStreetName;
    }

    /**
     * Sets the value of the addressStreetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressStreetName(String value) {
        this.addressStreetName = value;
    }

    /**
     * Gets the value of the addressStreetNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressStreetNumber() {
        return addressStreetNumber;
    }

    /**
     * Sets the value of the addressStreetNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressStreetNumber(String value) {
        this.addressStreetNumber = value;
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
     * Gets the value of the facilityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityId() {
        return facilityId;
    }

    /**
     * Sets the value of the facilityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityId(String value) {
        this.facilityId = value;
    }

    /**
     * Gets the value of the facilityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityName() {
        return facilityName;
    }

    /**
     * Sets the value of the facilityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityName(String value) {
        this.facilityName = value;
    }

    /**
     * Gets the value of the foodInspectionResults property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFoodInspectionSvcDto }
     *     
     */
    public ArrayOfFoodInspectionSvcDto getFoodInspectionResults() {
        return foodInspectionResults;
    }

    /**
     * Sets the value of the foodInspectionResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFoodInspectionSvcDto }
     *     
     */
    public void setFoodInspectionResults(ArrayOfFoodInspectionSvcDto value) {
        this.foodInspectionResults = value;
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
     * Gets the value of the orientations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFoodFacilityOrientationSvcDto }
     *     
     */
    public ArrayOfFoodFacilityOrientationSvcDto getOrientations() {
        return orientations;
    }

    /**
     * Sets the value of the orientations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFoodFacilityOrientationSvcDto }
     *     
     */
    public void setOrientations(ArrayOfFoodFacilityOrientationSvcDto value) {
        this.orientations = value;
    }

}
