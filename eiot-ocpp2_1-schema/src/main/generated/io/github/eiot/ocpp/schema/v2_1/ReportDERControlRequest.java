
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "curve",
    "enterService",
    "fixedPFAbsorb",
    "fixedPFInject",
    "fixedVar",
    "freqDroop",
    "gradient",
    "limitMaxDischarge",
    "requestId",
    "tbc",
    "customData"
})
public class ReportDERControlRequest {

    @JsonProperty("curve")
    @Size(min = 1, max = 24)
    @Valid
    private List<DERCurveGet> curve = new ArrayList<DERCurveGet>();
    @JsonProperty("enterService")
    @Size(min = 1, max = 24)
    @Valid
    private List<EnterServiceGet> enterService = new ArrayList<EnterServiceGet>();
    @JsonProperty("fixedPFAbsorb")
    @Size(min = 1, max = 24)
    @Valid
    private List<FixedPFGet> fixedPFAbsorb = new ArrayList<FixedPFGet>();
    @JsonProperty("fixedPFInject")
    @Size(min = 1, max = 24)
    @Valid
    private List<FixedPFGet> fixedPFInject = new ArrayList<FixedPFGet>();
    @JsonProperty("fixedVar")
    @Size(min = 1, max = 24)
    @Valid
    private List<FixedVarGet> fixedVar = new ArrayList<FixedVarGet>();
    @JsonProperty("freqDroop")
    @Size(min = 1, max = 24)
    @Valid
    private List<FreqDroopGet> freqDroop = new ArrayList<FreqDroopGet>();
    @JsonProperty("gradient")
    @Size(min = 1, max = 24)
    @Valid
    private List<GradientGet> gradient = new ArrayList<GradientGet>();
    @JsonProperty("limitMaxDischarge")
    @Size(min = 1, max = 24)
    @Valid
    private List<LimitMaxDischargeGet> limitMaxDischarge = new ArrayList<LimitMaxDischargeGet>();
    /**
     * RequestId from GetDERControlRequest.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("RequestId from GetDERControlRequest.\r\n")
    @NotNull
    private int requestId;
    /**
     * To Be Continued. Default value when omitted: false. +
     * False indicates that there are no further messages as part of this report.
     * 
     * 
     */
    @JsonProperty("tbc")
    @JsonPropertyDescription("To Be Continued. Default value when omitted: false. +\r\nFalse indicates that there are no further messages as part of this report.\r\n")
    private boolean tbc;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    @JsonProperty("curve")
    public List<DERCurveGet> getCurve() {
        return curve;
    }

    @JsonProperty("curve")
    public void setCurve(List<DERCurveGet> curve) {
        this.curve = curve;
    }

    public ReportDERControlRequest withCurve(List<DERCurveGet> curve) {
        this.curve = curve;
        return this;
    }

    @JsonProperty("enterService")
    public List<EnterServiceGet> getEnterService() {
        return enterService;
    }

    @JsonProperty("enterService")
    public void setEnterService(List<EnterServiceGet> enterService) {
        this.enterService = enterService;
    }

    public ReportDERControlRequest withEnterService(List<EnterServiceGet> enterService) {
        this.enterService = enterService;
        return this;
    }

    @JsonProperty("fixedPFAbsorb")
    public List<FixedPFGet> getFixedPFAbsorb() {
        return fixedPFAbsorb;
    }

    @JsonProperty("fixedPFAbsorb")
    public void setFixedPFAbsorb(List<FixedPFGet> fixedPFAbsorb) {
        this.fixedPFAbsorb = fixedPFAbsorb;
    }

    public ReportDERControlRequest withFixedPFAbsorb(List<FixedPFGet> fixedPFAbsorb) {
        this.fixedPFAbsorb = fixedPFAbsorb;
        return this;
    }

    @JsonProperty("fixedPFInject")
    public List<FixedPFGet> getFixedPFInject() {
        return fixedPFInject;
    }

    @JsonProperty("fixedPFInject")
    public void setFixedPFInject(List<FixedPFGet> fixedPFInject) {
        this.fixedPFInject = fixedPFInject;
    }

    public ReportDERControlRequest withFixedPFInject(List<FixedPFGet> fixedPFInject) {
        this.fixedPFInject = fixedPFInject;
        return this;
    }

    @JsonProperty("fixedVar")
    public List<FixedVarGet> getFixedVar() {
        return fixedVar;
    }

    @JsonProperty("fixedVar")
    public void setFixedVar(List<FixedVarGet> fixedVar) {
        this.fixedVar = fixedVar;
    }

    public ReportDERControlRequest withFixedVar(List<FixedVarGet> fixedVar) {
        this.fixedVar = fixedVar;
        return this;
    }

    @JsonProperty("freqDroop")
    public List<FreqDroopGet> getFreqDroop() {
        return freqDroop;
    }

    @JsonProperty("freqDroop")
    public void setFreqDroop(List<FreqDroopGet> freqDroop) {
        this.freqDroop = freqDroop;
    }

    public ReportDERControlRequest withFreqDroop(List<FreqDroopGet> freqDroop) {
        this.freqDroop = freqDroop;
        return this;
    }

    @JsonProperty("gradient")
    public List<GradientGet> getGradient() {
        return gradient;
    }

    @JsonProperty("gradient")
    public void setGradient(List<GradientGet> gradient) {
        this.gradient = gradient;
    }

