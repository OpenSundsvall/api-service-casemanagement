package se.sundsvall.vo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Sätts till den enum som hör ihop med den anropande e-tjänsten.", example = CaseType.Constants.NYBYGGNAD_ANSOKAN_OM_BYGGLOV_VALUE)
public enum CaseType {

    NYBYGGNAD_ANSOKAN_OM_BYGGLOV(Constants.NYBYGGNAD_ANSOKAN_OM_BYGGLOV_VALUE),
    LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING(Constants.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING_VALUE);

    private final String text;

    CaseType(String text) {
        this.text = text;
    }

    public static class Constants {
        private Constants() {

        }

        public static final String NYBYGGNAD_ANSOKAN_OM_BYGGLOV_VALUE = "NYBYGGNAD_ANSOKAN_OM_BYGGLOV";
        public static final String LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING_VALUE = "LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING";
    }


    public static String getText(CaseType type) {
        switch (type) {
            case NYBYGGNAD_ANSOKAN_OM_BYGGLOV:
                return "Nybyggnad - ansökan om bygglov";
            case LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING:
                return "Livsmedelsverksamhet - anmälan om registrering";
            default:
                return null;
        }
    }

}
