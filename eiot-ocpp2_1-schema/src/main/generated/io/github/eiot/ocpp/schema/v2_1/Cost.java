
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "costKind",
    "amount",
    "amountMultiplier",
    "customData"
})
public class Cost {

    /**
     * The kind of cost referred to in the message element amount
     * 
     * (Required)
     * 
     */
    @JsonProperty("costKind")
    @JsonPropertyDescription("The kind of cost referred to in the message element amount\r\n")
    @NotNull
    private CostKindEnum costKind;
    /**
     * The estimated or actual cost per kWh
     * 
     * (Required)
     * 
     */
    @JsonProperty("amount")
    @JsonPropertyDescription("The estimated or actual cost per kWh\r\n")
    @NotNull
    private int amount;
    /**
     * Values: -3..3, The amountMultiplier defines the exponent to base 10 (dec). The final value is determined by: amount * 10 ^ amountMultiplier
     * 
     * 
     */
    @JsonProperty("amountMultiplier")
    @JsonPropertyDescription("Values: -3..3, The amountMultiplier defines the exponent to base 10 (dec). The final value is determined by: amount * 10 ^ amountMultiplier\r\n")
    private int amountMultiplier;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * The kind of cost referred to in the message element amount
     * 
     * (Required)
     * 
     */
    @JsonProperty("costKind")
    public CostKindEnum getCostKind() {
        return costKind;
    }

    /**
     * The kind of cost referred to in the message element amount
     * 
     * (Required)
     * 
     */
    @JsonProperty("costKind")
    public void setCostKind(CostKindEnum costKind) {
        this.costKind = costKind;
    }

    public Cost withCostKind(CostKindEnum costKind) {
        this.costKind = costKind;
        return this;
    }

    /**
     * The estimated or actual cost per kWh
     * 
     * (Required)
     * 
     */
    @JsonProperty("amount")
    public int getAmount() {
        return amount;
    }

    /**
     * The estimated or actual cost per kWh
     * 
     * (Required)
     * 
     */
    @JsonProperty("amount")
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Cost withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Values: -3..3, The amountMultiplier defines the exponent to base 10 (dec). The final value is determined by: amount * 10 ^ amountMultiplier
     * 
     * 
     */
    @JsonProperty("amountMultiplier")
    public int getAmountMultiplier() {
        return amountMultiplier;
    }

    /**
     * Values: -3..3, The amountMultiplier defines the exponent to base 10 (dec). The final value is determined by: amount * 10 ^ amountMultiplier
     * 
     * 
     */
    @JsonProperty("amountMultiplier")
    public void setAmountMultiplier(int amountMultiplier) {
        this.amountMultiplier = amountMultiplier;
    }

    public Cost withAmountMultiplier(int amountMultiplier) {
        this.amountMultiplier = amountMultiplier;
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

    public Cost withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Cost.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("costKind");
        sb.append('=');
        sb.append(((this.costKind == null)?"<null>":this.costKind));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(this.amount);
        sb.append(',');
        sb.append("amountMultiplier");
        sb.append('=');
        sb.append(this.amountMultiplier);
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
        result = ((result* 31)+((this.costKind == null)? 0 :this.costKind.hashCode()));
        result = ((result* 31)+ this.amount);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+ this.amountMultiplier);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Cost) == false) {
            return false;
        }
        Cost rhs = ((Cost) other);
        return (((((this.costKind == rhs.costKind)||((this.costKind!= null)&&this.costKind.equals(rhs.costKind)))&&(this.amount == rhs.amount))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(this.amountMultiplier == rhs.amountMultiplier));
    }

}
