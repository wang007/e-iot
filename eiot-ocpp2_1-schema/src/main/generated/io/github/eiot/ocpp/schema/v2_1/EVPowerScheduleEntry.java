
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * *(2.1)* An entry in schedule of the energy amount over time that EV is willing to discharge. A negative value indicates the willingness to discharge under specific conditions, a positive value indicates that the EV currently is not able to offer energy to discharge.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "duration",
    "power",
    "customData"
})
public class EVPowerScheduleEntry {

    /**
     * The duration of this entry.
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("The duration of this entry.\r\n")
    @NotNull
    private int duration;
    /**
     * Defines maximum amount of power for the duration of this EVPowerScheduleEntry to be discharged from the EV battery through EVSE power outlet. Negative values are used for discharging.
     * 
     * (Required)
     * 
     */
    @JsonProperty("power")
    @JsonPropertyDescription("Defines maximum amount of power for the duration of this EVPowerScheduleEntry to be discharged from the EV battery through EVSE power outlet. Negative values are used for discharging.\r\n")
    @NotNull
    private double power;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * The duration of this entry.
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }

    /**
     * The duration of this entry.
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public EVPowerScheduleEntry withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Defines maximum amount of power for the duration of this EVPowerScheduleEntry to be discharged from the EV battery through EVSE power outlet. Negative values are used for discharging.
     * 
     * (Required)
     * 
     */
    @JsonProperty("power")
    public double getPower() {
        return power;
    }

    /**
     * Defines maximum amount of power for the duration of this EVPowerScheduleEntry to be discharged from the EV battery through EVSE power outlet. Negative values are used for discharging.
     * 
     * (Required)
     * 
     */
    @JsonProperty("power")
    public void setPower(double power) {
        this.power = power;
    }

    public EVPowerScheduleEntry withPower(double power) {
        this.power = power;
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

    public EVPowerScheduleEntry withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EVPowerScheduleEntry.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
        sb.append(',');
        sb.append("power");
        sb.append('=');
        sb.append(this.power);
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
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.power)^(Double.doubleToLongBits(this.power)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EVPowerScheduleEntry) == false) {
            return false;
        }
        EVPowerScheduleEntry rhs = ((EVPowerScheduleEntry) other);
        return (((this.duration == rhs.duration)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(Double.doubleToLongBits(this.power) == Double.doubleToLongBits(rhs.power)));
    }

}
