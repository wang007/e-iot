
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
 * GetCompositeScheduleRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectorId",
    "duration",
    "chargingRateUnit"
})
public class GetCompositeScheduleRequest {

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
    @JsonProperty("duration")
    @NotNull
    private int duration;
    @JsonProperty("chargingRateUnit")
    private GetCompositeScheduleRequest.ChargingRateUnit chargingRateUnit;

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

    public GetCompositeScheduleRequest withConnectorId(int connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public GetCompositeScheduleRequest withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    @JsonProperty("chargingRateUnit")
    public GetCompositeScheduleRequest.ChargingRateUnit getChargingRateUnit() {
        return chargingRateUnit;
    }

    @JsonProperty("chargingRateUnit")
    public void setChargingRateUnit(GetCompositeScheduleRequest.ChargingRateUnit chargingRateUnit) {
        this.chargingRateUnit = chargingRateUnit;
    }

    public GetCompositeScheduleRequest withChargingRateUnit(GetCompositeScheduleRequest.ChargingRateUnit chargingRateUnit) {
        this.chargingRateUnit = chargingRateUnit;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetCompositeScheduleRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connectorId");
        sb.append('=');
        sb.append(this.connectorId);
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
        sb.append(',');
        sb.append("chargingRateUnit");
        sb.append('=');
        sb.append(((this.chargingRateUnit == null)?"<null>":this.chargingRateUnit));
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
        result = ((result* 31)+ this.duration);
        result = ((result* 31)+ this.connectorId);
        result = ((result* 31)+((this.chargingRateUnit == null)? 0 :this.chargingRateUnit.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetCompositeScheduleRequest) == false) {
            return false;
        }
        GetCompositeScheduleRequest rhs = ((GetCompositeScheduleRequest) other);
        return (((this.duration == rhs.duration)&&(this.connectorId == rhs.connectorId))&&((this.chargingRateUnit == rhs.chargingRateUnit)||((this.chargingRateUnit!= null)&&this.chargingRateUnit.equals(rhs.chargingRateUnit))));
    }

    public enum ChargingRateUnit {

        A("A"),
        W("W");
        private final String value;
        private final static Map<String, GetCompositeScheduleRequest.ChargingRateUnit> CONSTANTS = new HashMap<String, GetCompositeScheduleRequest.ChargingRateUnit>();

        static {
            for (GetCompositeScheduleRequest.ChargingRateUnit c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        ChargingRateUnit(String value) {
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
        public static GetCompositeScheduleRequest.ChargingRateUnit fromValue(String value) {
            GetCompositeScheduleRequest.ChargingRateUnit constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
