
package v1.datacontracts.minutmiljo.api.ecos;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * &lt;p&gt;Java class for WatchDateFilterSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="WatchDateFilterSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FilterSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="DateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DateTimeComparison" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}DateTimeComparison" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="WatchDateTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WatchDateFilterSvcDto", propOrder = {
    "dateTime",
    "dateTimeComparison",
    "watchDateTypeId"
})
public class WatchDateFilterSvcDto
    extends FilterSvcDto
{

    @XmlElement(name = "DateTime", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime dateTime;
    @XmlElement(name = "DateTimeComparison")
    @XmlSchemaType(name = "string")
    protected DateTimeComparison dateTimeComparison;
    @XmlElement(name = "WatchDateTypeId")
    protected String watchDateTypeId;

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateTime(LocalDateTime value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the dateTimeComparison property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeComparison }
     *     
     */
    public DateTimeComparison getDateTimeComparison() {
        return dateTimeComparison;
    }

    /**
     * Sets the value of the dateTimeComparison property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeComparison }
     *     
     */
    public void setDateTimeComparison(DateTimeComparison value) {
        this.dateTimeComparison = value;
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
