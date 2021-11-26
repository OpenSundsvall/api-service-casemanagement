package se.sundsvall.sokigo.arendeexport;

import io.quarkiverse.cxf.annotation.CXFClient;
import se.tekis.servicecontract.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ArendeExportIntegrationService {

    @Inject
    @CXFClient("ARENDEEXPORT")
    IExportArenden iExportArenden;

    public Arende getArende(String dnr) {
        return iExportArenden.getArende(dnr);
    }

    public SaveNewArendeResponse2 saveNewArende(se.tekis.servicecontract.SaveNewArendeMessage message) {
        return iExportArenden.saveNewArende(message);
    }

    public SaveNewHandelseResponse2 saveNewHandelse(se.tekis.servicecontract.SaveNewHandelseMessage message) {
        return iExportArenden.saveNewHandelse(message);
    }

    public ArrayOfArende1 getRelateradeArendenByPersOrgNrAndRole(String organizationNumber, ArrayOfString arendeIntressentRoller, ArrayOfString handelseIntressentRoller) {
        return iExportArenden.getRelateradeArendenByPersOrgNrAndRole(organizationNumber, null, arendeIntressentRoller, handelseIntressentRoller, null);
    }
}
