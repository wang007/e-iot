
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
 * Charging schedule structure defines a list of charging periods, as used in: NotifyEVChargingScheduleRequest and ChargingProfileType. When used in a NotifyEVChargingScheduleRequest only _duration_ and _chargingSchedulePeriod_ are relevant and _chargingRateUnit_ must be 'W'. +
 * An ISO 15118-20 session may provide either an _absolutePriceSchedule_ or a _priceLevelSchedule_. An ISO 15118-2 session can only provide a_salesTariff_ element. The field _digestValue_ is used when price schedule or sales tariff are signed.
 * 
 * image::images/ChargingSchedule-Simple.png[]
 * 
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "limitAtSoC",
    "startSchedule",
    "duration",
    "chargingRateUnit",
    "minChargingRate",
    "powerTolerance",
    "signatureId",
    "digestValue",
    "useLocalTime",
    "chargingSchedulePeriod",
    "randomizedDelay",
    "salesTariff",
    "absolutePriceSchedule",
    "priceLevelSchedule",
    "customData"
})
public class ChargingSchedule {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @NotNull
    private int id;
    @JsonProperty("limitAtSoC")
    @Valid
    private LimitAtSoC limitAtSoC;
    /**
     * Starting point of an absolute schedule or recurring schedule.
     * 
     * 
     */
    @JsonProperty("startSchedule")
    @JsonPropertyDescription("Starting point of an absolute schedule or recurring schedule.\r\n")
    private OffsetDateTime startSchedule;
    /**
     * Duration of the charging schedule in seconds. If the duration is left empty, the last period will continue indefinitely or until end of the transaction in case startSchedule is absent.
     * 
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Duration of the charging schedule in seconds. If the duration is left empty, the last period will continue indefinitely or until end of the transaction in case startSchedule is absent.\r\n")
    private int duration;
    /**
     * The unit of measure in which limits and setpoints are expressed.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    @JsonPropertyDescription("The unit of measure in which limits and setpoints are expressed.\r\n")
    @NotNull
    private ChargingRateUnitEnum chargingRateUnit;
    /**
     * Minimum charging rate supported by the EV. The unit of measure is defined by the chargingRateUnit. This parameter is intended to be used by a local smart charging algorithm to optimize the power allocation for in the case a charging process is inefficient at lower charging rates. 
     * 
     * 
     */
    @JsonProperty("minChargingRate")
    @JsonPropertyDescription("Minimum charging rate supported by the EV. The unit of measure is defined by the chargingRateUnit. This parameter is intended to be used by a local smart charging algorithm to optimize the power allocation for in the case a charging process is inefficient at lower charging rates. \r\n")
    private double minChargingRate;
    /**
     * *(2.1)* Power tolerance when following EVPowerProfile.
     * 
     * 
     * 
     */
    @JsonProperty("powerTolerance")
    @JsonPropertyDescription("*(2.1)* Power tolerance when following EVPowerProfile.\r\n\r\n")
    private double powerTolerance;
    /**
     * *(2.1)* Id of this element for referencing in a signature.
     * 
     * 
     */
    @JsonProperty("signatureId")
    @JsonPropertyDescription("*(2.1)* Id of this element for referencing in a signature.\r\n")
    @DecimalMin("0")
    private int signatureId;
    /**
     * *(2.1)* Base64 encoded hash (SHA256 for ISO 15118-2, SHA512 for ISO 15118-20) of the EXI price schedule element. Used in signature.
     * 
     * 
     */
    @JsonProperty("digestValue")
    @JsonPropertyDescription("*(2.1)* Base64 encoded hash (SHA256 for ISO 15118-2, SHA512 for ISO 15118-20) of the EXI price schedule element. Used in signature.\r\n")
    @Size(max = 88)
    private String digestValue;
    /**
     * *(2.1)* Defaults to false. When true, disregard time zone offset in dateTime fields of  _ChargingScheduleType_ and use unqualified local time at Charging Station instead.
     *  This allows the same `Absolute` or `Recurring` charging profile to be used in both summer and winter time.
     * 
     * 
     * 
     */
    @JsonProperty("useLocalTime")
    @JsonPropertyDescription("*(2.1)* Defaults to false. When true, disregard time zone offset in dateTime fields of  _ChargingScheduleType_ and use unqualified local time at Charging Station instead.\r\n This allows the same `Absolute` or `Recurring` charging profile to be used in both summer and winter time.\r\n\r\n")
    private boolean useLocalTime;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    @Size(min = 1, max = 1024)
    @Valid
    @NotNull
    private List<ChargingSchedulePeriod> chargingSchedulePeriod = new ArrayList<ChargingSchedulePeriod>();
    /**
     * *(2.1)* Defaults to 0. When _randomizedDelay_ not equals zero, then the start of each &lt;&lt;cmn_chargingscheduleperiodtype,ChargingSchedulePeriodType&gt;&gt; is delayed by a randomly chosen number of seconds between 0 and _randomizedDelay_.  Only allowed for TxProfile and TxDefaultProfile.
     * 
     * 
     * 
     */
    @JsonProperty("randomizedDelay")
    @JsonPropertyDescription("*(2.1)* Defaults to 0. When _randomizedDelay_ not equals zero, then the start of each &lt;&lt;cmn_chargingscheduleperiodtype,ChargingSchedulePeriodType&gt;&gt; is delayed by a randomly chosen number of seconds between 0 and _randomizedDelay_.  Only allowed for TxProfile and TxDefaultProfile.\r\n\r\n")
    @DecimalMin("0")
    private int randomizedDelay;
    /**
     * A SalesTariff provided by a Mobility Operator (EMSP) .
     * NOTE: This dataType is based on dataTypes from &lt;&lt;ref-ISOIEC15118-2,ISO 15118-2&gt;&gt;.
     * 
     * 
     */
    @JsonProperty("salesTariff")
    @JsonPropertyDescription("A SalesTariff provided by a Mobility Operator (EMSP) .\r\nNOTE: This dataType is based on dataTypes from &lt;&lt;ref-ISOIEC15118-2,ISO 15118-2&gt;&gt;.\r\n")
    @Valid
    private SalesTariff salesTariff;
    /**
     * The AbsolutePriceScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.
     * 
     * image::images/AbsolutePriceSchedule-Simple.png[]
     * 
     * 
     * 
     */
    @JsonProperty("absolutePriceSchedule")
    @JsonPropertyDescription("The AbsolutePriceScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.\r\n\r\nimage::images/AbsolutePriceSchedule-Simple.png[]\r\n\r\n")
    @Valid
    private AbsolutePriceSchedule absolutePriceSchedule;
    /**
     * The PriceLevelScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.
     * 
     * 
     */
    @JsonProperty("priceLevelSchedule")
    @JsonPropertyDescription("The PriceLevelScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.\r\n")
    @Valid
    private PriceLevelSchedule priceLevelSchedule;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public ChargingSchedule withId(int id) {
        this.id = id;
        return this;
    }

