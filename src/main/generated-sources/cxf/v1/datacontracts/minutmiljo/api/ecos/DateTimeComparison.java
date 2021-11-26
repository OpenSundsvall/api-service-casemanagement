
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for DateTimeComparison.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="DateTimeComparison"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="Passed"/&amp;gt;
 *     &amp;lt;enumeration value="NotPassed"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "DateTimeComparison")
@XmlEnum
public enum DateTimeComparison {

    @XmlEnumValue("Passed")
    PASSED("Passed"),
    @XmlEnumValue("NotPassed")
    NOT_PASSED("NotPassed");
    private final String value;

    DateTimeComparison(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DateTimeComparison fromValue(String v) {
        for (DateTimeComparison c: DateTimeComparison.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
