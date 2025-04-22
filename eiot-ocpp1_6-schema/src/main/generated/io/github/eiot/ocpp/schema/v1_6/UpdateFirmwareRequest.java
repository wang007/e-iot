
package io.github.eiot.ocpp.schema.v1_6;

import java.net.URI;
import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;


/**
 * UpdateFirmwareRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "location",
    "retries",
    "retrieveDate",
    "retryInterval"
})
public class UpdateFirmwareRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    @NotNull
    private URI location;
    @JsonProperty("retries")
    private int retries;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("retrieveDate")
    @NotNull
    private ZonedDateTime retrieveDate;
    @JsonProperty("retryInterval")
    private int retryInterval;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    public URI getLocation() {
        return location;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    public void setLocation(URI location) {
        this.location = location;
    }

    public UpdateFirmwareRequest withLocation(URI location) {
        this.location = location;
        return this;
    }

    @JsonProperty("retries")
    public int getRetries() {
        return retries;
    }

    @JsonProperty("retries")
    public void setRetries(int retries) {
        this.retries = retries;
    }

    public UpdateFirmwareRequest withRetries(int retries) {
        this.retries = retries;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("retrieveDate")
    public ZonedDateTime getRetrieveDate() {
        return retrieveDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("retrieveDate")
    public void setRetrieveDate(ZonedDateTime retrieveDate) {
        this.retrieveDate = retrieveDate;
    }

    public UpdateFirmwareRequest withRetrieveDate(ZonedDateTime retrieveDate) {
        this.retrieveDate = retrieveDate;
        return this;
    }

    @JsonProperty("retryInterval")
    public int getRetryInterval() {
        return retryInterval;
    }

    @JsonProperty("retryInterval")
    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public UpdateFirmwareRequest withRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UpdateFirmwareRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("retries");
        sb.append('=');
        sb.append(this.retries);
        sb.append(',');
        sb.append("retrieveDate");
        sb.append('=');
        sb.append(((this.retrieveDate == null)?"<null>":this.retrieveDate));
        sb.append(',');
        sb.append("retryInterval");
        sb.append('=');
        sb.append(this.retryInterval);
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
        result = ((result* 31)+((this.retrieveDate == null)? 0 :this.retrieveDate.hashCode()));
        result = ((result* 31)+((this.location == null)? 0 :this.location.hashCode()));
        result = ((result* 31)+ this.retryInterval);
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
        return ((((this.retries == rhs.retries)&&((this.retrieveDate == rhs.retrieveDate)||((this.retrieveDate!= null)&&this.retrieveDate.equals(rhs.retrieveDate))))&&((this.location == rhs.location)||((this.location!= null)&&this.location.equals(rhs.location))))&&(this.retryInterval == rhs.retryInterval));
    }

}
