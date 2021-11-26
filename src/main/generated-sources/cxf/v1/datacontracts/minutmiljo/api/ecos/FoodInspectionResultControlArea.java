
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for FoodInspectionResultControlArea complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FoodInspectionResultControlArea"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ControlAreaNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ControlAreaTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="HasRemarks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FoodInspectionResultControlArea", propOrder = {
    "controlAreaNumber",
    "controlAreaTitle",
    "hasRemarks"
})
public class FoodInspectionResultControlArea {

    @XmlElement(name = "ControlAreaNumber", nillable = true)
    protected String controlAreaNumber;
    @XmlElement(name = "ControlAreaTitle", nillable = true)
    protected String controlAreaTitle;
    @XmlElement(name = "HasRemarks")
    protected Boolean hasRemarks;

    /**
     * Gets the value of the controlAreaNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlAreaNumber() {
        return controlAreaNumber;
    }

    /**
     * Sets the value of the controlAreaNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlAreaNumber(String value) {
        this.controlAreaNumber = value;
    }

    /**
     * Gets the value of the controlAreaTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlAreaTitle() {
        return controlAreaTitle;
    }

    /**
     * Sets the value of the controlAreaTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlAreaTitle(String value) {
        this.controlAreaTitle = value;
    }

    /**
     * Gets the value of the hasRemarks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasRemarks() {
        return hasRemarks;
    }

    /**
     * Sets the value of the hasRemarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasRemarks(Boolean value) {
        this.hasRemarks = value;
    }

}
