
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ocspRequestData",
    "customData"
})
public class GetCertificateStatusRequest {

    /**
     * Information about a certificate for an OCSP check.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocspRequestData")
    @JsonPropertyDescription("Information about a certificate for an OCSP check.\r\n")
    @Valid
    @NotNull
    private OCSPRequestData ocspRequestData;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Information about a certificate for an OCSP check.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocspRequestData")
    public OCSPRequestData getOcspRequestData() {
        return ocspRequestData;
    }

    /**
     * Information about a certificate for an OCSP check.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocspRequestData")
    public void setOcspRequestData(OCSPRequestData ocspRequestData) {
        this.ocspRequestData = ocspRequestData;
    }

    public GetCertificateStatusRequest withOcspRequestData(OCSPRequestData ocspRequestData) {
        this.ocspRequestData = ocspRequestData;
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

    public GetCertificateStatusRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetCertificateStatusRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ocspRequestData");
        sb.append('=');
        sb.append(((this.ocspRequestData == null)?"<null>":this.ocspRequestData));
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
        result = ((result* 31)+((this.ocspRequestData == null)? 0 :this.ocspRequestData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetCertificateStatusRequest) == false) {
            return false;
        }
        GetCertificateStatusRequest rhs = ((GetCertificateStatusRequest) other);
        return (((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.ocspRequestData == rhs.ocspRequestData)||((this.ocspRequestData!= null)&&this.ocspRequestData.equals(rhs.ocspRequestData))));
    }

}
