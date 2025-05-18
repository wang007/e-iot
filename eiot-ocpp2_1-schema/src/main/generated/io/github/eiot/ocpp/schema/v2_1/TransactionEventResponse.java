
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "totalCost",
    "chargingPriority",
    "idTokenInfo",
    "transactionLimit",
    "updatedPersonalMessage",
    "updatedPersonalMessageExtra",
    "customData"
})
public class TransactionEventResponse {

    /**
     * When _eventType_ of TransactionEventRequest is Updated, then this value contains the running cost. When _eventType_ of TransactionEventRequest is Ended, then this contains the final total cost of this transaction, including taxes, in the currency configured with the Configuration Variable: Currency. Absence of this value does not imply that the transaction was free. To indicate a free transaction, the CSMS SHALL send a value of 0.00.
     * 
     * 
     */
    @JsonProperty("totalCost")
    @JsonPropertyDescription("When _eventType_ of TransactionEventRequest is Updated, then this value contains the running cost. When _eventType_ of TransactionEventRequest is Ended, then this contains the final total cost of this transaction, including taxes, in the currency configured with the Configuration Variable: Currency. Absence of this value does not imply that the transaction was free. To indicate a free transaction, the CSMS SHALL send a value of 0.00.\r\n")
    private double totalCost;
    /**
     * Priority from a business point of view. Default priority is 0, The range is from -9 to 9. Higher values indicate a higher priority. The chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; is temporarily, so it may not be set in the &lt;&lt;cmn_idtokeninfotype,IdTokenInfoType&gt;&gt; afterwards. Also the chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; has a higher priority than the one in &lt;&lt;cmn_idtokeninfotype,IdTokenInfoType&gt;&gt;.  
     * 
     * 
     */
    @JsonProperty("chargingPriority")
    @JsonPropertyDescription("Priority from a business point of view. Default priority is 0, The range is from -9 to 9. Higher values indicate a higher priority. The chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; is temporarily, so it may not be set in the &lt;&lt;cmn_idtokeninfotype,IdTokenInfoType&gt;&gt; afterwards. Also the chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; has a higher priority than the one in &lt;&lt;cmn_idtokeninfotype,IdTokenInfoType&gt;&gt;.  \r\n")
    private int chargingPriority;
    /**
     * Contains status information about an identifier.
     * It is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.
     * 
     * 
     */
    @JsonProperty("idTokenInfo")
    @JsonPropertyDescription("Contains status information about an identifier.\r\nIt is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.\r\n")
    @Valid
    private IdTokenInfo idTokenInfo;
    /**
     * Cost, energy, time or SoC limit for a transaction.
     * 
     * 
     */
    @JsonProperty("transactionLimit")
    @JsonPropertyDescription("Cost, energy, time or SoC limit for a transaction.\r\n")
    @Valid
    private TransactionLimit transactionLimit;
    /**
     * Contains message details, for a message to be displayed on a Charging Station.
     * 
     * 
     * 
     */
    @JsonProperty("updatedPersonalMessage")
    @JsonPropertyDescription("Contains message details, for a message to be displayed on a Charging Station.\r\n\r\n")
    @Valid
    private MessageContent updatedPersonalMessage;
    @JsonProperty("updatedPersonalMessageExtra")
    @Size(min = 1, max = 4)
    @Valid
    private List<MessageContent> updatedPersonalMessageExtra = new ArrayList<MessageContent>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * When _eventType_ of TransactionEventRequest is Updated, then this value contains the running cost. When _eventType_ of TransactionEventRequest is Ended, then this contains the final total cost of this transaction, including taxes, in the currency configured with the Configuration Variable: Currency. Absence of this value does not imply that the transaction was free. To indicate a free transaction, the CSMS SHALL send a value of 0.00.
     * 
     * 
     */
    @JsonProperty("totalCost")
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * When _eventType_ of TransactionEventRequest is Updated, then this value contains the running cost. When _eventType_ of TransactionEventRequest is Ended, then this contains the final total cost of this transaction, including taxes, in the currency configured with the Configuration Variable: Currency. Absence of this value does not imply that the transaction was free. To indicate a free transaction, the CSMS SHALL send a value of 0.00.
     * 
     * 
     */
    @JsonProperty("totalCost")
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public TransactionEventResponse withTotalCost(double totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    /**
     * Priority from a business point of view. Default priority is 0, The range is from -9 to 9. Higher values indicate a higher priority. The chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; is temporarily, so it may not be set in the &lt;&lt;cmn_idtokeninfotype,IdTokenInfoType&gt;&gt; afterwards. Also the chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; has a higher priority than the one in &lt;&lt;cmn_idtokeninfotype,IdTokenInfoType&gt;&gt;.  
     * 
     * 
     */
    @JsonProperty("chargingPriority")
    public int getChargingPriority() {
        return chargingPriority;
    }

    /**
     * Priority from a business point of view. Default priority is 0, The range is from -9 to 9. Higher values indicate a higher priority. The chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; is temporarily, so it may not be set in the &lt;&lt;cmn_idtokeninfotype,IdTokenInfoType&gt;&gt; afterwards. Also the chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; has a higher priority than the one in &lt;&lt;cmn_idtokeninfotype,IdTokenInfoType&gt;&gt;.  
     * 
     * 
     */
    @JsonProperty("chargingPriority")
    public void setChargingPriority(int chargingPriority) {
        this.chargingPriority = chargingPriority;
    }

    public TransactionEventResponse withChargingPriority(int chargingPriority) {
        this.chargingPriority = chargingPriority;
        return this;
    }

    /**
     * Contains status information about an identifier.
     * It is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.
     * 
     * 
     */
    @JsonProperty("idTokenInfo")
    public IdTokenInfo getIdTokenInfo() {
        return idTokenInfo;
    }

    /**
     * Contains status information about an identifier.
     * It is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.
     * 
     * 
     */
    @JsonProperty("idTokenInfo")
    public void setIdTokenInfo(IdTokenInfo idTokenInfo) {
        this.idTokenInfo = idTokenInfo;
    }

    public TransactionEventResponse withIdTokenInfo(IdTokenInfo idTokenInfo) {
        this.idTokenInfo = idTokenInfo;
        return this;
    }

    /**
     * Cost, energy, time or SoC limit for a transaction.
     * 
     * 
     */
    @JsonProperty("transactionLimit")
    public TransactionLimit getTransactionLimit() {
        return transactionLimit;
    }

    /**
     * Cost, energy, time or SoC limit for a transaction.
     * 
     * 
     */
    @JsonProperty("transactionLimit")
    public void setTransactionLimit(TransactionLimit transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public TransactionEventResponse withTransactionLimit(TransactionLimit transactionLimit) {
        this.transactionLimit = transactionLimit;
        return this;
    }

    /**
     * Contains message details, for a message to be displayed on a Charging Station.
     * 
     * 
     * 
     */
    @JsonProperty("updatedPersonalMessage")
    public MessageContent getUpdatedPersonalMessage() {
        return updatedPersonalMessage;
    }

    /**
     * Contains message details, for a message to be displayed on a Charging Station.
     * 
     * 
     * 
     */
    @JsonProperty("updatedPersonalMessage")
    public void setUpdatedPersonalMessage(MessageContent updatedPersonalMessage) {
        this.updatedPersonalMessage = updatedPersonalMessage;
    }

    public TransactionEventResponse withUpdatedPersonalMessage(MessageContent updatedPersonalMessage) {
        this.updatedPersonalMessage = updatedPersonalMessage;
        return this;
    }

    @JsonProperty("updatedPersonalMessageExtra")
    public List<MessageContent> getUpdatedPersonalMessageExtra() {
        return updatedPersonalMessageExtra;
    }

    @JsonProperty("updatedPersonalMessageExtra")
    public void setUpdatedPersonalMessageExtra(List<MessageContent> updatedPersonalMessageExtra) {
        this.updatedPersonalMessageExtra = updatedPersonalMessageExtra;
    }

    public TransactionEventResponse withUpdatedPersonalMessageExtra(List<MessageContent> updatedPersonalMessageExtra) {
        this.updatedPersonalMessageExtra = updatedPersonalMessageExtra;
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

    public TransactionEventResponse withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TransactionEventResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("totalCost");
        sb.append('=');
        sb.append(this.totalCost);
        sb.append(',');
        sb.append("chargingPriority");
        sb.append('=');
        sb.append(this.chargingPriority);
        sb.append(',');
        sb.append("idTokenInfo");
        sb.append('=');
        sb.append(((this.idTokenInfo == null)?"<null>":this.idTokenInfo));
        sb.append(',');
        sb.append("transactionLimit");
        sb.append('=');
        sb.append(((this.transactionLimit == null)?"<null>":this.transactionLimit));
        sb.append(',');
        sb.append("updatedPersonalMessage");
        sb.append('=');
        sb.append(((this.updatedPersonalMessage == null)?"<null>":this.updatedPersonalMessage));
        sb.append(',');
        sb.append("updatedPersonalMessageExtra");
        sb.append('=');
        sb.append(((this.updatedPersonalMessageExtra == null)?"<null>":this.updatedPersonalMessageExtra));
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
        result = ((result* 31)+((this.idTokenInfo == null)? 0 :this.idTokenInfo.hashCode()));
        result = ((result* 31)+((this.updatedPersonalMessageExtra == null)? 0 :this.updatedPersonalMessageExtra.hashCode()));
        result = ((result* 31)+((this.updatedPersonalMessage == null)? 0 :this.updatedPersonalMessage.hashCode()));
        result = ((result* 31)+ this.chargingPriority);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.transactionLimit == null)? 0 :this.transactionLimit.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.totalCost)^(Double.doubleToLongBits(this.totalCost)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionEventResponse) == false) {
            return false;
        }
        TransactionEventResponse rhs = ((TransactionEventResponse) other);
        return ((((((((this.idTokenInfo == rhs.idTokenInfo)||((this.idTokenInfo!= null)&&this.idTokenInfo.equals(rhs.idTokenInfo)))&&((this.updatedPersonalMessageExtra == rhs.updatedPersonalMessageExtra)||((this.updatedPersonalMessageExtra!= null)&&this.updatedPersonalMessageExtra.equals(rhs.updatedPersonalMessageExtra))))&&((this.updatedPersonalMessage == rhs.updatedPersonalMessage)||((this.updatedPersonalMessage!= null)&&this.updatedPersonalMessage.equals(rhs.updatedPersonalMessage))))&&(this.chargingPriority == rhs.chargingPriority))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.transactionLimit == rhs.transactionLimit)||((this.transactionLimit!= null)&&this.transactionLimit.equals(rhs.transactionLimit))))&&(Double.doubleToLongBits(this.totalCost) == Double.doubleToLongBits(rhs.totalCost)));
    }

}
