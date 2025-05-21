
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
    "setMonitoringResult",
    "customData"
})
public class SetVariableMonitoringResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("setMonitoringResult")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<SetMonitoringResult> setMonitoringResult = new ArrayList<SetMonitoringResult>();
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
    @JsonProperty("setMonitoringResult")
    public List<SetMonitoringResult> getSetMonitoringResult() {
        return setMonitoringResult;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("setMonitoringResult")
    public void setSetMonitoringResult(List<SetMonitoringResult> setMonitoringResult) {
        this.setMonitoringResult = setMonitoringResult;
    }

    public SetVariableMonitoringResponse withSetMonitoringResult(List<SetMonitoringResult> setMonitoringResult) {
        this.setMonitoringResult = setMonitoringResult;
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

    public SetVariableMonitoringResponse withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SetVariableMonitoringResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("setMonitoringResult");
        sb.append('=');
        sb.append(((this.setMonitoringResult == null)?"<null>":this.setMonitoringResult));
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
        result = ((result* 31)+((this.setMonitoringResult == null)? 0 :this.setMonitoringResult.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SetVariableMonitoringResponse) == false) {
            return false;
        }
        SetVariableMonitoringResponse rhs = ((SetVariableMonitoringResponse) other);
        return (((this.setMonitoringResult == rhs.setMonitoringResult)||((this.setMonitoringResult!= null)&&this.setMonitoringResult.equals(rhs.setMonitoringResult)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
