
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ExternalCaseSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ExternalCaseSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ExternalCaseNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="ExternalPartyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalCaseSvcDto", propOrder = {
    "externalCaseNumber",
    "externalPartyName"
})
public class ExternalCaseSvcDto {

    @XmlElement(name = "ExternalCaseNumber", required = true, nillable = true)
    protected String externalCaseNumber;
    @XmlElement(name = "ExternalPartyName", nillable = true)
    protected String externalPartyName;

    /**
     * Gets the value of the externalCaseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalCaseNumber() {
        return externalCaseNumber;
    }

    /**
     * Sets the value of the externalCaseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalCaseNumber(String value) {
        this.externalCaseNumber = value;
    }

    /**
     * Gets the value of the externalPartyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalPartyName() {
        return externalPartyName;
    }

    /**
     * Sets the value of the externalPartyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalPartyName(String value) {
        this.externalPartyName = value;
    }

}
