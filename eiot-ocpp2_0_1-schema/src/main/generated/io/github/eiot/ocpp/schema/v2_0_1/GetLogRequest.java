
package io.github.eiot.ocpp.schema.v2_0_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customData",
    "log",
    "logType",
    "requestId",
    "retries",
    "retryInterval"
})
public class GetLogRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Log
     * urn:x-enexis:ecdm:uid:2:233373
     * Generic class for the configuration of logging entries.
     * 
     * (Required)
     * 
     */
    @JsonProperty("log")
    @JsonPropertyDescription("Log\r\nurn:x-enexis:ecdm:uid:2:233373\r\nGeneric class for the configuration of logging entries.\r\n")
    @Valid
    @NotNull
    private LogParameters log;
    /**
     * This contains the type of log file that the Charging Station
     * should send.
     * 
     * (Required)
     * 
     */
    @JsonProperty("logType")
    @JsonPropertyDescription("This contains the type of log file that the Charging Station\r\nshould send.\r\n")
    @NotNull
    private LogEnum logType;
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
     * This specifies how many times the Charging Station must try to upload the log before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry.
     * 
     * 
     */
    @JsonProperty("retries")
    @JsonPropertyDescription("This specifies how many times the Charging Station must try to upload the log before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry.\r\n")
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

    public GetLogRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    /**
     * Log
     * urn:x-enexis:ecdm:uid:2:233373
     * Generic class for the configuration of logging entries.
     * 
     * (Required)
     * 
     */
    @JsonProperty("log")
    public LogParameters getLog() {
        return log;
    }

    /**
     * Log
     * urn:x-enexis:ecdm:uid:2:233373
     * Generic class for the configuration of logging entries.
     * 
     * (Required)
     * 
     */
    @JsonProperty("log")
    public void setLog(LogParameters log) {
        this.log = log;
    }

    public GetLogRequest withLog(LogParameters log) {
        this.log = log;
        return this;
    }

    /**
     * This contains the type of log file that the Charging Station
     * should send.
     * 
     * (Required)
     * 
     */
    @JsonProperty("logType")
    public LogEnum getLogType() {
        return logType;
    }

    /**
     * This contains the type of log file that the Charging Station
     * should send.
     * 
     * (Required)
     * 
     */
    @JsonProperty("logType")
    public void setLogType(LogEnum logType) {
        this.logType = logType;
    }

    public GetLogRequest withLogType(LogEnum logType) {
        this.logType = logType;
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

    public GetLogRequest withRequestId(int requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * This specifies how many times the Charging Station must try to upload the log before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry.
     * 
     * 
     */
    @JsonProperty("retries")
    public int getRetries() {
        return retries;
    }

    /**
     * This specifies how many times the Charging Station must try to upload the log before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry.
     * 
     * 
     */
    @JsonProperty("retries")
    public void setRetries(int retries) {
        this.retries = retries;
    }

    public GetLogRequest withRetries(int retries) {
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

    public GetLogRequest withRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetLogRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customData");
        sb.append('=');
        sb.append(((this.customData == null)?"<null>":this.customData));
        sb.append(',');
        sb.append("log");
        sb.append('=');
        sb.append(((this.log == null)?"<null>":this.log));
        sb.append(',');
        sb.append("logType");
        sb.append('=');
        sb.append(((this.logType == null)?"<null>":this.logType));
        sb.append(',');
        sb.append("requestId");
        sb.append('=');
        sb.append(this.requestId);
        sb.append(',');
        sb.append("retries");
        sb.append('=');
        sb.append(this.retries);
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
        result = ((result* 31)+((this.logType == null)? 0 :this.logType.hashCode()));
        result = ((result* 31)+ this.retries);
        result = ((result* 31)+((this.log == null)? 0 :this.log.hashCode()));
        result = ((result* 31)+ this.requestId);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.retryInterval);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetLogRequest) == false) {
            return false;
        }
        GetLogRequest rhs = ((GetLogRequest) other);
        return (((((((this.logType == rhs.logType)||((this.logType!= null)&&this.logType.equals(rhs.logType)))&&(this.retries == rhs.retries))&&((this.log == rhs.log)||((this.log!= null)&&this.log.equals(rhs.log))))&&(this.requestId == rhs.requestId))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.retryInterval == rhs.retryInterval));
    }

}
