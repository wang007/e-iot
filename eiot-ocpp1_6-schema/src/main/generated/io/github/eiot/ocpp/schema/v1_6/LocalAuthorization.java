
package io.github.eiot.ocpp.schema.v1_6;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idTag",
    "idTagInfo"
})
public class LocalAuthorization {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTag")
    @Size(max = 20)
    @NotNull
    private String idTag;
    @JsonProperty("idTagInfo")
    @Valid
    private IdTagInfo__1 idTagInfo;

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

    public LocalAuthorization withIdTag(String idTag) {
        this.idTag = idTag;
        return this;
    }

    @JsonProperty("idTagInfo")
    public IdTagInfo__1 getIdTagInfo() {
        return idTagInfo;
    }

    @JsonProperty("idTagInfo")
    public void setIdTagInfo(IdTagInfo__1 idTagInfo) {
        this.idTagInfo = idTagInfo;
    }

    public LocalAuthorization withIdTagInfo(IdTagInfo__1 idTagInfo) {
        this.idTagInfo = idTagInfo;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LocalAuthorization.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("idTag");
        sb.append('=');
        sb.append(((this.idTag == null)?"<null>":this.idTag));
        sb.append(',');
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
        result = ((result* 31)+((this.idTag == null)? 0 :this.idTag.hashCode()));
        result = ((result* 31)+((this.idTagInfo == null)? 0 :this.idTagInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LocalAuthorization) == false) {
            return false;
        }
        LocalAuthorization rhs = ((LocalAuthorization) other);
        return (((this.idTag == rhs.idTag)||((this.idTag!= null)&&this.idTag.equals(rhs.idTag)))&&((this.idTagInfo == rhs.idTagInfo)||((this.idTagInfo!= null)&&this.idTagInfo.equals(rhs.idTagInfo))));
    }

}
