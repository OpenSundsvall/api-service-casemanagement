
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for FacilityMultiPartyRoleFilterSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FacilityMultiPartyRoleFilterSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:Ecos.API.MinutMiljo.DataContracts.V1}FacilityFilterSvcDto"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="PartyRoles" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfPartyRoleTupleSvcDto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="RequireAll" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityMultiPartyRoleFilterSvcDto", propOrder = {
    "partyRoles",
    "requireAll"
})
public class FacilityMultiPartyRoleFilterSvcDto
    extends FacilityFilterSvcDto
{

    @XmlElement(name = "PartyRoles", nillable = true)
    protected ArrayOfPartyRoleTupleSvcDto partyRoles;
    @XmlElement(name = "RequireAll")
    protected Boolean requireAll;

    /**
     * Gets the value of the partyRoles property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPartyRoleTupleSvcDto }
     *     
     */
    public ArrayOfPartyRoleTupleSvcDto getPartyRoles() {
        return partyRoles;
    }

    /**
     * Sets the value of the partyRoles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPartyRoleTupleSvcDto }
     *     
     */
    public void setPartyRoles(ArrayOfPartyRoleTupleSvcDto value) {
        this.partyRoles = value;
    }

    /**
     * Gets the value of the requireAll property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequireAll() {
        return requireAll;
    }

    /**
     * Sets the value of the requireAll property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequireAll(Boolean value) {
        this.requireAll = value;
    }

}
