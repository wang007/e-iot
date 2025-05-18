
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * Tariff with optional conditions for a time duration price.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "priceMinute",
    "conditions",
    "customData"
})
public class TariffTimePrice {

    /**
     * Price per minute (excl. tax) for this element.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceMinute")
    @JsonPropertyDescription("Price per minute (excl. tax) for this element.\r\n")
    @NotNull
    private double priceMinute;
    /**
     * These conditions describe if and when a TariffEnergyType or TariffTimeType applies during a transaction.
     * 
     * When more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.
     * 
     * For reverse energy flow (discharging) negative values of energy, power and current are used.
     * 
     * NOTE: _minXXX_ (where XXX = Kwh/A/Kw) must be read as "closest to zero", and _maxXXX_ as "furthest from zero". For example, a *charging* power range from 10 kW to 50 kWh is given by _minPower_ = 10000 and _maxPower_ = 50000, and a *discharging* power range from -10 kW to -50 kW is given by _minPower_ = -10 and _maxPower_ = -50.
     * 
     * NOTE: _startTimeOfDay_ and _endTimeOfDay_ are in local time, because it is the time in the tariff as it is shown to the EV driver at the Charging Station.
     * A Charging Station will convert this to the internal time zone that it uses (which is recommended to be UTC, see section Generic chapter 3.1) when performing cost calculation.
     * 
     * 
     * 
     */
    @JsonProperty("conditions")
    @JsonPropertyDescription("These conditions describe if and when a TariffEnergyType or TariffTimeType applies during a transaction.\r\n\r\nWhen more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.\r\n\r\nFor reverse energy flow (discharging) negative values of energy, power and current are used.\r\n\r\nNOTE: _minXXX_ (where XXX = Kwh/A/Kw) must be read as \"closest to zero\", and _maxXXX_ as \"furthest from zero\". For example, a *charging* power range from 10 kW to 50 kWh is given by _minPower_ = 10000 and _maxPower_ = 50000, and a *discharging* power range from -10 kW to -50 kW is given by _minPower_ = -10 and _maxPower_ = -50.\r\n\r\nNOTE: _startTimeOfDay_ and _endTimeOfDay_ are in local time, because it is the time in the tariff as it is shown to the EV driver at the Charging Station.\r\nA Charging Station will convert this to the internal time zone that it uses (which is recommended to be UTC, see section Generic chapter 3.1) when performing cost calculation.\r\n\r\n")
    @Valid
    private TariffConditions conditions;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Price per minute (excl. tax) for this element.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceMinute")
    public double getPriceMinute() {
        return priceMinute;
    }

    /**
     * Price per minute (excl. tax) for this element.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceMinute")
    public void setPriceMinute(double priceMinute) {
        this.priceMinute = priceMinute;
    }

    public TariffTimePrice withPriceMinute(double priceMinute) {
        this.priceMinute = priceMinute;
        return this;
    }

    /**
     * These conditions describe if and when a TariffEnergyType or TariffTimeType applies during a transaction.
     * 
     * When more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.
     * 
     * For reverse energy flow (discharging) negative values of energy, power and current are used.
     * 
     * NOTE: _minXXX_ (where XXX = Kwh/A/Kw) must be read as "closest to zero", and _maxXXX_ as "furthest from zero". For example, a *charging* power range from 10 kW to 50 kWh is given by _minPower_ = 10000 and _maxPower_ = 50000, and a *discharging* power range from -10 kW to -50 kW is given by _minPower_ = -10 and _maxPower_ = -50.
     * 
     * NOTE: _startTimeOfDay_ and _endTimeOfDay_ are in local time, because it is the time in the tariff as it is shown to the EV driver at the Charging Station.
     * A Charging Station will convert this to the internal time zone that it uses (which is recommended to be UTC, see section Generic chapter 3.1) when performing cost calculation.
     * 
     * 
     * 
     */
    @JsonProperty("conditions")
    public TariffConditions getConditions() {
        return conditions;
    }

    /**
     * These conditions describe if and when a TariffEnergyType or TariffTimeType applies during a transaction.
     * 
     * When more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.
     * 
     * For reverse energy flow (discharging) negative values of energy, power and current are used.
     * 
     * NOTE: _minXXX_ (where XXX = Kwh/A/Kw) must be read as "closest to zero", and _maxXXX_ as "furthest from zero". For example, a *charging* power range from 10 kW to 50 kWh is given by _minPower_ = 10000 and _maxPower_ = 50000, and a *discharging* power range from -10 kW to -50 kW is given by _minPower_ = -10 and _maxPower_ = -50.
     * 
     * NOTE: _startTimeOfDay_ and _endTimeOfDay_ are in local time, because it is the time in the tariff as it is shown to the EV driver at the Charging Station.
     * A Charging Station will convert this to the internal time zone that it uses (which is recommended to be UTC, see section Generic chapter 3.1) when performing cost calculation.
     * 
     * 
     * 
     */
    @JsonProperty("conditions")
    public void setConditions(TariffConditions conditions) {
        this.conditions = conditions;
    }

    public TariffTimePrice withConditions(TariffConditions conditions) {
        this.conditions = conditions;
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

    public TariffTimePrice withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TariffTimePrice.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("priceMinute");
        sb.append('=');
        sb.append(this.priceMinute);
        sb.append(',');
        sb.append("conditions");
        sb.append('=');
        sb.append(((this.conditions == null)?"<null>":this.conditions));
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.priceMinute)^(Double.doubleToLongBits(this.priceMinute)>>> 32))));
        result = ((result* 31)+((this.conditions == null)? 0 :this.conditions.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TariffTimePrice) == false) {
            return false;
        }
        TariffTimePrice rhs = ((TariffTimePrice) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(Double.doubleToLongBits(this.priceMinute) == Double.doubleToLongBits(rhs.priceMinute)))&&((this.conditions == rhs.conditions)||((this.conditions!= null)&&this.conditions.equals(rhs.conditions))));
    }

}
