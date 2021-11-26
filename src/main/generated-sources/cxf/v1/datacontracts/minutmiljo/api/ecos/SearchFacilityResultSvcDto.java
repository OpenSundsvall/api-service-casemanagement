
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for SearchFacilityResultSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="SearchFacilityResultSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="EstateDesignation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityCollectionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityStatusName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchFacilityResultSvcDto", propOrder = {
    "estateDesignation",
    "facilityCollectionName",
    "facilityId",
    "facilityName",
    "facilityStatusName",
    "facilityTypeName"
})
public class SearchFacilityResultSvcDto {

    @XmlElement(name = "EstateDesignation", nillable = true)
    protected String estateDesignation;
    @XmlElement(name = "FacilityCollectionName", nillable = true)
    protected String facilityCollectionName;
    @XmlElement(name = "FacilityId")
    protected String facilityId;
    @XmlElement(name = "FacilityName", nillable = true)
    protected String facilityName;
    @XmlElement(name = "FacilityStatusName", nillable = true)
    protected String facilityStatusName;
    @XmlElement(name = "FacilityTypeName", nillable = true)
    protected String facilityTypeName;

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
     * Gets the value of the facilityStatusName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityStatusName() {
        return facilityStatusName;
    }

    /**
     * Sets the value of the facilityStatusName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityStatusName(String value) {
        this.facilityStatusName = value;
    }

    /**
     * Gets the value of the facilityTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityTypeName() {
        return facilityTypeName;
    }

    /**
     * Sets the value of the facilityTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityTypeName(String value) {
        this.facilityTypeName = value;
    }

}
