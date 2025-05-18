
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;


/**
 * GetLocalListVersionResponse
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "listVersion"
})
public class GetLocalListVersionResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("listVersion")
    @NotNull
    private int listVersion;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("listVersion")
    public int getListVersion() {
        return listVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("listVersion")
    public void setListVersion(int listVersion) {
        this.listVersion = listVersion;
    }

    public GetLocalListVersionResponse withListVersion(int listVersion) {
        this.listVersion = listVersion;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetLocalListVersionResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("listVersion");
        sb.append('=');
        sb.append(this.listVersion);
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
        result = ((result* 31)+ this.listVersion);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetLocalListVersionResponse) == false) {
            return false;
        }
        GetLocalListVersionResponse rhs = ((GetLocalListVersionResponse) other);
        return (this.listVersion == rhs.listVersion);
    }

}
