
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
 * &lt;p&gt;Java class for FacilityFoodInspectionFilterSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FacilityFoodInspectionFilterSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FacilityFilterSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="InspectionHasRemarks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="InspectionOverallApproved" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="MinimumInspectionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityFoodInspectionFilterSvcDto", propOrder = {
    "inspectionHasRemarks",
    "inspectionOverallApproved",
    "minimumInspectionDate"
})
public class FacilityFoodInspectionFilterSvcDto
    extends FacilityFilterSvcDto
{

    @XmlElement(name = "InspectionHasRemarks", nillable = true)
    protected Boolean inspectionHasRemarks;
    @XmlElement(name = "InspectionOverallApproved", nillable = true)
    protected Boolean inspectionOverallApproved;
    @XmlElement(name = "MinimumInspectionDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime minimumInspectionDate;

    /**
     * Gets the value of the inspectionHasRemarks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInspectionHasRemarks() {
        return inspectionHasRemarks;
    }

    /**
     * Sets the value of the inspectionHasRemarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInspectionHasRemarks(Boolean value) {
        this.inspectionHasRemarks = value;
    }

    /**
     * Gets the value of the inspectionOverallApproved property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInspectionOverallApproved() {
        return inspectionOverallApproved;
    }

    /**
     * Sets the value of the inspectionOverallApproved property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInspectionOverallApproved(Boolean value) {
        this.inspectionOverallApproved = value;
    }

    /**
     * Gets the value of the minimumInspectionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getMinimumInspectionDate() {
        return minimumInspectionDate;
    }

    /**
     * Sets the value of the minimumInspectionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinimumInspectionDate(LocalDateTime value) {
        this.minimumInspectionDate = value;
    }

}
