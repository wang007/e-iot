
package io.github.eiot.ocpp.schema.v2_1;

import java.time.ZonedDateTime;
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
    "evseId",
    "serialNumber",
    "soC",
    "soH",
    "productionDate",
    "vendorInfo",
    "customData"
})
public class BatteryData {

    /**
     * Slot number where battery is inserted or removed.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("Slot number where battery is inserted or removed.\r\n")
    @DecimalMin("0")
    @NotNull
    private int evseId;
    /**
     * Serial number of battery.
     * 
     * (Required)
     * 
     */
    @JsonProperty("serialNumber")
    @JsonPropertyDescription("Serial number of battery.\r\n")
    @Size(max = 50)
    @NotNull
    private String serialNumber;
    /**
     * State of charge
     * 
     * (Required)
     * 
     */
    @JsonProperty("soC")
    @JsonPropertyDescription("State of charge\r\n")
    @NotNull
    private double soC;
    /**
     * State of health
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("soH")
    @JsonPropertyDescription("State of health\r\n\r\n")
    @NotNull
    private double soH;
    /**
     * Production date of battery.
     * 
     * 
     * 
     */
    @JsonProperty("productionDate")
    @JsonPropertyDescription("Production date of battery.\r\n\r\n")
    private ZonedDateTime productionDate;
    /**
     * Vendor-specific info from battery in undefined format.
     * 
     * 
     */
    @JsonProperty("vendorInfo")
    @JsonPropertyDescription("Vendor-specific info from battery in undefined format.\r\n")
    @Size(max = 500)
    private String vendorInfo;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Slot number where battery is inserted or removed.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public int getEvseId() {
        return evseId;
    }

    /**
     * Slot number where battery is inserted or removed.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    public void setEvseId(int evseId) {
        this.evseId = evseId;
    }

    public BatteryData withEvseId(int evseId) {
        this.evseId = evseId;
        return this;
    }

    /**
     * Serial number of battery.
     * 
     * (Required)
     * 
     */
    @JsonProperty("serialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Serial number of battery.
     * 
     * (Required)
     * 
     */
    @JsonProperty("serialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BatteryData withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    /**
     * State of charge
     * 
     * (Required)
     * 
     */
    @JsonProperty("soC")
    public double getSoC() {
        return soC;
    }

    /**
     * State of charge
     * 
     * (Required)
     * 
     */
    @JsonProperty("soC")
    public void setSoC(double soC) {
        this.soC = soC;
    }

    public BatteryData withSoC(double soC) {
        this.soC = soC;
        return this;
    }

    /**
     * State of health
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("soH")
    public double getSoH() {
        return soH;
    }

    /**
     * State of health
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("soH")
    public void setSoH(double soH) {
        this.soH = soH;
    }

    public BatteryData withSoH(double soH) {
        this.soH = soH;
        return this;
    }

    /**
     * Production date of battery.
     * 
     * 
     * 
     */
    @JsonProperty("productionDate")
    public ZonedDateTime getProductionDate() {
        return productionDate;
    }

    /**
     * Production date of battery.
     * 
     * 
     * 
     */
    @JsonProperty("productionDate")
    public void setProductionDate(ZonedDateTime productionDate) {
        this.productionDate = productionDate;
    }

    public BatteryData withProductionDate(ZonedDateTime productionDate) {
        this.productionDate = productionDate;
        return this;
    }

    /**
     * Vendor-specific info from battery in undefined format.
     * 
     * 
     */
    @JsonProperty("vendorInfo")
    public String getVendorInfo() {
        return vendorInfo;
    }

    /**
     * Vendor-specific info from battery in undefined format.
     * 
     * 
     */
    @JsonProperty("vendorInfo")
    public void setVendorInfo(String vendorInfo) {
        this.vendorInfo = vendorInfo;
    }

    public BatteryData withVendorInfo(String vendorInfo) {
        this.vendorInfo = vendorInfo;
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

    public BatteryData withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BatteryData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("evseId");
        sb.append('=');
        sb.append(this.evseId);
        sb.append(',');
        sb.append("serialNumber");
        sb.append('=');
        sb.append(((this.serialNumber == null)?"<null>":this.serialNumber));
        sb.append(',');
        sb.append("soC");
        sb.append('=');
        sb.append(this.soC);
        sb.append(',');
        sb.append("soH");
        sb.append('=');
        sb.append(this.soH);
        sb.append(',');
        sb.append("productionDate");
        sb.append('=');
        sb.append(((this.productionDate == null)?"<null>":this.productionDate));
        sb.append(',');
        sb.append("vendorInfo");
        sb.append('=');
        sb.append(((this.vendorInfo == null)?"<null>":this.vendorInfo));
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
        result = ((result* 31)+((this.serialNumber == null)? 0 :this.serialNumber.hashCode()));
        result = ((result* 31)+((this.productionDate == null)? 0 :this.productionDate.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.soC)^(Double.doubleToLongBits(this.soC)>>> 32))));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.vendorInfo == null)? 0 :this.vendorInfo.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.soH)^(Double.doubleToLongBits(this.soH)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BatteryData) == false) {
            return false;
        }
        BatteryData rhs = ((BatteryData) other);
        return (((((((this.evseId == rhs.evseId)&&((this.serialNumber == rhs.serialNumber)||((this.serialNumber!= null)&&this.serialNumber.equals(rhs.serialNumber))))&&((this.productionDate == rhs.productionDate)||((this.productionDate!= null)&&this.productionDate.equals(rhs.productionDate))))&&(Double.doubleToLongBits(this.soC) == Double.doubleToLongBits(rhs.soC)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.vendorInfo == rhs.vendorInfo)||((this.vendorInfo!= null)&&this.vendorInfo.equals(rhs.vendorInfo))))&&(Double.doubleToLongBits(this.soH) == Double.doubleToLongBits(rhs.soH)));
    }

}
