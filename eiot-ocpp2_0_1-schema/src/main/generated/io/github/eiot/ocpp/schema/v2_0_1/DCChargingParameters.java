
package io.github.eiot.ocpp.schema.v2_0_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;


/**
 * DC_ Charging_ Parameters
 * urn:x-oca:ocpp:uid:2:233251
 * EV DC charging parameters
 * 
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customData",
    "evMaxCurrent",
    "evMaxVoltage",
    "energyAmount",
    "evMaxPower",
    "stateOfCharge",
    "evEnergyCapacity",
    "fullSoC",
    "bulkSoC"
})
public class DCChargingParameters {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * DC_ Charging_ Parameters. EV_ Max. Current
     * urn:x-oca:ocpp:uid:1:569215
     * Maximum current (amps) supported by the electric vehicle. Includes cable capacity.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    @JsonPropertyDescription("DC_ Charging_ Parameters. EV_ Max. Current\r\nurn:x-oca:ocpp:uid:1:569215\r\nMaximum current (amps) supported by the electric vehicle. Includes cable capacity.\r\n")
    @NotNull
    private int evMaxCurrent;
    /**
     * DC_ Charging_ Parameters. EV_ Max. Voltage
     * urn:x-oca:ocpp:uid:1:569216
     * Maximum voltage supported by the electric vehicle
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    @JsonPropertyDescription("DC_ Charging_ Parameters. EV_ Max. Voltage\r\nurn:x-oca:ocpp:uid:1:569216\r\nMaximum voltage supported by the electric vehicle\r\n")
    @NotNull
    private int evMaxVoltage;
    /**
     * DC_ Charging_ Parameters. Energy_ Amount. Energy_ Amount
     * urn:x-oca:ocpp:uid:1:569217
     * Amount of energy requested (in Wh). This inludes energy required for preconditioning.
     * 
     * 
     */
    @JsonProperty("energyAmount")
    @JsonPropertyDescription("DC_ Charging_ Parameters. Energy_ Amount. Energy_ Amount\r\nurn:x-oca:ocpp:uid:1:569217\r\nAmount of energy requested (in Wh). This inludes energy required for preconditioning.\r\n")
    private int energyAmount;
    /**
     * DC_ Charging_ Parameters. EV_ Max. Power
     * urn:x-oca:ocpp:uid:1:569218
     * Maximum power (in W) supported by the electric vehicle. Required for DC charging.
     * 
     * 
     */
    @JsonProperty("evMaxPower")
    @JsonPropertyDescription("DC_ Charging_ Parameters. EV_ Max. Power\r\nurn:x-oca:ocpp:uid:1:569218\r\nMaximum power (in W) supported by the electric vehicle. Required for DC charging.\r\n")
    private int evMaxPower;
    /**
     * DC_ Charging_ Parameters. State_ Of_ Charge. Numeric
     * urn:x-oca:ocpp:uid:1:569219
     * Energy available in the battery (in percent of the battery capacity)
     * 
     * 
     */
    @JsonProperty("stateOfCharge")
    @JsonPropertyDescription("DC_ Charging_ Parameters. State_ Of_ Charge. Numeric\r\nurn:x-oca:ocpp:uid:1:569219\r\nEnergy available in the battery (in percent of the battery capacity)\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private int stateOfCharge;
    /**
     * DC_ Charging_ Parameters. EV_ Energy_ Capacity. Numeric
     * urn:x-oca:ocpp:uid:1:569220
     * Capacity of the electric vehicle battery (in Wh)
     * 
     * 
     */
    @JsonProperty("evEnergyCapacity")
    @JsonPropertyDescription("DC_ Charging_ Parameters. EV_ Energy_ Capacity. Numeric\r\nurn:x-oca:ocpp:uid:1:569220\r\nCapacity of the electric vehicle battery (in Wh)\r\n")
    private int evEnergyCapacity;
    /**
     * DC_ Charging_ Parameters. Full_ SOC. Percentage
     * urn:x-oca:ocpp:uid:1:569221
     * Percentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100)
     * 
     * 
     */
    @JsonProperty("fullSoC")
    @JsonPropertyDescription("DC_ Charging_ Parameters. Full_ SOC. Percentage\r\nurn:x-oca:ocpp:uid:1:569221\r\nPercentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100)\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private int fullSoC;
    /**
     * DC_ Charging_ Parameters. Bulk_ SOC. Percentage
     * urn:x-oca:ocpp:uid:1:569222
     * Percentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100)
     * 
     * 
     */
    @JsonProperty("bulkSoC")
    @JsonPropertyDescription("DC_ Charging_ Parameters. Bulk_ SOC. Percentage\r\nurn:x-oca:ocpp:uid:1:569222\r\nPercentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100)\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private int bulkSoC;

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

    /**
     * DC_ Charging_ Parameters. EV_ Max. Current
     * urn:x-oca:ocpp:uid:1:569215
     * Maximum current (amps) supported by the electric vehicle. Includes cable capacity.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    public int getEvMaxCurrent() {
        return evMaxCurrent;
    }

    /**
     * DC_ Charging_ Parameters. EV_ Max. Current
     * urn:x-oca:ocpp:uid:1:569215
     * Maximum current (amps) supported by the electric vehicle. Includes cable capacity.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    public void setEvMaxCurrent(int evMaxCurrent) {
        this.evMaxCurrent = evMaxCurrent;
    }

    public DCChargingParameters withEvMaxCurrent(int evMaxCurrent) {
        this.evMaxCurrent = evMaxCurrent;
        return this;
    }

    /**
     * DC_ Charging_ Parameters. EV_ Max. Voltage
     * urn:x-oca:ocpp:uid:1:569216
     * Maximum voltage supported by the electric vehicle
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    public int getEvMaxVoltage() {
        return evMaxVoltage;
    }

    /**
     * DC_ Charging_ Parameters. EV_ Max. Voltage
     * urn:x-oca:ocpp:uid:1:569216
     * Maximum voltage supported by the electric vehicle
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    public void setEvMaxVoltage(int evMaxVoltage) {
        this.evMaxVoltage = evMaxVoltage;
    }

    public DCChargingParameters withEvMaxVoltage(int evMaxVoltage) {
        this.evMaxVoltage = evMaxVoltage;
        return this;
    }

    /**
     * DC_ Charging_ Parameters. Energy_ Amount. Energy_ Amount
     * urn:x-oca:ocpp:uid:1:569217
     * Amount of energy requested (in Wh). This inludes energy required for preconditioning.
     * 
     * 
     */
    @JsonProperty("energyAmount")
    public int getEnergyAmount() {
        return energyAmount;
    }

    /**
     * DC_ Charging_ Parameters. Energy_ Amount. Energy_ Amount
     * urn:x-oca:ocpp:uid:1:569217
     * Amount of energy requested (in Wh). This inludes energy required for preconditioning.
     * 
     * 
     */
    @JsonProperty("energyAmount")
    public void setEnergyAmount(int energyAmount) {
        this.energyAmount = energyAmount;
    }

    public DCChargingParameters withEnergyAmount(int energyAmount) {
        this.energyAmount = energyAmount;
        return this;
    }

    /**
     * DC_ Charging_ Parameters. EV_ Max. Power
     * urn:x-oca:ocpp:uid:1:569218
     * Maximum power (in W) supported by the electric vehicle. Required for DC charging.
     * 
     * 
     */
    @JsonProperty("evMaxPower")
    public int getEvMaxPower() {
        return evMaxPower;
    }

    /**
     * DC_ Charging_ Parameters. EV_ Max. Power
     * urn:x-oca:ocpp:uid:1:569218
     * Maximum power (in W) supported by the electric vehicle. Required for DC charging.
     * 
     * 
     */
    @JsonProperty("evMaxPower")
    public void setEvMaxPower(int evMaxPower) {
        this.evMaxPower = evMaxPower;
    }

    public DCChargingParameters withEvMaxPower(int evMaxPower) {
        this.evMaxPower = evMaxPower;
        return this;
    }

    /**
     * DC_ Charging_ Parameters. State_ Of_ Charge. Numeric
     * urn:x-oca:ocpp:uid:1:569219
     * Energy available in the battery (in percent of the battery capacity)
     * 
     * 
     */
    @JsonProperty("stateOfCharge")
    public int getStateOfCharge() {
        return stateOfCharge;
    }

    /**
     * DC_ Charging_ Parameters. State_ Of_ Charge. Numeric
     * urn:x-oca:ocpp:uid:1:569219
     * Energy available in the battery (in percent of the battery capacity)
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
     * DC_ Charging_ Parameters. EV_ Energy_ Capacity. Numeric
     * urn:x-oca:ocpp:uid:1:569220
     * Capacity of the electric vehicle battery (in Wh)
     * 
     * 
     */
    @JsonProperty("evEnergyCapacity")
    public int getEvEnergyCapacity() {
        return evEnergyCapacity;
    }

    /**
     * DC_ Charging_ Parameters. EV_ Energy_ Capacity. Numeric
     * urn:x-oca:ocpp:uid:1:569220
     * Capacity of the electric vehicle battery (in Wh)
     * 
     * 
     */
    @JsonProperty("evEnergyCapacity")
    public void setEvEnergyCapacity(int evEnergyCapacity) {
        this.evEnergyCapacity = evEnergyCapacity;
    }

    public DCChargingParameters withEvEnergyCapacity(int evEnergyCapacity) {
        this.evEnergyCapacity = evEnergyCapacity;
        return this;
    }

    /**
     * DC_ Charging_ Parameters. Full_ SOC. Percentage
     * urn:x-oca:ocpp:uid:1:569221
     * Percentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100)
     * 
     * 
     */
    @JsonProperty("fullSoC")
    public int getFullSoC() {
        return fullSoC;
    }

    /**
     * DC_ Charging_ Parameters. Full_ SOC. Percentage
     * urn:x-oca:ocpp:uid:1:569221
     * Percentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100)
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
     * DC_ Charging_ Parameters. Bulk_ SOC. Percentage
     * urn:x-oca:ocpp:uid:1:569222
     * Percentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100)
     * 
     * 
     */
    @JsonProperty("bulkSoC")
    public int getBulkSoC() {
        return bulkSoC;
    }

    /**
     * DC_ Charging_ Parameters. Bulk_ SOC. Percentage
     * urn:x-oca:ocpp:uid:1:569222
     * Percentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100)
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DCChargingParameters.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customData");
        sb.append('=');
        sb.append(((this.customData == null)?"<null>":this.customData));
        sb.append(',');
        sb.append("evMaxCurrent");
        sb.append('=');
        sb.append(this.evMaxCurrent);
        sb.append(',');
        sb.append("evMaxVoltage");
        sb.append('=');
        sb.append(this.evMaxVoltage);
        sb.append(',');
        sb.append("energyAmount");
        sb.append('=');
        sb.append(this.energyAmount);
        sb.append(',');
        sb.append("evMaxPower");
        sb.append('=');
        sb.append(this.evMaxPower);
        sb.append(',');
        sb.append("stateOfCharge");
        sb.append('=');
        sb.append(this.stateOfCharge);
        sb.append(',');
        sb.append("evEnergyCapacity");
        sb.append('=');
        sb.append(this.evEnergyCapacity);
        sb.append(',');
        sb.append("fullSoC");
        sb.append('=');
        sb.append(this.fullSoC);
        sb.append(',');
        sb.append("bulkSoC");
        sb.append('=');
        sb.append(this.bulkSoC);
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
        result = ((result* 31)+ this.evMaxCurrent);
        result = ((result* 31)+ this.stateOfCharge);
        result = ((result* 31)+ this.evEnergyCapacity);
        result = ((result* 31)+ this.evMaxVoltage);
        result = ((result* 31)+ this.energyAmount);
        result = ((result* 31)+ this.bulkSoC);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.evMaxPower);
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
        return (((((((((this.evMaxCurrent == rhs.evMaxCurrent)&&(this.stateOfCharge == rhs.stateOfCharge))&&(this.evEnergyCapacity == rhs.evEnergyCapacity))&&(this.evMaxVoltage == rhs.evMaxVoltage))&&(this.energyAmount == rhs.energyAmount))&&(this.bulkSoC == rhs.bulkSoC))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.evMaxPower == rhs.evMaxPower))&&(this.fullSoC == rhs.fullSoC));
    }

}
