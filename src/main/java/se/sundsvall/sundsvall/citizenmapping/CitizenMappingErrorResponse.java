package se.sundsvall.sundsvall.citizenmapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class CitizenMappingErrorResponse {

    private String type;
    private String title;
    private long status;
    private String traceId;
    private Errors errors;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long value) {
        this.status = value;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String value) {
        this.traceId = value;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors value) {
        this.errors = value;
    }

    private static class Errors {
        private String[] personId;

        public String[] getPersonId() {
            return personId;
        }

        public void setPersonId(String[] value) {
            this.personId = value;
        }
    }

}
