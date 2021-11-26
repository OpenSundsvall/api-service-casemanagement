
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;


/**
 * &lt;p&gt;Java class for FacilityFnrsFilterSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FacilityFnrsFilterSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FacilityFilterSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Fnrs" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityFnrsFilterSvcDto", propOrder = {
    "fnrs"
})
public class FacilityFnrsFilterSvcDto
    extends FacilityFilterSvcDto
{

    @XmlElement(name = "Fnrs", nillable = true)
    protected ArrayOfint fnrs;

    /**
     * Gets the value of the fnrs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfint }
     *     
     */
    public ArrayOfint getFnrs() {
        return fnrs;
    }

    /**
     * Sets the value of the fnrs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfint }
     *     
     */
    public void setFnrs(ArrayOfint value) {
        this.fnrs = value;
    }

}
