
package io.github.eiot.ocpp.schema.v1_6;

import java.net.URI;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;


/**
 * GetDiagnosticsRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "location",
    "retries",
    "retryInterval",
    "startTime",
    "stopTime"
})
public class GetDiagnosticsRequest {

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
    @JsonProperty("retryInterval")
    private int retryInterval;
    @JsonProperty("startTime")
    private OffsetDateTime startTime;
    @JsonProperty("stopTime")
    private OffsetDateTime stopTime;

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

    public GetDiagnosticsRequest withLocation(URI location) {
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

    public GetDiagnosticsRequest withRetries(int retries) {
        this.retries = retries;
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

    public GetDiagnosticsRequest withRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
        return this;
    }

    @JsonProperty("startTime")
    public OffsetDateTime getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public GetDiagnosticsRequest withStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    @JsonProperty("stopTime")
    public OffsetDateTime getStopTime() {
        return stopTime;
    }

    @JsonProperty("stopTime")
    public void setStopTime(OffsetDateTime stopTime) {
        this.stopTime = stopTime;
    }

    public GetDiagnosticsRequest withStopTime(OffsetDateTime stopTime) {
        this.stopTime = stopTime;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetDiagnosticsRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("retries");
        sb.append('=');
        sb.append(this.retries);
        sb.append(',');
        sb.append("retryInterval");
        sb.append('=');
        sb.append(this.retryInterval);
        sb.append(',');
        sb.append("startTime");
        sb.append('=');
        sb.append(((this.startTime == null)?"<null>":this.startTime));
        sb.append(',');
        sb.append("stopTime");
        sb.append('=');
        sb.append(((this.stopTime == null)?"<null>":this.stopTime));
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
        result = ((result* 31)+((this.location == null)? 0 :this.location.hashCode()));
        result = ((result* 31)+ this.retryInterval);
        result = ((result* 31)+((this.startTime == null)? 0 :this.startTime.hashCode()));
        result = ((result* 31)+((this.stopTime == null)? 0 :this.stopTime.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetDiagnosticsRequest) == false) {
            return false;
        }
        GetDiagnosticsRequest rhs = ((GetDiagnosticsRequest) other);
        return (((((this.retries == rhs.retries)&&((this.location == rhs.location)||((this.location!= null)&&this.location.equals(rhs.location))))&&(this.retryInterval == rhs.retryInterval))&&((this.startTime == rhs.startTime)||((this.startTime!= null)&&this.startTime.equals(rhs.startTime))))&&((this.stopTime == rhs.stopTime)||((this.stopTime!= null)&&this.stopTime.equals(rhs.stopTime))));
    }

}
