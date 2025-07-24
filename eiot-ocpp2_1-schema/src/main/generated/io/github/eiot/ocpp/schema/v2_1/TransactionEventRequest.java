
package io.github.eiot.ocpp.schema.v2_1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "costDetails",
    "eventType",
    "meterValue",
    "timestamp",
    "triggerReason",
    "seqNo",
    "offline",
    "numberOfPhasesUsed",
    "cableMaxCurrent",
    "reservationId",
    "preconditioningStatus",
    "evseSleep",
    "transactionInfo",
    "evse",
    "idToken",
    "customData"
})
public class TransactionEventRequest {

    /**
     * CostDetailsType contains the cost as calculated by Charging Station based on provided TariffType.
     * 
     * NOTE: Reservation is not shown as a _chargingPeriod_, because it took place outside of the transaction.
     * 
     * 
     * 
     */
    @JsonProperty("costDetails")
    @JsonPropertyDescription("CostDetailsType contains the cost as calculated by Charging Station based on provided TariffType.\r\n\r\nNOTE: Reservation is not shown as a _chargingPeriod_, because it took place outside of the transaction.\r\n\r\n")
    @Valid
    private CostDetails costDetails;
    /**
     * This contains the type of this event.
     * The first TransactionEvent of a transaction SHALL contain: "Started" The last TransactionEvent of a transaction SHALL contain: "Ended" All others SHALL contain: "Updated"
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventType")
    @JsonPropertyDescription("This contains the type of this event.\r\nThe first TransactionEvent of a transaction SHALL contain: \"Started\" The last TransactionEvent of a transaction SHALL contain: \"Ended\" All others SHALL contain: \"Updated\"\r\n")
    @NotNull
    private TransactionEventEnum eventType;
    @JsonProperty("meterValue")
    @Size(min = 1)
    @Valid
    private List<MeterValue> meterValue = new ArrayList<MeterValue>();
    /**
     * The date and time at which this transaction event occurred.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("The date and time at which this transaction event occurred.\r\n")
    @NotNull
    private OffsetDateTime timestamp;
    /**
     * Reason the Charging Station sends this message to the CSMS
     * 
     * (Required)
     * 
     */
    @JsonProperty("triggerReason")
    @JsonPropertyDescription("Reason the Charging Station sends this message to the CSMS\r\n")
    @NotNull
    private TriggerReasonEnum triggerReason;
    /**
     * Incremental sequence number, helps with determining if all messages of a transaction have been received.
     * 
     * (Required)
     * 
     */
    @JsonProperty("seqNo")
    @JsonPropertyDescription("Incremental sequence number, helps with determining if all messages of a transaction have been received.\r\n")
    @DecimalMin("0")
    @NotNull
    private int seqNo;
    /**
     * Indication that this transaction event happened when the Charging Station was offline. Default = false, meaning: the event occurred when the Charging Station was online.
     * 
     * 
     */
    @JsonProperty("offline")
    @JsonPropertyDescription("Indication that this transaction event happened when the Charging Station was offline. Default = false, meaning: the event occurred when the Charging Station was online.\r\n")
    private boolean offline = false;
    /**
     * If the Charging Station is able to report the number of phases used, then it SHALL provide it.
     * When omitted the CSMS may be able to determine the number of phases used as follows: +
     *  1: The numberPhases in the currently used ChargingSchedule. +
     *  2: The number of phases provided via device management.
     * 
     * 
     */
    @JsonProperty("numberOfPhasesUsed")
    @JsonPropertyDescription("If the Charging Station is able to report the number of phases used, then it SHALL provide it.\r\nWhen omitted the CSMS may be able to determine the number of phases used as follows: +\r\n1: The numberPhases in the currently used ChargingSchedule. +\r\n2: The number of phases provided via device management.\r\n")
    @DecimalMin("0")
    @DecimalMax("3")
    private int numberOfPhasesUsed;
    /**
     * The maximum current of the connected cable in Ampere (A).
     * 
     * 
     */
    @JsonProperty("cableMaxCurrent")
    @JsonPropertyDescription("The maximum current of the connected cable in Ampere (A).\r\n")
    private int cableMaxCurrent;
    /**
     * This contains the Id of the reservation that terminates as a result of this transaction.
     * 
     * 
     */
    @JsonProperty("reservationId")
    @JsonPropertyDescription("This contains the Id of the reservation that terminates as a result of this transaction.\r\n")
    @DecimalMin("0")
    private int reservationId;
    /**
     * *(2.1)* The current preconditioning status of the BMS in the EV. Default value is Unknown.
     * 
     * 
     */
    @JsonProperty("preconditioningStatus")
    @JsonPropertyDescription("*(2.1)* The current preconditioning status of the BMS in the EV. Default value is Unknown.\r\n")
    private PreconditioningStatusEnum preconditioningStatus;
    /**
     * *(2.1)* True when EVSE electronics are in sleep mode for this transaction. Default value (when absent) is false.
     * 
     * 
     * 
     */
    @JsonProperty("evseSleep")
    @JsonPropertyDescription("*(2.1)* True when EVSE electronics are in sleep mode for this transaction. Default value (when absent) is false.\r\n\r\n")
    private boolean evseSleep;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionInfo")
    @Valid
    @NotNull
    private Transaction transactionInfo;
    /**
     * Electric Vehicle Supply Equipment
     * 
     * 
     */
    @JsonProperty("evse")
    @JsonPropertyDescription("Electric Vehicle Supply Equipment\r\n")
    @Valid
    private EVSE evse;
    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * 
     */
    @JsonProperty("idToken")
    @JsonPropertyDescription("Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.\r\n")
    @Valid
    private IdToken idToken;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * CostDetailsType contains the cost as calculated by Charging Station based on provided TariffType.
     * 
     * NOTE: Reservation is not shown as a _chargingPeriod_, because it took place outside of the transaction.
     * 
     * 
     * 
     */
    @JsonProperty("costDetails")
    public CostDetails getCostDetails() {
        return costDetails;
    }

