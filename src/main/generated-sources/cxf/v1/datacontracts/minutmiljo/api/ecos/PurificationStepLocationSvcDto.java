
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for PurificationStepLocationSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PurificationStepLocationSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Estate" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}EstateSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Location" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}LocationSvcDto"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurificationStepLocationSvcDto", propOrder = {
    "estate",
    "location"
})
public class PurificationStepLocationSvcDto {

    @XmlElement(name = "Estate", nillable = true)
    protected EstateSvcDto estate;
    @XmlElement(name = "Location", required = true, nillable = true)
    protected LocationSvcDto location;

    /**
     * Gets the value of the estate property.
     * 
     * @return
     *     possible object is
     *     {@link EstateSvcDto }
     *     
     */
    public EstateSvcDto getEstate() {
        return estate;
    }

    /**
     * Sets the value of the estate property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstateSvcDto }
     *     
     */
    public void setEstate(EstateSvcDto value) {
        this.estate = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationSvcDto }
     *     
     */
    public LocationSvcDto getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationSvcDto }
     *     
     */
    public void setLocation(LocationSvcDto value) {
        this.location = value;
    }

}
