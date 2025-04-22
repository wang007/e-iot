
package io.github.eiot.ocpp.schema.v1_6;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;


/**
 * GetConfigurationResponse
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configurationKey",
    "unknownKey"
})
public class GetConfigurationResponse {

    @JsonProperty("configurationKey")
    @Valid
    private List<ConfigurationKey> configurationKey = new ArrayList<ConfigurationKey>();
    @JsonProperty("unknownKey")
    @Valid
    private List<String> unknownKey = new ArrayList<String>();

    @JsonProperty("configurationKey")
    public List<ConfigurationKey> getConfigurationKey() {
        return configurationKey;
    }

    @JsonProperty("configurationKey")
    public void setConfigurationKey(List<ConfigurationKey> configurationKey) {
        this.configurationKey = configurationKey;
    }

    public GetConfigurationResponse withConfigurationKey(List<ConfigurationKey> configurationKey) {
        this.configurationKey = configurationKey;
        return this;
    }

    @JsonProperty("unknownKey")
    public List<String> getUnknownKey() {
        return unknownKey;
    }

    @JsonProperty("unknownKey")
    public void setUnknownKey(List<String> unknownKey) {
        this.unknownKey = unknownKey;
    }

    public GetConfigurationResponse withUnknownKey(List<String> unknownKey) {
        this.unknownKey = unknownKey;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetConfigurationResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("configurationKey");
        sb.append('=');
        sb.append(((this.configurationKey == null)?"<null>":this.configurationKey));
        sb.append(',');
        sb.append("unknownKey");
        sb.append('=');
        sb.append(((this.unknownKey == null)?"<null>":this.unknownKey));
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
        result = ((result* 31)+((this.configurationKey == null)? 0 :this.configurationKey.hashCode()));
        result = ((result* 31)+((this.unknownKey == null)? 0 :this.unknownKey.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetConfigurationResponse) == false) {
            return false;
        }
        GetConfigurationResponse rhs = ((GetConfigurationResponse) other);
        return (((this.configurationKey == rhs.configurationKey)||((this.configurationKey!= null)&&this.configurationKey.equals(rhs.configurationKey)))&&((this.unknownKey == rhs.unknownKey)||((this.unknownKey!= null)&&this.unknownKey.equals(rhs.unknownKey))));
    }

}
