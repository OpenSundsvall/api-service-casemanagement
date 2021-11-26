
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for PartyAddressSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PartyAddressSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="AddressTypes" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfAddressTypeSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CareOfName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PostCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PostalArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="StreetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="StreetNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyAddressSvcDto", propOrder = {
    "addressTypes",
    "careOfName",
    "country",
    "postCode",
    "postalArea",
    "streetName",
    "streetNumber"
})
public class PartyAddressSvcDto {

    @XmlElement(name = "AddressTypes", nillable = true)
    protected ArrayOfAddressTypeSvcDto addressTypes;
    @XmlElement(name = "CareOfName", nillable = true)
    protected String careOfName;
    @XmlElement(name = "Country", nillable = true)
    protected String country;
    @XmlElement(name = "PostCode", nillable = true)
    protected String postCode;
    @XmlElement(name = "PostalArea", nillable = true)
    protected String postalArea;
    @XmlElement(name = "StreetName", nillable = true)
    protected String streetName;
    @XmlElement(name = "StreetNumber", nillable = true)
    protected String streetNumber;

    /**
     * Gets the value of the addressTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAddressTypeSvcDto }
     *     
     */
    public ArrayOfAddressTypeSvcDto getAddressTypes() {
        return addressTypes;
    }

    /**
     * Sets the value of the addressTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAddressTypeSvcDto }
     *     
     */
    public void setAddressTypes(ArrayOfAddressTypeSvcDto value) {
        this.addressTypes = value;
    }

    /**
     * Gets the value of the careOfName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCareOfName() {
        return careOfName;
    }

    /**
     * Sets the value of the careOfName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCareOfName(String value) {
        this.careOfName = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the postCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets the value of the postCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostCode(String value) {
        this.postCode = value;
    }

    /**
     * Gets the value of the postalArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalArea() {
        return postalArea;
    }

    /**
     * Sets the value of the postalArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalArea(String value) {
        this.postalArea = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetName(String value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the streetNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets the value of the streetNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNumber(String value) {
        this.streetNumber = value;
    }

}
