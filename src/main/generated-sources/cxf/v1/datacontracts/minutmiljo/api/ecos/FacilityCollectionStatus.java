
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for FacilityCollectionStatus.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="FacilityCollectionStatus"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="All"/&amp;gt;
 *     &amp;lt;enumeration value="Active"/&amp;gt;
 *     &amp;lt;enumeration value="Discontinued"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "FacilityCollectionStatus")
@XmlEnum
public enum FacilityCollectionStatus {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Active")
    ACTIVE("Active"),
    @XmlEnumValue("Discontinued")
    DISCONTINUED("Discontinued");
    private final String value;

    FacilityCollectionStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FacilityCollectionStatus fromValue(String v) {
        for (FacilityCollectionStatus c: FacilityCollectionStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
