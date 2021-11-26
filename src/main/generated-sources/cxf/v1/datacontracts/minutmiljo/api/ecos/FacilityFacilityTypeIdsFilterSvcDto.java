
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for FacilityFacilityTypeIdsFilterSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FacilityFacilityTypeIdsFilterSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FacilityFilterSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="FacilityTypeIds" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityFacilityTypeIdsFilterSvcDto", propOrder = {
    "facilityTypeIds"
})
public class FacilityFacilityTypeIdsFilterSvcDto
    extends FacilityFilterSvcDto
{

    @XmlElement(name = "FacilityTypeIds")
    protected String facilityTypeIds;

    /**
     * Gets the value of the facilityTypeIds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityTypeIds() {
        return facilityTypeIds;
    }

    /**
     * Sets the value of the facilityTypeIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityTypeIds(String value) {
        this.facilityTypeIds = value;
    }

}
