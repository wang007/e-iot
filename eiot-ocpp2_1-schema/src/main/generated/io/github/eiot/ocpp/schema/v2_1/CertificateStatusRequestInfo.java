
package io.github.eiot.ocpp.schema.v2_1;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Data necessary to request the revocation status of a certificate.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certificateHashData",
    "source",
    "urls",
    "customData"
})
public class CertificateStatusRequestInfo {

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
     * URL(s) of _source_.
     * 
     * (Required)
     * 
     */
    @JsonProperty("urls")
    @JsonPropertyDescription("URL(s) of _source_.\r\n")
    @Size(min = 1, max = 5)
    @Valid
    @NotNull
    private List<String> urls = new ArrayList<String>();
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

    public CertificateStatusRequestInfo withCertificateHashData(CertificateHashData certificateHashData) {
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

    public CertificateStatusRequestInfo withSource(CertificateStatusSourceEnum source) {
        this.source = source;
        return this;
    }

    /**
     * URL(s) of _source_.
     * 
     * (Required)
     * 
     */
    @JsonProperty("urls")
    public List<String> getUrls() {
        return urls;
    }

    /**
     * URL(s) of _source_.
     * 
     * (Required)
     * 
     */
    @JsonProperty("urls")
    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public CertificateStatusRequestInfo withUrls(List<String> urls) {
        this.urls = urls;
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

    public CertificateStatusRequestInfo withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CertificateStatusRequestInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("certificateHashData");
        sb.append('=');
        sb.append(((this.certificateHashData == null)?"<null>":this.certificateHashData));
        sb.append(',');
        sb.append("source");
        sb.append('=');
        sb.append(((this.source == null)?"<null>":this.source));
        sb.append(',');
        sb.append("urls");
        sb.append('=');
        sb.append(((this.urls == null)?"<null>":this.urls));
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
        result = ((result* 31)+((this.urls == null)? 0 :this.urls.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.certificateHashData == null)? 0 :this.certificateHashData.hashCode()));
        result = ((result* 31)+((this.source == null)? 0 :this.source.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CertificateStatusRequestInfo) == false) {
            return false;
        }
        CertificateStatusRequestInfo rhs = ((CertificateStatusRequestInfo) other);
        return (((((this.urls == rhs.urls)||((this.urls!= null)&&this.urls.equals(rhs.urls)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.certificateHashData == rhs.certificateHashData)||((this.certificateHashData!= null)&&this.certificateHashData.equals(rhs.certificateHashData))))&&((this.source == rhs.source)||((this.source!= null)&&this.source.equals(rhs.source))));
    }

}
