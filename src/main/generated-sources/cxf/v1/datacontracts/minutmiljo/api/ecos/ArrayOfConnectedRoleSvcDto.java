
package v1.datacontracts.minutmiljo.api.ecos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ArrayOfConnectedRoleSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ArrayOfConnectedRoleSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ConnectedRoleSvcDto" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ConnectedRoleSvcDto" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfConnectedRoleSvcDto", propOrder = {
    "connectedRoleSvcDto"
})
public class ArrayOfConnectedRoleSvcDto {

    @XmlElement(name = "ConnectedRoleSvcDto", nillable = true)
    protected List<ConnectedRoleSvcDto> connectedRoleSvcDto;

    /**
     * Gets the value of the connectedRoleSvcDto property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the connectedRoleSvcDto property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getConnectedRoleSvcDto().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ConnectedRoleSvcDto }
     * 
     * 
     */
    public List<ConnectedRoleSvcDto> getConnectedRoleSvcDto() {
        if (connectedRoleSvcDto == null) {
            connectedRoleSvcDto = new ArrayList<ConnectedRoleSvcDto>();
        }
        return this.connectedRoleSvcDto;
    }

}
