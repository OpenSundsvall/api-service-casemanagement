
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
 *         &amp;lt;element name="GetInitatorsResult" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfGuidNamePairSvcDto" minOccurs="0"/&amp;gt;
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
    "getInitatorsResult"
})
@XmlRootElement(name = "GetInitatorsResponse")
public class GetInitatorsResponse {

    @XmlElement(name = "GetInitatorsResult", nillable = true)
    protected ArrayOfGuidNamePairSvcDto getInitatorsResult;

    /**
     * Gets the value of the getInitatorsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGuidNamePairSvcDto }
     *     
     */
    public ArrayOfGuidNamePairSvcDto getGetInitatorsResult() {
        return getInitatorsResult;
    }

    /**
     * Sets the value of the getInitatorsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGuidNamePairSvcDto }
     *     
     */
    public void setGetInitatorsResult(ArrayOfGuidNamePairSvcDto value) {
        this.getInitatorsResult = value;
    }

}
