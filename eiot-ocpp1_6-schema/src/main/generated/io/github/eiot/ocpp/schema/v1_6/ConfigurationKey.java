
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "readonly",
    "value"
})
public class ConfigurationKey {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    @Size(max = 50)
    @NotNull
    private String key;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("readonly")
    @NotNull
    private boolean readonly;
    @JsonProperty("value")
    @Size(max = 500)
    private String value;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    public ConfigurationKey withKey(String key) {
        this.key = key;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("readonly")
    public boolean isReadonly() {
        return readonly;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("readonly")
    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public ConfigurationKey withReadonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public ConfigurationKey withValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ConfigurationKey.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("key");
        sb.append('=');
        sb.append(((this.key == null)?"<null>":this.key));
        sb.append(',');
        sb.append("readonly");
        sb.append('=');
        sb.append(this.readonly);
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
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
        result = ((result* 31)+(this.readonly? 1 : 0));
        result = ((result* 31)+((this.value == null)? 0 :this.value.hashCode()));
        result = ((result* 31)+((this.key == null)? 0 :this.key.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ConfigurationKey) == false) {
            return false;
        }
        ConfigurationKey rhs = ((ConfigurationKey) other);
        return (((this.readonly == rhs.readonly)&&((this.value == rhs.value)||((this.value!= null)&&this.value.equals(rhs.value))))&&((this.key == rhs.key)||((this.key!= null)&&this.key.equals(rhs.key))));
    }

}
