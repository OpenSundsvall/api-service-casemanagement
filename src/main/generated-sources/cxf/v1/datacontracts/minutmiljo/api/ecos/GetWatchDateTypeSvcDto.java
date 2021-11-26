
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for GetWatchDateTypeSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="GetWatchDateTypeSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="CanBeUsedForCreateWatchDate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="WatchDateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="WatchDateTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetWatchDateTypeSvcDto", propOrder = {
    "canBeUsedForCreateWatchDate",
    "watchDateType",
    "watchDateTypeId"
})
public class GetWatchDateTypeSvcDto {

    @XmlElement(name = "CanBeUsedForCreateWatchDate")
    protected Boolean canBeUsedForCreateWatchDate;
    @XmlElement(name = "WatchDateType", nillable = true)
    protected String watchDateType;
    @XmlElement(name = "WatchDateTypeId")
    protected String watchDateTypeId;

    /**
     * Gets the value of the canBeUsedForCreateWatchDate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanBeUsedForCreateWatchDate() {
        return canBeUsedForCreateWatchDate;
    }

    /**
     * Sets the value of the canBeUsedForCreateWatchDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanBeUsedForCreateWatchDate(Boolean value) {
        this.canBeUsedForCreateWatchDate = value;
    }

    /**
     * Gets the value of the watchDateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWatchDateType() {
        return watchDateType;
    }

    /**
     * Sets the value of the watchDateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWatchDateType(String value) {
        this.watchDateType = value;
    }

    /**
     * Gets the value of the watchDateTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWatchDateTypeId() {
        return watchDateTypeId;
    }

    /**
     * Sets the value of the watchDateTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWatchDateTypeId(String value) {
        this.watchDateTypeId = value;
    }

}
