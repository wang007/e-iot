
package io.github.eiot.ocpp.schema.v1_6;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;


/**
 * BootNotificationResponse
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "currentTime",
    "interval"
})
public class BootNotificationResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @NotNull
    private BootNotificationResponse.Status status;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currentTime")
    @NotNull
    private OffsetDateTime currentTime;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("interval")
    @NotNull
    private int interval;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public BootNotificationResponse.Status getStatus() {
        return status;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(BootNotificationResponse.Status status) {
        this.status = status;
    }

    public BootNotificationResponse withStatus(BootNotificationResponse.Status status) {
        this.status = status;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currentTime")
    public OffsetDateTime getCurrentTime() {
        return currentTime;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currentTime")
    public void setCurrentTime(OffsetDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public BootNotificationResponse withCurrentTime(OffsetDateTime currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("interval")
    public int getInterval() {
        return interval;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("interval")
    public void setInterval(int interval) {
        this.interval = interval;
    }

    public BootNotificationResponse withInterval(int interval) {
        this.interval = interval;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BootNotificationResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("currentTime");
        sb.append('=');
        sb.append(((this.currentTime == null)?"<null>":this.currentTime));
        sb.append(',');
        sb.append("interval");
        sb.append('=');
        sb.append(this.interval);
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
        result = ((result* 31)+((this.currentTime == null)? 0 :this.currentTime.hashCode()));
        result = ((result* 31)+ this.interval);
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BootNotificationResponse) == false) {
            return false;
        }
        BootNotificationResponse rhs = ((BootNotificationResponse) other);
        return ((((this.currentTime == rhs.currentTime)||((this.currentTime!= null)&&this.currentTime.equals(rhs.currentTime)))&&(this.interval == rhs.interval))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

    public enum Status {

        ACCEPTED("Accepted"),
        PENDING("Pending"),
        REJECTED("Rejected");
        private final String value;
        private final static Map<String, BootNotificationResponse.Status> CONSTANTS = new HashMap<String, BootNotificationResponse.Status>();

        static {
            for (BootNotificationResponse.Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Status(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static BootNotificationResponse.Status fromValue(String value) {
            BootNotificationResponse.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
