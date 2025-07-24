
package io.github.eiot.ocpp.schema.v2_1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * A ChargingProfile consists of 1 to 3 ChargingSchedules with a list of ChargingSchedulePeriods, describing the amount of power or current that can be delivered per time interval.
 * 
 * image::images/ChargingProfile-Simple.png[]
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "stackLevel",
    "chargingProfilePurpose",
    "chargingProfileKind",
    "recurrencyKind",
    "validFrom",
    "validTo",
    "transactionId",
    "maxOfflineDuration",
    "chargingSchedule",
    "invalidAfterOfflineDuration",
    "dynUpdateInterval",
    "dynUpdateTime",
    "priceScheduleSignature",
    "customData"
})
public class ChargingProfile {

    /**
     * Id of ChargingProfile. Unique within charging station. Id can have a negative value. This is useful to distinguish charging profiles from an external actor (external constraints) from charging profiles received from CSMS.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Id of ChargingProfile. Unique within charging station. Id can have a negative value. This is useful to distinguish charging profiles from an external actor (external constraints) from charging profiles received from CSMS.\r\n")
    @NotNull
    private int id;
    /**
     * Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("stackLevel")
    @JsonPropertyDescription("Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.\r\n")
    @DecimalMin("0")
    @NotNull
    private int stackLevel;
    /**
     * Defines the purpose of the schedule transferred by this profile
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    @JsonPropertyDescription("Defines the purpose of the schedule transferred by this profile\r\n")
    @NotNull
    private ChargingProfilePurposeEnum chargingProfilePurpose;
    /**
     * Indicates the kind of schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileKind")
    @JsonPropertyDescription("Indicates the kind of schedule.\r\n")
    @NotNull
    private ChargingProfileKindEnum chargingProfileKind;
    /**
     * Indicates the start point of a recurrence.
     * 
     * 
     */
    @JsonProperty("recurrencyKind")
    @JsonPropertyDescription("Indicates the start point of a recurrence.\r\n")
    private RecurrencyKindEnum recurrencyKind;
    /**
     * Point in time at which the profile starts to be valid. If absent, the profile is valid as soon as it is received by the Charging Station.
     * 
     * 
     */
    @JsonProperty("validFrom")
    @JsonPropertyDescription("Point in time at which the profile starts to be valid. If absent, the profile is valid as soon as it is received by the Charging Station.\r\n")
    private OffsetDateTime validFrom;
    /**
     * Point in time at which the profile stops to be valid. If absent, the profile is valid until it is replaced by another profile.
     * 
     * 
     */
    @JsonProperty("validTo")
    @JsonPropertyDescription("Point in time at which the profile stops to be valid. If absent, the profile is valid until it is replaced by another profile.\r\n")
    private OffsetDateTime validTo;
    /**
     * SHALL only be included if ChargingProfilePurpose is set to TxProfile in a SetChargingProfileRequest. The transactionId is used to match the profile to a specific transaction.
     * 
     * 
     */
    @JsonProperty("transactionId")
    @JsonPropertyDescription("SHALL only be included if ChargingProfilePurpose is set to TxProfile in a SetChargingProfileRequest. The transactionId is used to match the profile to a specific transaction.\r\n")
    @Size(max = 36)
    private String transactionId;
    /**
     * *(2.1)* Period in seconds that this charging profile remains valid after the Charging Station has gone offline. After this period the charging profile becomes invalid for as long as it is offline and the Charging Station reverts back to a valid profile with a lower stack level. 
     * If _invalidAfterOfflineDuration_ is true, then this charging profile will become permanently invalid.
     * A value of 0 means that the charging profile is immediately invalid while offline. When the field is absent, then  no timeout applies and the charging profile remains valid when offline.
     * 
     * 
     */
    @JsonProperty("maxOfflineDuration")
    @JsonPropertyDescription("*(2.1)* Period in seconds that this charging profile remains valid after the Charging Station has gone offline. After this period the charging profile becomes invalid for as long as it is offline and the Charging Station reverts back to a valid profile with a lower stack level. \r\nIf _invalidAfterOfflineDuration_ is true, then this charging profile will become permanently invalid.\r\nA value of 0 means that the charging profile is immediately invalid while offline. When the field is absent, then  no timeout applies and the charging profile remains valid when offline.\r\n")
    private int maxOfflineDuration;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    @Size(min = 1, max = 3)
    @Valid
    @NotNull
    private List<ChargingSchedule> chargingSchedule = new ArrayList<ChargingSchedule>();
    /**
     * *(2.1)* When set to true this charging profile will not be valid anymore after being offline for more than _maxOfflineDuration_. +
     *     When absent defaults to false.
     * 
     * 
     */
    @JsonProperty("invalidAfterOfflineDuration")
    @JsonPropertyDescription("*(2.1)* When set to true this charging profile will not be valid anymore after being offline for more than _maxOfflineDuration_. +\r\n    When absent defaults to false.\r\n")
    private boolean invalidAfterOfflineDuration;
    /**
     * *(2.1)*  Interval in seconds after receipt of last update, when to request a profile update by sending a PullDynamicScheduleUpdateRequest message.
     *     A value of 0 or no value means that no update interval applies. +
     *     Only relevant in a dynamic charging profile.
     * 
     * 
     * 
     */
    @JsonProperty("dynUpdateInterval")
    @JsonPropertyDescription("*(2.1)*  Interval in seconds after receipt of last update, when to request a profile update by sending a PullDynamicScheduleUpdateRequest message.\r\n    A value of 0 or no value means that no update interval applies. +\r\n    Only relevant in a dynamic charging profile.\r\n\r\n")
    private int dynUpdateInterval;
    /**
     * *(2.1)* Time at which limits or setpoints in this charging profile were last updated by a PullDynamicScheduleUpdateRequest or UpdateDynamicScheduleRequest or by an external actor. +
     *     Only relevant in a dynamic charging profile.
     * 
     * 
     * 
     */
    @JsonProperty("dynUpdateTime")
    @JsonPropertyDescription("*(2.1)* Time at which limits or setpoints in this charging profile were last updated by a PullDynamicScheduleUpdateRequest or UpdateDynamicScheduleRequest or by an external actor. +\r\n    Only relevant in a dynamic charging profile.\r\n\r\n")
    private OffsetDateTime dynUpdateTime;
    /**
     * *(2.1)* ISO 15118-20 signature for all price schedules in _chargingSchedules_. +
     * Note: for 256-bit elliptic curves (like secp256k1) the ECDSA signature is 512 bits (64 bytes) and for 521-bit curves (like secp521r1) the signature is 1042 bits. This equals 131 bytes, which can be encoded as base64 in 176 bytes.
     * 
     * 
     */
    @JsonProperty("priceScheduleSignature")
    @JsonPropertyDescription("*(2.1)* ISO 15118-20 signature for all price schedules in _chargingSchedules_. +\r\nNote: for 256-bit elliptic curves (like secp256k1) the ECDSA signature is 512 bits (64 bytes) and for 521-bit curves (like secp521r1) the signature is 1042 bits. This equals 131 bytes, which can be encoded as base64 in 176 bytes.\r\n")
    @Size(max = 256)
    private String priceScheduleSignature;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Id of ChargingProfile. Unique within charging station. Id can have a negative value. This is useful to distinguish charging profiles from an external actor (external constraints) from charging profiles received from CSMS.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * Id of ChargingProfile. Unique within charging station. Id can have a negative value. This is useful to distinguish charging profiles from an external actor (external constraints) from charging profiles received from CSMS.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public ChargingProfile withId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("stackLevel")
    public int getStackLevel() {
        return stackLevel;
    }

