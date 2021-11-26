
package v1.datacontracts.minutmiljo.api.ecos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ArrayOfContactInfoItemSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ArrayOfContactInfoItemSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ContactInfoItemSvcDto" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ContactInfoItemSvcDto" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfContactInfoItemSvcDto", propOrder = {
    "contactInfoItemSvcDto"
})
public class ArrayOfContactInfoItemSvcDto {

    @XmlElement(name = "ContactInfoItemSvcDto", nillable = true)
    protected List<ContactInfoItemSvcDto> contactInfoItemSvcDto;

    /**
     * Gets the value of the contactInfoItemSvcDto property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the contactInfoItemSvcDto property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getContactInfoItemSvcDto().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ContactInfoItemSvcDto }
     * 
     * 
     */
    public List<ContactInfoItemSvcDto> getContactInfoItemSvcDto() {
        if (contactInfoItemSvcDto == null) {
            contactInfoItemSvcDto = new ArrayList<ContactInfoItemSvcDto>();
        }
        return this.contactInfoItemSvcDto;
    }

}
