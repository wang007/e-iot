
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "retries",
    "retryInterval",
    "requestId",
    "firmware",
    "customData"
})
public class UpdateFirmwareRequest {

    /**
     * This specifies how many times Charging Station must retry to download the firmware before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry.
     * If the value is 0, it means: no retries.
     * 
     * 
     */
    @JsonProperty("retries")
    @JsonPropertyDescription("This specifies how many times Charging Station must retry to download the firmware before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry.\r\nIf the value is 0, it means: no retries.\r\n")
    @DecimalMin("0")
    private int retries;
    /**
     * The interval in seconds after which a retry may be attempted. If this field is not present, it is left to Charging Station to decide how long to wait between attempts.
     * 
     * 
     */
    @JsonProperty("retryInterval")
    @JsonPropertyDescription("The interval in seconds after which a retry may be attempted. If this field is not present, it is left to Charging Station to decide how long to wait between attempts.\r\n")
    private int retryInterval;
    /**
     * The Id of this request
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("The Id of this request\r\n")
    @NotNull
    private int requestId;
    /**
     * Represents a copy of the firmware that can be loaded/updated on the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("firmware")
    @JsonPropertyDescription("Represents a copy of the firmware that can be loaded/updated on the Charging Station.\r\n")
    @Valid
    @NotNull
    private Firmware firmware;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * This specifies how many times Charging Station must retry to download the firmware before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry.
     * If the value is 0, it means: no retries.
     * 
     * 
     */
    @JsonProperty("retries")
    public int getRetries() {
        return retries;
    }

    /**
     * This specifies how many times Charging Station must retry to download the firmware before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry.
     * If the value is 0, it means: no retries.
     * 
     * 
     */
    @JsonProperty("retries")
    public void setRetries(int retries) {
        this.retries = retries;
    }

    public UpdateFirmwareRequest withRetries(int retries) {
        this.retries = retries;
        return this;
    }

    /**
     * The interval in seconds after which a retry may be attempted. If this field is not present, it is left to Charging Station to decide how long to wait between attempts.
     * 
     * 
     */
    @JsonProperty("retryInterval")
    public int getRetryInterval() {
        return retryInterval;
    }

    /**
     * The interval in seconds after which a retry may be attempted. If this field is not present, it is left to Charging Station to decide how long to wait between attempts.
     * 
     * 
     */
    @JsonProperty("retryInterval")
    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public UpdateFirmwareRequest withRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
        return this;
    }

    /**
     * The Id of this request
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public int getRequestId() {
        return requestId;
    }

    /**
     * The Id of this request
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public UpdateFirmwareRequest withRequestId(int requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Represents a copy of the firmware that can be loaded/updated on the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("firmware")
    public Firmware getFirmware() {
        return firmware;
    }

    /**
     * Represents a copy of the firmware that can be loaded/updated on the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("firmware")
    public void setFirmware(Firmware firmware) {
        this.firmware = firmware;
    }

    public UpdateFirmwareRequest withFirmware(Firmware firmware) {
        this.firmware = firmware;
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

    public UpdateFirmwareRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UpdateFirmwareRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("retries");
        sb.append('=');
        sb.append(this.retries);
        sb.append(',');
        sb.append("retryInterval");
        sb.append('=');
        sb.append(this.retryInterval);
        sb.append(',');
        sb.append("requestId");
        sb.append('=');
        sb.append(this.requestId);
        sb.append(',');
        sb.append("firmware");
        sb.append('=');
        sb.append(((this.firmware == null)?"<null>":this.firmware));
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
        result = ((result* 31)+ this.retries);
        result = ((result* 31)+ this.retryInterval);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.firmware == null)? 0 :this.firmware.hashCode()));
        result = ((result* 31)+ this.requestId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateFirmwareRequest) == false) {
            return false;
        }
        UpdateFirmwareRequest rhs = ((UpdateFirmwareRequest) other);
        return (((((this.retries == rhs.retries)&&(this.retryInterval == rhs.retryInterval))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.firmware == rhs.firmware)||((this.firmware!= null)&&this.firmware.equals(rhs.firmware))))&&(this.requestId == rhs.requestId));
    }

}