    /**
     * CostDetailsType contains the cost as calculated by Charging Station based on provided TariffType.
     * 
     * NOTE: Reservation is not shown as a _chargingPeriod_, because it took place outside of the transaction.
     * 
     * 
     * 
     */
    @JsonProperty("costDetails")
    public void setCostDetails(CostDetails costDetails) {
        this.costDetails = costDetails;
    }

    public TransactionEventRequest withCostDetails(CostDetails costDetails) {
        this.costDetails = costDetails;
        return this;
    }

    /**
     * This contains the type of this event.
     * The first TransactionEvent of a transaction SHALL contain: "Started" The last TransactionEvent of a transaction SHALL contain: "Ended" All others SHALL contain: "Updated"
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventType")
    public TransactionEventEnum getEventType() {
        return eventType;
    }

    /**
     * This contains the type of this event.
     * The first TransactionEvent of a transaction SHALL contain: "Started" The last TransactionEvent of a transaction SHALL contain: "Ended" All others SHALL contain: "Updated"
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventType")
    public void setEventType(TransactionEventEnum eventType) {
        this.eventType = eventType;
    }

    public TransactionEventRequest withEventType(TransactionEventEnum eventType) {
        this.eventType = eventType;
        return this;
    }

    @JsonProperty("meterValue")
    public List<MeterValue> getMeterValue() {
        return meterValue;
    }

    @JsonProperty("meterValue")
    public void setMeterValue(List<MeterValue> meterValue) {
        this.meterValue = meterValue;
    }

    public TransactionEventRequest withMeterValue(List<MeterValue> meterValue) {
        this.meterValue = meterValue;
        return this;
    }

    /**
     * The date and time at which this transaction event occurred.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * The date and time at which this transaction event occurred.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public TransactionEventRequest withTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Reason the Charging Station sends this message to the CSMS
     * 
     * (Required)
     * 
     */
    @JsonProperty("triggerReason")
    public TriggerReasonEnum getTriggerReason() {
        return triggerReason;
    }

    /**
     * Reason the Charging Station sends this message to the CSMS
     * 
     * (Required)
     * 
     */
    @JsonProperty("triggerReason")
    public void setTriggerReason(TriggerReasonEnum triggerReason) {
        this.triggerReason = triggerReason;
    }

    public TransactionEventRequest withTriggerReason(TriggerReasonEnum triggerReason) {
        this.triggerReason = triggerReason;
        return this;
    }

    /**
     * Incremental sequence number, helps with determining if all messages of a transaction have been received.
     * 
     * (Required)
     * 
     */
    @JsonProperty("seqNo")
    public int getSeqNo() {
        return seqNo;
    }

    /**
     * Incremental sequence number, helps with determining if all messages of a transaction have been received.
     * 
     * (Required)
     * 
     */
    @JsonProperty("seqNo")
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public TransactionEventRequest withSeqNo(int seqNo) {
        this.seqNo = seqNo;
        return this;
    }

    /**
     * Indication that this transaction event happened when the Charging Station was offline. Default = false, meaning: the event occurred when the Charging Station was online.
     * 
     * 
     */
    @JsonProperty("offline")
    public boolean isOffline() {
        return offline;
    }

    /**
     * Indication that this transaction event happened when the Charging Station was offline. Default = false, meaning: the event occurred when the Charging Station was online.
     * 
     * 
     */
    @JsonProperty("offline")
    public void setOffline(boolean offline) {
        this.offline = offline;
    }

    public TransactionEventRequest withOffline(boolean offline) {
        this.offline = offline;
        return this;
    }

