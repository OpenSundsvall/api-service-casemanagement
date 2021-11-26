
package v1.service.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import v1.datacontracts.minutmiljo.api.ecos.CreateHealthProtectionFacilitySvcDto;


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
 *         &amp;lt;element name="createHealthProtectionFacilitySvcDto" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}CreateHealthProtectionFacilitySvcDto" minOccurs="0"/&amp;gt;
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
    "createHealthProtectionFacilitySvcDto"
})
@XmlRootElement(name = "CreateHealthProtectionFacility")
public class CreateHealthProtectionFacility {

    @XmlElement(nillable = true)
    protected CreateHealthProtectionFacilitySvcDto createHealthProtectionFacilitySvcDto;

    /**
     * Gets the value of the createHealthProtectionFacilitySvcDto property.
     * 
     * @return
     *     possible object is
     *     {@link CreateHealthProtectionFacilitySvcDto }
     *     
     */
    public CreateHealthProtectionFacilitySvcDto getCreateHealthProtectionFacilitySvcDto() {
        return createHealthProtectionFacilitySvcDto;
    }

    /**
     * Sets the value of the createHealthProtectionFacilitySvcDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateHealthProtectionFacilitySvcDto }
     *     
     */
    public void setCreateHealthProtectionFacilitySvcDto(CreateHealthProtectionFacilitySvcDto value) {
        this.createHealthProtectionFacilitySvcDto = value;
    }

}
