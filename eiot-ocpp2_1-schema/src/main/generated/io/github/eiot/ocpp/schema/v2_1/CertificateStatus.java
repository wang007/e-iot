
package io.github.eiot.ocpp.schema.v2_1;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * Revocation status of certificate
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certificateHashData",
    "source",
    "status",
    "nextUpdate",
    "customData"
})
public class CertificateStatus {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("certificateHashData")
    @Valid
    @NotNull
    private CertificateHashData certificateHashData;
    /**
     * Source of status: OCSP, CRL
     * 
     * (Required)
     * 
     */
    @JsonProperty("source")
    @JsonPropertyDescription("Source of status: OCSP, CRL\r\n")
    @NotNull
    private CertificateStatusSourceEnum source;
    /**
     * Status of certificate: good, revoked or unknown.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Status of certificate: good, revoked or unknown.\r\n")
    @NotNull
    private CertificateStatusEnum status;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("nextUpdate")
    @NotNull
    private OffsetDateTime nextUpdate;
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
    @JsonProperty("certificateHashData")
    public CertificateHashData getCertificateHashData() {
        return certificateHashData;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("certificateHashData")
    public void setCertificateHashData(CertificateHashData certificateHashData) {
        this.certificateHashData = certificateHashData;
    }

    public CertificateStatus withCertificateHashData(CertificateHashData certificateHashData) {
        this.certificateHashData = certificateHashData;
        return this;
    }

    /**
     * Source of status: OCSP, CRL
     * 
     * (Required)
     * 
     */
    @JsonProperty("source")
    public CertificateStatusSourceEnum getSource() {
        return source;
    }

    /**
     * Source of status: OCSP, CRL
     * 
     * (Required)
     * 
     */
    @JsonProperty("source")
    public void setSource(CertificateStatusSourceEnum source) {
        this.source = source;
    }

    public CertificateStatus withSource(CertificateStatusSourceEnum source) {
        this.source = source;
        return this;
    }

    /**
     * Status of certificate: good, revoked or unknown.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public CertificateStatusEnum getStatus() {
        return status;
    }

    /**
     * Status of certificate: good, revoked or unknown.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(CertificateStatusEnum status) {
        this.status = status;
    }

    public CertificateStatus withStatus(CertificateStatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("nextUpdate")
    public OffsetDateTime getNextUpdate() {
        return nextUpdate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("nextUpdate")
    public void setNextUpdate(OffsetDateTime nextUpdate) {
        this.nextUpdate = nextUpdate;
    }

    public CertificateStatus withNextUpdate(OffsetDateTime nextUpdate) {
        this.nextUpdate = nextUpdate;
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

    public CertificateStatus withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CertificateStatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("certificateHashData");
        sb.append('=');
        sb.append(((this.certificateHashData == null)?"<null>":this.certificateHashData));
        sb.append(',');
        sb.append("source");
        sb.append('=');
        sb.append(((this.source == null)?"<null>":this.source));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("nextUpdate");
        sb.append('=');
        sb.append(((this.nextUpdate == null)?"<null>":this.nextUpdate));
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
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.certificateHashData == null)? 0 :this.certificateHashData.hashCode()));
        result = ((result* 31)+((this.source == null)? 0 :this.source.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        result = ((result* 31)+((this.nextUpdate == null)? 0 :this.nextUpdate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CertificateStatus) == false) {
            return false;
        }
        CertificateStatus rhs = ((CertificateStatus) other);
        return ((((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.certificateHashData == rhs.certificateHashData)||((this.certificateHashData!= null)&&this.certificateHashData.equals(rhs.certificateHashData))))&&((this.source == rhs.source)||((this.source!= null)&&this.source.equals(rhs.source))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))))&&((this.nextUpdate == rhs.nextUpdate)||((this.nextUpdate!= null)&&this.nextUpdate.equals(rhs.nextUpdate))));
    }

}
