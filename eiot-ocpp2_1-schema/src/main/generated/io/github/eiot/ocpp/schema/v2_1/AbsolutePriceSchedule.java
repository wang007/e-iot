
package io.github.eiot.ocpp.schema.v2_1;

import java.time.ZonedDateTime;
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
 * The AbsolutePriceScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.
 * 
 * image::images/AbsolutePriceSchedule-Simple.png[]
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "timeAnchor",
    "priceScheduleID",
    "priceScheduleDescription",
    "currency",
    "language",
    "priceAlgorithm",
    "minimumCost",
    "maximumCost",
    "priceRuleStacks",
    "taxRules",
    "overstayRuleList",
    "additionalSelectedServices",
    "customData"
})
public class AbsolutePriceSchedule {

    /**
     * Starting point of price schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    @JsonPropertyDescription("Starting point of price schedule.\r\n")
    @NotNull
    private ZonedDateTime timeAnchor;
    /**
     * Unique ID of price schedule
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceScheduleID")
    @JsonPropertyDescription("Unique ID of price schedule\r\n")
    @DecimalMin("0")
    @NotNull
    private int priceScheduleID;
    /**
     * Description of the price schedule.
     * 
     * 
     */
    @JsonProperty("priceScheduleDescription")
    @JsonPropertyDescription("Description of the price schedule.\r\n")
    @Size(max = 160)
    private String priceScheduleDescription;
    /**
     * Currency according to ISO 4217.
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    @JsonPropertyDescription("Currency according to ISO 4217.\r\n")
    @Size(max = 3)
    @NotNull
    private String currency;
    /**
     * String that indicates what language is used for the human readable strings in the price schedule. Based on ISO 639.
     * 
     * (Required)
     * 
     */
    @JsonProperty("language")
    @JsonPropertyDescription("String that indicates what language is used for the human readable strings in the price schedule. Based on ISO 639.\r\n")
    @Size(max = 8)
    @NotNull
    private String language;
    /**
     * A string in URN notation which shall uniquely identify an algorithm that defines how to compute an energy fee sum for a specific power profile based on the EnergyFee information from the PriceRule elements.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceAlgorithm")
    @JsonPropertyDescription("A string in URN notation which shall uniquely identify an algorithm that defines how to compute an energy fee sum for a specific power profile based on the EnergyFee information from the PriceRule elements.\r\n")
    @Size(max = 2000)
    @NotNull
    private String priceAlgorithm;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("minimumCost")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    private RationalNumber minimumCost;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("maximumCost")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    private RationalNumber maximumCost;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceRuleStacks")
    @Size(min = 1, max = 1024)
    @Valid
    @NotNull
    private List<PriceRuleStack> priceRuleStacks = new ArrayList<PriceRuleStack>();
    @JsonProperty("taxRules")
    @Size(min = 1, max = 10)
    @Valid
    private List<TaxRule> taxRules = new ArrayList<TaxRule>();
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("overstayRuleList")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    private OverstayRuleList overstayRuleList;
    @JsonProperty("additionalSelectedServices")
    @Size(min = 1, max = 5)
    @Valid
    private List<AdditionalSelectedServices> additionalSelectedServices = new ArrayList<AdditionalSelectedServices>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Starting point of price schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    public ZonedDateTime getTimeAnchor() {
        return timeAnchor;
    }

    /**
     * Starting point of price schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    public void setTimeAnchor(ZonedDateTime timeAnchor) {
        this.timeAnchor = timeAnchor;
    }

    public AbsolutePriceSchedule withTimeAnchor(ZonedDateTime timeAnchor) {
        this.timeAnchor = timeAnchor;
        return this;
    }

    /**
     * Unique ID of price schedule
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceScheduleID")
    public int getPriceScheduleID() {
        return priceScheduleID;
    }

    /**
     * Unique ID of price schedule
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceScheduleID")
    public void setPriceScheduleID(int priceScheduleID) {
        this.priceScheduleID = priceScheduleID;
    }

    public AbsolutePriceSchedule withPriceScheduleID(int priceScheduleID) {
        this.priceScheduleID = priceScheduleID;
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

    public AbsolutePriceSchedule withPriceScheduleDescription(String priceScheduleDescription) {
        this.priceScheduleDescription = priceScheduleDescription;
        return this;
    }

    /**
     * Currency according to ISO 4217.
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * Currency according to ISO 4217.
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AbsolutePriceSchedule withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * String that indicates what language is used for the human readable strings in the price schedule. Based on ISO 639.
     * 
     * (Required)
     * 
     */
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    /**
     * String that indicates what language is used for the human readable strings in the price schedule. Based on ISO 639.
     * 
     * (Required)
     * 
     */
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    public AbsolutePriceSchedule withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * A string in URN notation which shall uniquely identify an algorithm that defines how to compute an energy fee sum for a specific power profile based on the EnergyFee information from the PriceRule elements.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceAlgorithm")
    public String getPriceAlgorithm() {
        return priceAlgorithm;
    }

