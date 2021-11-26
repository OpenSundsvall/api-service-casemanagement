
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
 * &lt;p&gt;Java class for CreateCaseWatchDateSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CreateCaseWatchDateSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="CaseId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *         &amp;lt;element name="NotificationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="WatchDateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&amp;gt;
 *         &amp;lt;element name="WatchDateNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="WatchDateTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *         &amp;lt;element name="WatcherId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateCaseWatchDateSvcDto", propOrder = {
    "caseId",
    "notificationDate",
    "watchDateDate",
    "watchDateNote",
    "watchDateTypeId",
    "watcherId"
})
public class CreateCaseWatchDateSvcDto {

    @XmlElement(name = "CaseId", required = true)
    protected String caseId;
    @XmlElement(name = "NotificationDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime notificationDate;
    @XmlElement(name = "WatchDateDate", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime watchDateDate;
    @XmlElement(name = "WatchDateNote", nillable = true)
    protected String watchDateNote;
    @XmlElement(name = "WatchDateTypeId", required = true)
    protected String watchDateTypeId;
    @XmlElement(name = "WatcherId", required = true)
    protected String watcherId;

    /**
     * Gets the value of the caseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * Sets the value of the caseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseId(String value) {
        this.caseId = value;
    }

    /**
     * Gets the value of the notificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getNotificationDate() {
        return notificationDate;
    }

    /**
     * Sets the value of the notificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationDate(LocalDateTime value) {
        this.notificationDate = value;
    }

    /**
     * Gets the value of the watchDateDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getWatchDateDate() {
        return watchDateDate;
    }

    /**
     * Sets the value of the watchDateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWatchDateDate(LocalDateTime value) {
        this.watchDateDate = value;
    }

    /**
     * Gets the value of the watchDateNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWatchDateNote() {
        return watchDateNote;
    }

    /**
     * Sets the value of the watchDateNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWatchDateNote(String value) {
        this.watchDateNote = value;
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

    /**
     * Gets the value of the watcherId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWatcherId() {
        return watcherId;
    }

    /**
     * Sets the value of the watcherId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWatcherId(String value) {
        this.watcherId = value;
    }

}