    /**
     * Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("stackLevel")
    public void setStackLevel(int stackLevel) {
        this.stackLevel = stackLevel;
    }

    public ChargingProfile withStackLevel(int stackLevel) {
        this.stackLevel = stackLevel;
        return this;
    }

    /**
     * Defines the purpose of the schedule transferred by this profile
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    public ChargingProfilePurposeEnum getChargingProfilePurpose() {
        return chargingProfilePurpose;
    }

    /**
     * Defines the purpose of the schedule transferred by this profile
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    public void setChargingProfilePurpose(ChargingProfilePurposeEnum chargingProfilePurpose) {
        this.chargingProfilePurpose = chargingProfilePurpose;
    }

    public ChargingProfile withChargingProfilePurpose(ChargingProfilePurposeEnum chargingProfilePurpose) {
        this.chargingProfilePurpose = chargingProfilePurpose;
        return this;
    }

    /**
     * Indicates the kind of schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileKind")
    public ChargingProfileKindEnum getChargingProfileKind() {
        return chargingProfileKind;
    }

    /**
     * Indicates the kind of schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileKind")
    public void setChargingProfileKind(ChargingProfileKindEnum chargingProfileKind) {
        this.chargingProfileKind = chargingProfileKind;
    }

    public ChargingProfile withChargingProfileKind(ChargingProfileKindEnum chargingProfileKind) {
        this.chargingProfileKind = chargingProfileKind;
        return this;
    }

    /**
     * Indicates the start point of a recurrence.
     * 
     * 
     */
    @JsonProperty("recurrencyKind")
    public RecurrencyKindEnum getRecurrencyKind() {
        return recurrencyKind;
    }

