
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for RefrigerantUnitSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RefrigerantUnitSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="FillingQuantityKg" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="HasLeakageWarning" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="InstallationYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IsHermeticallySealed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="RefrigerantId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Usage" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefrigerantUnitSvcDto", propOrder = {
    "fillingQuantityKg",
    "hasLeakageWarning",
    "installationYear",
    "isHermeticallySealed",
    "name",
    "refrigerantId",
    "usage"
})
public class RefrigerantUnitSvcDto {

    @XmlElement(name = "FillingQuantityKg")
    protected Double fillingQuantityKg;
    @XmlElement(name = "HasLeakageWarning", nillable = true)
    protected Boolean hasLeakageWarning;
    @XmlElement(name = "InstallationYear", nillable = true)
    protected Integer installationYear;
    @XmlElement(name = "IsHermeticallySealed", nillable = true)
    protected Boolean isHermeticallySealed;
    @XmlElement(name = "Name", nillable = true)
    protected String name;
    @XmlElement(name = "RefrigerantId")
    protected String refrigerantId;
    @XmlElement(name = "Usage", nillable = true)
    protected String usage;

    /**
     * Gets the value of the fillingQuantityKg property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFillingQuantityKg() {
        return fillingQuantityKg;
    }

    /**
     * Sets the value of the fillingQuantityKg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFillingQuantityKg(Double value) {
        this.fillingQuantityKg = value;
    }

    /**
     * Gets the value of the hasLeakageWarning property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasLeakageWarning() {
        return hasLeakageWarning;
    }

    /**
     * Sets the value of the hasLeakageWarning property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasLeakageWarning(Boolean value) {
        this.hasLeakageWarning = value;
    }

    /**
     * Gets the value of the installationYear property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInstallationYear() {
        return installationYear;
    }

    /**
     * Sets the value of the installationYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInstallationYear(Integer value) {
        this.installationYear = value;
    }

    /**
     * Gets the value of the isHermeticallySealed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsHermeticallySealed() {
        return isHermeticallySealed;
    }

    /**
     * Sets the value of the isHermeticallySealed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsHermeticallySealed(Boolean value) {
        this.isHermeticallySealed = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the refrigerantId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefrigerantId() {
        return refrigerantId;
    }

    /**
     * Sets the value of the refrigerantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefrigerantId(String value) {
        this.refrigerantId = value;
    }

    /**
     * Gets the value of the usage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Sets the value of the usage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsage(String value) {
        this.usage = value;
    }

}
