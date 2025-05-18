
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "isDefault",
    "controlId",
    "controlType",
    "curve",
    "enterService",
    "fixedPFAbsorb",
    "fixedPFInject",
    "fixedVar",
    "freqDroop",
    "gradient",
    "limitMaxDischarge",
    "customData"
})
public class SetDERControlRequest {

    /**
     * True if this is a default DER control
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("isDefault")
    @JsonPropertyDescription("True if this is a default DER control\r\n\r\n")
    @NotNull
    private boolean isDefault;
    /**
     * Unique id of this control, e.g. UUID
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlId")
    @JsonPropertyDescription("Unique id of this control, e.g. UUID\r\n\r\n")
    @Size(max = 36)
    @NotNull
    private String controlId;
    /**
     * Type of control.  Determines which setting field below is used.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlType")
    @JsonPropertyDescription("Type of control.  Determines which setting field below is used.\r\n\r\n")
    @NotNull
    private DERControlEnum controlType;
    @JsonProperty("curve")
    @Valid
    private DERCurve curve;
    @JsonProperty("enterService")
    @Valid
    private EnterService enterService;
    @JsonProperty("fixedPFAbsorb")
    @Valid
    private FixedPF fixedPFAbsorb;
    @JsonProperty("fixedPFInject")
    @Valid
    private FixedPF fixedPFInject;
    @JsonProperty("fixedVar")
    @Valid
    private FixedVar fixedVar;
    @JsonProperty("freqDroop")
    @Valid
    private FreqDroop freqDroop;
    @JsonProperty("gradient")
    @Valid
    private Gradient gradient;
    @JsonProperty("limitMaxDischarge")
    @Valid
    private LimitMaxDischarge limitMaxDischarge;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * True if this is a default DER control
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("isDefault")
    public boolean isIsDefault() {
        return isDefault;
    }

    /**
     * True if this is a default DER control
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("isDefault")
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public SetDERControlRequest withIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    /**
     * Unique id of this control, e.g. UUID
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlId")
    public String getControlId() {
        return controlId;
    }

    /**
     * Unique id of this control, e.g. UUID
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlId")
    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public SetDERControlRequest withControlId(String controlId) {
        this.controlId = controlId;
        return this;
    }

    /**
     * Type of control.  Determines which setting field below is used.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlType")
    public DERControlEnum getControlType() {
        return controlType;
    }

    /**
     * Type of control.  Determines which setting field below is used.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlType")
    public void setControlType(DERControlEnum controlType) {
        this.controlType = controlType;
    }

    public SetDERControlRequest withControlType(DERControlEnum controlType) {
        this.controlType = controlType;
        return this;
    }

    @JsonProperty("curve")
    public DERCurve getCurve() {
        return curve;
    }

    @JsonProperty("curve")
    public void setCurve(DERCurve curve) {
        this.curve = curve;
    }

    public SetDERControlRequest withCurve(DERCurve curve) {
        this.curve = curve;
        return this;
    }

    @JsonProperty("enterService")
    public EnterService getEnterService() {
        return enterService;
    }

    @JsonProperty("enterService")
    public void setEnterService(EnterService enterService) {
        this.enterService = enterService;
    }

    public SetDERControlRequest withEnterService(EnterService enterService) {
        this.enterService = enterService;
        return this;
    }

    @JsonProperty("fixedPFAbsorb")
    public FixedPF getFixedPFAbsorb() {
        return fixedPFAbsorb;
    }

    @JsonProperty("fixedPFAbsorb")
    public void setFixedPFAbsorb(FixedPF fixedPFAbsorb) {
        this.fixedPFAbsorb = fixedPFAbsorb;
    }

    public SetDERControlRequest withFixedPFAbsorb(FixedPF fixedPFAbsorb) {
        this.fixedPFAbsorb = fixedPFAbsorb;
        return this;
    }

    @JsonProperty("fixedPFInject")
    public FixedPF getFixedPFInject() {
        return fixedPFInject;
    }

    @JsonProperty("fixedPFInject")
    public void setFixedPFInject(FixedPF fixedPFInject) {
        this.fixedPFInject = fixedPFInject;
    }

    public SetDERControlRequest withFixedPFInject(FixedPF fixedPFInject) {
        this.fixedPFInject = fixedPFInject;
        return this;
    }

    @JsonProperty("fixedVar")
    public FixedVar getFixedVar() {
        return fixedVar;
    }

    @JsonProperty("fixedVar")
    public void setFixedVar(FixedVar fixedVar) {
        this.fixedVar = fixedVar;
    }

    public SetDERControlRequest withFixedVar(FixedVar fixedVar) {
        this.fixedVar = fixedVar;
        return this;
    }

    @JsonProperty("freqDroop")
    public FreqDroop getFreqDroop() {
        return freqDroop;
    }

    @JsonProperty("freqDroop")
    public void setFreqDroop(FreqDroop freqDroop) {
        this.freqDroop = freqDroop;
    }

    public SetDERControlRequest withFreqDroop(FreqDroop freqDroop) {
        this.freqDroop = freqDroop;
        return this;
    }

    @JsonProperty("gradient")
    public Gradient getGradient() {
        return gradient;
    }

    @JsonProperty("gradient")
    public void setGradient(Gradient gradient) {
        this.gradient = gradient;
    }

    public SetDERControlRequest withGradient(Gradient gradient) {
        this.gradient = gradient;
        return this;
    }

    @JsonProperty("limitMaxDischarge")
    public LimitMaxDischarge getLimitMaxDischarge() {
        return limitMaxDischarge;
    }

    @JsonProperty("limitMaxDischarge")
    public void setLimitMaxDischarge(LimitMaxDischarge limitMaxDischarge) {
        this.limitMaxDischarge = limitMaxDischarge;
    }

    public SetDERControlRequest withLimitMaxDischarge(LimitMaxDischarge limitMaxDischarge) {
        this.limitMaxDischarge = limitMaxDischarge;
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

    public SetDERControlRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SetDERControlRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("isDefault");
        sb.append('=');
        sb.append(this.isDefault);
        sb.append(',');
        sb.append("controlId");
        sb.append('=');
        sb.append(((this.controlId == null)?"<null>":this.controlId));
        sb.append(',');
        sb.append("controlType");
        sb.append('=');
        sb.append(((this.controlType == null)?"<null>":this.controlType));
        sb.append(',');
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
        result = ((result* 31)+((this.curve == null)? 0 :this.curve.hashCode()));
        result = ((result* 31)+((this.fixedPFAbsorb == null)? 0 :this.fixedPFAbsorb.hashCode()));
        result = ((result* 31)+((this.fixedPFInject == null)? 0 :this.fixedPFInject.hashCode()));
        result = ((result* 31)+((this.gradient == null)? 0 :this.gradient.hashCode()));
        result = ((result* 31)+((this.limitMaxDischarge == null)? 0 :this.limitMaxDischarge.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.controlId == null)? 0 :this.controlId.hashCode()));
        result = ((result* 31)+((this.freqDroop == null)? 0 :this.freqDroop.hashCode()));
        result = ((result* 31)+(this.isDefault? 1 : 0));
        result = ((result* 31)+((this.controlType == null)? 0 :this.controlType.hashCode()));
        result = ((result* 31)+((this.enterService == null)? 0 :this.enterService.hashCode()));
        result = ((result* 31)+((this.fixedVar == null)? 0 :this.fixedVar.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SetDERControlRequest) == false) {
            return false;
        }
        SetDERControlRequest rhs = ((SetDERControlRequest) other);
        return (((((((((((((this.curve == rhs.curve)||((this.curve!= null)&&this.curve.equals(rhs.curve)))&&((this.fixedPFAbsorb == rhs.fixedPFAbsorb)||((this.fixedPFAbsorb!= null)&&this.fixedPFAbsorb.equals(rhs.fixedPFAbsorb))))&&((this.fixedPFInject == rhs.fixedPFInject)||((this.fixedPFInject!= null)&&this.fixedPFInject.equals(rhs.fixedPFInject))))&&((this.gradient == rhs.gradient)||((this.gradient!= null)&&this.gradient.equals(rhs.gradient))))&&((this.limitMaxDischarge == rhs.limitMaxDischarge)||((this.limitMaxDischarge!= null)&&this.limitMaxDischarge.equals(rhs.limitMaxDischarge))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.controlId == rhs.controlId)||((this.controlId!= null)&&this.controlId.equals(rhs.controlId))))&&((this.freqDroop == rhs.freqDroop)||((this.freqDroop!= null)&&this.freqDroop.equals(rhs.freqDroop))))&&(this.isDefault == rhs.isDefault))&&((this.controlType == rhs.controlType)||((this.controlType!= null)&&this.controlType.equals(rhs.controlType))))&&((this.enterService == rhs.enterService)||((this.enterService!= null)&&this.enterService.equals(rhs.enterService))))&&((this.fixedVar == rhs.fixedVar)||((this.fixedVar!= null)&&this.fixedVar.equals(rhs.fixedVar))));
    }

}
