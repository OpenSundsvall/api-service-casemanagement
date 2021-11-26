
package v1.service.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import v1.datacontracts.minutmiljo.api.ecos.ArrayOfConnectedRoleSvcDto;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="caseId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="connections" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}ArrayOfConnectedRoleSvcDto" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "caseId",
    "connections"
})
@XmlRootElement(name = "SetCasePartyRoleContactDetails")
public class SetCasePartyRoleContactDetails {

    protected String caseId;
    @XmlElement(nillable = true)
    protected ArrayOfConnectedRoleSvcDto connections;

    /**
     * Gets the value of the caseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * Sets the value of the caseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseId(String value) {
        this.caseId = value;
    }

    /**
     * Gets the value of the connections property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfConnectedRoleSvcDto }
     *     
     */
    public ArrayOfConnectedRoleSvcDto getConnections() {
        return connections;
    }

    /**
     * Sets the value of the connections property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfConnectedRoleSvcDto }
     *     
     */
    public void setConnections(ArrayOfConnectedRoleSvcDto value) {
        this.connections = value;
    }

}
