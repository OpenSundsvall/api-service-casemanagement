
package v1.service.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import v1.datacontracts.minutmiljo.api.ecos.ArrayOfGuidNamePairSvcDto;


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
 *         &amp;lt;element name="GetWasteWaterResult" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfGuidNamePairSvcDto" minOccurs="0"/&amp;gt;
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
    "getWasteWaterResult"
})
@XmlRootElement(name = "GetWasteWaterResponse")
public class GetWasteWaterResponse {

    @XmlElement(name = "GetWasteWaterResult", nillable = true)
    protected ArrayOfGuidNamePairSvcDto getWasteWaterResult;

    /**
     * Gets the value of the getWasteWaterResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGuidNamePairSvcDto }
     *     
     */
    public ArrayOfGuidNamePairSvcDto getGetWasteWaterResult() {
        return getWasteWaterResult;
    }

    /**
     * Sets the value of the getWasteWaterResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGuidNamePairSvcDto }
     *     
     */
    public void setGetWasteWaterResult(ArrayOfGuidNamePairSvcDto value) {
        this.getWasteWaterResult = value;
    }

}
