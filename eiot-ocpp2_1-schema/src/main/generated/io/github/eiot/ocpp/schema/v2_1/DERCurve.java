
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
    "curveData",
    "hysteresis",
    "priority",
    "reactivePowerParams",
    "voltageParams",
    "yUnit",
    "responseTime",
    "startTime",
    "duration",
    "customData"
})
public class DERCurve {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("curveData")
    @Size(min = 1, max = 10)
    @Valid
    @NotNull
    private List<DERCurvePoints> curveData = new ArrayList<DERCurvePoints>();
    @JsonProperty("hysteresis")
    @Valid
    private Hysteresis hysteresis;
    /**
     * Priority of curve (0=highest)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("Priority of curve (0=highest)\r\n\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private int priority;
    @JsonProperty("reactivePowerParams")
    @Valid
    private ReactivePowerParams reactivePowerParams;
    @JsonProperty("voltageParams")
    @Valid
    private VoltageParams voltageParams;
    /**
     * Unit of the Y-axis of DER curve
     * 
     * (Required)
     * 
     */
    @JsonProperty("yUnit")
    @JsonPropertyDescription("Unit of the Y-axis of DER curve\r\n")
    @NotNull
    private DERUnitEnum yUnit;
    /**
     * Open loop response time, the time to ramp up to 90% of the new target in response to the change in voltage, in seconds. A value of 0 is used to mean no limit. When not present, the device should follow its default behavior.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("responseTime")
    @JsonPropertyDescription("Open loop response time, the time to ramp up to 90% of the new target in response to the change in voltage, in seconds. A value of 0 is used to mean no limit. When not present, the device should follow its default behavior.\r\n\r\n\r\n")
    private double responseTime;
    /**
     * Point in time when this curve will become activated. Only absent when _default_ is true.
     * 
     * 
     * 
     */
    @JsonProperty("startTime")
    @JsonPropertyDescription("Point in time when this curve will become activated. Only absent when _default_ is true.\r\n\r\n")
    private ZonedDateTime startTime;
    /**
     * Duration in seconds that this curve will be active. Only absent when _default_ is true.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Duration in seconds that this curve will be active. Only absent when _default_ is true.\r\n\r\n\r\n")
    private double duration;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("curveData")
    public List<DERCurvePoints> getCurveData() {
        return curveData;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("curveData")
    public void setCurveData(List<DERCurvePoints> curveData) {
        this.curveData = curveData;
    }

    public DERCurve withCurveData(List<DERCurvePoints> curveData) {
        this.curveData = curveData;
        return this;
    }

    @JsonProperty("hysteresis")
    public Hysteresis getHysteresis() {
        return hysteresis;
    }

    @JsonProperty("hysteresis")
    public void setHysteresis(Hysteresis hysteresis) {
        this.hysteresis = hysteresis;
    }

    public DERCurve withHysteresis(Hysteresis hysteresis) {
        this.hysteresis = hysteresis;
        return this;
    }

    /**
     * Priority of curve (0=highest)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    public int getPriority() {
        return priority;
    }

    /**
     * Priority of curve (0=highest)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public DERCurve withPriority(int priority) {
        this.priority = priority;
        return this;
    }

    @JsonProperty("reactivePowerParams")
    public ReactivePowerParams getReactivePowerParams() {
        return reactivePowerParams;
    }

    @JsonProperty("reactivePowerParams")
    public void setReactivePowerParams(ReactivePowerParams reactivePowerParams) {
        this.reactivePowerParams = reactivePowerParams;
    }

    public DERCurve withReactivePowerParams(ReactivePowerParams reactivePowerParams) {
        this.reactivePowerParams = reactivePowerParams;
        return this;
    }

    @JsonProperty("voltageParams")
    public VoltageParams getVoltageParams() {
        return voltageParams;
    }

    @JsonProperty("voltageParams")
    public void setVoltageParams(VoltageParams voltageParams) {
        this.voltageParams = voltageParams;
    }

    public DERCurve withVoltageParams(VoltageParams voltageParams) {
        this.voltageParams = voltageParams;
        return this;
    }

    /**
     * Unit of the Y-axis of DER curve
     * 
     * (Required)
     * 
     */
    @JsonProperty("yUnit")
    public DERUnitEnum getyUnit() {
        return yUnit;
    }

    /**
     * Unit of the Y-axis of DER curve
     * 
     * (Required)
     * 
     */
    @JsonProperty("yUnit")
    public void setyUnit(DERUnitEnum yUnit) {
        this.yUnit = yUnit;
    }

