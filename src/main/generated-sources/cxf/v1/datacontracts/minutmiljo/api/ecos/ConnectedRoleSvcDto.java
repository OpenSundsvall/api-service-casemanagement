
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ConnectedRoleSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ConnectedRoleSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ConnectionId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PartyId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *         &amp;lt;element name="RoleId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/&amp;gt;
 *         &amp;lt;element name="SelectedContact" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}SelectedContactSvcDto" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConnectedRoleSvcDto", propOrder = {
    "connectionId",
    "partyId",
    "roleId",
    "selectedContact"
})
public class ConnectedRoleSvcDto {

    @XmlElement(name = "ConnectionId")
    protected String connectionId;
    @XmlElement(name = "PartyId", required = true)
    protected String partyId;
    @XmlElement(name = "RoleId", required = true)
    protected String roleId;
    @XmlElement(name = "SelectedContact", nillable = true)
    protected SelectedContactSvcDto selectedContact;

    /**
     * Gets the value of the connectionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectionId() {
        return connectionId;
    }

    /**
     * Sets the value of the connectionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectionId(String value) {
        this.connectionId = value;
    }

    /**
     * Gets the value of the partyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartyId() {
        return partyId;
    }

    /**
     * Sets the value of the partyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartyId(String value) {
        this.partyId = value;
    }

    /**
     * Gets the value of the roleId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Sets the value of the roleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleId(String value) {
        this.roleId = value;
    }

    /**
     * Gets the value of the selectedContact property.
     * 
     * @return
     *     possible object is
     *     {@link SelectedContactSvcDto }
     *     
     */
    public SelectedContactSvcDto getSelectedContact() {
        return selectedContact;
    }

    /**
     * Sets the value of the selectedContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectedContactSvcDto }
     *     
     */
    public void setSelectedContact(SelectedContactSvcDto value) {
        this.selectedContact = value;
    }

}
