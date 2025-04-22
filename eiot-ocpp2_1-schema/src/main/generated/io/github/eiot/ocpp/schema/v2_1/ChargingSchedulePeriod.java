
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Charging schedule period structure defines a time period in a charging schedule. It is used in: CompositeScheduleType and in ChargingScheduleType. When used in a NotifyEVChargingScheduleRequest only _startPeriod_, _limit_, _limit_L2_, _limit_L3_ are relevant.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "startPeriod",
    "limit",
    "limit_L2",
    "limit_L3",
    "numberPhases",
    "phaseToUse",
    "dischargeLimit",
    "dischargeLimit_L2",
    "dischargeLimit_L3",
    "setpoint",
    "setpoint_L2",
    "setpoint_L3",
    "setpointReactive",
    "setpointReactive_L2",
    "setpointReactive_L3",
    "preconditioningRequest",
    "evseSleep",
    "v2xBaseline",
    "operationMode",
    "v2xFreqWattCurve",
    "v2xSignalWattCurve",
    "customData"
})
public class ChargingSchedulePeriod {

    /**
     * Start of the period, in seconds from the start of schedule. The value of StartPeriod also defines the stop time of the previous period.
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    @JsonPropertyDescription("Start of the period, in seconds from the start of schedule. The value of StartPeriod also defines the stop time of the previous period.\r\n")
    @NotNull
    private int startPeriod;
    /**
     * Optional only when not required by the _operationMode_, as in CentralSetpoint, ExternalSetpoint, ExternalLimits, LocalFrequency,  LocalLoadBalancing. +
     * Charging rate limit during the schedule period, in the applicable _chargingRateUnit_. 
     * This SHOULD be a non-negative value; a negative value is only supported for backwards compatibility with older systems that use a negative value to specify a discharging limit.
     * When using _chargingRateUnit_ = `W`, this field represents the sum of the power of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("limit")
    @JsonPropertyDescription("Optional only when not required by the _operationMode_, as in CentralSetpoint, ExternalSetpoint, ExternalLimits, LocalFrequency,  LocalLoadBalancing. +\r\nCharging rate limit during the schedule period, in the applicable _chargingRateUnit_. \r\nThis SHOULD be a non-negative value; a negative value is only supported for backwards compatibility with older systems that use a negative value to specify a discharging limit.\r\nWhen using _chargingRateUnit_ = `W`, this field represents the sum of the power of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\n")
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
     * The number of phases that can be used for charging. +
     * For a DC EVSE this field should be omitted. +
     * For an AC EVSE a default value of _numberPhases_ = 3 will be assumed if the field is absent.
     * 
     * 
     */
    @JsonProperty("numberPhases")
    @JsonPropertyDescription("The number of phases that can be used for charging. +\r\nFor a DC EVSE this field should be omitted. +\r\nFor an AC EVSE a default value of _numberPhases_ = 3 will be assumed if the field is absent.\r\n")
    @DecimalMin("0")
    @DecimalMax("3")
    private int numberPhases;
    /**
     * Values: 1..3, Used if numberPhases=1 and if the EVSE is capable of switching the phase connected to the EV, i.e. ACPhaseSwitchingSupported is defined and true. It’s not allowed unless both conditions above are true. If both conditions are true, and phaseToUse is omitted, the Charging Station / EVSE will make the selection on its own.
     * 
     * 
     * 
     */
    @JsonProperty("phaseToUse")
    @JsonPropertyDescription("Values: 1..3, Used if numberPhases=1 and if the EVSE is capable of switching the phase connected to the EV, i.e. ACPhaseSwitchingSupported is defined and true. It\u2019s not allowed unless both conditions above are true. If both conditions are true, and phaseToUse is omitted, the Charging Station / EVSE will make the selection on its own.\r\n\r\n")
    @DecimalMin("0")
    @DecimalMax("3")
    private int phaseToUse;
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
     * *(2.1)* If  true, the EV should attempt to keep the BMS preconditioned for this time interval.
     * 
     * 
     */
    @JsonProperty("preconditioningRequest")
    @JsonPropertyDescription("*(2.1)* If  true, the EV should attempt to keep the BMS preconditioned for this time interval.\r\n")
    private boolean preconditioningRequest;
    /**
     * *(2.1)* If true, the EVSE must turn off power electronics/modules associated with this transaction. Default value when absent is false.
     * 
     * 
     */
    @JsonProperty("evseSleep")
    @JsonPropertyDescription("*(2.1)* If true, the EVSE must turn off power electronics/modules associated with this transaction. Default value when absent is false.\r\n")
    private boolean evseSleep;
    /**
     * *(2.1)* Power value that, when present, is used as a baseline on top of which values from _v2xFreqWattCurve_ and _v2xSignalWattCurve_ are added.
     * 
     * 
     * 
     */
    @JsonProperty("v2xBaseline")
    @JsonPropertyDescription("*(2.1)* Power value that, when present, is used as a baseline on top of which values from _v2xFreqWattCurve_ and _v2xSignalWattCurve_ are added.\r\n\r\n")
    private double v2xBaseline;
    /**
     * *(2.1)* Charging operation mode to use during this time interval. When absent defaults to `ChargingOnly`.
     * 
     * 
     */
    @JsonProperty("operationMode")
    @JsonPropertyDescription("*(2.1)* Charging operation mode to use during this time interval. When absent defaults to `ChargingOnly`.\r\n")
    private OperationModeEnum operationMode;
    @JsonProperty("v2xFreqWattCurve")
    @Size(min = 1, max = 20)
    @Valid
    private List<V2XFreqWattPoint> v2xFreqWattCurve = new ArrayList<V2XFreqWattPoint>();
    @JsonProperty("v2xSignalWattCurve")
    @Size(min = 1, max = 20)
    @Valid
    private List<V2XSignalWattPoint> v2xSignalWattCurve = new ArrayList<V2XSignalWattPoint>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Start of the period, in seconds from the start of schedule. The value of StartPeriod also defines the stop time of the previous period.
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    public int getStartPeriod() {
        return startPeriod;
    }

