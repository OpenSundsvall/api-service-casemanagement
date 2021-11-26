
package v1.service.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import v1.datacontracts.minutmiljo.api.ecos.ArrayOfConnectedRoleSvcDto;


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
 *         &amp;lt;element name="GetFacilityPartyRolesResult" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfConnectedRoleSvcDto" minOccurs="0"/&amp;gt;
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
    "getFacilityPartyRolesResult"
})
@XmlRootElement(name = "GetFacilityPartyRolesResponse")
public class GetFacilityPartyRolesResponse {

    @XmlElement(name = "GetFacilityPartyRolesResult", nillable = true)
    protected ArrayOfConnectedRoleSvcDto getFacilityPartyRolesResult;

    /**
     * Gets the value of the getFacilityPartyRolesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfConnectedRoleSvcDto }
     *     
     */
    public ArrayOfConnectedRoleSvcDto getGetFacilityPartyRolesResult() {
        return getFacilityPartyRolesResult;
    }

    /**
     * Sets the value of the getFacilityPartyRolesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfConnectedRoleSvcDto }
     *     
     */
    public void setGetFacilityPartyRolesResult(ArrayOfConnectedRoleSvcDto value) {
        this.getFacilityPartyRolesResult = value;
    }

}
