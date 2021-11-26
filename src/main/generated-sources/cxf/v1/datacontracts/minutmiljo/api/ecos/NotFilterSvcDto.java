
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for NotFilterSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="NotFilterSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FilterSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Filter" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FilterSvcDto" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotFilterSvcDto", propOrder = {
    "filter"
})
public class NotFilterSvcDto
    extends FilterSvcDto
{

    @XmlElement(name = "Filter", nillable = true)
    protected FilterSvcDto filter;

    /**
     * Gets the value of the filter property.
     * 
     * @return
     *     possible object is
     *     {@link FilterSvcDto }
     *     
     */
    public FilterSvcDto getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterSvcDto }
     *     
     */
    public void setFilter(FilterSvcDto value) {
        this.filter = value;
    }

}
