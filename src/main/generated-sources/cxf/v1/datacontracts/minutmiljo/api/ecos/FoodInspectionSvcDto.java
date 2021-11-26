
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
 * &lt;p&gt;Java class for FoodInspectionSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FoodInspectionSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="CaseNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ControlAreas" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfFoodInspectionResultControlArea" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="InspectionCause" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="InspectionCauseId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="InspectionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Notified" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="OverallApproved" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FoodInspectionSvcDto", propOrder = {
    "caseNumber",
    "controlAreas",
    "inspectionCause",
    "inspectionCauseId",
    "inspectionDate",
    "notified",
    "overallApproved"
})
public class FoodInspectionSvcDto {

    @XmlElement(name = "CaseNumber", nillable = true)
    protected String caseNumber;
    @XmlElement(name = "ControlAreas", nillable = true)
    protected ArrayOfFoodInspectionResultControlArea controlAreas;
    @XmlElement(name = "InspectionCause", nillable = true)
    protected String inspectionCause;
    @XmlElement(name = "InspectionCauseId")
    protected String inspectionCauseId;
    @XmlElement(name = "InspectionDate", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime inspectionDate;
    @XmlElement(name = "Notified")
    protected Boolean notified;
    @XmlElement(name = "OverallApproved", nillable = true)
    protected Boolean overallApproved;

    /**
     * Gets the value of the caseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseNumber() {
        return caseNumber;
    }

    /**
     * Sets the value of the caseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseNumber(String value) {
        this.caseNumber = value;
    }

    /**
     * Gets the value of the controlAreas property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFoodInspectionResultControlArea }
     *     
     */
    public ArrayOfFoodInspectionResultControlArea getControlAreas() {
        return controlAreas;
    }

    /**
     * Sets the value of the controlAreas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFoodInspectionResultControlArea }
     *     
     */
    public void setControlAreas(ArrayOfFoodInspectionResultControlArea value) {
        this.controlAreas = value;
    }

    /**
     * Gets the value of the inspectionCause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspectionCause() {
        return inspectionCause;
    }

    /**
     * Sets the value of the inspectionCause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspectionCause(String value) {
        this.inspectionCause = value;
    }

    /**
     * Gets the value of the inspectionCauseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspectionCauseId() {
        return inspectionCauseId;
    }

    /**
     * Sets the value of the inspectionCauseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspectionCauseId(String value) {
        this.inspectionCauseId = value;
    }

    /**
     * Gets the value of the inspectionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getInspectionDate() {
        return inspectionDate;
    }

    /**
     * Sets the value of the inspectionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspectionDate(LocalDateTime value) {
        this.inspectionDate = value;
    }

    /**
     * Gets the value of the notified property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotified() {
        return notified;
    }

    /**
     * Sets the value of the notified property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotified(Boolean value) {
        this.notified = value;
    }

    /**
     * Gets the value of the overallApproved property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOverallApproved() {
        return overallApproved;
    }

    /**
     * Sets the value of the overallApproved property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOverallApproved(Boolean value) {
        this.overallApproved = value;
    }

}
