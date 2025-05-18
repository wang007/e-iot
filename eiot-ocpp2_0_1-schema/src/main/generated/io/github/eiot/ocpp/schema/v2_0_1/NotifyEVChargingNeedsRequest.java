
package io.github.eiot.ocpp.schema.v2_0_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customData",
    "maxScheduleTuples",
    "chargingNeeds",
    "evseId"
})
public class NotifyEVChargingNeedsRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Contains the maximum schedule tuples the car supports per schedule.
     * 
     * 
     */
    @JsonProperty("maxScheduleTuples")
    @JsonPropertyDescription("Contains the maximum schedule tuples the car supports per schedule.\r\n")
    private int maxScheduleTuples;
    /**
     * Charging_ Needs
     * urn:x-oca:ocpp:uid:2:233249
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingNeeds")
    @JsonPropertyDescription("Charging_ Needs\r\nurn:x-oca:ocpp:uid:2:233249\r\n")
    @Valid
    @NotNull
    private ChargingNeeds chargingNeeds;
    /**
     * Defines the EVSE and connector to which the EV is connected. EvseId may not be 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("Defines the EVSE and connector to which the EV is connected. EvseId may not be 0.\r\n")
    @NotNull
    private int evseId;

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

    public NotifyEVChargingNeedsRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    /**
     * Contains the maximum schedule tuples the car supports per schedule.
     * 
     * 
     */
    @JsonProperty("maxScheduleTuples")
    public int getMaxScheduleTuples() {
        return maxScheduleTuples;
    }

    /**
     * Contains the maximum schedule tuples the car supports per schedule.
     * 
     * 
     */
    @JsonProperty("maxScheduleTuples")
    public void setMaxScheduleTuples(int maxScheduleTuples) {
        this.maxScheduleTuples = maxScheduleTuples;
    }

    public NotifyEVChargingNeedsRequest withMaxScheduleTuples(int maxScheduleTuples) {
        this.maxScheduleTuples = maxScheduleTuples;
        return this;
    }

    /**
     * Charging_ Needs
     * urn:x-oca:ocpp:uid:2:233249
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingNeeds")
    public ChargingNeeds getChargingNeeds() {
        return chargingNeeds;
    }

    /**
     * Charging_ Needs
     * urn:x-oca:ocpp:uid:2:233249
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingNeeds")
    public void setChargingNeeds(ChargingNeeds chargingNeeds) {
        this.chargingNeeds = chargingNeeds;
    }

    public NotifyEVChargingNeedsRequest withChargingNeeds(ChargingNeeds chargingNeeds) {
        this.chargingNeeds = chargingNeeds;
        return this;
    }

    /**
     * Defines the EVSE and connector to which the EV is connected. EvseId may not be 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * Defines the EVSE and connector to which the EV is connected. EvseId may not be 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public NotifyEVChargingNeedsRequest withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyEVChargingNeedsRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customData");
        sb.append('=');
        sb.append(((this.customData == null)?"<null>":this.customData));
        sb.append(',');
        sb.append("maxScheduleTuples");
        sb.append('=');
        sb.append(this.maxScheduleTuples);
        sb.append(',');
        sb.append("chargingNeeds");
        sb.append('=');
        sb.append(((this.chargingNeeds == null)?"<null>":this.chargingNeeds));
        sb.append(',');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
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
        result = ((result* 31)+ this.evseId);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.maxScheduleTuples);
        result = ((result* 31)+((this.chargingNeeds == null)? 0 :this.chargingNeeds.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NotifyEVChargingNeedsRequest) == false) {
            return false;
        }
        NotifyEVChargingNeedsRequest rhs = ((NotifyEVChargingNeedsRequest) other);
        return ((((this.evseId == rhs.evseId)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.maxScheduleTuples == rhs.maxScheduleTuples))&&((this.chargingNeeds == rhs.chargingNeeds)||((this.chargingNeeds!= null)&&this.chargingNeeds.equals(rhs.chargingNeeds))));
    }

}
