
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
 *         &amp;lt;element name="AddEstateToCaseResult" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
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
    "addEstateToCaseResult"
})
@XmlRootElement(name = "AddEstateToCaseResponse")
public class AddEstateToCaseResponse {

    @XmlElement(name = "AddEstateToCaseResult", nillable = true)
    protected String addEstateToCaseResult;

    /**
     * Gets the value of the addEstateToCaseResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddEstateToCaseResult() {
        return addEstateToCaseResult;
    }

    /**
     * Sets the value of the addEstateToCaseResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddEstateToCaseResult(String value) {
        this.addEstateToCaseResult = value;
    }

}
