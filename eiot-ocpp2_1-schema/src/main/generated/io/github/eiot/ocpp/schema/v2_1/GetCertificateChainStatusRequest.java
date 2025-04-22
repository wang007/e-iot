
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
    "certificateStatusRequests",
    "customData"
})
public class GetCertificateChainStatusRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("certificateStatusRequests")
    @Size(min = 1, max = 4)
    @Valid
    @NotNull
    private List<CertificateStatusRequestInfo> certificateStatusRequests = new ArrayList<CertificateStatusRequestInfo>();
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
    @JsonProperty("certificateStatusRequests")
    public List<CertificateStatusRequestInfo> getCertificateStatusRequests() {
        return certificateStatusRequests;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("certificateStatusRequests")
    public void setCertificateStatusRequests(List<CertificateStatusRequestInfo> certificateStatusRequests) {
        this.certificateStatusRequests = certificateStatusRequests;
    }

    public GetCertificateChainStatusRequest withCertificateStatusRequests(List<CertificateStatusRequestInfo> certificateStatusRequests) {
        this.certificateStatusRequests = certificateStatusRequests;
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

    public GetCertificateChainStatusRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetCertificateChainStatusRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("certificateStatusRequests");
        sb.append('=');
        sb.append(((this.certificateStatusRequests == null)?"<null>":this.certificateStatusRequests));
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
        result = ((result* 31)+((this.certificateStatusRequests == null)? 0 :this.certificateStatusRequests.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetCertificateChainStatusRequest) == false) {
            return false;
        }
        GetCertificateChainStatusRequest rhs = ((GetCertificateChainStatusRequest) other);
        return (((this.certificateStatusRequests == rhs.certificateStatusRequests)||((this.certificateStatusRequests!= null)&&this.certificateStatusRequests.equals(rhs.certificateStatusRequests)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))));
    }

}