    /**
     * If the Charging Station is able to report the number of phases used, then it SHALL provide it.
     * When omitted the CSMS may be able to determine the number of phases used as follows: +
     *  1: The numberPhases in the currently used ChargingSchedule. +
     *  2: The number of phases provided via device management.
     * 
     * 
     */
    @JsonProperty("numberOfPhasesUsed")
    public int getNumberOfPhasesUsed() {
        return numberOfPhasesUsed;
    }

    /**
     * If the Charging Station is able to report the number of phases used, then it SHALL provide it.
     * When omitted the CSMS may be able to determine the number of phases used as follows: +
     *  1: The numberPhases in the currently used ChargingSchedule. +
     *  2: The number of phases provided via device management.
     * 
     * 
     */
    @JsonProperty("numberOfPhasesUsed")
    public void setNumberOfPhasesUsed(int numberOfPhasesUsed) {
        this.numberOfPhasesUsed = numberOfPhasesUsed;
    }

    public TransactionEventRequest withNumberOfPhasesUsed(int numberOfPhasesUsed) {
        this.numberOfPhasesUsed = numberOfPhasesUsed;
        return this;
    }

    /**
     * The maximum current of the connected cable in Ampere (A).
     * 
     * 
     */
    @JsonProperty("cableMaxCurrent")
    public int getCableMaxCurrent() {
        return cableMaxCurrent;
    }

    /**
     * The maximum current of the connected cable in Ampere (A).
     * 
     * 
     */
    @JsonProperty("cableMaxCurrent")
    public void setCableMaxCurrent(int cableMaxCurrent) {
        this.cableMaxCurrent = cableMaxCurrent;
    }

    public TransactionEventRequest withCableMaxCurrent(int cableMaxCurrent) {
        this.cableMaxCurrent = cableMaxCurrent;
        return this;
    }

    /**
     * This contains the Id of the reservation that terminates as a result of this transaction.
     * 
     * 
     */
    @JsonProperty("reservationId")
    public int getReservationId() {
        return reservationId;
    }

