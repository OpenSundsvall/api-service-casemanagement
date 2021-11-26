
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for DiaryPlanSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DiaryPlanSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Diarieplan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DiarieplanBeteckning" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="DiarieplanId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiaryPlanSvcDto", propOrder = {
    "diarieplan",
    "diarieplanBeteckning",
    "diarieplanId"
})
public class DiaryPlanSvcDto {

    @XmlElement(name = "Diarieplan", nillable = true)
    protected String diarieplan;
    @XmlElement(name = "DiarieplanBeteckning", nillable = true)
    protected String diarieplanBeteckning;
    @XmlElement(name = "DiarieplanId")
    protected String diarieplanId;

    /**
     * Gets the value of the diarieplan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiarieplan() {
        return diarieplan;
    }

    /**
     * Sets the value of the diarieplan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiarieplan(String value) {
        this.diarieplan = value;
    }

    /**
     * Gets the value of the diarieplanBeteckning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiarieplanBeteckning() {
        return diarieplanBeteckning;
    }

    /**
     * Sets the value of the diarieplanBeteckning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiarieplanBeteckning(String value) {
        this.diarieplanBeteckning = value;
    }

    /**
     * Gets the value of the diarieplanId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiarieplanId() {
        return diarieplanId;
    }

    /**
     * Sets the value of the diarieplanId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiarieplanId(String value) {
        this.diarieplanId = value;
    }

}