    @JsonProperty("limitAtSoC")
    public LimitAtSoC getLimitAtSoC() {
        return limitAtSoC;
    }

    @JsonProperty("limitAtSoC")
    public void setLimitAtSoC(LimitAtSoC limitAtSoC) {
        this.limitAtSoC = limitAtSoC;
    }

    public ChargingSchedule withLimitAtSoC(LimitAtSoC limitAtSoC) {
        this.limitAtSoC = limitAtSoC;
        return this;
    }

    /**
     * Starting point of an absolute schedule or recurring schedule.
     * 
     * 
     */
    @JsonProperty("startSchedule")
    public OffsetDateTime getStartSchedule() {
        return startSchedule;
    }

    /**
     * Starting point of an absolute schedule or recurring schedule.
     * 
     * 
     */
    @JsonProperty("startSchedule")
    public void setStartSchedule(OffsetDateTime startSchedule) {
        this.startSchedule = startSchedule;
    }

    public ChargingSchedule withStartSchedule(OffsetDateTime startSchedule) {
        this.startSchedule = startSchedule;
        return this;
    }

    /**
     * Duration of the charging schedule in seconds. If the duration is left empty, the last period will continue indefinitely or until end of the transaction in case startSchedule is absent.
     * 
     * 
     */
    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }

    /**
     * Duration of the charging schedule in seconds. If the duration is left empty, the last period will continue indefinitely or until end of the transaction in case startSchedule is absent.
     * 
     * 
     */
    @JsonProperty("duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ChargingSchedule withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * The unit of measure in which limits and setpoints are expressed.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    public ChargingRateUnitEnum getChargingRateUnit() {
        return chargingRateUnit;
    }

    /**
     * The unit of measure in which limits and setpoints are expressed.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    public void setChargingRateUnit(ChargingRateUnitEnum chargingRateUnit) {
        this.chargingRateUnit = chargingRateUnit;
    }

    public ChargingSchedule withChargingRateUnit(ChargingRateUnitEnum chargingRateUnit) {
        this.chargingRateUnit = chargingRateUnit;
        return this;
    }

    /**
     * Minimum charging rate supported by the EV. The unit of measure is defined by the chargingRateUnit. This parameter is intended to be used by a local smart charging algorithm to optimize the power allocation for in the case a charging process is inefficient at lower charging rates. 
     * 
     * 
     */
    @JsonProperty("minChargingRate")
    public double getMinChargingRate() {
        return minChargingRate;
    }

    /**
     * Minimum charging rate supported by the EV. The unit of measure is defined by the chargingRateUnit. This parameter is intended to be used by a local smart charging algorithm to optimize the power allocation for in the case a charging process is inefficient at lower charging rates. 
     * 
     * 
     */
    @JsonProperty("minChargingRate")
    public void setMinChargingRate(double minChargingRate) {
        this.minChargingRate = minChargingRate;
    }

    public ChargingSchedule withMinChargingRate(double minChargingRate) {
        this.minChargingRate = minChargingRate;
        return this;
    }

    /**
     * *(2.1)* Power tolerance when following EVPowerProfile.
     * 
     * 
     * 
     */
    @JsonProperty("powerTolerance")
    public double getPowerTolerance() {
        return powerTolerance;
    }

    /**
     * *(2.1)* Power tolerance when following EVPowerProfile.
     * 
     * 
     * 
     */
    @JsonProperty("powerTolerance")
    public void setPowerTolerance(double powerTolerance) {
        this.powerTolerance = powerTolerance;
    }

    public ChargingSchedule withPowerTolerance(double powerTolerance) {
        this.powerTolerance = powerTolerance;
        return this;
    }

    /**
     * *(2.1)* Id of this element for referencing in a signature.
     * 
     * 
     */
    @JsonProperty("signatureId")
    public int getSignatureId() {
        return signatureId;
    }

    /**
     * *(2.1)* Id of this element for referencing in a signature.
     * 
     * 
     */
    @JsonProperty("signatureId")
    public void setSignatureId(int signatureId) {
        this.signatureId = signatureId;
    }

    public ChargingSchedule withSignatureId(int signatureId) {
        this.signatureId = signatureId;
        return this;
    }

    /**
     * *(2.1)* Base64 encoded hash (SHA256 for ISO 15118-2, SHA512 for ISO 15118-20) of the EXI price schedule element. Used in signature.
     * 
     * 
     */
    @JsonProperty("digestValue")
    public String getDigestValue() {
        return digestValue;
    }

    /**
     * *(2.1)* Base64 encoded hash (SHA256 for ISO 15118-2, SHA512 for ISO 15118-20) of the EXI price schedule element. Used in signature.
     * 
     * 
     */
    @JsonProperty("digestValue")
    public void setDigestValue(String digestValue) {
        this.digestValue = digestValue;
    }

    public ChargingSchedule withDigestValue(String digestValue) {
        this.digestValue = digestValue;
        return this;
    }

    /**
     * *(2.1)* Defaults to false. When true, disregard time zone offset in dateTime fields of  _ChargingScheduleType_ and use unqualified local time at Charging Station instead.
     *  This allows the same `Absolute` or `Recurring` charging profile to be used in both summer and winter time.
     * 
     * 
     * 
     */
    @JsonProperty("useLocalTime")
    public boolean isUseLocalTime() {
        return useLocalTime;
    }

    /**
     * *(2.1)* Defaults to false. When true, disregard time zone offset in dateTime fields of  _ChargingScheduleType_ and use unqualified local time at Charging Station instead.
     *  This allows the same `Absolute` or `Recurring` charging profile to be used in both summer and winter time.
     * 
     * 
     * 
     */
    @JsonProperty("useLocalTime")
    public void setUseLocalTime(boolean useLocalTime) {
        this.useLocalTime = useLocalTime;
    }

    public ChargingSchedule withUseLocalTime(boolean useLocalTime) {
        this.useLocalTime = useLocalTime;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    public List<ChargingSchedulePeriod> getChargingSchedulePeriod() {
        return chargingSchedulePeriod;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    public void setChargingSchedulePeriod(List<ChargingSchedulePeriod> chargingSchedulePeriod) {
        this.chargingSchedulePeriod = chargingSchedulePeriod;
    }

    public ChargingSchedule withChargingSchedulePeriod(List<ChargingSchedulePeriod> chargingSchedulePeriod) {
        this.chargingSchedulePeriod = chargingSchedulePeriod;
        return this;
    }

    /**
     * *(2.1)* Defaults to 0. When _randomizedDelay_ not equals zero, then the start of each &lt;&lt;cmn_chargingscheduleperiodtype,ChargingSchedulePeriodType&gt;&gt; is delayed by a randomly chosen number of seconds between 0 and _randomizedDelay_.  Only allowed for TxProfile and TxDefaultProfile.
     * 
     * 
     * 
     */
    @JsonProperty("randomizedDelay")
    public int getRandomizedDelay() {
        return randomizedDelay;
    }

    /**
     * *(2.1)* Defaults to 0. When _randomizedDelay_ not equals zero, then the start of each &lt;&lt;cmn_chargingscheduleperiodtype,ChargingSchedulePeriodType&gt;&gt; is delayed by a randomly chosen number of seconds between 0 and _randomizedDelay_.  Only allowed for TxProfile and TxDefaultProfile.
     * 
     * 
     * 
     */
    @JsonProperty("randomizedDelay")
    public void setRandomizedDelay(int randomizedDelay) {
        this.randomizedDelay = randomizedDelay;
    }

    public ChargingSchedule withRandomizedDelay(int randomizedDelay) {
        this.randomizedDelay = randomizedDelay;
        return this;
    }

    /**
     * A SalesTariff provided by a Mobility Operator (EMSP) .
     * NOTE: This dataType is based on dataTypes from &lt;&lt;ref-ISOIEC15118-2,ISO 15118-2&gt;&gt;.
     * 
     * 
     */
    @JsonProperty("salesTariff")
    public SalesTariff getSalesTariff() {
        return salesTariff;
    }

    /**
     * A SalesTariff provided by a Mobility Operator (EMSP) .
     * NOTE: This dataType is based on dataTypes from &lt;&lt;ref-ISOIEC15118-2,ISO 15118-2&gt;&gt;.
     * 
     * 
     */
    @JsonProperty("salesTariff")
    public void setSalesTariff(SalesTariff salesTariff) {
        this.salesTariff = salesTariff;
    }

    public ChargingSchedule withSalesTariff(SalesTariff salesTariff) {
        this.salesTariff = salesTariff;
        return this;
    }

    /**
     * The AbsolutePriceScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.
     * 
     * image::images/AbsolutePriceSchedule-Simple.png[]
     * 
     * 
     * 
     */
    @JsonProperty("absolutePriceSchedule")
    public AbsolutePriceSchedule getAbsolutePriceSchedule() {
        return absolutePriceSchedule;
    }

    /**
     * The AbsolutePriceScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.
     * 
     * image::images/AbsolutePriceSchedule-Simple.png[]
     * 
     * 
     * 
     */
    @JsonProperty("absolutePriceSchedule")
    public void setAbsolutePriceSchedule(AbsolutePriceSchedule absolutePriceSchedule) {
        this.absolutePriceSchedule = absolutePriceSchedule;
    }

    public ChargingSchedule withAbsolutePriceSchedule(AbsolutePriceSchedule absolutePriceSchedule) {
        this.absolutePriceSchedule = absolutePriceSchedule;
        return this;
    }

    /**
     * The PriceLevelScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.
     * 
     * 
     */
    @JsonProperty("priceLevelSchedule")
    public PriceLevelSchedule getPriceLevelSchedule() {
        return priceLevelSchedule;
    }

    /**
     * The PriceLevelScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.
     * 
     * 
     */
    @JsonProperty("priceLevelSchedule")
    public void setPriceLevelSchedule(PriceLevelSchedule priceLevelSchedule) {
        this.priceLevelSchedule = priceLevelSchedule;
    }

    public ChargingSchedule withPriceLevelSchedule(PriceLevelSchedule priceLevelSchedule) {
        this.priceLevelSchedule = priceLevelSchedule;
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

    public ChargingSchedule withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingSchedule.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("limitAtSoC");
        sb.append('=');
        sb.append(((this.limitAtSoC == null)?"<null>":this.limitAtSoC));
        sb.append(',');
        sb.append("startSchedule");
        sb.append('=');
        sb.append(((this.startSchedule == null)?"<null>":this.startSchedule));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
        sb.append(',');
        sb.append("chargingRateUnit");
        sb.append('=');
        sb.append(((this.chargingRateUnit == null)?"<null>":this.chargingRateUnit));
        sb.append(',');
        sb.append("minChargingRate");
        sb.append('=');
        sb.append(this.minChargingRate);
        sb.append(',');
        sb.append("powerTolerance");
        sb.append('=');
        sb.append(this.powerTolerance);
        sb.append(',');
        sb.append("signatureId");
        sb.append('=');
        sb.append(this.signatureId);
        sb.append(',');
        sb.append("digestValue");
        sb.append('=');
        sb.append(((this.digestValue == null)?"<null>":this.digestValue));
        sb.append(',');
        sb.append("useLocalTime");
        sb.append('=');
        sb.append(this.useLocalTime);
        sb.append(',');
        sb.append("chargingSchedulePeriod");
        sb.append('=');
        sb.append(((this.chargingSchedulePeriod == null)?"<null>":this.chargingSchedulePeriod));
        sb.append(',');
        sb.append("randomizedDelay");
        sb.append('=');
        sb.append(this.randomizedDelay);
        sb.append(',');
        sb.append("salesTariff");
        sb.append('=');
        sb.append(((this.salesTariff == null)?"<null>":this.salesTariff));
        sb.append(',');
        sb.append("absolutePriceSchedule");
        sb.append('=');
        sb.append(((this.absolutePriceSchedule == null)?"<null>":this.absolutePriceSchedule));
        sb.append(',');
        sb.append("priceLevelSchedule");
        sb.append('=');
        sb.append(((this.priceLevelSchedule == null)?"<null>":this.priceLevelSchedule));
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
        result = ((result* 31)+((this.startSchedule == null)? 0 :this.startSchedule.hashCode()));
        result = ((result* 31)+((this.chargingSchedulePeriod == null)? 0 :this.chargingSchedulePeriod.hashCode()));
        result = ((result* 31)+((this.salesTariff == null)? 0 :this.salesTariff.hashCode()));
        result = ((result* 31)+((this.chargingRateUnit == null)? 0 :this.chargingRateUnit.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.powerTolerance)^(Double.doubleToLongBits(this.powerTolerance)>>> 32))));
        result = ((result* 31)+ this.signatureId);
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.limitAtSoC == null)? 0 :this.limitAtSoC.hashCode()));
        result = ((result* 31)+ this.duration);
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.minChargingRate)^(Double.doubleToLongBits(this.minChargingRate)>>> 32))));
        result = ((result* 31)+((this.digestValue == null)? 0 :this.digestValue.hashCode()));
        result = ((result* 31)+(this.useLocalTime? 1 : 0));
        result = ((result* 31)+((this.priceLevelSchedule == null)? 0 :this.priceLevelSchedule.hashCode()));
        result = ((result* 31)+ this.randomizedDelay);
        result = ((result* 31)+ this.id);
        result = ((result* 31)+((this.absolutePriceSchedule == null)? 0 :this.absolutePriceSchedule.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingSchedule) == false) {
            return false;
        }
        ChargingSchedule rhs = ((ChargingSchedule) other);
        return (((((((((((((((((this.startSchedule == rhs.startSchedule)||((this.startSchedule!= null)&&this.startSchedule.equals(rhs.startSchedule)))&&((this.chargingSchedulePeriod == rhs.chargingSchedulePeriod)||((this.chargingSchedulePeriod!= null)&&this.chargingSchedulePeriod.equals(rhs.chargingSchedulePeriod))))&&((this.salesTariff == rhs.salesTariff)||((this.salesTariff!= null)&&this.salesTariff.equals(rhs.salesTariff))))&&((this.chargingRateUnit == rhs.chargingRateUnit)||((this.chargingRateUnit!= null)&&this.chargingRateUnit.equals(rhs.chargingRateUnit))))&&(Double.doubleToLongBits(this.powerTolerance) == Double.doubleToLongBits(rhs.powerTolerance)))&&(this.signatureId == rhs.signatureId))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.limitAtSoC == rhs.limitAtSoC)||((this.limitAtSoC!= null)&&this.limitAtSoC.equals(rhs.limitAtSoC))))&&(this.duration == rhs.duration))&&(Double.doubleToLongBits(this.minChargingRate) == Double.doubleToLongBits(rhs.minChargingRate)))&&((this.digestValue == rhs.digestValue)||((this.digestValue!= null)&&this.digestValue.equals(rhs.digestValue))))&&(this.useLocalTime == rhs.useLocalTime))&&((this.priceLevelSchedule == rhs.priceLevelSchedule)||((this.priceLevelSchedule!= null)&&this.priceLevelSchedule.equals(rhs.priceLevelSchedule))))&&(this.randomizedDelay == rhs.randomizedDelay))&&(this.id == rhs.id))&&((this.absolutePriceSchedule == rhs.absolutePriceSchedule)||((this.absolutePriceSchedule!= null)&&this.absolutePriceSchedule.equals(rhs.absolutePriceSchedule))));
    }

}
