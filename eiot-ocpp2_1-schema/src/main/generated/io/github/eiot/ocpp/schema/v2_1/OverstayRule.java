
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Part of ISO 15118-20 price schedule.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "overstayFee",
    "overstayRuleDescription",
    "startTime",
    "overstayFeePeriod",
    "customData"
})
public class OverstayRule {

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("overstayFee")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    @NotNull
    private RationalNumber overstayFee;
    /**
     * Human readable string to identify the overstay rule.
     * 
     * 
     */
    @JsonProperty("overstayRuleDescription")
    @JsonPropertyDescription("Human readable string to identify the overstay rule.\r\n")
    @Size(max = 32)
    private String overstayRuleDescription;
    /**
     * Time in seconds after trigger of the parent Overstay Rules for this particular fee to apply.
     * 
     * (Required)
     * 
     */
    @JsonProperty("startTime")
    @JsonPropertyDescription("Time in seconds after trigger of the parent Overstay Rules for this particular fee to apply.\r\n")
    @NotNull
    private int startTime;
    /**
     * Time till overstay will be reapplied
     * 
     * (Required)
     * 
     */
    @JsonProperty("overstayFeePeriod")
    @JsonPropertyDescription("Time till overstay will be reapplied\r\n")
    @NotNull
    private int overstayFeePeriod;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("overstayFee")
    public RationalNumber getOverstayFee() {
        return overstayFee;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("overstayFee")
    public void setOverstayFee(RationalNumber overstayFee) {
        this.overstayFee = overstayFee;
    }

    public OverstayRule withOverstayFee(RationalNumber overstayFee) {
        this.overstayFee = overstayFee;
        return this;
    }

    /**
     * Human readable string to identify the overstay rule.
     * 
     * 
     */
    @JsonProperty("overstayRuleDescription")
    public String getOverstayRuleDescription() {
        return overstayRuleDescription;
    }

    /**
     * Human readable string to identify the overstay rule.
     * 
     * 
     */
    @JsonProperty("overstayRuleDescription")
    public void setOverstayRuleDescription(String overstayRuleDescription) {
        this.overstayRuleDescription = overstayRuleDescription;
    }

    public OverstayRule withOverstayRuleDescription(String overstayRuleDescription) {
        this.overstayRuleDescription = overstayRuleDescription;
        return this;
    }

    /**
     * Time in seconds after trigger of the parent Overstay Rules for this particular fee to apply.
     * 
     * (Required)
     * 
     */
    @JsonProperty("startTime")
    public int getStartTime() {
        return startTime;
    }

    /**
     * Time in seconds after trigger of the parent Overstay Rules for this particular fee to apply.
     * 
     * (Required)
     * 
     */
    @JsonProperty("startTime")
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public OverstayRule withStartTime(int startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Time till overstay will be reapplied
     * 
     * (Required)
     * 
     */
    @JsonProperty("overstayFeePeriod")
    public int getOverstayFeePeriod() {
        return overstayFeePeriod;
    }

    /**
     * Time till overstay will be reapplied
     * 
     * (Required)
     * 
     */
    @JsonProperty("overstayFeePeriod")
    public void setOverstayFeePeriod(int overstayFeePeriod) {
        this.overstayFeePeriod = overstayFeePeriod;
    }

    public OverstayRule withOverstayFeePeriod(int overstayFeePeriod) {
        this.overstayFeePeriod = overstayFeePeriod;
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

    public OverstayRule withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OverstayRule.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("overstayFee");
        sb.append('=');
        sb.append(((this.overstayFee == null)?"<null>":this.overstayFee));
        sb.append(',');
        sb.append("overstayRuleDescription");
        sb.append('=');
        sb.append(((this.overstayRuleDescription == null)?"<null>":this.overstayRuleDescription));
        sb.append(',');
        sb.append("startTime");
        sb.append('=');
        sb.append(this.startTime);
        sb.append(',');
        sb.append("overstayFeePeriod");
        sb.append('=');
        sb.append(this.overstayFeePeriod);
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
        result = ((result* 31)+ this.startTime);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.overstayFee == null)? 0 :this.overstayFee.hashCode()));
        result = ((result* 31)+ this.overstayFeePeriod);
        result = ((result* 31)+((this.overstayRuleDescription == null)? 0 :this.overstayRuleDescription.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OverstayRule) == false) {
            return false;
        }
        OverstayRule rhs = ((OverstayRule) other);
        return (((((this.startTime == rhs.startTime)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.overstayFee == rhs.overstayFee)||((this.overstayFee!= null)&&this.overstayFee.equals(rhs.overstayFee))))&&(this.overstayFeePeriod == rhs.overstayFeePeriod))&&((this.overstayRuleDescription == rhs.overstayRuleDescription)||((this.overstayRuleDescription!= null)&&this.overstayRuleDescription.equals(rhs.overstayRuleDescription))));
    }

}
