
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
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "duration",
    "priceRule",
    "customData"
})
public class PriceRuleStack {

    /**
     * Duration of the stack of price rules.  he amount of seconds that define the duration of the given PriceRule(s).
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Duration of the stack of price rules.  he amount of seconds that define the duration of the given PriceRule(s).\r\n")
    @NotNull
    private int duration;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceRule")
    @Size(min = 1, max = 8)
    @Valid
    @NotNull
    private List<PriceRule> priceRule = new ArrayList<PriceRule>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Duration of the stack of price rules.  he amount of seconds that define the duration of the given PriceRule(s).
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }

    /**
     * Duration of the stack of price rules.  he amount of seconds that define the duration of the given PriceRule(s).
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public PriceRuleStack withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceRule")
    public List<PriceRule> getPriceRule() {
        return priceRule;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceRule")
    public void setPriceRule(List<PriceRule> priceRule) {
        this.priceRule = priceRule;
    }

    public PriceRuleStack withPriceRule(List<PriceRule> priceRule) {
        this.priceRule = priceRule;
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

    public PriceRuleStack withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PriceRuleStack.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
        sb.append(',');
        sb.append("priceRule");
        sb.append('=');
        sb.append(((this.priceRule == null)?"<null>":this.priceRule));
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
        result = ((result* 31)+((this.priceRule == null)? 0 :this.priceRule.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PriceRuleStack) == false) {
            return false;
        }
        PriceRuleStack rhs = ((PriceRuleStack) other);
        return (((this.duration == rhs.duration)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.priceRule == rhs.priceRule)||((this.priceRule!= null)&&this.priceRule.equals(rhs.priceRule))));
    }

}
