
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
    "priority",
    "highVoltage",
    "lowVoltage",
    "highFreq",
    "lowFreq",
    "delay",
    "randomDelay",
    "rampRate",
    "customData"
})
public class EnterService {

    /**
     * Priority of setting (0=highest)
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("Priority of setting (0=highest)\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private int priority;
    /**
     * Enter service voltage high
     * 
     * (Required)
     * 
     */
    @JsonProperty("highVoltage")
    @JsonPropertyDescription("Enter service voltage high\r\n")
    @NotNull
    private double highVoltage;
    /**
     * Enter service voltage low
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("lowVoltage")
    @JsonPropertyDescription("Enter service voltage low\r\n\r\n\r\n")
    @NotNull
    private double lowVoltage;
    /**
     * Enter service frequency high
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("highFreq")
    @JsonPropertyDescription("Enter service frequency high\r\n\r\n")
    @NotNull
    private double highFreq;
    /**
     * Enter service frequency low
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("lowFreq")
    @JsonPropertyDescription("Enter service frequency low\r\n\r\n\r\n")
    @NotNull
    private double lowFreq;
    /**
     * Enter service delay
     * 
     * 
     * 
     * 
     */
    @JsonProperty("delay")
    @JsonPropertyDescription("Enter service delay\r\n\r\n\r\n")
    private double delay;
    /**
     * Enter service randomized delay
     * 
     * 
     * 
     * 
     */
    @JsonProperty("randomDelay")
    @JsonPropertyDescription("Enter service randomized delay\r\n\r\n\r\n")
    private double randomDelay;
    /**
     * Enter service ramp rate in seconds
     * 
     * 
     * 
     * 
     */
    @JsonProperty("rampRate")
    @JsonPropertyDescription("Enter service ramp rate in seconds\r\n\r\n\r\n")
    private double rampRate;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Priority of setting (0=highest)
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    public int getPriority() {
        return priority;
    }

    /**
     * Priority of setting (0=highest)
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public EnterService withPriority(int priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Enter service voltage high
     * 
     * (Required)
     * 
     */
    @JsonProperty("highVoltage")
    public double getHighVoltage() {
        return highVoltage;
    }

    /**
     * Enter service voltage high
     * 
     * (Required)
     * 
     */
    @JsonProperty("highVoltage")
    public void setHighVoltage(double highVoltage) {
        this.highVoltage = highVoltage;
    }

    public EnterService withHighVoltage(double highVoltage) {
        this.highVoltage = highVoltage;
        return this;
    }

    /**
     * Enter service voltage low
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("lowVoltage")
    public double getLowVoltage() {
        return lowVoltage;
    }

    /**
     * Enter service voltage low
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("lowVoltage")
    public void setLowVoltage(double lowVoltage) {
        this.lowVoltage = lowVoltage;
    }

    public EnterService withLowVoltage(double lowVoltage) {
        this.lowVoltage = lowVoltage;
        return this;
    }

    /**
     * Enter service frequency high
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("highFreq")
    public double getHighFreq() {
        return highFreq;
    }

    /**
     * Enter service frequency high
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("highFreq")
    public void setHighFreq(double highFreq) {
        this.highFreq = highFreq;
    }

    public EnterService withHighFreq(double highFreq) {
        this.highFreq = highFreq;
        return this;
    }

    /**
     * Enter service frequency low
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("lowFreq")
    public double getLowFreq() {
        return lowFreq;
    }

    /**
     * Enter service frequency low
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("lowFreq")
    public void setLowFreq(double lowFreq) {
        this.lowFreq = lowFreq;
    }

    public EnterService withLowFreq(double lowFreq) {
        this.lowFreq = lowFreq;
        return this;
    }

    /**
     * Enter service delay
     * 
     * 
     * 
     * 
     */
    @JsonProperty("delay")
    public double getDelay() {
        return delay;
    }

    /**
     * Enter service delay
     * 
     * 
     * 
     * 
     */
    @JsonProperty("delay")
    public void setDelay(double delay) {
        this.delay = delay;
    }

    public EnterService withDelay(double delay) {
        this.delay = delay;
        return this;
    }

    /**
     * Enter service randomized delay
     * 
     * 
     * 
     * 
     */
    @JsonProperty("randomDelay")
    public double getRandomDelay() {
        return randomDelay;
    }

    /**
     * Enter service randomized delay
     * 
     * 
     * 
     * 
     */
    @JsonProperty("randomDelay")
    public void setRandomDelay(double randomDelay) {
        this.randomDelay = randomDelay;
    }

    public EnterService withRandomDelay(double randomDelay) {
        this.randomDelay = randomDelay;
        return this;
    }

    /**
     * Enter service ramp rate in seconds
     * 
     * 
     * 
     * 
     */
    @JsonProperty("rampRate")
    public double getRampRate() {
        return rampRate;
    }

    /**
     * Enter service ramp rate in seconds
     * 
     * 
     * 
     * 
     */
    @JsonProperty("rampRate")
    public void setRampRate(double rampRate) {
        this.rampRate = rampRate;
    }

    public EnterService withRampRate(double rampRate) {
        this.rampRate = rampRate;
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

    public EnterService withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EnterService.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("priority");
        sb.append('=');
        sb.append(this.priority);
        sb.append(',');
        sb.append("highVoltage");
        sb.append('=');
        sb.append(this.highVoltage);
        sb.append(',');
        sb.append("lowVoltage");
        sb.append('=');
        sb.append(this.lowVoltage);
        sb.append(',');
        sb.append("highFreq");
        sb.append('=');
        sb.append(this.highFreq);
        sb.append(',');
        sb.append("lowFreq");
        sb.append('=');
        sb.append(this.lowFreq);
        sb.append(',');
        sb.append("delay");
        sb.append('=');
        sb.append(this.delay);
        sb.append(',');
        sb.append("randomDelay");
        sb.append('=');
        sb.append(this.randomDelay);
        sb.append(',');
        sb.append("rampRate");
        sb.append('=');
        sb.append(this.rampRate);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.rampRate)^(Double.doubleToLongBits(this.rampRate)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.delay)^(Double.doubleToLongBits(this.delay)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.lowFreq)^(Double.doubleToLongBits(this.lowFreq)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.lowVoltage)^(Double.doubleToLongBits(this.lowVoltage)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.highVoltage)^(Double.doubleToLongBits(this.highVoltage)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.randomDelay)^(Double.doubleToLongBits(this.randomDelay)>>> 32))));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.priority);
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.highFreq)^(Double.doubleToLongBits(this.highFreq)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EnterService) == false) {
            return false;
        }
        EnterService rhs = ((EnterService) other);
        return (((((((((Double.doubleToLongBits(this.rampRate) == Double.doubleToLongBits(rhs.rampRate))&&(Double.doubleToLongBits(this.delay) == Double.doubleToLongBits(rhs.delay)))&&(Double.doubleToLongBits(this.lowFreq) == Double.doubleToLongBits(rhs.lowFreq)))&&(Double.doubleToLongBits(this.lowVoltage) == Double.doubleToLongBits(rhs.lowVoltage)))&&(Double.doubleToLongBits(this.highVoltage) == Double.doubleToLongBits(rhs.highVoltage)))&&(Double.doubleToLongBits(this.randomDelay) == Double.doubleToLongBits(rhs.randomDelay)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.priority == rhs.priority))&&(Double.doubleToLongBits(this.highFreq) == Double.doubleToLongBits(rhs.highFreq)));
    }

}
