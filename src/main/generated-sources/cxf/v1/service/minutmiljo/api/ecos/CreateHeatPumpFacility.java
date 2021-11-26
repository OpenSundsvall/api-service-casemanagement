
package v1.service.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import v1.datacontracts.minutmiljo.api.ecos.CreateHeatPumpFacilitySvcDto;


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
 *         &amp;lt;element name="createIndividualSewageSvcDto" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}CreateHeatPumpFacilitySvcDto" minOccurs="0"/&amp;gt;
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
    "createIndividualSewageSvcDto"
})
@XmlRootElement(name = "CreateHeatPumpFacility")
public class CreateHeatPumpFacility {

    @XmlElement(nillable = true)
    protected CreateHeatPumpFacilitySvcDto createIndividualSewageSvcDto;

    /**
     * Gets the value of the createIndividualSewageSvcDto property.
     * 
     * @return
     *     possible object is
     *     {@link CreateHeatPumpFacilitySvcDto }
     *     
     */
    public CreateHeatPumpFacilitySvcDto getCreateIndividualSewageSvcDto() {
        return createIndividualSewageSvcDto;
    }

    /**
     * Sets the value of the createIndividualSewageSvcDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateHeatPumpFacilitySvcDto }
     *     
     */
    public void setCreateIndividualSewageSvcDto(CreateHeatPumpFacilitySvcDto value) {
        this.createIndividualSewageSvcDto = value;
    }

}
