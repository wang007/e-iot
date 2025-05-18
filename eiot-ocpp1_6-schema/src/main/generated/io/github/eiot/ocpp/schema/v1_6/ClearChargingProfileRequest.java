
package io.github.eiot.ocpp.schema.v1_6;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * ClearChargingProfileRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "connectorId",
    "chargingProfilePurpose",
    "stackLevel"
})
public class ClearChargingProfileRequest {

    @JsonProperty("id")
    private int id;
    @JsonProperty("connectorId")
    private int connectorId;
    @JsonProperty("chargingProfilePurpose")
    private ClearChargingProfileRequest.ChargingProfilePurpose chargingProfilePurpose;
    @JsonProperty("stackLevel")
    private int stackLevel;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public ClearChargingProfileRequest withId(int id) {
        this.id = id;
        return this;
    }

    @JsonProperty("connectorId")
    public int getConnectorId() {
        return connectorId;
    }

    @JsonProperty("connectorId")
    public void setConnectorId(int connectorId) {
        this.connectorId = connectorId;
    }

    public ClearChargingProfileRequest withConnectorId(int connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    @JsonProperty("chargingProfilePurpose")
    public ClearChargingProfileRequest.ChargingProfilePurpose getChargingProfilePurpose() {
        return chargingProfilePurpose;
    }

    @JsonProperty("chargingProfilePurpose")
    public void setChargingProfilePurpose(ClearChargingProfileRequest.ChargingProfilePurpose chargingProfilePurpose) {
        this.chargingProfilePurpose = chargingProfilePurpose;
    }

    public ClearChargingProfileRequest withChargingProfilePurpose(ClearChargingProfileRequest.ChargingProfilePurpose chargingProfilePurpose) {
        this.chargingProfilePurpose = chargingProfilePurpose;
        return this;
    }

    @JsonProperty("stackLevel")
    public int getStackLevel() {
        return stackLevel;
    }

    @JsonProperty("stackLevel")
    public void setStackLevel(int stackLevel) {
        this.stackLevel = stackLevel;
    }

    public ClearChargingProfileRequest withStackLevel(int stackLevel) {
        this.stackLevel = stackLevel;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ClearChargingProfileRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("connectorId");
        sb.append('=');
        sb.append(this.connectorId);
        sb.append(',');
        sb.append("chargingProfilePurpose");
        sb.append('=');
        sb.append(((this.chargingProfilePurpose == null)?"<null>":this.chargingProfilePurpose));
        sb.append(',');
        sb.append("stackLevel");
        sb.append('=');
        sb.append(this.stackLevel);
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
        result = ((result* 31)+((this.chargingProfilePurpose == null)? 0 :this.chargingProfilePurpose.hashCode()));
        result = ((result* 31)+ this.id);
        result = ((result* 31)+ this.stackLevel);
        result = ((result* 31)+ this.connectorId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ClearChargingProfileRequest) == false) {
            return false;
        }
        ClearChargingProfileRequest rhs = ((ClearChargingProfileRequest) other);
        return (((((this.chargingProfilePurpose == rhs.chargingProfilePurpose)||((this.chargingProfilePurpose!= null)&&this.chargingProfilePurpose.equals(rhs.chargingProfilePurpose)))&&(this.id == rhs.id))&&(this.stackLevel == rhs.stackLevel))&&(this.connectorId == rhs.connectorId));
    }

    public enum ChargingProfilePurpose {

        CHARGE_POINT_MAX_PROFILE("ChargePointMaxProfile"),
        TX_DEFAULT_PROFILE("TxDefaultProfile"),
        TX_PROFILE("TxProfile");
        private final String value;
        private final static Map<String, ClearChargingProfileRequest.ChargingProfilePurpose> CONSTANTS = new HashMap<String, ClearChargingProfileRequest.ChargingProfilePurpose>();

        static {
            for (ClearChargingProfileRequest.ChargingProfilePurpose c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        ChargingProfilePurpose(String value) {
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
        public static ClearChargingProfileRequest.ChargingProfilePurpose fromValue(String value) {
            ClearChargingProfileRequest.ChargingProfilePurpose constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
