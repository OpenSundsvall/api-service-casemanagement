
package v1.datacontracts.minutmiljo.api.ecos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for FilterSvcDto complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FilterSvcDto"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterSvcDto")
@XmlSeeAlso({
    OrFilterSvcDto.class,
    AndFilterSvcDto.class,
    NotFilterSvcDto.class,
    SinglePartyRoleFilterSvcDto.class,
    MultiPartyRoleFilterSvcDto.class,
    WatchDateFilterSvcDto.class,
    CaseStartDateFilterSvcDto.class,
    DocumentKindFilterSvcDto.class,
    DocumentTypeFilterSvcDto.class,
    DocumentStatusFilterSvcDto.class,
    CaseNumberFilterSvcDto.class,
    FnrFilterSvcDto.class,
    OccurrenceFilterSvcDto.class,
    MainDecisionFilterSvcDto.class,
    CaseStatusIdFilterSvcDto.class
})
public class FilterSvcDto {


}
