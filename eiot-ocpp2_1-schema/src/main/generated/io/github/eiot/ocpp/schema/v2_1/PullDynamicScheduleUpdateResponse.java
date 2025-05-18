
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "scheduleUpdate",
    "status",
    "statusInfo",
    "customData"
})
public class PullDynamicScheduleUpdateResponse {

    /**
     * Updates to a ChargingSchedulePeriodType for dynamic charging profiles.
     * 
     * 
     * 
     */
    @JsonProperty("scheduleUpdate")
    @JsonPropertyDescription("Updates to a ChargingSchedulePeriodType for dynamic charging profiles.\r\n\r\n")
    @Valid
    private ChargingScheduleUpdate scheduleUpdate;
    /**
     * Result of request.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Result of request.\r\n\r\n")
    @NotNull
    private ChargingProfileStatusEnum status;
    /**
     * Element providing more information about the status.
     * 
     * 
     */
    @JsonProperty("statusInfo")
    @JsonPropertyDescription("Element providing more information about the status.\r\n")
    @Valid
    private StatusInfo statusInfo;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Updates to a ChargingSchedulePeriodType for dynamic charging profiles.
     * 
     * 
     * 
     */
    @JsonProperty("scheduleUpdate")
    public ChargingScheduleUpdate getScheduleUpdate() {
        return scheduleUpdate;
    }

    /**
     * Updates to a ChargingSchedulePeriodType for dynamic charging profiles.
     * 
     * 
     * 
     */
    @JsonProperty("scheduleUpdate")
    public void setScheduleUpdate(ChargingScheduleUpdate scheduleUpdate) {
        this.scheduleUpdate = scheduleUpdate;
    }

    public PullDynamicScheduleUpdateResponse withScheduleUpdate(ChargingScheduleUpdate scheduleUpdate) {
        this.scheduleUpdate = scheduleUpdate;
        return this;
    }

    /**
     * Result of request.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public ChargingProfileStatusEnum getStatus() {
        return status;
    }

    /**
     * Result of request.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(ChargingProfileStatusEnum status) {
        this.status = status;
    }

    public PullDynamicScheduleUpdateResponse withStatus(ChargingProfileStatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Element providing more information about the status.
     * 
     * 
     */
    @JsonProperty("statusInfo")
    public StatusInfo getStatusInfo() {
        return statusInfo;
    }

    /**
     * Element providing more information about the status.
     * 
     * 
     */
    @JsonProperty("statusInfo")
    public void setStatusInfo(StatusInfo statusInfo) {
        this.statusInfo = statusInfo;
    }

    public PullDynamicScheduleUpdateResponse withStatusInfo(StatusInfo statusInfo) {
        this.statusInfo = statusInfo;
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

    public PullDynamicScheduleUpdateResponse withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PullDynamicScheduleUpdateResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("scheduleUpdate");
        sb.append('=');
        sb.append(((this.scheduleUpdate == null)?"<null>":this.scheduleUpdate));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("statusInfo");
        sb.append('=');
        sb.append(((this.statusInfo == null)?"<null>":this.statusInfo));
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
        result = ((result* 31)+((this.scheduleUpdate == null)? 0 :this.scheduleUpdate.hashCode()));
        result = ((result* 31)+((this.statusInfo == null)? 0 :this.statusInfo.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PullDynamicScheduleUpdateResponse) == false) {
            return false;
        }
        PullDynamicScheduleUpdateResponse rhs = ((PullDynamicScheduleUpdateResponse) other);
        return (((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.scheduleUpdate == rhs.scheduleUpdate)||((this.scheduleUpdate!= null)&&this.scheduleUpdate.equals(rhs.scheduleUpdate))))&&((this.statusInfo == rhs.statusInfo)||((this.statusInfo!= null)&&this.statusInfo.equals(rhs.statusInfo))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
