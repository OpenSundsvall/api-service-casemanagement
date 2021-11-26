
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ContactInfoItemSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ContactInfoItemSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ContactDetailId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ContactDetailTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *         &amp;lt;element name="ContactPathId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *         &amp;lt;element name="Note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactInfoItemSvcDto", propOrder = {
    "contactDetailId",
    "contactDetailTypeId",
    "contactPathId",
    "note",
    "value"
})
public class ContactInfoItemSvcDto {

    @XmlElement(name = "ContactDetailId", nillable = true)
    protected String contactDetailId;
    @XmlElement(name = "ContactDetailTypeId", required = true)
    protected String contactDetailTypeId;
    @XmlElement(name = "ContactPathId", required = true)
    protected String contactPathId;
    @XmlElement(name = "Note", nillable = true)
    protected String note;
    @XmlElement(name = "Value", required = true, nillable = true)
    protected String value;

    /**
     * Gets the value of the contactDetailId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactDetailId() {
        return contactDetailId;
    }

    /**
     * Sets the value of the contactDetailId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactDetailId(String value) {
        this.contactDetailId = value;
    }

    /**
     * Gets the value of the contactDetailTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactDetailTypeId() {
        return contactDetailTypeId;
    }

    /**
     * Sets the value of the contactDetailTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactDetailTypeId(String value) {
        this.contactDetailTypeId = value;
    }

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
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
