
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
 * ChangeAvailabilityRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectorId",
    "type"
})
public class ChangeAvailabilityRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    @NotNull
    private int connectorId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    @NotNull
    private ChangeAvailabilityRequest.Type type;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    public int getConnectorId() {
        return connectorId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    public void setConnectorId(int connectorId) {
        this.connectorId = connectorId;
    }

    public ChangeAvailabilityRequest withConnectorId(int connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public ChangeAvailabilityRequest.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(ChangeAvailabilityRequest.Type type) {
        this.type = type;
    }

    public ChangeAvailabilityRequest withType(ChangeAvailabilityRequest.Type type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChangeAvailabilityRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connectorId");
        sb.append('=');
        sb.append(this.connectorId);
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
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
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+ this.connectorId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChangeAvailabilityRequest) == false) {
            return false;
        }
        ChangeAvailabilityRequest rhs = ((ChangeAvailabilityRequest) other);
        return (((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type)))&&(this.connectorId == rhs.connectorId));
    }

    public enum Type {

        INOPERATIVE("Inoperative"),
        OPERATIVE("Operative");
        private final String value;
        private final static Map<String, ChangeAvailabilityRequest.Type> CONSTANTS = new HashMap<String, ChangeAvailabilityRequest.Type>();

        static {
            for (ChangeAvailabilityRequest.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Type(String value) {
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
        public static ChangeAvailabilityRequest.Type fromValue(String value) {
            ChangeAvailabilityRequest.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
