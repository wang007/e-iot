
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vatNumber",
    "evseId",
    "customData"
})
public class VatNumberValidationRequest {

    /**
     * VAT number to check.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("vatNumber")
    @JsonPropertyDescription("VAT number to check.\r\n\r\n")
    @Size(max = 20)
    @NotNull
    private String vatNumber;
    /**
     * EVSE id for which check is done
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("EVSE id for which check is done\r\n\r\n")
    @DecimalMin("0")
    private int evseId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * VAT number to check.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("vatNumber")
    public String getVatNumber() {
        return vatNumber;
    }

    /**
     * VAT number to check.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("vatNumber")
    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public VatNumberValidationRequest withVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
        return this;
    }

    /**
     * EVSE id for which check is done
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * EVSE id for which check is done
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public VatNumberValidationRequest withEvseId(int evseId) {
        this.evseId = evseId;
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

    public VatNumberValidationRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VatNumberValidationRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("vatNumber");
        sb.append('=');
        sb.append(((this.vatNumber == null)?"<null>":this.vatNumber));
        sb.append(',');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
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
        result = ((result* 31)+ this.evseId);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.vatNumber == null)? 0 :this.vatNumber.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VatNumberValidationRequest) == false) {
            return false;
        }
        VatNumberValidationRequest rhs = ((VatNumberValidationRequest) other);
        return (((this.evseId == rhs.evseId)&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.vatNumber == rhs.vatNumber)||((this.vatNumber!= null)&&this.vatNumber.equals(rhs.vatNumber))));
    }

}
