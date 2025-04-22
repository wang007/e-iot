
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;


/**
 * Updates to a ChargingSchedulePeriodType for dynamic charging profiles.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "limit",
    "limit_L2",
    "limit_L3",
    "dischargeLimit",
    "dischargeLimit_L2",
    "dischargeLimit_L3",
    "setpoint",
    "setpoint_L2",
    "setpoint_L3",
    "setpointReactive",
    "setpointReactive_L2",
    "setpointReactive_L3",
    "customData"
})
public class ChargingScheduleUpdate {

    /**
     * Optional only when not required by the _operationMode_, as in CentralSetpoint, ExternalSetpoint, ExternalLimits, LocalFrequency,  LocalLoadBalancing. +
     * Charging rate limit during the schedule period, in the applicable _chargingRateUnit_. 
     * This SHOULD be a non-negative value; a negative value is only supported for backwards compatibility with older systems that use a negative value to specify a discharging limit.
     * For AC this field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("limit")
    @JsonPropertyDescription("Optional only when not required by the _operationMode_, as in CentralSetpoint, ExternalSetpoint, ExternalLimits, LocalFrequency,  LocalLoadBalancing. +\r\nCharging rate limit during the schedule period, in the applicable _chargingRateUnit_. \r\nThis SHOULD be a non-negative value; a negative value is only supported for backwards compatibility with older systems that use a negative value to specify a discharging limit.\r\nFor AC this field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\n")
    private double limit;
    /**
     * *(2.1)* Charging rate limit on phase L2  in the applicable _chargingRateUnit_. 
     * 
     * 
     */
    @JsonProperty("limit_L2")
    @JsonPropertyDescription("*(2.1)* Charging rate limit on phase L2  in the applicable _chargingRateUnit_. \r\n")
    private double limitL2;
    /**
     * *(2.1)* Charging rate limit on phase L3  in the applicable _chargingRateUnit_. 
     * 
     * 
     */
    @JsonProperty("limit_L3")
    @JsonPropertyDescription("*(2.1)* Charging rate limit on phase L3  in the applicable _chargingRateUnit_. \r\n")
    private double limitL3;
    /**
     * *(2.1)* Limit in _chargingRateUnit_ that the EV is allowed to discharge with. Note, these are negative values in order to be consistent with _setpoint_, which can be positive and negative.  +
     * For AC this field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("dischargeLimit")
    @JsonPropertyDescription("*(2.1)* Limit in _chargingRateUnit_ that the EV is allowed to discharge with. Note, these are negative values in order to be consistent with _setpoint_, which can be positive and negative.  +\r\nFor AC this field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\n")
    private double dischargeLimit;
    /**
     * *(2.1)* Limit in _chargingRateUnit_ on phase L2 that the EV is allowed to discharge with. 
     * 
     * 
     */
    @JsonProperty("dischargeLimit_L2")
    @JsonPropertyDescription("*(2.1)* Limit in _chargingRateUnit_ on phase L2 that the EV is allowed to discharge with. \r\n")
    private double dischargeLimitL2;
    /**
     * *(2.1)* Limit in _chargingRateUnit_ on phase L3 that the EV is allowed to discharge with. 
     * 
     * 
     */
    @JsonProperty("dischargeLimit_L3")
    @JsonPropertyDescription("*(2.1)* Limit in _chargingRateUnit_ on phase L3 that the EV is allowed to discharge with. \r\n")
    private double dischargeLimitL3;
    /**
     * *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow as close as possible. Use negative values for discharging. +
     * When a limit and/or _dischargeLimit_ are given the overshoot when following _setpoint_ must remain within these values.
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("setpoint")
    @JsonPropertyDescription("*(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow as close as possible. Use negative values for discharging. +\r\nWhen a limit and/or _dischargeLimit_ are given the overshoot when following _setpoint_ must remain within these values.\r\nThis field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\n")
    private double setpoint;
    /**
     * *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L2 as close as possible.
     * 
     * 
     */
    @JsonProperty("setpoint_L2")
    @JsonPropertyDescription("*(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L2 as close as possible.\r\n")
    private double setpointL2;
    /**
     * *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L3 as close as possible. 
     * 
     * 
     */
    @JsonProperty("setpoint_L3")
    @JsonPropertyDescription("*(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L3 as close as possible. \r\n")
    private double setpointL3;
    /**
     * *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow as closely as possible. Positive values for inductive, negative for capacitive reactive power or current.  +
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("setpointReactive")
    @JsonPropertyDescription("*(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow as closely as possible. Positive values for inductive, negative for capacitive reactive power or current.  +\r\nThis field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\n")
    private double setpointReactive;
    /**
     * *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L2 as closely as possible. 
     * 
     * 
     */
    @JsonProperty("setpointReactive_L2")
    @JsonPropertyDescription("*(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L2 as closely as possible. \r\n")
    private double setpointReactiveL2;
    /**
     * *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L3 as closely as possible. 
     * 
     * 
     */
    @JsonProperty("setpointReactive_L3")
    @JsonPropertyDescription("*(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L3 as closely as possible. \r\n")
    private double setpointReactiveL3;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Optional only when not required by the _operationMode_, as in CentralSetpoint, ExternalSetpoint, ExternalLimits, LocalFrequency,  LocalLoadBalancing. +
     * Charging rate limit during the schedule period, in the applicable _chargingRateUnit_. 
     * This SHOULD be a non-negative value; a negative value is only supported for backwards compatibility with older systems that use a negative value to specify a discharging limit.
     * For AC this field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("limit")
    public double getLimit() {
        return limit;
    }

    /**
     * Optional only when not required by the _operationMode_, as in CentralSetpoint, ExternalSetpoint, ExternalLimits, LocalFrequency,  LocalLoadBalancing. +
     * Charging rate limit during the schedule period, in the applicable _chargingRateUnit_. 
     * This SHOULD be a non-negative value; a negative value is only supported for backwards compatibility with older systems that use a negative value to specify a discharging limit.
     * For AC this field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("limit")
    public void setLimit(double limit) {
        this.limit = limit;
    }

    public ChargingScheduleUpdate withLimit(double limit) {
        this.limit = limit;
        return this;
    }

    /**
     * *(2.1)* Charging rate limit on phase L2  in the applicable _chargingRateUnit_. 
     * 
     * 
     */
    @JsonProperty("limit_L2")
    public double getLimitL2() {
        return limitL2;
    }

    /**
     * *(2.1)* Charging rate limit on phase L2  in the applicable _chargingRateUnit_. 
     * 
     * 
     */
    @JsonProperty("limit_L2")
    public void setLimitL2(double limitL2) {
        this.limitL2 = limitL2;
    }

    public ChargingScheduleUpdate withLimitL2(double limitL2) {
        this.limitL2 = limitL2;
        return this;
    }

    /**
     * *(2.1)* Charging rate limit on phase L3  in the applicable _chargingRateUnit_. 
     * 
     * 
     */
    @JsonProperty("limit_L3")
    public double getLimitL3() {
        return limitL3;
    }

    /**
     * *(2.1)* Charging rate limit on phase L3  in the applicable _chargingRateUnit_. 
     * 
     * 
     */
    @JsonProperty("limit_L3")
    public void setLimitL3(double limitL3) {
        this.limitL3 = limitL3;
    }

    public ChargingScheduleUpdate withLimitL3(double limitL3) {
        this.limitL3 = limitL3;
        return this;
    }

    /**
     * *(2.1)* Limit in _chargingRateUnit_ that the EV is allowed to discharge with. Note, these are negative values in order to be consistent with _setpoint_, which can be positive and negative.  +
     * For AC this field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("dischargeLimit")
    public double getDischargeLimit() {
        return dischargeLimit;
    }

    /**
     * *(2.1)* Limit in _chargingRateUnit_ that the EV is allowed to discharge with. Note, these are negative values in order to be consistent with _setpoint_, which can be positive and negative.  +
     * For AC this field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("dischargeLimit")
    public void setDischargeLimit(double dischargeLimit) {
        this.dischargeLimit = dischargeLimit;
    }

    public ChargingScheduleUpdate withDischargeLimit(double dischargeLimit) {
        this.dischargeLimit = dischargeLimit;
        return this;
    }

    /**
     * *(2.1)* Limit in _chargingRateUnit_ on phase L2 that the EV is allowed to discharge with. 
     * 
     * 
     */
    @JsonProperty("dischargeLimit_L2")
    public double getDischargeLimitL2() {
        return dischargeLimitL2;
    }

    /**
     * *(2.1)* Limit in _chargingRateUnit_ on phase L2 that the EV is allowed to discharge with. 
     * 
     * 
     */
    @JsonProperty("dischargeLimit_L2")
    public void setDischargeLimitL2(double dischargeLimitL2) {
        this.dischargeLimitL2 = dischargeLimitL2;
    }

    public ChargingScheduleUpdate withDischargeLimitL2(double dischargeLimitL2) {
        this.dischargeLimitL2 = dischargeLimitL2;
        return this;
    }

    /**
     * *(2.1)* Limit in _chargingRateUnit_ on phase L3 that the EV is allowed to discharge with. 
     * 
     * 
     */
    @JsonProperty("dischargeLimit_L3")
    public double getDischargeLimitL3() {
        return dischargeLimitL3;
    }

    /**
     * *(2.1)* Limit in _chargingRateUnit_ on phase L3 that the EV is allowed to discharge with. 
     * 
     * 
     */
    @JsonProperty("dischargeLimit_L3")
    public void setDischargeLimitL3(double dischargeLimitL3) {
        this.dischargeLimitL3 = dischargeLimitL3;
    }

    public ChargingScheduleUpdate withDischargeLimitL3(double dischargeLimitL3) {
        this.dischargeLimitL3 = dischargeLimitL3;
        return this;
    }

    /**
     * *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow as close as possible. Use negative values for discharging. +
     * When a limit and/or _dischargeLimit_ are given the overshoot when following _setpoint_ must remain within these values.
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("setpoint")
    public double getSetpoint() {
        return setpoint;
    }

    /**
     * *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow as close as possible. Use negative values for discharging. +
     * When a limit and/or _dischargeLimit_ are given the overshoot when following _setpoint_ must remain within these values.
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("setpoint")
    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    public ChargingScheduleUpdate withSetpoint(double setpoint) {
        this.setpoint = setpoint;
        return this;
    }

    /**
     * *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L2 as close as possible.
     * 
     * 
     */
    @JsonProperty("setpoint_L2")
    public double getSetpointL2() {
        return setpointL2;
    }

    /**
     * *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L2 as close as possible.
     * 
     * 
     */
    @JsonProperty("setpoint_L2")
    public void setSetpointL2(double setpointL2) {
        this.setpointL2 = setpointL2;
    }

    public ChargingScheduleUpdate withSetpointL2(double setpointL2) {
        this.setpointL2 = setpointL2;
        return this;
    }

    /**
     * *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L3 as close as possible. 
     * 
     * 
     */
    @JsonProperty("setpoint_L3")
    public double getSetpointL3() {
        return setpointL3;
    }

    /**
     * *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L3 as close as possible. 
     * 
     * 
     */
    @JsonProperty("setpoint_L3")
    public void setSetpointL3(double setpointL3) {
        this.setpointL3 = setpointL3;
    }

    public ChargingScheduleUpdate withSetpointL3(double setpointL3) {
        this.setpointL3 = setpointL3;
        return this;
    }

    /**
     * *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow as closely as possible. Positive values for inductive, negative for capacitive reactive power or current.  +
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("setpointReactive")
    public double getSetpointReactive() {
        return setpointReactive;
    }

    /**
     * *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow as closely as possible. Positive values for inductive, negative for capacitive reactive power or current.  +
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("setpointReactive")
    public void setSetpointReactive(double setpointReactive) {
        this.setpointReactive = setpointReactive;
    }

    public ChargingScheduleUpdate withSetpointReactive(double setpointReactive) {
        this.setpointReactive = setpointReactive;
        return this;
    }

    /**
     * *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L2 as closely as possible. 
     * 
     * 
     */
    @JsonProperty("setpointReactive_L2")
    public double getSetpointReactiveL2() {
        return setpointReactiveL2;
    }

    /**
     * *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L2 as closely as possible. 
     * 
     * 
     */
    @JsonProperty("setpointReactive_L2")
    public void setSetpointReactiveL2(double setpointReactiveL2) {
        this.setpointReactiveL2 = setpointReactiveL2;
    }

    public ChargingScheduleUpdate withSetpointReactiveL2(double setpointReactiveL2) {
        this.setpointReactiveL2 = setpointReactiveL2;
        return this;
    }

    /**
     * *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L3 as closely as possible. 
     * 
     * 
     */
    @JsonProperty("setpointReactive_L3")
    public double getSetpointReactiveL3() {
        return setpointReactiveL3;
    }

    /**
     * *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L3 as closely as possible. 
     * 
     * 
     */
    @JsonProperty("setpointReactive_L3")
    public void setSetpointReactiveL3(double setpointReactiveL3) {
        this.setpointReactiveL3 = setpointReactiveL3;
    }

    public ChargingScheduleUpdate withSetpointReactiveL3(double setpointReactiveL3) {
        this.setpointReactiveL3 = setpointReactiveL3;
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

    public ChargingScheduleUpdate withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingScheduleUpdate.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("limit");
        sb.append('=');
        sb.append(this.limit);
        sb.append(',');
        sb.append("limitL2");
        sb.append('=');
        sb.append(this.limitL2);
        sb.append(',');
        sb.append("limitL3");
        sb.append('=');
        sb.append(this.limitL3);
        sb.append(',');
        sb.append("dischargeLimit");
        sb.append('=');
        sb.append(this.dischargeLimit);
        sb.append(',');
        sb.append("dischargeLimitL2");
        sb.append('=');
        sb.append(this.dischargeLimitL2);
        sb.append(',');
        sb.append("dischargeLimitL3");
        sb.append('=');
        sb.append(this.dischargeLimitL3);
        sb.append(',');
        sb.append("setpoint");
        sb.append('=');
        sb.append(this.setpoint);
        sb.append(',');
        sb.append("setpointL2");
        sb.append('=');
        sb.append(this.setpointL2);
        sb.append(',');
        sb.append("setpointL3");
        sb.append('=');
        sb.append(this.setpointL3);
        sb.append(',');
        sb.append("setpointReactive");
        sb.append('=');
        sb.append(this.setpointReactive);
        sb.append(',');
        sb.append("setpointReactiveL2");
        sb.append('=');
        sb.append(this.setpointReactiveL2);
        sb.append(',');
        sb.append("setpointReactiveL3");
        sb.append('=');
        sb.append(this.setpointReactiveL3);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpoint)^(Double.doubleToLongBits(this.setpoint)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.dischargeLimitL3)^(Double.doubleToLongBits(this.dischargeLimitL3)>>> 32))));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpointL3)^(Double.doubleToLongBits(this.setpointL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpointL2)^(Double.doubleToLongBits(this.setpointL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpointReactive)^(Double.doubleToLongBits(this.setpointReactive)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.limit)^(Double.doubleToLongBits(this.limit)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpointReactiveL2)^(Double.doubleToLongBits(this.setpointReactiveL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpointReactiveL3)^(Double.doubleToLongBits(this.setpointReactiveL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.dischargeLimitL2)^(Double.doubleToLongBits(this.dischargeLimitL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.limitL3)^(Double.doubleToLongBits(this.limitL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.dischargeLimit)^(Double.doubleToLongBits(this.dischargeLimit)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.limitL2)^(Double.doubleToLongBits(this.limitL2)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingScheduleUpdate) == false) {
            return false;
        }
        ChargingScheduleUpdate rhs = ((ChargingScheduleUpdate) other);
        return (((((((((((((Double.doubleToLongBits(this.setpoint) == Double.doubleToLongBits(rhs.setpoint))&&(Double.doubleToLongBits(this.dischargeLimitL3) == Double.doubleToLongBits(rhs.dischargeLimitL3)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(Double.doubleToLongBits(this.setpointL3) == Double.doubleToLongBits(rhs.setpointL3)))&&(Double.doubleToLongBits(this.setpointL2) == Double.doubleToLongBits(rhs.setpointL2)))&&(Double.doubleToLongBits(this.setpointReactive) == Double.doubleToLongBits(rhs.setpointReactive)))&&(Double.doubleToLongBits(this.limit) == Double.doubleToLongBits(rhs.limit)))&&(Double.doubleToLongBits(this.setpointReactiveL2) == Double.doubleToLongBits(rhs.setpointReactiveL2)))&&(Double.doubleToLongBits(this.setpointReactiveL3) == Double.doubleToLongBits(rhs.setpointReactiveL3)))&&(Double.doubleToLongBits(this.dischargeLimitL2) == Double.doubleToLongBits(rhs.dischargeLimitL2)))&&(Double.doubleToLongBits(this.limitL3) == Double.doubleToLongBits(rhs.limitL3)))&&(Double.doubleToLongBits(this.dischargeLimit) == Double.doubleToLongBits(rhs.dischargeLimit)))&&(Double.doubleToLongBits(this.limitL2) == Double.doubleToLongBits(rhs.limitL2)));
    }

}
