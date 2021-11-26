
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for SearchFacilityCollectioResultSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="SearchFacilityCollectioResultSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="FacilityCollectionId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityCollectionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityCollectionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FacilityListItem" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfFacilityItemSvcDto" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchFacilityCollectioResultSvcDto", propOrder = {
    "facilityCollectionId",
    "facilityCollectionName",
    "facilityCollectionStatus",
    "facilityListItem"
})
public class SearchFacilityCollectioResultSvcDto {

    @XmlElement(name = "FacilityCollectionId")
    protected String facilityCollectionId;
    @XmlElement(name = "FacilityCollectionName", nillable = true)
    protected String facilityCollectionName;
    @XmlElement(name = "FacilityCollectionStatus", nillable = true)
    protected String facilityCollectionStatus;
    @XmlElement(name = "FacilityListItem", nillable = true)
    protected ArrayOfFacilityItemSvcDto facilityListItem;

    /**
     * Gets the value of the facilityCollectionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityCollectionId() {
        return facilityCollectionId;
    }

    /**
     * Sets the value of the facilityCollectionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityCollectionId(String value) {
        this.facilityCollectionId = value;
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
     *     {@link String }
     *     
     */
    public String getFacilityCollectionStatus() {
        return facilityCollectionStatus;
    }

    /**
     * Sets the value of the facilityCollectionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityCollectionStatus(String value) {
        this.facilityCollectionStatus = value;
    }

    /**
     * Gets the value of the facilityListItem property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFacilityItemSvcDto }
     *     
     */
    public ArrayOfFacilityItemSvcDto getFacilityListItem() {
        return facilityListItem;
    }

    /**
     * Sets the value of the facilityListItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFacilityItemSvcDto }
     *     
     */
    public void setFacilityListItem(ArrayOfFacilityItemSvcDto value) {
        this.facilityListItem = value;
    }

}
