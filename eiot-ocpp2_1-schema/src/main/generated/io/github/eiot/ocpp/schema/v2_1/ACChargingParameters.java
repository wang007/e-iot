
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * EV AC charging parameters for ISO 15118-2
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "energyAmount",
    "evMinCurrent",
    "evMaxCurrent",
    "evMaxVoltage",
    "customData"
})
public class ACChargingParameters {

    /**
     * Amount of energy requested (in Wh). This includes energy required for preconditioning.
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EAmount +
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyAmount")
    @JsonPropertyDescription("Amount of energy requested (in Wh). This includes energy required for preconditioning.\r\nRelates to: +\r\n*ISO 15118-2*: AC_EVChargeParameterType: EAmount +\r\n*ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest\r\n\r\n")
    @NotNull
    private double energyAmount;
    /**
     * Minimum current (amps) supported by the electric vehicle (per phase).
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EVMinCurrent
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMinCurrent")
    @JsonPropertyDescription("Minimum current (amps) supported by the electric vehicle (per phase).\r\nRelates to: +\r\n*ISO 15118-2*: AC_EVChargeParameterType: EVMinCurrent\r\n\r\n")
    @NotNull
    private double evMinCurrent;
    /**
     * Maximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity.
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EVMaxCurrent
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    @JsonPropertyDescription("Maximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity.\r\nRelates to: +\r\n*ISO 15118-2*: AC_EVChargeParameterType: EVMaxCurrent\r\n\r\n")
    @NotNull
    private double evMaxCurrent;
    /**
     * Maximum voltage supported by the electric vehicle.
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EVMaxVoltage
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    @JsonPropertyDescription("Maximum voltage supported by the electric vehicle.\r\nRelates to: +\r\n*ISO 15118-2*: AC_EVChargeParameterType: EVMaxVoltage\r\n\r\n")
    @NotNull
    private double evMaxVoltage;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Amount of energy requested (in Wh). This includes energy required for preconditioning.
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EAmount +
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyAmount")
    public double getEnergyAmount() {
        return energyAmount;
    }

    /**
     * Amount of energy requested (in Wh). This includes energy required for preconditioning.
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EAmount +
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyAmount")
    public void setEnergyAmount(double energyAmount) {
        this.energyAmount = energyAmount;
    }

    public ACChargingParameters withEnergyAmount(double energyAmount) {
        this.energyAmount = energyAmount;
        return this;
    }

    /**
     * Minimum current (amps) supported by the electric vehicle (per phase).
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EVMinCurrent
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMinCurrent")
    public double getEvMinCurrent() {
        return evMinCurrent;
    }

    /**
     * Minimum current (amps) supported by the electric vehicle (per phase).
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EVMinCurrent
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMinCurrent")
    public void setEvMinCurrent(double evMinCurrent) {
        this.evMinCurrent = evMinCurrent;
    }

    public ACChargingParameters withEvMinCurrent(double evMinCurrent) {
        this.evMinCurrent = evMinCurrent;
        return this;
    }

    /**
     * Maximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity.
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EVMaxCurrent
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    public double getEvMaxCurrent() {
        return evMaxCurrent;
    }

    /**
     * Maximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity.
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EVMaxCurrent
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    public void setEvMaxCurrent(double evMaxCurrent) {
        this.evMaxCurrent = evMaxCurrent;
    }

    public ACChargingParameters withEvMaxCurrent(double evMaxCurrent) {
        this.evMaxCurrent = evMaxCurrent;
        return this;
    }

    /**
     * Maximum voltage supported by the electric vehicle.
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EVMaxVoltage
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    public double getEvMaxVoltage() {
        return evMaxVoltage;
    }

    /**
     * Maximum voltage supported by the electric vehicle.
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EVMaxVoltage
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    public void setEvMaxVoltage(double evMaxVoltage) {
        this.evMaxVoltage = evMaxVoltage;
    }

    public ACChargingParameters withEvMaxVoltage(double evMaxVoltage) {
        this.evMaxVoltage = evMaxVoltage;
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

    public ACChargingParameters withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ACChargingParameters.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("energyAmount");
        sb.append('=');
        sb.append(this.energyAmount);
        sb.append(',');
        sb.append("evMinCurrent");
        sb.append('=');
        sb.append(this.evMinCurrent);
        sb.append(',');
        sb.append("evMaxCurrent");
        sb.append('=');
        sb.append(this.evMaxCurrent);
        sb.append(',');
        sb.append("evMaxVoltage");
        sb.append('=');
        sb.append(this.evMaxVoltage);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.energyAmount)^(Double.doubleToLongBits(this.energyAmount)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evMaxCurrent)^(Double.doubleToLongBits(this.evMaxCurrent)>>> 32))));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evMinCurrent)^(Double.doubleToLongBits(this.evMinCurrent)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evMaxVoltage)^(Double.doubleToLongBits(this.evMaxVoltage)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ACChargingParameters) == false) {
            return false;
        }
        ACChargingParameters rhs = ((ACChargingParameters) other);
        return (((((Double.doubleToLongBits(this.energyAmount) == Double.doubleToLongBits(rhs.energyAmount))&&(Double.doubleToLongBits(this.evMaxCurrent) == Double.doubleToLongBits(rhs.evMaxCurrent)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(Double.doubleToLongBits(this.evMinCurrent) == Double.doubleToLongBits(rhs.evMinCurrent)))&&(Double.doubleToLongBits(this.evMaxVoltage) == Double.doubleToLongBits(rhs.evMaxVoltage)));
    }

}
