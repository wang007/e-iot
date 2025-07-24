
package io.github.eiot.ocpp.schema.v1_6;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chargingProfileId",
    "transactionId",
    "stackLevel",
    "chargingProfilePurpose",
    "chargingProfileKind",
    "recurrencyKind",
    "validFrom",
    "validTo",
    "chargingSchedule"
})
public class ChargingProfile {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileId")
    @NotNull
    private int chargingProfileId;
    @JsonProperty("transactionId")
    private int transactionId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("stackLevel")
    @NotNull
    private int stackLevel;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    @NotNull
    private ChargingProfile.ChargingProfilePurpose chargingProfilePurpose;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileKind")
    @NotNull
    private ChargingProfile.ChargingProfileKind chargingProfileKind;
    @JsonProperty("recurrencyKind")
    private ChargingProfile.RecurrencyKind recurrencyKind;
    @JsonProperty("validFrom")
    private OffsetDateTime validFrom;
    @JsonProperty("validTo")
    private OffsetDateTime validTo;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    @Valid
    @NotNull
    private ChargingSchedule__1 chargingSchedule;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileId")
    public int getChargingProfileId() {
        return chargingProfileId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileId")
    public void setChargingProfileId(int chargingProfileId) {
        this.chargingProfileId = chargingProfileId;
    }

    public ChargingProfile withChargingProfileId(int chargingProfileId) {
        this.chargingProfileId = chargingProfileId;
        return this;
    }

    @JsonProperty("transactionId")
    public int getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transactionId")
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public ChargingProfile withTransactionId(int transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("stackLevel")
    public int getStackLevel() {
        return stackLevel;
    }

    /**
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    public ChargingProfile.ChargingProfilePurpose getChargingProfilePurpose() {
        return chargingProfilePurpose;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    public void setChargingProfilePurpose(ChargingProfile.ChargingProfilePurpose chargingProfilePurpose) {
        this.chargingProfilePurpose = chargingProfilePurpose;
    }

    public ChargingProfile withChargingProfilePurpose(ChargingProfile.ChargingProfilePurpose chargingProfilePurpose) {
        this.chargingProfilePurpose = chargingProfilePurpose;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileKind")
    public ChargingProfile.ChargingProfileKind getChargingProfileKind() {
        return chargingProfileKind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileKind")
    public void setChargingProfileKind(ChargingProfile.ChargingProfileKind chargingProfileKind) {
        this.chargingProfileKind = chargingProfileKind;
    }

    public ChargingProfile withChargingProfileKind(ChargingProfile.ChargingProfileKind chargingProfileKind) {
        this.chargingProfileKind = chargingProfileKind;
        return this;
    }

    @JsonProperty("recurrencyKind")
    public ChargingProfile.RecurrencyKind getRecurrencyKind() {
        return recurrencyKind;
    }

    @JsonProperty("recurrencyKind")
    public void setRecurrencyKind(ChargingProfile.RecurrencyKind recurrencyKind) {
        this.recurrencyKind = recurrencyKind;
    }

    public ChargingProfile withRecurrencyKind(ChargingProfile.RecurrencyKind recurrencyKind) {
        this.recurrencyKind = recurrencyKind;
        return this;
    }

    @JsonProperty("validFrom")
    public OffsetDateTime getValidFrom() {
        return validFrom;
    }

    @JsonProperty("validFrom")
    public void setValidFrom(OffsetDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public ChargingProfile withValidFrom(OffsetDateTime validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    @JsonProperty("validTo")
    public OffsetDateTime getValidTo() {
        return validTo;
    }

    @JsonProperty("validTo")
    public void setValidTo(OffsetDateTime validTo) {
        this.validTo = validTo;
    }

    public ChargingProfile withValidTo(OffsetDateTime validTo) {
        this.validTo = validTo;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    public ChargingSchedule__1 getChargingSchedule() {
        return chargingSchedule;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    public void setChargingSchedule(ChargingSchedule__1 chargingSchedule) {
        this.chargingSchedule = chargingSchedule;
    }

    public ChargingProfile withChargingSchedule(ChargingSchedule__1 chargingSchedule) {
        this.chargingSchedule = chargingSchedule;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("chargingProfileId");
        sb.append('=');
        sb.append(this.chargingProfileId);
        sb.append(',');
        sb.append("transactionId");
        sb.append('=');
        sb.append(this.transactionId);
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
        sb.append("chargingSchedule");
        sb.append('=');
        sb.append(((this.chargingSchedule == null)?"<null>":this.chargingSchedule));
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
        result = ((result* 31)+((this.chargingProfileKind == null)? 0 :this.chargingProfileKind.hashCode()));
        result = ((result* 31)+((this.chargingProfilePurpose == null)? 0 :this.chargingProfilePurpose.hashCode()));
        result = ((result* 31)+((this.recurrencyKind == null)? 0 :this.recurrencyKind.hashCode()));
        result = ((result* 31)+((this.chargingSchedule == null)? 0 :this.chargingSchedule.hashCode()));
        result = ((result* 31)+ this.chargingProfileId);
        result = ((result* 31)+((this.validFrom == null)? 0 :this.validFrom.hashCode()));
        result = ((result* 31)+ this.stackLevel);
        result = ((result* 31)+ this.transactionId);
        result = ((result* 31)+((this.validTo == null)? 0 :this.validTo.hashCode()));
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
        return ((((((((((this.chargingProfileKind == rhs.chargingProfileKind)||((this.chargingProfileKind!= null)&&this.chargingProfileKind.equals(rhs.chargingProfileKind)))&&((this.chargingProfilePurpose == rhs.chargingProfilePurpose)||((this.chargingProfilePurpose!= null)&&this.chargingProfilePurpose.equals(rhs.chargingProfilePurpose))))&&((this.recurrencyKind == rhs.recurrencyKind)||((this.recurrencyKind!= null)&&this.recurrencyKind.equals(rhs.recurrencyKind))))&&((this.chargingSchedule == rhs.chargingSchedule)||((this.chargingSchedule!= null)&&this.chargingSchedule.equals(rhs.chargingSchedule))))&&(this.chargingProfileId == rhs.chargingProfileId))&&((this.validFrom == rhs.validFrom)||((this.validFrom!= null)&&this.validFrom.equals(rhs.validFrom))))&&(this.stackLevel == rhs.stackLevel))&&(this.transactionId == rhs.transactionId))&&((this.validTo == rhs.validTo)||((this.validTo!= null)&&this.validTo.equals(rhs.validTo))));
    }

    public enum ChargingProfileKind {

        ABSOLUTE("Absolute"),
        RECURRING("Recurring"),
        RELATIVE("Relative");
        private final String value;
        private final static Map<String, ChargingProfile.ChargingProfileKind> CONSTANTS = new HashMap<String, ChargingProfile.ChargingProfileKind>();

        static {
            for (ChargingProfile.ChargingProfileKind c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        ChargingProfileKind(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static ChargingProfile.ChargingProfileKind fromValue(String value) {
            ChargingProfile.ChargingProfileKind constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum ChargingProfilePurpose {

        CHARGE_POINT_MAX_PROFILE("ChargePointMaxProfile"),
        TX_DEFAULT_PROFILE("TxDefaultProfile"),
        TX_PROFILE("TxProfile");
        private final String value;
        private final static Map<String, ChargingProfile.ChargingProfilePurpose> CONSTANTS = new HashMap<String, ChargingProfile.ChargingProfilePurpose>();

        static {
            for (ChargingProfile.ChargingProfilePurpose c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        ChargingProfilePurpose(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static ChargingProfile.ChargingProfilePurpose fromValue(String value) {
            ChargingProfile.ChargingProfilePurpose constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum RecurrencyKind {

        DAILY("Daily"),
        WEEKLY("Weekly");
        private final String value;
        private final static Map<String, ChargingProfile.RecurrencyKind> CONSTANTS = new HashMap<String, ChargingProfile.RecurrencyKind>();

        static {
            for (ChargingProfile.RecurrencyKind c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        RecurrencyKind(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static ChargingProfile.RecurrencyKind fromValue(String value) {
            ChargingProfile.RecurrencyKind constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
