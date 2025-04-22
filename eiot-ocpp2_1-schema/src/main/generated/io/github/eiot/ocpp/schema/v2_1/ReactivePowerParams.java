
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vRef",
    "autonomousVRefEnable",
    "autonomousVRefTimeConstant",
    "customData"
})
public class ReactivePowerParams {

    /**
     * Only for VoltVar curve: The nominal ac voltage (rms) adjustment to the voltage curve points for Volt-Var curves (percentage).
     * 
     * 
     * 
     * 
     */
    @JsonProperty("vRef")
    @JsonPropertyDescription("Only for VoltVar curve: The nominal ac voltage (rms) adjustment to the voltage curve points for Volt-Var curves (percentage).\r\n\r\n\r\n")
    private double vRef;
    /**
     * Only for VoltVar: Enable/disable autonomous VRef adjustment
     * 
     * 
     * 
     * 
     */
    @JsonProperty("autonomousVRefEnable")
    @JsonPropertyDescription("Only for VoltVar: Enable/disable autonomous VRef adjustment\r\n\r\n\r\n")
    private boolean autonomousVRefEnable;
    /**
     * Only for VoltVar: Adjustment range for VRef time constant
     * 
     * 
     * 
     * 
     */
    @JsonProperty("autonomousVRefTimeConstant")
    @JsonPropertyDescription("Only for VoltVar: Adjustment range for VRef time constant\r\n\r\n\r\n")
    private double autonomousVRefTimeConstant;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Only for VoltVar curve: The nominal ac voltage (rms) adjustment to the voltage curve points for Volt-Var curves (percentage).
     * 
     * 
     * 
     * 
     */
    @JsonProperty("vRef")
    public double getvRef() {
        return vRef;
    }

    /**
     * Only for VoltVar curve: The nominal ac voltage (rms) adjustment to the voltage curve points for Volt-Var curves (percentage).
     * 
     * 
     * 
     * 
     */
    @JsonProperty("vRef")
    public void setvRef(double vRef) {
        this.vRef = vRef;
    }

    public ReactivePowerParams withvRef(double vRef) {
        this.vRef = vRef;
        return this;
    }

    /**
     * Only for VoltVar: Enable/disable autonomous VRef adjustment
     * 
     * 
     * 
     * 
     */
    @JsonProperty("autonomousVRefEnable")
    public boolean isAutonomousVRefEnable() {
        return autonomousVRefEnable;
    }

    /**
     * Only for VoltVar: Enable/disable autonomous VRef adjustment
     * 
     * 
     * 
     * 
     */
    @JsonProperty("autonomousVRefEnable")
    public void setAutonomousVRefEnable(boolean autonomousVRefEnable) {
        this.autonomousVRefEnable = autonomousVRefEnable;
    }

    public ReactivePowerParams withAutonomousVRefEnable(boolean autonomousVRefEnable) {
        this.autonomousVRefEnable = autonomousVRefEnable;
        return this;
    }

    /**
     * Only for VoltVar: Adjustment range for VRef time constant
     * 
     * 
     * 
     * 
     */
    @JsonProperty("autonomousVRefTimeConstant")
    public double getAutonomousVRefTimeConstant() {
        return autonomousVRefTimeConstant;
    }

    /**
     * Only for VoltVar: Adjustment range for VRef time constant
     * 
     * 
     * 
     * 
     */
    @JsonProperty("autonomousVRefTimeConstant")
    public void setAutonomousVRefTimeConstant(double autonomousVRefTimeConstant) {
        this.autonomousVRefTimeConstant = autonomousVRefTimeConstant;
    }

    public ReactivePowerParams withAutonomousVRefTimeConstant(double autonomousVRefTimeConstant) {
        this.autonomousVRefTimeConstant = autonomousVRefTimeConstant;
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

    public ReactivePowerParams withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ReactivePowerParams.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("vRef");
        sb.append('=');
        sb.append(this.vRef);
        sb.append(',');
        sb.append("autonomousVRefEnable");
        sb.append('=');
        sb.append(this.autonomousVRefEnable);
        sb.append(',');
        sb.append("autonomousVRefTimeConstant");
        sb.append('=');
        sb.append(this.autonomousVRefTimeConstant);
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
        result = ((result* 31)+(this.autonomousVRefEnable? 1 : 0));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.vRef)^(Double.doubleToLongBits(this.vRef)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.autonomousVRefTimeConstant)^(Double.doubleToLongBits(this.autonomousVRefTimeConstant)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReactivePowerParams) == false) {
            return false;
        }
        ReactivePowerParams rhs = ((ReactivePowerParams) other);
        return ((((this.autonomousVRefEnable == rhs.autonomousVRefEnable)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(Double.doubleToLongBits(this.vRef) == Double.doubleToLongBits(rhs.vRef)))&&(Double.doubleToLongBits(this.autonomousVRefTimeConstant) == Double.doubleToLongBits(rhs.autonomousVRefTimeConstant)));
    }

}
