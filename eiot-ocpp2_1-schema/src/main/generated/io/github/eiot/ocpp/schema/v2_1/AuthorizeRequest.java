
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idToken",
    "certificate",
    "iso15118CertificateHashData",
    "customData"
})
public class AuthorizeRequest {

    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idToken")
    @JsonPropertyDescription("Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.\r\n")
    @Valid
    @NotNull
    private IdToken idToken;
    /**
     * *(2.1)* The X.509 certificate chain presented by EV and encoded in PEM format. Order of certificates in chain is from leaf up to (but excluding) root certificate. +
     * Only needed in case of central contract validation when Charging Station cannot validate the contract certificate.
     * 
     * 
     * 
     */
    @JsonProperty("certificate")
    @JsonPropertyDescription("*(2.1)* The X.509 certificate chain presented by EV and encoded in PEM format. Order of certificates in chain is from leaf up to (but excluding) root certificate. +\r\nOnly needed in case of central contract validation when Charging Station cannot validate the contract certificate.\r\n\r\n")
    @Size(max = 10000)
    private String certificate;
    @JsonProperty("iso15118CertificateHashData")
    @Size(min = 1, max = 4)
    @Valid
    private List<OCSPRequestData> iso15118CertificateHashData = new ArrayList<OCSPRequestData>();
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idToken")
    public IdToken getIdToken() {
        return idToken;
    }

    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idToken")
    public void setIdToken(IdToken idToken) {
        this.idToken = idToken;
    }

    public AuthorizeRequest withIdToken(IdToken idToken) {
        this.idToken = idToken;
        return this;
    }

    /**
     * *(2.1)* The X.509 certificate chain presented by EV and encoded in PEM format. Order of certificates in chain is from leaf up to (but excluding) root certificate. +
     * Only needed in case of central contract validation when Charging Station cannot validate the contract certificate.
     * 
     * 
     * 
     */
    @JsonProperty("certificate")
    public String getCertificate() {
        return certificate;
    }

    /**
     * *(2.1)* The X.509 certificate chain presented by EV and encoded in PEM format. Order of certificates in chain is from leaf up to (but excluding) root certificate. +
     * Only needed in case of central contract validation when Charging Station cannot validate the contract certificate.
     * 
     * 
     * 
     */
    @JsonProperty("certificate")
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public AuthorizeRequest withCertificate(String certificate) {
        this.certificate = certificate;
        return this;
    }

    @JsonProperty("iso15118CertificateHashData")
    public List<OCSPRequestData> getIso15118CertificateHashData() {
        return iso15118CertificateHashData;
    }

    @JsonProperty("iso15118CertificateHashData")
    public void setIso15118CertificateHashData(List<OCSPRequestData> iso15118CertificateHashData) {
        this.iso15118CertificateHashData = iso15118CertificateHashData;
    }

    public AuthorizeRequest withIso15118CertificateHashData(List<OCSPRequestData> iso15118CertificateHashData) {
        this.iso15118CertificateHashData = iso15118CertificateHashData;
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

    public AuthorizeRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AuthorizeRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("idToken");
        sb.append('=');
        sb.append(((this.idToken == null)?"<null>":this.idToken));
        sb.append(',');
        sb.append("certificate");
        sb.append('=');
        sb.append(((this.certificate == null)?"<null>":this.certificate));
        sb.append(',');
        sb.append("iso15118CertificateHashData");
        sb.append('=');
        sb.append(((this.iso15118CertificateHashData == null)?"<null>":this.iso15118CertificateHashData));
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
        result = ((result* 31)+((this.idToken == null)? 0 :this.idToken.hashCode()));
        result = ((result* 31)+((this.certificate == null)? 0 :this.certificate.hashCode()));
        result = ((result* 31)+((this.iso15118CertificateHashData == null)? 0 :this.iso15118CertificateHashData.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AuthorizeRequest) == false) {
            return false;
        }
        AuthorizeRequest rhs = ((AuthorizeRequest) other);
        return (((((this.idToken == rhs.idToken)||((this.idToken!= null)&&this.idToken.equals(rhs.idToken)))&&((this.certificate == rhs.certificate)||((this.certificate!= null)&&this.certificate.equals(rhs.certificate))))&&((this.iso15118CertificateHashData == rhs.iso15118CertificateHashData)||((this.iso15118CertificateHashData!= null)&&this.iso15118CertificateHashData.equals(rhs.iso15118CertificateHashData))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
