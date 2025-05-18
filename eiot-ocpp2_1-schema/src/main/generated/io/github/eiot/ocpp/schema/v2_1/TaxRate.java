
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Tax percentage
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "tax",
    "stack",
    "customData"
})
public class TaxRate {

    /**
     * Type of this tax, e.g.  "Federal ",  "State", for information on receipt.
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of this tax, e.g.  \"Federal \",  \"State\", for information on receipt.\r\n")
    @Size(max = 20)
    @NotNull
    private String type;
    /**
     * Tax percentage
     * 
     * (Required)
     * 
     */
    @JsonProperty("tax")
    @JsonPropertyDescription("Tax percentage\r\n")
    @NotNull
    private double tax;
    /**
     * Stack level for this type of tax. Default value, when absent, is 0. +
     * _stack_ = 0: tax on net price; +
     * _stack_ = 1: tax added on top of _stack_ 0; +
     * _stack_ = 2: tax added on top of _stack_ 1, etc. 
     * 
     * 
     */
    @JsonProperty("stack")
    @JsonPropertyDescription("Stack level for this type of tax. Default value, when absent, is 0. +\r\n_stack_ = 0: tax on net price; +\r\n_stack_ = 1: tax added on top of _stack_ 0; +\r\n_stack_ = 2: tax added on top of _stack_ 1, etc. \r\n")
    @DecimalMin("0")
    private int stack;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Type of this tax, e.g.  "Federal ",  "State", for information on receipt.
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type of this tax, e.g.  "Federal ",  "State", for information on receipt.
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public TaxRate withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Tax percentage
     * 
     * (Required)
     * 
     */
    @JsonProperty("tax")
    public double getTax() {
        return tax;
    }

    /**
     * Tax percentage
     * 
     * (Required)
     * 
     */
    @JsonProperty("tax")
    public void setTax(double tax) {
        this.tax = tax;
    }

    public TaxRate withTax(double tax) {
        this.tax = tax;
        return this;
    }

    /**
     * Stack level for this type of tax. Default value, when absent, is 0. +
     * _stack_ = 0: tax on net price; +
     * _stack_ = 1: tax added on top of _stack_ 0; +
     * _stack_ = 2: tax added on top of _stack_ 1, etc. 
     * 
     * 
     */
    @JsonProperty("stack")
    public int getStack() {
        return stack;
    }

    /**
     * Stack level for this type of tax. Default value, when absent, is 0. +
     * _stack_ = 0: tax on net price; +
     * _stack_ = 1: tax added on top of _stack_ 0; +
     * _stack_ = 2: tax added on top of _stack_ 1, etc. 
     * 
     * 
     */
    @JsonProperty("stack")
    public void setStack(int stack) {
        this.stack = stack;
    }

    public TaxRate withStack(int stack) {
        this.stack = stack;
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

    public TaxRate withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TaxRate.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("tax");
        sb.append('=');
        sb.append(this.tax);
        sb.append(',');
        sb.append("stack");
        sb.append('=');
        sb.append(this.stack);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.tax)^(Double.doubleToLongBits(this.tax)>>> 32))));
        result = ((result* 31)+ this.stack);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TaxRate) == false) {
            return false;
        }
        TaxRate rhs = ((TaxRate) other);
        return ((((Double.doubleToLongBits(this.tax) == Double.doubleToLongBits(rhs.tax))&&(this.stack == rhs.stack))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))));
    }

}
