
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
 * UnlockConnectorResponse
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status"
})
public class UnlockConnectorResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @NotNull
    private UnlockConnectorResponse.Status status;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public UnlockConnectorResponse.Status getStatus() {
        return status;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(UnlockConnectorResponse.Status status) {
        this.status = status;
    }

    public UnlockConnectorResponse withStatus(UnlockConnectorResponse.Status status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UnlockConnectorResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof UnlockConnectorResponse) == false) {
            return false;
        }
        UnlockConnectorResponse rhs = ((UnlockConnectorResponse) other);
        return ((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status)));
    }

    public enum Status {

        UNLOCKED("Unlocked"),
        UNLOCK_FAILED("UnlockFailed"),
        NOT_SUPPORTED("NotSupported");
        private final String value;
        private final static Map<String, UnlockConnectorResponse.Status> CONSTANTS = new HashMap<String, UnlockConnectorResponse.Status>();

        static {
            for (UnlockConnectorResponse.Status c: values()) {
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
        public static UnlockConnectorResponse.Status fromValue(String value) {
            UnlockConnectorResponse.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
