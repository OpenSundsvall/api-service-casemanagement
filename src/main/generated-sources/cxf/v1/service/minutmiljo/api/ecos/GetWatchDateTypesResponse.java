
package v1.service.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import v1.datacontracts.minutmiljo.api.ecos.ArrayOfGetWatchDateTypeSvcDto;


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
 *         &amp;lt;element name="GetWatchDateTypesResult" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfGetWatchDateTypeSvcDto" minOccurs="0"/&amp;gt;
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
    "getWatchDateTypesResult"
})
@XmlRootElement(name = "GetWatchDateTypesResponse")
public class GetWatchDateTypesResponse {

    @XmlElement(name = "GetWatchDateTypesResult", nillable = true)
    protected ArrayOfGetWatchDateTypeSvcDto getWatchDateTypesResult;

    /**
     * Gets the value of the getWatchDateTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGetWatchDateTypeSvcDto }
     *     
     */
    public ArrayOfGetWatchDateTypeSvcDto getGetWatchDateTypesResult() {
        return getWatchDateTypesResult;
    }

    /**
     * Sets the value of the getWatchDateTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGetWatchDateTypeSvcDto }
     *     
     */
    public void setGetWatchDateTypesResult(ArrayOfGetWatchDateTypeSvcDto value) {
        this.getWatchDateTypesResult = value;
    }

}
