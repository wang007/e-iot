
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
    "certificateStatus",
    "customData"
})
public class GetCertificateChainStatusResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("certificateStatus")
    @Size(min = 1, max = 4)
    @Valid
    @NotNull
    private List<CertificateStatus> certificateStatus = new ArrayList<CertificateStatus>();
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
    @JsonProperty("certificateStatus")
    public List<CertificateStatus> getCertificateStatus() {
        return certificateStatus;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("certificateStatus")
    public void setCertificateStatus(List<CertificateStatus> certificateStatus) {
        this.certificateStatus = certificateStatus;
    }

    public GetCertificateChainStatusResponse withCertificateStatus(List<CertificateStatus> certificateStatus) {
        this.certificateStatus = certificateStatus;
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

    public GetCertificateChainStatusResponse withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetCertificateChainStatusResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("certificateStatus");
        sb.append('=');
        sb.append(((this.certificateStatus == null)?"<null>":this.certificateStatus));
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
        result = ((result* 31)+((this.certificateStatus == null)? 0 :this.certificateStatus.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetCertificateChainStatusResponse) == false) {
            return false;
        }
        GetCertificateChainStatusResponse rhs = ((GetCertificateChainStatusResponse) other);
        return (((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&((this.certificateStatus == rhs.certificateStatus)||((this.certificateStatus!= null)&&this.certificateStatus.equals(rhs.certificateStatus))));
    }

}