    /**
     * Start of the period, in seconds from the start of schedule. The value of StartPeriod also defines the stop time of the previous period.
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    public void setStartPeriod(int startPeriod) {
        this.startPeriod = startPeriod;
    }

    public ChargingSchedulePeriod withStartPeriod(int startPeriod) {
        this.startPeriod = startPeriod;
        return this;
    }

    /**
     * Optional only when not required by the _operationMode_, as in CentralSetpoint, ExternalSetpoint, ExternalLimits, LocalFrequency,  LocalLoadBalancing. +
     * Charging rate limit during the schedule period, in the applicable _chargingRateUnit_. 
     * This SHOULD be a non-negative value; a negative value is only supported for backwards compatibility with older systems that use a negative value to specify a discharging limit.
     * When using _chargingRateUnit_ = `W`, this field represents the sum of the power of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
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
     * When using _chargingRateUnit_ = `W`, this field represents the sum of the power of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("limit")
    public void setLimit(double limit) {
        this.limit = limit;
    }

    public ChargingSchedulePeriod withLimit(double limit) {
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

    public ChargingSchedulePeriod withLimitL2(double limitL2) {
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

    public ChargingSchedulePeriod withLimitL3(double limitL3) {
        this.limitL3 = limitL3;
        return this;
    }

    /**
     * The number of phases that can be used for charging. +
     * For a DC EVSE this field should be omitted. +
     * For an AC EVSE a default value of _numberPhases_ = 3 will be assumed if the field is absent.
     * 
     * 
     */
    @JsonProperty("numberPhases")
    public int getNumberPhases() {
        return numberPhases;
    }

    /**
     * The number of phases that can be used for charging. +
     * For a DC EVSE this field should be omitted. +
     * For an AC EVSE a default value of _numberPhases_ = 3 will be assumed if the field is absent.
     * 
     * 
     */
    @JsonProperty("numberPhases")
    public void setNumberPhases(int numberPhases) {
        this.numberPhases = numberPhases;
    }

