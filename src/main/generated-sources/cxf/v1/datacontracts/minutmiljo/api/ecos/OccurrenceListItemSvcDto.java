
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
 * &lt;p&gt;Java class for OccurrenceListItemSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="OccurrenceListItemSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Documents" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfDocumentListItemSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="OccurrenceDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="OccurrenceDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="OccurrenceId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="OccurrenceKindId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="OccurrenceTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OccurrenceListItemSvcDto", propOrder = {
    "documents",
    "occurrenceDate",
    "occurrenceDescription",
    "occurrenceId",
    "occurrenceKindId",
    "occurrenceTypeId"
})
public class OccurrenceListItemSvcDto {

    @XmlElement(name = "Documents", nillable = true)
    protected ArrayOfDocumentListItemSvcDto documents;
    @XmlElement(name = "OccurrenceDate", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime occurrenceDate;
    @XmlElement(name = "OccurrenceDescription", nillable = true)
    protected String occurrenceDescription;
    @XmlElement(name = "OccurrenceId", nillable = true)
    protected String occurrenceId;
    @XmlElement(name = "OccurrenceKindId")
    protected String occurrenceKindId;
    @XmlElement(name = "OccurrenceTypeId")
    protected String occurrenceTypeId;

    /**
     * Gets the value of the documents property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDocumentListItemSvcDto }
     *     
     */
    public ArrayOfDocumentListItemSvcDto getDocuments() {
        return documents;
    }

    /**
     * Sets the value of the documents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDocumentListItemSvcDto }
     *     
     */
    public void setDocuments(ArrayOfDocumentListItemSvcDto value) {
        this.documents = value;
    }

    /**
     * Gets the value of the occurrenceDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getOccurrenceDate() {
        return occurrenceDate;
    }

    /**
     * Sets the value of the occurrenceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurrenceDate(LocalDateTime value) {
        this.occurrenceDate = value;
    }

    /**
     * Gets the value of the occurrenceDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccurrenceDescription() {
        return occurrenceDescription;
    }

    /**
     * Sets the value of the occurrenceDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurrenceDescription(String value) {
        this.occurrenceDescription = value;
    }

    /**
     * Gets the value of the occurrenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccurrenceId() {
        return occurrenceId;
    }

    /**
     * Sets the value of the occurrenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurrenceId(String value) {
        this.occurrenceId = value;
    }

    /**
     * Gets the value of the occurrenceKindId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccurrenceKindId() {
        return occurrenceKindId;
    }

    /**
     * Sets the value of the occurrenceKindId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurrenceKindId(String value) {
        this.occurrenceKindId = value;
    }

    /**
     * Gets the value of the occurrenceTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccurrenceTypeId() {
        return occurrenceTypeId;
    }

    /**
     * Sets the value of the occurrenceTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurrenceTypeId(String value) {
        this.occurrenceTypeId = value;
    }

}
