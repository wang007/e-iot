
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
    "hashAlgorithm",
    "issuerNameHash",
    "issuerKeyHash",
    "serialNumber",
    "customData"
})
public class CertificateHashData {

    /**
     * Used algorithms for the hashes provided.
     * 
     * (Required)
     * 
     */
    @JsonProperty("hashAlgorithm")
    @JsonPropertyDescription("Used algorithms for the hashes provided.\r\n")
    @NotNull
    private HashAlgorithmEnum hashAlgorithm;
    /**
     * The hash of the issuer’s distinguished
     * name (DN), that must be calculated over the DER
     * encoding of the issuer’s name field in the certificate
     * being checked.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("issuerNameHash")
    @JsonPropertyDescription("The hash of the issuer\u2019s distinguished\r\nname (DN), that must be calculated over the DER\r\nencoding of the issuer\u2019s name field in the certificate\r\nbeing checked.\r\n\r\n")
    @Size(max = 128)
    @NotNull
    private String issuerNameHash;
    /**
     * The hash of the DER encoded public key:
     * the value (excluding tag and length) of the subject
     * public key field in the issuer’s certificate.
     * 
     * (Required)
     * 
     */
    @JsonProperty("issuerKeyHash")
    @JsonPropertyDescription("The hash of the DER encoded public key:\r\nthe value (excluding tag and length) of the subject\r\npublic key field in the issuer\u2019s certificate.\r\n")
    @Size(max = 128)
    @NotNull
    private String issuerKeyHash;
    /**
     * The string representation of the
     * hexadecimal value of the serial number without the
     * prefix "0x" and without leading zeroes.
     * 
     * (Required)
     * 
     */
    @JsonProperty("serialNumber")
    @JsonPropertyDescription("The string representation of the\r\nhexadecimal value of the serial number without the\r\nprefix \"0x\" and without leading zeroes.\r\n")
    @Size(max = 40)
    @NotNull
    private String serialNumber;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Used algorithms for the hashes provided.
     * 
     * (Required)
     * 
     */
    @JsonProperty("hashAlgorithm")
    public HashAlgorithmEnum getHashAlgorithm() {
        return hashAlgorithm;
    }

    /**
     * Used algorithms for the hashes provided.
     * 
     * (Required)
     * 
     */
    @JsonProperty("hashAlgorithm")
    public void setHashAlgorithm(HashAlgorithmEnum hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public CertificateHashData withHashAlgorithm(HashAlgorithmEnum hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
        return this;
    }

    /**
     * The hash of the issuer’s distinguished
     * name (DN), that must be calculated over the DER
     * encoding of the issuer’s name field in the certificate
     * being checked.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("issuerNameHash")
    public String getIssuerNameHash() {
        return issuerNameHash;
    }

    /**
     * The hash of the issuer’s distinguished
     * name (DN), that must be calculated over the DER
     * encoding of the issuer’s name field in the certificate
     * being checked.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("issuerNameHash")
    public void setIssuerNameHash(String issuerNameHash) {
        this.issuerNameHash = issuerNameHash;
    }

    public CertificateHashData withIssuerNameHash(String issuerNameHash) {
        this.issuerNameHash = issuerNameHash;
        return this;
    }

    /**
     * The hash of the DER encoded public key:
     * the value (excluding tag and length) of the subject
     * public key field in the issuer’s certificate.
     * 
     * (Required)
     * 
     */
    @JsonProperty("issuerKeyHash")
    public String getIssuerKeyHash() {
        return issuerKeyHash;
    }

    /**
     * The hash of the DER encoded public key:
     * the value (excluding tag and length) of the subject
     * public key field in the issuer’s certificate.
     * 
     * (Required)
     * 
     */
    @JsonProperty("issuerKeyHash")
    public void setIssuerKeyHash(String issuerKeyHash) {
        this.issuerKeyHash = issuerKeyHash;
    }

    public CertificateHashData withIssuerKeyHash(String issuerKeyHash) {
        this.issuerKeyHash = issuerKeyHash;
        return this;
    }

    /**
     * The string representation of the
     * hexadecimal value of the serial number without the
     * prefix "0x" and without leading zeroes.
     * 
     * (Required)
     * 
     */
    @JsonProperty("serialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * The string representation of the
     * hexadecimal value of the serial number without the
     * prefix "0x" and without leading zeroes.
     * 
     * (Required)
     * 
     */
    @JsonProperty("serialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public CertificateHashData withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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

    public CertificateHashData withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CertificateHashData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("hashAlgorithm");
        sb.append('=');
        sb.append(((this.hashAlgorithm == null)?"<null>":this.hashAlgorithm));
        sb.append(',');
        sb.append("issuerNameHash");
        sb.append('=');
        sb.append(((this.issuerNameHash == null)?"<null>":this.issuerNameHash));
        sb.append(',');
        sb.append("issuerKeyHash");
        sb.append('=');
        sb.append(((this.issuerKeyHash == null)?"<null>":this.issuerKeyHash));
        sb.append(',');
        sb.append("serialNumber");
        sb.append('=');
        sb.append(((this.serialNumber == null)?"<null>":this.serialNumber));
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
        result = ((result* 31)+((this.issuerNameHash == null)? 0 :this.issuerNameHash.hashCode()));
        result = ((result* 31)+((this.issuerKeyHash == null)? 0 :this.issuerKeyHash.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.serialNumber == null)? 0 :this.serialNumber.hashCode()));
        result = ((result* 31)+((this.hashAlgorithm == null)? 0 :this.hashAlgorithm.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CertificateHashData) == false) {
            return false;
        }
        CertificateHashData rhs = ((CertificateHashData) other);
        return ((((((this.issuerNameHash == rhs.issuerNameHash)||((this.issuerNameHash!= null)&&this.issuerNameHash.equals(rhs.issuerNameHash)))&&((this.issuerKeyHash == rhs.issuerKeyHash)||((this.issuerKeyHash!= null)&&this.issuerKeyHash.equals(rhs.issuerKeyHash))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.serialNumber == rhs.serialNumber)||((this.serialNumber!= null)&&this.serialNumber.equals(rhs.serialNumber))))&&((this.hashAlgorithm == rhs.hashAlgorithm)||((this.hashAlgorithm!= null)&&this.hashAlgorithm.equals(rhs.hashAlgorithm))));
    }

}
