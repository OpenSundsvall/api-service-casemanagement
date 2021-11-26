
package v1.service.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import v1.datacontracts.minutmiljo.api.ecos.CreateOccurrenceOnFacilitySvcDto;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="createOccurrenceOnFacilitySvcDto" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}CreateOccurrenceOnFacilitySvcDto" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "createOccurrenceOnFacilitySvcDto"
})
@XmlRootElement(name = "CreateOccurrenceOnFacility")
public class CreateOccurrenceOnFacility {

    @XmlElement(nillable = true)
    protected CreateOccurrenceOnFacilitySvcDto createOccurrenceOnFacilitySvcDto;

    /**
     * Gets the value of the createOccurrenceOnFacilitySvcDto property.
     * 
     * @return
     *     possible object is
     *     {@link CreateOccurrenceOnFacilitySvcDto }
     *     
     */
    public CreateOccurrenceOnFacilitySvcDto getCreateOccurrenceOnFacilitySvcDto() {
        return createOccurrenceOnFacilitySvcDto;
    }

    /**
     * Sets the value of the createOccurrenceOnFacilitySvcDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateOccurrenceOnFacilitySvcDto }
     *     
     */
    public void setCreateOccurrenceOnFacilitySvcDto(CreateOccurrenceOnFacilitySvcDto value) {
        this.createOccurrenceOnFacilitySvcDto = value;
    }

}
