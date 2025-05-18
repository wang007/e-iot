
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * Tariff with optional conditions for a fixed price.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "priceFixed",
    "customData"
})
public class TariffFixedPrice {

    /**
     * These conditions describe if a FixedPrice applies at start of the transaction.
     * 
     * When more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.
     * 
     * NOTE: _startTimeOfDay_ and _endTimeOfDay_ are in local time, because it is the time in the tariff as it is shown to the EV driver at the Charging Station.
     * A Charging Station will convert this to the internal time zone that it uses (which is recommended to be UTC, see section Generic chapter 3.1) when performing cost calculation.
     * 
     * 
     * 
     */
    @JsonProperty("conditions")
    @JsonPropertyDescription("These conditions describe if a FixedPrice applies at start of the transaction.\r\n\r\nWhen more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.\r\n\r\nNOTE: _startTimeOfDay_ and _endTimeOfDay_ are in local time, because it is the time in the tariff as it is shown to the EV driver at the Charging Station.\r\nA Charging Station will convert this to the internal time zone that it uses (which is recommended to be UTC, see section Generic chapter 3.1) when performing cost calculation.\r\n\r\n")
    @Valid
    private TariffConditionsFixed conditions;
    /**
     * Fixed price  for this element e.g. a start fee.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceFixed")
    @JsonPropertyDescription("Fixed price  for this element e.g. a start fee.\r\n")
    @NotNull
    private double priceFixed;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * These conditions describe if a FixedPrice applies at start of the transaction.
     * 
     * When more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.
     * 
     * NOTE: _startTimeOfDay_ and _endTimeOfDay_ are in local time, because it is the time in the tariff as it is shown to the EV driver at the Charging Station.
     * A Charging Station will convert this to the internal time zone that it uses (which is recommended to be UTC, see section Generic chapter 3.1) when performing cost calculation.
     * 
     * 
     * 
     */
    @JsonProperty("conditions")
    public TariffConditionsFixed getConditions() {
        return conditions;
    }

    /**
     * These conditions describe if a FixedPrice applies at start of the transaction.
     * 
     * When more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.
     * 
     * NOTE: _startTimeOfDay_ and _endTimeOfDay_ are in local time, because it is the time in the tariff as it is shown to the EV driver at the Charging Station.
     * A Charging Station will convert this to the internal time zone that it uses (which is recommended to be UTC, see section Generic chapter 3.1) when performing cost calculation.
     * 
     * 
     * 
     */
    @JsonProperty("conditions")
    public void setConditions(TariffConditionsFixed conditions) {
        this.conditions = conditions;
    }

    public TariffFixedPrice withConditions(TariffConditionsFixed conditions) {
        this.conditions = conditions;
        return this;
    }

    /**
     * Fixed price  for this element e.g. a start fee.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceFixed")
    public double getPriceFixed() {
        return priceFixed;
    }

    /**
     * Fixed price  for this element e.g. a start fee.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceFixed")
    public void setPriceFixed(double priceFixed) {
        this.priceFixed = priceFixed;
    }

    public TariffFixedPrice withPriceFixed(double priceFixed) {
        this.priceFixed = priceFixed;
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

    public TariffFixedPrice withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TariffFixedPrice.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("conditions");
        sb.append('=');
        sb.append(((this.conditions == null)?"<null>":this.conditions));
        sb.append(',');
        sb.append("priceFixed");
        sb.append('=');
        sb.append(this.priceFixed);
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
        result = ((result* 31)+((this.conditions == null)? 0 :this.conditions.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.priceFixed)^(Double.doubleToLongBits(this.priceFixed)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TariffFixedPrice) == false) {
            return false;
        }
        TariffFixedPrice rhs = ((TariffFixedPrice) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.conditions == rhs.conditions)||((this.conditions!= null)&&this.conditions.equals(rhs.conditions))))&&(Double.doubleToLongBits(this.priceFixed) == Double.doubleToLongBits(rhs.priceFixed)));
    }

}
