
package se.tekis.servicecontract;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &amp;lt;element name="GetRelateradeArendenByPersOrgNrAndRoleResult" type="{www.tekis.se/ServiceContract}ArrayOfArende1" minOccurs="0"/&amp;gt;
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
    "getRelateradeArendenByPersOrgNrAndRoleResult"
})
@XmlRootElement(name = "GetRelateradeArendenByPersOrgNrAndRoleResponse")
public class GetRelateradeArendenByPersOrgNrAndRoleResponse {

    @XmlElement(name = "GetRelateradeArendenByPersOrgNrAndRoleResult")
    protected ArrayOfArende1 getRelateradeArendenByPersOrgNrAndRoleResult;

    /**
     * Gets the value of the getRelateradeArendenByPersOrgNrAndRoleResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArende1 }
     *     
     */
    public ArrayOfArende1 getGetRelateradeArendenByPersOrgNrAndRoleResult() {
        return getRelateradeArendenByPersOrgNrAndRoleResult;
    }

    /**
     * Sets the value of the getRelateradeArendenByPersOrgNrAndRoleResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArende1 }
     *     
     */
    public void setGetRelateradeArendenByPersOrgNrAndRoleResult(ArrayOfArende1 value) {
        this.getRelateradeArendenByPersOrgNrAndRoleResult = value;
    }

}
