
package v1.service.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import v1.datacontracts.minutmiljo.api.ecos.AddDocumentsToCaseSvcDto;


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
 *         &amp;lt;element name="addDocumentToCaseSvcDto" type="{urn:Ecos.API.MinutMiljo.DataContracts.V1}AddDocumentsToCaseSvcDto" minOccurs="0"/&amp;gt;
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
    "addDocumentToCaseSvcDto"
})
@XmlRootElement(name = "AddDocumentsToCase")
public class AddDocumentsToCase {

    @XmlElement(nillable = true)
    protected AddDocumentsToCaseSvcDto addDocumentToCaseSvcDto;

    /**
     * Gets the value of the addDocumentToCaseSvcDto property.
     * 
     * @return
     *     possible object is
     *     {@link AddDocumentsToCaseSvcDto }
     *     
     */
    public AddDocumentsToCaseSvcDto getAddDocumentToCaseSvcDto() {
        return addDocumentToCaseSvcDto;
    }

    /**
     * Sets the value of the addDocumentToCaseSvcDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddDocumentsToCaseSvcDto }
     *     
     */
    public void setAddDocumentToCaseSvcDto(AddDocumentsToCaseSvcDto value) {
        this.addDocumentToCaseSvcDto = value;
    }

}
