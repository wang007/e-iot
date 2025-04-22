
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hysteresisHigh",
    "hysteresisLow",
    "hysteresisDelay",
    "hysteresisGradient",
    "customData"
})
public class Hysteresis {

    /**
     * High value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisHigh")
    @JsonPropertyDescription("High value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit\r\n\r\n\r\n")
    private double hysteresisHigh;
    /**
     * Low value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisLow")
    @JsonPropertyDescription("Low value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit\r\n\r\n\r\n")
    private double hysteresisLow;
    /**
     * Delay in seconds, once grid parameter within HysteresisLow and HysteresisHigh, for the EV to return to normal operation after a grid event.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisDelay")
    @JsonPropertyDescription("Delay in seconds, once grid parameter within HysteresisLow and HysteresisHigh, for the EV to return to normal operation after a grid event.\r\n\r\n\r\n")
    private double hysteresisDelay;
    /**
     * Set default rate of change (ramp rate %/s) for the EV to return to normal operation after a grid event
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisGradient")
    @JsonPropertyDescription("Set default rate of change (ramp rate %/s) for the EV to return to normal operation after a grid event\r\n\r\n\r\n")
    private double hysteresisGradient;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * High value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisHigh")
    public double getHysteresisHigh() {
        return hysteresisHigh;
    }

    /**
     * High value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisHigh")
    public void setHysteresisHigh(double hysteresisHigh) {
        this.hysteresisHigh = hysteresisHigh;
    }

    public Hysteresis withHysteresisHigh(double hysteresisHigh) {
        this.hysteresisHigh = hysteresisHigh;
        return this;
    }

    /**
     * Low value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisLow")
    public double getHysteresisLow() {
        return hysteresisLow;
    }

    /**
     * Low value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisLow")
    public void setHysteresisLow(double hysteresisLow) {
        this.hysteresisLow = hysteresisLow;
    }

    public Hysteresis withHysteresisLow(double hysteresisLow) {
        this.hysteresisLow = hysteresisLow;
        return this;
    }

    /**
     * Delay in seconds, once grid parameter within HysteresisLow and HysteresisHigh, for the EV to return to normal operation after a grid event.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisDelay")
    public double getHysteresisDelay() {
        return hysteresisDelay;
    }

    /**
     * Delay in seconds, once grid parameter within HysteresisLow and HysteresisHigh, for the EV to return to normal operation after a grid event.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisDelay")
    public void setHysteresisDelay(double hysteresisDelay) {
        this.hysteresisDelay = hysteresisDelay;
    }

    public Hysteresis withHysteresisDelay(double hysteresisDelay) {
        this.hysteresisDelay = hysteresisDelay;
        return this;
    }

    /**
     * Set default rate of change (ramp rate %/s) for the EV to return to normal operation after a grid event
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisGradient")
    public double getHysteresisGradient() {
        return hysteresisGradient;
    }

    /**
     * Set default rate of change (ramp rate %/s) for the EV to return to normal operation after a grid event
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisGradient")
    public void setHysteresisGradient(double hysteresisGradient) {
        this.hysteresisGradient = hysteresisGradient;
    }

    public Hysteresis withHysteresisGradient(double hysteresisGradient) {
        this.hysteresisGradient = hysteresisGradient;
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

    public Hysteresis withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Hysteresis.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("hysteresisHigh");
        sb.append('=');
        sb.append(this.hysteresisHigh);
        sb.append(',');
        sb.append("hysteresisLow");
        sb.append('=');
        sb.append(this.hysteresisLow);
        sb.append(',');
        sb.append("hysteresisDelay");
        sb.append('=');
        sb.append(this.hysteresisDelay);
        sb.append(',');
        sb.append("hysteresisGradient");
        sb.append('=');
        sb.append(this.hysteresisGradient);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.hysteresisHigh)^(Double.doubleToLongBits(this.hysteresisHigh)>>> 32))));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.hysteresisGradient)^(Double.doubleToLongBits(this.hysteresisGradient)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.hysteresisDelay)^(Double.doubleToLongBits(this.hysteresisDelay)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.hysteresisLow)^(Double.doubleToLongBits(this.hysteresisLow)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Hysteresis) == false) {
            return false;
        }
        Hysteresis rhs = ((Hysteresis) other);
        return (((((Double.doubleToLongBits(this.hysteresisHigh) == Double.doubleToLongBits(rhs.hysteresisHigh))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(Double.doubleToLongBits(this.hysteresisGradient) == Double.doubleToLongBits(rhs.hysteresisGradient)))&&(Double.doubleToLongBits(this.hysteresisDelay) == Double.doubleToLongBits(rhs.hysteresisDelay)))&&(Double.doubleToLongBits(this.hysteresisLow) == Double.doubleToLongBits(rhs.hysteresisLow)));
    }

}