    /**
     * Indicates the start point of a recurrence.
     * 
     * 
     */
    @JsonProperty("recurrencyKind")
    public void setRecurrencyKind(RecurrencyKindEnum recurrencyKind) {
        this.recurrencyKind = recurrencyKind;
    }

    public ChargingProfile withRecurrencyKind(RecurrencyKindEnum recurrencyKind) {
        this.recurrencyKind = recurrencyKind;
        return this;
    }

    /**
     * Point in time at which the profile starts to be valid. If absent, the profile is valid as soon as it is received by the Charging Station.
     * 
     * 
     */
    @JsonProperty("validFrom")
    public OffsetDateTime getValidFrom() {
        return validFrom;
    }

    /**
     * Point in time at which the profile starts to be valid. If absent, the profile is valid as soon as it is received by the Charging Station.
     * 
     * 
     */
    @JsonProperty("validFrom")
    public void setValidFrom(OffsetDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public ChargingProfile withValidFrom(OffsetDateTime validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    /**
     * Point in time at which the profile stops to be valid. If absent, the profile is valid until it is replaced by another profile.
     * 
     * 
     */
    @JsonProperty("validTo")
    public OffsetDateTime getValidTo() {
        return validTo;
    }

    /**
     * Point in time at which the profile stops to be valid. If absent, the profile is valid until it is replaced by another profile.
     * 
     * 
     */
    @JsonProperty("validTo")
    public void setValidTo(OffsetDateTime validTo) {
        this.validTo = validTo;
    }

    public ChargingProfile withValidTo(OffsetDateTime validTo) {
        this.validTo = validTo;
        return this;
    }

    /**
     * SHALL only be included if ChargingProfilePurpose is set to TxProfile in a SetChargingProfileRequest. The transactionId is used to match the profile to a specific transaction.
     * 
     * 
     */
    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * SHALL only be included if ChargingProfilePurpose is set to TxProfile in a SetChargingProfileRequest. The transactionId is used to match the profile to a specific transaction.
     * 
     * 
     */
    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public ChargingProfile withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * *(2.1)* Period in seconds that this charging profile remains valid after the Charging Station has gone offline. After this period the charging profile becomes invalid for as long as it is offline and the Charging Station reverts back to a valid profile with a lower stack level. 
     * If _invalidAfterOfflineDuration_ is true, then this charging profile will become permanently invalid.
     * A value of 0 means that the charging profile is immediately invalid while offline. When the field is absent, then  no timeout applies and the charging profile remains valid when offline.
     * 
     * 
     */
    @JsonProperty("maxOfflineDuration")
    public int getMaxOfflineDuration() {
        return maxOfflineDuration;
    }

    /**
     * *(2.1)* Period in seconds that this charging profile remains valid after the Charging Station has gone offline. After this period the charging profile becomes invalid for as long as it is offline and the Charging Station reverts back to a valid profile with a lower stack level. 
     * If _invalidAfterOfflineDuration_ is true, then this charging profile will become permanently invalid.
     * A value of 0 means that the charging profile is immediately invalid while offline. When the field is absent, then  no timeout applies and the charging profile remains valid when offline.
     * 
     * 
     */
    @JsonProperty("maxOfflineDuration")
    public void setMaxOfflineDuration(int maxOfflineDuration) {
        this.maxOfflineDuration = maxOfflineDuration;
    }

    public ChargingProfile withMaxOfflineDuration(int maxOfflineDuration) {
        this.maxOfflineDuration = maxOfflineDuration;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    public List<ChargingSchedule> getChargingSchedule() {
        return chargingSchedule;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    public void setChargingSchedule(List<ChargingSchedule> chargingSchedule) {
        this.chargingSchedule = chargingSchedule;
    }

    public ChargingProfile withChargingSchedule(List<ChargingSchedule> chargingSchedule) {
        this.chargingSchedule = chargingSchedule;
        return this;
    }

    /**
     * *(2.1)* When set to true this charging profile will not be valid anymore after being offline for more than _maxOfflineDuration_. +
     *     When absent defaults to false.
     * 
     * 
     */
    @JsonProperty("invalidAfterOfflineDuration")
    public boolean isInvalidAfterOfflineDuration() {
        return invalidAfterOfflineDuration;
    }

    /**
     * *(2.1)* When set to true this charging profile will not be valid anymore after being offline for more than _maxOfflineDuration_. +
     *     When absent defaults to false.
     * 
     * 
     */
    @JsonProperty("invalidAfterOfflineDuration")
    public void setInvalidAfterOfflineDuration(boolean invalidAfterOfflineDuration) {
        this.invalidAfterOfflineDuration = invalidAfterOfflineDuration;
    }

    public ChargingProfile withInvalidAfterOfflineDuration(boolean invalidAfterOfflineDuration) {
        this.invalidAfterOfflineDuration = invalidAfterOfflineDuration;
        return this;
    }

    /**
     * *(2.1)*  Interval in seconds after receipt of last update, when to request a profile update by sending a PullDynamicScheduleUpdateRequest message.
     *     A value of 0 or no value means that no update interval applies. +
     *     Only relevant in a dynamic charging profile.
     * 
     * 
     * 
     */
    @JsonProperty("dynUpdateInterval")
    public int getDynUpdateInterval() {
        return dynUpdateInterval;
    }

    /**
     * *(2.1)*  Interval in seconds after receipt of last update, when to request a profile update by sending a PullDynamicScheduleUpdateRequest message.
     *     A value of 0 or no value means that no update interval applies. +
     *     Only relevant in a dynamic charging profile.
     * 
     * 
     * 
     */
    @JsonProperty("dynUpdateInterval")
    public void setDynUpdateInterval(int dynUpdateInterval) {
        this.dynUpdateInterval = dynUpdateInterval;
    }

    public ChargingProfile withDynUpdateInterval(int dynUpdateInterval) {
        this.dynUpdateInterval = dynUpdateInterval;
        return this;
    }

    /**
     * *(2.1)* Time at which limits or setpoints in this charging profile were last updated by a PullDynamicScheduleUpdateRequest or UpdateDynamicScheduleRequest or by an external actor. +
     *     Only relevant in a dynamic charging profile.
     * 
     * 
     * 
     */
    @JsonProperty("dynUpdateTime")
    public OffsetDateTime getDynUpdateTime() {
        return dynUpdateTime;
    }

    /**
     * *(2.1)* Time at which limits or setpoints in this charging profile were last updated by a PullDynamicScheduleUpdateRequest or UpdateDynamicScheduleRequest or by an external actor. +
     *     Only relevant in a dynamic charging profile.
     * 
     * 
     * 
     */
    @JsonProperty("dynUpdateTime")
    public void setDynUpdateTime(OffsetDateTime dynUpdateTime) {
        this.dynUpdateTime = dynUpdateTime;
    }

    public ChargingProfile withDynUpdateTime(OffsetDateTime dynUpdateTime) {
        this.dynUpdateTime = dynUpdateTime;
        return this;
    }

    /**
     * *(2.1)* ISO 15118-20 signature for all price schedules in _chargingSchedules_. +
     * Note: for 256-bit elliptic curves (like secp256k1) the ECDSA signature is 512 bits (64 bytes) and for 521-bit curves (like secp521r1) the signature is 1042 bits. This equals 131 bytes, which can be encoded as base64 in 176 bytes.
     * 
     * 
     */
    @JsonProperty("priceScheduleSignature")
    public String getPriceScheduleSignature() {
        return priceScheduleSignature;
    }

    /**
     * *(2.1)* ISO 15118-20 signature for all price schedules in _chargingSchedules_. +
     * Note: for 256-bit elliptic curves (like secp256k1) the ECDSA signature is 512 bits (64 bytes) and for 521-bit curves (like secp521r1) the signature is 1042 bits. This equals 131 bytes, which can be encoded as base64 in 176 bytes.
     * 
     * 
     */
    @JsonProperty("priceScheduleSignature")
    public void setPriceScheduleSignature(String priceScheduleSignature) {
        this.priceScheduleSignature = priceScheduleSignature;
    }

    public ChargingProfile withPriceScheduleSignature(String priceScheduleSignature) {
        this.priceScheduleSignature = priceScheduleSignature;
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

    public ChargingProfile withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("stackLevel");
        sb.append('=');
        sb.append(this.stackLevel);
        sb.append(',');
        sb.append("chargingProfilePurpose");
        sb.append('=');
        sb.append(((this.chargingProfilePurpose == null)?"<null>":this.chargingProfilePurpose));
        sb.append(',');
        sb.append("chargingProfileKind");
        sb.append('=');
        sb.append(((this.chargingProfileKind == null)?"<null>":this.chargingProfileKind));
        sb.append(',');
        sb.append("recurrencyKind");
        sb.append('=');
        sb.append(((this.recurrencyKind == null)?"<null>":this.recurrencyKind));
        sb.append(',');
        sb.append("validFrom");
        sb.append('=');
        sb.append(((this.validFrom == null)?"<null>":this.validFrom));
        sb.append(',');
        sb.append("validTo");
        sb.append('=');
        sb.append(((this.validTo == null)?"<null>":this.validTo));
        sb.append(',');
        sb.append("transactionId");
        sb.append('=');
        sb.append(((this.transactionId == null)?"<null>":this.transactionId));
        sb.append(',');
        sb.append("maxOfflineDuration");
        sb.append('=');
        sb.append(this.maxOfflineDuration);
        sb.append(',');
        sb.append("chargingSchedule");
        sb.append('=');
        sb.append(((this.chargingSchedule == null)?"<null>":this.chargingSchedule));
        sb.append(',');
        sb.append("invalidAfterOfflineDuration");
        sb.append('=');
        sb.append(this.invalidAfterOfflineDuration);
        sb.append(',');
        sb.append("dynUpdateInterval");
        sb.append('=');
        sb.append(this.dynUpdateInterval);
        sb.append(',');
        sb.append("dynUpdateTime");
        sb.append('=');
        sb.append(((this.dynUpdateTime == null)?"<null>":this.dynUpdateTime));
        sb.append(',');
        sb.append("priceScheduleSignature");
        sb.append('=');
        sb.append(((this.priceScheduleSignature == null)?"<null>":this.priceScheduleSignature));
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
        result = ((result* 31)+((this.recurrencyKind == null)? 0 :this.recurrencyKind.hashCode()));
        result = ((result* 31)+((this.chargingSchedule == null)? 0 :this.chargingSchedule.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.validFrom == null)? 0 :this.validFrom.hashCode()));
        result = ((result* 31)+ this.stackLevel);
        result = ((result* 31)+((this.priceScheduleSignature == null)? 0 :this.priceScheduleSignature.hashCode()));
        result = ((result* 31)+((this.transactionId == null)? 0 :this.transactionId.hashCode()));
        result = ((result* 31)+((this.chargingProfileKind == null)? 0 :this.chargingProfileKind.hashCode()));
        result = ((result* 31)+((this.chargingProfilePurpose == null)? 0 :this.chargingProfilePurpose.hashCode()));
        result = ((result* 31)+(this.invalidAfterOfflineDuration? 1 : 0));
        result = ((result* 31)+((this.dynUpdateTime == null)? 0 :this.dynUpdateTime.hashCode()));
        result = ((result* 31)+ this.id);
        result = ((result* 31)+ this.maxOfflineDuration);
        result = ((result* 31)+((this.validTo == null)? 0 :this.validTo.hashCode()));
        result = ((result* 31)+ this.dynUpdateInterval);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingProfile) == false) {
            return false;
        }
        ChargingProfile rhs = ((ChargingProfile) other);
        return ((((((((((((((((this.recurrencyKind == rhs.recurrencyKind)||((this.recurrencyKind!= null)&&this.recurrencyKind.equals(rhs.recurrencyKind)))&&((this.chargingSchedule == rhs.chargingSchedule)||((this.chargingSchedule!= null)&&this.chargingSchedule.equals(rhs.chargingSchedule))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.validFrom == rhs.validFrom)||((this.validFrom!= null)&&this.validFrom.equals(rhs.validFrom))))&&(this.stackLevel == rhs.stackLevel))&&((this.priceScheduleSignature == rhs.priceScheduleSignature)||((this.priceScheduleSignature!= null)&&this.priceScheduleSignature.equals(rhs.priceScheduleSignature))))&&((this.transactionId == rhs.transactionId)||((this.transactionId!= null)&&this.transactionId.equals(rhs.transactionId))))&&((this.chargingProfileKind == rhs.chargingProfileKind)||((this.chargingProfileKind!= null)&&this.chargingProfileKind.equals(rhs.chargingProfileKind))))&&((this.chargingProfilePurpose == rhs.chargingProfilePurpose)||((this.chargingProfilePurpose!= null)&&this.chargingProfilePurpose.equals(rhs.chargingProfilePurpose))))&&(this.invalidAfterOfflineDuration == rhs.invalidAfterOfflineDuration))&&((this.dynUpdateTime == rhs.dynUpdateTime)||((this.dynUpdateTime!= null)&&this.dynUpdateTime.equals(rhs.dynUpdateTime))))&&(this.id == rhs.id))&&(this.maxOfflineDuration == rhs.maxOfflineDuration))&&((this.validTo == rhs.validTo)||((this.validTo!= null)&&this.validTo.equals(rhs.validTo))))&&(this.dynUpdateInterval == rhs.dynUpdateInterval));
    }

}
