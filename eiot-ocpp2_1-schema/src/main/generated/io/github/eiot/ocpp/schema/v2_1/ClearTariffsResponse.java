
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
    "clearTariffsResult",
    "customData"
})
public class ClearTariffsResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("clearTariffsResult")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<ClearTariffsResult> clearTariffsResult = new ArrayList<ClearTariffsResult>();
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
    @JsonProperty("clearTariffsResult")
    public List<ClearTariffsResult> getClearTariffsResult() {
        return clearTariffsResult;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("clearTariffsResult")
    public void setClearTariffsResult(List<ClearTariffsResult> clearTariffsResult) {
        this.clearTariffsResult = clearTariffsResult;
    }

    public ClearTariffsResponse withClearTariffsResult(List<ClearTariffsResult> clearTariffsResult) {
        this.clearTariffsResult = clearTariffsResult;
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

    public ClearTariffsResponse withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ClearTariffsResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("clearTariffsResult");
        sb.append('=');
        sb.append(((this.clearTariffsResult == null)?"<null>":this.clearTariffsResult));
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
        result = ((result* 31)+((this.clearTariffsResult == null)? 0 :this.clearTariffsResult.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ClearTariffsResponse) == false) {
            return false;
        }
        ClearTariffsResponse rhs = ((ClearTariffsResponse) other);
        return (((this.clearTariffsResult == rhs.clearTariffsResult)||((this.clearTariffsResult!= null)&&this.clearTariffsResult.equals(rhs.clearTariffsResult)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
