
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for GetContactDetailPathsAndTypesSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="GetContactDetailPathsAndTypesSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ContactPathId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ContactPathName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ContactTypes" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfContactTypeSvcDto" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetContactDetailPathsAndTypesSvcDto", propOrder = {
    "contactPathId",
    "contactPathName",
    "contactTypes"
})
public class GetContactDetailPathsAndTypesSvcDto {

    @XmlElement(name = "ContactPathId")
    protected String contactPathId;
    @XmlElement(name = "ContactPathName", nillable = true)
    protected String contactPathName;
    @XmlElement(name = "ContactTypes", nillable = true)
    protected ArrayOfContactTypeSvcDto contactTypes;

    /**
     * Gets the value of the contactPathId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPathId() {
        return contactPathId;
    }

    /**
     * Sets the value of the contactPathId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPathId(String value) {
        this.contactPathId = value;
    }

    /**
     * Gets the value of the contactPathName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPathName() {
        return contactPathName;
    }

    /**
     * Sets the value of the contactPathName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPathName(String value) {
        this.contactPathName = value;
    }

    /**
     * Gets the value of the contactTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfContactTypeSvcDto }
     *     
     */
    public ArrayOfContactTypeSvcDto getContactTypes() {
        return contactTypes;
    }

    /**
     * Sets the value of the contactTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfContactTypeSvcDto }
     *     
     */
    public void setContactTypes(ArrayOfContactTypeSvcDto value) {
        this.contactTypes = value;
    }

}
