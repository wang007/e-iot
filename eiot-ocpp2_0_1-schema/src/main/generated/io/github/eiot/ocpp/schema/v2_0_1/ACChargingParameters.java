
package io.github.eiot.ocpp.schema.v2_0_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * AC_ Charging_ Parameters
 * urn:x-oca:ocpp:uid:2:233250
 * EV AC charging parameters.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customData",
    "energyAmount",
    "evMinCurrent",
    "evMaxCurrent",
    "evMaxVoltage"
})
public class ACChargingParameters {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * AC_ Charging_ Parameters. Energy_ Amount. Energy_ Amount
     * urn:x-oca:ocpp:uid:1:569211
     * Amount of energy requested (in Wh). This includes energy required for preconditioning.
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyAmount")
    @JsonPropertyDescription("AC_ Charging_ Parameters. Energy_ Amount. Energy_ Amount\r\nurn:x-oca:ocpp:uid:1:569211\r\nAmount of energy requested (in Wh). This includes energy required for preconditioning.\r\n")
    @NotNull
    private int energyAmount;
    /**
     * AC_ Charging_ Parameters. EV_ Min. Current
     * urn:x-oca:ocpp:uid:1:569212
     * Minimum current (amps) supported by the electric vehicle (per phase).
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMinCurrent")
    @JsonPropertyDescription("AC_ Charging_ Parameters. EV_ Min. Current\r\nurn:x-oca:ocpp:uid:1:569212\r\nMinimum current (amps) supported by the electric vehicle (per phase).\r\n")
    @NotNull
    private int evMinCurrent;
    /**
     * AC_ Charging_ Parameters. EV_ Max. Current
     * urn:x-oca:ocpp:uid:1:569213
     * Maximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    @JsonPropertyDescription("AC_ Charging_ Parameters. EV_ Max. Current\r\nurn:x-oca:ocpp:uid:1:569213\r\nMaximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity.\r\n")
    @NotNull
    private int evMaxCurrent;
    /**
     * AC_ Charging_ Parameters. EV_ Max. Voltage
     * urn:x-oca:ocpp:uid:1:569214
     * Maximum voltage supported by the electric vehicle
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    @JsonPropertyDescription("AC_ Charging_ Parameters. EV_ Max. Voltage\r\nurn:x-oca:ocpp:uid:1:569214\r\nMaximum voltage supported by the electric vehicle\r\n")
    @NotNull
    private int evMaxVoltage;

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

    /**
     * AC_ Charging_ Parameters. Energy_ Amount. Energy_ Amount
     * urn:x-oca:ocpp:uid:1:569211
     * Amount of energy requested (in Wh). This includes energy required for preconditioning.
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyAmount")
    public int getEnergyAmount() {
        return energyAmount;
    }

    /**
     * AC_ Charging_ Parameters. Energy_ Amount. Energy_ Amount
     * urn:x-oca:ocpp:uid:1:569211
     * Amount of energy requested (in Wh). This includes energy required for preconditioning.
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyAmount")
    public void setEnergyAmount(int energyAmount) {
        this.energyAmount = energyAmount;
    }

    public ACChargingParameters withEnergyAmount(int energyAmount) {
        this.energyAmount = energyAmount;
        return this;
    }

    /**
     * AC_ Charging_ Parameters. EV_ Min. Current
     * urn:x-oca:ocpp:uid:1:569212
     * Minimum current (amps) supported by the electric vehicle (per phase).
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMinCurrent")
    public int getEvMinCurrent() {
        return evMinCurrent;
    }

    /**
     * AC_ Charging_ Parameters. EV_ Min. Current
     * urn:x-oca:ocpp:uid:1:569212
     * Minimum current (amps) supported by the electric vehicle (per phase).
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMinCurrent")
    public void setEvMinCurrent(int evMinCurrent) {
        this.evMinCurrent = evMinCurrent;
    }

    public ACChargingParameters withEvMinCurrent(int evMinCurrent) {
        this.evMinCurrent = evMinCurrent;
        return this;
    }

    /**
     * AC_ Charging_ Parameters. EV_ Max. Current
     * urn:x-oca:ocpp:uid:1:569213
     * Maximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    public int getEvMaxCurrent() {
        return evMaxCurrent;
    }

    /**
     * AC_ Charging_ Parameters. EV_ Max. Current
     * urn:x-oca:ocpp:uid:1:569213
     * Maximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    public void setEvMaxCurrent(int evMaxCurrent) {
        this.evMaxCurrent = evMaxCurrent;
    }

    public ACChargingParameters withEvMaxCurrent(int evMaxCurrent) {
        this.evMaxCurrent = evMaxCurrent;
        return this;
    }

    /**
     * AC_ Charging_ Parameters. EV_ Max. Voltage
     * urn:x-oca:ocpp:uid:1:569214
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
     * AC_ Charging_ Parameters. EV_ Max. Voltage
     * urn:x-oca:ocpp:uid:1:569214
     * Maximum voltage supported by the electric vehicle
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    public void setEvMaxVoltage(int evMaxVoltage) {
        this.evMaxVoltage = evMaxVoltage;
    }

    public ACChargingParameters withEvMaxVoltage(int evMaxVoltage) {
        this.evMaxVoltage = evMaxVoltage;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ACChargingParameters.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customData");
        sb.append('=');
        sb.append(((this.customData == null)?"<null>":this.customData));
        sb.append(',');
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
        result = ((result* 31)+ this.energyAmount);
        result = ((result* 31)+ this.evMaxCurrent);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.evMinCurrent);
        result = ((result* 31)+ this.evMaxVoltage);
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
        return (((((this.energyAmount == rhs.energyAmount)&&(this.evMaxCurrent == rhs.evMaxCurrent))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.evMinCurrent == rhs.evMinCurrent))&&(this.evMaxVoltage == rhs.evMaxVoltage));
    }

}
