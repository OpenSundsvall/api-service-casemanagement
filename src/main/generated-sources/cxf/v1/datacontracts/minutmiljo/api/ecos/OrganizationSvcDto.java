
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for OrganizationSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="OrganizationSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}PartySvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ContactInfo" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfContactInfoSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IsInternalCustomer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IsMainOffice" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="OrganizationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Webpage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IsForeignIdentificationNumber" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationSvcDto", propOrder = {
    "contactInfo",
    "isInternalCustomer",
    "isMainOffice",
    "organizationName",
    "webpage",
    "isForeignIdentificationNumber"
})
public class OrganizationSvcDto
    extends PartySvcDto
{

    @XmlElement(name = "ContactInfo", nillable = true)
    protected ArrayOfContactInfoSvcDto contactInfo;
    @XmlElement(name = "IsInternalCustomer")
    protected Boolean isInternalCustomer;
    @XmlElement(name = "IsMainOffice")
    protected Boolean isMainOffice;
    @XmlElement(name = "OrganizationName", nillable = true)
    protected String organizationName;
    @XmlElement(name = "Webpage", nillable = true)
    protected String webpage;
    @XmlElement(name = "IsForeignIdentificationNumber")
    protected Boolean isForeignIdentificationNumber;

    /**
     * Gets the value of the contactInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfContactInfoSvcDto }
     *     
     */
    public ArrayOfContactInfoSvcDto getContactInfo() {
        return contactInfo;
    }

    /**
     * Sets the value of the contactInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfContactInfoSvcDto }
     *     
     */
    public void setContactInfo(ArrayOfContactInfoSvcDto value) {
        this.contactInfo = value;
    }

    /**
     * Gets the value of the isInternalCustomer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsInternalCustomer() {
        return isInternalCustomer;
    }

    /**
     * Sets the value of the isInternalCustomer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsInternalCustomer(Boolean value) {
        this.isInternalCustomer = value;
    }

    /**
     * Gets the value of the isMainOffice property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsMainOffice() {
        return isMainOffice;
    }

    /**
     * Sets the value of the isMainOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsMainOffice(Boolean value) {
        this.isMainOffice = value;
    }

    /**
     * Gets the value of the organizationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Sets the value of the organizationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationName(String value) {
        this.organizationName = value;
    }

    /**
     * Gets the value of the webpage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebpage() {
        return webpage;
    }

    /**
     * Sets the value of the webpage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebpage(String value) {
        this.webpage = value;
    }

    /**
     * Gets the value of the isForeignIdentificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsForeignIdentificationNumber() {
        return isForeignIdentificationNumber;
    }

    /**
     * Sets the value of the isForeignIdentificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsForeignIdentificationNumber(Boolean value) {
        this.isForeignIdentificationNumber = value;
    }

}
