
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "constantStreamData",
    "customData"
})
public class GetPeriodicEventStreamResponse {

    @JsonProperty("constantStreamData")
    @Size(min = 1)
    @Valid
    private List<ConstantStreamData> constantStreamData = new ArrayList<ConstantStreamData>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    @JsonProperty("constantStreamData")
    public List<ConstantStreamData> getConstantStreamData() {
        return constantStreamData;
    }

    @JsonProperty("constantStreamData")
    public void setConstantStreamData(List<ConstantStreamData> constantStreamData) {
        this.constantStreamData = constantStreamData;
    }

    public GetPeriodicEventStreamResponse withConstantStreamData(List<ConstantStreamData> constantStreamData) {
        this.constantStreamData = constantStreamData;
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

    public GetPeriodicEventStreamResponse withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetPeriodicEventStreamResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("constantStreamData");
        sb.append('=');
        sb.append(((this.constantStreamData == null)?"<null>":this.constantStreamData));
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
        result = ((result* 31)+((this.constantStreamData == null)? 0 :this.constantStreamData.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetPeriodicEventStreamResponse) == false) {
            return false;
        }
        GetPeriodicEventStreamResponse rhs = ((GetPeriodicEventStreamResponse) other);
        return (((this.constantStreamData == rhs.constantStreamData)||((this.constantStreamData!= null)&&this.constantStreamData.equals(rhs.constantStreamData)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
