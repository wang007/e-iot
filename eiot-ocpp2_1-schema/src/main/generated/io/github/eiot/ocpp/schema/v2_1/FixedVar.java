
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
    "setpoint",
    "unit",
    "startTime",
    "duration",
    "customData"
})
public class FixedVar {

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
     * The value specifies a target var output interpreted as a signed percentage (-100 to 100). 
     *     A negative value refers to charging, whereas a positive one refers to discharging.
     *     The value type is determined by the unit field.
     * 
     * (Required)
     * 
     */
    @JsonProperty("setpoint")
    @JsonPropertyDescription("The value specifies a target var output interpreted as a signed percentage (-100 to 100). \r\n    A negative value refers to charging, whereas a positive one refers to discharging.\r\n    The value type is determined by the unit field.\r\n")
    @NotNull
    private double setpoint;
    /**
     * Unit of the Y-axis of DER curve
     * 
     * (Required)
     * 
     */
    @JsonProperty("unit")
    @JsonPropertyDescription("Unit of the Y-axis of DER curve\r\n")
    @NotNull
    private DERUnitEnum unit;
    /**
     * Time when this setting becomes active.
     * 
     * 
     */
    @JsonProperty("startTime")
    @JsonPropertyDescription("Time when this setting becomes active.\r\n")
    private OffsetDateTime startTime;
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

    public FixedVar withPriority(int priority) {
        this.priority = priority;
        return this;
    }

    /**
     * The value specifies a target var output interpreted as a signed percentage (-100 to 100). 
     *     A negative value refers to charging, whereas a positive one refers to discharging.
     *     The value type is determined by the unit field.
     * 
     * (Required)
     * 
     */
    @JsonProperty("setpoint")
    public double getSetpoint() {
        return setpoint;
    }

    /**
     * The value specifies a target var output interpreted as a signed percentage (-100 to 100). 
     *     A negative value refers to charging, whereas a positive one refers to discharging.
     *     The value type is determined by the unit field.
     * 
     * (Required)
     * 
     */
    @JsonProperty("setpoint")
    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    public FixedVar withSetpoint(double setpoint) {
        this.setpoint = setpoint;
        return this;
    }

    /**
     * Unit of the Y-axis of DER curve
     * 
     * (Required)
     * 
     */
    @JsonProperty("unit")
    public DERUnitEnum getUnit() {
        return unit;
    }

    /**
     * Unit of the Y-axis of DER curve
     * 
     * (Required)
     * 
     */
    @JsonProperty("unit")
    public void setUnit(DERUnitEnum unit) {
        this.unit = unit;
    }

    public FixedVar withUnit(DERUnitEnum unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Time when this setting becomes active.
     * 
     * 
     */
    @JsonProperty("startTime")
    public OffsetDateTime getStartTime() {
        return startTime;
    }

    /**
     * Time when this setting becomes active.
     * 
     * 
     */
    @JsonProperty("startTime")
    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public FixedVar withStartTime(OffsetDateTime startTime) {
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

    public FixedVar withDuration(double duration) {
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

    public FixedVar withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FixedVar.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("priority");
        sb.append('=');
        sb.append(this.priority);
        sb.append(',');
        sb.append("setpoint");
        sb.append('=');
        sb.append(this.setpoint);
        sb.append(',');
        sb.append("unit");
        sb.append('=');
        sb.append(((this.unit == null)?"<null>":this.unit));
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
        result = ((result* 31)+((this.unit == null)? 0 :this.unit.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpoint)^(Double.doubleToLongBits(this.setpoint)>>> 32))));
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
        if ((other instanceof FixedVar) == false) {
            return false;
        }
        FixedVar rhs = ((FixedVar) other);
        return ((((((Double.doubleToLongBits(this.duration) == Double.doubleToLongBits(rhs.duration))&&((this.unit == rhs.unit)||((this.unit!= null)&&this.unit.equals(rhs.unit))))&&(Double.doubleToLongBits(this.setpoint) == Double.doubleToLongBits(rhs.setpoint)))&&((this.startTime == rhs.startTime)||((this.startTime!= null)&&this.startTime.equals(rhs.startTime))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.priority == rhs.priority));
    }

}
