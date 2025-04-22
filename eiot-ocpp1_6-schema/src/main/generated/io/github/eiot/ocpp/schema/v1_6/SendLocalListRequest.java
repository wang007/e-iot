
package io.github.eiot.ocpp.schema.v1_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


/**
 * SendLocalListRequest
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "listVersion",
    "localAuthorizationList",
    "updateType"
})
public class SendLocalListRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("listVersion")
    @NotNull
    private int listVersion;
    @JsonProperty("localAuthorizationList")
    @Valid
    private List<LocalAuthorization> localAuthorizationList = new ArrayList<LocalAuthorization>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("updateType")
    @NotNull
    private SendLocalListRequest.UpdateType updateType;

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

    public SendLocalListRequest withListVersion(int listVersion) {
        this.listVersion = listVersion;
        return this;
    }

    @JsonProperty("localAuthorizationList")
    public List<LocalAuthorization> getLocalAuthorizationList() {
        return localAuthorizationList;
    }

    @JsonProperty("localAuthorizationList")
    public void setLocalAuthorizationList(List<LocalAuthorization> localAuthorizationList) {
        this.localAuthorizationList = localAuthorizationList;
    }

    public SendLocalListRequest withLocalAuthorizationList(List<LocalAuthorization> localAuthorizationList) {
        this.localAuthorizationList = localAuthorizationList;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("updateType")
    public SendLocalListRequest.UpdateType getUpdateType() {
        return updateType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("updateType")
    public void setUpdateType(SendLocalListRequest.UpdateType updateType) {
        this.updateType = updateType;
    }

    public SendLocalListRequest withUpdateType(SendLocalListRequest.UpdateType updateType) {
        this.updateType = updateType;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SendLocalListRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("listVersion");
        sb.append('=');
        sb.append(this.listVersion);
        sb.append(',');
        sb.append("localAuthorizationList");
        sb.append('=');
        sb.append(((this.localAuthorizationList == null)?"<null>":this.localAuthorizationList));
        sb.append(',');
        sb.append("updateType");
        sb.append('=');
        sb.append(((this.updateType == null)?"<null>":this.updateType));
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
        result = ((result* 31)+((this.localAuthorizationList == null)? 0 :this.localAuthorizationList.hashCode()));
        result = ((result* 31)+((this.updateType == null)? 0 :this.updateType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SendLocalListRequest) == false) {
            return false;
        }
        SendLocalListRequest rhs = ((SendLocalListRequest) other);
        return (((this.listVersion == rhs.listVersion)&&((this.localAuthorizationList == rhs.localAuthorizationList)||((this.localAuthorizationList!= null)&&this.localAuthorizationList.equals(rhs.localAuthorizationList))))&&((this.updateType == rhs.updateType)||((this.updateType!= null)&&this.updateType.equals(rhs.updateType))));
    }

    public enum UpdateType {

        DIFFERENTIAL("Differential"),
        FULL("Full");
        private final String value;
        private final static Map<String, SendLocalListRequest.UpdateType> CONSTANTS = new HashMap<String, SendLocalListRequest.UpdateType>();

        static {
            for (SendLocalListRequest.UpdateType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        UpdateType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SendLocalListRequest.UpdateType fromValue(String value) {
            SendLocalListRequest.UpdateType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
