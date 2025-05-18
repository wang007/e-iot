
package io.github.eiot.ocpp.schema.v2_1;

import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "evseId",
    "maxScheduleTuples",
    "chargingNeeds",
    "timestamp",
    "customData"
})
public class NotifyEVChargingNeedsRequest {

    /**
     * Defines the EVSE and connector to which the EV is connected. EvseId may not be 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("Defines the EVSE and connector to which the EV is connected. EvseId may not be 0.\r\n")
    @DecimalMin("1")
    @NotNull
    private int evseId;
    /**
     * Contains the maximum elements the EV supports for: +
     * - ISO 15118-2: schedule tuples in SASchedule (both Pmax and Tariff). +
     * - ISO 15118-20: PowerScheduleEntry, PriceRule and PriceLevelScheduleEntries.
     * 
     * 
     */
    @JsonProperty("maxScheduleTuples")
    @JsonPropertyDescription("Contains the maximum elements the EV supports for: +\r\n- ISO 15118-2: schedule tuples in SASchedule (both Pmax and Tariff). +\r\n- ISO 15118-20: PowerScheduleEntry, PriceRule and PriceLevelScheduleEntries.\r\n")
    @DecimalMin("0")
    private int maxScheduleTuples;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingNeeds")
    @Valid
    @NotNull
    private ChargingNeeds chargingNeeds;
    /**
     * *(2.1)* Time when EV charging needs were received. +
     * Field can be added when charging station was offline when charging needs were received.
     * 
     * 
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("*(2.1)* Time when EV charging needs were received. +\r\nField can be added when charging station was offline when charging needs were received.\r\n\r\n")
    private ZonedDateTime timestamp;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

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

    /**
     * Contains the maximum elements the EV supports for: +
     * - ISO 15118-2: schedule tuples in SASchedule (both Pmax and Tariff). +
     * - ISO 15118-20: PowerScheduleEntry, PriceRule and PriceLevelScheduleEntries.
     * 
     * 
     */
    @JsonProperty("maxScheduleTuples")
    public int getMaxScheduleTuples() {
        return maxScheduleTuples;
    }

    /**
     * Contains the maximum elements the EV supports for: +
     * - ISO 15118-2: schedule tuples in SASchedule (both Pmax and Tariff). +
     * - ISO 15118-20: PowerScheduleEntry, PriceRule and PriceLevelScheduleEntries.
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingNeeds")
    public ChargingNeeds getChargingNeeds() {
        return chargingNeeds;
    }

    /**
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
     * *(2.1)* Time when EV charging needs were received. +
     * Field can be added when charging station was offline when charging needs were received.
     * 
     * 
     * 
     */
    @JsonProperty("timestamp")
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * *(2.1)* Time when EV charging needs were received. +
     * Field can be added when charging station was offline when charging needs were received.
     * 
     * 
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public NotifyEVChargingNeedsRequest withTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
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

    public NotifyEVChargingNeedsRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyEVChargingNeedsRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
        sb.append(',');
        sb.append("maxScheduleTuples");
        sb.append('=');
        sb.append(this.maxScheduleTuples);
        sb.append(',');
        sb.append("chargingNeeds");
        sb.append('=');
        sb.append(((this.chargingNeeds == null)?"<null>":this.chargingNeeds));
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
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
        result = ((result* 31)+ this.evseId);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.maxScheduleTuples);
        result = ((result* 31)+((this.chargingNeeds == null)? 0 :this.chargingNeeds.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
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
        return (((((this.evseId == rhs.evseId)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.maxScheduleTuples == rhs.maxScheduleTuples))&&((this.chargingNeeds == rhs.chargingNeeds)||((this.chargingNeeds!= null)&&this.chargingNeeds.equals(rhs.chargingNeeds))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))));
    }

}