    /**
     * A string in URN notation which shall uniquely identify an algorithm that defines how to compute an energy fee sum for a specific power profile based on the EnergyFee information from the PriceRule elements.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceAlgorithm")
    public void setPriceAlgorithm(String priceAlgorithm) {
        this.priceAlgorithm = priceAlgorithm;
    }

    public AbsolutePriceSchedule withPriceAlgorithm(String priceAlgorithm) {
        this.priceAlgorithm = priceAlgorithm;
        return this;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("minimumCost")
    public RationalNumber getMinimumCost() {
        return minimumCost;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("minimumCost")
    public void setMinimumCost(RationalNumber minimumCost) {
        this.minimumCost = minimumCost;
    }

    public AbsolutePriceSchedule withMinimumCost(RationalNumber minimumCost) {
        this.minimumCost = minimumCost;
        return this;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("maximumCost")
    public RationalNumber getMaximumCost() {
        return maximumCost;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("maximumCost")
    public void setMaximumCost(RationalNumber maximumCost) {
        this.maximumCost = maximumCost;
    }

    public AbsolutePriceSchedule withMaximumCost(RationalNumber maximumCost) {
        this.maximumCost = maximumCost;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceRuleStacks")
    public List<PriceRuleStack> getPriceRuleStacks() {
        return priceRuleStacks;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceRuleStacks")
    public void setPriceRuleStacks(List<PriceRuleStack> priceRuleStacks) {
        this.priceRuleStacks = priceRuleStacks;
    }

    public AbsolutePriceSchedule withPriceRuleStacks(List<PriceRuleStack> priceRuleStacks) {
        this.priceRuleStacks = priceRuleStacks;
        return this;
    }

    @JsonProperty("taxRules")
    public List<TaxRule> getTaxRules() {
        return taxRules;
    }

    @JsonProperty("taxRules")
    public void setTaxRules(List<TaxRule> taxRules) {
        this.taxRules = taxRules;
    }

    public AbsolutePriceSchedule withTaxRules(List<TaxRule> taxRules) {
        this.taxRules = taxRules;
        return this;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("overstayRuleList")
    public OverstayRuleList getOverstayRuleList() {
        return overstayRuleList;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("overstayRuleList")
    public void setOverstayRuleList(OverstayRuleList overstayRuleList) {
        this.overstayRuleList = overstayRuleList;
    }

    public AbsolutePriceSchedule withOverstayRuleList(OverstayRuleList overstayRuleList) {
        this.overstayRuleList = overstayRuleList;
        return this;
    }

    @JsonProperty("additionalSelectedServices")
    public List<AdditionalSelectedServices> getAdditionalSelectedServices() {
        return additionalSelectedServices;
    }

    @JsonProperty("additionalSelectedServices")
    public void setAdditionalSelectedServices(List<AdditionalSelectedServices> additionalSelectedServices) {
        this.additionalSelectedServices = additionalSelectedServices;
    }

    public AbsolutePriceSchedule withAdditionalSelectedServices(List<AdditionalSelectedServices> additionalSelectedServices) {
        this.additionalSelectedServices = additionalSelectedServices;
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

    public AbsolutePriceSchedule withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AbsolutePriceSchedule.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("timeAnchor");
        sb.append('=');
        sb.append(((this.timeAnchor == null)?"<null>":this.timeAnchor));
        sb.append(',');
        sb.append("priceScheduleID");
        sb.append('=');
        sb.append(this.priceScheduleID);
        sb.append(',');
        sb.append("priceScheduleDescription");
        sb.append('=');
        sb.append(((this.priceScheduleDescription == null)?"<null>":this.priceScheduleDescription));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null)?"<null>":this.language));
        sb.append(',');
        sb.append("priceAlgorithm");
        sb.append('=');
        sb.append(((this.priceAlgorithm == null)?"<null>":this.priceAlgorithm));
        sb.append(',');
        sb.append("minimumCost");
        sb.append('=');
        sb.append(((this.minimumCost == null)?"<null>":this.minimumCost));
        sb.append(',');
        sb.append("maximumCost");
        sb.append('=');
        sb.append(((this.maximumCost == null)?"<null>":this.maximumCost));
        sb.append(',');
        sb.append("priceRuleStacks");
        sb.append('=');
        sb.append(((this.priceRuleStacks == null)?"<null>":this.priceRuleStacks));
        sb.append(',');
        sb.append("taxRules");
        sb.append('=');
        sb.append(((this.taxRules == null)?"<null>":this.taxRules));
        sb.append(',');
        sb.append("overstayRuleList");
        sb.append('=');
        sb.append(((this.overstayRuleList == null)?"<null>":this.overstayRuleList));
        sb.append(',');
        sb.append("additionalSelectedServices");
        sb.append('=');
        sb.append(((this.additionalSelectedServices == null)?"<null>":this.additionalSelectedServices));
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
        result = ((result* 31)+((this.taxRules == null)? 0 :this.taxRules.hashCode()));
        result = ((result* 31)+((this.additionalSelectedServices == null)? 0 :this.additionalSelectedServices.hashCode()));
        result = ((result* 31)+((this.overstayRuleList == null)? 0 :this.overstayRuleList.hashCode()));
        result = ((result* 31)+((this.language == null)? 0 :this.language.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.minimumCost == null)? 0 :this.minimumCost.hashCode()));
        result = ((result* 31)+((this.priceAlgorithm == null)? 0 :this.priceAlgorithm.hashCode()));
        result = ((result* 31)+ this.priceScheduleID);
        result = ((result* 31)+((this.priceRuleStacks == null)? 0 :this.priceRuleStacks.hashCode()));
        result = ((result* 31)+((this.timeAnchor == null)? 0 :this.timeAnchor.hashCode()));
        result = ((result* 31)+((this.priceScheduleDescription == null)? 0 :this.priceScheduleDescription.hashCode()));
        result = ((result* 31)+((this.currency == null)? 0 :this.currency.hashCode()));
        result = ((result* 31)+((this.maximumCost == null)? 0 :this.maximumCost.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AbsolutePriceSchedule) == false) {
            return false;
        }
        AbsolutePriceSchedule rhs = ((AbsolutePriceSchedule) other);
        return ((((((((((((((this.taxRules == rhs.taxRules)||((this.taxRules!= null)&&this.taxRules.equals(rhs.taxRules)))&&((this.additionalSelectedServices == rhs.additionalSelectedServices)||((this.additionalSelectedServices!= null)&&this.additionalSelectedServices.equals(rhs.additionalSelectedServices))))&&((this.overstayRuleList == rhs.overstayRuleList)||((this.overstayRuleList!= null)&&this.overstayRuleList.equals(rhs.overstayRuleList))))&&((this.language == rhs.language)||((this.language!= null)&&this.language.equals(rhs.language))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.minimumCost == rhs.minimumCost)||((this.minimumCost!= null)&&this.minimumCost.equals(rhs.minimumCost))))&&((this.priceAlgorithm == rhs.priceAlgorithm)||((this.priceAlgorithm!= null)&&this.priceAlgorithm.equals(rhs.priceAlgorithm))))&&(this.priceScheduleID == rhs.priceScheduleID))&&((this.priceRuleStacks == rhs.priceRuleStacks)||((this.priceRuleStacks!= null)&&this.priceRuleStacks.equals(rhs.priceRuleStacks))))&&((this.timeAnchor == rhs.timeAnchor)||((this.timeAnchor!= null)&&this.timeAnchor.equals(rhs.timeAnchor))))&&((this.priceScheduleDescription == rhs.priceScheduleDescription)||((this.priceScheduleDescription!= null)&&this.priceScheduleDescription.equals(rhs.priceScheduleDescription))))&&((this.currency == rhs.currency)||((this.currency!= null)&&this.currency.equals(rhs.currency))))&&((this.maximumCost == rhs.maximumCost)||((this.maximumCost!= null)&&this.maximumCost.equals(rhs.maximumCost))));
    }

}