    public ChargingSchedulePeriod withNumberPhases(int numberPhases) {
        this.numberPhases = numberPhases;
        return this;
    }

    /**
     * Values: 1..3, Used if numberPhases=1 and if the EVSE is capable of switching the phase connected to the EV, i.e. ACPhaseSwitchingSupported is defined and true. It’s not allowed unless both conditions above are true. If both conditions are true, and phaseToUse is omitted, the Charging Station / EVSE will make the selection on its own.
     * 
     * 
     * 
     */
    @JsonProperty("phaseToUse")
    public int getPhaseToUse() {
        return phaseToUse;
    }

    /**
     * Values: 1..3, Used if numberPhases=1 and if the EVSE is capable of switching the phase connected to the EV, i.e. ACPhaseSwitchingSupported is defined and true. It’s not allowed unless both conditions above are true. If both conditions are true, and phaseToUse is omitted, the Charging Station / EVSE will make the selection on its own.
     * 
     * 
     * 
     */
    @JsonProperty("phaseToUse")
    public void setPhaseToUse(int phaseToUse) {
        this.phaseToUse = phaseToUse;
    }

    public ChargingSchedulePeriod withPhaseToUse(int phaseToUse) {
        this.phaseToUse = phaseToUse;
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

    public ChargingSchedulePeriod withDischargeLimit(double dischargeLimit) {
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

    public ChargingSchedulePeriod withDischargeLimitL2(double dischargeLimitL2) {
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

    public ChargingSchedulePeriod withDischargeLimitL3(double dischargeLimitL3) {
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

    public ChargingSchedulePeriod withSetpoint(double setpoint) {
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

    public ChargingSchedulePeriod withSetpointL2(double setpointL2) {
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

    public ChargingSchedulePeriod withSetpointL3(double setpointL3) {
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

    public ChargingSchedulePeriod withSetpointReactive(double setpointReactive) {
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

    public ChargingSchedulePeriod withSetpointReactiveL2(double setpointReactiveL2) {
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

    public ChargingSchedulePeriod withSetpointReactiveL3(double setpointReactiveL3) {
        this.setpointReactiveL3 = setpointReactiveL3;
        return this;
    }

    /**
     * *(2.1)* If  true, the EV should attempt to keep the BMS preconditioned for this time interval.
     * 
     * 
     */
    @JsonProperty("preconditioningRequest")
    public boolean isPreconditioningRequest() {
        return preconditioningRequest;
    }

    /**
     * *(2.1)* If  true, the EV should attempt to keep the BMS preconditioned for this time interval.
     * 
     * 
     */
    @JsonProperty("preconditioningRequest")
    public void setPreconditioningRequest(boolean preconditioningRequest) {
        this.preconditioningRequest = preconditioningRequest;
    }

    public ChargingSchedulePeriod withPreconditioningRequest(boolean preconditioningRequest) {
        this.preconditioningRequest = preconditioningRequest;
        return this;
    }

    /**
     * *(2.1)* If true, the EVSE must turn off power electronics/modules associated with this transaction. Default value when absent is false.
     * 
     * 
     */
    @JsonProperty("evseSleep")
    public boolean isEvseSleep() {
        return evseSleep;
    }

    /**
     * *(2.1)* If true, the EVSE must turn off power electronics/modules associated with this transaction. Default value when absent is false.
     * 
     * 
     */
    @JsonProperty("evseSleep")
    public void setEvseSleep(boolean evseSleep) {
        this.evseSleep = evseSleep;
    }

    public ChargingSchedulePeriod withEvseSleep(boolean evseSleep) {
        this.evseSleep = evseSleep;
        return this;
    }

    /**
     * *(2.1)* Power value that, when present, is used as a baseline on top of which values from _v2xFreqWattCurve_ and _v2xSignalWattCurve_ are added.
     * 
     * 
     * 
     */
    @JsonProperty("v2xBaseline")
    public double getV2xBaseline() {
        return v2xBaseline;
    }

    /**
     * *(2.1)* Power value that, when present, is used as a baseline on top of which values from _v2xFreqWattCurve_ and _v2xSignalWattCurve_ are added.
     * 
     * 
     * 
     */
    @JsonProperty("v2xBaseline")
    public void setV2xBaseline(double v2xBaseline) {
        this.v2xBaseline = v2xBaseline;
    }

    public ChargingSchedulePeriod withV2xBaseline(double v2xBaseline) {
        this.v2xBaseline = v2xBaseline;
        return this;
    }

    /**
     * *(2.1)* Charging operation mode to use during this time interval. When absent defaults to `ChargingOnly`.
     * 
     * 
     */
    @JsonProperty("operationMode")
    public OperationModeEnum getOperationMode() {
        return operationMode;
    }

    /**
     * *(2.1)* Charging operation mode to use during this time interval. When absent defaults to `ChargingOnly`.
     * 
     * 
     */
    @JsonProperty("operationMode")
    public void setOperationMode(OperationModeEnum operationMode) {
        this.operationMode = operationMode;
    }

    public ChargingSchedulePeriod withOperationMode(OperationModeEnum operationMode) {
        this.operationMode = operationMode;
        return this;
    }

    @JsonProperty("v2xFreqWattCurve")
    public List<V2XFreqWattPoint> getV2xFreqWattCurve() {
        return v2xFreqWattCurve;
    }

    @JsonProperty("v2xFreqWattCurve")
    public void setV2xFreqWattCurve(List<V2XFreqWattPoint> v2xFreqWattCurve) {
        this.v2xFreqWattCurve = v2xFreqWattCurve;
    }

    public ChargingSchedulePeriod withV2xFreqWattCurve(List<V2XFreqWattPoint> v2xFreqWattCurve) {
        this.v2xFreqWattCurve = v2xFreqWattCurve;
        return this;
    }

    @JsonProperty("v2xSignalWattCurve")
    public List<V2XSignalWattPoint> getV2xSignalWattCurve() {
        return v2xSignalWattCurve;
    }

    @JsonProperty("v2xSignalWattCurve")
    public void setV2xSignalWattCurve(List<V2XSignalWattPoint> v2xSignalWattCurve) {
        this.v2xSignalWattCurve = v2xSignalWattCurve;
    }

    public ChargingSchedulePeriod withV2xSignalWattCurve(List<V2XSignalWattPoint> v2xSignalWattCurve) {
        this.v2xSignalWattCurve = v2xSignalWattCurve;
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

    public ChargingSchedulePeriod withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingSchedulePeriod.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("startPeriod");
        sb.append('=');
        sb.append(this.startPeriod);
        sb.append(',');
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
        sb.append("numberPhases");
        sb.append('=');
        sb.append(this.numberPhases);
        sb.append(',');
        sb.append("phaseToUse");
        sb.append('=');
        sb.append(this.phaseToUse);
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
        sb.append("preconditioningRequest");
        sb.append('=');
        sb.append(this.preconditioningRequest);
        sb.append(',');
        sb.append("evseSleep");
        sb.append('=');
        sb.append(this.evseSleep);
        sb.append(',');
        sb.append("v2xBaseline");
        sb.append('=');
        sb.append(this.v2xBaseline);
        sb.append(',');
        sb.append("operationMode");
        sb.append('=');
        sb.append(((this.operationMode == null)?"<null>":this.operationMode));
        sb.append(',');
        sb.append("v2xFreqWattCurve");
        sb.append('=');
        sb.append(((this.v2xFreqWattCurve == null)?"<null>":this.v2xFreqWattCurve));
        sb.append(',');
        sb.append("v2xSignalWattCurve");
        sb.append('=');
        sb.append(((this.v2xSignalWattCurve == null)?"<null>":this.v2xSignalWattCurve));
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
        result = ((result* 31)+(this.evseSleep? 1 : 0));
        result = ((result* 31)+(this.preconditioningRequest? 1 : 0));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpoint)^(Double.doubleToLongBits(this.setpoint)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.dischargeLimitL3)^(Double.doubleToLongBits(this.dischargeLimitL3)>>> 32))));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.phaseToUse);
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpointL3)^(Double.doubleToLongBits(this.setpointL3)>>> 32))));
        result = ((result* 31)+ this.startPeriod);
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpointL2)^(Double.doubleToLongBits(this.setpointL2)>>> 32))));
        result = ((result* 31)+((this.operationMode == null)? 0 :this.operationMode.hashCode()));
        result = ((result* 31)+((this.v2xFreqWattCurve == null)? 0 :this.v2xFreqWattCurve.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpointReactive)^(Double.doubleToLongBits(this.setpointReactive)>>> 32))));
        result = ((result* 31)+((this.v2xSignalWattCurve == null)? 0 :this.v2xSignalWattCurve.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.limit)^(Double.doubleToLongBits(this.limit)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpointReactiveL2)^(Double.doubleToLongBits(this.setpointReactiveL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.setpointReactiveL3)^(Double.doubleToLongBits(this.setpointReactiveL3)>>> 32))));
        result = ((result* 31)+ this.numberPhases);
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.dischargeLimitL2)^(Double.doubleToLongBits(this.dischargeLimitL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.limitL3)^(Double.doubleToLongBits(this.limitL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.dischargeLimit)^(Double.doubleToLongBits(this.dischargeLimit)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.limitL2)^(Double.doubleToLongBits(this.limitL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.v2xBaseline)^(Double.doubleToLongBits(this.v2xBaseline)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingSchedulePeriod) == false) {
            return false;
        }
        ChargingSchedulePeriod rhs = ((ChargingSchedulePeriod) other);
        return ((((((((((((((((((((((this.evseSleep == rhs.evseSleep)&&(this.preconditioningRequest == rhs.preconditioningRequest))&&(Double.doubleToLongBits(this.setpoint) == Double.doubleToLongBits(rhs.setpoint)))&&(Double.doubleToLongBits(this.dischargeLimitL3) == Double.doubleToLongBits(rhs.dischargeLimitL3)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.phaseToUse == rhs.phaseToUse))&&(Double.doubleToLongBits(this.setpointL3) == Double.doubleToLongBits(rhs.setpointL3)))&&(this.startPeriod == rhs.startPeriod))&&(Double.doubleToLongBits(this.setpointL2) == Double.doubleToLongBits(rhs.setpointL2)))&&((this.operationMode == rhs.operationMode)||((this.operationMode!= null)&&this.operationMode.equals(rhs.operationMode))))&&((this.v2xFreqWattCurve == rhs.v2xFreqWattCurve)||((this.v2xFreqWattCurve!= null)&&this.v2xFreqWattCurve.equals(rhs.v2xFreqWattCurve))))&&(Double.doubleToLongBits(this.setpointReactive) == Double.doubleToLongBits(rhs.setpointReactive)))&&((this.v2xSignalWattCurve == rhs.v2xSignalWattCurve)||((this.v2xSignalWattCurve!= null)&&this.v2xSignalWattCurve.equals(rhs.v2xSignalWattCurve))))&&(Double.doubleToLongBits(this.limit) == Double.doubleToLongBits(rhs.limit)))&&(Double.doubleToLongBits(this.setpointReactiveL2) == Double.doubleToLongBits(rhs.setpointReactiveL2)))&&(Double.doubleToLongBits(this.setpointReactiveL3) == Double.doubleToLongBits(rhs.setpointReactiveL3)))&&(this.numberPhases == rhs.numberPhases))&&(Double.doubleToLongBits(this.dischargeLimitL2) == Double.doubleToLongBits(rhs.dischargeLimitL2)))&&(Double.doubleToLongBits(this.limitL3) == Double.doubleToLongBits(rhs.limitL3)))&&(Double.doubleToLongBits(this.dischargeLimit) == Double.doubleToLongBits(rhs.dischargeLimit)))&&(Double.doubleToLongBits(this.limitL2) == Double.doubleToLongBits(rhs.limitL2)))&&(Double.doubleToLongBits(this.v2xBaseline) == Double.doubleToLongBits(rhs.v2xBaseline)));
    }

}
