
package io.github.eiot.ocpp.schema.v2_1;

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
    "chargingState",
    "timeSpentCharging",
    "stoppedReason",
    "remoteStartId",
    "operationMode",
    "tariffId",
    "transactionLimit",
    "customData"
})
public class Transaction {

    /**
     * This contains the Id of the transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    @JsonPropertyDescription("This contains the Id of the transaction.\r\n")
    @Size(max = 36)
    @NotNull
    private String transactionId;
    /**
     * Current charging state, is required when state
     * has changed. Omitted when there is no communication between EVSE and EV, because no cable is plugged in.
     * 
     * 
     */
    @JsonProperty("chargingState")
    @JsonPropertyDescription("Current charging state, is required when state\r\nhas changed. Omitted when there is no communication between EVSE and EV, because no cable is plugged in.\r\n")
    private ChargingStateEnum chargingState;
    /**
     * Contains the total time that energy flowed from EVSE to EV during the transaction (in seconds). Note that timeSpentCharging is smaller or equal to the duration of the transaction.
     * 
     * 
     */
    @JsonProperty("timeSpentCharging")
    @JsonPropertyDescription("Contains the total time that energy flowed from EVSE to EV during the transaction (in seconds). Note that timeSpentCharging is smaller or equal to the duration of the transaction.\r\n")
    private int timeSpentCharging;
    /**
     * The _stoppedReason_ is the reason/event that initiated the process of stopping the transaction. It will normally be the user stopping authorization via card (Local or MasterPass) or app (Remote), but it can also be CSMS revoking authorization (DeAuthorized), or disconnecting the EV when TxStopPoint = EVConnected (EVDisconnected). Most other reasons are related to technical faults or energy limitations. +
     * MAY only be omitted when _stoppedReason_ is "Local"
     * 
     * 
     * 
     * 
     */
    @JsonProperty("stoppedReason")
    @JsonPropertyDescription("The _stoppedReason_ is the reason/event that initiated the process of stopping the transaction. It will normally be the user stopping authorization via card (Local or MasterPass) or app (Remote), but it can also be CSMS revoking authorization (DeAuthorized), or disconnecting the EV when TxStopPoint = EVConnected (EVDisconnected). Most other reasons are related to technical faults or energy limitations. +\r\nMAY only be omitted when _stoppedReason_ is \"Local\"\r\n\r\n\r\n")
    private ReasonEnum stoppedReason;
    /**
     * The ID given to remote start request (&lt;&lt;requeststarttransactionrequest, RequestStartTransactionRequest&gt;&gt;. This enables to CSMS to match the started transaction to the given start request.
     * 
     * 
     */
    @JsonProperty("remoteStartId")
    @JsonPropertyDescription("The ID given to remote start request (&lt;&lt;requeststarttransactionrequest, RequestStartTransactionRequest&gt;&gt;. This enables to CSMS to match the started transaction to the given start request.\r\n")
    private int remoteStartId;
    /**
     * *(2.1)* The _operationMode_ that is currently in effect for the transaction.
     * 
     * 
     */
    @JsonProperty("operationMode")
    @JsonPropertyDescription("*(2.1)* The _operationMode_ that is currently in effect for the transaction.\r\n")
    private OperationModeEnum operationMode;
    /**
     * *(2.1)* Id of tariff in use for transaction
     * 
     * 
     */
    @JsonProperty("tariffId")
    @JsonPropertyDescription("*(2.1)* Id of tariff in use for transaction\r\n")
    @Size(max = 60)
    private String tariffId;
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
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * This contains the Id of the transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * This contains the Id of the transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Transaction withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * Current charging state, is required when state
     * has changed. Omitted when there is no communication between EVSE and EV, because no cable is plugged in.
     * 
     * 
     */
    @JsonProperty("chargingState")
    public ChargingStateEnum getChargingState() {
        return chargingState;
    }

    /**
     * Current charging state, is required when state
     * has changed. Omitted when there is no communication between EVSE and EV, because no cable is plugged in.
     * 
     * 
     */
    @JsonProperty("chargingState")
    public void setChargingState(ChargingStateEnum chargingState) {
        this.chargingState = chargingState;
    }

    public Transaction withChargingState(ChargingStateEnum chargingState) {
        this.chargingState = chargingState;
        return this;
    }

    /**
     * Contains the total time that energy flowed from EVSE to EV during the transaction (in seconds). Note that timeSpentCharging is smaller or equal to the duration of the transaction.
     * 
     * 
     */
    @JsonProperty("timeSpentCharging")
    public int getTimeSpentCharging() {
        return timeSpentCharging;
    }

    /**
     * Contains the total time that energy flowed from EVSE to EV during the transaction (in seconds). Note that timeSpentCharging is smaller or equal to the duration of the transaction.
     * 
     * 
     */
    @JsonProperty("timeSpentCharging")
    public void setTimeSpentCharging(int timeSpentCharging) {
        this.timeSpentCharging = timeSpentCharging;
    }

    public Transaction withTimeSpentCharging(int timeSpentCharging) {
        this.timeSpentCharging = timeSpentCharging;
        return this;
    }

    /**
     * The _stoppedReason_ is the reason/event that initiated the process of stopping the transaction. It will normally be the user stopping authorization via card (Local or MasterPass) or app (Remote), but it can also be CSMS revoking authorization (DeAuthorized), or disconnecting the EV when TxStopPoint = EVConnected (EVDisconnected). Most other reasons are related to technical faults or energy limitations. +
     * MAY only be omitted when _stoppedReason_ is "Local"
     * 
     * 
     * 
     * 
     */
    @JsonProperty("stoppedReason")
    public ReasonEnum getStoppedReason() {
        return stoppedReason;
    }

