
package v1.datacontracts.minutmiljo.api.ecos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ArrayOfFacilityFilterSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ArrayOfFacilityFilterSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="FacilityFilterSvcDto" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FacilityFilterSvcDto" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFacilityFilterSvcDto", propOrder = {
    "facilityFilterSvcDto"
})
public class ArrayOfFacilityFilterSvcDto {

    @XmlElement(name = "FacilityFilterSvcDto", nillable = true)
    protected List<FacilityFilterSvcDto> facilityFilterSvcDto;

    /**
     * Gets the value of the facilityFilterSvcDto property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the facilityFilterSvcDto property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getFacilityFilterSvcDto().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link FacilityFilterSvcDto }
     * 
     * 
     */
    public List<FacilityFilterSvcDto> getFacilityFilterSvcDto() {
        if (facilityFilterSvcDto == null) {
            facilityFilterSvcDto = new ArrayList<FacilityFilterSvcDto>();
        }
        return this.facilityFilterSvcDto;
    }

}
