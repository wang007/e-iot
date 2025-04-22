
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * AuthorizeRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idTag"
})
public class AuthorizeRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTag")
    @Size(max = 20)
    @NotNull
    private String idTag;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTag")
    public String getIdTag() {
        return idTag;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTag")
    public void setIdTag(String idTag) {
        this.idTag = idTag;
    }

    public AuthorizeRequest withIdTag(String idTag) {
        this.idTag = idTag;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AuthorizeRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("idTag");
        sb.append('=');
        sb.append(((this.idTag == null)?"<null>":this.idTag));
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
        result = ((result* 31)+((this.idTag == null)? 0 :this.idTag.hashCode()));
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
        return ((this.idTag == rhs.idTag)||((this.idTag!= null)&&this.idTag.equals(rhs.idTag)));
    }

}
