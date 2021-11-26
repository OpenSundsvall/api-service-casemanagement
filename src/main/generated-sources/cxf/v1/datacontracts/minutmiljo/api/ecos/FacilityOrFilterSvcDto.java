
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for FacilityOrFilterSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FacilityOrFilterSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FacilityFilterSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Filters" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfFacilityFilterSvcDto" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityOrFilterSvcDto", propOrder = {
    "filters"
})
public class FacilityOrFilterSvcDto
    extends FacilityFilterSvcDto
{

    @XmlElement(name = "Filters", nillable = true)
    protected ArrayOfFacilityFilterSvcDto filters;

    /**
     * Gets the value of the filters property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFacilityFilterSvcDto }
     *     
     */
    public ArrayOfFacilityFilterSvcDto getFilters() {
        return filters;
    }

    /**
     * Sets the value of the filters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFacilityFilterSvcDto }
     *     
     */
    public void setFilters(ArrayOfFacilityFilterSvcDto value) {
        this.filters = value;
    }

}
