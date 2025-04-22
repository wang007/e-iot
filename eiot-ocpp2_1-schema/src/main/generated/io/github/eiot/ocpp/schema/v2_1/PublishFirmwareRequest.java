
package io.github.eiot.ocpp.schema.v2_1;

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
    "location",
    "retries",
    "checksum",
    "requestId",
    "retryInterval",
    "customData"
})
public class PublishFirmwareRequest {

    /**
     * This contains a string containing a URI pointing to a
     * location from which to retrieve the firmware.
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    @JsonPropertyDescription("This contains a string containing a URI pointing to a\r\nlocation from which to retrieve the firmware.\r\n")
    @Size(max = 2000)
    @NotNull
    private String location;
    /**
     * This specifies how many times Charging Station must retry
     * to download the firmware before giving up. If this field is not
     * present, it is left to Charging Station to decide how many times it wants to retry.
     * If the value is 0, it means: no retries.
     * 
     * 
     */
    @JsonProperty("retries")
    @JsonPropertyDescription("This specifies how many times Charging Station must retry\r\nto download the firmware before giving up. If this field is not\r\npresent, it is left to Charging Station to decide how many times it wants to retry.\r\nIf the value is 0, it means: no retries.\r\n")
    @DecimalMin("0")
    private int retries;
    /**
     * The MD5 checksum over the entire firmware file as a hexadecimal string of length 32. 
     * 
     * (Required)
     * 
     */
    @JsonProperty("checksum")
    @JsonPropertyDescription("The MD5 checksum over the entire firmware file as a hexadecimal string of length 32. \r\n")
    @Size(max = 32)
    @NotNull
    private String checksum;
    /**
     * The Id of the request.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("The Id of the request.\r\n")
    @DecimalMin("0")
    @NotNull
    private int requestId;
    /**
     * The interval in seconds
     * after which a retry may be
     * attempted. If this field is not
     * present, it is left to Charging
     * Station to decide how long to wait
     * between attempts.
     * 
     * 
     */
    @JsonProperty("retryInterval")
    @JsonPropertyDescription("The interval in seconds\r\nafter which a retry may be\r\nattempted. If this field is not\r\npresent, it is left to Charging\r\nStation to decide how long to wait\r\nbetween attempts.\r\n")
    @DecimalMin("0")
    private int retryInterval;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * This contains a string containing a URI pointing to a
     * location from which to retrieve the firmware.
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * This contains a string containing a URI pointing to a
     * location from which to retrieve the firmware.
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    public PublishFirmwareRequest withLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * This specifies how many times Charging Station must retry
     * to download the firmware before giving up. If this field is not
     * present, it is left to Charging Station to decide how many times it wants to retry.
     * If the value is 0, it means: no retries.
     * 
     * 
     */
    @JsonProperty("retries")
    public int getRetries() {
        return retries;
    }

    /**
     * This specifies how many times Charging Station must retry
     * to download the firmware before giving up. If this field is not
     * present, it is left to Charging Station to decide how many times it wants to retry.
     * If the value is 0, it means: no retries.
     * 
     * 
     */
    @JsonProperty("retries")
    public void setRetries(int retries) {
        this.retries = retries;
    }

    public PublishFirmwareRequest withRetries(int retries) {
        this.retries = retries;
        return this;
    }

    /**
     * The MD5 checksum over the entire firmware file as a hexadecimal string of length 32. 
     * 
     * (Required)
     * 
     */
    @JsonProperty("checksum")
    public String getChecksum() {
        return checksum;
    }

    /**
     * The MD5 checksum over the entire firmware file as a hexadecimal string of length 32. 
     * 
     * (Required)
     * 
     */
    @JsonProperty("checksum")
    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public PublishFirmwareRequest withChecksum(String checksum) {
        this.checksum = checksum;
        return this;
    }

    /**
     * The Id of the request.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public int getRequestId() {
        return requestId;
    }

    /**
     * The Id of the request.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public PublishFirmwareRequest withRequestId(int requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * The interval in seconds
     * after which a retry may be
     * attempted. If this field is not
     * present, it is left to Charging
     * Station to decide how long to wait
     * between attempts.
     * 
     * 
     */
    @JsonProperty("retryInterval")
    public int getRetryInterval() {
        return retryInterval;
    }

    /**
     * The interval in seconds
     * after which a retry may be
     * attempted. If this field is not
     * present, it is left to Charging
     * Station to decide how long to wait
     * between attempts.
     * 
     * 
     */
    @JsonProperty("retryInterval")
    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public PublishFirmwareRequest withRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
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

    public PublishFirmwareRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PublishFirmwareRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("retries");
        sb.append('=');
        sb.append(this.retries);
        sb.append(',');
        sb.append("checksum");
        sb.append('=');
        sb.append(((this.checksum == null)?"<null>":this.checksum));
        sb.append(',');
        sb.append("requestId");
        sb.append('=');
        sb.append(this.requestId);
        sb.append(',');
        sb.append("retryInterval");
        sb.append('=');
        sb.append(this.retryInterval);
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
        result = ((result* 31)+ this.requestId);
        result = ((result* 31)+((this.checksum == null)? 0 :this.checksum.hashCode()));
        result = ((result* 31)+((this.location == null)? 0 :this.location.hashCode()));
        result = ((result* 31)+ this.retryInterval);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PublishFirmwareRequest) == false) {
            return false;
        }
        PublishFirmwareRequest rhs = ((PublishFirmwareRequest) other);
        return ((((((this.retries == rhs.retries)&&(this.requestId == rhs.requestId))&&((this.checksum == rhs.checksum)||((this.checksum!= null)&&this.checksum.equals(rhs.checksum))))&&((this.location == rhs.location)||((this.location!= null)&&this.location.equals(rhs.location))))&&(this.retryInterval == rhs.retryInterval))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
