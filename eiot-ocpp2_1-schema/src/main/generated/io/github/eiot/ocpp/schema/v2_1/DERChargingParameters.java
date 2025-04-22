
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;


/**
 * *(2.1)* DERChargingParametersType is used in ChargingNeedsType during an ISO 15118-20 session for AC_BPT_DER to report the inverter settings related to DER control that were agreed between EVSE and EV.
 * 
 * Fields starting with "ev" contain values from the EV.
 * Other fields contain a value that is supported by both EV and EVSE.
 * 
 * DERChargingParametersType type is only relevant in case of an ISO 15118-20 AC_BPT_DER/AC_DER charging session.
 * 
 * NOTE: All these fields have values greater or equal to zero (i.e. are non-negative)
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "evSupportedDERControl",
    "evOverExcitedMaxDischargePower",
    "evOverExcitedPowerFactor",
    "evUnderExcitedMaxDischargePower",
    "evUnderExcitedPowerFactor",
    "maxApparentPower",
    "maxChargeApparentPower",
    "maxChargeApparentPower_L2",
    "maxChargeApparentPower_L3",
    "maxDischargeApparentPower",
    "maxDischargeApparentPower_L2",
    "maxDischargeApparentPower_L3",
    "maxChargeReactivePower",
    "maxChargeReactivePower_L2",
    "maxChargeReactivePower_L3",
    "minChargeReactivePower",
    "minChargeReactivePower_L2",
    "minChargeReactivePower_L3",
    "maxDischargeReactivePower",
    "maxDischargeReactivePower_L2",
    "maxDischargeReactivePower_L3",
    "minDischargeReactivePower",
    "minDischargeReactivePower_L2",
    "minDischargeReactivePower_L3",
    "nominalVoltage",
    "nominalVoltageOffset",
    "maxNominalVoltage",
    "minNominalVoltage",
    "evInverterManufacturer",
    "evInverterModel",
    "evInverterSerialNumber",
    "evInverterSwVersion",
    "evInverterHwVersion",
    "evIslandingDetectionMethod",
    "evIslandingTripTime",
    "evMaximumLevel1DCInjection",
    "evDurationLevel1DCInjection",
    "evMaximumLevel2DCInjection",
    "evDurationLevel2DCInjection",
    "evReactiveSusceptance",
    "evSessionTotalDischargeEnergyAvailable",
    "customData"
})
public class DERChargingParameters {

    /**
     * DER control functions supported by EV. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType:DERControlFunctions (bitmap)
     * 
     * 
     */
    @JsonProperty("evSupportedDERControl")
    @JsonPropertyDescription("DER control functions supported by EV. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType:DERControlFunctions (bitmap)\r\n")
    @Size(min = 1)
    @Valid
    private List<DERControlEnum> evSupportedDERControl = new ArrayList<DERControlEnum>();
    /**
     * Rated maximum injected active power by EV, at specified over-excited power factor (overExcitedPowerFactor). +
     * It can also be defined as the rated maximum discharge power at the rated minimum injected reactive power value. This means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to overExcitedMaximumDischargePower to meet the minimum reactive power requirements. +
     * Corresponds to the WOvPF attribute in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedMaximumDischargePower
     * 
     * 
     */
    @JsonProperty("evOverExcitedMaxDischargePower")
    @JsonPropertyDescription("Rated maximum injected active power by EV, at specified over-excited power factor (overExcitedPowerFactor). +\r\nIt can also be defined as the rated maximum discharge power at the rated minimum injected reactive power value. This means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to overExcitedMaximumDischargePower to meet the minimum reactive power requirements. +\r\nCorresponds to the WOvPF attribute in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedMaximumDischargePower\r\n")
    private double evOverExcitedMaxDischargePower;
    /**
     * EV power factor when injecting (over excited) the minimum reactive power. +
     * Corresponds to the OvPF attribute in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedPowerFactor
     * 
     * 
     */
    @JsonProperty("evOverExcitedPowerFactor")
    @JsonPropertyDescription("EV power factor when injecting (over excited) the minimum reactive power. +\r\nCorresponds to the OvPF attribute in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedPowerFactor\r\n")
    private double evOverExcitedPowerFactor;
    /**
     * Rated maximum injected active power by EV supported at specified under-excited power factor (EVUnderExcitedPowerFactor). +
     * It can also be defined as the rated maximum dischargePower at the rated minimum absorbed reactive power value.
     * This means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to underExcitedMaximumDischargePower to meet the minimum reactive power requirements. +
     * This corresponds to the WUnPF attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedMaximumDischargePower
     * 
     * 
     */
    @JsonProperty("evUnderExcitedMaxDischargePower")
    @JsonPropertyDescription("Rated maximum injected active power by EV supported at specified under-excited power factor (EVUnderExcitedPowerFactor). +\r\nIt can also be defined as the rated maximum dischargePower at the rated minimum absorbed reactive power value.\r\nThis means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to underExcitedMaximumDischargePower to meet the minimum reactive power requirements. +\r\nThis corresponds to the WUnPF attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedMaximumDischargePower\r\n")
    private double evUnderExcitedMaxDischargePower;
    /**
     * EV power factor when injecting (under excited) the minimum reactive power. +
     * Corresponds to the OvPF attribute in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedPowerFactor
     * 
     * 
     */
    @JsonProperty("evUnderExcitedPowerFactor")
    @JsonPropertyDescription("EV power factor when injecting (under excited) the minimum reactive power. +\r\nCorresponds to the OvPF attribute in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedPowerFactor\r\n")
    private double evUnderExcitedPowerFactor;
    /**
     * Rated maximum total apparent power, defined by min(EV, EVSE) in va.
     * Corresponds to the VAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumApparentPower
     * 
     * 
     */
    @JsonProperty("maxApparentPower")
    @JsonPropertyDescription("Rated maximum total apparent power, defined by min(EV, EVSE) in va.\r\nCorresponds to the VAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumApparentPower\r\n")
    private double maxApparentPower;
    /**
     * Rated maximum absorbed apparent power, defined by min(EV, EVSE) in va. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *     Corresponds to the ChaVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower
     * 
     * 
     */
    @JsonProperty("maxChargeApparentPower")
    @JsonPropertyDescription("Rated maximum absorbed apparent power, defined by min(EV, EVSE) in va. +\r\n    This field represents the sum of all phases, unless values are provided for L2 and L3,\r\n    in which case this field represents phase L1. +\r\n    Corresponds to the ChaVAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower\r\n")
    private double maxChargeApparentPower;
    /**
     * Rated maximum absorbed apparent power on phase L2, defined by min(EV, EVSE) in va.
     * Corresponds to the ChaVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L2
     * 
     * 
     */
    @JsonProperty("maxChargeApparentPower_L2")
    @JsonPropertyDescription("Rated maximum absorbed apparent power on phase L2, defined by min(EV, EVSE) in va.\r\nCorresponds to the ChaVAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L2\r\n")
    private double maxChargeApparentPowerL2;
    /**
     * Rated maximum absorbed apparent power on phase L3, defined by min(EV, EVSE) in va.
     * Corresponds to the ChaVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L3
     * 
     * 
     */
    @JsonProperty("maxChargeApparentPower_L3")
    @JsonPropertyDescription("Rated maximum absorbed apparent power on phase L3, defined by min(EV, EVSE) in va.\r\nCorresponds to the ChaVAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L3\r\n")
    private double maxChargeApparentPowerL3;
    /**
     * Rated maximum injected apparent power, defined by min(EV, EVSE) in va. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *     Corresponds to the DisVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower
     * 
     * 
     */
    @JsonProperty("maxDischargeApparentPower")
    @JsonPropertyDescription("Rated maximum injected apparent power, defined by min(EV, EVSE) in va. +\r\n    This field represents the sum of all phases, unless values are provided for L2 and L3,\r\n    in which case this field represents phase L1. +\r\n    Corresponds to the DisVAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower\r\n")
    private double maxDischargeApparentPower;
    /**
     * Rated maximum injected apparent power on phase L2, defined by min(EV, EVSE) in va. +
     *     Corresponds to the DisVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L2
     * 
     * 
     */
    @JsonProperty("maxDischargeApparentPower_L2")
    @JsonPropertyDescription("Rated maximum injected apparent power on phase L2, defined by min(EV, EVSE) in va. +\r\n    Corresponds to the DisVAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L2\r\n")
    private double maxDischargeApparentPowerL2;
    /**
     * Rated maximum injected apparent power on phase L3, defined by min(EV, EVSE) in va. +
     *     Corresponds to the DisVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L3
     * 
     * 
     */
    @JsonProperty("maxDischargeApparentPower_L3")
    @JsonPropertyDescription("Rated maximum injected apparent power on phase L3, defined by min(EV, EVSE) in va. +\r\n    Corresponds to the DisVAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L3\r\n")
    private double maxDischargeApparentPowerL3;
    /**
     * Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     * Corresponds to the AvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower
     * 
     * 
     */
    @JsonProperty("maxChargeReactivePower")
    @JsonPropertyDescription("Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars. +\r\n    This field represents the sum of all phases, unless values are provided for L2 and L3,\r\n    in which case this field represents phase L1. +\r\nCorresponds to the AvarMax attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower\r\n")
    private double maxChargeReactivePower;
    /**
     * Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L2. +
     * Corresponds to the AvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("maxChargeReactivePower_L2")
    @JsonPropertyDescription("Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L2. +\r\nCorresponds to the AvarMax attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L2\r\n")
    private double maxChargeReactivePowerL2;
    /**
     * Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L3. +
     * Corresponds to the AvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("maxChargeReactivePower_L3")
    @JsonPropertyDescription("Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L3. +\r\nCorresponds to the AvarMax attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L3\r\n")
    private double maxChargeReactivePowerL3;
    /**
     * Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower
     * 
     * 
     */
    @JsonProperty("minChargeReactivePower")
    @JsonPropertyDescription("Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars. +\r\n    This field represents the sum of all phases, unless values are provided for L2 and L3,\r\n    in which case this field represents phase L1. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower\r\n")
    private double minChargeReactivePower;
    /**
     * Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L2. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("minChargeReactivePower_L2")
    @JsonPropertyDescription("Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L2. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L2\r\n")
    private double minChargeReactivePowerL2;
    /**
     * Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L3. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("minChargeReactivePower_L3")
    @JsonPropertyDescription("Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L3. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L3\r\n")
    private double minChargeReactivePowerL3;
    /**
     * Rated maximum injected reactive power, defined by min(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     * Corresponds to the IvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower
     * 
     * 
     */
    @JsonProperty("maxDischargeReactivePower")
    @JsonPropertyDescription("Rated maximum injected reactive power, defined by min(EV, EVSE), in vars. +\r\n    This field represents the sum of all phases, unless values are provided for L2 and L3,\r\n    in which case this field represents phase L1. +\r\nCorresponds to the IvarMax attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower\r\n")
    private double maxDischargeReactivePower;
    /**
     * Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L2. +
     * Corresponds to the IvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("maxDischargeReactivePower_L2")
    @JsonPropertyDescription("Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L2. +\r\nCorresponds to the IvarMax attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L2\r\n")
    private double maxDischargeReactivePowerL2;
    /**
     * Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L3. +
     * Corresponds to the IvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("maxDischargeReactivePower_L3")
    @JsonPropertyDescription("Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L3. +\r\nCorresponds to the IvarMax attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L3\r\n")
    private double maxDischargeReactivePowerL3;
    /**
     * Rated minimum injected reactive power, defined by max(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower
     * 
     * 
     */
    @JsonProperty("minDischargeReactivePower")
    @JsonPropertyDescription("Rated minimum injected reactive power, defined by max(EV, EVSE), in vars. +\r\n    This field represents the sum of all phases, unless values are provided for L2 and L3,\r\n    in which case this field represents phase L1. +\r\n        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower\r\n")
    private double minDischargeReactivePower;
    /**
     * Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L2. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("minDischargeReactivePower_L2")
    @JsonPropertyDescription("Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L2. +\r\n        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L2\r\n")
    private double minDischargeReactivePowerL2;
    /**
     * Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L3. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("minDischargeReactivePower_L3")
    @JsonPropertyDescription("Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L3. +\r\n        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L3\r\n")
    private double minDischargeReactivePowerL3;
    /**
     * Line voltage supported by EVSE and EV.
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltage
     * 
     * 
     */
    @JsonProperty("nominalVoltage")
    @JsonPropertyDescription("Line voltage supported by EVSE and EV.\r\n        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltage\r\n")
    private double nominalVoltage;
    /**
     * The nominal AC voltage (rms) offset between the Charging Station's electrical connection point and the utility’s point of common coupling. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltageOffset
     * 
     * 
     */
    @JsonProperty("nominalVoltageOffset")
    @JsonPropertyDescription("The nominal AC voltage (rms) offset between the Charging Station's electrical connection point and the utility\u2019s point of common coupling. +\r\n        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltageOffset\r\n")
    private double nominalVoltageOffset;
    /**
     * Maximum AC rms voltage, as defined by min(EV, EVSE)  to operate with. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumNominalVoltage
     * 
     * 
     */
    @JsonProperty("maxNominalVoltage")
    @JsonPropertyDescription("Maximum AC rms voltage, as defined by min(EV, EVSE)  to operate with. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumNominalVoltage\r\n")
    private double maxNominalVoltage;
    /**
     * Minimum AC rms voltage, as defined by max(EV, EVSE)  to operate with. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumNominalVoltage
     * 
     * 
     */
    @JsonProperty("minNominalVoltage")
    @JsonPropertyDescription("Minimum AC rms voltage, as defined by max(EV, EVSE)  to operate with. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumNominalVoltage\r\n")
    private double minNominalVoltage;
    /**
     * Manufacturer of the EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterManufacturer
     * 
     * 
     */
    @JsonProperty("evInverterManufacturer")
    @JsonPropertyDescription("Manufacturer of the EV inverter. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterManufacturer\r\n")
    @Size(max = 50)
    private String evInverterManufacturer;
    /**
     * Model name of the EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterModel
     * 
     * 
     */
    @JsonProperty("evInverterModel")
    @JsonPropertyDescription("Model name of the EV inverter. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterModel\r\n")
    @Size(max = 50)
    private String evInverterModel;
    /**
     * Serial number of the EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSerialNumber
     * 
     * 
     */
    @JsonProperty("evInverterSerialNumber")
    @JsonPropertyDescription("Serial number of the EV inverter. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSerialNumber\r\n")
    @Size(max = 50)
    private String evInverterSerialNumber;
    /**
     * Software version of EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSwVersion
     * 
     * 
     */
    @JsonProperty("evInverterSwVersion")
    @JsonPropertyDescription("Software version of EV inverter. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSwVersion\r\n")
    @Size(max = 50)
    private String evInverterSwVersion;
    /**
     * Hardware version of EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterHwVersion
     * 
     * 
     */
    @JsonProperty("evInverterHwVersion")
    @JsonPropertyDescription("Hardware version of EV inverter. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterHwVersion\r\n")
    @Size(max = 50)
    private String evInverterHwVersion;
    /**
     * Type of islanding detection method. Only mandatory when islanding detection is required at the site, as set in the ISO 15118 Service Details configuration. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingDetectionMethod
     * 
     * 
     */
    @JsonProperty("evIslandingDetectionMethod")
    @JsonPropertyDescription("Type of islanding detection method. Only mandatory when islanding detection is required at the site, as set in the ISO 15118 Service Details configuration. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingDetectionMethod\r\n")
    @Size(min = 1)
    @Valid
    private List<IslandingDetectionEnum> evIslandingDetectionMethod = new ArrayList<IslandingDetectionEnum>();
    /**
     * Time after which EV will trip if an island has been detected. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingTripTime
     * 
     * 
     */
    @JsonProperty("evIslandingTripTime")
    @JsonPropertyDescription("Time after which EV will trip if an island has been detected. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingTripTime\r\n")
    private double evIslandingTripTime;
    /**
     * Maximum injected DC current allowed at level 1 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel1DCInjection
     * 
     * 
     */
    @JsonProperty("evMaximumLevel1DCInjection")
    @JsonPropertyDescription("Maximum injected DC current allowed at level 1 charging. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel1DCInjection\r\n")
    private double evMaximumLevel1DCInjection;
    /**
     * Maximum allowed duration of DC injection at level 1 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel1DCInjection
     * 
     * 
     */
    @JsonProperty("evDurationLevel1DCInjection")
    @JsonPropertyDescription("Maximum allowed duration of DC injection at level 1 charging. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel1DCInjection\r\n")
    private double evDurationLevel1DCInjection;
    /**
     * Maximum injected DC current allowed at level 2 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel2DCInjection
     * 
     * 
     */
    @JsonProperty("evMaximumLevel2DCInjection")
    @JsonPropertyDescription("Maximum injected DC current allowed at level 2 charging. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel2DCInjection\r\n")
    private double evMaximumLevel2DCInjection;
    /**
     * Maximum allowed duration of DC injection at level 2 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel2DCInjection
     * 
     * 
     */
    @JsonProperty("evDurationLevel2DCInjection")
    @JsonPropertyDescription("Maximum allowed duration of DC injection at level 2 charging. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel2DCInjection\r\n")
    private double evDurationLevel2DCInjection;
    /**
     * 	Measure of the susceptibility of the circuit to reactance, in Siemens (S). +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVReactiveSusceptance
     * 
     * 
     * 
     * 
     */
    @JsonProperty("evReactiveSusceptance")
    @JsonPropertyDescription("\tMeasure of the susceptibility of the circuit to reactance, in Siemens (S). +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVReactiveSusceptance\r\n\r\n\r\n")
    private double evReactiveSusceptance;
    /**
     * Total energy value, in Wh, that EV is allowed to provide during the entire V2G session. The value is independent of the V2X Cycling area. Once this value reaches the value of 0, the EV may block any attempt to discharge in order to protect the battery health.
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVSessionTotalDischargeEnergyAvailable
     * 
     * 
     * 
     * 
     */
    @JsonProperty("evSessionTotalDischargeEnergyAvailable")
    @JsonPropertyDescription("Total energy value, in Wh, that EV is allowed to provide during the entire V2G session. The value is independent of the V2X Cycling area. Once this value reaches the value of 0, the EV may block any attempt to discharge in order to protect the battery health.\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVSessionTotalDischargeEnergyAvailable\r\n\r\n\r\n")
    private double evSessionTotalDischargeEnergyAvailable;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * DER control functions supported by EV. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType:DERControlFunctions (bitmap)
     * 
     * 
     */
    @JsonProperty("evSupportedDERControl")
    public List<DERControlEnum> getEvSupportedDERControl() {
        return evSupportedDERControl;
    }

    /**
     * DER control functions supported by EV. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType:DERControlFunctions (bitmap)
     * 
     * 
     */
    @JsonProperty("evSupportedDERControl")
    public void setEvSupportedDERControl(List<DERControlEnum> evSupportedDERControl) {
        this.evSupportedDERControl = evSupportedDERControl;
    }

    public DERChargingParameters withEvSupportedDERControl(List<DERControlEnum> evSupportedDERControl) {
        this.evSupportedDERControl = evSupportedDERControl;
        return this;
    }

    /**
     * Rated maximum injected active power by EV, at specified over-excited power factor (overExcitedPowerFactor). +
     * It can also be defined as the rated maximum discharge power at the rated minimum injected reactive power value. This means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to overExcitedMaximumDischargePower to meet the minimum reactive power requirements. +
     * Corresponds to the WOvPF attribute in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedMaximumDischargePower
     * 
     * 
     */
    @JsonProperty("evOverExcitedMaxDischargePower")
    public double getEvOverExcitedMaxDischargePower() {
        return evOverExcitedMaxDischargePower;
    }

    /**
     * Rated maximum injected active power by EV, at specified over-excited power factor (overExcitedPowerFactor). +
     * It can also be defined as the rated maximum discharge power at the rated minimum injected reactive power value. This means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to overExcitedMaximumDischargePower to meet the minimum reactive power requirements. +
     * Corresponds to the WOvPF attribute in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedMaximumDischargePower
     * 
     * 
     */
    @JsonProperty("evOverExcitedMaxDischargePower")
    public void setEvOverExcitedMaxDischargePower(double evOverExcitedMaxDischargePower) {
        this.evOverExcitedMaxDischargePower = evOverExcitedMaxDischargePower;
    }

    public DERChargingParameters withEvOverExcitedMaxDischargePower(double evOverExcitedMaxDischargePower) {
        this.evOverExcitedMaxDischargePower = evOverExcitedMaxDischargePower;
        return this;
    }

    /**
     * EV power factor when injecting (over excited) the minimum reactive power. +
     * Corresponds to the OvPF attribute in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedPowerFactor
     * 
     * 
     */
    @JsonProperty("evOverExcitedPowerFactor")
    public double getEvOverExcitedPowerFactor() {
        return evOverExcitedPowerFactor;
    }

    /**
     * EV power factor when injecting (over excited) the minimum reactive power. +
     * Corresponds to the OvPF attribute in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedPowerFactor
     * 
     * 
     */
    @JsonProperty("evOverExcitedPowerFactor")
    public void setEvOverExcitedPowerFactor(double evOverExcitedPowerFactor) {
        this.evOverExcitedPowerFactor = evOverExcitedPowerFactor;
    }

    public DERChargingParameters withEvOverExcitedPowerFactor(double evOverExcitedPowerFactor) {
        this.evOverExcitedPowerFactor = evOverExcitedPowerFactor;
        return this;
    }

    /**
     * Rated maximum injected active power by EV supported at specified under-excited power factor (EVUnderExcitedPowerFactor). +
     * It can also be defined as the rated maximum dischargePower at the rated minimum absorbed reactive power value.
     * This means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to underExcitedMaximumDischargePower to meet the minimum reactive power requirements. +
     * This corresponds to the WUnPF attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedMaximumDischargePower
     * 
     * 
     */
    @JsonProperty("evUnderExcitedMaxDischargePower")
    public double getEvUnderExcitedMaxDischargePower() {
        return evUnderExcitedMaxDischargePower;
    }

    /**
     * Rated maximum injected active power by EV supported at specified under-excited power factor (EVUnderExcitedPowerFactor). +
     * It can also be defined as the rated maximum dischargePower at the rated minimum absorbed reactive power value.
     * This means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to underExcitedMaximumDischargePower to meet the minimum reactive power requirements. +
     * This corresponds to the WUnPF attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedMaximumDischargePower
     * 
     * 
     */
    @JsonProperty("evUnderExcitedMaxDischargePower")
    public void setEvUnderExcitedMaxDischargePower(double evUnderExcitedMaxDischargePower) {
        this.evUnderExcitedMaxDischargePower = evUnderExcitedMaxDischargePower;
    }

    public DERChargingParameters withEvUnderExcitedMaxDischargePower(double evUnderExcitedMaxDischargePower) {
        this.evUnderExcitedMaxDischargePower = evUnderExcitedMaxDischargePower;
        return this;
    }

    /**
     * EV power factor when injecting (under excited) the minimum reactive power. +
     * Corresponds to the OvPF attribute in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedPowerFactor
     * 
     * 
     */
    @JsonProperty("evUnderExcitedPowerFactor")
    public double getEvUnderExcitedPowerFactor() {
        return evUnderExcitedPowerFactor;
    }

    /**
     * EV power factor when injecting (under excited) the minimum reactive power. +
     * Corresponds to the OvPF attribute in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedPowerFactor
     * 
     * 
     */
    @JsonProperty("evUnderExcitedPowerFactor")
    public void setEvUnderExcitedPowerFactor(double evUnderExcitedPowerFactor) {
        this.evUnderExcitedPowerFactor = evUnderExcitedPowerFactor;
    }

    public DERChargingParameters withEvUnderExcitedPowerFactor(double evUnderExcitedPowerFactor) {
        this.evUnderExcitedPowerFactor = evUnderExcitedPowerFactor;
        return this;
    }

    /**
     * Rated maximum total apparent power, defined by min(EV, EVSE) in va.
     * Corresponds to the VAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumApparentPower
     * 
     * 
     */
    @JsonProperty("maxApparentPower")
    public double getMaxApparentPower() {
        return maxApparentPower;
    }

    /**
     * Rated maximum total apparent power, defined by min(EV, EVSE) in va.
     * Corresponds to the VAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumApparentPower
     * 
     * 
     */
    @JsonProperty("maxApparentPower")
    public void setMaxApparentPower(double maxApparentPower) {
        this.maxApparentPower = maxApparentPower;
    }

    public DERChargingParameters withMaxApparentPower(double maxApparentPower) {
        this.maxApparentPower = maxApparentPower;
        return this;
    }

    /**
     * Rated maximum absorbed apparent power, defined by min(EV, EVSE) in va. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *     Corresponds to the ChaVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower
     * 
     * 
     */
    @JsonProperty("maxChargeApparentPower")
    public double getMaxChargeApparentPower() {
        return maxChargeApparentPower;
    }

    /**
     * Rated maximum absorbed apparent power, defined by min(EV, EVSE) in va. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *     Corresponds to the ChaVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower
     * 
     * 
     */
    @JsonProperty("maxChargeApparentPower")
    public void setMaxChargeApparentPower(double maxChargeApparentPower) {
        this.maxChargeApparentPower = maxChargeApparentPower;
    }

    public DERChargingParameters withMaxChargeApparentPower(double maxChargeApparentPower) {
        this.maxChargeApparentPower = maxChargeApparentPower;
        return this;
    }

    /**
     * Rated maximum absorbed apparent power on phase L2, defined by min(EV, EVSE) in va.
     * Corresponds to the ChaVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L2
     * 
     * 
     */
    @JsonProperty("maxChargeApparentPower_L2")
    public double getMaxChargeApparentPowerL2() {
        return maxChargeApparentPowerL2;
    }

    /**
     * Rated maximum absorbed apparent power on phase L2, defined by min(EV, EVSE) in va.
     * Corresponds to the ChaVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L2
     * 
     * 
     */
    @JsonProperty("maxChargeApparentPower_L2")
    public void setMaxChargeApparentPowerL2(double maxChargeApparentPowerL2) {
        this.maxChargeApparentPowerL2 = maxChargeApparentPowerL2;
    }

    public DERChargingParameters withMaxChargeApparentPowerL2(double maxChargeApparentPowerL2) {
        this.maxChargeApparentPowerL2 = maxChargeApparentPowerL2;
        return this;
    }

    /**
     * Rated maximum absorbed apparent power on phase L3, defined by min(EV, EVSE) in va.
     * Corresponds to the ChaVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L3
     * 
     * 
     */
    @JsonProperty("maxChargeApparentPower_L3")
    public double getMaxChargeApparentPowerL3() {
        return maxChargeApparentPowerL3;
    }

    /**
     * Rated maximum absorbed apparent power on phase L3, defined by min(EV, EVSE) in va.
     * Corresponds to the ChaVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L3
     * 
     * 
     */
    @JsonProperty("maxChargeApparentPower_L3")
    public void setMaxChargeApparentPowerL3(double maxChargeApparentPowerL3) {
        this.maxChargeApparentPowerL3 = maxChargeApparentPowerL3;
    }

    public DERChargingParameters withMaxChargeApparentPowerL3(double maxChargeApparentPowerL3) {
        this.maxChargeApparentPowerL3 = maxChargeApparentPowerL3;
        return this;
    }

    /**
     * Rated maximum injected apparent power, defined by min(EV, EVSE) in va. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *     Corresponds to the DisVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower
     * 
     * 
     */
    @JsonProperty("maxDischargeApparentPower")
    public double getMaxDischargeApparentPower() {
        return maxDischargeApparentPower;
    }

    /**
     * Rated maximum injected apparent power, defined by min(EV, EVSE) in va. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *     Corresponds to the DisVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower
     * 
     * 
     */
    @JsonProperty("maxDischargeApparentPower")
    public void setMaxDischargeApparentPower(double maxDischargeApparentPower) {
        this.maxDischargeApparentPower = maxDischargeApparentPower;
    }

    public DERChargingParameters withMaxDischargeApparentPower(double maxDischargeApparentPower) {
        this.maxDischargeApparentPower = maxDischargeApparentPower;
        return this;
    }

    /**
     * Rated maximum injected apparent power on phase L2, defined by min(EV, EVSE) in va. +
     *     Corresponds to the DisVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L2
     * 
     * 
     */
    @JsonProperty("maxDischargeApparentPower_L2")
    public double getMaxDischargeApparentPowerL2() {
        return maxDischargeApparentPowerL2;
    }

    /**
     * Rated maximum injected apparent power on phase L2, defined by min(EV, EVSE) in va. +
     *     Corresponds to the DisVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L2
     * 
     * 
     */
    @JsonProperty("maxDischargeApparentPower_L2")
    public void setMaxDischargeApparentPowerL2(double maxDischargeApparentPowerL2) {
        this.maxDischargeApparentPowerL2 = maxDischargeApparentPowerL2;
    }

    public DERChargingParameters withMaxDischargeApparentPowerL2(double maxDischargeApparentPowerL2) {
        this.maxDischargeApparentPowerL2 = maxDischargeApparentPowerL2;
        return this;
    }

    /**
     * Rated maximum injected apparent power on phase L3, defined by min(EV, EVSE) in va. +
     *     Corresponds to the DisVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L3
     * 
     * 
     */
    @JsonProperty("maxDischargeApparentPower_L3")
    public double getMaxDischargeApparentPowerL3() {
        return maxDischargeApparentPowerL3;
    }

    /**
     * Rated maximum injected apparent power on phase L3, defined by min(EV, EVSE) in va. +
     *     Corresponds to the DisVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L3
     * 
     * 
     */
    @JsonProperty("maxDischargeApparentPower_L3")
    public void setMaxDischargeApparentPowerL3(double maxDischargeApparentPowerL3) {
        this.maxDischargeApparentPowerL3 = maxDischargeApparentPowerL3;
    }

    public DERChargingParameters withMaxDischargeApparentPowerL3(double maxDischargeApparentPowerL3) {
        this.maxDischargeApparentPowerL3 = maxDischargeApparentPowerL3;
        return this;
    }

    /**
     * Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     * Corresponds to the AvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower
     * 
     * 
     */
    @JsonProperty("maxChargeReactivePower")
    public double getMaxChargeReactivePower() {
        return maxChargeReactivePower;
    }

    /**
     * Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     * Corresponds to the AvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower
     * 
     * 
     */
    @JsonProperty("maxChargeReactivePower")
    public void setMaxChargeReactivePower(double maxChargeReactivePower) {
        this.maxChargeReactivePower = maxChargeReactivePower;
    }

    public DERChargingParameters withMaxChargeReactivePower(double maxChargeReactivePower) {
        this.maxChargeReactivePower = maxChargeReactivePower;
        return this;
    }

    /**
     * Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L2. +
     * Corresponds to the AvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("maxChargeReactivePower_L2")
    public double getMaxChargeReactivePowerL2() {
        return maxChargeReactivePowerL2;
    }

    /**
     * Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L2. +
     * Corresponds to the AvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("maxChargeReactivePower_L2")
    public void setMaxChargeReactivePowerL2(double maxChargeReactivePowerL2) {
        this.maxChargeReactivePowerL2 = maxChargeReactivePowerL2;
    }

    public DERChargingParameters withMaxChargeReactivePowerL2(double maxChargeReactivePowerL2) {
        this.maxChargeReactivePowerL2 = maxChargeReactivePowerL2;
        return this;
    }

    /**
     * Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L3. +
     * Corresponds to the AvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("maxChargeReactivePower_L3")
    public double getMaxChargeReactivePowerL3() {
        return maxChargeReactivePowerL3;
    }

    /**
     * Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L3. +
     * Corresponds to the AvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("maxChargeReactivePower_L3")
    public void setMaxChargeReactivePowerL3(double maxChargeReactivePowerL3) {
        this.maxChargeReactivePowerL3 = maxChargeReactivePowerL3;
    }

    public DERChargingParameters withMaxChargeReactivePowerL3(double maxChargeReactivePowerL3) {
        this.maxChargeReactivePowerL3 = maxChargeReactivePowerL3;
        return this;
    }

    /**
     * Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower
     * 
     * 
     */
    @JsonProperty("minChargeReactivePower")
    public double getMinChargeReactivePower() {
        return minChargeReactivePower;
    }

    /**
     * Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower
     * 
     * 
     */
    @JsonProperty("minChargeReactivePower")
    public void setMinChargeReactivePower(double minChargeReactivePower) {
        this.minChargeReactivePower = minChargeReactivePower;
    }

    public DERChargingParameters withMinChargeReactivePower(double minChargeReactivePower) {
        this.minChargeReactivePower = minChargeReactivePower;
        return this;
    }

    /**
     * Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L2. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("minChargeReactivePower_L2")
    public double getMinChargeReactivePowerL2() {
        return minChargeReactivePowerL2;
    }

    /**
     * Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L2. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("minChargeReactivePower_L2")
    public void setMinChargeReactivePowerL2(double minChargeReactivePowerL2) {
        this.minChargeReactivePowerL2 = minChargeReactivePowerL2;
    }

    public DERChargingParameters withMinChargeReactivePowerL2(double minChargeReactivePowerL2) {
        this.minChargeReactivePowerL2 = minChargeReactivePowerL2;
        return this;
    }

    /**
     * Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L3. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("minChargeReactivePower_L3")
    public double getMinChargeReactivePowerL3() {
        return minChargeReactivePowerL3;
    }

    /**
     * Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L3. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("minChargeReactivePower_L3")
    public void setMinChargeReactivePowerL3(double minChargeReactivePowerL3) {
        this.minChargeReactivePowerL3 = minChargeReactivePowerL3;
    }

    public DERChargingParameters withMinChargeReactivePowerL3(double minChargeReactivePowerL3) {
        this.minChargeReactivePowerL3 = minChargeReactivePowerL3;
        return this;
    }

    /**
     * Rated maximum injected reactive power, defined by min(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     * Corresponds to the IvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower
     * 
     * 
     */
    @JsonProperty("maxDischargeReactivePower")
    public double getMaxDischargeReactivePower() {
        return maxDischargeReactivePower;
    }

    /**
     * Rated maximum injected reactive power, defined by min(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     * Corresponds to the IvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower
     * 
     * 
     */
    @JsonProperty("maxDischargeReactivePower")
    public void setMaxDischargeReactivePower(double maxDischargeReactivePower) {
        this.maxDischargeReactivePower = maxDischargeReactivePower;
    }

    public DERChargingParameters withMaxDischargeReactivePower(double maxDischargeReactivePower) {
        this.maxDischargeReactivePower = maxDischargeReactivePower;
        return this;
    }

    /**
     * Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L2. +
     * Corresponds to the IvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("maxDischargeReactivePower_L2")
    public double getMaxDischargeReactivePowerL2() {
        return maxDischargeReactivePowerL2;
    }

    /**
     * Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L2. +
     * Corresponds to the IvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("maxDischargeReactivePower_L2")
    public void setMaxDischargeReactivePowerL2(double maxDischargeReactivePowerL2) {
        this.maxDischargeReactivePowerL2 = maxDischargeReactivePowerL2;
    }

    public DERChargingParameters withMaxDischargeReactivePowerL2(double maxDischargeReactivePowerL2) {
        this.maxDischargeReactivePowerL2 = maxDischargeReactivePowerL2;
        return this;
    }

    /**
     * Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L3. +
     * Corresponds to the IvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("maxDischargeReactivePower_L3")
    public double getMaxDischargeReactivePowerL3() {
        return maxDischargeReactivePowerL3;
    }

    /**
     * Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L3. +
     * Corresponds to the IvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("maxDischargeReactivePower_L3")
    public void setMaxDischargeReactivePowerL3(double maxDischargeReactivePowerL3) {
        this.maxDischargeReactivePowerL3 = maxDischargeReactivePowerL3;
    }

    public DERChargingParameters withMaxDischargeReactivePowerL3(double maxDischargeReactivePowerL3) {
        this.maxDischargeReactivePowerL3 = maxDischargeReactivePowerL3;
        return this;
    }

    /**
     * Rated minimum injected reactive power, defined by max(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower
     * 
     * 
     */
    @JsonProperty("minDischargeReactivePower")
    public double getMinDischargeReactivePower() {
        return minDischargeReactivePower;
    }

    /**
     * Rated minimum injected reactive power, defined by max(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower
     * 
     * 
     */
    @JsonProperty("minDischargeReactivePower")
    public void setMinDischargeReactivePower(double minDischargeReactivePower) {
        this.minDischargeReactivePower = minDischargeReactivePower;
    }

    public DERChargingParameters withMinDischargeReactivePower(double minDischargeReactivePower) {
        this.minDischargeReactivePower = minDischargeReactivePower;
        return this;
    }

    /**
     * Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L2. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("minDischargeReactivePower_L2")
    public double getMinDischargeReactivePowerL2() {
        return minDischargeReactivePowerL2;
    }

    /**
     * Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L2. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("minDischargeReactivePower_L2")
    public void setMinDischargeReactivePowerL2(double minDischargeReactivePowerL2) {
        this.minDischargeReactivePowerL2 = minDischargeReactivePowerL2;
    }

    public DERChargingParameters withMinDischargeReactivePowerL2(double minDischargeReactivePowerL2) {
        this.minDischargeReactivePowerL2 = minDischargeReactivePowerL2;
        return this;
    }

    /**
     * Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L3. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("minDischargeReactivePower_L3")
    public double getMinDischargeReactivePowerL3() {
        return minDischargeReactivePowerL3;
    }

    /**
     * Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L3. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("minDischargeReactivePower_L3")
    public void setMinDischargeReactivePowerL3(double minDischargeReactivePowerL3) {
        this.minDischargeReactivePowerL3 = minDischargeReactivePowerL3;
    }

    public DERChargingParameters withMinDischargeReactivePowerL3(double minDischargeReactivePowerL3) {
        this.minDischargeReactivePowerL3 = minDischargeReactivePowerL3;
        return this;
    }

    /**
     * Line voltage supported by EVSE and EV.
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltage
     * 
     * 
     */
    @JsonProperty("nominalVoltage")
    public double getNominalVoltage() {
        return nominalVoltage;
    }

    /**
     * Line voltage supported by EVSE and EV.
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltage
     * 
     * 
     */
    @JsonProperty("nominalVoltage")
    public void setNominalVoltage(double nominalVoltage) {
        this.nominalVoltage = nominalVoltage;
    }

    public DERChargingParameters withNominalVoltage(double nominalVoltage) {
        this.nominalVoltage = nominalVoltage;
        return this;
    }

    /**
     * The nominal AC voltage (rms) offset between the Charging Station's electrical connection point and the utility’s point of common coupling. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltageOffset
     * 
     * 
     */
    @JsonProperty("nominalVoltageOffset")
    public double getNominalVoltageOffset() {
        return nominalVoltageOffset;
    }

    /**
     * The nominal AC voltage (rms) offset between the Charging Station's electrical connection point and the utility’s point of common coupling. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltageOffset
     * 
     * 
     */
    @JsonProperty("nominalVoltageOffset")
    public void setNominalVoltageOffset(double nominalVoltageOffset) {
        this.nominalVoltageOffset = nominalVoltageOffset;
    }

    public DERChargingParameters withNominalVoltageOffset(double nominalVoltageOffset) {
        this.nominalVoltageOffset = nominalVoltageOffset;
        return this;
    }

    /**
     * Maximum AC rms voltage, as defined by min(EV, EVSE)  to operate with. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumNominalVoltage
     * 
     * 
     */
    @JsonProperty("maxNominalVoltage")
    public double getMaxNominalVoltage() {
        return maxNominalVoltage;
    }

    /**
     * Maximum AC rms voltage, as defined by min(EV, EVSE)  to operate with. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumNominalVoltage
     * 
     * 
     */
    @JsonProperty("maxNominalVoltage")
    public void setMaxNominalVoltage(double maxNominalVoltage) {
        this.maxNominalVoltage = maxNominalVoltage;
    }

    public DERChargingParameters withMaxNominalVoltage(double maxNominalVoltage) {
        this.maxNominalVoltage = maxNominalVoltage;
        return this;
    }

    /**
     * Minimum AC rms voltage, as defined by max(EV, EVSE)  to operate with. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumNominalVoltage
     * 
     * 
     */
    @JsonProperty("minNominalVoltage")
    public double getMinNominalVoltage() {
        return minNominalVoltage;
    }

    /**
     * Minimum AC rms voltage, as defined by max(EV, EVSE)  to operate with. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumNominalVoltage
     * 
     * 
     */
    @JsonProperty("minNominalVoltage")
    public void setMinNominalVoltage(double minNominalVoltage) {
        this.minNominalVoltage = minNominalVoltage;
    }

    public DERChargingParameters withMinNominalVoltage(double minNominalVoltage) {
        this.minNominalVoltage = minNominalVoltage;
        return this;
    }

    /**
     * Manufacturer of the EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterManufacturer
     * 
     * 
     */
    @JsonProperty("evInverterManufacturer")
    public String getEvInverterManufacturer() {
        return evInverterManufacturer;
    }

    /**
     * Manufacturer of the EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterManufacturer
     * 
     * 
     */
    @JsonProperty("evInverterManufacturer")
    public void setEvInverterManufacturer(String evInverterManufacturer) {
        this.evInverterManufacturer = evInverterManufacturer;
    }

    public DERChargingParameters withEvInverterManufacturer(String evInverterManufacturer) {
        this.evInverterManufacturer = evInverterManufacturer;
        return this;
    }

    /**
     * Model name of the EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterModel
     * 
     * 
     */
    @JsonProperty("evInverterModel")
    public String getEvInverterModel() {
        return evInverterModel;
    }

    /**
     * Model name of the EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterModel
     * 
     * 
     */
    @JsonProperty("evInverterModel")
    public void setEvInverterModel(String evInverterModel) {
        this.evInverterModel = evInverterModel;
    }

    public DERChargingParameters withEvInverterModel(String evInverterModel) {
        this.evInverterModel = evInverterModel;
        return this;
    }

    /**
     * Serial number of the EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSerialNumber
     * 
     * 
     */
    @JsonProperty("evInverterSerialNumber")
    public String getEvInverterSerialNumber() {
        return evInverterSerialNumber;
    }

    /**
     * Serial number of the EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSerialNumber
     * 
     * 
     */
    @JsonProperty("evInverterSerialNumber")
    public void setEvInverterSerialNumber(String evInverterSerialNumber) {
        this.evInverterSerialNumber = evInverterSerialNumber;
    }

    public DERChargingParameters withEvInverterSerialNumber(String evInverterSerialNumber) {
        this.evInverterSerialNumber = evInverterSerialNumber;
        return this;
    }

    /**
     * Software version of EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSwVersion
     * 
     * 
     */
    @JsonProperty("evInverterSwVersion")
    public String getEvInverterSwVersion() {
        return evInverterSwVersion;
    }

    /**
     * Software version of EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSwVersion
     * 
     * 
     */
    @JsonProperty("evInverterSwVersion")
    public void setEvInverterSwVersion(String evInverterSwVersion) {
        this.evInverterSwVersion = evInverterSwVersion;
    }

    public DERChargingParameters withEvInverterSwVersion(String evInverterSwVersion) {
        this.evInverterSwVersion = evInverterSwVersion;
        return this;
    }

    /**
     * Hardware version of EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterHwVersion
     * 
     * 
     */
    @JsonProperty("evInverterHwVersion")
    public String getEvInverterHwVersion() {
        return evInverterHwVersion;
    }

    /**
     * Hardware version of EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterHwVersion
     * 
     * 
     */
    @JsonProperty("evInverterHwVersion")
    public void setEvInverterHwVersion(String evInverterHwVersion) {
        this.evInverterHwVersion = evInverterHwVersion;
    }

    public DERChargingParameters withEvInverterHwVersion(String evInverterHwVersion) {
        this.evInverterHwVersion = evInverterHwVersion;
        return this;
    }

    /**
     * Type of islanding detection method. Only mandatory when islanding detection is required at the site, as set in the ISO 15118 Service Details configuration. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingDetectionMethod
     * 
     * 
     */
    @JsonProperty("evIslandingDetectionMethod")
    public List<IslandingDetectionEnum> getEvIslandingDetectionMethod() {
        return evIslandingDetectionMethod;
    }

    /**
     * Type of islanding detection method. Only mandatory when islanding detection is required at the site, as set in the ISO 15118 Service Details configuration. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingDetectionMethod
     * 
     * 
     */
    @JsonProperty("evIslandingDetectionMethod")
    public void setEvIslandingDetectionMethod(List<IslandingDetectionEnum> evIslandingDetectionMethod) {
        this.evIslandingDetectionMethod = evIslandingDetectionMethod;
    }

    public DERChargingParameters withEvIslandingDetectionMethod(List<IslandingDetectionEnum> evIslandingDetectionMethod) {
        this.evIslandingDetectionMethod = evIslandingDetectionMethod;
        return this;
    }

    /**
     * Time after which EV will trip if an island has been detected. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingTripTime
     * 
     * 
     */
    @JsonProperty("evIslandingTripTime")
    public double getEvIslandingTripTime() {
        return evIslandingTripTime;
    }

    /**
     * Time after which EV will trip if an island has been detected. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingTripTime
     * 
     * 
     */
    @JsonProperty("evIslandingTripTime")
    public void setEvIslandingTripTime(double evIslandingTripTime) {
        this.evIslandingTripTime = evIslandingTripTime;
    }

    public DERChargingParameters withEvIslandingTripTime(double evIslandingTripTime) {
        this.evIslandingTripTime = evIslandingTripTime;
        return this;
    }

    /**
     * Maximum injected DC current allowed at level 1 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel1DCInjection
     * 
     * 
     */
    @JsonProperty("evMaximumLevel1DCInjection")
    public double getEvMaximumLevel1DCInjection() {
        return evMaximumLevel1DCInjection;
    }

    /**
     * Maximum injected DC current allowed at level 1 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel1DCInjection
     * 
     * 
     */
    @JsonProperty("evMaximumLevel1DCInjection")
    public void setEvMaximumLevel1DCInjection(double evMaximumLevel1DCInjection) {
        this.evMaximumLevel1DCInjection = evMaximumLevel1DCInjection;
    }

    public DERChargingParameters withEvMaximumLevel1DCInjection(double evMaximumLevel1DCInjection) {
        this.evMaximumLevel1DCInjection = evMaximumLevel1DCInjection;
        return this;
    }

    /**
     * Maximum allowed duration of DC injection at level 1 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel1DCInjection
     * 
     * 
     */
    @JsonProperty("evDurationLevel1DCInjection")
    public double getEvDurationLevel1DCInjection() {
        return evDurationLevel1DCInjection;
    }

    /**
     * Maximum allowed duration of DC injection at level 1 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel1DCInjection
     * 
     * 
     */
    @JsonProperty("evDurationLevel1DCInjection")
    public void setEvDurationLevel1DCInjection(double evDurationLevel1DCInjection) {
        this.evDurationLevel1DCInjection = evDurationLevel1DCInjection;
    }

    public DERChargingParameters withEvDurationLevel1DCInjection(double evDurationLevel1DCInjection) {
        this.evDurationLevel1DCInjection = evDurationLevel1DCInjection;
        return this;
    }

    /**
     * Maximum injected DC current allowed at level 2 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel2DCInjection
     * 
     * 
     */
    @JsonProperty("evMaximumLevel2DCInjection")
    public double getEvMaximumLevel2DCInjection() {
        return evMaximumLevel2DCInjection;
    }

    /**
     * Maximum injected DC current allowed at level 2 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel2DCInjection
     * 
     * 
     */
    @JsonProperty("evMaximumLevel2DCInjection")
    public void setEvMaximumLevel2DCInjection(double evMaximumLevel2DCInjection) {
        this.evMaximumLevel2DCInjection = evMaximumLevel2DCInjection;
    }

    public DERChargingParameters withEvMaximumLevel2DCInjection(double evMaximumLevel2DCInjection) {
        this.evMaximumLevel2DCInjection = evMaximumLevel2DCInjection;
        return this;
    }

    /**
     * Maximum allowed duration of DC injection at level 2 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel2DCInjection
     * 
     * 
     */
    @JsonProperty("evDurationLevel2DCInjection")
    public double getEvDurationLevel2DCInjection() {
        return evDurationLevel2DCInjection;
    }

    /**
     * Maximum allowed duration of DC injection at level 2 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel2DCInjection
     * 
     * 
     */
    @JsonProperty("evDurationLevel2DCInjection")
    public void setEvDurationLevel2DCInjection(double evDurationLevel2DCInjection) {
        this.evDurationLevel2DCInjection = evDurationLevel2DCInjection;
    }

    public DERChargingParameters withEvDurationLevel2DCInjection(double evDurationLevel2DCInjection) {
        this.evDurationLevel2DCInjection = evDurationLevel2DCInjection;
        return this;
    }

    /**
     * 	Measure of the susceptibility of the circuit to reactance, in Siemens (S). +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVReactiveSusceptance
     * 
     * 
     * 
     * 
     */
    @JsonProperty("evReactiveSusceptance")
    public double getEvReactiveSusceptance() {
        return evReactiveSusceptance;
    }

    /**
     * 	Measure of the susceptibility of the circuit to reactance, in Siemens (S). +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVReactiveSusceptance
     * 
     * 
     * 
     * 
     */
    @JsonProperty("evReactiveSusceptance")
    public void setEvReactiveSusceptance(double evReactiveSusceptance) {
        this.evReactiveSusceptance = evReactiveSusceptance;
    }

    public DERChargingParameters withEvReactiveSusceptance(double evReactiveSusceptance) {
        this.evReactiveSusceptance = evReactiveSusceptance;
        return this;
    }

    /**
     * Total energy value, in Wh, that EV is allowed to provide during the entire V2G session. The value is independent of the V2X Cycling area. Once this value reaches the value of 0, the EV may block any attempt to discharge in order to protect the battery health.
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVSessionTotalDischargeEnergyAvailable
     * 
     * 
     * 
     * 
     */
    @JsonProperty("evSessionTotalDischargeEnergyAvailable")
    public double getEvSessionTotalDischargeEnergyAvailable() {
        return evSessionTotalDischargeEnergyAvailable;
    }

    /**
     * Total energy value, in Wh, that EV is allowed to provide during the entire V2G session. The value is independent of the V2X Cycling area. Once this value reaches the value of 0, the EV may block any attempt to discharge in order to protect the battery health.
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVSessionTotalDischargeEnergyAvailable
     * 
     * 
     * 
     * 
     */
    @JsonProperty("evSessionTotalDischargeEnergyAvailable")
    public void setEvSessionTotalDischargeEnergyAvailable(double evSessionTotalDischargeEnergyAvailable) {
        this.evSessionTotalDischargeEnergyAvailable = evSessionTotalDischargeEnergyAvailable;
    }

    public DERChargingParameters withEvSessionTotalDischargeEnergyAvailable(double evSessionTotalDischargeEnergyAvailable) {
        this.evSessionTotalDischargeEnergyAvailable = evSessionTotalDischargeEnergyAvailable;
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

    public DERChargingParameters withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DERChargingParameters.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("evSupportedDERControl");
        sb.append('=');
        sb.append(((this.evSupportedDERControl == null)?"<null>":this.evSupportedDERControl));
        sb.append(',');
        sb.append("evOverExcitedMaxDischargePower");
        sb.append('=');
        sb.append(this.evOverExcitedMaxDischargePower);
        sb.append(',');
        sb.append("evOverExcitedPowerFactor");
        sb.append('=');
        sb.append(this.evOverExcitedPowerFactor);
        sb.append(',');
        sb.append("evUnderExcitedMaxDischargePower");
        sb.append('=');
        sb.append(this.evUnderExcitedMaxDischargePower);
        sb.append(',');
        sb.append("evUnderExcitedPowerFactor");
        sb.append('=');
        sb.append(this.evUnderExcitedPowerFactor);
        sb.append(',');
        sb.append("maxApparentPower");
        sb.append('=');
        sb.append(this.maxApparentPower);
        sb.append(',');
        sb.append("maxChargeApparentPower");
        sb.append('=');
        sb.append(this.maxChargeApparentPower);
        sb.append(',');
        sb.append("maxChargeApparentPowerL2");
        sb.append('=');
        sb.append(this.maxChargeApparentPowerL2);
        sb.append(',');
        sb.append("maxChargeApparentPowerL3");
        sb.append('=');
        sb.append(this.maxChargeApparentPowerL3);
        sb.append(',');
        sb.append("maxDischargeApparentPower");
        sb.append('=');
        sb.append(this.maxDischargeApparentPower);
        sb.append(',');
        sb.append("maxDischargeApparentPowerL2");
        sb.append('=');
        sb.append(this.maxDischargeApparentPowerL2);
        sb.append(',');
        sb.append("maxDischargeApparentPowerL3");
        sb.append('=');
        sb.append(this.maxDischargeApparentPowerL3);
        sb.append(',');
        sb.append("maxChargeReactivePower");
        sb.append('=');
        sb.append(this.maxChargeReactivePower);
        sb.append(',');
        sb.append("maxChargeReactivePowerL2");
        sb.append('=');
        sb.append(this.maxChargeReactivePowerL2);
        sb.append(',');
        sb.append("maxChargeReactivePowerL3");
        sb.append('=');
        sb.append(this.maxChargeReactivePowerL3);
        sb.append(',');
        sb.append("minChargeReactivePower");
        sb.append('=');
        sb.append(this.minChargeReactivePower);
        sb.append(',');
        sb.append("minChargeReactivePowerL2");
        sb.append('=');
        sb.append(this.minChargeReactivePowerL2);
        sb.append(',');
        sb.append("minChargeReactivePowerL3");
        sb.append('=');
        sb.append(this.minChargeReactivePowerL3);
        sb.append(',');
        sb.append("maxDischargeReactivePower");
        sb.append('=');
        sb.append(this.maxDischargeReactivePower);
        sb.append(',');
        sb.append("maxDischargeReactivePowerL2");
        sb.append('=');
        sb.append(this.maxDischargeReactivePowerL2);
        sb.append(',');
        sb.append("maxDischargeReactivePowerL3");
        sb.append('=');
        sb.append(this.maxDischargeReactivePowerL3);
        sb.append(',');
        sb.append("minDischargeReactivePower");
        sb.append('=');
        sb.append(this.minDischargeReactivePower);
        sb.append(',');
        sb.append("minDischargeReactivePowerL2");
        sb.append('=');
        sb.append(this.minDischargeReactivePowerL2);
        sb.append(',');
        sb.append("minDischargeReactivePowerL3");
        sb.append('=');
        sb.append(this.minDischargeReactivePowerL3);
        sb.append(',');
        sb.append("nominalVoltage");
        sb.append('=');
        sb.append(this.nominalVoltage);
        sb.append(',');
        sb.append("nominalVoltageOffset");
        sb.append('=');
        sb.append(this.nominalVoltageOffset);
        sb.append(',');
        sb.append("maxNominalVoltage");
        sb.append('=');
        sb.append(this.maxNominalVoltage);
        sb.append(',');
        sb.append("minNominalVoltage");
        sb.append('=');
        sb.append(this.minNominalVoltage);
        sb.append(',');
        sb.append("evInverterManufacturer");
        sb.append('=');
        sb.append(((this.evInverterManufacturer == null)?"<null>":this.evInverterManufacturer));
        sb.append(',');
        sb.append("evInverterModel");
        sb.append('=');
        sb.append(((this.evInverterModel == null)?"<null>":this.evInverterModel));
        sb.append(',');
        sb.append("evInverterSerialNumber");
        sb.append('=');
        sb.append(((this.evInverterSerialNumber == null)?"<null>":this.evInverterSerialNumber));
        sb.append(',');
        sb.append("evInverterSwVersion");
        sb.append('=');
        sb.append(((this.evInverterSwVersion == null)?"<null>":this.evInverterSwVersion));
        sb.append(',');
        sb.append("evInverterHwVersion");
        sb.append('=');
        sb.append(((this.evInverterHwVersion == null)?"<null>":this.evInverterHwVersion));
        sb.append(',');
        sb.append("evIslandingDetectionMethod");
        sb.append('=');
        sb.append(((this.evIslandingDetectionMethod == null)?"<null>":this.evIslandingDetectionMethod));
        sb.append(',');
        sb.append("evIslandingTripTime");
        sb.append('=');
        sb.append(this.evIslandingTripTime);
        sb.append(',');
        sb.append("evMaximumLevel1DCInjection");
        sb.append('=');
        sb.append(this.evMaximumLevel1DCInjection);
        sb.append(',');
        sb.append("evDurationLevel1DCInjection");
        sb.append('=');
        sb.append(this.evDurationLevel1DCInjection);
        sb.append(',');
        sb.append("evMaximumLevel2DCInjection");
        sb.append('=');
        sb.append(this.evMaximumLevel2DCInjection);
        sb.append(',');
        sb.append("evDurationLevel2DCInjection");
        sb.append('=');
        sb.append(this.evDurationLevel2DCInjection);
        sb.append(',');
        sb.append("evReactiveSusceptance");
        sb.append('=');
        sb.append(this.evReactiveSusceptance);
        sb.append(',');
        sb.append("evSessionTotalDischargeEnergyAvailable");
        sb.append('=');
        sb.append(this.evSessionTotalDischargeEnergyAvailable);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxDischargeReactivePower)^(Double.doubleToLongBits(this.maxDischargeReactivePower)>>> 32))));
        result = ((result* 31)+((this.evInverterHwVersion == null)? 0 :this.evInverterHwVersion.hashCode()));
        result = ((result* 31)+((this.evInverterManufacturer == null)? 0 :this.evInverterManufacturer.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxDischargeApparentPower)^(Double.doubleToLongBits(this.maxDischargeApparentPower)>>> 32))));
        result = ((result* 31)+((this.evInverterModel == null)? 0 :this.evInverterModel.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evDurationLevel1DCInjection)^(Double.doubleToLongBits(this.evDurationLevel1DCInjection)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evOverExcitedMaxDischargePower)^(Double.doubleToLongBits(this.evOverExcitedMaxDischargePower)>>> 32))));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxNominalVoltage)^(Double.doubleToLongBits(this.maxNominalVoltage)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.nominalVoltageOffset)^(Double.doubleToLongBits(this.nominalVoltageOffset)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evUnderExcitedPowerFactor)^(Double.doubleToLongBits(this.evUnderExcitedPowerFactor)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.nominalVoltage)^(Double.doubleToLongBits(this.nominalVoltage)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evSessionTotalDischargeEnergyAvailable)^(Double.doubleToLongBits(this.evSessionTotalDischargeEnergyAvailable)>>> 32))));
        result = ((result* 31)+((this.evIslandingDetectionMethod == null)? 0 :this.evIslandingDetectionMethod.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evMaximumLevel1DCInjection)^(Double.doubleToLongBits(this.evMaximumLevel1DCInjection)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxDischargeApparentPowerL2)^(Double.doubleToLongBits(this.maxDischargeApparentPowerL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxDischargeApparentPowerL3)^(Double.doubleToLongBits(this.maxDischargeApparentPowerL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxDischargeReactivePowerL2)^(Double.doubleToLongBits(this.maxDischargeReactivePowerL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minDischargeReactivePower)^(Double.doubleToLongBits(this.minDischargeReactivePower)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxDischargeReactivePowerL3)^(Double.doubleToLongBits(this.maxDischargeReactivePowerL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evReactiveSusceptance)^(Double.doubleToLongBits(this.evReactiveSusceptance)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evDurationLevel2DCInjection)^(Double.doubleToLongBits(this.evDurationLevel2DCInjection)>>> 32))));
        result = ((result* 31)+((this.evSupportedDERControl == null)? 0 :this.evSupportedDERControl.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evOverExcitedPowerFactor)^(Double.doubleToLongBits(this.evOverExcitedPowerFactor)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evUnderExcitedMaxDischargePower)^(Double.doubleToLongBits(this.evUnderExcitedMaxDischargePower)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxChargeReactivePowerL2)^(Double.doubleToLongBits(this.maxChargeReactivePowerL2)>>> 32))));
        result = ((result* 31)+((this.evInverterSwVersion == null)? 0 :this.evInverterSwVersion.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxChargeReactivePowerL3)^(Double.doubleToLongBits(this.maxChargeReactivePowerL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxChargeApparentPowerL3)^(Double.doubleToLongBits(this.maxChargeApparentPowerL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minChargeReactivePowerL2)^(Double.doubleToLongBits(this.minChargeReactivePowerL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minDischargeReactivePowerL3)^(Double.doubleToLongBits(this.minDischargeReactivePowerL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxChargeApparentPowerL2)^(Double.doubleToLongBits(this.maxChargeApparentPowerL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minChargeReactivePowerL3)^(Double.doubleToLongBits(this.minChargeReactivePowerL3)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minDischargeReactivePowerL2)^(Double.doubleToLongBits(this.minDischargeReactivePowerL2)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evIslandingTripTime)^(Double.doubleToLongBits(this.evIslandingTripTime)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxChargeReactivePower)^(Double.doubleToLongBits(this.maxChargeReactivePower)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxChargeApparentPower)^(Double.doubleToLongBits(this.maxChargeApparentPower)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxApparentPower)^(Double.doubleToLongBits(this.maxApparentPower)>>> 32))));
        result = ((result* 31)+((this.evInverterSerialNumber == null)? 0 :this.evInverterSerialNumber.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evMaximumLevel2DCInjection)^(Double.doubleToLongBits(this.evMaximumLevel2DCInjection)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minNominalVoltage)^(Double.doubleToLongBits(this.minNominalVoltage)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minChargeReactivePower)^(Double.doubleToLongBits(this.minChargeReactivePower)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DERChargingParameters) == false) {
            return false;
        }
        DERChargingParameters rhs = ((DERChargingParameters) other);
        return ((((((((((((((((((((((((((((((((((((((((((Double.doubleToLongBits(this.maxDischargeReactivePower) == Double.doubleToLongBits(rhs.maxDischargeReactivePower))&&((this.evInverterHwVersion == rhs.evInverterHwVersion)||((this.evInverterHwVersion!= null)&&this.evInverterHwVersion.equals(rhs.evInverterHwVersion))))&&((this.evInverterManufacturer == rhs.evInverterManufacturer)||((this.evInverterManufacturer!= null)&&this.evInverterManufacturer.equals(rhs.evInverterManufacturer))))&&(Double.doubleToLongBits(this.maxDischargeApparentPower) == Double.doubleToLongBits(rhs.maxDischargeApparentPower)))&&((this.evInverterModel == rhs.evInverterModel)||((this.evInverterModel!= null)&&this.evInverterModel.equals(rhs.evInverterModel))))&&(Double.doubleToLongBits(this.evDurationLevel1DCInjection) == Double.doubleToLongBits(rhs.evDurationLevel1DCInjection)))&&(Double.doubleToLongBits(this.evOverExcitedMaxDischargePower) == Double.doubleToLongBits(rhs.evOverExcitedMaxDischargePower)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(Double.doubleToLongBits(this.maxNominalVoltage) == Double.doubleToLongBits(rhs.maxNominalVoltage)))&&(Double.doubleToLongBits(this.nominalVoltageOffset) == Double.doubleToLongBits(rhs.nominalVoltageOffset)))&&(Double.doubleToLongBits(this.evUnderExcitedPowerFactor) == Double.doubleToLongBits(rhs.evUnderExcitedPowerFactor)))&&(Double.doubleToLongBits(this.nominalVoltage) == Double.doubleToLongBits(rhs.nominalVoltage)))&&(Double.doubleToLongBits(this.evSessionTotalDischargeEnergyAvailable) == Double.doubleToLongBits(rhs.evSessionTotalDischargeEnergyAvailable)))&&((this.evIslandingDetectionMethod == rhs.evIslandingDetectionMethod)||((this.evIslandingDetectionMethod!= null)&&this.evIslandingDetectionMethod.equals(rhs.evIslandingDetectionMethod))))&&(Double.doubleToLongBits(this.evMaximumLevel1DCInjection) == Double.doubleToLongBits(rhs.evMaximumLevel1DCInjection)))&&(Double.doubleToLongBits(this.maxDischargeApparentPowerL2) == Double.doubleToLongBits(rhs.maxDischargeApparentPowerL2)))&&(Double.doubleToLongBits(this.maxDischargeApparentPowerL3) == Double.doubleToLongBits(rhs.maxDischargeApparentPowerL3)))&&(Double.doubleToLongBits(this.maxDischargeReactivePowerL2) == Double.doubleToLongBits(rhs.maxDischargeReactivePowerL2)))&&(Double.doubleToLongBits(this.minDischargeReactivePower) == Double.doubleToLongBits(rhs.minDischargeReactivePower)))&&(Double.doubleToLongBits(this.maxDischargeReactivePowerL3) == Double.doubleToLongBits(rhs.maxDischargeReactivePowerL3)))&&(Double.doubleToLongBits(this.evReactiveSusceptance) == Double.doubleToLongBits(rhs.evReactiveSusceptance)))&&(Double.doubleToLongBits(this.evDurationLevel2DCInjection) == Double.doubleToLongBits(rhs.evDurationLevel2DCInjection)))&&((this.evSupportedDERControl == rhs.evSupportedDERControl)||((this.evSupportedDERControl!= null)&&this.evSupportedDERControl.equals(rhs.evSupportedDERControl))))&&(Double.doubleToLongBits(this.evOverExcitedPowerFactor) == Double.doubleToLongBits(rhs.evOverExcitedPowerFactor)))&&(Double.doubleToLongBits(this.evUnderExcitedMaxDischargePower) == Double.doubleToLongBits(rhs.evUnderExcitedMaxDischargePower)))&&(Double.doubleToLongBits(this.maxChargeReactivePowerL2) == Double.doubleToLongBits(rhs.maxChargeReactivePowerL2)))&&((this.evInverterSwVersion == rhs.evInverterSwVersion)||((this.evInverterSwVersion!= null)&&this.evInverterSwVersion.equals(rhs.evInverterSwVersion))))&&(Double.doubleToLongBits(this.maxChargeReactivePowerL3) == Double.doubleToLongBits(rhs.maxChargeReactivePowerL3)))&&(Double.doubleToLongBits(this.maxChargeApparentPowerL3) == Double.doubleToLongBits(rhs.maxChargeApparentPowerL3)))&&(Double.doubleToLongBits(this.minChargeReactivePowerL2) == Double.doubleToLongBits(rhs.minChargeReactivePowerL2)))&&(Double.doubleToLongBits(this.minDischargeReactivePowerL3) == Double.doubleToLongBits(rhs.minDischargeReactivePowerL3)))&&(Double.doubleToLongBits(this.maxChargeApparentPowerL2) == Double.doubleToLongBits(rhs.maxChargeApparentPowerL2)))&&(Double.doubleToLongBits(this.minChargeReactivePowerL3) == Double.doubleToLongBits(rhs.minChargeReactivePowerL3)))&&(Double.doubleToLongBits(this.minDischargeReactivePowerL2) == Double.doubleToLongBits(rhs.minDischargeReactivePowerL2)))&&(Double.doubleToLongBits(this.evIslandingTripTime) == Double.doubleToLongBits(rhs.evIslandingTripTime)))&&(Double.doubleToLongBits(this.maxChargeReactivePower) == Double.doubleToLongBits(rhs.maxChargeReactivePower)))&&(Double.doubleToLongBits(this.maxChargeApparentPower) == Double.doubleToLongBits(rhs.maxChargeApparentPower)))&&(Double.doubleToLongBits(this.maxApparentPower) == Double.doubleToLongBits(rhs.maxApparentPower)))&&((this.evInverterSerialNumber == rhs.evInverterSerialNumber)||((this.evInverterSerialNumber!= null)&&this.evInverterSerialNumber.equals(rhs.evInverterSerialNumber))))&&(Double.doubleToLongBits(this.evMaximumLevel2DCInjection) == Double.doubleToLongBits(rhs.evMaximumLevel2DCInjection)))&&(Double.doubleToLongBits(this.minNominalVoltage) == Double.doubleToLongBits(rhs.minNominalVoltage)))&&(Double.doubleToLongBits(this.minChargeReactivePower) == Double.doubleToLongBits(rhs.minChargeReactivePower)));
    }

}
