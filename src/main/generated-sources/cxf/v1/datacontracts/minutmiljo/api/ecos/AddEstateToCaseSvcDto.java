
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for AddEstateToCaseSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="AddEstateToCaseSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="AddressId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="BuildingId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CaseId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *         &amp;lt;element name="Fnr" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddEstateToCaseSvcDto", propOrder = {
    "addressId",
    "buildingId",
    "caseId",
    "fnr"
})
public class AddEstateToCaseSvcDto {

    @XmlElement(name = "AddressId", nillable = true)
    protected Integer addressId;
    @XmlElement(name = "BuildingId", nillable = true)
    protected Integer buildingId;
    @XmlElement(name = "CaseId", required = true)
    protected String caseId;
    @XmlElement(name = "Fnr")
    protected int fnr;

    /**
     * Gets the value of the addressId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * Sets the value of the addressId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAddressId(Integer value) {
        this.addressId = value;
    }

    /**
     * Gets the value of the buildingId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBuildingId() {
        return buildingId;
    }

    /**
     * Sets the value of the buildingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBuildingId(Integer value) {
        this.buildingId = value;
    }

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
     * Gets the value of the fnr property.
     * 
     */
    public int getFnr() {
        return fnr;
    }

    /**
     * Sets the value of the fnr property.
     * 
     */
    public void setFnr(int value) {
        this.fnr = value;
    }

}