    /**
     * The _stoppedReason_ is the reason/event that initiated the process of stopping the transaction. It will normally be the user stopping authorization via card (Local or MasterPass) or app (Remote), but it can also be CSMS revoking authorization (DeAuthorized), or disconnecting the EV when TxStopPoint = EVConnected (EVDisconnected). Most other reasons are related to technical faults or energy limitations. +
     * MAY only be omitted when _stoppedReason_ is "Local"
     * 
     * 
     * 
     * 
     */
    @JsonProperty("stoppedReason")
    public void setStoppedReason(ReasonEnum stoppedReason) {
        this.stoppedReason = stoppedReason;
    }

    public Transaction withStoppedReason(ReasonEnum stoppedReason) {
        this.stoppedReason = stoppedReason;
        return this;
    }

    /**
     * The ID given to remote start request (&lt;&lt;requeststarttransactionrequest, RequestStartTransactionRequest&gt;&gt;. This enables to CSMS to match the started transaction to the given start request.
     * 
     * 
     */
    @JsonProperty("remoteStartId")
    public int getRemoteStartId() {
        return remoteStartId;
    }

    /**
     * The ID given to remote start request (&lt;&lt;requeststarttransactionrequest, RequestStartTransactionRequest&gt;&gt;. This enables to CSMS to match the started transaction to the given start request.
     * 
     * 
     */
    @JsonProperty("remoteStartId")
    public void setRemoteStartId(int remoteStartId) {
        this.remoteStartId = remoteStartId;
    }

    public Transaction withRemoteStartId(int remoteStartId) {
        this.remoteStartId = remoteStartId;
        return this;
    }

    /**
     * *(2.1)* The _operationMode_ that is currently in effect for the transaction.
     * 
     * 
     */
    @JsonProperty("operationMode")
    public OperationModeEnum getOperationMode() {
        return operationMode;
    }

    /**
     * *(2.1)* The _operationMode_ that is currently in effect for the transaction.
     * 
     * 
     */
    @JsonProperty("operationMode")
    public void setOperationMode(OperationModeEnum operationMode) {
        this.operationMode = operationMode;
    }

    public Transaction withOperationMode(OperationModeEnum operationMode) {
        this.operationMode = operationMode;
        return this;
    }

    /**
     * *(2.1)* Id of tariff in use for transaction
     * 
     * 
     */
    @JsonProperty("tariffId")
    public String getTariffId() {
        return tariffId;
    }

    /**
     * *(2.1)* Id of tariff in use for transaction
     * 
     * 
     */
    @JsonProperty("tariffId")
    public void setTariffId(String tariffId) {
        this.tariffId = tariffId;
    }

    public Transaction withTariffId(String tariffId) {
        this.tariffId = tariffId;
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

    public Transaction withTransactionLimit(TransactionLimit transactionLimit) {
        this.transactionLimit = transactionLimit;
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

    public Transaction withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Transaction.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("transactionId");
        sb.append('=');
        sb.append(((this.transactionId == null)?"<null>":this.transactionId));
        sb.append(',');
        sb.append("chargingState");
        sb.append('=');
        sb.append(((this.chargingState == null)?"<null>":this.chargingState));
        sb.append(',');
        sb.append("timeSpentCharging");
        sb.append('=');
        sb.append(this.timeSpentCharging);
        sb.append(',');
        sb.append("stoppedReason");
        sb.append('=');
        sb.append(((this.stoppedReason == null)?"<null>":this.stoppedReason));
        sb.append(',');
        sb.append("remoteStartId");
        sb.append('=');
        sb.append(this.remoteStartId);
        sb.append(',');
        sb.append("operationMode");
        sb.append('=');
        sb.append(((this.operationMode == null)?"<null>":this.operationMode));
        sb.append(',');
        sb.append("tariffId");
        sb.append('=');
        sb.append(((this.tariffId == null)?"<null>":this.tariffId));
        sb.append(',');
        sb.append("transactionLimit");
        sb.append('=');
        sb.append(((this.transactionLimit == null)?"<null>":this.transactionLimit));
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
        result = ((result* 31)+((this.operationMode == null)? 0 :this.operationMode.hashCode()));
        result = ((result* 31)+ this.remoteStartId);
        result = ((result* 31)+((this.stoppedReason == null)? 0 :this.stoppedReason.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.tariffId == null)? 0 :this.tariffId.hashCode()));
        result = ((result* 31)+((this.transactionLimit == null)? 0 :this.transactionLimit.hashCode()));
        result = ((result* 31)+((this.transactionId == null)? 0 :this.transactionId.hashCode()));
        result = ((result* 31)+ this.timeSpentCharging);
        result = ((result* 31)+((this.chargingState == null)? 0 :this.chargingState.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Transaction) == false) {
            return false;
        }
        Transaction rhs = ((Transaction) other);
        return ((((((((((this.operationMode == rhs.operationMode)||((this.operationMode!= null)&&this.operationMode.equals(rhs.operationMode)))&&(this.remoteStartId == rhs.remoteStartId))&&((this.stoppedReason == rhs.stoppedReason)||((this.stoppedReason!= null)&&this.stoppedReason.equals(rhs.stoppedReason))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.tariffId == rhs.tariffId)||((this.tariffId!= null)&&this.tariffId.equals(rhs.tariffId))))&&((this.transactionLimit == rhs.transactionLimit)||((this.transactionLimit!= null)&&this.transactionLimit.equals(rhs.transactionLimit))))&&((this.transactionId == rhs.transactionId)||((this.transactionId!= null)&&this.transactionId.equals(rhs.transactionId))))&&(this.timeSpentCharging == rhs.timeSpentCharging))&&((this.chargingState == rhs.chargingState)||((this.chargingState!= null)&&this.chargingState.equals(rhs.chargingState))));
    }

}
