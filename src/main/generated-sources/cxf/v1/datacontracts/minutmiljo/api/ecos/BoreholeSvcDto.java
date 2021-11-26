
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for BoreholeSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="BoreholeSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="AngleToVertical" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CompassDirection" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityStatusId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Length" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Location" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}LocationSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BoreholeSvcDto", propOrder = {
    "angleToVertical",
    "compassDirection",
    "facilityStatusId",
    "length",
    "location",
    "name"
})
public class BoreholeSvcDto {

    @XmlElement(name = "AngleToVertical", nillable = true)
    protected Integer angleToVertical;
    @XmlElement(name = "CompassDirection", nillable = true)
    protected Double compassDirection;
    @XmlElement(name = "FacilityStatusId", nillable = true)
    protected String facilityStatusId;
    @XmlElement(name = "Length", nillable = true)
    protected Integer length;
    @XmlElement(name = "Location", nillable = true)
    protected LocationSvcDto location;
    @XmlElement(name = "Name", nillable = true)
    protected String name;

    /**
     * Gets the value of the angleToVertical property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAngleToVertical() {
        return angleToVertical;
    }

    /**
     * Sets the value of the angleToVertical property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAngleToVertical(Integer value) {
        this.angleToVertical = value;
    }

    /**
     * Gets the value of the compassDirection property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCompassDirection() {
        return compassDirection;
    }

    /**
     * Sets the value of the compassDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCompassDirection(Double value) {
        this.compassDirection = value;
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
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLength(Integer value) {
        this.length = value;
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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
