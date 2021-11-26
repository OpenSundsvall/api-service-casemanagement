package v2.service.minutmiljo.api.ecos;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.2
 * 2021-10-20T15:30:02.564+02:00
 * Generated source version: 3.4.2
 *
 */
@WebService(targetNamespace = "urn:Ecos.API.MinutMiljo.Service.V2", name = "IMinutMiljoServiceV2")
@XmlSeeAlso({v1.datacontracts.minutmiljo.api.ecos.ObjectFactory.class, com.microsoft.schemas._2003._10.serialization.ObjectFactory.class, com.microsoft.schemas._2003._10.serialization.arrays.ObjectFactory.class, v2.datacontracts.minutmiljo.api.ecos.ObjectFactory.class, ObjectFactory.class})
public interface IMinutMiljoServiceV2 {

    @WebMethod(operationName = "RegisterDocument", action = "urn:Ecos.API.MinutMiljo.Service.V2/IMinutMiljoServiceV2/RegisterDocument")
    @Action(input = "urn:Ecos.API.MinutMiljo.Service.V2/IMinutMiljoServiceV2/RegisterDocument", output = "urn:Ecos.API.MinutMiljo.Service.V2/IMinutMiljoServiceV2/RegisterDocumentResponse")
    @RequestWrapper(localName = "RegisterDocument", targetNamespace = "urn:Ecos.API.MinutMiljo.Service.V2", className = "v2.service.minutmiljo.api.ecos.RegisterDocument")
    @ResponseWrapper(localName = "RegisterDocumentResponse", targetNamespace = "urn:Ecos.API.MinutMiljo.Service.V2", className = "v2.service.minutmiljo.api.ecos.RegisterDocumentResponse")
    @WebResult(name = "RegisterDocumentResult", targetNamespace = "urn:Ecos.API.MinutMiljo.Service.V2")
    public v1.datacontracts.minutmiljo.api.ecos.RegisterDocumentCaseResultSvcDto registerDocument(

        @WebParam(name = "registerDocumentCaseSvcDto", targetNamespace = "urn:Ecos.API.MinutMiljo.Service.V2")
        v2.datacontracts.minutmiljo.api.ecos.RegisterDocumentCaseSvcDtoV2 registerDocumentCaseSvcDto
    );
}
