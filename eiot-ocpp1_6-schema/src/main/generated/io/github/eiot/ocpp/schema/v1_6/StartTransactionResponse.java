
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * StartTransactionResponse
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idTagInfo",
    "transactionId"
})
public class StartTransactionResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTagInfo")
    @Valid
    @NotNull
    private IdTagInfo__2 idTagInfo;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    @NotNull
    private int transactionId;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTagInfo")
    public IdTagInfo__2 getIdTagInfo() {
        return idTagInfo;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTagInfo")
    public void setIdTagInfo(IdTagInfo__2 idTagInfo) {
        this.idTagInfo = idTagInfo;
    }

    public StartTransactionResponse withIdTagInfo(IdTagInfo__2 idTagInfo) {
        this.idTagInfo = idTagInfo;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    public int getTransactionId() {
        return transactionId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public StartTransactionResponse withTransactionId(int transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StartTransactionResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("idTagInfo");
        sb.append('=');
        sb.append(((this.idTagInfo == null)?"<null>":this.idTagInfo));
        sb.append(',');
        sb.append("transactionId");
        sb.append('=');
        sb.append(this.transactionId);
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
        result = ((result* 31)+ this.transactionId);
        result = ((result* 31)+((this.idTagInfo == null)? 0 :this.idTagInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StartTransactionResponse) == false) {
            return false;
        }
        StartTransactionResponse rhs = ((StartTransactionResponse) other);
        return ((this.transactionId == rhs.transactionId)&&((this.idTagInfo == rhs.idTagInfo)||((this.idTagInfo!= null)&&this.idTagInfo.equals(rhs.idTagInfo))));
    }

}
