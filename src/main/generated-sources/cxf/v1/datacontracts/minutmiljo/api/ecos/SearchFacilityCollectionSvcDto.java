
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for SearchFacilityCollectionSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="SearchFacilityCollectionSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="EstateDesgnation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FNR" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityCollectionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityCollectionStatus" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FacilityCollectionStatus" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityStatus" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityType" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Kommun" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="StreetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="StreetNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchFacilityCollectionSvcDto", propOrder = {
    "estateDesgnation",
    "fnr",
    "facilityCollectionName",
    "facilityCollectionStatus",
    "facilityStatus",
    "facilityType",
    "kommun",
    "postalCode",
    "streetName",
    "streetNumber"
})
public class SearchFacilityCollectionSvcDto {

    @XmlElement(name = "EstateDesgnation", nillable = true)
    protected String estateDesgnation;
    @XmlElement(name = "FNR", nillable = true)
    protected Integer fnr;
    @XmlElement(name = "FacilityCollectionName", nillable = true)
    protected String facilityCollectionName;
    @XmlElement(name = "FacilityCollectionStatus")
    @XmlSchemaType(name = "string")
    protected FacilityCollectionStatus facilityCollectionStatus;
    @XmlElement(name = "FacilityStatus", nillable = true)
    protected String facilityStatus;
    @XmlElement(name = "FacilityType", nillable = true)
    protected String facilityType;
    @XmlElement(name = "Kommun", nillable = true)
    protected String kommun;
    @XmlElement(name = "PostalCode", nillable = true)
    protected String postalCode;
    @XmlElement(name = "StreetName", nillable = true)
    protected String streetName;
    @XmlElement(name = "StreetNumber", nillable = true)
    protected String streetNumber;

    /**
     * Gets the value of the estateDesgnation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstateDesgnation() {
        return estateDesgnation;
    }

    /**
     * Sets the value of the estateDesgnation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstateDesgnation(String value) {
        this.estateDesgnation = value;
    }

    /**
     * Gets the value of the fnr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFNR() {
        return fnr;
    }

    /**
     * Sets the value of the fnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFNR(Integer value) {
        this.fnr = value;
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
     * Gets the value of the facilityCollectionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityCollectionStatus }
     *     
     */
    public FacilityCollectionStatus getFacilityCollectionStatus() {
        return facilityCollectionStatus;
    }

    /**
     * Sets the value of the facilityCollectionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityCollectionStatus }
     *     
     */
    public void setFacilityCollectionStatus(FacilityCollectionStatus value) {
        this.facilityCollectionStatus = value;
    }

    /**
     * Gets the value of the facilityStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityStatus() {
        return facilityStatus;
    }

    /**
     * Sets the value of the facilityStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityStatus(String value) {
        this.facilityStatus = value;
    }

    /**
     * Gets the value of the facilityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityType() {
        return facilityType;
    }

    /**
     * Sets the value of the facilityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityType(String value) {
        this.facilityType = value;
    }

    /**
     * Gets the value of the kommun property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKommun() {
        return kommun;
    }

    /**
     * Sets the value of the kommun property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKommun(String value) {
        this.kommun = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetName(String value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the streetNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets the value of the streetNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNumber(String value) {
        this.streetNumber = value;
    }

}
