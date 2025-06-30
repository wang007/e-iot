
package io.github.eiot.ocpp.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * The physical system where an Electrical Vehicle (EV) can be charged.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "serialNumber",
    "model",
    "modem",
    "vendorName",
    "firmwareVersion",
    "customData"
})
public class ChargingStation {

    /**
     * Vendor-specific device identifier.
     * 
     * 
     */
    @JsonProperty("serialNumber")
    @JsonPropertyDescription("Vendor-specific device identifier.\r\n")
    @Size(max = 25)
    private String serialNumber;
    /**
     * Defines the model of the device.
     * 
     * (Required)
     * 
     */
    @JsonProperty("model")
    @JsonPropertyDescription("Defines the model of the device.\r\n")
    @Size(max = 20)
    @NotNull
    private String model;
    /**
     * Defines parameters required for initiating and maintaining wireless communication with other devices.
     * 
     * 
     */
    @JsonProperty("modem")
    @JsonPropertyDescription("Defines parameters required for initiating and maintaining wireless communication with other devices.\r\n")
    @Valid
    private Modem modem;
    /**
     * Identifies the vendor (not necessarily in a unique manner).
     * 
     * (Required)
     * 
     */
    @JsonProperty("vendorName")
    @JsonPropertyDescription("Identifies the vendor (not necessarily in a unique manner).\r\n")
    @Size(max = 50)
    @NotNull
    private String vendorName;
    /**
     * This contains the firmware version of the Charging Station.
     * 
     * 
     * 
     */
    @JsonProperty("firmwareVersion")
    @JsonPropertyDescription("This contains the firmware version of the Charging Station.\r\n\r\n")
    @Size(max = 50)
    private String firmwareVersion;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Vendor-specific device identifier.
     * 
     * 
     */
    @JsonProperty("serialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Vendor-specific device identifier.
     * 
     * 
     */
    @JsonProperty("serialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public ChargingStation withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    /**
     * Defines the model of the device.
     * 
     * (Required)
     * 
     */
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    /**
     * Defines the model of the device.
     * 
     * (Required)
     * 
     */
    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    public ChargingStation withModel(String model) {
        this.model = model;
        return this;
    }

    /**
     * Defines parameters required for initiating and maintaining wireless communication with other devices.
     * 
     * 
     */
    @JsonProperty("modem")
    public Modem getModem() {
        return modem;
    }

    /**
     * Defines parameters required for initiating and maintaining wireless communication with other devices.
     * 
     * 
     */
    @JsonProperty("modem")
    public void setModem(Modem modem) {
        this.modem = modem;
    }

    public ChargingStation withModem(Modem modem) {
        this.modem = modem;
        return this;
    }

    /**
     * Identifies the vendor (not necessarily in a unique manner).
     * 
     * (Required)
     * 
     */
    @JsonProperty("vendorName")
    public String getVendorName() {
        return vendorName;
    }

    /**
     * Identifies the vendor (not necessarily in a unique manner).
     * 
     * (Required)
     * 
     */
    @JsonProperty("vendorName")
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public ChargingStation withVendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    /**
     * This contains the firmware version of the Charging Station.
     * 
     * 
     * 
     */
    @JsonProperty("firmwareVersion")
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    /**
     * This contains the firmware version of the Charging Station.
     * 
     * 
     * 
     */
    @JsonProperty("firmwareVersion")
    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public ChargingStation withFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
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

    public ChargingStation withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargingStation.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("serialNumber");
        sb.append('=');
        sb.append(((this.serialNumber == null)?"<null>":this.serialNumber));
        sb.append(',');
        sb.append("model");
        sb.append('=');
        sb.append(((this.model == null)?"<null>":this.model));
        sb.append(',');
        sb.append("modem");
        sb.append('=');
        sb.append(((this.modem == null)?"<null>":this.modem));
        sb.append(',');
        sb.append("vendorName");
        sb.append('=');
        sb.append(((this.vendorName == null)?"<null>":this.vendorName));
        sb.append(',');
        sb.append("firmwareVersion");
        sb.append('=');
        sb.append(((this.firmwareVersion == null)?"<null>":this.firmwareVersion));
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
        result = ((result* 31)+((this.serialNumber == null)? 0 :this.serialNumber.hashCode()));
        result = ((result* 31)+((this.modem == null)? 0 :this.modem.hashCode()));
        result = ((result* 31)+((this.model == null)? 0 :this.model.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.vendorName == null)? 0 :this.vendorName.hashCode()));
        result = ((result* 31)+((this.firmwareVersion == null)? 0 :this.firmwareVersion.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargingStation) == false) {
            return false;
        }
        ChargingStation rhs = ((ChargingStation) other);
        return (((((((this.serialNumber == rhs.serialNumber)||((this.serialNumber!= null)&&this.serialNumber.equals(rhs.serialNumber)))&&((this.modem == rhs.modem)||((this.modem!= null)&&this.modem.equals(rhs.modem))))&&((this.model == rhs.model)||((this.model!= null)&&this.model.equals(rhs.model))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.vendorName == rhs.vendorName)||((this.vendorName!= null)&&this.vendorName.equals(rhs.vendorName))))&&((this.firmwareVersion == rhs.firmwareVersion)||((this.firmwareVersion!= null)&&this.firmwareVersion.equals(rhs.firmwareVersion))));
    }

}
