
package se.tekis.arende;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for prelDetaljPlan complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="prelDetaljPlan"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{www.tekis.se/arende}detaljPlan"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="geom" type="{www.tekis.se/arende}GeomType" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prelDetaljPlan", propOrder = {
    "geom"
})
public class PrelDetaljPlan
    extends DetaljPlan
{

    protected GeomType geom;

    /**
     * Gets the value of the geom property.
     * 
     * @return
     *     possible object is
     *     {@link GeomType }
     *     
     */
    public GeomType getGeom() {
        return geom;
    }

    /**
     * Sets the value of the geom property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeomType }
     *     
     */
    public void setGeom(GeomType value) {
        this.geom = value;
    }

}