    /**
     * This contains the Id of the reservation that terminates as a result of this transaction.
     * 
     * 
     */
    @JsonProperty("reservationId")
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public TransactionEventRequest withReservationId(int reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    /**
     * *(2.1)* The current preconditioning status of the BMS in the EV. Default value is Unknown.
     * 
     * 
     */
    @JsonProperty("preconditioningStatus")
    public PreconditioningStatusEnum getPreconditioningStatus() {
        return preconditioningStatus;
    }

    /**
     * *(2.1)* The current preconditioning status of the BMS in the EV. Default value is Unknown.
     * 
     * 
     */
    @JsonProperty("preconditioningStatus")
    public void setPreconditioningStatus(PreconditioningStatusEnum preconditioningStatus) {
        this.preconditioningStatus = preconditioningStatus;
    }

    public TransactionEventRequest withPreconditioningStatus(PreconditioningStatusEnum preconditioningStatus) {
        this.preconditioningStatus = preconditioningStatus;
        return this;
    }

    /**
     * *(2.1)* True when EVSE electronics are in sleep mode for this transaction. Default value (when absent) is false.
     * 
     * 
     * 
     */
    @JsonProperty("evseSleep")
    public boolean isEvseSleep() {
        return evseSleep;
    }

    /**
     * *(2.1)* True when EVSE electronics are in sleep mode for this transaction. Default value (when absent) is false.
     * 
     * 
     * 
     */
    @JsonProperty("evseSleep")
    public void setEvseSleep(boolean evseSleep) {
        this.evseSleep = evseSleep;
    }

    public TransactionEventRequest withEvseSleep(boolean evseSleep) {
        this.evseSleep = evseSleep;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionInfo")
    public Transaction getTransactionInfo() {
        return transactionInfo;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionInfo")
    public void setTransactionInfo(Transaction transactionInfo) {
        this.transactionInfo = transactionInfo;
    }

    public TransactionEventRequest withTransactionInfo(Transaction transactionInfo) {
        this.transactionInfo = transactionInfo;
        return this;
    }

    /**
     * Electric Vehicle Supply Equipment
     * 
     * 
     */
    @JsonProperty("evse")
    public EVSE getEvse() {
        return evse;
    }

    /**
     * Electric Vehicle Supply Equipment
     * 
     * 
     */
    @JsonProperty("evse")
    public void setEvse(EVSE evse) {
        this.evse = evse;
    }

    public TransactionEventRequest withEvse(EVSE evse) {
        this.evse = evse;
        return this;
    }

    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * 
     */
    @JsonProperty("idToken")
    public IdToken getIdToken() {
        return idToken;
    }

    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * 
     */
    @JsonProperty("idToken")
    public void setIdToken(IdToken idToken) {
        this.idToken = idToken;
    }

    public TransactionEventRequest withIdToken(IdToken idToken) {
        this.idToken = idToken;
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

    public TransactionEventRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TransactionEventRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("costDetails");
        sb.append('=');
        sb.append(((this.costDetails == null)?"<null>":this.costDetails));
        sb.append(',');
        sb.append("eventType");
        sb.append('=');
        sb.append(((this.eventType == null)?"<null>":this.eventType));
        sb.append(',');
        sb.append("meterValue");
        sb.append('=');
        sb.append(((this.meterValue == null)?"<null>":this.meterValue));
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("triggerReason");
        sb.append('=');
        sb.append(((this.triggerReason == null)?"<null>":this.triggerReason));
        sb.append(',');
        sb.append("seqNo");
        sb.append('=');
        sb.append(this.seqNo);
        sb.append(',');
        sb.append("offline");
        sb.append('=');
        sb.append(this.offline);
        sb.append(',');
        sb.append("numberOfPhasesUsed");
        sb.append('=');
        sb.append(this.numberOfPhasesUsed);
        sb.append(',');
        sb.append("cableMaxCurrent");
        sb.append('=');
        sb.append(this.cableMaxCurrent);
        sb.append(',');
        sb.append("reservationId");
        sb.append('=');
        sb.append(this.reservationId);
        sb.append(',');
        sb.append("preconditioningStatus");
        sb.append('=');
        sb.append(((this.preconditioningStatus == null)?"<null>":this.preconditioningStatus));
        sb.append(',');
        sb.append("evseSleep");
        sb.append('=');
        sb.append(this.evseSleep);
        sb.append(',');
        sb.append("transactionInfo");
        sb.append('=');
        sb.append(((this.transactionInfo == null)?"<null>":this.transactionInfo));
        sb.append(',');
        sb.append("evse");
        sb.append('=');
        sb.append(((this.evse == null)?"<null>":this.evse));
        sb.append(',');
        sb.append("idToken");
        sb.append('=');
        sb.append(((this.idToken == null)?"<null>":this.idToken));
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
        result = ((result* 31)+((this.preconditioningStatus == null)? 0 :this.preconditioningStatus.hashCode()));
        result = ((result* 31)+(this.evseSleep? 1 : 0));
        result = ((result* 31)+ this.seqNo);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.eventType == null)? 0 :this.eventType.hashCode()));
        result = ((result* 31)+((this.evse == null)? 0 :this.evse.hashCode()));
        result = ((result* 31)+((this.transactionInfo == null)? 0 :this.transactionInfo.hashCode()));
        result = ((result* 31)+(this.offline? 1 : 0));
        result = ((result* 31)+ this.reservationId);
        result = ((result* 31)+((this.costDetails == null)? 0 :this.costDetails.hashCode()));
        result = ((result* 31)+((this.triggerReason == null)? 0 :this.triggerReason.hashCode()));
        result = ((result* 31)+((this.idToken == null)? 0 :this.idToken.hashCode()));
        result = ((result* 31)+((this.meterValue == null)? 0 :this.meterValue.hashCode()));
        result = ((result* 31)+ this.cableMaxCurrent);
        result = ((result* 31)+ this.numberOfPhasesUsed);
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionEventRequest) == false) {
            return false;
        }
        TransactionEventRequest rhs = ((TransactionEventRequest) other);
        return (((((((((((((((((this.preconditioningStatus == rhs.preconditioningStatus)||((this.preconditioningStatus!= null)&&this.preconditioningStatus.equals(rhs.preconditioningStatus)))&&(this.evseSleep == rhs.evseSleep))&&(this.seqNo == rhs.seqNo))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.eventType == rhs.eventType)||((this.eventType!= null)&&this.eventType.equals(rhs.eventType))))&&((this.evse == rhs.evse)||((this.evse!= null)&&this.evse.equals(rhs.evse))))&&((this.transactionInfo == rhs.transactionInfo)||((this.transactionInfo!= null)&&this.transactionInfo.equals(rhs.transactionInfo))))&&(this.offline == rhs.offline))&&(this.reservationId == rhs.reservationId))&&((this.costDetails == rhs.costDetails)||((this.costDetails!= null)&&this.costDetails.equals(rhs.costDetails))))&&((this.triggerReason == rhs.triggerReason)||((this.triggerReason!= null)&&this.triggerReason.equals(rhs.triggerReason))))&&((this.idToken == rhs.idToken)||((this.idToken!= null)&&this.idToken.equals(rhs.idToken))))&&((this.meterValue == rhs.meterValue)||((this.meterValue!= null)&&this.meterValue.equals(rhs.meterValue))))&&(this.cableMaxCurrent == rhs.cableMaxCurrent))&&(this.numberOfPhasesUsed == rhs.numberOfPhasesUsed))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))));
    }

}
