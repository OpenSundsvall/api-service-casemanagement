
package v1.datacontracts.minutmiljo.api.ecos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ArrayOfSearchCaseResultSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ArrayOfSearchCaseResultSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="SearchCaseResultSvcDto" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}SearchCaseResultSvcDto" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSearchCaseResultSvcDto", propOrder = {
    "searchCaseResultSvcDto"
})
public class ArrayOfSearchCaseResultSvcDto {

    @XmlElement(name = "SearchCaseResultSvcDto", nillable = true)
    protected List<SearchCaseResultSvcDto> searchCaseResultSvcDto;

    /**
     * Gets the value of the searchCaseResultSvcDto property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the searchCaseResultSvcDto property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSearchCaseResultSvcDto().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link SearchCaseResultSvcDto }
     * 
     * 
     */
    public List<SearchCaseResultSvcDto> getSearchCaseResultSvcDto() {
        if (searchCaseResultSvcDto == null) {
            searchCaseResultSvcDto = new ArrayList<SearchCaseResultSvcDto>();
        }
        return this.searchCaseResultSvcDto;
    }

}
