
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "requestId",
    "statusInfo",
    "customData"
})
public class FirmwareStatusNotificationRequest {

    /**
     * This contains the progress status of the firmware installation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("This contains the progress status of the firmware installation.\r\n")
    @NotNull
    private FirmwareStatusEnum status;
    /**
     * The request id that was provided in the
     * UpdateFirmwareRequest that started this firmware update.
     * This field is mandatory, unless the message was triggered by a TriggerMessageRequest AND there is no firmware update ongoing.
     * 
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("The request id that was provided in the\r\nUpdateFirmwareRequest that started this firmware update.\r\nThis field is mandatory, unless the message was triggered by a TriggerMessageRequest AND there is no firmware update ongoing.\r\n")
    private int requestId;
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
     * This contains the progress status of the firmware installation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public FirmwareStatusEnum getStatus() {
        return status;
    }

    /**
     * This contains the progress status of the firmware installation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(FirmwareStatusEnum status) {
        this.status = status;
    }

    public FirmwareStatusNotificationRequest withStatus(FirmwareStatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * The request id that was provided in the
     * UpdateFirmwareRequest that started this firmware update.
     * This field is mandatory, unless the message was triggered by a TriggerMessageRequest AND there is no firmware update ongoing.
     * 
     * 
     */
    @JsonProperty("requestId")
    public int getRequestId() {
        return requestId;
    }

    /**
     * The request id that was provided in the
     * UpdateFirmwareRequest that started this firmware update.
     * This field is mandatory, unless the message was triggered by a TriggerMessageRequest AND there is no firmware update ongoing.
     * 
     * 
     */
    @JsonProperty("requestId")
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public FirmwareStatusNotificationRequest withRequestId(int requestId) {
        this.requestId = requestId;
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

    public FirmwareStatusNotificationRequest withStatusInfo(StatusInfo statusInfo) {
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

    public FirmwareStatusNotificationRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FirmwareStatusNotificationRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("requestId");
        sb.append('=');
        sb.append(this.requestId);
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
        result = ((result* 31)+((this.statusInfo == null)? 0 :this.statusInfo.hashCode()));
        result = ((result* 31)+ this.requestId);
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FirmwareStatusNotificationRequest) == false) {
            return false;
        }
        FirmwareStatusNotificationRequest rhs = ((FirmwareStatusNotificationRequest) other);
        return (((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.statusInfo == rhs.statusInfo)||((this.statusInfo!= null)&&this.statusInfo.equals(rhs.statusInfo))))&&(this.requestId == rhs.requestId))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
