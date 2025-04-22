
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Part of ISO 15118-20 price schedule.
 * 
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "serviceFee",
    "serviceName",
    "customData"
})
public class AdditionalSelectedServices {

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceFee")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    @NotNull
    private RationalNumber serviceFee;
    /**
     * Human readable string to identify this service.
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceName")
    @JsonPropertyDescription("Human readable string to identify this service.\r\n")
    @Size(max = 80)
    @NotNull
    private String serviceName;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceFee")
    public RationalNumber getServiceFee() {
        return serviceFee;
    }

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceFee")
    public void setServiceFee(RationalNumber serviceFee) {
        this.serviceFee = serviceFee;
    }

    public AdditionalSelectedServices withServiceFee(RationalNumber serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    /**
     * Human readable string to identify this service.
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Human readable string to identify this service.
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public AdditionalSelectedServices withServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public AdditionalSelectedServices withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AdditionalSelectedServices.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("serviceFee");
        sb.append('=');
        sb.append(((this.serviceFee == null)?"<null>":this.serviceFee));
        sb.append(',');
        sb.append("serviceName");
        sb.append('=');
        sb.append(((this.serviceName == null)?"<null>":this.serviceName));
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
        result = ((result* 31)+((this.serviceFee == null)? 0 :this.serviceFee.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.serviceName == null)? 0 :this.serviceName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdditionalSelectedServices) == false) {
            return false;
        }
        AdditionalSelectedServices rhs = ((AdditionalSelectedServices) other);
        return ((((this.serviceFee == rhs.serviceFee)||((this.serviceFee!= null)&&this.serviceFee.equals(rhs.serviceFee)))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.serviceName == rhs.serviceName)||((this.serviceName!= null)&&this.serviceName.equals(rhs.serviceName))));
    }

}
