
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;


/**
 * Charging parameters for ISO 15118-20, also supporting V2X charging/discharging.+
 * All values are greater or equal to zero, with the exception of EVMinEnergyRequest, EVMaxEnergyRequest, EVTargetEnergyRequest, EVMinV2XEnergyRequest and EVMaxV2XEnergyRequest.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "minChargePower",
    "minChargePower_L2",
    "minChargePower_L3",
    "maxChargePower",
    "maxChargePower_L2",
    "maxChargePower_L3",
    "minDischargePower",
    "minDischargePower_L2",
    "minDischargePower_L3",
    "maxDischargePower",
    "maxDischargePower_L2",
    "maxDischargePower_L3",
    "minChargeCurrent",
    "maxChargeCurrent",
    "minDischargeCurrent",
    "maxDischargeCurrent",
    "minVoltage",
    "maxVoltage",
    "evTargetEnergyRequest",
    "evMinEnergyRequest",
    "evMaxEnergyRequest",
    "evMinV2XEnergyRequest",
    "evMaxV2XEnergyRequest",
    "targetSoC",
    "customData"
})
public class V2XChargingParameters {

    /**
     * Minimum charge power in W, defined by max(EV, EVSE).
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower
     * 
     * 
     */
    @JsonProperty("minChargePower")
    @JsonPropertyDescription("Minimum charge power in W, defined by max(EV, EVSE).\r\nThis field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower\r\n")
    private double minChargePower;
    /**
     * Minimum charge power on phase L2 in W, defined by max(EV, EVSE).
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L2
     * 
     * 
     */
    @JsonProperty("minChargePower_L2")
    @JsonPropertyDescription("Minimum charge power on phase L2 in W, defined by max(EV, EVSE).\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L2\r\n")
    private double minChargePowerL2;
    /**
     * Minimum charge power on phase L3 in W, defined by max(EV, EVSE).
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L3
     * 
     * 
     */
    @JsonProperty("minChargePower_L3")
    @JsonPropertyDescription("Minimum charge power on phase L3 in W, defined by max(EV, EVSE).\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L3\r\n")
    private double minChargePowerL3;
    /**
     * Maximum charge (absorbed) power in W, defined by min(EV, EVSE) at unity power factor. +
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * It corresponds to the ChaWMax attribute in the IEC 61850.
     * It is usually equivalent to the rated apparent power of the EV when discharging (ChaVAMax) in IEC 61850. +
     * 
     * Relates to: 
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower
     * 
     * 
     * 
     */
    @JsonProperty("maxChargePower")
    @JsonPropertyDescription("Maximum charge (absorbed) power in W, defined by min(EV, EVSE) at unity power factor. +\r\nThis field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\nIt corresponds to the ChaWMax attribute in the IEC 61850.\r\nIt is usually equivalent to the rated apparent power of the EV when discharging (ChaVAMax) in IEC 61850. +\r\n\r\nRelates to: \r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower\r\n\r\n")
    private double maxChargePower;
    /**
     * Maximum charge power on phase L2 in W, defined by min(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L2
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxChargePower_L2")
    @JsonPropertyDescription("Maximum charge power on phase L2 in W, defined by min(EV, EVSE)\r\nRelates to: \r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L2\r\n\r\n\r\n")
    private double maxChargePowerL2;
    /**
     * Maximum charge power on phase L3 in W, defined by min(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L3
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxChargePower_L3")
    @JsonPropertyDescription("Maximum charge power on phase L3 in W, defined by min(EV, EVSE)\r\nRelates to: \r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L3\r\n\r\n\r\n")
    private double maxChargePowerL3;
    /**
     * Minimum discharge (injected) power in W, defined by max(EV, EVSE) at unity power factor. Value &gt;= 0. +
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. +
     * It corresponds to the WMax attribute in the IEC 61850.
     * It is usually equivalent to the rated apparent power of the EV when discharging (VAMax attribute in the IEC 61850).
     * 
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower
     * 
     * 
     * 
     */
    @JsonProperty("minDischargePower")
    @JsonPropertyDescription("Minimum discharge (injected) power in W, defined by max(EV, EVSE) at unity power factor. Value &gt;= 0. +\r\nThis field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. +\r\nIt corresponds to the WMax attribute in the IEC 61850.\r\nIt is usually equivalent to the rated apparent power of the EV when discharging (VAMax attribute in the IEC 61850).\r\n\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower\r\n\r\n")
    private double minDischargePower;
    /**
     * Minimum discharge power on phase L2 in W, defined by max(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L2
     * 
     * 
     * 
     */
    @JsonProperty("minDischargePower_L2")
    @JsonPropertyDescription("Minimum discharge power on phase L2 in W, defined by max(EV, EVSE).  Value &gt;= 0.\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L2\r\n\r\n")
    private double minDischargePowerL2;
    /**
     * Minimum discharge power on phase L3 in W, defined by max(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L3
     * 
     * 
     * 
     */
    @JsonProperty("minDischargePower_L3")
    @JsonPropertyDescription("Minimum discharge power on phase L3 in W, defined by max(EV, EVSE).  Value &gt;= 0.\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L3\r\n\r\n")
    private double minDischargePowerL3;
    /**
     * Maximum discharge (injected) power in W, defined by min(EV, EVSE) at unity power factor.  Value &gt;= 0.
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargePower")
    @JsonPropertyDescription("Maximum discharge (injected) power in W, defined by min(EV, EVSE) at unity power factor.  Value &gt;= 0.\r\nThis field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower\r\n\r\n\r\n")
    private double maxDischargePower;
    /**
     * Maximum discharge power on phase L2 in W, defined by min(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePowe_L2
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargePower_L2")
    @JsonPropertyDescription("Maximum discharge power on phase L2 in W, defined by min(EV, EVSE).  Value &gt;= 0.\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePowe_L2\r\n\r\n")
    private double maxDischargePowerL2;
    /**
     * Maximum discharge power on phase L3 in W, defined by min(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower_L3
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargePower_L3")
    @JsonPropertyDescription("Maximum discharge power on phase L3 in W, defined by min(EV, EVSE).  Value &gt;= 0.\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower_L3\r\n\r\n")
    private double maxDischargePowerL3;
    /**
     * Minimum charge current in A, defined by max(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumChargeCurrent
     * 
     * 
     * 
     */
    @JsonProperty("minChargeCurrent")
    @JsonPropertyDescription("Minimum charge current in A, defined by max(EV, EVSE)\r\nRelates to: \r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumChargeCurrent\r\n\r\n")
    private double minChargeCurrent;
    /**
     * Maximum charge current in A, defined by min(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumChargeCurrent
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxChargeCurrent")
    @JsonPropertyDescription("Maximum charge current in A, defined by min(EV, EVSE)\r\nRelates to: \r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumChargeCurrent\r\n\r\n\r\n")
    private double maxChargeCurrent;
    /**
     * Minimum discharge current in A, defined by max(EV, EVSE).  Value &gt;= 0.
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumDischargeCurrent
     * 
     * 
     * 
     * 
     */
    @JsonProperty("minDischargeCurrent")
    @JsonPropertyDescription("Minimum discharge current in A, defined by max(EV, EVSE).  Value &gt;= 0.\r\nRelates to: \r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumDischargeCurrent\r\n\r\n\r\n")
    private double minDischargeCurrent;
    /**
     * Maximum discharge current in A, defined by min(EV, EVSE).  Value &gt;= 0.
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumDischargeCurrent
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargeCurrent")
    @JsonPropertyDescription("Maximum discharge current in A, defined by min(EV, EVSE).  Value &gt;= 0.\r\nRelates to: \r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumDischargeCurrent\r\n\r\n")
    private double maxDischargeCurrent;
    /**
     * Minimum voltage in V, defined by max(EV, EVSE)
     * Relates to:
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumVoltage
     * 
     * 
     * 
     */
    @JsonProperty("minVoltage")
    @JsonPropertyDescription("Minimum voltage in V, defined by max(EV, EVSE)\r\nRelates to:\r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumVoltage\r\n\r\n")
    private double minVoltage;
    /**
     * Maximum voltage in V, defined by min(EV, EVSE)
     * Relates to:
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumVoltage
     * 
     * 
     * 
     */
    @JsonProperty("maxVoltage")
    @JsonPropertyDescription("Maximum voltage in V, defined by min(EV, EVSE)\r\nRelates to:\r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumVoltage\r\n\r\n")
    private double maxVoltage;
    /**
     * Energy to requested state of charge in Wh
     * Relates to:
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evTargetEnergyRequest")
    @JsonPropertyDescription("Energy to requested state of charge in Wh\r\nRelates to:\r\n*ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest\r\n\r\n")
    private double evTargetEnergyRequest;
    /**
     * Energy to minimum allowed state of charge in Wh
     * Relates to:
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMinimumEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evMinEnergyRequest")
    @JsonPropertyDescription("Energy to minimum allowed state of charge in Wh\r\nRelates to:\r\n*ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMinimumEnergyRequest\r\n\r\n")
    private double evMinEnergyRequest;
    /**
     * Energy to maximum state of charge in Wh
     * Relates to:
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMaximumEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evMaxEnergyRequest")
    @JsonPropertyDescription("Energy to maximum state of charge in Wh\r\nRelates to:\r\n*ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMaximumEnergyRequest\r\n\r\n")
    private double evMaxEnergyRequest;
    /**
     * Energy (in Wh) to minimum state of charge for cycling (V2X) activity. 
     * Positive value means that current state of charge is below V2X range.
     * Relates to:
     * *ISO 15118-20*: Dynamic_SEReqControlModeType: EVMinimumV2XEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evMinV2XEnergyRequest")
    @JsonPropertyDescription("Energy (in Wh) to minimum state of charge for cycling (V2X) activity. \r\nPositive value means that current state of charge is below V2X range.\r\nRelates to:\r\n*ISO 15118-20*: Dynamic_SEReqControlModeType: EVMinimumV2XEnergyRequest\r\n\r\n")
    private double evMinV2XEnergyRequest;
    /**
     * Energy (in Wh) to maximum state of charge for cycling (V2X) activity.
     * Negative value indicates that current state of charge is above V2X range.
     * Relates to:
     * *ISO 15118-20*: Dynamic_SEReqControlModeType: EVMaximumV2XEnergyRequest
     * 
     * 
     * 
     * 
     */
    @JsonProperty("evMaxV2XEnergyRequest")
    @JsonPropertyDescription("Energy (in Wh) to maximum state of charge for cycling (V2X) activity.\r\nNegative value indicates that current state of charge is above V2X range.\r\nRelates to:\r\n*ISO 15118-20*: Dynamic_SEReqControlModeType: EVMaximumV2XEnergyRequest\r\n\r\n\r\n")
    private double evMaxV2XEnergyRequest;
    /**
     * Target state of charge at departure as percentage.
     * Relates to:
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: TargetSOC
     * 
     * 
     * 
     */
    @JsonProperty("targetSoC")
    @JsonPropertyDescription("Target state of charge at departure as percentage.\r\nRelates to:\r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: TargetSOC\r\n\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private int targetSoC;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Minimum charge power in W, defined by max(EV, EVSE).
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower
     * 
     * 
     */
    @JsonProperty("minChargePower")
    public double getMinChargePower() {
        return minChargePower;
    }

    /**
     * Minimum charge power in W, defined by max(EV, EVSE).
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower
     * 
     * 
     */
    @JsonProperty("minChargePower")
    public void setMinChargePower(double minChargePower) {
        this.minChargePower = minChargePower;
    }

    public V2XChargingParameters withMinChargePower(double minChargePower) {
        this.minChargePower = minChargePower;
        return this;
    }

    /**
     * Minimum charge power on phase L2 in W, defined by max(EV, EVSE).
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L2
     * 
     * 
     */
    @JsonProperty("minChargePower_L2")
    public double getMinChargePowerL2() {
        return minChargePowerL2;
    }

    /**
     * Minimum charge power on phase L2 in W, defined by max(EV, EVSE).
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L2
     * 
     * 
     */
    @JsonProperty("minChargePower_L2")
    public void setMinChargePowerL2(double minChargePowerL2) {
        this.minChargePowerL2 = minChargePowerL2;
    }

    public V2XChargingParameters withMinChargePowerL2(double minChargePowerL2) {
        this.minChargePowerL2 = minChargePowerL2;
        return this;
    }

    /**
     * Minimum charge power on phase L3 in W, defined by max(EV, EVSE).
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L3
     * 
     * 
     */
    @JsonProperty("minChargePower_L3")
    public double getMinChargePowerL3() {
        return minChargePowerL3;
    }

    /**
     * Minimum charge power on phase L3 in W, defined by max(EV, EVSE).
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L3
     * 
     * 
     */
    @JsonProperty("minChargePower_L3")
    public void setMinChargePowerL3(double minChargePowerL3) {
        this.minChargePowerL3 = minChargePowerL3;
    }

    public V2XChargingParameters withMinChargePowerL3(double minChargePowerL3) {
        this.minChargePowerL3 = minChargePowerL3;
        return this;
    }

    /**
     * Maximum charge (absorbed) power in W, defined by min(EV, EVSE) at unity power factor. +
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * It corresponds to the ChaWMax attribute in the IEC 61850.
     * It is usually equivalent to the rated apparent power of the EV when discharging (ChaVAMax) in IEC 61850. +
     * 
     * Relates to: 
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower
     * 
     * 
     * 
     */
    @JsonProperty("maxChargePower")
    public double getMaxChargePower() {
        return maxChargePower;
    }

    /**
     * Maximum charge (absorbed) power in W, defined by min(EV, EVSE) at unity power factor. +
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * It corresponds to the ChaWMax attribute in the IEC 61850.
     * It is usually equivalent to the rated apparent power of the EV when discharging (ChaVAMax) in IEC 61850. +
     * 
     * Relates to: 
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower
     * 
     * 
     * 
     */
    @JsonProperty("maxChargePower")
    public void setMaxChargePower(double maxChargePower) {
        this.maxChargePower = maxChargePower;
    }

    public V2XChargingParameters withMaxChargePower(double maxChargePower) {
        this.maxChargePower = maxChargePower;
        return this;
    }

    /**
     * Maximum charge power on phase L2 in W, defined by min(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L2
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxChargePower_L2")
    public double getMaxChargePowerL2() {
        return maxChargePowerL2;
    }

    /**
     * Maximum charge power on phase L2 in W, defined by min(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L2
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxChargePower_L2")
    public void setMaxChargePowerL2(double maxChargePowerL2) {
        this.maxChargePowerL2 = maxChargePowerL2;
    }

    public V2XChargingParameters withMaxChargePowerL2(double maxChargePowerL2) {
        this.maxChargePowerL2 = maxChargePowerL2;
        return this;
    }

    /**
     * Maximum charge power on phase L3 in W, defined by min(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L3
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxChargePower_L3")
    public double getMaxChargePowerL3() {
        return maxChargePowerL3;
    }

    /**
     * Maximum charge power on phase L3 in W, defined by min(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L3
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxChargePower_L3")
    public void setMaxChargePowerL3(double maxChargePowerL3) {
        this.maxChargePowerL3 = maxChargePowerL3;
    }

    public V2XChargingParameters withMaxChargePowerL3(double maxChargePowerL3) {
        this.maxChargePowerL3 = maxChargePowerL3;
        return this;
    }

    /**
     * Minimum discharge (injected) power in W, defined by max(EV, EVSE) at unity power factor. Value &gt;= 0. +
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. +
     * It corresponds to the WMax attribute in the IEC 61850.
     * It is usually equivalent to the rated apparent power of the EV when discharging (VAMax attribute in the IEC 61850).
     * 
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower
     * 
     * 
     * 
     */
    @JsonProperty("minDischargePower")
    public double getMinDischargePower() {
        return minDischargePower;
    }

    /**
     * Minimum discharge (injected) power in W, defined by max(EV, EVSE) at unity power factor. Value &gt;= 0. +
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. +
     * It corresponds to the WMax attribute in the IEC 61850.
     * It is usually equivalent to the rated apparent power of the EV when discharging (VAMax attribute in the IEC 61850).
     * 
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower
     * 
     * 
     * 
     */
    @JsonProperty("minDischargePower")
    public void setMinDischargePower(double minDischargePower) {
        this.minDischargePower = minDischargePower;
    }

    public V2XChargingParameters withMinDischargePower(double minDischargePower) {
        this.minDischargePower = minDischargePower;
        return this;
    }

    /**
     * Minimum discharge power on phase L2 in W, defined by max(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L2
     * 
     * 
     * 
     */
    @JsonProperty("minDischargePower_L2")
    public double getMinDischargePowerL2() {
        return minDischargePowerL2;
    }

    /**
     * Minimum discharge power on phase L2 in W, defined by max(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L2
     * 
     * 
     * 
     */
    @JsonProperty("minDischargePower_L2")
    public void setMinDischargePowerL2(double minDischargePowerL2) {
        this.minDischargePowerL2 = minDischargePowerL2;
    }

    public V2XChargingParameters withMinDischargePowerL2(double minDischargePowerL2) {
        this.minDischargePowerL2 = minDischargePowerL2;
        return this;
    }

    /**
     * Minimum discharge power on phase L3 in W, defined by max(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L3
     * 
     * 
     * 
     */
    @JsonProperty("minDischargePower_L3")
    public double getMinDischargePowerL3() {
        return minDischargePowerL3;
    }

    /**
     * Minimum discharge power on phase L3 in W, defined by max(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L3
     * 
     * 
     * 
     */
    @JsonProperty("minDischargePower_L3")
    public void setMinDischargePowerL3(double minDischargePowerL3) {
        this.minDischargePowerL3 = minDischargePowerL3;
    }

    public V2XChargingParameters withMinDischargePowerL3(double minDischargePowerL3) {
        this.minDischargePowerL3 = minDischargePowerL3;
        return this;
    }

    /**
     * Maximum discharge (injected) power in W, defined by min(EV, EVSE) at unity power factor.  Value &gt;= 0.
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargePower")
    public double getMaxDischargePower() {
        return maxDischargePower;
    }

    /**
     * Maximum discharge (injected) power in W, defined by min(EV, EVSE) at unity power factor.  Value &gt;= 0.
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargePower")
    public void setMaxDischargePower(double maxDischargePower) {
        this.maxDischargePower = maxDischargePower;
    }

    public V2XChargingParameters withMaxDischargePower(double maxDischargePower) {
        this.maxDischargePower = maxDischargePower;
        return this;
    }

    /**
     * Maximum discharge power on phase L2 in W, defined by min(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePowe_L2
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargePower_L2")
    public double getMaxDischargePowerL2() {
        return maxDischargePowerL2;
    }

    /**
     * Maximum discharge power on phase L2 in W, defined by min(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePowe_L2
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargePower_L2")
    public void setMaxDischargePowerL2(double maxDischargePowerL2) {
        this.maxDischargePowerL2 = maxDischargePowerL2;
    }

    public V2XChargingParameters withMaxDischargePowerL2(double maxDischargePowerL2) {
        this.maxDischargePowerL2 = maxDischargePowerL2;
        return this;
    }

    /**
     * Maximum discharge power on phase L3 in W, defined by min(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower_L3
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargePower_L3")
    public double getMaxDischargePowerL3() {
        return maxDischargePowerL3;
    }

    /**
     * Maximum discharge power on phase L3 in W, defined by min(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower_L3
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargePower_L3")
    public void setMaxDischargePowerL3(double maxDischargePowerL3) {
        this.maxDischargePowerL3 = maxDischargePowerL3;
    }

    public V2XChargingParameters withMaxDischargePowerL3(double maxDischargePowerL3) {
        this.maxDischargePowerL3 = maxDischargePowerL3;
        return this;
    }

    /**
     * Minimum charge current in A, defined by max(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumChargeCurrent
     * 
     * 
     * 
     */
    @JsonProperty("minChargeCurrent")
    public double getMinChargeCurrent() {
        return minChargeCurrent;
    }

    /**
     * Minimum charge current in A, defined by max(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumChargeCurrent
     * 
     * 
     * 
     */
    @JsonProperty("minChargeCurrent")
    public void setMinChargeCurrent(double minChargeCurrent) {
        this.minChargeCurrent = minChargeCurrent;
    }

    public V2XChargingParameters withMinChargeCurrent(double minChargeCurrent) {
        this.minChargeCurrent = minChargeCurrent;
        return this;
    }

    /**
     * Maximum charge current in A, defined by min(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumChargeCurrent
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxChargeCurrent")
    public double getMaxChargeCurrent() {
        return maxChargeCurrent;
    }

    /**
     * Maximum charge current in A, defined by min(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumChargeCurrent
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxChargeCurrent")
    public void setMaxChargeCurrent(double maxChargeCurrent) {
        this.maxChargeCurrent = maxChargeCurrent;
    }

    public V2XChargingParameters withMaxChargeCurrent(double maxChargeCurrent) {
        this.maxChargeCurrent = maxChargeCurrent;
        return this;
    }

    /**
     * Minimum discharge current in A, defined by max(EV, EVSE).  Value &gt;= 0.
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumDischargeCurrent
     * 
     * 
     * 
     * 
     */
    @JsonProperty("minDischargeCurrent")
    public double getMinDischargeCurrent() {
        return minDischargeCurrent;
    }

    /**
     * Minimum discharge current in A, defined by max(EV, EVSE).  Value &gt;= 0.
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumDischargeCurrent
     * 
     * 
     * 
     * 
     */
    @JsonProperty("minDischargeCurrent")
    public void setMinDischargeCurrent(double minDischargeCurrent) {
        this.minDischargeCurrent = minDischargeCurrent;
    }

    public V2XChargingParameters withMinDischargeCurrent(double minDischargeCurrent) {
        this.minDischargeCurrent = minDischargeCurrent;
        return this;
    }

    /**
     * Maximum discharge current in A, defined by min(EV, EVSE).  Value &gt;= 0.
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumDischargeCurrent
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargeCurrent")
    public double getMaxDischargeCurrent() {
        return maxDischargeCurrent;
    }

    /**
     * Maximum discharge current in A, defined by min(EV, EVSE).  Value &gt;= 0.
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumDischargeCurrent
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargeCurrent")
    public void setMaxDischargeCurrent(double maxDischargeCurrent) {
        this.maxDischargeCurrent = maxDischargeCurrent;
    }

    public V2XChargingParameters withMaxDischargeCurrent(double maxDischargeCurrent) {
        this.maxDischargeCurrent = maxDischargeCurrent;
        return this;
    }

    /**
     * Minimum voltage in V, defined by max(EV, EVSE)
     * Relates to:
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumVoltage
     * 
     * 
     * 
     */
    @JsonProperty("minVoltage")
    public double getMinVoltage() {
        return minVoltage;
    }

    /**
     * Minimum voltage in V, defined by max(EV, EVSE)
     * Relates to:
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumVoltage
     * 
     * 
     * 
     */
    @JsonProperty("minVoltage")
    public void setMinVoltage(double minVoltage) {
        this.minVoltage = minVoltage;
    }

    public V2XChargingParameters withMinVoltage(double minVoltage) {
        this.minVoltage = minVoltage;
        return this;
    }

    /**
     * Maximum voltage in V, defined by min(EV, EVSE)
     * Relates to:
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumVoltage
     * 
     * 
     * 
     */
    @JsonProperty("maxVoltage")
    public double getMaxVoltage() {
        return maxVoltage;
    }

    /**
     * Maximum voltage in V, defined by min(EV, EVSE)
     * Relates to:
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumVoltage
     * 
     * 
     * 
     */
    @JsonProperty("maxVoltage")
    public void setMaxVoltage(double maxVoltage) {
        this.maxVoltage = maxVoltage;
    }

    public V2XChargingParameters withMaxVoltage(double maxVoltage) {
        this.maxVoltage = maxVoltage;
        return this;
    }

    /**
     * Energy to requested state of charge in Wh
     * Relates to:
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evTargetEnergyRequest")
    public double getEvTargetEnergyRequest() {
        return evTargetEnergyRequest;
    }

    /**
     * Energy to requested state of charge in Wh
     * Relates to:
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evTargetEnergyRequest")
    public void setEvTargetEnergyRequest(double evTargetEnergyRequest) {
        this.evTargetEnergyRequest = evTargetEnergyRequest;
    }

    public V2XChargingParameters withEvTargetEnergyRequest(double evTargetEnergyRequest) {
        this.evTargetEnergyRequest = evTargetEnergyRequest;
        return this;
    }

    /**
     * Energy to minimum allowed state of charge in Wh
     * Relates to:
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMinimumEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evMinEnergyRequest")
    public double getEvMinEnergyRequest() {
        return evMinEnergyRequest;
    }

    /**
     * Energy to minimum allowed state of charge in Wh
     * Relates to:
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMinimumEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evMinEnergyRequest")
    public void setEvMinEnergyRequest(double evMinEnergyRequest) {
        this.evMinEnergyRequest = evMinEnergyRequest;
    }

    public V2XChargingParameters withEvMinEnergyRequest(double evMinEnergyRequest) {
        this.evMinEnergyRequest = evMinEnergyRequest;
        return this;
    }

    /**
     * Energy to maximum state of charge in Wh
     * Relates to:
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMaximumEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evMaxEnergyRequest")
    public double getEvMaxEnergyRequest() {
        return evMaxEnergyRequest;
    }

    /**
     * Energy to maximum state of charge in Wh
     * Relates to:
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMaximumEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evMaxEnergyRequest")
    public void setEvMaxEnergyRequest(double evMaxEnergyRequest) {
        this.evMaxEnergyRequest = evMaxEnergyRequest;
    }

    public V2XChargingParameters withEvMaxEnergyRequest(double evMaxEnergyRequest) {
        this.evMaxEnergyRequest = evMaxEnergyRequest;
        return this;
    }

    /**
     * Energy (in Wh) to minimum state of charge for cycling (V2X) activity. 
     * Positive value means that current state of charge is below V2X range.
     * Relates to:
     * *ISO 15118-20*: Dynamic_SEReqControlModeType: EVMinimumV2XEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evMinV2XEnergyRequest")
    public double getEvMinV2XEnergyRequest() {
        return evMinV2XEnergyRequest;
    }

    /**
     * Energy (in Wh) to minimum state of charge for cycling (V2X) activity. 
     * Positive value means that current state of charge is below V2X range.
     * Relates to:
     * *ISO 15118-20*: Dynamic_SEReqControlModeType: EVMinimumV2XEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evMinV2XEnergyRequest")
    public void setEvMinV2XEnergyRequest(double evMinV2XEnergyRequest) {
        this.evMinV2XEnergyRequest = evMinV2XEnergyRequest;
    }

    public V2XChargingParameters withEvMinV2XEnergyRequest(double evMinV2XEnergyRequest) {
        this.evMinV2XEnergyRequest = evMinV2XEnergyRequest;
        return this;
    }

    /**
     * Energy (in Wh) to maximum state of charge for cycling (V2X) activity.
     * Negative value indicates that current state of charge is above V2X range.
     * Relates to:
     * *ISO 15118-20*: Dynamic_SEReqControlModeType: EVMaximumV2XEnergyRequest
     * 
     * 
     * 
     * 
     */
    @JsonProperty("evMaxV2XEnergyRequest")
    public double getEvMaxV2XEnergyRequest() {
        return evMaxV2XEnergyRequest;
    }

    /**
     * Energy (in Wh) to maximum state of charge for cycling (V2X) activity.
     * Negative value indicates that current state of charge is above V2X range.
     * Relates to:
     * *ISO 15118-20*: Dynamic_SEReqControlModeType: EVMaximumV2XEnergyRequest
     * 
     * 
     * 
     * 
     */
    @JsonProperty("evMaxV2XEnergyRequest")
    public void setEvMaxV2XEnergyRequest(double evMaxV2XEnergyRequest) {
        this.evMaxV2XEnergyRequest = evMaxV2XEnergyRequest;
    }

    public V2XChargingParameters withEvMaxV2XEnergyRequest(double evMaxV2XEnergyRequest) {
        this.evMaxV2XEnergyRequest = evMaxV2XEnergyRequest;
        return this;
    }

    /**
     * Target state of charge at departure as percentage.
     * Relates to:
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: TargetSOC
     * 
     * 
     * 
     */
    @JsonProperty("targetSoC")
    public int getTargetSoC() {
        return targetSoC;
    }

    /**
     * Target state of charge at departure as percentage.
     * Relates to:
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: TargetSOC
     * 
     * 
     * 
     */
    @JsonProperty("targetSoC")
    public void setTargetSoC(int targetSoC) {
        this.targetSoC = targetSoC;
    }

    public V2XChargingParameters withTargetSoC(int targetSoC) {
        this.targetSoC = targetSoC;
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

    public V2XChargingParameters withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V2XChargingParameters.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("minChargePower");
        sb.append('=');
        sb.append(this.minChargePower);
        sb.append(',');
        sb.append("minChargePowerL2");
        sb.append('=');
        sb.append(this.minChargePowerL2);
        sb.append(',');
        sb.append("minChargePowerL3");
        sb.append('=');
        sb.append(this.minChargePowerL3);
        sb.append(',');
        sb.append("maxChargePower");
        sb.append('=');
        sb.append(this.maxChargePower);
        sb.append(',');
        sb.append("maxChargePowerL2");
        sb.append('=');
        sb.append(this.maxChargePowerL2);
        sb.append(',');
        sb.append("maxChargePowerL3");
        sb.append('=');
        sb.append(this.maxChargePowerL3);
        sb.append(',');
        sb.append("minDischargePower");
        sb.append('=');
        sb.append(this.minDischargePower);
        sb.append(',');
        sb.append("minDischargePowerL2");
        sb.append('=');
        sb.append(this.minDischargePowerL2);
        sb.append(',');
        sb.append("minDischargePowerL3");
        sb.append('=');
        sb.append(this.minDischargePowerL3);
        sb.append(',');
        sb.append("maxDischargePower");
        sb.append('=');
        sb.append(this.maxDischargePower);
        sb.append(',');
        sb.append("maxDischargePowerL2");
        sb.append('=');
        sb.append(this.maxDischargePowerL2);
        sb.append(',');
        sb.append("maxDischargePowerL3");
        sb.append('=');
        sb.append(this.maxDischargePowerL3);
        sb.append(',');
        sb.append("minChargeCurrent");
        sb.append('=');
        sb.append(this.minChargeCurrent);
        sb.append(',');
        sb.append("maxChargeCurrent");
        sb.append('=');
        sb.append(this.maxChargeCurrent);
        sb.append(',');
        sb.append("minDischargeCurrent");
        sb.append('=');
        sb.append(this.minDischargeCurrent);
        sb.append(',');
        sb.append("maxDischargeCurrent");
        sb.append('=');
        sb.append(this.maxDischargeCurrent);
        sb.append(',');
        sb.append("minVoltage");
        sb.append('=');
        sb.append(this.minVoltage);
        sb.append(',');
        sb.append("maxVoltage");
        sb.append('=');
        sb.append(this.maxVoltage);
        sb.append(',');
        sb.append("evTargetEnergyRequest");
        sb.append('=');
        sb.append(this.evTargetEnergyRequest);
        sb.append(',');
        sb.append("evMinEnergyRequest");
        sb.append('=');
        sb.append(this.evMinEnergyRequest);
        sb.append(',');
        sb.append("evMaxEnergyRequest");
        sb.append('=');
        sb.append(this.evMaxEnergyRequest);
        sb.append(',');
        sb.append("evMinV2XEnergyRequest");
        sb.append('=');
        sb.append(this.evMinV2XEnergyRequest);
        sb.append(',');
        sb.append("evMaxV2XEnergyRequest");
        sb.append('=');
        sb.append(this.evMaxV2XEnergyRequest);
        sb.append(',');
        sb.append("targetSoC");
        sb.append('=');
        sb.append(this.targetSoC);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minChargePower)^(Double.doubleToLongBits(this.minChargePower)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evMinV2XEnergyRequest)^(Double.doubleToLongBits(this.evMinV2XEnergyRequest)>>> 32))));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minChargeCurrent)^(Double.doubleToLongBits(this.minChargeCurrent)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minDischargePowerL2)^(Double.doubleToLongBits(this.minDischargePowerL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evMaxEnergyRequest)^(Double.doubleToLongBits(this.evMaxEnergyRequest)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minChargePowerL2)^(Double.doubleToLongBits(this.minChargePowerL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minDischargePowerL3)^(Double.doubleToLongBits(this.minDischargePowerL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minChargePowerL3)^(Double.doubleToLongBits(this.minChargePowerL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxDischargeCurrent)^(Double.doubleToLongBits(this.maxDischargeCurrent)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evMinEnergyRequest)^(Double.doubleToLongBits(this.evMinEnergyRequest)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxDischargePower)^(Double.doubleToLongBits(this.maxDischargePower)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minDischargePower)^(Double.doubleToLongBits(this.minDischargePower)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxChargePowerL3)^(Double.doubleToLongBits(this.maxChargePowerL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxChargeCurrent)^(Double.doubleToLongBits(this.maxChargeCurrent)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxChargePowerL2)^(Double.doubleToLongBits(this.maxChargePowerL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minVoltage)^(Double.doubleToLongBits(this.minVoltage)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxVoltage)^(Double.doubleToLongBits(this.maxVoltage)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxDischargePowerL2)^(Double.doubleToLongBits(this.maxDischargePowerL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxDischargePowerL3)^(Double.doubleToLongBits(this.maxDischargePowerL3)>>> 32))));
        result = ((result* 31)+ this.targetSoC);
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxChargePower)^(Double.doubleToLongBits(this.maxChargePower)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minDischargeCurrent)^(Double.doubleToLongBits(this.minDischargeCurrent)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evTargetEnergyRequest)^(Double.doubleToLongBits(this.evTargetEnergyRequest)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evMaxV2XEnergyRequest)^(Double.doubleToLongBits(this.evMaxV2XEnergyRequest)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof V2XChargingParameters) == false) {
            return false;
        }
        V2XChargingParameters rhs = ((V2XChargingParameters) other);
        return (((((((((((((((((((((((((Double.doubleToLongBits(this.minChargePower) == Double.doubleToLongBits(rhs.minChargePower))&&(Double.doubleToLongBits(this.evMinV2XEnergyRequest) == Double.doubleToLongBits(rhs.evMinV2XEnergyRequest)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(Double.doubleToLongBits(this.minChargeCurrent) == Double.doubleToLongBits(rhs.minChargeCurrent)))&&(Double.doubleToLongBits(this.minDischargePowerL2) == Double.doubleToLongBits(rhs.minDischargePowerL2)))&&(Double.doubleToLongBits(this.evMaxEnergyRequest) == Double.doubleToLongBits(rhs.evMaxEnergyRequest)))&&(Double.doubleToLongBits(this.minChargePowerL2) == Double.doubleToLongBits(rhs.minChargePowerL2)))&&(Double.doubleToLongBits(this.minDischargePowerL3) == Double.doubleToLongBits(rhs.minDischargePowerL3)))&&(Double.doubleToLongBits(this.minChargePowerL3) == Double.doubleToLongBits(rhs.minChargePowerL3)))&&(Double.doubleToLongBits(this.maxDischargeCurrent) == Double.doubleToLongBits(rhs.maxDischargeCurrent)))&&(Double.doubleToLongBits(this.evMinEnergyRequest) == Double.doubleToLongBits(rhs.evMinEnergyRequest)))&&(Double.doubleToLongBits(this.maxDischargePower) == Double.doubleToLongBits(rhs.maxDischargePower)))&&(Double.doubleToLongBits(this.minDischargePower) == Double.doubleToLongBits(rhs.minDischargePower)))&&(Double.doubleToLongBits(this.maxChargePowerL3) == Double.doubleToLongBits(rhs.maxChargePowerL3)))&&(Double.doubleToLongBits(this.maxChargeCurrent) == Double.doubleToLongBits(rhs.maxChargeCurrent)))&&(Double.doubleToLongBits(this.maxChargePowerL2) == Double.doubleToLongBits(rhs.maxChargePowerL2)))&&(Double.doubleToLongBits(this.minVoltage) == Double.doubleToLongBits(rhs.minVoltage)))&&(Double.doubleToLongBits(this.maxVoltage) == Double.doubleToLongBits(rhs.maxVoltage)))&&(Double.doubleToLongBits(this.maxDischargePowerL2) == Double.doubleToLongBits(rhs.maxDischargePowerL2)))&&(Double.doubleToLongBits(this.maxDischargePowerL3) == Double.doubleToLongBits(rhs.maxDischargePowerL3)))&&(this.targetSoC == rhs.targetSoC))&&(Double.doubleToLongBits(this.maxChargePower) == Double.doubleToLongBits(rhs.maxChargePower)))&&(Double.doubleToLongBits(this.minDischargeCurrent) == Double.doubleToLongBits(rhs.minDischargeCurrent)))&&(Double.doubleToLongBits(this.evTargetEnergyRequest) == Double.doubleToLongBits(rhs.evTargetEnergyRequest)))&&(Double.doubleToLongBits(this.evMaxV2XEnergyRequest) == Double.doubleToLongBits(rhs.evMaxV2XEnergyRequest)));
    }

}
