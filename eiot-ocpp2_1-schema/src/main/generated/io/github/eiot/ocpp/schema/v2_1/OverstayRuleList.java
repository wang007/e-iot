
package io.github.eiot.ocpp.schema.v2_1;

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
 * Part of ISO 15118-20 price schedule.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "overstayPowerThreshold",
    "overstayRule",
    "overstayTimeThreshold",
    "customData"
})
public class OverstayRuleList {

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("overstayPowerThreshold")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    private RationalNumber overstayPowerThreshold;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("overstayRule")
    @Size(min = 1, max = 5)
    @Valid
    @NotNull
    private List<OverstayRule> overstayRule = new ArrayList<OverstayRule>();
    /**
     * Time till overstay is applied in seconds.
     * 
     * 
     */
    @JsonProperty("overstayTimeThreshold")
    @JsonPropertyDescription("Time till overstay is applied in seconds.\r\n")
    private int overstayTimeThreshold;
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
     * 
     */
    @JsonProperty("overstayPowerThreshold")
    public RationalNumber getOverstayPowerThreshold() {
        return overstayPowerThreshold;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("overstayPowerThreshold")
    public void setOverstayPowerThreshold(RationalNumber overstayPowerThreshold) {
        this.overstayPowerThreshold = overstayPowerThreshold;
    }

    public OverstayRuleList withOverstayPowerThreshold(RationalNumber overstayPowerThreshold) {
        this.overstayPowerThreshold = overstayPowerThreshold;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("overstayRule")
    public List<OverstayRule> getOverstayRule() {
        return overstayRule;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("overstayRule")
    public void setOverstayRule(List<OverstayRule> overstayRule) {
        this.overstayRule = overstayRule;
    }

    public OverstayRuleList withOverstayRule(List<OverstayRule> overstayRule) {
        this.overstayRule = overstayRule;
        return this;
    }

    /**
     * Time till overstay is applied in seconds.
     * 
     * 
     */
    @JsonProperty("overstayTimeThreshold")
    public int getOverstayTimeThreshold() {
        return overstayTimeThreshold;
    }

    /**
     * Time till overstay is applied in seconds.
     * 
     * 
     */
    @JsonProperty("overstayTimeThreshold")
    public void setOverstayTimeThreshold(int overstayTimeThreshold) {
        this.overstayTimeThreshold = overstayTimeThreshold;
    }

    public OverstayRuleList withOverstayTimeThreshold(int overstayTimeThreshold) {
        this.overstayTimeThreshold = overstayTimeThreshold;
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

    public OverstayRuleList withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OverstayRuleList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("overstayPowerThreshold");
        sb.append('=');
        sb.append(((this.overstayPowerThreshold == null)?"<null>":this.overstayPowerThreshold));
        sb.append(',');
        sb.append("overstayRule");
        sb.append('=');
        sb.append(((this.overstayRule == null)?"<null>":this.overstayRule));
        sb.append(',');
        sb.append("overstayTimeThreshold");
        sb.append('=');
        sb.append(this.overstayTimeThreshold);
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
        result = ((result* 31)+ this.overstayTimeThreshold);
        result = ((result* 31)+((this.overstayPowerThreshold == null)? 0 :this.overstayPowerThreshold.hashCode()));
        result = ((result* 31)+((this.overstayRule == null)? 0 :this.overstayRule.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OverstayRuleList) == false) {
            return false;
        }
        OverstayRuleList rhs = ((OverstayRuleList) other);
        return (((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(this.overstayTimeThreshold == rhs.overstayTimeThreshold))&&((this.overstayPowerThreshold == rhs.overstayPowerThreshold)||((this.overstayPowerThreshold!= null)&&this.overstayPowerThreshold.equals(rhs.overstayPowerThreshold))))&&((this.overstayRule == rhs.overstayRule)||((this.overstayRule!= null)&&this.overstayRule.equals(rhs.overstayRule))));
    }

}