    public ReportDERControlRequest withGradient(List<GradientGet> gradient) {
        this.gradient = gradient;
        return this;
    }

    @JsonProperty("limitMaxDischarge")
    public List<LimitMaxDischargeGet> getLimitMaxDischarge() {
        return limitMaxDischarge;
    }

    @JsonProperty("limitMaxDischarge")
    public void setLimitMaxDischarge(List<LimitMaxDischargeGet> limitMaxDischarge) {
        this.limitMaxDischarge = limitMaxDischarge;
    }

    public ReportDERControlRequest withLimitMaxDischarge(List<LimitMaxDischargeGet> limitMaxDischarge) {
        this.limitMaxDischarge = limitMaxDischarge;
        return this;
    }

    /**
     * RequestId from GetDERControlRequest.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public int getRequestId() {
        return requestId;
    }

    /**
     * RequestId from GetDERControlRequest.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public ReportDERControlRequest withRequestId(int requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * To Be Continued. Default value when omitted: false. +
     * False indicates that there are no further messages as part of this report.
     * 
     * 
     */
    @JsonProperty("tbc")
    public boolean isTbc() {
        return tbc;
    }

    /**
     * To Be Continued. Default value when omitted: false. +
     * False indicates that there are no further messages as part of this report.
     * 
     * 
     */
    @JsonProperty("tbc")
    public void setTbc(boolean tbc) {
        this.tbc = tbc;
    }

    public ReportDERControlRequest withTbc(boolean tbc) {
        this.tbc = tbc;
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

    public ReportDERControlRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ReportDERControlRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("curve");
        sb.append('=');
        sb.append(((this.curve == null)?"<null>":this.curve));
        sb.append(',');
        sb.append("enterService");
        sb.append('=');
        sb.append(((this.enterService == null)?"<null>":this.enterService));
        sb.append(',');
        sb.append("fixedPFAbsorb");
        sb.append('=');
        sb.append(((this.fixedPFAbsorb == null)?"<null>":this.fixedPFAbsorb));
        sb.append(',');
        sb.append("fixedPFInject");
        sb.append('=');
        sb.append(((this.fixedPFInject == null)?"<null>":this.fixedPFInject));
        sb.append(',');
        sb.append("fixedVar");
        sb.append('=');
        sb.append(((this.fixedVar == null)?"<null>":this.fixedVar));
        sb.append(',');
        sb.append("freqDroop");
        sb.append('=');
        sb.append(((this.freqDroop == null)?"<null>":this.freqDroop));
        sb.append(',');
        sb.append("gradient");
        sb.append('=');
        sb.append(((this.gradient == null)?"<null>":this.gradient));
        sb.append(',');
        sb.append("limitMaxDischarge");
        sb.append('=');
        sb.append(((this.limitMaxDischarge == null)?"<null>":this.limitMaxDischarge));
        sb.append(',');
        sb.append("requestId");
        sb.append('=');
        sb.append(this.requestId);
        sb.append(',');
        sb.append("tbc");
        sb.append('=');
        sb.append(this.tbc);
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
        result = ((result* 31)+((this.curve == null)? 0 :this.curve.hashCode()));
        result = ((result* 31)+((this.fixedPFAbsorb == null)? 0 :this.fixedPFAbsorb.hashCode()));
        result = ((result* 31)+((this.fixedPFInject == null)? 0 :this.fixedPFInject.hashCode()));
        result = ((result* 31)+ this.requestId);
        result = ((result* 31)+((this.gradient == null)? 0 :this.gradient.hashCode()));
        result = ((result* 31)+((this.enterService == null)? 0 :this.enterService.hashCode()));
        result = ((result* 31)+((this.limitMaxDischarge == null)? 0 :this.limitMaxDischarge.hashCode()));
        result = ((result* 31)+((this.fixedVar == null)? 0 :this.fixedVar.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.freqDroop == null)? 0 :this.freqDroop.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReportDERControlRequest) == false) {
            return false;
        }
        ReportDERControlRequest rhs = ((ReportDERControlRequest) other);
        return (((((((((((this.tbc == rhs.tbc)&&((this.curve == rhs.curve)||((this.curve!= null)&&this.curve.equals(rhs.curve))))&&((this.fixedPFAbsorb == rhs.fixedPFAbsorb)||((this.fixedPFAbsorb!= null)&&this.fixedPFAbsorb.equals(rhs.fixedPFAbsorb))))&&((this.fixedPFInject == rhs.fixedPFInject)||((this.fixedPFInject!= null)&&this.fixedPFInject.equals(rhs.fixedPFInject))))&&(this.requestId == rhs.requestId))&&((this.gradient == rhs.gradient)||((this.gradient!= null)&&this.gradient.equals(rhs.gradient))))&&((this.enterService == rhs.enterService)||((this.enterService!= null)&&this.enterService.equals(rhs.enterService))))&&((this.limitMaxDischarge == rhs.limitMaxDischarge)||((this.limitMaxDischarge!= null)&&this.limitMaxDischarge.equals(rhs.limitMaxDischarge))))&&((this.fixedVar == rhs.fixedVar)||((this.fixedVar!= null)&&this.fixedVar.equals(rhs.fixedVar))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.freqDroop == rhs.freqDroop)||((this.freqDroop!= null)&&this.freqDroop.equals(rhs.freqDroop))));
    }

}
