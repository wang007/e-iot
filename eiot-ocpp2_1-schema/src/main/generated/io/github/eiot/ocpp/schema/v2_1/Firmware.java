
package io.github.eiot.ocpp.schema.v2_1;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Represents a copy of the firmware that can be loaded/updated on the Charging Station.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "location",
    "retrieveDateTime",
    "installDateTime",
    "signingCertificate",
    "signature",
    "customData"
})
public class Firmware {

    /**
     * URI defining the origin of the firmware.
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    @JsonPropertyDescription("URI defining the origin of the firmware.\r\n")
    @Size(max = 2000)
    @NotNull
    private String location;
    /**
     * Date and time at which the firmware shall be retrieved.
     * 
     * (Required)
     * 
     */
    @JsonProperty("retrieveDateTime")
    @JsonPropertyDescription("Date and time at which the firmware shall be retrieved.\r\n")
    @NotNull
    private OffsetDateTime retrieveDateTime;
    /**
     * Date and time at which the firmware shall be installed.
     * 
     * 
     */
    @JsonProperty("installDateTime")
    @JsonPropertyDescription("Date and time at which the firmware shall be installed.\r\n")
    private OffsetDateTime installDateTime;
    /**
     * Certificate with which the firmware was signed.
     * PEM encoded X.509 certificate.
     * 
     * 
     */
    @JsonProperty("signingCertificate")
    @JsonPropertyDescription("Certificate with which the firmware was signed.\r\nPEM encoded X.509 certificate.\r\n")
    @Size(max = 5500)
    private String signingCertificate;
    /**
     * Base64 encoded firmware signature.
     * 
     * 
     */
    @JsonProperty("signature")
    @JsonPropertyDescription("Base64 encoded firmware signature.\r\n")
    @Size(max = 800)
    private String signature;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * URI defining the origin of the firmware.
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * URI defining the origin of the firmware.
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    public Firmware withLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Date and time at which the firmware shall be retrieved.
     * 
     * (Required)
     * 
     */
    @JsonProperty("retrieveDateTime")
    public OffsetDateTime getRetrieveDateTime() {
        return retrieveDateTime;
    }

    /**
     * Date and time at which the firmware shall be retrieved.
     * 
     * (Required)
     * 
     */
    @JsonProperty("retrieveDateTime")
    public void setRetrieveDateTime(OffsetDateTime retrieveDateTime) {
        this.retrieveDateTime = retrieveDateTime;
    }

    public Firmware withRetrieveDateTime(OffsetDateTime retrieveDateTime) {
        this.retrieveDateTime = retrieveDateTime;
        return this;
    }

    /**
     * Date and time at which the firmware shall be installed.
     * 
     * 
     */
    @JsonProperty("installDateTime")
    public OffsetDateTime getInstallDateTime() {
        return installDateTime;
    }

    /**
     * Date and time at which the firmware shall be installed.
     * 
     * 
     */
    @JsonProperty("installDateTime")
    public void setInstallDateTime(OffsetDateTime installDateTime) {
        this.installDateTime = installDateTime;
    }

    public Firmware withInstallDateTime(OffsetDateTime installDateTime) {
        this.installDateTime = installDateTime;
        return this;
    }

    /**
     * Certificate with which the firmware was signed.
     * PEM encoded X.509 certificate.
     * 
     * 
     */
    @JsonProperty("signingCertificate")
    public String getSigningCertificate() {
        return signingCertificate;
    }

    /**
     * Certificate with which the firmware was signed.
     * PEM encoded X.509 certificate.
     * 
     * 
     */
    @JsonProperty("signingCertificate")
    public void setSigningCertificate(String signingCertificate) {
        this.signingCertificate = signingCertificate;
    }

    public Firmware withSigningCertificate(String signingCertificate) {
        this.signingCertificate = signingCertificate;
        return this;
    }

    /**
     * Base64 encoded firmware signature.
     * 
     * 
     */
    @JsonProperty("signature")
    public String getSignature() {
        return signature;
    }

    /**
     * Base64 encoded firmware signature.
     * 
     * 
     */
    @JsonProperty("signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Firmware withSignature(String signature) {
        this.signature = signature;
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

    public Firmware withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Firmware.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("retrieveDateTime");
        sb.append('=');
        sb.append(((this.retrieveDateTime == null)?"<null>":this.retrieveDateTime));
        sb.append(',');
        sb.append("installDateTime");
        sb.append('=');
        sb.append(((this.installDateTime == null)?"<null>":this.installDateTime));
        sb.append(',');
        sb.append("signingCertificate");
        sb.append('=');
        sb.append(((this.signingCertificate == null)?"<null>":this.signingCertificate));
        sb.append(',');
        sb.append("signature");
        sb.append('=');
        sb.append(((this.signature == null)?"<null>":this.signature));
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
        result = ((result* 31)+((this.signingCertificate == null)? 0 :this.signingCertificate.hashCode()));
        result = ((result* 31)+((this.retrieveDateTime == null)? 0 :this.retrieveDateTime.hashCode()));
        result = ((result* 31)+((this.signature == null)? 0 :this.signature.hashCode()));
        result = ((result* 31)+((this.location == null)? 0 :this.location.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.installDateTime == null)? 0 :this.installDateTime.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Firmware) == false) {
            return false;
        }
        Firmware rhs = ((Firmware) other);
        return (((((((this.signingCertificate == rhs.signingCertificate)||((this.signingCertificate!= null)&&this.signingCertificate.equals(rhs.signingCertificate)))&&((this.retrieveDateTime == rhs.retrieveDateTime)||((this.retrieveDateTime!= null)&&this.retrieveDateTime.equals(rhs.retrieveDateTime))))&&((this.signature == rhs.signature)||((this.signature!= null)&&this.signature.equals(rhs.signature))))&&((this.location == rhs.location)||((this.location!= null)&&this.location.equals(rhs.location))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.installDateTime == rhs.installDateTime)||((this.installDateTime!= null)&&this.installDateTime.equals(rhs.installDateTime))));
    }

}
