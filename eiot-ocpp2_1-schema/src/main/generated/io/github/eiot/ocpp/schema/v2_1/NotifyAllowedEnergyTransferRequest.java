
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "transactionId",
    "allowedEnergyTransfer",
    "customData"
})
public class NotifyAllowedEnergyTransferRequest {

    /**
     * The transaction for which the allowed energy transfer is allowed.
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    @JsonPropertyDescription("The transaction for which the allowed energy transfer is allowed.\r\n")
    @Size(max = 36)
    @NotNull
    private String transactionId;
    /**
     * Modes of energy transfer that are accepted by CSMS.
     * 
     * (Required)
     * 
     */
    @JsonProperty("allowedEnergyTransfer")
    @JsonPropertyDescription("Modes of energy transfer that are accepted by CSMS.\r\n")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<EnergyTransferModeEnum> allowedEnergyTransfer = new ArrayList<EnergyTransferModeEnum>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * The transaction for which the allowed energy transfer is allowed.
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * The transaction for which the allowed energy transfer is allowed.
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public NotifyAllowedEnergyTransferRequest withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * Modes of energy transfer that are accepted by CSMS.
     * 
     * (Required)
     * 
     */
    @JsonProperty("allowedEnergyTransfer")
    public List<EnergyTransferModeEnum> getAllowedEnergyTransfer() {
        return allowedEnergyTransfer;
    }

    /**
     * Modes of energy transfer that are accepted by CSMS.
     * 
     * (Required)
     * 
     */
    @JsonProperty("allowedEnergyTransfer")
    public void setAllowedEnergyTransfer(List<EnergyTransferModeEnum> allowedEnergyTransfer) {
        this.allowedEnergyTransfer = allowedEnergyTransfer;
    }

    public NotifyAllowedEnergyTransferRequest withAllowedEnergyTransfer(List<EnergyTransferModeEnum> allowedEnergyTransfer) {
        this.allowedEnergyTransfer = allowedEnergyTransfer;
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

    public NotifyAllowedEnergyTransferRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyAllowedEnergyTransferRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("transactionId");
        sb.append('=');
        sb.append(((this.transactionId == null)?"<null>":this.transactionId));
        sb.append(',');
        sb.append("allowedEnergyTransfer");
        sb.append('=');
        sb.append(((this.allowedEnergyTransfer == null)?"<null>":this.allowedEnergyTransfer));
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
        result = ((result* 31)+((this.allowedEnergyTransfer == null)? 0 :this.allowedEnergyTransfer.hashCode()));
        result = ((result* 31)+((this.transactionId == null)? 0 :this.transactionId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NotifyAllowedEnergyTransferRequest) == false) {
            return false;
        }
        NotifyAllowedEnergyTransferRequest rhs = ((NotifyAllowedEnergyTransferRequest) other);
        return ((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.allowedEnergyTransfer == rhs.allowedEnergyTransfer)||((this.allowedEnergyTransfer!= null)&&this.allowedEnergyTransfer.equals(rhs.allowedEnergyTransfer))))&&((this.transactionId == rhs.transactionId)||((this.transactionId!= null)&&this.transactionId.equals(rhs.transactionId))));
    }

}
