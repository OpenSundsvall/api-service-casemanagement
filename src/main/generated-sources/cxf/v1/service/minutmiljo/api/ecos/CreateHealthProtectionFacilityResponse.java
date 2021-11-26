
package v1.service.minutmiljo.api.ecos;

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
 *         &amp;lt;element name="CreateHealthProtectionFacilityResult" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
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
    "createHealthProtectionFacilityResult"
})
@XmlRootElement(name = "CreateHealthProtectionFacilityResponse")
public class CreateHealthProtectionFacilityResponse {

    @XmlElement(name = "CreateHealthProtectionFacilityResult", nillable = true)
    protected String createHealthProtectionFacilityResult;

    /**
     * Gets the value of the createHealthProtectionFacilityResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateHealthProtectionFacilityResult() {
        return createHealthProtectionFacilityResult;
    }

    /**
     * Sets the value of the createHealthProtectionFacilityResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateHealthProtectionFacilityResult(String value) {
        this.createHealthProtectionFacilityResult = value;
    }

}
