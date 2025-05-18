
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;


/**
 * StopTransactionResponse
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idTagInfo"
})
public class StopTransactionResponse {

    @JsonProperty("idTagInfo")
    @Valid
    private IdTagInfo__3 idTagInfo;

    @JsonProperty("idTagInfo")
    public IdTagInfo__3 getIdTagInfo() {
        return idTagInfo;
    }

    @JsonProperty("idTagInfo")
    public void setIdTagInfo(IdTagInfo__3 idTagInfo) {
        this.idTagInfo = idTagInfo;
    }

    public StopTransactionResponse withIdTagInfo(IdTagInfo__3 idTagInfo) {
        this.idTagInfo = idTagInfo;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StopTransactionResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("idTagInfo");
        sb.append('=');
        sb.append(((this.idTagInfo == null)?"<null>":this.idTagInfo));
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
        result = ((result* 31)+((this.idTagInfo == null)? 0 :this.idTagInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StopTransactionResponse) == false) {
            return false;
        }
        StopTransactionResponse rhs = ((StopTransactionResponse) other);
        return ((this.idTagInfo == rhs.idTagInfo)||((this.idTagInfo!= null)&&this.idTagInfo.equals(rhs.idTagInfo)));
    }

}
