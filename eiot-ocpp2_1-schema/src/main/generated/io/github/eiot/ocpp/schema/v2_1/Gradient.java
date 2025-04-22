
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "priority",
    "gradient",
    "softGradient",
    "customData"
})
public class Gradient {

    /**
     * Id of setting
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("Id of setting\r\n\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private int priority;
    /**
     * Default ramp rate in seconds (0 if not applicable)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("gradient")
    @JsonPropertyDescription("Default ramp rate in seconds (0 if not applicable)\r\n\r\n\r\n")
    @NotNull
    private double gradient;
    /**
     * Soft-start ramp rate in seconds (0 if not applicable)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("softGradient")
    @JsonPropertyDescription("Soft-start ramp rate in seconds (0 if not applicable)\r\n\r\n\r\n")
    @NotNull
    private double softGradient;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Id of setting
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    public int getPriority() {
        return priority;
    }

    /**
     * Id of setting
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Gradient withPriority(int priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Default ramp rate in seconds (0 if not applicable)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("gradient")
    public double getGradient() {
        return gradient;
    }

    /**
     * Default ramp rate in seconds (0 if not applicable)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("gradient")
    public void setGradient(double gradient) {
        this.gradient = gradient;
    }

    public Gradient withGradient(double gradient) {
        this.gradient = gradient;
        return this;
    }

    /**
     * Soft-start ramp rate in seconds (0 if not applicable)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("softGradient")
    public double getSoftGradient() {
        return softGradient;
    }

    /**
     * Soft-start ramp rate in seconds (0 if not applicable)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("softGradient")
    public void setSoftGradient(double softGradient) {
        this.softGradient = softGradient;
    }

    public Gradient withSoftGradient(double softGradient) {
        this.softGradient = softGradient;
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

    public Gradient withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Gradient.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("priority");
        sb.append('=');
        sb.append(this.priority);
        sb.append(',');
        sb.append("gradient");
        sb.append('=');
        sb.append(this.gradient);
        sb.append(',');
        sb.append("softGradient");
        sb.append('=');
        sb.append(this.softGradient);
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
        result = ((result* 31)+ this.priority);
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.softGradient)^(Double.doubleToLongBits(this.softGradient)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.gradient)^(Double.doubleToLongBits(this.gradient)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Gradient) == false) {
            return false;
        }
        Gradient rhs = ((Gradient) other);
        return (((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(this.priority == rhs.priority))&&(Double.doubleToLongBits(this.softGradient) == Double.doubleToLongBits(rhs.softGradient)))&&(Double.doubleToLongBits(this.gradient) == Double.doubleToLongBits(rhs.gradient)));
    }

}
