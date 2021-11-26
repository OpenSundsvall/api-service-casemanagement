
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for InfiltrationPlantSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="InfiltrationPlantSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}PurificationStepSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Area" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Elevated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IsModuleSystem" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Reinforced" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SpreadLinesCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SpreadLinesLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfiltrationPlantSvcDto", propOrder = {
    "area",
    "elevated",
    "isModuleSystem",
    "reinforced",
    "spreadLinesCount",
    "spreadLinesLength"
})
public class InfiltrationPlantSvcDto
    extends PurificationStepSvcDto
{

    @XmlElement(name = "Area", nillable = true)
    protected Integer area;
    @XmlElement(name = "Elevated", nillable = true)
    protected Boolean elevated;
    @XmlElement(name = "IsModuleSystem", nillable = true)
    protected Boolean isModuleSystem;
    @XmlElement(name = "Reinforced", nillable = true)
    protected Boolean reinforced;
    @XmlElement(name = "SpreadLinesCount", nillable = true)
    protected Integer spreadLinesCount;
    @XmlElement(name = "SpreadLinesLength", nillable = true)
    protected Integer spreadLinesLength;

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
     * Gets the value of the elevated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isElevated() {
        return elevated;
    }

    /**
     * Sets the value of the elevated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setElevated(Boolean value) {
        this.elevated = value;
    }

    /**
     * Gets the value of the isModuleSystem property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsModuleSystem() {
        return isModuleSystem;
    }

    /**
     * Sets the value of the isModuleSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsModuleSystem(Boolean value) {
        this.isModuleSystem = value;
    }

    /**
     * Gets the value of the reinforced property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReinforced() {
        return reinforced;
    }

    /**
     * Sets the value of the reinforced property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReinforced(Boolean value) {
        this.reinforced = value;
    }

    /**
     * Gets the value of the spreadLinesCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSpreadLinesCount() {
        return spreadLinesCount;
    }

    /**
     * Sets the value of the spreadLinesCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSpreadLinesCount(Integer value) {
        this.spreadLinesCount = value;
    }

    /**
     * Gets the value of the spreadLinesLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSpreadLinesLength() {
        return spreadLinesLength;
    }

    /**
     * Sets the value of the spreadLinesLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSpreadLinesLength(Integer value) {
        this.spreadLinesLength = value;
    }

}
