
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "location",
    "requestId",
    "statusInfo",
    "customData"
})
public class PublishFirmwareStatusNotificationRequest {

    /**
     * This contains the progress status of the publishfirmware
     * installation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("This contains the progress status of the publishfirmware\r\ninstallation.\r\n")
    @NotNull
    private PublishFirmwareStatusEnum status;
    /**
     * Required if status is Published. Can be multiple URI’s, if the Local Controller supports e.g. HTTP, HTTPS, and FTP.
     * 
     * 
     */
    @JsonProperty("location")
    @JsonPropertyDescription("Required if status is Published. Can be multiple URI\u2019s, if the Local Controller supports e.g. HTTP, HTTPS, and FTP.\r\n")
    @Size(min = 1)
    @Valid
    private List<String> location = new ArrayList<String>();
    /**
     * The request id that was
     * provided in the
     * PublishFirmwareRequest which
     * triggered this action.
     * 
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("The request id that was\r\nprovided in the\r\nPublishFirmwareRequest which\r\ntriggered this action.\r\n")
    @DecimalMin("0")
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
     * This contains the progress status of the publishfirmware
     * installation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public PublishFirmwareStatusEnum getStatus() {
        return status;
    }

    /**
     * This contains the progress status of the publishfirmware
     * installation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(PublishFirmwareStatusEnum status) {
        this.status = status;
    }

    public PublishFirmwareStatusNotificationRequest withStatus(PublishFirmwareStatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Required if status is Published. Can be multiple URI’s, if the Local Controller supports e.g. HTTP, HTTPS, and FTP.
     * 
     * 
     */
    @JsonProperty("location")
    public List<String> getLocation() {
        return location;
    }

    /**
     * Required if status is Published. Can be multiple URI’s, if the Local Controller supports e.g. HTTP, HTTPS, and FTP.
     * 
     * 
     */
    @JsonProperty("location")
    public void setLocation(List<String> location) {
        this.location = location;
    }

    public PublishFirmwareStatusNotificationRequest withLocation(List<String> location) {
        this.location = location;
        return this;
    }

    /**
     * The request id that was
     * provided in the
     * PublishFirmwareRequest which
     * triggered this action.
     * 
     * 
     */
    @JsonProperty("requestId")
    public int getRequestId() {
        return requestId;
    }

    /**
     * The request id that was
     * provided in the
     * PublishFirmwareRequest which
     * triggered this action.
     * 
     * 
     */
    @JsonProperty("requestId")
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public PublishFirmwareStatusNotificationRequest withRequestId(int requestId) {
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

    public PublishFirmwareStatusNotificationRequest withStatusInfo(StatusInfo statusInfo) {
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

    public PublishFirmwareStatusNotificationRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PublishFirmwareStatusNotificationRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
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
        result = ((result* 31)+((this.location == null)? 0 :this.location.hashCode()));
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
        if ((other instanceof PublishFirmwareStatusNotificationRequest) == false) {
            return false;
        }
        PublishFirmwareStatusNotificationRequest rhs = ((PublishFirmwareStatusNotificationRequest) other);
        return ((((((this.location == rhs.location)||((this.location!= null)&&this.location.equals(rhs.location)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.statusInfo == rhs.statusInfo)||((this.statusInfo!= null)&&this.statusInfo.equals(rhs.statusInfo))))&&(this.requestId == rhs.requestId))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
