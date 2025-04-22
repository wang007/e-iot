
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * DataTransferRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vendorId",
    "messageId",
    "data"
})
public class DataTransferRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("vendorId")
    @Size(max = 255)
    @NotNull
    private String vendorId;
    @JsonProperty("messageId")
    @Size(max = 50)
    private String messageId;
    @JsonProperty("data")
    private String data;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("vendorId")
    public String getVendorId() {
        return vendorId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("vendorId")
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public DataTransferRequest withVendorId(String vendorId) {
        this.vendorId = vendorId;
        return this;
    }

    @JsonProperty("messageId")
    public String getMessageId() {
        return messageId;
    }

    @JsonProperty("messageId")
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public DataTransferRequest withMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    @JsonProperty("data")
    public String getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(String data) {
        this.data = data;
    }

    public DataTransferRequest withData(String data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DataTransferRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("vendorId");
        sb.append('=');
        sb.append(((this.vendorId == null)?"<null>":this.vendorId));
        sb.append(',');
        sb.append("messageId");
        sb.append('=');
        sb.append(((this.messageId == null)?"<null>":this.messageId));
        sb.append(',');
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null)?"<null>":this.data));
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
        result = ((result* 31)+((this.vendorId == null)? 0 :this.vendorId.hashCode()));
        result = ((result* 31)+((this.messageId == null)? 0 :this.messageId.hashCode()));
        result = ((result* 31)+((this.data == null)? 0 :this.data.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DataTransferRequest) == false) {
            return false;
        }
        DataTransferRequest rhs = ((DataTransferRequest) other);
        return ((((this.vendorId == rhs.vendorId)||((this.vendorId!= null)&&this.vendorId.equals(rhs.vendorId)))&&((this.messageId == rhs.messageId)||((this.messageId!= null)&&this.messageId.equals(rhs.messageId))))&&((this.data == rhs.data)||((this.data!= null)&&this.data.equals(rhs.data))));
    }

}
