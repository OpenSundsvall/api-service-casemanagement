package se.sundsvall;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Dennis Nilsson
 */
@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info(title = "CaseManagement",
                version = "2.0",
                description = "En tjänst som hanterar ärenden mot ByggR(bygglovsärenden) och Ecos2(miljökontorärenden).",
                contact = @Contact(name = "Sundsvalls kommun - Dennis Nilsson", email = "dennis.nilsson@sundsvall.se")))
public class CaseManagementServiceApp extends Application {

}
