
package io.github.eiot.ocpp.schema.v2_0_1;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customData",
    "timeBase",
    "chargingSchedule",
    "evseId"
})
public class NotifyEVChargingScheduleRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Periods contained in the charging profile are relative to this point in time.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeBase")
    @JsonPropertyDescription("Periods contained in the charging profile are relative to this point in time.\r\n")
    @NotNull
    private OffsetDateTime timeBase;
    /**
     * Charging_ Schedule
     * urn:x-oca:ocpp:uid:2:233256
     * Charging schedule structure defines a list of charging periods, as used in: GetCompositeSchedule.conf and ChargingProfile. 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    @JsonPropertyDescription("Charging_ Schedule\r\nurn:x-oca:ocpp:uid:2:233256\r\nCharging schedule structure defines a list of charging periods, as used in: GetCompositeSchedule.conf and ChargingProfile. \r\n")
    @Valid
    @NotNull
    private ChargingSchedule chargingSchedule;
    /**
     * The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0.\r\n")
    @NotNull
    private int evseId;

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    public CustomData getCustomData() {
        return customData;
    }

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }

    public NotifyEVChargingScheduleRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    /**
     * Periods contained in the charging profile are relative to this point in time.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeBase")
    public OffsetDateTime getTimeBase() {
        return timeBase;
    }

    /**
     * Periods contained in the charging profile are relative to this point in time.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeBase")
    public void setTimeBase(OffsetDateTime timeBase) {
        this.timeBase = timeBase;
    }

    public NotifyEVChargingScheduleRequest withTimeBase(OffsetDateTime timeBase) {
        this.timeBase = timeBase;
        return this;
    }

    /**
     * Charging_ Schedule
     * urn:x-oca:ocpp:uid:2:233256
     * Charging schedule structure defines a list of charging periods, as used in: GetCompositeSchedule.conf and ChargingProfile. 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    public ChargingSchedule getChargingSchedule() {
        return chargingSchedule;
    }

    /**
     * Charging_ Schedule
     * urn:x-oca:ocpp:uid:2:233256
     * Charging schedule structure defines a list of charging periods, as used in: GetCompositeSchedule.conf and ChargingProfile. 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    public void setChargingSchedule(ChargingSchedule chargingSchedule) {
        this.chargingSchedule = chargingSchedule;
    }

    public NotifyEVChargingScheduleRequest withChargingSchedule(ChargingSchedule chargingSchedule) {
        this.chargingSchedule = chargingSchedule;
        return this;
    }

    /**
     * The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public NotifyEVChargingScheduleRequest withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyEVChargingScheduleRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customData");
        sb.append('=');
        sb.append(((this.customData == null)?"<null>":this.customData));
        sb.append(',');
        sb.append("timeBase");
        sb.append('=');
        sb.append(((this.timeBase == null)?"<null>":this.timeBase));
        sb.append(',');
        sb.append("chargingSchedule");
        sb.append('=');
        sb.append(((this.chargingSchedule == null)?"<null>":this.chargingSchedule));
        sb.append(',');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
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
        result = ((result* 31)+ this.evseId);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.timeBase == null)? 0 :this.timeBase.hashCode()));
        result = ((result* 31)+((this.chargingSchedule == null)? 0 :this.chargingSchedule.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NotifyEVChargingScheduleRequest) == false) {
            return false;
        }
        NotifyEVChargingScheduleRequest rhs = ((NotifyEVChargingScheduleRequest) other);
        return ((((this.evseId == rhs.evseId)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.timeBase == rhs.timeBase)||((this.timeBase!= null)&&this.timeBase.equals(rhs.timeBase))))&&((this.chargingSchedule == rhs.chargingSchedule)||((this.chargingSchedule!= null)&&this.chargingSchedule.equals(rhs.chargingSchedule))));
    }

}
