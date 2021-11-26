
package v1.datacontracts.minutmiljo.api.ecos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ArrayOfDecisionBasisSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ArrayOfDecisionBasisSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="DecisionBasisSvcDto" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}DecisionBasisSvcDto" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDecisionBasisSvcDto", propOrder = {
    "decisionBasisSvcDto"
})
public class ArrayOfDecisionBasisSvcDto {

    @XmlElement(name = "DecisionBasisSvcDto", nillable = true)
    protected List<DecisionBasisSvcDto> decisionBasisSvcDto;

    /**
     * Gets the value of the decisionBasisSvcDto property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the decisionBasisSvcDto property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDecisionBasisSvcDto().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DecisionBasisSvcDto }
     * 
     * 
     */
    public List<DecisionBasisSvcDto> getDecisionBasisSvcDto() {
        if (decisionBasisSvcDto == null) {
            decisionBasisSvcDto = new ArrayList<DecisionBasisSvcDto>();
        }
        return this.decisionBasisSvcDto;
    }

}
