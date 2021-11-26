
package v1.datacontracts.minutmiljo.api.ecos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ArrayOfGetContactDetailPathsAndTypesSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ArrayOfGetContactDetailPathsAndTypesSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="GetContactDetailPathsAndTypesSvcDto" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}GetContactDetailPathsAndTypesSvcDto" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfGetContactDetailPathsAndTypesSvcDto", propOrder = {
    "getContactDetailPathsAndTypesSvcDto"
})
public class ArrayOfGetContactDetailPathsAndTypesSvcDto {

    @XmlElement(name = "GetContactDetailPathsAndTypesSvcDto", nillable = true)
    protected List<GetContactDetailPathsAndTypesSvcDto> getContactDetailPathsAndTypesSvcDto;

    /**
     * Gets the value of the getContactDetailPathsAndTypesSvcDto property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the getContactDetailPathsAndTypesSvcDto property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getGetContactDetailPathsAndTypesSvcDto().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link GetContactDetailPathsAndTypesSvcDto }
     * 
     * 
     */
    public List<GetContactDetailPathsAndTypesSvcDto> getGetContactDetailPathsAndTypesSvcDto() {
        if (getContactDetailPathsAndTypesSvcDto == null) {
            getContactDetailPathsAndTypesSvcDto = new ArrayList<GetContactDetailPathsAndTypesSvcDto>();
        }
        return this.getContactDetailPathsAndTypesSvcDto;
    }

}
