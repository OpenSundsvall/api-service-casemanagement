
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for BiologicalStepSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="BiologicalStepSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}PurificationStepSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Area" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="BiologicalStepTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BiologicalStepSvcDto", propOrder = {
    "area",
    "biologicalStepTypeId"
})
public class BiologicalStepSvcDto
    extends PurificationStepSvcDto
{

    @XmlElement(name = "Area", nillable = true)
    protected Integer area;
    @XmlElement(name = "BiologicalStepTypeId")
    protected String biologicalStepTypeId;

    /**
     * Gets the value of the area property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setArea(Integer value) {
        this.area = value;
    }

    /**
     * Gets the value of the biologicalStepTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiologicalStepTypeId() {
        return biologicalStepTypeId;
    }

    /**
     * Sets the value of the biologicalStepTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiologicalStepTypeId(String value) {
        this.biologicalStepTypeId = value;
    }

}
