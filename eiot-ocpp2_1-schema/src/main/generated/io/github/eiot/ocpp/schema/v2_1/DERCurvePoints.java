
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "x",
    "y",
    "customData"
})
public class DERCurvePoints {

    /**
     * The data value of the X-axis (independent) variable, depending on the curve type.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("x")
    @JsonPropertyDescription("The data value of the X-axis (independent) variable, depending on the curve type.\r\n\r\n\r\n")
    @NotNull
    private double x;
    /**
     * The data value of the Y-axis (dependent) variable, depending on the  &lt;&lt;cmn_derunitenumtype&gt;&gt; of the curve. If _y_ is power factor, then a positive value means DER is absorbing reactive power (under-excited), a negative value when DER is injecting reactive power (over-excited).
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("y")
    @JsonPropertyDescription("The data value of the Y-axis (dependent) variable, depending on the  &lt;&lt;cmn_derunitenumtype&gt;&gt; of the curve. If _y_ is power factor, then a positive value means DER is absorbing reactive power (under-excited), a negative value when DER is injecting reactive power (over-excited).\r\n\r\n")
    @NotNull
    private double y;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * The data value of the X-axis (independent) variable, depending on the curve type.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("x")
    public double getX() {
        return x;
    }

    /**
     * The data value of the X-axis (independent) variable, depending on the curve type.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("x")
    public void setX(double x) {
        this.x = x;
    }

    public DERCurvePoints withX(double x) {
        this.x = x;
        return this;
    }

    /**
     * The data value of the Y-axis (dependent) variable, depending on the  &lt;&lt;cmn_derunitenumtype&gt;&gt; of the curve. If _y_ is power factor, then a positive value means DER is absorbing reactive power (under-excited), a negative value when DER is injecting reactive power (over-excited).
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("y")
    public double getY() {
        return y;
    }

    /**
     * The data value of the Y-axis (dependent) variable, depending on the  &lt;&lt;cmn_derunitenumtype&gt;&gt; of the curve. If _y_ is power factor, then a positive value means DER is absorbing reactive power (under-excited), a negative value when DER is injecting reactive power (over-excited).
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("y")
    public void setY(double y) {
        this.y = y;
    }

    public DERCurvePoints withY(double y) {
        this.y = y;
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

    public DERCurvePoints withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DERCurvePoints.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("x");
        sb.append('=');
        sb.append(this.x);
        sb.append(',');
        sb.append("y");
        sb.append('=');
        sb.append(this.y);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.x)^(Double.doubleToLongBits(this.x)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.y)^(Double.doubleToLongBits(this.y)>>> 32))));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DERCurvePoints) == false) {
            return false;
        }
        DERCurvePoints rhs = ((DERCurvePoints) other);
        return (((Double.doubleToLongBits(this.x) == Double.doubleToLongBits(rhs.x))&&(Double.doubleToLongBits(this.y) == Double.doubleToLongBits(rhs.y)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
