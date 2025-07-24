
package io.github.eiot.ocpp.schema.v2_1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * The PriceLevelScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "priceLevelScheduleEntries",
    "timeAnchor",
    "priceScheduleId",
    "priceScheduleDescription",
    "numberOfPriceLevels",
    "customData"
})
public class PriceLevelSchedule {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceLevelScheduleEntries")
    @Size(min = 1, max = 100)
    @Valid
    @NotNull
    private List<PriceLevelScheduleEntry> priceLevelScheduleEntries = new ArrayList<PriceLevelScheduleEntry>();
    /**
     * Starting point of this price schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    @JsonPropertyDescription("Starting point of this price schedule.\r\n")
    @NotNull
    private OffsetDateTime timeAnchor;
    /**
     * Unique ID of this price schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceScheduleId")
    @JsonPropertyDescription("Unique ID of this price schedule.\r\n")
    @DecimalMin("0")
    @NotNull
    private int priceScheduleId;
    /**
     * Description of the price schedule.
     * 
     * 
     */
    @JsonProperty("priceScheduleDescription")
    @JsonPropertyDescription("Description of the price schedule.\r\n")
    @Size(max = 32)
    private String priceScheduleDescription;
    /**
     * Defines the overall number of distinct price level elements used across all PriceLevelSchedules.
     * 
     * (Required)
     * 
     */
    @JsonProperty("numberOfPriceLevels")
    @JsonPropertyDescription("Defines the overall number of distinct price level elements used across all PriceLevelSchedules.\r\n")
    @DecimalMin("0")
    @NotNull
    private int numberOfPriceLevels;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceLevelScheduleEntries")
    public List<PriceLevelScheduleEntry> getPriceLevelScheduleEntries() {
        return priceLevelScheduleEntries;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceLevelScheduleEntries")
    public void setPriceLevelScheduleEntries(List<PriceLevelScheduleEntry> priceLevelScheduleEntries) {
        this.priceLevelScheduleEntries = priceLevelScheduleEntries;
    }

    public PriceLevelSchedule withPriceLevelScheduleEntries(List<PriceLevelScheduleEntry> priceLevelScheduleEntries) {
        this.priceLevelScheduleEntries = priceLevelScheduleEntries;
        return this;
    }

    /**
     * Starting point of this price schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    public OffsetDateTime getTimeAnchor() {
        return timeAnchor;
    }

    /**
     * Starting point of this price schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    public void setTimeAnchor(OffsetDateTime timeAnchor) {
        this.timeAnchor = timeAnchor;
    }

    public PriceLevelSchedule withTimeAnchor(OffsetDateTime timeAnchor) {
        this.timeAnchor = timeAnchor;
        return this;
    }

    /**
     * Unique ID of this price schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceScheduleId")
    public int getPriceScheduleId() {
        return priceScheduleId;
    }

    /**
     * Unique ID of this price schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceScheduleId")
    public void setPriceScheduleId(int priceScheduleId) {
        this.priceScheduleId = priceScheduleId;
    }

    public PriceLevelSchedule withPriceScheduleId(int priceScheduleId) {
        this.priceScheduleId = priceScheduleId;
        return this;
    }

    /**
     * Description of the price schedule.
     * 
     * 
     */
    @JsonProperty("priceScheduleDescription")
    public String getPriceScheduleDescription() {
        return priceScheduleDescription;
    }

    /**
     * Description of the price schedule.
     * 
     * 
     */
    @JsonProperty("priceScheduleDescription")
    public void setPriceScheduleDescription(String priceScheduleDescription) {
        this.priceScheduleDescription = priceScheduleDescription;
    }

    public PriceLevelSchedule withPriceScheduleDescription(String priceScheduleDescription) {
        this.priceScheduleDescription = priceScheduleDescription;
        return this;
    }

    /**
     * Defines the overall number of distinct price level elements used across all PriceLevelSchedules.
     * 
     * (Required)
     * 
     */
    @JsonProperty("numberOfPriceLevels")
    public int getNumberOfPriceLevels() {
        return numberOfPriceLevels;
    }

    /**
     * Defines the overall number of distinct price level elements used across all PriceLevelSchedules.
     * 
     * (Required)
     * 
     */
    @JsonProperty("numberOfPriceLevels")
    public void setNumberOfPriceLevels(int numberOfPriceLevels) {
        this.numberOfPriceLevels = numberOfPriceLevels;
    }

    public PriceLevelSchedule withNumberOfPriceLevels(int numberOfPriceLevels) {
        this.numberOfPriceLevels = numberOfPriceLevels;
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

    public PriceLevelSchedule withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PriceLevelSchedule.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("priceLevelScheduleEntries");
        sb.append('=');
        sb.append(((this.priceLevelScheduleEntries == null)?"<null>":this.priceLevelScheduleEntries));
        sb.append(',');
        sb.append("timeAnchor");
        sb.append('=');
        sb.append(((this.timeAnchor == null)?"<null>":this.timeAnchor));
        sb.append(',');
        sb.append("priceScheduleId");
        sb.append('=');
        sb.append(this.priceScheduleId);
        sb.append(',');
        sb.append("priceScheduleDescription");
        sb.append('=');
        sb.append(((this.priceScheduleDescription == null)?"<null>":this.priceScheduleDescription));
        sb.append(',');
        sb.append("numberOfPriceLevels");
        sb.append('=');
        sb.append(this.numberOfPriceLevels);
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
        result = ((result* 31)+ this.priceScheduleId);
        result = ((result* 31)+((this.priceLevelScheduleEntries == null)? 0 :this.priceLevelScheduleEntries.hashCode()));
        result = ((result* 31)+((this.timeAnchor == null)? 0 :this.timeAnchor.hashCode()));
        result = ((result* 31)+((this.priceScheduleDescription == null)? 0 :this.priceScheduleDescription.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.numberOfPriceLevels);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PriceLevelSchedule) == false) {
            return false;
        }
        PriceLevelSchedule rhs = ((PriceLevelSchedule) other);
        return ((((((this.priceScheduleId == rhs.priceScheduleId)&&((this.priceLevelScheduleEntries == rhs.priceLevelScheduleEntries)||((this.priceLevelScheduleEntries!= null)&&this.priceLevelScheduleEntries.equals(rhs.priceLevelScheduleEntries))))&&((this.timeAnchor == rhs.timeAnchor)||((this.timeAnchor!= null)&&this.timeAnchor.equals(rhs.timeAnchor))))&&((this.priceScheduleDescription == rhs.priceScheduleDescription)||((this.priceScheduleDescription!= null)&&this.priceScheduleDescription.equals(rhs.priceScheduleDescription))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.numberOfPriceLevels == rhs.numberOfPriceLevels));
    }

}
