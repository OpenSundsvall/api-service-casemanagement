
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CreateGeothermalHeatingFacilitySvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CreateGeothermalHeatingFacilitySvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}CreateHeatPumpFacilityWithHeatTransferFluidSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Boreholes" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfBoreholeSvcDto" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateGeothermalHeatingFacilitySvcDto", propOrder = {
    "boreholes"
})
public class CreateGeothermalHeatingFacilitySvcDto
    extends CreateHeatPumpFacilityWithHeatTransferFluidSvcDto
{

    @XmlElement(name = "Boreholes", nillable = true)
    protected ArrayOfBoreholeSvcDto boreholes;

    /**
     * Gets the value of the boreholes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBoreholeSvcDto }
     *     
     */
    public ArrayOfBoreholeSvcDto getBoreholes() {
        return boreholes;
    }

    /**
     * Sets the value of the boreholes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBoreholeSvcDto }
     *     
     */
    public void setBoreholes(ArrayOfBoreholeSvcDto value) {
        this.boreholes = value;
    }

}
