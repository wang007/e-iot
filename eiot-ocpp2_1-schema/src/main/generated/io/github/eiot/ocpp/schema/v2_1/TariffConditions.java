
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
 * These conditions describe if and when a TariffEnergyType or TariffTimeType applies during a transaction.
 * 
 * When more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.
 * 
 * For reverse energy flow (discharging) negative values of energy, power and current are used.
 * 
 * NOTE: _minXXX_ (where XXX = Kwh/A/Kw) must be read as "closest to zero", and _maxXXX_ as "furthest from zero". For example, a *charging* power range from 10 kW to 50 kWh is given by _minPower_ = 10000 and _maxPower_ = 50000, and a *discharging* power range from -10 kW to -50 kW is given by _minPower_ = -10 and _maxPower_ = -50.
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
    "minEnergy",
    "maxEnergy",
    "minCurrent",
    "maxCurrent",
    "minPower",
    "maxPower",
    "minTime",
    "maxTime",
    "minChargingTime",
    "maxChargingTime",
    "minIdleTime",
    "maxIdleTime",
    "customData"
})
public class TariffConditions {

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
     * Minimum consumed energy in Wh, for example 20000 Wh.
     *     Valid from this amount of energy (inclusive) being used.
     * 
     * 
     */
    @JsonProperty("minEnergy")
    @JsonPropertyDescription("Minimum consumed energy in Wh, for example 20000 Wh.\r\n    Valid from this amount of energy (inclusive) being used.\r\n")
    private double minEnergy;
    /**
     * Maximum consumed energy in Wh, for example 50000 Wh.
     *     Valid until this amount of energy (exclusive) being used.
     * 
     * 
     */
    @JsonProperty("maxEnergy")
    @JsonPropertyDescription("Maximum consumed energy in Wh, for example 50000 Wh.\r\n    Valid until this amount of energy (exclusive) being used.\r\n")
    private double maxEnergy;
    /**
     * Sum of the minimum current (in Amperes) over all phases, for example 5 A.
     *     When the EV is charging with more than, or equal to, the defined amount of current, this price is/becomes active. If the charging current is or becomes lower, this price is not or no longer valid and becomes inactive. +
     *     This is NOT about the minimum current over the entire transaction.
     * 
     * 
     */
    @JsonProperty("minCurrent")
    @JsonPropertyDescription("Sum of the minimum current (in Amperes) over all phases, for example 5 A.\r\n    When the EV is charging with more than, or equal to, the defined amount of current, this price is/becomes active. If the charging current is or becomes lower, this price is not or no longer valid and becomes inactive. +\r\n    This is NOT about the minimum current over the entire transaction.\r\n")
    private double minCurrent;
    /**
     * Sum of the maximum current (in Amperes) over all phases, for example 20 A.
     *       When the EV is charging with less than the defined amount of current, this price becomes/is active. If the charging current is or becomes higher, this price is not or no longer valid and becomes inactive.
     *       This is NOT about the maximum current over the entire transaction.
     * 
     * 
     */
    @JsonProperty("maxCurrent")
    @JsonPropertyDescription("Sum of the maximum current (in Amperes) over all phases, for example 20 A.\r\n      When the EV is charging with less than the defined amount of current, this price becomes/is active. If the charging current is or becomes higher, this price is not or no longer valid and becomes inactive.\r\n      This is NOT about the maximum current over the entire transaction.\r\n")
    private double maxCurrent;
    /**
     * Minimum power in W, for example 5000 W.
     *       When the EV is charging with more than, or equal to, the defined amount of power, this price is/becomes active.
     *       If the charging power is or becomes lower, this price is not or no longer valid and becomes inactive.
     *       This is NOT about the minimum power over the entire transaction.
     * 
     * 
     */
    @JsonProperty("minPower")
    @JsonPropertyDescription("Minimum power in W, for example 5000 W.\r\n      When the EV is charging with more than, or equal to, the defined amount of power, this price is/becomes active.\r\n      If the charging power is or becomes lower, this price is not or no longer valid and becomes inactive.\r\n      This is NOT about the minimum power over the entire transaction.\r\n")
    private double minPower;
    /**
     * Maximum power in W, for example 20000 W.
     *       When the EV is charging with less than the defined amount of power, this price becomes/is active.
     *       If the charging power is or becomes higher, this price is not or no longer valid and becomes inactive.
     *       This is NOT about the maximum power over the entire transaction.
     * 
     * 
     */
    @JsonProperty("maxPower")
    @JsonPropertyDescription("Maximum power in W, for example 20000 W.\r\n      When the EV is charging with less than the defined amount of power, this price becomes/is active.\r\n      If the charging power is or becomes higher, this price is not or no longer valid and becomes inactive.\r\n      This is NOT about the maximum power over the entire transaction.\r\n")
    private double maxPower;
    /**
     * Minimum duration in seconds the transaction (charging &amp; idle) MUST last (inclusive).
     *       When the duration of a transaction is longer than the defined value, this price is or becomes active.
     *       Before that moment, this price is not yet active.
     * 
     * 
     */
    @JsonProperty("minTime")
    @JsonPropertyDescription("Minimum duration in seconds the transaction (charging &amp; idle) MUST last (inclusive).\r\n      When the duration of a transaction is longer than the defined value, this price is or becomes active.\r\n      Before that moment, this price is not yet active.\r\n")
    private int minTime;
    /**
     * Maximum duration in seconds the transaction (charging &amp; idle) MUST last (exclusive).
     *       When the duration of a transaction is shorter than the defined value, this price is or becomes active.
     *       After that moment, this price is no longer active.
     * 
     * 
     */
    @JsonProperty("maxTime")
    @JsonPropertyDescription("Maximum duration in seconds the transaction (charging &amp; idle) MUST last (exclusive).\r\n      When the duration of a transaction is shorter than the defined value, this price is or becomes active.\r\n      After that moment, this price is no longer active.\r\n")
    private int maxTime;
    /**
     * Minimum duration in seconds the charging MUST last (inclusive).
     *       When the duration of a charging is longer than the defined value, this price is or becomes active.
     *       Before that moment, this price is not yet active.
     * 
     * 
     */
    @JsonProperty("minChargingTime")
    @JsonPropertyDescription("Minimum duration in seconds the charging MUST last (inclusive).\r\n      When the duration of a charging is longer than the defined value, this price is or becomes active.\r\n      Before that moment, this price is not yet active.\r\n")
    private int minChargingTime;
    /**
     * Maximum duration in seconds the charging MUST last (exclusive).
     *       When the duration of a charging is shorter than the defined value, this price is or becomes active.
     *       After that moment, this price is no longer active.
     * 
     * 
     */
    @JsonProperty("maxChargingTime")
    @JsonPropertyDescription("Maximum duration in seconds the charging MUST last (exclusive).\r\n      When the duration of a charging is shorter than the defined value, this price is or becomes active.\r\n      After that moment, this price is no longer active.\r\n")
    private int maxChargingTime;
    /**
     * Minimum duration in seconds the idle period (i.e. not charging) MUST last (inclusive).
     *       When the duration of the idle time is longer than the defined value, this price is or becomes active.
     *       Before that moment, this price is not yet active.
     * 
     * 
     */
    @JsonProperty("minIdleTime")
    @JsonPropertyDescription("Minimum duration in seconds the idle period (i.e. not charging) MUST last (inclusive).\r\n      When the duration of the idle time is longer than the defined value, this price is or becomes active.\r\n      Before that moment, this price is not yet active.\r\n")
    private int minIdleTime;
    /**
     * Maximum duration in seconds the idle period (i.e. not charging) MUST last (exclusive).
     *       When the duration of idle time is shorter than the defined value, this price is or becomes active.
     *       After that moment, this price is no longer active.
     * 
     * 
     */
    @JsonProperty("maxIdleTime")
    @JsonPropertyDescription("Maximum duration in seconds the idle period (i.e. not charging) MUST last (exclusive).\r\n      When the duration of idle time is shorter than the defined value, this price is or becomes active.\r\n      After that moment, this price is no longer active.\r\n")
    private int maxIdleTime;
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

