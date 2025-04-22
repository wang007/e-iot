
package io.github.eiot.ocpp.schema.v2_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * VPN Configuration settings
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "server",
    "user",
    "group",
    "password",
    "key",
    "type",
    "customData"
})
public class VPN {

    /**
     * VPN Server Address
     * 
     * (Required)
     * 
     */
    @JsonProperty("server")
    @JsonPropertyDescription("VPN Server Address\r\n")
    @Size(max = 2000)
    @NotNull
    private String server;
    /**
     * VPN User
     * 
     * (Required)
     * 
     */
    @JsonProperty("user")
    @JsonPropertyDescription("VPN User\r\n")
    @Size(max = 50)
    @NotNull
    private String user;
    /**
     * VPN group.
     * 
     * 
     */
    @JsonProperty("group")
    @JsonPropertyDescription("VPN group.\r\n")
    @Size(max = 50)
    private String group;
    /**
     * *(2.1)* VPN Password.
     * 
     * (Required)
     * 
     */
    @JsonProperty("password")
    @JsonPropertyDescription("*(2.1)* VPN Password.\r\n")
    @Size(max = 64)
    @NotNull
    private String password;
    /**
     * VPN shared secret.
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    @JsonPropertyDescription("VPN shared secret.\r\n")
    @Size(max = 255)
    @NotNull
    private String key;
    /**
     * Type of VPN
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of VPN\r\n")
    @NotNull
    private VPNEnum type;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    /**
     * VPN Server Address
     * 
     * (Required)
     * 
     */
    @JsonProperty("server")
    public String getServer() {
        return server;
    }

    /**
     * VPN Server Address
     * 
     * (Required)
     * 
     */
    @JsonProperty("server")
    public void setServer(String server) {
        this.server = server;
    }

    public VPN withServer(String server) {
        this.server = server;
        return this;
    }

    /**
     * VPN User
     * 
     * (Required)
     * 
     */
    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    /**
     * VPN User
     * 
     * (Required)
     * 
     */
    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    public VPN withUser(String user) {
        this.user = user;
        return this;
    }

    /**
     * VPN group.
     * 
     * 
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * VPN group.
     * 
     * 
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    public VPN withGroup(String group) {
        this.group = group;
        return this;
    }

    /**
     * *(2.1)* VPN Password.
     * 
     * (Required)
     * 
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * *(2.1)* VPN Password.
     * 
     * (Required)
     * 
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    public VPN withPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * VPN shared secret.
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * VPN shared secret.
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    public VPN withKey(String key) {
        this.key = key;
        return this;
    }

    /**
     * Type of VPN
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public VPNEnum getType() {
        return type;
    }

    /**
     * Type of VPN
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(VPNEnum type) {
        this.type = type;
    }

    public VPN withType(VPNEnum type) {
        this.type = type;
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

    public VPN withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VPN.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("server");
        sb.append('=');
        sb.append(((this.server == null)?"<null>":this.server));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("group");
        sb.append('=');
        sb.append(((this.group == null)?"<null>":this.group));
        sb.append(',');
        sb.append("password");
        sb.append('=');
        sb.append(((this.password == null)?"<null>":this.password));
        sb.append(',');
        sb.append("key");
        sb.append('=');
        sb.append(((this.key == null)?"<null>":this.key));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
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
        result = ((result* 31)+((this.server == null)? 0 :this.server.hashCode()));
        result = ((result* 31)+((this.password == null)? 0 :this.password.hashCode()));
        result = ((result* 31)+((this.customData == null)? 0 :this.customData.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.user == null)? 0 :this.user.hashCode()));
        result = ((result* 31)+((this.key == null)? 0 :this.key.hashCode()));
        result = ((result* 31)+((this.group == null)? 0 :this.group.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VPN) == false) {
            return false;
        }
        VPN rhs = ((VPN) other);
        return ((((((((this.server == rhs.server)||((this.server!= null)&&this.server.equals(rhs.server)))&&((this.password == rhs.password)||((this.password!= null)&&this.password.equals(rhs.password))))&&((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.user == rhs.user)||((this.user!= null)&&this.user.equals(rhs.user))))&&((this.key == rhs.key)||((this.key!= null)&&this.key.equals(rhs.key))))&&((this.group == rhs.group)||((this.group!= null)&&this.group.equals(rhs.group))));
    }

}