    public DERCurve withyUnit(DERUnitEnum yUnit) {
        this.yUnit = yUnit;
        return this;
    }

    /**
     * Open loop response time, the time to ramp up to 90% of the new target in response to the change in voltage, in seconds. A value of 0 is used to mean no limit. When not present, the device should follow its default behavior.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("responseTime")
    public double getResponseTime() {
        return responseTime;
    }

    /**
     * Open loop response time, the time to ramp up to 90% of the new target in response to the change in voltage, in seconds. A value of 0 is used to mean no limit. When not present, the device should follow its default behavior.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("responseTime")
    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public DERCurve withResponseTime(double responseTime) {
        this.responseTime = responseTime;
        return this;
    }

    /**
     * Point in time when this curve will become activated. Only absent when _default_ is true.
     * 
     * 
     * 
     */
    @JsonProperty("startTime")
    public ZonedDateTime getStartTime() {
        return startTime;
    }

    /**
     * Point in time when this curve will become activated. Only absent when _default_ is true.
     * 
     * 
     * 
     */
    @JsonProperty("startTime")
    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public DERCurve withStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Duration in seconds that this curve will be active. Only absent when _default_ is true.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("duration")
    public double getDuration() {
        return duration;
    }

    /**
     * Duration in seconds that this curve will be active. Only absent when _default_ is true.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("duration")
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public DERCurve withDuration(double duration) {
        this.duration = duration;
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

    public DERCurve withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DERCurve.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("curveData");
        sb.append('=');
        sb.append(((this.curveData == null)?"<null>":this.curveData));
        sb.append(',');
        sb.append("hysteresis");
        sb.append('=');
        sb.append(((this.hysteresis == null)?"<null>":this.hysteresis));
        sb.append(',');
        sb.append("priority");
        sb.append('=');
        sb.append(this.priority);
        sb.append(',');
        sb.append("reactivePowerParams");
        sb.append('=');
        sb.append(((this.reactivePowerParams == null)?"<null>":this.reactivePowerParams));
        sb.append(',');
        sb.append("voltageParams");
        sb.append('=');
        sb.append(((this.voltageParams == null)?"<null>":this.voltageParams));
        sb.append(',');
        sb.append("yUnit");
        sb.append('=');
        sb.append(((this.yUnit == null)?"<null>":this.yUnit));
        sb.append(',');
        sb.append("responseTime");
        sb.append('=');
        sb.append(this.responseTime);
        sb.append(',');
        sb.append("startTime");
        sb.append('=');
        sb.append(((this.startTime == null)?"<null>":this.startTime));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.duration)^(Double.doubleToLongBits(this.duration)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.responseTime)^(Double.doubleToLongBits(this.responseTime)>>> 32))));
        result = ((result* 31)+((this.startTime == null)? 0 :this.startTime.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.curveData == null)? 0 :this.curveData.hashCode()));
        result = ((result* 31)+ this.priority);
        result = ((result* 31)+((this.yUnit == null)? 0 :this.yUnit.hashCode()));
        result = ((result* 31)+((this.reactivePowerParams == null)? 0 :this.reactivePowerParams.hashCode()));
        result = ((result* 31)+((this.voltageParams == null)? 0 :this.voltageParams.hashCode()));
        result = ((result* 31)+((this.hysteresis == null)? 0 :this.hysteresis.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DERCurve) == false) {
            return false;
        }
        DERCurve rhs = ((DERCurve) other);
        return ((((((((((Double.doubleToLongBits(this.duration) == Double.doubleToLongBits(rhs.duration))&&(Double.doubleToLongBits(this.responseTime) == Double.doubleToLongBits(rhs.responseTime)))&&((this.startTime == rhs.startTime)||((this.startTime!= null)&&this.startTime.equals(rhs.startTime))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.curveData == rhs.curveData)||((this.curveData!= null)&&this.curveData.equals(rhs.curveData))))&&(this.priority == rhs.priority))&&((this.yUnit == rhs.yUnit)||((this.yUnit!= null)&&this.yUnit.equals(rhs.yUnit))))&&((this.reactivePowerParams == rhs.reactivePowerParams)||((this.reactivePowerParams!= null)&&this.reactivePowerParams.equals(rhs.reactivePowerParams))))&&((this.voltageParams == rhs.voltageParams)||((this.voltageParams!= null)&&this.voltageParams.equals(rhs.voltageParams))))&&((this.hysteresis == rhs.hysteresis)||((this.hysteresis!= null)&&this.hysteresis.equals(rhs.hysteresis))));
    }

}
