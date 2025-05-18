
package io.github.eiot.ocpp.schema.v1_6;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;


/**
 * FirmwareStatusNotificationRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status"
})
public class FirmwareStatusNotificationRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @NotNull
    private FirmwareStatusNotificationRequest.Status status;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public FirmwareStatusNotificationRequest.Status getStatus() {
        return status;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(FirmwareStatusNotificationRequest.Status status) {
        this.status = status;
    }

    public FirmwareStatusNotificationRequest withStatus(FirmwareStatusNotificationRequest.Status status) {
        this.status = status;
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
        return ((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status)));
    }

    public enum Status {

        DOWNLOADED("Downloaded"),
        DOWNLOAD_FAILED("DownloadFailed"),
        DOWNLOADING("Downloading"),
        IDLE("Idle"),
        INSTALLATION_FAILED("InstallationFailed"),
        INSTALLING("Installing"),
        INSTALLED("Installed");
        private final String value;
        private final static Map<String, FirmwareStatusNotificationRequest.Status> CONSTANTS = new HashMap<String, FirmwareStatusNotificationRequest.Status>();

        static {
            for (FirmwareStatusNotificationRequest.Status c: values()) {
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
        public static FirmwareStatusNotificationRequest.Status fromValue(String value) {
            FirmwareStatusNotificationRequest.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