    public TariffConditions withStartTimeOfDay(String startTimeOfDay) {
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

    public TariffConditions withEndTimeOfDay(String endTimeOfDay) {
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

    public TariffConditions withDayOfWeek(List<DayOfWeekEnum> dayOfWeek) {
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

    public TariffConditions withValidFromDate(String validFromDate) {
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

    public TariffConditions withValidToDate(String validToDate) {
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

    public TariffConditions withEvseKind(EvseKindEnum evseKind) {
        this.evseKind = evseKind;
        return this;
    }

    /**
     * Minimum consumed energy in Wh, for example 20000 Wh.
     *     Valid from this amount of energy (inclusive) being used.
     * 
     * 
     */
    @JsonProperty("minEnergy")
    public double getMinEnergy() {
        return minEnergy;
    }

    /**
     * Minimum consumed energy in Wh, for example 20000 Wh.
     *     Valid from this amount of energy (inclusive) being used.
     * 
     * 
     */
    @JsonProperty("minEnergy")
    public void setMinEnergy(double minEnergy) {
        this.minEnergy = minEnergy;
    }

    public TariffConditions withMinEnergy(double minEnergy) {
        this.minEnergy = minEnergy;
        return this;
    }

    /**
     * Maximum consumed energy in Wh, for example 50000 Wh.
     *     Valid until this amount of energy (exclusive) being used.
     * 
     * 
     */
    @JsonProperty("maxEnergy")
    public double getMaxEnergy() {
        return maxEnergy;
    }

    /**
     * Maximum consumed energy in Wh, for example 50000 Wh.
     *     Valid until this amount of energy (exclusive) being used.
     * 
     * 
     */
    @JsonProperty("maxEnergy")
    public void setMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public TariffConditions withMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
        return this;
    }

    /**
     * Sum of the minimum current (in Amperes) over all phases, for example 5 A.
     *     When the EV is charging with more than, or equal to, the defined amount of current, this price is/becomes active. If the charging current is or becomes lower, this price is not or no longer valid and becomes inactive. +
     *     This is NOT about the minimum current over the entire transaction.
     * 
     * 
     */
    @JsonProperty("minCurrent")
    public double getMinCurrent() {
        return minCurrent;
    }

    /**
     * Sum of the minimum current (in Amperes) over all phases, for example 5 A.
     *     When the EV is charging with more than, or equal to, the defined amount of current, this price is/becomes active. If the charging current is or becomes lower, this price is not or no longer valid and becomes inactive. +
     *     This is NOT about the minimum current over the entire transaction.
     * 
     * 
     */
    @JsonProperty("minCurrent")
    public void setMinCurrent(double minCurrent) {
        this.minCurrent = minCurrent;
    }

    public TariffConditions withMinCurrent(double minCurrent) {
        this.minCurrent = minCurrent;
        return this;
    }

    /**
     * Sum of the maximum current (in Amperes) over all phases, for example 20 A.
     *       When the EV is charging with less than the defined amount of current, this price becomes/is active. If the charging current is or becomes higher, this price is not or no longer valid and becomes inactive.
     *       This is NOT about the maximum current over the entire transaction.
     * 
     * 
     */
    @JsonProperty("maxCurrent")
    public double getMaxCurrent() {
        return maxCurrent;
    }

    /**
     * Sum of the maximum current (in Amperes) over all phases, for example 20 A.
     *       When the EV is charging with less than the defined amount of current, this price becomes/is active. If the charging current is or becomes higher, this price is not or no longer valid and becomes inactive.
     *       This is NOT about the maximum current over the entire transaction.
     * 
     * 
     */
    @JsonProperty("maxCurrent")
    public void setMaxCurrent(double maxCurrent) {
        this.maxCurrent = maxCurrent;
    }

    public TariffConditions withMaxCurrent(double maxCurrent) {
        this.maxCurrent = maxCurrent;
        return this;
    }

    /**
     * Minimum power in W, for example 5000 W.
     *       When the EV is charging with more than, or equal to, the defined amount of power, this price is/becomes active.
     *       If the charging power is or becomes lower, this price is not or no longer valid and becomes inactive.
     *       This is NOT about the minimum power over the entire transaction.
     * 
     * 
     */
    @JsonProperty("minPower")
    public double getMinPower() {
        return minPower;
    }

    /**
     * Minimum power in W, for example 5000 W.
     *       When the EV is charging with more than, or equal to, the defined amount of power, this price is/becomes active.
     *       If the charging power is or becomes lower, this price is not or no longer valid and becomes inactive.
     *       This is NOT about the minimum power over the entire transaction.
     * 
     * 
     */
    @JsonProperty("minPower")
    public void setMinPower(double minPower) {
        this.minPower = minPower;
    }

    public TariffConditions withMinPower(double minPower) {
        this.minPower = minPower;
        return this;
    }

    /**
     * Maximum power in W, for example 20000 W.
     *       When the EV is charging with less than the defined amount of power, this price becomes/is active.
     *       If the charging power is or becomes higher, this price is not or no longer valid and becomes inactive.
     *       This is NOT about the maximum power over the entire transaction.
     * 
     * 
     */
    @JsonProperty("maxPower")
    public double getMaxPower() {
        return maxPower;
    }

    /**
     * Maximum power in W, for example 20000 W.
     *       When the EV is charging with less than the defined amount of power, this price becomes/is active.
     *       If the charging power is or becomes higher, this price is not or no longer valid and becomes inactive.
     *       This is NOT about the maximum power over the entire transaction.
     * 
     * 
     */
    @JsonProperty("maxPower")
    public void setMaxPower(double maxPower) {
        this.maxPower = maxPower;
    }

    public TariffConditions withMaxPower(double maxPower) {
        this.maxPower = maxPower;
        return this;
    }

    /**
     * Minimum duration in seconds the transaction (charging &amp; idle) MUST last (inclusive).
     *       When the duration of a transaction is longer than the defined value, this price is or becomes active.
     *       Before that moment, this price is not yet active.
     * 
     * 
     */
    @JsonProperty("minTime")
    public int getMinTime() {
        return minTime;
    }

    /**
     * Minimum duration in seconds the transaction (charging &amp; idle) MUST last (inclusive).
     *       When the duration of a transaction is longer than the defined value, this price is or becomes active.
     *       Before that moment, this price is not yet active.
     * 
     * 
     */
    @JsonProperty("minTime")
    public void setMinTime(int minTime) {
        this.minTime = minTime;
    }

    public TariffConditions withMinTime(int minTime) {
        this.minTime = minTime;
        return this;
    }

    /**
     * Maximum duration in seconds the transaction (charging &amp; idle) MUST last (exclusive).
     *       When the duration of a transaction is shorter than the defined value, this price is or becomes active.
     *       After that moment, this price is no longer active.
     * 
     * 
     */
    @JsonProperty("maxTime")
    public int getMaxTime() {
        return maxTime;
    }

    /**
     * Maximum duration in seconds the transaction (charging &amp; idle) MUST last (exclusive).
     *       When the duration of a transaction is shorter than the defined value, this price is or becomes active.
     *       After that moment, this price is no longer active.
     * 
     * 
     */
    @JsonProperty("maxTime")
    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public TariffConditions withMaxTime(int maxTime) {
        this.maxTime = maxTime;
        return this;
    }

    /**
     * Minimum duration in seconds the charging MUST last (inclusive).
     *       When the duration of a charging is longer than the defined value, this price is or becomes active.
     *       Before that moment, this price is not yet active.
     * 
     * 
     */
    @JsonProperty("minChargingTime")
    public int getMinChargingTime() {
        return minChargingTime;
    }

    /**
     * Minimum duration in seconds the charging MUST last (inclusive).
     *       When the duration of a charging is longer than the defined value, this price is or becomes active.
     *       Before that moment, this price is not yet active.
     * 
     * 
     */
    @JsonProperty("minChargingTime")
    public void setMinChargingTime(int minChargingTime) {
        this.minChargingTime = minChargingTime;
    }

    public TariffConditions withMinChargingTime(int minChargingTime) {
        this.minChargingTime = minChargingTime;
        return this;
    }

    /**
     * Maximum duration in seconds the charging MUST last (exclusive).
     *       When the duration of a charging is shorter than the defined value, this price is or becomes active.
     *       After that moment, this price is no longer active.
     * 
     * 
     */
    @JsonProperty("maxChargingTime")
    public int getMaxChargingTime() {
        return maxChargingTime;
    }

    /**
     * Maximum duration in seconds the charging MUST last (exclusive).
     *       When the duration of a charging is shorter than the defined value, this price is or becomes active.
     *       After that moment, this price is no longer active.
     * 
     * 
     */
    @JsonProperty("maxChargingTime")
    public void setMaxChargingTime(int maxChargingTime) {
        this.maxChargingTime = maxChargingTime;
    }

    public TariffConditions withMaxChargingTime(int maxChargingTime) {
        this.maxChargingTime = maxChargingTime;
        return this;
    }

    /**
     * Minimum duration in seconds the idle period (i.e. not charging) MUST last (inclusive).
     *       When the duration of the idle time is longer than the defined value, this price is or becomes active.
     *       Before that moment, this price is not yet active.
     * 
     * 
     */
    @JsonProperty("minIdleTime")
    public int getMinIdleTime() {
        return minIdleTime;
    }

    /**
     * Minimum duration in seconds the idle period (i.e. not charging) MUST last (inclusive).
     *       When the duration of the idle time is longer than the defined value, this price is or becomes active.
     *       Before that moment, this price is not yet active.
     * 
     * 
     */
    @JsonProperty("minIdleTime")
    public void setMinIdleTime(int minIdleTime) {
        this.minIdleTime = minIdleTime;
    }

    public TariffConditions withMinIdleTime(int minIdleTime) {
        this.minIdleTime = minIdleTime;
        return this;
    }

    /**
     * Maximum duration in seconds the idle period (i.e. not charging) MUST last (exclusive).
     *       When the duration of idle time is shorter than the defined value, this price is or becomes active.
     *       After that moment, this price is no longer active.
     * 
     * 
     */
    @JsonProperty("maxIdleTime")
    public int getMaxIdleTime() {
        return maxIdleTime;
    }

    /**
     * Maximum duration in seconds the idle period (i.e. not charging) MUST last (exclusive).
     *       When the duration of idle time is shorter than the defined value, this price is or becomes active.
     *       After that moment, this price is no longer active.
     * 
     * 
     */
    @JsonProperty("maxIdleTime")
    public void setMaxIdleTime(int maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    public TariffConditions withMaxIdleTime(int maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
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

    public TariffConditions withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TariffConditions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("minEnergy");
        sb.append('=');
        sb.append(this.minEnergy);
        sb.append(',');
        sb.append("maxEnergy");
        sb.append('=');
        sb.append(this.maxEnergy);
        sb.append(',');
        sb.append("minCurrent");
        sb.append('=');
        sb.append(this.minCurrent);
        sb.append(',');
        sb.append("maxCurrent");
        sb.append('=');
        sb.append(this.maxCurrent);
        sb.append(',');
        sb.append("minPower");
        sb.append('=');
        sb.append(this.minPower);
        sb.append(',');
        sb.append("maxPower");
        sb.append('=');
        sb.append(this.maxPower);
        sb.append(',');
        sb.append("minTime");
        sb.append('=');
        sb.append(this.minTime);
        sb.append(',');
        sb.append("maxTime");
        sb.append('=');
        sb.append(this.maxTime);
        sb.append(',');
        sb.append("minChargingTime");
        sb.append('=');
        sb.append(this.minChargingTime);
        sb.append(',');
        sb.append("maxChargingTime");
        sb.append('=');
        sb.append(this.maxChargingTime);
        sb.append(',');
        sb.append("minIdleTime");
        sb.append('=');
        sb.append(this.minIdleTime);
        sb.append(',');
        sb.append("maxIdleTime");
        sb.append('=');
        sb.append(this.maxIdleTime);
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
        result = ((result* 31)+ this.maxTime);
        result = ((result* 31)+ this.minChargingTime);
        result = ((result* 31)+ this.maxChargingTime);
        result = ((result* 31)+ this.maxIdleTime);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minPower)^(Double.doubleToLongBits(this.minPower)>>> 32))));
        result = ((result* 31)+((this.evseKind == null)? 0 :this.evseKind.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxEnergy)^(Double.doubleToLongBits(this.maxEnergy)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxCurrent)^(Double.doubleToLongBits(this.maxCurrent)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minEnergy)^(Double.doubleToLongBits(this.minEnergy)>>> 32))));
        result = ((result* 31)+((this.dayOfWeek == null)? 0 :this.dayOfWeek.hashCode()));
        result = ((result* 31)+ this.minTime);
        result = ((result* 31)+((this.endTimeOfDay == null)? 0 :this.endTimeOfDay.hashCode()));
        result = ((result* 31)+((this.validFromDate == null)? 0 :this.validFromDate.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minCurrent)^(Double.doubleToLongBits(this.minCurrent)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.maxPower)^(Double.doubleToLongBits(this.maxPower)>>> 32))));
        result = ((result* 31)+ this.minIdleTime);
        result = ((result* 31)+((this.startTimeOfDay == null)? 0 :this.startTimeOfDay.hashCode()));
        result = ((result* 31)+((this.validToDate == null)? 0 :this.validToDate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TariffConditions) == false) {
            return false;
        }
        TariffConditions rhs = ((TariffConditions) other);
        return (((((((((((((((((((this.maxTime == rhs.maxTime)&&(this.minChargingTime == rhs.minChargingTime))&&(this.maxChargingTime == rhs.maxChargingTime))&&(this.maxIdleTime == rhs.maxIdleTime))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&(Double.doubleToLongBits(this.minPower) == Double.doubleToLongBits(rhs.minPower)))&&((this.evseKind == rhs.evseKind)||((this.evseKind!= null)&&this.evseKind.equals(rhs.evseKind))))&&(Double.doubleToLongBits(this.maxEnergy) == Double.doubleToLongBits(rhs.maxEnergy)))&&(Double.doubleToLongBits(this.maxCurrent) == Double.doubleToLongBits(rhs.maxCurrent)))&&(Double.doubleToLongBits(this.minEnergy) == Double.doubleToLongBits(rhs.minEnergy)))&&((this.dayOfWeek == rhs.dayOfWeek)||((this.dayOfWeek!= null)&&this.dayOfWeek.equals(rhs.dayOfWeek))))&&(this.minTime == rhs.minTime))&&((this.endTimeOfDay == rhs.endTimeOfDay)||((this.endTimeOfDay!= null)&&this.endTimeOfDay.equals(rhs.endTimeOfDay))))&&((this.validFromDate == rhs.validFromDate)||((this.validFromDate!= null)&&this.validFromDate.equals(rhs.validFromDate))))&&(Double.doubleToLongBits(this.minCurrent) == Double.doubleToLongBits(rhs.minCurrent)))&&(Double.doubleToLongBits(this.maxPower) == Double.doubleToLongBits(rhs.maxPower)))&&(this.minIdleTime == rhs.minIdleTime))&&((this.startTimeOfDay == rhs.startTimeOfDay)||((this.startTimeOfDay!= null)&&this.startTimeOfDay.equals(rhs.startTimeOfDay))))&&((this.validToDate == rhs.validToDate)||((this.validToDate!= null)&&this.validToDate.equals(rhs.validToDate))));
    }

}
