
package v1.datacontracts.minutmiljo.api.ecos;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * &lt;p&gt;Java class for PurificationStepSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PurificationStepSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="HasOverflowAlarm" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="InstallationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="LifeTime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PersonCapacity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PurificationStepFacilityStatusId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PurificationStepLocation" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}PurificationStepLocationSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="StepNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurificationStepSvcDto", propOrder = {
    "hasOverflowAlarm",
    "installationDate",
    "lifeTime",
    "personCapacity",
    "purificationStepFacilityStatusId",
    "purificationStepLocation",
    "stepNumber"
})
@XmlSeeAlso({
    SepticTankSvcDto.class,
    InfiltrationPlantSvcDto.class,
    ClosedTankSvcDto.class,
    DrySolutionSvcDto.class,
    MiniSewageSvcDto.class,
    FilterBedSvcDto.class,
    SandFilterSvcDto.class,
    BiologicalStepSvcDto.class,
    PhosphorusTrapSvcDto.class,
    ChemicalPretreatmentSvcDto.class
})
public class PurificationStepSvcDto {

    @XmlElement(name = "HasOverflowAlarm", nillable = true)
    protected Boolean hasOverflowAlarm;
    @XmlElement(name = "InstallationDate", type = String.class, nillable = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime installationDate;
    @XmlElement(name = "LifeTime", nillable = true)
    protected Integer lifeTime;
    @XmlElement(name = "PersonCapacity", nillable = true)
    protected Integer personCapacity;
    @XmlElement(name = "PurificationStepFacilityStatusId", nillable = true)
    protected String purificationStepFacilityStatusId;
    @XmlElement(name = "PurificationStepLocation", nillable = true)
    protected PurificationStepLocationSvcDto purificationStepLocation;
    @XmlElement(name = "StepNumber")
    protected Integer stepNumber;

    /**
     * Gets the value of the hasOverflowAlarm property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasOverflowAlarm() {
        return hasOverflowAlarm;
    }

    /**
     * Sets the value of the hasOverflowAlarm property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasOverflowAlarm(Boolean value) {
        this.hasOverflowAlarm = value;
    }

    /**
     * Gets the value of the installationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDateTime getInstallationDate() {
        return installationDate;
    }

    /**
     * Sets the value of the installationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstallationDate(LocalDateTime value) {
        this.installationDate = value;
    }

    /**
     * Gets the value of the lifeTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLifeTime() {
        return lifeTime;
    }

    /**
     * Sets the value of the lifeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLifeTime(Integer value) {
        this.lifeTime = value;
    }

    /**
     * Gets the value of the personCapacity property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPersonCapacity() {
        return personCapacity;
    }

    /**
     * Sets the value of the personCapacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPersonCapacity(Integer value) {
        this.personCapacity = value;
    }

    /**
     * Gets the value of the purificationStepFacilityStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurificationStepFacilityStatusId() {
        return purificationStepFacilityStatusId;
    }

    /**
     * Sets the value of the purificationStepFacilityStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurificationStepFacilityStatusId(String value) {
        this.purificationStepFacilityStatusId = value;
    }

    /**
     * Gets the value of the purificationStepLocation property.
     * 
     * @return
     *     possible object is
     *     {@link PurificationStepLocationSvcDto }
     *     
     */
    public PurificationStepLocationSvcDto getPurificationStepLocation() {
        return purificationStepLocation;
    }

    /**
     * Sets the value of the purificationStepLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurificationStepLocationSvcDto }
     *     
     */
    public void setPurificationStepLocation(PurificationStepLocationSvcDto value) {
        this.purificationStepLocation = value;
    }

    /**
     * Gets the value of the stepNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStepNumber() {
        return stepNumber;
    }

    /**
     * Sets the value of the stepNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStepNumber(Integer value) {
        this.stepNumber = value;
    }

}
