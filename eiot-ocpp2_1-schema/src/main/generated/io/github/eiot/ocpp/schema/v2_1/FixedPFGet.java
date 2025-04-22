
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
    "fixedPF",
    "id",
    "isDefault",
    "isSuperseded",
    "customData"
})
public class FixedPFGet {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fixedPF")
    @Valid
    @NotNull
    private FixedPF fixedPF;
    /**
     * Id of setting.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Id of setting.\r\n")
    @Size(max = 36)
    @NotNull
    private String id;
    /**
     * True if setting is a default control.
     * 
     * (Required)
     * 
     */
    @JsonProperty("isDefault")
    @JsonPropertyDescription("True if setting is a default control.\r\n")
    @NotNull
    private boolean isDefault;
    /**
     * True if this setting is superseded by a lower priority setting.
     * 
     * (Required)
     * 
     */
    @JsonProperty("isSuperseded")
    @JsonPropertyDescription("True if this setting is superseded by a lower priority setting.\r\n")
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
    @JsonProperty("fixedPF")
    public FixedPF getFixedPF() {
        return fixedPF;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fixedPF")
    public void setFixedPF(FixedPF fixedPF) {
        this.fixedPF = fixedPF;
    }

    public FixedPFGet withFixedPF(FixedPF fixedPF) {
        this.fixedPF = fixedPF;
        return this;
    }

    /**
     * Id of setting.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Id of setting.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public FixedPFGet withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * True if setting is a default control.
     * 
     * (Required)
     * 
     */
    @JsonProperty("isDefault")
    public boolean isIsDefault() {
        return isDefault;
    }

    /**
     * True if setting is a default control.
     * 
     * (Required)
     * 
     */
    @JsonProperty("isDefault")
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public FixedPFGet withIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    /**
     * True if this setting is superseded by a lower priority setting.
     * 
     * (Required)
     * 
     */
    @JsonProperty("isSuperseded")
    public boolean isIsSuperseded() {
        return isSuperseded;
    }

    /**
     * True if this setting is superseded by a lower priority setting.
     * 
     * (Required)
     * 
     */
    @JsonProperty("isSuperseded")
    public void setIsSuperseded(boolean isSuperseded) {
        this.isSuperseded = isSuperseded;
    }

    public FixedPFGet withIsSuperseded(boolean isSuperseded) {
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

    public FixedPFGet withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FixedPFGet.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("fixedPF");
        sb.append('=');
        sb.append(((this.fixedPF == null)?"<null>":this.fixedPF));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
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
        result = ((result* 31)+((this.fixedPF == null)? 0 :this.fixedPF.hashCode()));
        result = ((result* 31)+(this.isDefault? 1 : 0));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+(this.isSuperseded? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FixedPFGet) == false) {
            return false;
        }
        FixedPFGet rhs = ((FixedPFGet) other);
        return ((((((this.fixedPF == rhs.fixedPF)||((this.fixedPF!= null)&&this.fixedPF.equals(rhs.fixedPF)))&&(this.isDefault == rhs.isDefault))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&(this.isSuperseded == rhs.isSuperseded));
    }

}
