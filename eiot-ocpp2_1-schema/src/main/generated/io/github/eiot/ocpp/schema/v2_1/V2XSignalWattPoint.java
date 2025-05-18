
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * *(2.1)* A point of a signal-watt curve.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "signal",
    "power",
    "customData"
})
public class V2XSignalWattPoint {

    /**
     * Signal value from an AFRRSignalRequest.
     * 
     * (Required)
     * 
     */
    @JsonProperty("signal")
    @JsonPropertyDescription("Signal value from an AFRRSignalRequest.\r\n")
    @NotNull
    private int signal;
    /**
     * Power in W to charge (positive) or discharge (negative) at specified frequency.
     * 
     * (Required)
     * 
     */
    @JsonProperty("power")
    @JsonPropertyDescription("Power in W to charge (positive) or discharge (negative) at specified frequency.\r\n")
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
     * Signal value from an AFRRSignalRequest.
     * 
     * (Required)
     * 
     */
    @JsonProperty("signal")
    public int getSignal() {
        return signal;
    }

    /**
     * Signal value from an AFRRSignalRequest.
     * 
     * (Required)
     * 
     */
    @JsonProperty("signal")
    public void setSignal(int signal) {
        this.signal = signal;
    }

    public V2XSignalWattPoint withSignal(int signal) {
        this.signal = signal;
        return this;
    }

    /**
     * Power in W to charge (positive) or discharge (negative) at specified frequency.
     * 
     * (Required)
     * 
     */
    @JsonProperty("power")
    public double getPower() {
        return power;
    }

    /**
     * Power in W to charge (positive) or discharge (negative) at specified frequency.
     * 
     * (Required)
     * 
     */
    @JsonProperty("power")
    public void setPower(double power) {
        this.power = power;
    }

    public V2XSignalWattPoint withPower(double power) {
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

    public V2XSignalWattPoint withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V2XSignalWattPoint.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("signal");
        sb.append('=');
        sb.append(this.signal);
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
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.power)^(Double.doubleToLongBits(this.power)>>> 32))));
        result = ((result* 31)+ this.signal);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof V2XSignalWattPoint) == false) {
            return false;
        }
        V2XSignalWattPoint rhs = ((V2XSignalWattPoint) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(Double.doubleToLongBits(this.power) == Double.doubleToLongBits(rhs.power)))&&(this.signal == rhs.signal));
    }

}
