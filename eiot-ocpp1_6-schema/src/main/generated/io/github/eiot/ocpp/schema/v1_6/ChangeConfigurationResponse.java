
package io.github.eiot.ocpp.schema.v1_6;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;


/**
 * ChangeConfigurationResponse
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status"
})
public class ChangeConfigurationResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @NotNull
    private ChangeConfigurationResponse.Status status;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public ChangeConfigurationResponse.Status getStatus() {
        return status;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(ChangeConfigurationResponse.Status status) {
        this.status = status;
    }

    public ChangeConfigurationResponse withStatus(ChangeConfigurationResponse.Status status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChangeConfigurationResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChangeConfigurationResponse) == false) {
            return false;
        }
        ChangeConfigurationResponse rhs = ((ChangeConfigurationResponse) other);
        return ((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status)));
    }

    public enum Status {

        ACCEPTED("Accepted"),
        REJECTED("Rejected"),
        REBOOT_REQUIRED("RebootRequired"),
        NOT_SUPPORTED("NotSupported");
        private final String value;
        private final static Map<String, ChangeConfigurationResponse.Status> CONSTANTS = new HashMap<String, ChangeConfigurationResponse.Status>();

        static {
            for (ChangeConfigurationResponse.Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Status(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static ChangeConfigurationResponse.Status fromValue(String value) {
            ChangeConfigurationResponse.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
