
package io.github.eiot.ocpp.schema.v1_6;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * GetCompositeScheduleResponse
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "connectorId",
    "scheduleStart",
    "chargingSchedule"
})
public class GetCompositeScheduleResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @NotNull
    private GetCompositeScheduleResponse.Status status;
    @JsonProperty("connectorId")
    private int connectorId;
    @JsonProperty("scheduleStart")
    private OffsetDateTime scheduleStart;
    @JsonProperty("chargingSchedule")
    @Valid
    private ChargingSchedule chargingSchedule;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public GetCompositeScheduleResponse.Status getStatus() {
        return status;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(GetCompositeScheduleResponse.Status status) {
        this.status = status;
    }

    public GetCompositeScheduleResponse withStatus(GetCompositeScheduleResponse.Status status) {
        this.status = status;
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

    public GetCompositeScheduleResponse withConnectorId(int connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    @JsonProperty("scheduleStart")
    public OffsetDateTime getScheduleStart() {
        return scheduleStart;
    }

    @JsonProperty("scheduleStart")
    public void setScheduleStart(OffsetDateTime scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    public GetCompositeScheduleResponse withScheduleStart(OffsetDateTime scheduleStart) {
        this.scheduleStart = scheduleStart;
        return this;
    }

    @JsonProperty("chargingSchedule")
    public ChargingSchedule getChargingSchedule() {
        return chargingSchedule;
    }

    @JsonProperty("chargingSchedule")
    public void setChargingSchedule(ChargingSchedule chargingSchedule) {
        this.chargingSchedule = chargingSchedule;
    }

    public GetCompositeScheduleResponse withChargingSchedule(ChargingSchedule chargingSchedule) {
        this.chargingSchedule = chargingSchedule;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetCompositeScheduleResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("connectorId");
        sb.append('=');
        sb.append(this.connectorId);
        sb.append(',');
        sb.append("scheduleStart");
        sb.append('=');
        sb.append(((this.scheduleStart == null)?"<null>":this.scheduleStart));
        sb.append(',');
        sb.append("chargingSchedule");
        sb.append('=');
        sb.append(((this.chargingSchedule == null)?"<null>":this.chargingSchedule));
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
        result = ((result* 31)+((this.scheduleStart == null)? 0 :this.scheduleStart.hashCode()));
        result = ((result* 31)+((this.chargingSchedule == null)? 0 :this.chargingSchedule.hashCode()));
        result = ((result* 31)+ this.connectorId);
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetCompositeScheduleResponse) == false) {
            return false;
        }
        GetCompositeScheduleResponse rhs = ((GetCompositeScheduleResponse) other);
        return (((((this.scheduleStart == rhs.scheduleStart)||((this.scheduleStart!= null)&&this.scheduleStart.equals(rhs.scheduleStart)))&&((this.chargingSchedule == rhs.chargingSchedule)||((this.chargingSchedule!= null)&&this.chargingSchedule.equals(rhs.chargingSchedule))))&&(this.connectorId == rhs.connectorId))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

    public enum Status {

        ACCEPTED("Accepted"),
        REJECTED("Rejected");
        private final String value;
        private final static Map<String, GetCompositeScheduleResponse.Status> CONSTANTS = new HashMap<String, GetCompositeScheduleResponse.Status>();

        static {
            for (GetCompositeScheduleResponse.Status c: values()) {
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
        public static GetCompositeScheduleResponse.Status fromValue(String value) {
            GetCompositeScheduleResponse.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
