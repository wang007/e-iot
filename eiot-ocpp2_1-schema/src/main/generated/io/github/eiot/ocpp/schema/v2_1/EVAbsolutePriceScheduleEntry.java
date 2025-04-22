
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
 * *(2.1)* An entry in price schedule over time for which EV is willing to discharge.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "duration",
    "evPriceRule",
    "customData"
})
public class EVAbsolutePriceScheduleEntry {

    /**
     * The amount of seconds of this entry.
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("The amount of seconds of this entry.\r\n")
    @NotNull
    private int duration;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("evPriceRule")
    @Size(min = 1, max = 8)
    @Valid
    @NotNull
    private List<EVPriceRule> evPriceRule = new ArrayList<EVPriceRule>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * The amount of seconds of this entry.
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }

    /**
     * The amount of seconds of this entry.
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public EVAbsolutePriceScheduleEntry withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("evPriceRule")
    public List<EVPriceRule> getEvPriceRule() {
        return evPriceRule;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("evPriceRule")
    public void setEvPriceRule(List<EVPriceRule> evPriceRule) {
        this.evPriceRule = evPriceRule;
    }

    public EVAbsolutePriceScheduleEntry withEvPriceRule(List<EVPriceRule> evPriceRule) {
        this.evPriceRule = evPriceRule;
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

    public EVAbsolutePriceScheduleEntry withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EVAbsolutePriceScheduleEntry.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
        sb.append(',');
        sb.append("evPriceRule");
        sb.append('=');
        sb.append(((this.evPriceRule == null)?"<null>":this.evPriceRule));
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
        result = ((result* 31)+((this.evPriceRule == null)? 0 :this.evPriceRule.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EVAbsolutePriceScheduleEntry) == false) {
            return false;
        }
        EVAbsolutePriceScheduleEntry rhs = ((EVAbsolutePriceScheduleEntry) other);
        return (((this.duration == rhs.duration)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.evPriceRule == rhs.evPriceRule)||((this.evPriceRule!= null)&&this.evPriceRule.equals(rhs.evPriceRule))));
    }

}
