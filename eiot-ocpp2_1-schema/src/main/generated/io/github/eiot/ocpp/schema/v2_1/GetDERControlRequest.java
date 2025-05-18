
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
    "requestId",
    "isDefault",
    "controlType",
    "controlId",
    "customData"
})
public class GetDERControlRequest {

    /**
     * RequestId to be used in ReportDERControlRequest.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("RequestId to be used in ReportDERControlRequest.\r\n")
    @NotNull
    private int requestId;
    /**
     * True: get a default DER control. False: get a scheduled control.
     * 
     * 
     * 
     */
    @JsonProperty("isDefault")
    @JsonPropertyDescription("True: get a default DER control. False: get a scheduled control.\r\n\r\n")
    private boolean isDefault;
    /**
     * Type of control settings to retrieve. Not used when _controlId_ is provided.
     * 
     * 
     * 
     */
    @JsonProperty("controlType")
    @JsonPropertyDescription("Type of control settings to retrieve. Not used when _controlId_ is provided.\r\n\r\n")
    private DERControlEnum controlType;
    /**
     * Id of setting to get. When omitted all settings for _controlType_ are retrieved.
     * 
     * 
     * 
     */
    @JsonProperty("controlId")
    @JsonPropertyDescription("Id of setting to get. When omitted all settings for _controlType_ are retrieved.\r\n\r\n")
    @Size(max = 36)
    private String controlId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * RequestId to be used in ReportDERControlRequest.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public int getRequestId() {
        return requestId;
    }

    /**
     * RequestId to be used in ReportDERControlRequest.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public GetDERControlRequest withRequestId(int requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * True: get a default DER control. False: get a scheduled control.
     * 
     * 
     * 
     */
    @JsonProperty("isDefault")
    public boolean isIsDefault() {
        return isDefault;
    }

    /**
     * True: get a default DER control. False: get a scheduled control.
     * 
     * 
     * 
     */
    @JsonProperty("isDefault")
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public GetDERControlRequest withIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    /**
     * Type of control settings to retrieve. Not used when _controlId_ is provided.
     * 
     * 
     * 
     */
    @JsonProperty("controlType")
    public DERControlEnum getControlType() {
        return controlType;
    }

    /**
     * Type of control settings to retrieve. Not used when _controlId_ is provided.
     * 
     * 
     * 
     */
    @JsonProperty("controlType")
    public void setControlType(DERControlEnum controlType) {
        this.controlType = controlType;
    }

    public GetDERControlRequest withControlType(DERControlEnum controlType) {
        this.controlType = controlType;
        return this;
    }

    /**
     * Id of setting to get. When omitted all settings for _controlType_ are retrieved.
     * 
     * 
     * 
     */
    @JsonProperty("controlId")
    public String getControlId() {
        return controlId;
    }

    /**
     * Id of setting to get. When omitted all settings for _controlType_ are retrieved.
     * 
     * 
     * 
     */
    @JsonProperty("controlId")
    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public GetDERControlRequest withControlId(String controlId) {
        this.controlId = controlId;
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

    public GetDERControlRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetDERControlRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("requestId");
        sb.append('=');
        sb.append(this.requestId);
        sb.append(',');
        sb.append("isDefault");
        sb.append('=');
        sb.append(this.isDefault);
        sb.append(',');
        sb.append("controlType");
        sb.append('=');
        sb.append(((this.controlType == null)?"<null>":this.controlType));
        sb.append(',');
        sb.append("controlId");
        sb.append('=');
        sb.append(((this.controlId == null)?"<null>":this.controlId));
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
        result = ((result* 31)+(this.isDefault? 1 : 0));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.controlId == null)? 0 :this.controlId.hashCode()));
        result = ((result* 31)+((this.controlType == null)? 0 :this.controlType.hashCode()));
        result = ((result* 31)+ this.requestId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetDERControlRequest) == false) {
            return false;
        }
        GetDERControlRequest rhs = ((GetDERControlRequest) other);
        return (((((this.isDefault == rhs.isDefault)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.controlId == rhs.controlId)||((this.controlId!= null)&&this.controlId.equals(rhs.controlId))))&&((this.controlType == rhs.controlType)||((this.controlType!= null)&&this.controlType.equals(rhs.controlType))))&&(this.requestId == rhs.requestId));
    }

}
