
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CreateHeatPumpFacilityWithHeatTransferFluidSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CreateHeatPumpFacilityWithHeatTransferFluidSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}CreateHeatPumpFacilitySvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Capacity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="HeatTransferFluidId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateHeatPumpFacilityWithHeatTransferFluidSvcDto", propOrder = {
    "capacity",
    "heatTransferFluidId"
})
@XmlSeeAlso({
    CreateGeothermalHeatingFacilitySvcDto.class,
    CreateHeatPumpFacilityWithCollectorTubesSvcDto.class
})
public class CreateHeatPumpFacilityWithHeatTransferFluidSvcDto
    extends CreateHeatPumpFacilitySvcDto
{

    @XmlElement(name = "Capacity", nillable = true)
    protected Double capacity;
    @XmlElement(name = "HeatTransferFluidId", nillable = true)
    protected String heatTransferFluidId;

    /**
     * Gets the value of the capacity property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCapacity(Double value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the heatTransferFluidId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeatTransferFluidId() {
        return heatTransferFluidId;
    }

    /**
     * Sets the value of the heatTransferFluidId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeatTransferFluidId(String value) {
        this.heatTransferFluidId = value;
    }

}
