
package io.github.eiot.ocpp.schema.v2_0_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * Cost
 * urn:x-oca:ocpp:uid:2:233258
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customData",
    "costKind",
    "amount",
    "amountMultiplier"
})
public class Cost {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Cost. Cost_ Kind. Cost_ Kind_ Code
     * urn:x-oca:ocpp:uid:1:569243
     * The kind of cost referred to in the message element amount
     * 
     * (Required)
     * 
     */
    @JsonProperty("costKind")
    @JsonPropertyDescription("Cost. Cost_ Kind. Cost_ Kind_ Code\r\nurn:x-oca:ocpp:uid:1:569243\r\nThe kind of cost referred to in the message element amount\r\n")
    @NotNull
    private CostKindEnum costKind;
    /**
     * Cost. Amount. Amount
     * urn:x-oca:ocpp:uid:1:569244
     * The estimated or actual cost per kWh
     * 
     * (Required)
     * 
     */
    @JsonProperty("amount")
    @JsonPropertyDescription("Cost. Amount. Amount\r\nurn:x-oca:ocpp:uid:1:569244\r\nThe estimated or actual cost per kWh\r\n")
    @NotNull
    private int amount;
    /**
     * Cost. Amount_ Multiplier. Integer
     * urn:x-oca:ocpp:uid:1:569245
     * Values: -3..3, The amountMultiplier defines the exponent to base 10 (dec). The final value is determined by: amount * 10 ^ amountMultiplier
     * 
     * 
     */
    @JsonProperty("amountMultiplier")
    @JsonPropertyDescription("Cost. Amount_ Multiplier. Integer\r\nurn:x-oca:ocpp:uid:1:569245\r\nValues: -3..3, The amountMultiplier defines the exponent to base 10 (dec). The final value is determined by: amount * 10 ^ amountMultiplier\r\n")
    private int amountMultiplier;

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

    /**
     * Cost. Cost_ Kind. Cost_ Kind_ Code
     * urn:x-oca:ocpp:uid:1:569243
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
     * Cost. Cost_ Kind. Cost_ Kind_ Code
     * urn:x-oca:ocpp:uid:1:569243
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
     * Cost. Amount. Amount
     * urn:x-oca:ocpp:uid:1:569244
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
     * Cost. Amount. Amount
     * urn:x-oca:ocpp:uid:1:569244
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
     * Cost. Amount_ Multiplier. Integer
     * urn:x-oca:ocpp:uid:1:569245
     * Values: -3..3, The amountMultiplier defines the exponent to base 10 (dec). The final value is determined by: amount * 10 ^ amountMultiplier
     * 
     * 
     */
    @JsonProperty("amountMultiplier")
    public int getAmountMultiplier() {
        return amountMultiplier;
    }

    /**
     * Cost. Amount_ Multiplier. Integer
     * urn:x-oca:ocpp:uid:1:569245
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Cost.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customData");
        sb.append('=');
        sb.append(((this.customData == null)?"<null>":this.customData));
        sb.append(',');
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
        result = ((result* 31)+((this.costKind == null)? 0 :this.costKind.hashCode()));
        result = ((result* 31)+ this.amount);
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
        return (((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.costKind == rhs.costKind)||((this.costKind!= null)&&this.costKind.equals(rhs.costKind))))&&(this.amount == rhs.amount))&&(this.amountMultiplier == rhs.amountMultiplier));
    }

}
