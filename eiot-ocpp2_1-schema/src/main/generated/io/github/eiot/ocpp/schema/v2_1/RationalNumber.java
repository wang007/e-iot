
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * Part of ISO 15118-20 price schedule.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exponent",
    "value",
    "customData"
})
public class RationalNumber {

    /**
     * The exponent to base 10 (dec)
     * 
     * (Required)
     * 
     */
    @JsonProperty("exponent")
    @JsonPropertyDescription("The exponent to base 10 (dec)\r\n")
    @NotNull
    private int exponent;
    /**
     * Value which shall be multiplied.
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    @JsonPropertyDescription("Value which shall be multiplied.\r\n")
    @NotNull
    private int value;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * The exponent to base 10 (dec)
     * 
     * (Required)
     * 
     */
    @JsonProperty("exponent")
    public int getExponent() {
        return exponent;
    }

    /**
     * The exponent to base 10 (dec)
     * 
     * (Required)
     * 
     */
    @JsonProperty("exponent")
    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public RationalNumber withExponent(int exponent) {
        this.exponent = exponent;
        return this;
    }

    /**
     * Value which shall be multiplied.
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    public int getValue() {
        return value;
    }

    /**
     * Value which shall be multiplied.
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    public void setValue(int value) {
        this.value = value;
    }

    public RationalNumber withValue(int value) {
        this.value = value;
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

    public RationalNumber withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RationalNumber.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("exponent");
        sb.append('=');
        sb.append(this.exponent);
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(this.value);
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
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.value);
        result = ((result* 31)+ this.exponent);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RationalNumber) == false) {
            return false;
        }
        RationalNumber rhs = ((RationalNumber) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(this.value == rhs.value))&&(this.exponent == rhs.exponent));
    }

}
