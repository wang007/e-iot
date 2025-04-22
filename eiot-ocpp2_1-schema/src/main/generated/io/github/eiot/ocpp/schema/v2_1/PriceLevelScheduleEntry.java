
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;


/**
 * Part of ISO 15118-20 price schedule.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "duration",
    "priceLevel",
    "customData"
})
public class PriceLevelScheduleEntry {

    /**
     * The amount of seconds that define the duration of this given PriceLevelScheduleEntry.
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("The amount of seconds that define the duration of this given PriceLevelScheduleEntry.\r\n")
    @NotNull
    private int duration;
    /**
     * Defines the price level of this PriceLevelScheduleEntry (referring to NumberOfPriceLevels). Small values for the PriceLevel represent a cheaper PriceLevelScheduleEntry. Large values for the PriceLevel represent a more expensive PriceLevelScheduleEntry.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceLevel")
    @JsonPropertyDescription("Defines the price level of this PriceLevelScheduleEntry (referring to NumberOfPriceLevels). Small values for the PriceLevel represent a cheaper PriceLevelScheduleEntry. Large values for the PriceLevel represent a more expensive PriceLevelScheduleEntry.\r\n")
    @DecimalMin("0")
    @NotNull
    private int priceLevel;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * The amount of seconds that define the duration of this given PriceLevelScheduleEntry.
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }

    /**
     * The amount of seconds that define the duration of this given PriceLevelScheduleEntry.
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public PriceLevelScheduleEntry withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Defines the price level of this PriceLevelScheduleEntry (referring to NumberOfPriceLevels). Small values for the PriceLevel represent a cheaper PriceLevelScheduleEntry. Large values for the PriceLevel represent a more expensive PriceLevelScheduleEntry.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceLevel")
    public int getPriceLevel() {
        return priceLevel;
    }

    /**
     * Defines the price level of this PriceLevelScheduleEntry (referring to NumberOfPriceLevels). Small values for the PriceLevel represent a cheaper PriceLevelScheduleEntry. Large values for the PriceLevel represent a more expensive PriceLevelScheduleEntry.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceLevel")
    public void setPriceLevel(int priceLevel) {
        this.priceLevel = priceLevel;
    }

    public PriceLevelScheduleEntry withPriceLevel(int priceLevel) {
        this.priceLevel = priceLevel;
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

    public PriceLevelScheduleEntry withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PriceLevelScheduleEntry.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
        sb.append(',');
        sb.append("priceLevel");
        sb.append('=');
        sb.append(this.priceLevel);
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
        result = ((result* 31)+ this.duration);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.priceLevel);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PriceLevelScheduleEntry) == false) {
            return false;
        }
        PriceLevelScheduleEntry rhs = ((PriceLevelScheduleEntry) other);
        return (((this.duration == rhs.duration)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.priceLevel == rhs.priceLevel));
    }

}
