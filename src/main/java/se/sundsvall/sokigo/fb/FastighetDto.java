package se.sundsvall.sokigo.fb;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FastighetDto {
    private Integer fnr;
    private List<AdressplatsIdentifierDto> grupp;

    public Integer getFnr() {
        return fnr;
    }

    public void setFnr(Integer fnr) {
        this.fnr = fnr;
    }

    public List<AdressplatsIdentifierDto> getGrupp() {
        return grupp;
    }

    public void setGrupp(List<AdressplatsIdentifierDto> grupp) {
        this.grupp = grupp;
    }

}
