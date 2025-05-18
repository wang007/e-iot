
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "duration",
    "chargingRateUnit",
    "evseId",
    "customData"
})
public class GetCompositeScheduleRequest {

    /**
     * Length of the requested schedule in seconds.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Length of the requested schedule in seconds.\r\n\r\n")
    @NotNull
    private int duration;
    /**
     * Can be used to force a power or current profile.
     * 
     * 
     * 
     */
    @JsonProperty("chargingRateUnit")
    @JsonPropertyDescription("Can be used to force a power or current profile.\r\n\r\n")
    private ChargingRateUnitEnum chargingRateUnit;
    /**
     * The ID of the EVSE for which the schedule is requested. When evseid=0, the Charging Station will calculate the expected consumption for the grid connection.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("The ID of the EVSE for which the schedule is requested. When evseid=0, the Charging Station will calculate the expected consumption for the grid connection.\r\n")
    @DecimalMin("0")
    @NotNull
    private int evseId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Length of the requested schedule in seconds.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }

    /**
     * Length of the requested schedule in seconds.
     * 
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

    /**
     * Can be used to force a power or current profile.
     * 
     * 
     * 
     */
    @JsonProperty("chargingRateUnit")
    public ChargingRateUnitEnum getChargingRateUnit() {
        return chargingRateUnit;
    }

    /**
     * Can be used to force a power or current profile.
     * 
     * 
     * 
     */
    @JsonProperty("chargingRateUnit")
    public void setChargingRateUnit(ChargingRateUnitEnum chargingRateUnit) {
        this.chargingRateUnit = chargingRateUnit;
    }

    public GetCompositeScheduleRequest withChargingRateUnit(ChargingRateUnitEnum chargingRateUnit) {
        this.chargingRateUnit = chargingRateUnit;
        return this;
    }

    /**
     * The ID of the EVSE for which the schedule is requested. When evseid=0, the Charging Station will calculate the expected consumption for the grid connection.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * The ID of the EVSE for which the schedule is requested. When evseid=0, the Charging Station will calculate the expected consumption for the grid connection.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public GetCompositeScheduleRequest withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

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

    public GetCompositeScheduleRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetCompositeScheduleRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
        sb.append(',');
        sb.append("chargingRateUnit");
        sb.append('=');
        sb.append(((this.chargingRateUnit == null)?"<null>":this.chargingRateUnit));
        sb.append(',');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
        sb.append(',');
        sb.append("customData");
        sb.append('=');
        sb.append(((this.customData == null)?"<null>":this.customData));
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
        result = ((result* 31)+ this.evseId);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
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
        return ((((this.duration == rhs.duration)&&(this.evseId == rhs.evseId))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.chargingRateUnit == rhs.chargingRateUnit)||((this.chargingRateUnit!= null)&&this.chargingRateUnit.equals(rhs.chargingRateUnit))));
    }

}
