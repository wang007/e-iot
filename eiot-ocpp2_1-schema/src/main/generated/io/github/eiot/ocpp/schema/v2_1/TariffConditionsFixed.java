
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;


/**
 * These conditions describe if a FixedPrice applies at start of the transaction.
 * 
 * When more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.
 * 
 * NOTE: _startTimeOfDay_ and _endTimeOfDay_ are in local time, because it is the time in the tariff as it is shown to the EV driver at the Charging Station.
 * A Charging Station will convert this to the internal time zone that it uses (which is recommended to be UTC, see section Generic chapter 3.1) when performing cost calculation.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "startTimeOfDay",
    "endTimeOfDay",
    "dayOfWeek",
    "validFromDate",
    "validToDate",
    "evseKind",
    "paymentBrand",
    "paymentRecognition",
    "customData"
})
public class TariffConditionsFixed {

    /**
     * Start time of day in local time. +
     * Format as per RFC 3339: time-hour ":" time-minute  +
     * Must be in 24h format with leading zeros. Hour/Minute separator: ":"
     * Regex: ([0-1][0-9]\|2[0-3]):[0-5][0-9]
     * 
     * 
     */
    @JsonProperty("startTimeOfDay")
    @JsonPropertyDescription("Start time of day in local time. +\r\nFormat as per RFC 3339: time-hour \":\" time-minute  +\r\nMust be in 24h format with leading zeros. Hour/Minute separator: \":\"\r\nRegex: ([0-1][0-9]\\|2[0-3]):[0-5][0-9]\r\n")
    private String startTimeOfDay;
    /**
     * End time of day in local time. Same syntax as _startTimeOfDay_. +
     *     If end time &lt; start time then the period wraps around to the next day. +
     *     To stop at end of the day use: 00:00.
     * 
     * 
     */
    @JsonProperty("endTimeOfDay")
    @JsonPropertyDescription("End time of day in local time. Same syntax as _startTimeOfDay_. +\r\n    If end time &lt; start time then the period wraps around to the next day. +\r\n    To stop at end of the day use: 00:00.\r\n")
    private String endTimeOfDay;
    /**
     * Day(s) of the week this is tariff applies.
     * 
     * 
     */
    @JsonProperty("dayOfWeek")
    @JsonPropertyDescription("Day(s) of the week this is tariff applies.\r\n")
    @Size(min = 1, max = 7)
    @Valid
    private List<DayOfWeekEnum> dayOfWeek = new ArrayList<DayOfWeekEnum>();
    /**
     * Start date in local time, for example: 2015-12-24.
     * Valid from this day (inclusive). +
     * Format as per RFC 3339: full-date  + 
     * 
     * Regex: ([12][0-9]{3})-(0[1-9]\|1[0-2])-(0[1-9]\|[12][0-9]\|3[01])
     * 
     * 
     */
    @JsonProperty("validFromDate")
    @JsonPropertyDescription("Start date in local time, for example: 2015-12-24.\r\nValid from this day (inclusive). +\r\nFormat as per RFC 3339: full-date  + \r\n\r\nRegex: ([12][0-9]{3})-(0[1-9]\\|1[0-2])-(0[1-9]\\|[12][0-9]\\|3[01])\r\n")
    private String validFromDate;
    /**
     * End date in local time, for example: 2015-12-27.
     *     Valid until this day (exclusive). Same syntax as _validFromDate_.
     * 
     * 
     */
    @JsonProperty("validToDate")
    @JsonPropertyDescription("End date in local time, for example: 2015-12-27.\r\n    Valid until this day (exclusive). Same syntax as _validFromDate_.\r\n")
    private String validToDate;
    /**
     * Type of EVSE (AC, DC) this tariff applies to.
     * 
     * 
     */
    @JsonProperty("evseKind")
    @JsonPropertyDescription("Type of EVSE (AC, DC) this tariff applies to.\r\n")
    private EvseKindEnum evseKind;
    /**
     * For which payment brand this (adhoc) tariff applies. Can be used to add a surcharge for certain payment brands.
     *     Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = "PaymentBrand".
     * 
     * 
     */
    @JsonProperty("paymentBrand")
    @JsonPropertyDescription("For which payment brand this (adhoc) tariff applies. Can be used to add a surcharge for certain payment brands.\r\n    Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = \"PaymentBrand\".\r\n")
    @Size(max = 20)
    private String paymentBrand;
    /**
     * Type of adhoc payment, e.g. CC, Debit.
     *     Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = "PaymentRecognition".
     * 
     * 
     */
    @JsonProperty("paymentRecognition")
    @JsonPropertyDescription("Type of adhoc payment, e.g. CC, Debit.\r\n    Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = \"PaymentRecognition\".\r\n")
    @Size(max = 20)
    private String paymentRecognition;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Start time of day in local time. +
     * Format as per RFC 3339: time-hour ":" time-minute  +
     * Must be in 24h format with leading zeros. Hour/Minute separator: ":"
     * Regex: ([0-1][0-9]\|2[0-3]):[0-5][0-9]
     * 
     * 
     */
    @JsonProperty("startTimeOfDay")
    public String getStartTimeOfDay() {
        return startTimeOfDay;
    }

    /**
     * Start time of day in local time. +
     * Format as per RFC 3339: time-hour ":" time-minute  +
     * Must be in 24h format with leading zeros. Hour/Minute separator: ":"
     * Regex: ([0-1][0-9]\|2[0-3]):[0-5][0-9]
     * 
     * 
     */
    @JsonProperty("startTimeOfDay")
    public void setStartTimeOfDay(String startTimeOfDay) {
        this.startTimeOfDay = startTimeOfDay;
    }

    public TariffConditionsFixed withStartTimeOfDay(String startTimeOfDay) {
        this.startTimeOfDay = startTimeOfDay;
        return this;
    }

    /**
     * End time of day in local time. Same syntax as _startTimeOfDay_. +
     *     If end time &lt; start time then the period wraps around to the next day. +
     *     To stop at end of the day use: 00:00.
     * 
     * 
     */
    @JsonProperty("endTimeOfDay")
    public String getEndTimeOfDay() {
        return endTimeOfDay;
    }

    /**
     * End time of day in local time. Same syntax as _startTimeOfDay_. +
     *     If end time &lt; start time then the period wraps around to the next day. +
     *     To stop at end of the day use: 00:00.
     * 
     * 
     */
    @JsonProperty("endTimeOfDay")
    public void setEndTimeOfDay(String endTimeOfDay) {
        this.endTimeOfDay = endTimeOfDay;
    }

    public TariffConditionsFixed withEndTimeOfDay(String endTimeOfDay) {
        this.endTimeOfDay = endTimeOfDay;
        return this;
    }

    /**
     * Day(s) of the week this is tariff applies.
     * 
     * 
     */
    @JsonProperty("dayOfWeek")
    public List<DayOfWeekEnum> getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Day(s) of the week this is tariff applies.
     * 
     * 
     */
    @JsonProperty("dayOfWeek")
    public void setDayOfWeek(List<DayOfWeekEnum> dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public TariffConditionsFixed withDayOfWeek(List<DayOfWeekEnum> dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    /**
     * Start date in local time, for example: 2015-12-24.
     * Valid from this day (inclusive). +
     * Format as per RFC 3339: full-date  + 
     * 
     * Regex: ([12][0-9]{3})-(0[1-9]\|1[0-2])-(0[1-9]\|[12][0-9]\|3[01])
     * 
     * 
     */
    @JsonProperty("validFromDate")
    public String getValidFromDate() {
        return validFromDate;
    }

    /**
     * Start date in local time, for example: 2015-12-24.
     * Valid from this day (inclusive). +
     * Format as per RFC 3339: full-date  + 
     * 
     * Regex: ([12][0-9]{3})-(0[1-9]\|1[0-2])-(0[1-9]\|[12][0-9]\|3[01])
     * 
     * 
     */
    @JsonProperty("validFromDate")
    public void setValidFromDate(String validFromDate) {
        this.validFromDate = validFromDate;
    }

    public TariffConditionsFixed withValidFromDate(String validFromDate) {
        this.validFromDate = validFromDate;
        return this;
    }

    /**
     * End date in local time, for example: 2015-12-27.
     *     Valid until this day (exclusive). Same syntax as _validFromDate_.
     * 
     * 
     */
    @JsonProperty("validToDate")
    public String getValidToDate() {
        return validToDate;
    }

    /**
     * End date in local time, for example: 2015-12-27.
     *     Valid until this day (exclusive). Same syntax as _validFromDate_.
     * 
     * 
     */
    @JsonProperty("validToDate")
    public void setValidToDate(String validToDate) {
        this.validToDate = validToDate;
    }

    public TariffConditionsFixed withValidToDate(String validToDate) {
        this.validToDate = validToDate;
        return this;
    }

    /**
     * Type of EVSE (AC, DC) this tariff applies to.
     * 
     * 
     */
    @JsonProperty("evseKind")
    public EvseKindEnum getEvseKind() {
        return evseKind;
    }

    /**
     * Type of EVSE (AC, DC) this tariff applies to.
     * 
     * 
     */
    @JsonProperty("evseKind")
    public void setEvseKind(EvseKindEnum evseKind) {
        this.evseKind = evseKind;
    }

    public TariffConditionsFixed withEvseKind(EvseKindEnum evseKind) {
        this.evseKind = evseKind;
        return this;
    }

    /**
     * For which payment brand this (adhoc) tariff applies. Can be used to add a surcharge for certain payment brands.
     *     Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = "PaymentBrand".
     * 
     * 
     */
    @JsonProperty("paymentBrand")
    public String getPaymentBrand() {
        return paymentBrand;
    }

    /**
     * For which payment brand this (adhoc) tariff applies. Can be used to add a surcharge for certain payment brands.
     *     Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = "PaymentBrand".
     * 
     * 
     */
    @JsonProperty("paymentBrand")
    public void setPaymentBrand(String paymentBrand) {
        this.paymentBrand = paymentBrand;
    }

    public TariffConditionsFixed withPaymentBrand(String paymentBrand) {
        this.paymentBrand = paymentBrand;
        return this;
    }

    /**
     * Type of adhoc payment, e.g. CC, Debit.
     *     Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = "PaymentRecognition".
     * 
     * 
     */
    @JsonProperty("paymentRecognition")
    public String getPaymentRecognition() {
        return paymentRecognition;
    }

    /**
     * Type of adhoc payment, e.g. CC, Debit.
     *     Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = "PaymentRecognition".
     * 
     * 
     */
    @JsonProperty("paymentRecognition")
    public void setPaymentRecognition(String paymentRecognition) {
        this.paymentRecognition = paymentRecognition;
    }

    public TariffConditionsFixed withPaymentRecognition(String paymentRecognition) {
        this.paymentRecognition = paymentRecognition;
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

    public TariffConditionsFixed withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TariffConditionsFixed.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("startTimeOfDay");
        sb.append('=');
        sb.append(((this.startTimeOfDay == null)?"<null>":this.startTimeOfDay));
        sb.append(',');
        sb.append("endTimeOfDay");
        sb.append('=');
        sb.append(((this.endTimeOfDay == null)?"<null>":this.endTimeOfDay));
        sb.append(',');
        sb.append("dayOfWeek");
        sb.append('=');
        sb.append(((this.dayOfWeek == null)?"<null>":this.dayOfWeek));
        sb.append(',');
        sb.append("validFromDate");
        sb.append('=');
        sb.append(((this.validFromDate == null)?"<null>":this.validFromDate));
        sb.append(',');
        sb.append("validToDate");
        sb.append('=');
        sb.append(((this.validToDate == null)?"<null>":this.validToDate));
        sb.append(',');
        sb.append("evseKind");
        sb.append('=');
        sb.append(((this.evseKind == null)?"<null>":this.evseKind));
        sb.append(',');
        sb.append("paymentBrand");
        sb.append('=');
        sb.append(((this.paymentBrand == null)?"<null>":this.paymentBrand));
        sb.append(',');
        sb.append("paymentRecognition");
        sb.append('=');
        sb.append(((this.paymentRecognition == null)?"<null>":this.paymentRecognition));
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
        result = ((result* 31)+((this.evseKind == null)? 0 :this.evseKind.hashCode()));
        result = ((result* 31)+((this.paymentRecognition == null)? 0 :this.paymentRecognition.hashCode()));
        result = ((result* 31)+((this.dayOfWeek == null)? 0 :this.dayOfWeek.hashCode()));
        result = ((result* 31)+((this.paymentBrand == null)? 0 :this.paymentBrand.hashCode()));
        result = ((result* 31)+((this.endTimeOfDay == null)? 0 :this.endTimeOfDay.hashCode()));
        result = ((result* 31)+((this.validFromDate == null)? 0 :this.validFromDate.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.startTimeOfDay == null)? 0 :this.startTimeOfDay.hashCode()));
        result = ((result* 31)+((this.validToDate == null)? 0 :this.validToDate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TariffConditionsFixed) == false) {
            return false;
        }
        TariffConditionsFixed rhs = ((TariffConditionsFixed) other);
        return ((((((((((this.evseKind == rhs.evseKind)||((this.evseKind!= null)&&this.evseKind.equals(rhs.evseKind)))&&((this.paymentRecognition == rhs.paymentRecognition)||((this.paymentRecognition!= null)&&this.paymentRecognition.equals(rhs.paymentRecognition))))&&((this.dayOfWeek == rhs.dayOfWeek)||((this.dayOfWeek!= null)&&this.dayOfWeek.equals(rhs.dayOfWeek))))&&((this.paymentBrand == rhs.paymentBrand)||((this.paymentBrand!= null)&&this.paymentBrand.equals(rhs.paymentBrand))))&&((this.endTimeOfDay == rhs.endTimeOfDay)||((this.endTimeOfDay!= null)&&this.endTimeOfDay.equals(rhs.endTimeOfDay))))&&((this.validFromDate == rhs.validFromDate)||((this.validFromDate!= null)&&this.validFromDate.equals(rhs.validFromDate))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.startTimeOfDay == rhs.startTimeOfDay)||((this.startTimeOfDay!= null)&&this.startTimeOfDay.equals(rhs.startTimeOfDay))))&&((this.validToDate == rhs.validToDate)||((this.validToDate!= null)&&this.validToDate.equals(rhs.validToDate))));
    }

}
