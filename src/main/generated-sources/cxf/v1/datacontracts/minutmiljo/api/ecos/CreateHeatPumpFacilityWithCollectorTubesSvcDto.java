
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CreateHeatPumpFacilityWithCollectorTubesSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CreateHeatPumpFacilityWithCollectorTubesSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}CreateHeatPumpFacilityWithHeatTransferFluidSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="HeatCollectorTubes" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfHeatCollectorTubeSvcDto" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateHeatPumpFacilityWithCollectorTubesSvcDto", propOrder = {
    "heatCollectorTubes"
})
@XmlSeeAlso({
    CreateSoilHeatingFacilitySvcDto.class,
    CreateMarineHeatingFacilitySvcDto.class
})
public class CreateHeatPumpFacilityWithCollectorTubesSvcDto
    extends CreateHeatPumpFacilityWithHeatTransferFluidSvcDto
{

    @XmlElement(name = "HeatCollectorTubes", nillable = true)
    protected ArrayOfHeatCollectorTubeSvcDto heatCollectorTubes;

    /**
     * Gets the value of the heatCollectorTubes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHeatCollectorTubeSvcDto }
     *     
     */
    public ArrayOfHeatCollectorTubeSvcDto getHeatCollectorTubes() {
        return heatCollectorTubes;
    }

    /**
     * Sets the value of the heatCollectorTubes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHeatCollectorTubeSvcDto }
     *     
     */
    public void setHeatCollectorTubes(ArrayOfHeatCollectorTubeSvcDto value) {
        this.heatCollectorTubes = value;
    }

}
