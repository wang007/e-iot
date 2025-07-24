
package io.github.eiot.ocpp.schema.v2_1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * *(2.1)* Price schedule of EV energy offer.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "timeAnchor",
    "currency",
    "evAbsolutePriceScheduleEntries",
    "priceAlgorithm",
    "customData"
})
public class EVAbsolutePriceSchedule {

    /**
     * Starting point in time of the EVEnergyOffer.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    @JsonPropertyDescription("Starting point in time of the EVEnergyOffer.\r\n")
    @NotNull
    private OffsetDateTime timeAnchor;
    /**
     * Currency code according to ISO 4217.
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    @JsonPropertyDescription("Currency code according to ISO 4217.\r\n")
    @Size(max = 3)
    @NotNull
    private String currency;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("evAbsolutePriceScheduleEntries")
    @Size(min = 1, max = 1024)
    @Valid
    @NotNull
    private List<EVAbsolutePriceScheduleEntry> evAbsolutePriceScheduleEntries = new ArrayList<EVAbsolutePriceScheduleEntry>();
    /**
     * ISO 15118-20 URN of price algorithm: Power, PeakPower, StackedEnergy.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceAlgorithm")
    @JsonPropertyDescription("ISO 15118-20 URN of price algorithm: Power, PeakPower, StackedEnergy.\r\n")
    @Size(max = 2000)
    @NotNull
    private String priceAlgorithm;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Starting point in time of the EVEnergyOffer.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    public OffsetDateTime getTimeAnchor() {
        return timeAnchor;
    }

    /**
     * Starting point in time of the EVEnergyOffer.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    public void setTimeAnchor(OffsetDateTime timeAnchor) {
        this.timeAnchor = timeAnchor;
    }

    public EVAbsolutePriceSchedule withTimeAnchor(OffsetDateTime timeAnchor) {
        this.timeAnchor = timeAnchor;
        return this;
    }

    /**
     * Currency code according to ISO 4217.
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * Currency code according to ISO 4217.
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public EVAbsolutePriceSchedule withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("evAbsolutePriceScheduleEntries")
    public List<EVAbsolutePriceScheduleEntry> getEvAbsolutePriceScheduleEntries() {
        return evAbsolutePriceScheduleEntries;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("evAbsolutePriceScheduleEntries")
    public void setEvAbsolutePriceScheduleEntries(List<EVAbsolutePriceScheduleEntry> evAbsolutePriceScheduleEntries) {
        this.evAbsolutePriceScheduleEntries = evAbsolutePriceScheduleEntries;
    }

    public EVAbsolutePriceSchedule withEvAbsolutePriceScheduleEntries(List<EVAbsolutePriceScheduleEntry> evAbsolutePriceScheduleEntries) {
        this.evAbsolutePriceScheduleEntries = evAbsolutePriceScheduleEntries;
        return this;
    }

    /**
     * ISO 15118-20 URN of price algorithm: Power, PeakPower, StackedEnergy.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceAlgorithm")
    public String getPriceAlgorithm() {
        return priceAlgorithm;
    }

    /**
     * ISO 15118-20 URN of price algorithm: Power, PeakPower, StackedEnergy.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceAlgorithm")
    public void setPriceAlgorithm(String priceAlgorithm) {
        this.priceAlgorithm = priceAlgorithm;
    }

    public EVAbsolutePriceSchedule withPriceAlgorithm(String priceAlgorithm) {
        this.priceAlgorithm = priceAlgorithm;
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

    public EVAbsolutePriceSchedule withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EVAbsolutePriceSchedule.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("timeAnchor");
        sb.append('=');
        sb.append(((this.timeAnchor == null)?"<null>":this.timeAnchor));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
        sb.append(',');
        sb.append("evAbsolutePriceScheduleEntries");
        sb.append('=');
        sb.append(((this.evAbsolutePriceScheduleEntries == null)?"<null>":this.evAbsolutePriceScheduleEntries));
        sb.append(',');
        sb.append("priceAlgorithm");
        sb.append('=');
        sb.append(((this.priceAlgorithm == null)?"<null>":this.priceAlgorithm));
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
        result = ((result* 31)+((this.currency == null)? 0 :this.currency.hashCode()));
        result = ((result* 31)+((this.evAbsolutePriceScheduleEntries == null)? 0 :this.evAbsolutePriceScheduleEntries.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.priceAlgorithm == null)? 0 :this.priceAlgorithm.hashCode()));
        result = ((result* 31)+((this.timeAnchor == null)? 0 :this.timeAnchor.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EVAbsolutePriceSchedule) == false) {
            return false;
        }
        EVAbsolutePriceSchedule rhs = ((EVAbsolutePriceSchedule) other);
        return ((((((this.currency == rhs.currency)||((this.currency!= null)&&this.currency.equals(rhs.currency)))&&((this.evAbsolutePriceScheduleEntries == rhs.evAbsolutePriceScheduleEntries)||((this.evAbsolutePriceScheduleEntries!= null)&&this.evAbsolutePriceScheduleEntries.equals(rhs.evAbsolutePriceScheduleEntries))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.priceAlgorithm == rhs.priceAlgorithm)||((this.priceAlgorithm!= null)&&this.priceAlgorithm.equals(rhs.priceAlgorithm))))&&((this.timeAnchor == rhs.timeAnchor)||((this.timeAnchor!= null)&&this.timeAnchor.equals(rhs.timeAnchor))));
    }

}
