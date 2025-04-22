
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * *(2.1)* A schedule of the energy amount over time that EV is willing to discharge. A negative value indicates the willingness to discharge under specific conditions, a positive value indicates that the EV currently is not able to offer energy to discharge. 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "evAbsolutePriceSchedule",
    "evPowerSchedule",
    "customData"
})
public class EVEnergyOffer {

    /**
     * *(2.1)* Price schedule of EV energy offer.
     * 
     * 
     */
    @JsonProperty("evAbsolutePriceSchedule")
    @JsonPropertyDescription("*(2.1)* Price schedule of EV energy offer.\r\n")
    @Valid
    private EVAbsolutePriceSchedule evAbsolutePriceSchedule;
    /**
     * *(2.1)* Schedule of EV energy offer.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evPowerSchedule")
    @JsonPropertyDescription("*(2.1)* Schedule of EV energy offer.\r\n")
    @Valid
    @NotNull
    private EVPowerSchedule evPowerSchedule;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * *(2.1)* Price schedule of EV energy offer.
     * 
     * 
     */
    @JsonProperty("evAbsolutePriceSchedule")
    public EVAbsolutePriceSchedule getEvAbsolutePriceSchedule() {
        return evAbsolutePriceSchedule;
    }

    /**
     * *(2.1)* Price schedule of EV energy offer.
     * 
     * 
     */
    @JsonProperty("evAbsolutePriceSchedule")
    public void setEvAbsolutePriceSchedule(EVAbsolutePriceSchedule evAbsolutePriceSchedule) {
        this.evAbsolutePriceSchedule = evAbsolutePriceSchedule;
    }

    public EVEnergyOffer withEvAbsolutePriceSchedule(EVAbsolutePriceSchedule evAbsolutePriceSchedule) {
        this.evAbsolutePriceSchedule = evAbsolutePriceSchedule;
        return this;
    }

    /**
     * *(2.1)* Schedule of EV energy offer.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evPowerSchedule")
    public EVPowerSchedule getEvPowerSchedule() {
        return evPowerSchedule;
    }

    /**
     * *(2.1)* Schedule of EV energy offer.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evPowerSchedule")
    public void setEvPowerSchedule(EVPowerSchedule evPowerSchedule) {
        this.evPowerSchedule = evPowerSchedule;
    }

    public EVEnergyOffer withEvPowerSchedule(EVPowerSchedule evPowerSchedule) {
        this.evPowerSchedule = evPowerSchedule;
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

    public EVEnergyOffer withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EVEnergyOffer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("evAbsolutePriceSchedule");
        sb.append('=');
        sb.append(((this.evAbsolutePriceSchedule == null)?"<null>":this.evAbsolutePriceSchedule));
        sb.append(',');
        sb.append("evPowerSchedule");
        sb.append('=');
        sb.append(((this.evPowerSchedule == null)?"<null>":this.evPowerSchedule));
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
        result = ((result* 31)+((this.evPowerSchedule == null)? 0 :this.evPowerSchedule.hashCode()));
        result = ((result* 31)+((this.evAbsolutePriceSchedule == null)? 0 :this.evAbsolutePriceSchedule.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EVEnergyOffer) == false) {
            return false;
        }
        EVEnergyOffer rhs = ((EVEnergyOffer) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.evPowerSchedule == rhs.evPowerSchedule)||((this.evPowerSchedule!= null)&&this.evPowerSchedule.equals(rhs.evPowerSchedule))))&&((this.evAbsolutePriceSchedule == rhs.evAbsolutePriceSchedule)||((this.evAbsolutePriceSchedule!= null)&&this.evAbsolutePriceSchedule.equals(rhs.evAbsolutePriceSchedule))));
    }

}
