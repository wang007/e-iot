
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * *(2.1)* An entry in price schedule over time for which EV is willing to discharge.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "energyFee",
    "powerRangeStart",
    "customData"
})
public class EVPriceRule {

    /**
     * Cost per kWh.
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyFee")
    @JsonPropertyDescription("Cost per kWh.\r\n")
    @NotNull
    private double energyFee;
    /**
     * The EnergyFee applies between this value and the value of the PowerRangeStart of the subsequent EVPriceRule. If the power is below this value, the EnergyFee of the previous EVPriceRule applies. Negative values are used for discharging.
     * 
     * (Required)
     * 
     */
    @JsonProperty("powerRangeStart")
    @JsonPropertyDescription("The EnergyFee applies between this value and the value of the PowerRangeStart of the subsequent EVPriceRule. If the power is below this value, the EnergyFee of the previous EVPriceRule applies. Negative values are used for discharging.\r\n")
    @NotNull
    private double powerRangeStart;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Cost per kWh.
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyFee")
    public double getEnergyFee() {
        return energyFee;
    }

    /**
     * Cost per kWh.
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyFee")
    public void setEnergyFee(double energyFee) {
        this.energyFee = energyFee;
    }

    public EVPriceRule withEnergyFee(double energyFee) {
        this.energyFee = energyFee;
        return this;
    }

    /**
     * The EnergyFee applies between this value and the value of the PowerRangeStart of the subsequent EVPriceRule. If the power is below this value, the EnergyFee of the previous EVPriceRule applies. Negative values are used for discharging.
     * 
     * (Required)
     * 
     */
    @JsonProperty("powerRangeStart")
    public double getPowerRangeStart() {
        return powerRangeStart;
    }

    /**
     * The EnergyFee applies between this value and the value of the PowerRangeStart of the subsequent EVPriceRule. If the power is below this value, the EnergyFee of the previous EVPriceRule applies. Negative values are used for discharging.
     * 
     * (Required)
     * 
     */
    @JsonProperty("powerRangeStart")
    public void setPowerRangeStart(double powerRangeStart) {
        this.powerRangeStart = powerRangeStart;
    }

    public EVPriceRule withPowerRangeStart(double powerRangeStart) {
        this.powerRangeStart = powerRangeStart;
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

    public EVPriceRule withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EVPriceRule.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("energyFee");
        sb.append('=');
        sb.append(this.energyFee);
        sb.append(',');
        sb.append("powerRangeStart");
        sb.append('=');
        sb.append(this.powerRangeStart);
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
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.energyFee)^(Double.doubleToLongBits(this.energyFee)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.powerRangeStart)^(Double.doubleToLongBits(this.powerRangeStart)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EVPriceRule) == false) {
            return false;
        }
        EVPriceRule rhs = ((EVPriceRule) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(Double.doubleToLongBits(this.energyFee) == Double.doubleToLongBits(rhs.energyFee)))&&(Double.doubleToLongBits(this.powerRangeStart) == Double.doubleToLongBits(rhs.powerRangeStart)));
    }

}
