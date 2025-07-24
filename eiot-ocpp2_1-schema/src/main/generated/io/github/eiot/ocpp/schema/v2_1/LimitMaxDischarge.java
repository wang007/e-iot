
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
    "pctMaxDischargePower",
    "powerMonitoringMustTrip",
    "startTime",
    "duration",
    "customData"
})
public class LimitMaxDischarge {

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
     * Only for PowerMonitoring. +
     *     The value specifies a percentage (0 to 100) of the rated maximum discharge power of EV. 
     *     The PowerMonitoring curve becomes active when power exceeds this percentage.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("pctMaxDischargePower")
    @JsonPropertyDescription("Only for PowerMonitoring. +\r\n    The value specifies a percentage (0 to 100) of the rated maximum discharge power of EV. \r\n    The PowerMonitoring curve becomes active when power exceeds this percentage.\r\n\r\n\r\n")
    private double pctMaxDischargePower;
    @JsonProperty("powerMonitoringMustTrip")
    @Valid
    private DERCurve powerMonitoringMustTrip;
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

    public LimitMaxDischarge withPriority(int priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Only for PowerMonitoring. +
     *     The value specifies a percentage (0 to 100) of the rated maximum discharge power of EV. 
     *     The PowerMonitoring curve becomes active when power exceeds this percentage.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("pctMaxDischargePower")
    public double getPctMaxDischargePower() {
        return pctMaxDischargePower;
    }

    /**
     * Only for PowerMonitoring. +
     *     The value specifies a percentage (0 to 100) of the rated maximum discharge power of EV. 
     *     The PowerMonitoring curve becomes active when power exceeds this percentage.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("pctMaxDischargePower")
    public void setPctMaxDischargePower(double pctMaxDischargePower) {
        this.pctMaxDischargePower = pctMaxDischargePower;
    }

    public LimitMaxDischarge withPctMaxDischargePower(double pctMaxDischargePower) {
        this.pctMaxDischargePower = pctMaxDischargePower;
        return this;
    }

    @JsonProperty("powerMonitoringMustTrip")
    public DERCurve getPowerMonitoringMustTrip() {
        return powerMonitoringMustTrip;
    }

    @JsonProperty("powerMonitoringMustTrip")
    public void setPowerMonitoringMustTrip(DERCurve powerMonitoringMustTrip) {
        this.powerMonitoringMustTrip = powerMonitoringMustTrip;
    }

    public LimitMaxDischarge withPowerMonitoringMustTrip(DERCurve powerMonitoringMustTrip) {
        this.powerMonitoringMustTrip = powerMonitoringMustTrip;
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

    public LimitMaxDischarge withStartTime(OffsetDateTime startTime) {
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

    public LimitMaxDischarge withDuration(double duration) {
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

    public LimitMaxDischarge withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LimitMaxDischarge.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("priority");
        sb.append('=');
        sb.append(this.priority);
        sb.append(',');
        sb.append("pctMaxDischargePower");
        sb.append('=');
        sb.append(this.pctMaxDischargePower);
        sb.append(',');
        sb.append("powerMonitoringMustTrip");
        sb.append('=');
        sb.append(((this.powerMonitoringMustTrip == null)?"<null>":this.powerMonitoringMustTrip));
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
        result = ((result* 31)+((this.powerMonitoringMustTrip == null)? 0 :this.powerMonitoringMustTrip.hashCode()));
        result = ((result* 31)+((this.startTime == null)? 0 :this.startTime.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.priority);
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.pctMaxDischargePower)^(Double.doubleToLongBits(this.pctMaxDischargePower)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LimitMaxDischarge) == false) {
            return false;
        }
        LimitMaxDischarge rhs = ((LimitMaxDischarge) other);
        return ((((((Double.doubleToLongBits(this.duration) == Double.doubleToLongBits(rhs.duration))&&((this.powerMonitoringMustTrip == rhs.powerMonitoringMustTrip)||((this.powerMonitoringMustTrip!= null)&&this.powerMonitoringMustTrip.equals(rhs.powerMonitoringMustTrip))))&&((this.startTime == rhs.startTime)||((this.startTime!= null)&&this.startTime.equals(rhs.startTime))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.priority == rhs.priority))&&(Double.doubleToLongBits(this.pctMaxDischargePower) == Double.doubleToLongBits(rhs.pctMaxDischargePower)));
    }

}
