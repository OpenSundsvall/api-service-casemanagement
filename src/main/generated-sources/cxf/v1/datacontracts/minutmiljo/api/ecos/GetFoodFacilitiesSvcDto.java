
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfguid;


/**
 * &lt;p&gt;Java class for GetFoodFacilitiesSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="GetFoodFacilitiesSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="FacilityIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfguid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="MaxNumberOfInspectionResults" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFoodFacilitiesSvcDto", propOrder = {
    "facilityIds",
    "maxNumberOfInspectionResults"
})
public class GetFoodFacilitiesSvcDto {

    @XmlElement(name = "FacilityIds", nillable = true)
    protected ArrayOfguid facilityIds;
    @XmlElement(name = "MaxNumberOfInspectionResults", nillable = true)
    protected Integer maxNumberOfInspectionResults;

    /**
     * Gets the value of the facilityIds property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfguid }
     *     
     */
    public ArrayOfguid getFacilityIds() {
        return facilityIds;
    }

    /**
     * Sets the value of the facilityIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfguid }
     *     
     */
    public void setFacilityIds(ArrayOfguid value) {
        this.facilityIds = value;
    }

    /**
     * Gets the value of the maxNumberOfInspectionResults property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxNumberOfInspectionResults() {
        return maxNumberOfInspectionResults;
    }

    /**
     * Sets the value of the maxNumberOfInspectionResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxNumberOfInspectionResults(Integer value) {
        this.maxNumberOfInspectionResults = value;
    }

}
