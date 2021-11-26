
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfguid;


/**
 * &lt;p&gt;Java class for FacilityFoodFacilityOrientationTypesFilterSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FacilityFoodFacilityOrientationTypesFilterSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FacilityFilterSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="OrientationTypeIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfguid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="RequireAll" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityFoodFacilityOrientationTypesFilterSvcDto", propOrder = {
    "orientationTypeIds",
    "requireAll"
})
public class FacilityFoodFacilityOrientationTypesFilterSvcDto
    extends FacilityFilterSvcDto
{

    @XmlElement(name = "OrientationTypeIds", nillable = true)
    protected ArrayOfguid orientationTypeIds;
    @XmlElement(name = "RequireAll")
    protected Boolean requireAll;

    /**
     * Gets the value of the orientationTypeIds property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfguid }
     *     
     */
    public ArrayOfguid getOrientationTypeIds() {
        return orientationTypeIds;
    }

    /**
     * Sets the value of the orientationTypeIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfguid }
     *     
     */
    public void setOrientationTypeIds(ArrayOfguid value) {
        this.orientationTypeIds = value;
    }

    /**
     * Gets the value of the requireAll property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequireAll() {
        return requireAll;
    }

    /**
     * Sets the value of the requireAll property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequireAll(Boolean value) {
        this.requireAll = value;
    }

}
