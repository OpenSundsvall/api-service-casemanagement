
package v1.service.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import v1.datacontracts.minutmiljo.api.ecos.PartySvcDto;


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
 *         &amp;lt;element name="GetPartyResult" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}PartySvcDto" minOccurs="0"/&amp;gt;
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
    "getPartyResult"
})
@XmlRootElement(name = "GetPartyResponse")
public class GetPartyResponse {

    @XmlElement(name = "GetPartyResult", nillable = true)
    protected PartySvcDto getPartyResult;

    /**
     * Gets the value of the getPartyResult property.
     * 
     * @return
     *     possible object is
     *     {@link PartySvcDto }
     *     
     */
    public PartySvcDto getGetPartyResult() {
        return getPartyResult;
    }

    /**
     * Sets the value of the getPartyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartySvcDto }
     *     
     */
    public void setGetPartyResult(PartySvcDto value) {
        this.getPartyResult = value;
    }

}
