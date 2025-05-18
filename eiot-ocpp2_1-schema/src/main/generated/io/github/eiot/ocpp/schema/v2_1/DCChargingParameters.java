
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;


/**
 * EV DC charging parameters for ISO 15118-2
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "evMaxCurrent",
    "evMaxVoltage",
    "evMaxPower",
    "evEnergyCapacity",
    "energyAmount",
    "stateOfCharge",
    "fullSoC",
    "bulkSoC",
    "customData"
})
public class DCChargingParameters {

    /**
     * Maximum current (in A) supported by the electric vehicle. Includes cable capacity.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType:EVMaximumCurrentLimit
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    @JsonPropertyDescription("Maximum current (in A) supported by the electric vehicle. Includes cable capacity.\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType:EVMaximumCurrentLimit\r\n")
    @NotNull
    private double evMaxCurrent;
    /**
     * Maximum voltage supported by the electric vehicle.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVMaximumVoltageLimit
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    @JsonPropertyDescription("Maximum voltage supported by the electric vehicle.\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: EVMaximumVoltageLimit\r\n\r\n")
    @NotNull
    private double evMaxVoltage;
    /**
     * Maximum power (in W) supported by the electric vehicle. Required for DC charging.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVMaximumPowerLimit
     * 
     * 
     * 
     */
    @JsonProperty("evMaxPower")
    @JsonPropertyDescription("Maximum power (in W) supported by the electric vehicle. Required for DC charging.\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: EVMaximumPowerLimit\r\n\r\n")
    private double evMaxPower;
    /**
     * Capacity of the electric vehicle battery (in Wh).
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVEnergyCapacity
     * 
     * 
     * 
     */
    @JsonProperty("evEnergyCapacity")
    @JsonPropertyDescription("Capacity of the electric vehicle battery (in Wh).\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: EVEnergyCapacity\r\n\r\n")
    private double evEnergyCapacity;
    /**
     * Amount of energy requested (in Wh). This inludes energy required for preconditioning.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVEnergyRequest
     * 
     * 
     * 
     * 
     */
    @JsonProperty("energyAmount")
    @JsonPropertyDescription("Amount of energy requested (in Wh). This inludes energy required for preconditioning.\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: EVEnergyRequest\r\n\r\n\r\n")
    private double energyAmount;
    /**
     * Energy available in the battery (in percent of the battery capacity)
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: DC_EVStatus: EVRESSSOC
     * 
     * 
     * 
     */
    @JsonProperty("stateOfCharge")
    @JsonPropertyDescription("Energy available in the battery (in percent of the battery capacity)\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: DC_EVStatus: EVRESSSOC\r\n\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private int stateOfCharge;
    /**
     * Percentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100)
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: FullSOC
     * 
     * 
     * 
     */
    @JsonProperty("fullSoC")
    @JsonPropertyDescription("Percentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100)\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: FullSOC\r\n\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private int fullSoC;
    /**
     * Percentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100)
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: BulkSOC
     * 
     * 
     * 
     */
    @JsonProperty("bulkSoC")
    @JsonPropertyDescription("Percentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100)\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: BulkSOC\r\n\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private int bulkSoC;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Maximum current (in A) supported by the electric vehicle. Includes cable capacity.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType:EVMaximumCurrentLimit
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    public double getEvMaxCurrent() {
        return evMaxCurrent;
    }

    /**
     * Maximum current (in A) supported by the electric vehicle. Includes cable capacity.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType:EVMaximumCurrentLimit
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    public void setEvMaxCurrent(double evMaxCurrent) {
        this.evMaxCurrent = evMaxCurrent;
    }

    public DCChargingParameters withEvMaxCurrent(double evMaxCurrent) {
        this.evMaxCurrent = evMaxCurrent;
        return this;
    }

    /**
     * Maximum voltage supported by the electric vehicle.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVMaximumVoltageLimit
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
     * *ISO 15118-2*: DC_EVChargeParameterType: EVMaximumVoltageLimit
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    public void setEvMaxVoltage(double evMaxVoltage) {
        this.evMaxVoltage = evMaxVoltage;
    }

    public DCChargingParameters withEvMaxVoltage(double evMaxVoltage) {
        this.evMaxVoltage = evMaxVoltage;
        return this;
    }

    /**
     * Maximum power (in W) supported by the electric vehicle. Required for DC charging.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVMaximumPowerLimit
     * 
     * 
     * 
     */
    @JsonProperty("evMaxPower")
    public double getEvMaxPower() {
        return evMaxPower;
    }

    /**
     * Maximum power (in W) supported by the electric vehicle. Required for DC charging.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVMaximumPowerLimit
     * 
     * 
     * 
     */
    @JsonProperty("evMaxPower")
    public void setEvMaxPower(double evMaxPower) {
        this.evMaxPower = evMaxPower;
    }

    public DCChargingParameters withEvMaxPower(double evMaxPower) {
        this.evMaxPower = evMaxPower;
        return this;
    }

    /**
     * Capacity of the electric vehicle battery (in Wh).
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVEnergyCapacity
     * 
     * 
     * 
     */
    @JsonProperty("evEnergyCapacity")
    public double getEvEnergyCapacity() {
        return evEnergyCapacity;
    }

    /**
     * Capacity of the electric vehicle battery (in Wh).
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVEnergyCapacity
     * 
     * 
     * 
     */
    @JsonProperty("evEnergyCapacity")
    public void setEvEnergyCapacity(double evEnergyCapacity) {
        this.evEnergyCapacity = evEnergyCapacity;
    }

    public DCChargingParameters withEvEnergyCapacity(double evEnergyCapacity) {
        this.evEnergyCapacity = evEnergyCapacity;
        return this;
    }

    /**
     * Amount of energy requested (in Wh). This inludes energy required for preconditioning.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVEnergyRequest
     * 
     * 
     * 
     * 
     */
    @JsonProperty("energyAmount")
    public double getEnergyAmount() {
        return energyAmount;
    }

    /**
     * Amount of energy requested (in Wh). This inludes energy required for preconditioning.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVEnergyRequest
     * 
     * 
     * 
     * 
     */
    @JsonProperty("energyAmount")
    public void setEnergyAmount(double energyAmount) {
        this.energyAmount = energyAmount;
    }

    public DCChargingParameters withEnergyAmount(double energyAmount) {
        this.energyAmount = energyAmount;
        return this;
    }

    /**
     * Energy available in the battery (in percent of the battery capacity)
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: DC_EVStatus: EVRESSSOC
     * 
     * 
     * 
     */
    @JsonProperty("stateOfCharge")
    public int getStateOfCharge() {
        return stateOfCharge;
    }

    /**
     * Energy available in the battery (in percent of the battery capacity)
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: DC_EVStatus: EVRESSSOC
     * 
     * 
     * 
     */
    @JsonProperty("stateOfCharge")
    public void setStateOfCharge(int stateOfCharge) {
        this.stateOfCharge = stateOfCharge;
    }

    public DCChargingParameters withStateOfCharge(int stateOfCharge) {
        this.stateOfCharge = stateOfCharge;
        return this;
    }

    /**
     * Percentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100)
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: FullSOC
     * 
     * 
     * 
     */
    @JsonProperty("fullSoC")
    public int getFullSoC() {
        return fullSoC;
    }

    /**
     * Percentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100)
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: FullSOC
     * 
     * 
     * 
     */
    @JsonProperty("fullSoC")
    public void setFullSoC(int fullSoC) {
        this.fullSoC = fullSoC;
    }

    public DCChargingParameters withFullSoC(int fullSoC) {
        this.fullSoC = fullSoC;
        return this;
    }

    /**
     * Percentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100)
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: BulkSOC
     * 
     * 
     * 
     */
    @JsonProperty("bulkSoC")
    public int getBulkSoC() {
        return bulkSoC;
    }

    /**
     * Percentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100)
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: BulkSOC
     * 
     * 
     * 
     */
    @JsonProperty("bulkSoC")
    public void setBulkSoC(int bulkSoC) {
        this.bulkSoC = bulkSoC;
    }

    public DCChargingParameters withBulkSoC(int bulkSoC) {
        this.bulkSoC = bulkSoC;
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

    public DCChargingParameters withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DCChargingParameters.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("evMaxCurrent");
        sb.append('=');
        sb.append(this.evMaxCurrent);
        sb.append(',');
        sb.append("evMaxVoltage");
        sb.append('=');
        sb.append(this.evMaxVoltage);
        sb.append(',');
        sb.append("evMaxPower");
        sb.append('=');
        sb.append(this.evMaxPower);
        sb.append(',');
        sb.append("evEnergyCapacity");
        sb.append('=');
        sb.append(this.evEnergyCapacity);
        sb.append(',');
        sb.append("energyAmount");
        sb.append('=');
        sb.append(this.energyAmount);
        sb.append(',');
        sb.append("stateOfCharge");
        sb.append('=');
        sb.append(this.stateOfCharge);
        sb.append(',');
        sb.append("fullSoC");
        sb.append('=');
        sb.append(this.fullSoC);
        sb.append(',');
        sb.append("bulkSoC");
        sb.append('=');
        sb.append(this.bulkSoC);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evMaxCurrent)^(Double.doubleToLongBits(this.evMaxCurrent)>>> 32))));
        result = ((result* 31)+ this.stateOfCharge);
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evEnergyCapacity)^(Double.doubleToLongBits(this.evEnergyCapacity)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evMaxVoltage)^(Double.doubleToLongBits(this.evMaxVoltage)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.energyAmount)^(Double.doubleToLongBits(this.energyAmount)>>> 32))));
        result = ((result* 31)+ this.bulkSoC);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.evMaxPower)^(Double.doubleToLongBits(this.evMaxPower)>>> 32))));
        result = ((result* 31)+ this.fullSoC);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DCChargingParameters) == false) {
            return false;
        }
        DCChargingParameters rhs = ((DCChargingParameters) other);
        return (((((((((Double.doubleToLongBits(this.evMaxCurrent) == Double.doubleToLongBits(rhs.evMaxCurrent))&&(this.stateOfCharge == rhs.stateOfCharge))&&(Double.doubleToLongBits(this.evEnergyCapacity) == Double.doubleToLongBits(rhs.evEnergyCapacity)))&&(Double.doubleToLongBits(this.evMaxVoltage) == Double.doubleToLongBits(rhs.evMaxVoltage)))&&(Double.doubleToLongBits(this.energyAmount) == Double.doubleToLongBits(rhs.energyAmount)))&&(this.bulkSoC == rhs.bulkSoC))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(Double.doubleToLongBits(this.evMaxPower) == Double.doubleToLongBits(rhs.evMaxPower)))&&(this.fullSoC == rhs.fullSoC));
    }

}
