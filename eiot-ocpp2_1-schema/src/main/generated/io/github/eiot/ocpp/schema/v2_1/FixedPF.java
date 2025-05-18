
package io.github.eiot.ocpp.schema.v2_1;

import java.time.ZonedDateTime;
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
    "displacement",
    "excitation",
    "startTime",
    "duration",
    "customData"
})
public class FixedPF {

    /**
     * Priority of setting (0=highest)
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("Priority of setting (0=highest)\r\n")
    @DecimalMin("0")
    @NotNull
    private int priority;
    /**
     * Power factor, cos(phi), as value between 0..1.
     * 
     * (Required)
     * 
     */
    @JsonProperty("displacement")
    @JsonPropertyDescription("Power factor, cos(phi), as value between 0..1.\r\n")
    @NotNull
    private double displacement;
    /**
     * True when absorbing reactive power (under-excited), false when injecting reactive power (over-excited).
     * 
     * (Required)
     * 
     */
    @JsonProperty("excitation")
    @JsonPropertyDescription("True when absorbing reactive power (under-excited), false when injecting reactive power (over-excited).\r\n")
    @NotNull
    private boolean excitation;
    /**
     * Time when this setting becomes active
     * 
     * 
     */
    @JsonProperty("startTime")
    @JsonPropertyDescription("Time when this setting becomes active\r\n")
    private ZonedDateTime startTime;
    /**
     * Duration in seconds that this setting is active.
     * 
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Duration in seconds that this setting is active.\r\n")
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
     * (Required)
     * 
     */
    @JsonProperty("priority")
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public FixedPF withPriority(int priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Power factor, cos(phi), as value between 0..1.
     * 
     * (Required)
     * 
     */
    @JsonProperty("displacement")
    public double getDisplacement() {
        return displacement;
    }

    /**
     * Power factor, cos(phi), as value between 0..1.
     * 
     * (Required)
     * 
     */
    @JsonProperty("displacement")
    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public FixedPF withDisplacement(double displacement) {
        this.displacement = displacement;
        return this;
    }

    /**
     * True when absorbing reactive power (under-excited), false when injecting reactive power (over-excited).
     * 
     * (Required)
     * 
     */
    @JsonProperty("excitation")
    public boolean isExcitation() {
        return excitation;
    }

    /**
     * True when absorbing reactive power (under-excited), false when injecting reactive power (over-excited).
     * 
     * (Required)
     * 
     */
    @JsonProperty("excitation")
    public void setExcitation(boolean excitation) {
        this.excitation = excitation;
    }

    public FixedPF withExcitation(boolean excitation) {
        this.excitation = excitation;
        return this;
    }

    /**
     * Time when this setting becomes active
     * 
     * 
     */
    @JsonProperty("startTime")
    public ZonedDateTime getStartTime() {
        return startTime;
    }

    /**
     * Time when this setting becomes active
     * 
     * 
     */
    @JsonProperty("startTime")
    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public FixedPF withStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Duration in seconds that this setting is active.
     * 
     * 
     */
    @JsonProperty("duration")
    public double getDuration() {
        return duration;
    }

    /**
     * Duration in seconds that this setting is active.
     * 
     * 
     */
    @JsonProperty("duration")
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public FixedPF withDuration(double duration) {
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

    public FixedPF withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FixedPF.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("priority");
        sb.append('=');
        sb.append(this.priority);
        sb.append(',');
        sb.append("displacement");
        sb.append('=');
        sb.append(this.displacement);
        sb.append(',');
        sb.append("excitation");
        sb.append('=');
        sb.append(this.excitation);
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
        result = ((result* 31)+(this.excitation? 1 : 0));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.displacement)^(Double.doubleToLongBits(this.displacement)>>> 32))));
        result = ((result* 31)+((this.startTime == null)? 0 :this.startTime.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.priority);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FixedPF) == false) {
            return false;
        }
        FixedPF rhs = ((FixedPF) other);
        return ((((((Double.doubleToLongBits(this.duration) == Double.doubleToLongBits(rhs.duration))&&(this.excitation == rhs.excitation))&&(Double.doubleToLongBits(this.displacement) == Double.doubleToLongBits(rhs.displacement)))&&((this.startTime == rhs.startTime)||((this.startTime!= null)&&this.startTime.equals(rhs.startTime))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.priority == rhs.priority));
    }

}
