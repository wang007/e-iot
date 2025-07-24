
package io.github.eiot.ocpp.schema.v2_1;

import java.time.OffsetDateTime;
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
    "overFreq",
    "underFreq",
    "overDroop",
    "underDroop",
    "responseTime",
    "startTime",
    "duration",
    "customData"
})
public class FreqDroop {

    /**
     * Priority of setting (0=highest)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("Priority of setting (0=highest)\r\n\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private int priority;
    /**
     * Over-frequency start of droop
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("overFreq")
    @JsonPropertyDescription("Over-frequency start of droop\r\n\r\n\r\n")
    @NotNull
    private double overFreq;
    /**
     * Under-frequency start of droop
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("underFreq")
    @JsonPropertyDescription("Under-frequency start of droop\r\n\r\n\r\n")
    @NotNull
    private double underFreq;
    /**
     * Over-frequency droop per unit, oFDroop
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("overDroop")
    @JsonPropertyDescription("Over-frequency droop per unit, oFDroop\r\n\r\n\r\n")
    @NotNull
    private double overDroop;
    /**
     * Under-frequency droop per unit, uFDroop
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("underDroop")
    @JsonPropertyDescription("Under-frequency droop per unit, uFDroop\r\n\r\n")
    @NotNull
    private double underDroop;
    /**
     * Open loop response time in seconds
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("responseTime")
    @JsonPropertyDescription("Open loop response time in seconds\r\n\r\n")
    @NotNull
    private double responseTime;
    /**
     * Time when this setting becomes active
     * 
     * 
     * 
     * 
     */
    @JsonProperty("startTime")
    @JsonPropertyDescription("Time when this setting becomes active\r\n\r\n\r\n")
    private OffsetDateTime startTime;
    /**
     * Duration in seconds that this setting is active
     * 
     * 
     * 
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Duration in seconds that this setting is active\r\n\r\n\r\n")
    private double duration;
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public FreqDroop withPriority(int priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Over-frequency start of droop
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("overFreq")
    public double getOverFreq() {
        return overFreq;
    }

    /**
     * Over-frequency start of droop
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("overFreq")
    public void setOverFreq(double overFreq) {
        this.overFreq = overFreq;
    }

    public FreqDroop withOverFreq(double overFreq) {
        this.overFreq = overFreq;
        return this;
    }

    /**
     * Under-frequency start of droop
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("underFreq")
    public double getUnderFreq() {
        return underFreq;
    }

    /**
     * Under-frequency start of droop
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("underFreq")
    public void setUnderFreq(double underFreq) {
        this.underFreq = underFreq;
    }

    public FreqDroop withUnderFreq(double underFreq) {
        this.underFreq = underFreq;
        return this;
    }

    /**
     * Over-frequency droop per unit, oFDroop
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("overDroop")
    public double getOverDroop() {
        return overDroop;
    }

    /**
     * Over-frequency droop per unit, oFDroop
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("overDroop")
    public void setOverDroop(double overDroop) {
        this.overDroop = overDroop;
    }

    public FreqDroop withOverDroop(double overDroop) {
        this.overDroop = overDroop;
        return this;
    }

    /**
     * Under-frequency droop per unit, uFDroop
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("underDroop")
    public double getUnderDroop() {
        return underDroop;
    }

    /**
     * Under-frequency droop per unit, uFDroop
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("underDroop")
    public void setUnderDroop(double underDroop) {
        this.underDroop = underDroop;
    }

    public FreqDroop withUnderDroop(double underDroop) {
        this.underDroop = underDroop;
        return this;
    }

    /**
     * Open loop response time in seconds
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("responseTime")
    public double getResponseTime() {
        return responseTime;
    }

    /**
     * Open loop response time in seconds
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("responseTime")
    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public FreqDroop withResponseTime(double responseTime) {
        this.responseTime = responseTime;
        return this;
    }

    /**
     * Time when this setting becomes active
     * 
     * 
     * 
     * 
     */
    @JsonProperty("startTime")
    public OffsetDateTime getStartTime() {
        return startTime;
    }

    /**
     * Time when this setting becomes active
     * 
     * 
     * 
     * 
     */
    @JsonProperty("startTime")
    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public FreqDroop withStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Duration in seconds that this setting is active
     * 
     * 
     * 
     * 
     */
    @JsonProperty("duration")
    public double getDuration() {
        return duration;
    }

    /**
     * Duration in seconds that this setting is active
     * 
     * 
     * 
     * 
     */
    @JsonProperty("duration")
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public FreqDroop withDuration(double duration) {
        this.duration = duration;
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

    public FreqDroop withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FreqDroop.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("priority");
        sb.append('=');
        sb.append(this.priority);
        sb.append(',');
        sb.append("overFreq");
        sb.append('=');
        sb.append(this.overFreq);
        sb.append(',');
        sb.append("underFreq");
        sb.append('=');
        sb.append(this.underFreq);
        sb.append(',');
        sb.append("overDroop");
        sb.append('=');
        sb.append(this.overDroop);
        sb.append(',');
        sb.append("underDroop");
        sb.append('=');
        sb.append(this.underDroop);
        sb.append(',');
        sb.append("responseTime");
        sb.append('=');
        sb.append(this.responseTime);
        sb.append(',');
        sb.append("startTime");
        sb.append('=');
        sb.append(((this.startTime == null)?"<null>":this.startTime));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.duration)^(Double.doubleToLongBits(this.duration)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.underDroop)^(Double.doubleToLongBits(this.underDroop)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.overDroop)^(Double.doubleToLongBits(this.overDroop)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.responseTime)^(Double.doubleToLongBits(this.responseTime)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.underFreq)^(Double.doubleToLongBits(this.underFreq)>>> 32))));
        result = ((result* 31)+((this.startTime == null)? 0 :this.startTime.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.priority);
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.overFreq)^(Double.doubleToLongBits(this.overFreq)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FreqDroop) == false) {
            return false;
        }
        FreqDroop rhs = ((FreqDroop) other);
        return (((((((((Double.doubleToLongBits(this.duration) == Double.doubleToLongBits(rhs.duration))&&(Double.doubleToLongBits(this.underDroop) == Double.doubleToLongBits(rhs.underDroop)))&&(Double.doubleToLongBits(this.overDroop) == Double.doubleToLongBits(rhs.overDroop)))&&(Double.doubleToLongBits(this.responseTime) == Double.doubleToLongBits(rhs.responseTime)))&&(Double.doubleToLongBits(this.underFreq) == Double.doubleToLongBits(rhs.underFreq)))&&((this.startTime == rhs.startTime)||((this.startTime!= null)&&this.startTime.equals(rhs.startTime))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.priority == rhs.priority))&&(Double.doubleToLongBits(this.overFreq) == Double.doubleToLongBits(rhs.overFreq)));
    }

}
