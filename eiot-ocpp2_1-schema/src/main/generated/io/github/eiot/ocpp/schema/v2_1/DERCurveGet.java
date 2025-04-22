
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
    "curve",
    "id",
    "curveType",
    "isDefault",
    "isSuperseded",
    "customData"
})
public class DERCurveGet {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("curve")
    @Valid
    @NotNull
    private DERCurve curve;
    /**
     * Id of DER curve
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Id of DER curve\r\n\r\n")
    @Size(max = 36)
    @NotNull
    private String id;
    /**
     * Type of DER curve
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("curveType")
    @JsonPropertyDescription("Type of DER curve\r\n\r\n")
    @NotNull
    private DERControlEnum curveType;
    /**
     * True if this is a default curve
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("isDefault")
    @JsonPropertyDescription("True if this is a default curve\r\n\r\n")
    @NotNull
    private boolean isDefault;
    /**
     * True if this setting is superseded by a higher priority setting (i.e. lower value of _priority_)
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("isSuperseded")
    @JsonPropertyDescription("True if this setting is superseded by a higher priority setting (i.e. lower value of _priority_)\r\n\r\n")
    @NotNull
    private boolean isSuperseded;
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
    @JsonProperty("curve")
    public DERCurve getCurve() {
        return curve;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("curve")
    public void setCurve(DERCurve curve) {
        this.curve = curve;
    }

    public DERCurveGet withCurve(DERCurve curve) {
        this.curve = curve;
        return this;
    }

    /**
     * Id of DER curve
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Id of DER curve
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public DERCurveGet withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Type of DER curve
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("curveType")
    public DERControlEnum getCurveType() {
        return curveType;
    }

    /**
     * Type of DER curve
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("curveType")
    public void setCurveType(DERControlEnum curveType) {
        this.curveType = curveType;
    }

    public DERCurveGet withCurveType(DERControlEnum curveType) {
        this.curveType = curveType;
        return this;
    }

    /**
     * True if this is a default curve
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
     * True if this is a default curve
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("isDefault")
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public DERCurveGet withIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    /**
     * True if this setting is superseded by a higher priority setting (i.e. lower value of _priority_)
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("isSuperseded")
    public boolean isIsSuperseded() {
        return isSuperseded;
    }

    /**
     * True if this setting is superseded by a higher priority setting (i.e. lower value of _priority_)
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("isSuperseded")
    public void setIsSuperseded(boolean isSuperseded) {
        this.isSuperseded = isSuperseded;
    }

    public DERCurveGet withIsSuperseded(boolean isSuperseded) {
        this.isSuperseded = isSuperseded;
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

    public DERCurveGet withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DERCurveGet.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("curve");
        sb.append('=');
        sb.append(((this.curve == null)?"<null>":this.curve));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("curveType");
        sb.append('=');
        sb.append(((this.curveType == null)?"<null>":this.curveType));
        sb.append(',');
        sb.append("isDefault");
        sb.append('=');
        sb.append(this.isDefault);
        sb.append(',');
        sb.append("isSuperseded");
        sb.append('=');
        sb.append(this.isSuperseded);
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
        result = ((result* 31)+((this.curveType == null)? 0 :this.curveType.hashCode()));
        result = ((result* 31)+(this.isDefault? 1 : 0));
        result = ((result* 31)+(this.isSuperseded? 1 : 0));
        result = ((result* 31)+((this.curve == null)? 0 :this.curve.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DERCurveGet) == false) {
            return false;
        }
        DERCurveGet rhs = ((DERCurveGet) other);
        return (((((((this.curveType == rhs.curveType)||((this.curveType!= null)&&this.curveType.equals(rhs.curveType)))&&(this.isDefault == rhs.isDefault))&&(this.isSuperseded == rhs.isSuperseded))&&((this.curve == rhs.curve)||((this.curve!= null)&&this.curve.equals(rhs.curve))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))));
    }

}
