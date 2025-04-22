
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chargingProfileId",
    "customData"
})
public class PullDynamicScheduleUpdateRequest {

    /**
     * Id of charging profile to update.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileId")
    @JsonPropertyDescription("Id of charging profile to update.\r\n")
    @NotNull
    private int chargingProfileId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Id of charging profile to update.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileId")
    public int getChargingProfileId() {
        return chargingProfileId;
    }

    /**
     * Id of charging profile to update.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileId")
    public void setChargingProfileId(int chargingProfileId) {
        this.chargingProfileId = chargingProfileId;
    }

    public PullDynamicScheduleUpdateRequest withChargingProfileId(int chargingProfileId) {
        this.chargingProfileId = chargingProfileId;
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

    public PullDynamicScheduleUpdateRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PullDynamicScheduleUpdateRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("chargingProfileId");
        sb.append('=');
        sb.append(this.chargingProfileId);
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
        result = ((result* 31)+ this.chargingProfileId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PullDynamicScheduleUpdateRequest) == false) {
            return false;
        }
        PullDynamicScheduleUpdateRequest rhs = ((PullDynamicScheduleUpdateRequest) other);
        return (((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(this.chargingProfileId == rhs.chargingProfileId));
    }

}
