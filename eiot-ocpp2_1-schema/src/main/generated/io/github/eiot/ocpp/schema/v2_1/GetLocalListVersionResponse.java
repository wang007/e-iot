
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "versionNumber",
    "customData"
})
public class GetLocalListVersionResponse {

    /**
     * This contains the current version number of the local authorization list in the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("versionNumber")
    @JsonPropertyDescription("This contains the current version number of the local authorization list in the Charging Station.\r\n")
    @NotNull
    private int versionNumber;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * This contains the current version number of the local authorization list in the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("versionNumber")
    public int getVersionNumber() {
        return versionNumber;
    }

    /**
     * This contains the current version number of the local authorization list in the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("versionNumber")
    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    public GetLocalListVersionResponse withVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
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

    public GetLocalListVersionResponse withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetLocalListVersionResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("versionNumber");
        sb.append('=');
        sb.append(this.versionNumber);
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
        result = ((result* 31)+ this.versionNumber);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetLocalListVersionResponse) == false) {
            return false;
        }
        GetLocalListVersionResponse rhs = ((GetLocalListVersionResponse) other);
        return ((this.versionNumber == rhs.versionNumber)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
