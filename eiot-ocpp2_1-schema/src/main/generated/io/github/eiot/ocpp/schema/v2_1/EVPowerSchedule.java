
package io.github.eiot.ocpp.schema.v2_1;

import java.time.ZonedDateTime;
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
 * *(2.1)* Schedule of EV energy offer.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "evPowerScheduleEntries",
    "timeAnchor",
    "customData"
})
public class EVPowerSchedule {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("evPowerScheduleEntries")
    @Size(min = 1, max = 1024)
    @Valid
    @NotNull
    private List<EVPowerScheduleEntry> evPowerScheduleEntries = new ArrayList<EVPowerScheduleEntry>();
    /**
     * The time that defines the starting point for the EVEnergyOffer.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    @JsonPropertyDescription("The time that defines the starting point for the EVEnergyOffer.\r\n")
    @NotNull
    private ZonedDateTime timeAnchor;
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
    @JsonProperty("evPowerScheduleEntries")
    public List<EVPowerScheduleEntry> getEvPowerScheduleEntries() {
        return evPowerScheduleEntries;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("evPowerScheduleEntries")
    public void setEvPowerScheduleEntries(List<EVPowerScheduleEntry> evPowerScheduleEntries) {
        this.evPowerScheduleEntries = evPowerScheduleEntries;
    }

    public EVPowerSchedule withEvPowerScheduleEntries(List<EVPowerScheduleEntry> evPowerScheduleEntries) {
        this.evPowerScheduleEntries = evPowerScheduleEntries;
        return this;
    }

    /**
     * The time that defines the starting point for the EVEnergyOffer.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    public ZonedDateTime getTimeAnchor() {
        return timeAnchor;
    }

    /**
     * The time that defines the starting point for the EVEnergyOffer.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    public void setTimeAnchor(ZonedDateTime timeAnchor) {
        this.timeAnchor = timeAnchor;
    }

    public EVPowerSchedule withTimeAnchor(ZonedDateTime timeAnchor) {
        this.timeAnchor = timeAnchor;
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

    public EVPowerSchedule withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EVPowerSchedule.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("evPowerScheduleEntries");
        sb.append('=');
        sb.append(((this.evPowerScheduleEntries == null)?"<null>":this.evPowerScheduleEntries));
        sb.append(',');
        sb.append("timeAnchor");
        sb.append('=');
        sb.append(((this.timeAnchor == null)?"<null>":this.timeAnchor));
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
        result = ((result* 31)+((this.evPowerScheduleEntries == null)? 0 :this.evPowerScheduleEntries.hashCode()));
        result = ((result* 31)+((this.timeAnchor == null)? 0 :this.timeAnchor.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EVPowerSchedule) == false) {
            return false;
        }
        EVPowerSchedule rhs = ((EVPowerSchedule) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.evPowerScheduleEntries == rhs.evPowerScheduleEntries)||((this.evPowerScheduleEntries!= null)&&this.evPowerScheduleEntries.equals(rhs.evPowerScheduleEntries))))&&((this.timeAnchor == rhs.timeAnchor)||((this.timeAnchor!= null)&&this.timeAnchor.equals(rhs.timeAnchor))));
    }

}
