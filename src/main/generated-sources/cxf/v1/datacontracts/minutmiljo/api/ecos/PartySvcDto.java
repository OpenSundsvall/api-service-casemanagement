
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for PartySvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PartySvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Addresses" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfPartyAddressSvcDto"/&amp;gt;
 *         &amp;lt;element name="Certificates" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfCertificationSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CounterPartCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CustomerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Id" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="NationalIdentificationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartySvcDto", propOrder = {
    "addresses",
    "certificates",
    "counterPartCode",
    "customerNumber",
    "id",
    "nationalIdentificationNumber"
})
@XmlSeeAlso({
    PersonSvcDto.class,
    OrganizationSvcDto.class
})
public class PartySvcDto {

    @XmlElement(name = "Addresses", required = true, nillable = true)
    protected ArrayOfPartyAddressSvcDto addresses;
    @XmlElement(name = "Certificates", nillable = true)
    protected ArrayOfCertificationSvcDto certificates;
    @XmlElement(name = "CounterPartCode", nillable = true)
    protected String counterPartCode;
    @XmlElement(name = "CustomerNumber", nillable = true)
    protected String customerNumber;
    @XmlElement(name = "Id", nillable = true)
    protected String id;
    @XmlElement(name = "NationalIdentificationNumber", nillable = true)
    protected String nationalIdentificationNumber;

    /**
     * Gets the value of the addresses property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPartyAddressSvcDto }
     *     
     */
    public ArrayOfPartyAddressSvcDto getAddresses() {
        return addresses;
    }

    /**
     * Sets the value of the addresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPartyAddressSvcDto }
     *     
     */
    public void setAddresses(ArrayOfPartyAddressSvcDto value) {
        this.addresses = value;
    }

    /**
     * Gets the value of the certificates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCertificationSvcDto }
     *     
     */
    public ArrayOfCertificationSvcDto getCertificates() {
        return certificates;
    }

    /**
     * Sets the value of the certificates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCertificationSvcDto }
     *     
     */
    public void setCertificates(ArrayOfCertificationSvcDto value) {
        this.certificates = value;
    }

    /**
     * Gets the value of the counterPartCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounterPartCode() {
        return counterPartCode;
    }

    /**
     * Sets the value of the counterPartCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounterPartCode(String value) {
        this.counterPartCode = value;
    }

    /**
     * Gets the value of the customerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the value of the customerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerNumber(String value) {
        this.customerNumber = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the nationalIdentificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    /**
     * Sets the value of the nationalIdentificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalIdentificationNumber(String value) {
        this.nationalIdentificationNumber = value;
    }

}
