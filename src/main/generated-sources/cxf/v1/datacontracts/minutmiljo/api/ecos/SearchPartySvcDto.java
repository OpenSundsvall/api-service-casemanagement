
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for SearchPartySvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="SearchPartySvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ExactOrganizationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="OrganizationIdentificationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PersonalIdentificationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchPartySvcDto", propOrder = {
    "exactOrganizationName",
    "name",
    "organizationIdentificationNumber",
    "personalIdentificationNumber"
})
public class SearchPartySvcDto {

    @XmlElement(name = "ExactOrganizationName", nillable = true)
    protected String exactOrganizationName;
    @XmlElement(name = "Name", nillable = true)
    protected String name;
    @XmlElement(name = "OrganizationIdentificationNumber", nillable = true)
    protected String organizationIdentificationNumber;
    @XmlElement(name = "PersonalIdentificationNumber", nillable = true)
    protected String personalIdentificationNumber;

    /**
     * Gets the value of the exactOrganizationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExactOrganizationName() {
        return exactOrganizationName;
    }

    /**
     * Sets the value of the exactOrganizationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExactOrganizationName(String value) {
        this.exactOrganizationName = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the organizationIdentificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationIdentificationNumber() {
        return organizationIdentificationNumber;
    }

    /**
     * Sets the value of the organizationIdentificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationIdentificationNumber(String value) {
        this.organizationIdentificationNumber = value;
    }

    /**
     * Gets the value of the personalIdentificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }

    /**
     * Sets the value of the personalIdentificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalIdentificationNumber(String value) {
        this.personalIdentificationNumber = value;
    }

}
