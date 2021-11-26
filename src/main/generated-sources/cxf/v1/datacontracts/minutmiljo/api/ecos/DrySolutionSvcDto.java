
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for DrySolutionSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DrySolutionSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}PurificationStepSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="CompostProductName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DrySolutionCompostTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DrySolutionTypeId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="HasUrineSeparatingToilet" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="NoContOrCompt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="NoLPerContOrCompt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ToiletProductName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Volume" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DrySolutionSvcDto", propOrder = {
    "compostProductName",
    "drySolutionCompostTypeId",
    "drySolutionTypeId",
    "hasUrineSeparatingToilet",
    "noContOrCompt",
    "noLPerContOrCompt",
    "toiletProductName",
    "volume"
})
public class DrySolutionSvcDto
    extends PurificationStepSvcDto
{

    @XmlElement(name = "CompostProductName", nillable = true)
    protected String compostProductName;
    @XmlElement(name = "DrySolutionCompostTypeId", nillable = true)
    protected String drySolutionCompostTypeId;
    @XmlElement(name = "DrySolutionTypeId")
    protected String drySolutionTypeId;
    @XmlElement(name = "HasUrineSeparatingToilet", nillable = true)
    protected Boolean hasUrineSeparatingToilet;
    @XmlElement(name = "NoContOrCompt", nillable = true)
    protected String noContOrCompt;
    @XmlElement(name = "NoLPerContOrCompt", nillable = true)
    protected String noLPerContOrCompt;
    @XmlElement(name = "ToiletProductName", nillable = true)
    protected String toiletProductName;
    @XmlElement(name = "Volume", nillable = true)
    protected Double volume;

    /**
     * Gets the value of the compostProductName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompostProductName() {
        return compostProductName;
    }

    /**
     * Sets the value of the compostProductName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompostProductName(String value) {
        this.compostProductName = value;
    }

    /**
     * Gets the value of the drySolutionCompostTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrySolutionCompostTypeId() {
        return drySolutionCompostTypeId;
    }

    /**
     * Sets the value of the drySolutionCompostTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrySolutionCompostTypeId(String value) {
        this.drySolutionCompostTypeId = value;
    }

    /**
     * Gets the value of the drySolutionTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrySolutionTypeId() {
        return drySolutionTypeId;
    }

    /**
     * Sets the value of the drySolutionTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrySolutionTypeId(String value) {
        this.drySolutionTypeId = value;
    }

    /**
     * Gets the value of the hasUrineSeparatingToilet property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasUrineSeparatingToilet() {
        return hasUrineSeparatingToilet;
    }

    /**
     * Sets the value of the hasUrineSeparatingToilet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasUrineSeparatingToilet(Boolean value) {
        this.hasUrineSeparatingToilet = value;
    }

    /**
     * Gets the value of the noContOrCompt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoContOrCompt() {
        return noContOrCompt;
    }

    /**
     * Sets the value of the noContOrCompt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoContOrCompt(String value) {
        this.noContOrCompt = value;
    }

    /**
     * Gets the value of the noLPerContOrCompt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoLPerContOrCompt() {
        return noLPerContOrCompt;
    }

    /**
     * Sets the value of the noLPerContOrCompt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoLPerContOrCompt(String value) {
        this.noLPerContOrCompt = value;
    }

    /**
     * Gets the value of the toiletProductName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToiletProductName() {
        return toiletProductName;
    }

    /**
     * Sets the value of the toiletProductName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToiletProductName(String value) {
        this.toiletProductName = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVolume(Double value) {
        this.volume = value;
    }

}
