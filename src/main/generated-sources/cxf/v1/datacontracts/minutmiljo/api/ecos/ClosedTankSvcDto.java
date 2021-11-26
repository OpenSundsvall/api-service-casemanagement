
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ClosedTankSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ClosedTankSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}PurificationStepSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="EmptyingInterval" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="HasCeMarking" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Volume" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClosedTankSvcDto", propOrder = {
    "emptyingInterval",
    "hasCeMarking",
    "volume"
})
public class ClosedTankSvcDto
    extends PurificationStepSvcDto
{

    @XmlElement(name = "EmptyingInterval", nillable = true)
    protected Integer emptyingInterval;
    @XmlElement(name = "HasCeMarking", nillable = true)
    protected Boolean hasCeMarking;
    @XmlElement(name = "Volume", nillable = true)
    protected Double volume;

    /**
     * Gets the value of the emptyingInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEmptyingInterval() {
        return emptyingInterval;
    }

    /**
     * Sets the value of the emptyingInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEmptyingInterval(Integer value) {
        this.emptyingInterval = value;
    }

    /**
     * Gets the value of the hasCeMarking property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasCeMarking() {
        return hasCeMarking;
    }

    /**
     * Sets the value of the hasCeMarking property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasCeMarking(Boolean value) {
        this.hasCeMarking = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVolume(Double value) {
        this.volume = value;
    }

}
