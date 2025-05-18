
package io.github.eiot.ocpp.schema.v2_1;

import java.time.ZonedDateTime;
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
    "monitor",
    "requestId",
    "tbc",
    "seqNo",
    "generatedAt",
    "customData"
})
public class NotifyMonitoringReportRequest {

    @JsonProperty("monitor")
    @Size(min = 1)
    @Valid
    private List<MonitoringData> monitor = new ArrayList<MonitoringData>();
    /**
     * The id of the GetMonitoringRequest that requested this report.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("The id of the GetMonitoringRequest that requested this report.\r\n\r\n")
    @NotNull
    private int requestId;
    /**
     * “to be continued” indicator. Indicates whether another part of the monitoringData follows in an upcoming notifyMonitoringReportRequest message. Default value when omitted is false.
     * 
     * 
     */
    @JsonProperty("tbc")
    @JsonPropertyDescription("\u201cto be continued\u201d indicator. Indicates whether another part of the monitoringData follows in an upcoming notifyMonitoringReportRequest message. Default value when omitted is false.\r\n")
    private boolean tbc = false;
    /**
     * Sequence number of this message. First message starts at 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("seqNo")
    @JsonPropertyDescription("Sequence number of this message. First message starts at 0.\r\n")
    @DecimalMin("0")
    @NotNull
    private int seqNo;
    /**
     * Timestamp of the moment this message was generated at the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("generatedAt")
    @JsonPropertyDescription("Timestamp of the moment this message was generated at the Charging Station.\r\n")
    @NotNull
    private ZonedDateTime generatedAt;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    @JsonProperty("monitor")
    public List<MonitoringData> getMonitor() {
        return monitor;
    }

    @JsonProperty("monitor")
    public void setMonitor(List<MonitoringData> monitor) {
        this.monitor = monitor;
    }

    public NotifyMonitoringReportRequest withMonitor(List<MonitoringData> monitor) {
        this.monitor = monitor;
        return this;
    }

    /**
     * The id of the GetMonitoringRequest that requested this report.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public int getRequestId() {
        return requestId;
    }

    /**
     * The id of the GetMonitoringRequest that requested this report.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public NotifyMonitoringReportRequest withRequestId(int requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * “to be continued” indicator. Indicates whether another part of the monitoringData follows in an upcoming notifyMonitoringReportRequest message. Default value when omitted is false.
     * 
     * 
     */
    @JsonProperty("tbc")
    public boolean isTbc() {
        return tbc;
    }

    /**
     * “to be continued” indicator. Indicates whether another part of the monitoringData follows in an upcoming notifyMonitoringReportRequest message. Default value when omitted is false.
     * 
     * 
     */
    @JsonProperty("tbc")
    public void setTbc(boolean tbc) {
        this.tbc = tbc;
    }

    public NotifyMonitoringReportRequest withTbc(boolean tbc) {
        this.tbc = tbc;
        return this;
    }

    /**
     * Sequence number of this message. First message starts at 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("seqNo")
    public int getSeqNo() {
        return seqNo;
    }

    /**
     * Sequence number of this message. First message starts at 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("seqNo")
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public NotifyMonitoringReportRequest withSeqNo(int seqNo) {
        this.seqNo = seqNo;
        return this;
    }

    /**
     * Timestamp of the moment this message was generated at the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("generatedAt")
    public ZonedDateTime getGeneratedAt() {
        return generatedAt;
    }

    /**
     * Timestamp of the moment this message was generated at the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("generatedAt")
    public void setGeneratedAt(ZonedDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public NotifyMonitoringReportRequest withGeneratedAt(ZonedDateTime generatedAt) {
        this.generatedAt = generatedAt;
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

    public NotifyMonitoringReportRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyMonitoringReportRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("monitor");
        sb.append('=');
        sb.append(((this.monitor == null)?"<null>":this.monitor));
        sb.append(',');
        sb.append("requestId");
        sb.append('=');
        sb.append(this.requestId);
        sb.append(',');
        sb.append("tbc");
        sb.append('=');
        sb.append(this.tbc);
        sb.append(',');
        sb.append("seqNo");
        sb.append('=');
        sb.append(this.seqNo);
        sb.append(',');
        sb.append("generatedAt");
        sb.append('=');
        sb.append(((this.generatedAt == null)?"<null>":this.generatedAt));
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
        result = ((result* 31)+(this.tbc? 1 : 0));
        result = ((result* 31)+ this.seqNo);
        result = ((result* 31)+ this.requestId);
        result = ((result* 31)+((this.generatedAt == null)? 0 :this.generatedAt.hashCode()));
        result = ((result* 31)+((this.monitor == null)? 0 :this.monitor.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NotifyMonitoringReportRequest) == false) {
            return false;
        }
        NotifyMonitoringReportRequest rhs = ((NotifyMonitoringReportRequest) other);
        return ((((((this.tbc == rhs.tbc)&&(this.seqNo == rhs.seqNo))&&(this.requestId == rhs.requestId))&&((this.generatedAt == rhs.generatedAt)||((this.generatedAt!= null)&&this.generatedAt.equals(rhs.generatedAt))))&&((this.monitor == rhs.monitor)||((this.monitor!= null)&&this.monitor.equals(rhs.monitor))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
