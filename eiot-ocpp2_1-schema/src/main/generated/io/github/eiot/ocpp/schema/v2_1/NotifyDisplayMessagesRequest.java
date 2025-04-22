
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
    "messageInfo",
    "requestId",
    "tbc",
    "customData"
})
public class NotifyDisplayMessagesRequest {

    @JsonProperty("messageInfo")
    @Size(min = 1)
    @Valid
    private List<MessageInfo> messageInfo = new ArrayList<MessageInfo>();
    /**
     * The id of the &lt;&lt;getdisplaymessagesrequest,GetDisplayMessagesRequest&gt;&gt; that requested this message.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("The id of the &lt;&lt;getdisplaymessagesrequest,GetDisplayMessagesRequest&gt;&gt; that requested this message.\r\n")
    @NotNull
    private int requestId;
    /**
     * "to be continued" indicator. Indicates whether another part of the report follows in an upcoming NotifyDisplayMessagesRequest message. Default value when omitted is false.
     * 
     * 
     */
    @JsonProperty("tbc")
    @JsonPropertyDescription("\"to be continued\" indicator. Indicates whether another part of the report follows in an upcoming NotifyDisplayMessagesRequest message. Default value when omitted is false.\r\n")
    private boolean tbc = false;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

    @JsonProperty("messageInfo")
    public List<MessageInfo> getMessageInfo() {
        return messageInfo;
    }

    @JsonProperty("messageInfo")
    public void setMessageInfo(List<MessageInfo> messageInfo) {
        this.messageInfo = messageInfo;
    }

    public NotifyDisplayMessagesRequest withMessageInfo(List<MessageInfo> messageInfo) {
        this.messageInfo = messageInfo;
        return this;
    }

    /**
     * The id of the &lt;&lt;getdisplaymessagesrequest,GetDisplayMessagesRequest&gt;&gt; that requested this message.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public int getRequestId() {
        return requestId;
    }

    /**
     * The id of the &lt;&lt;getdisplaymessagesrequest,GetDisplayMessagesRequest&gt;&gt; that requested this message.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public NotifyDisplayMessagesRequest withRequestId(int requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * "to be continued" indicator. Indicates whether another part of the report follows in an upcoming NotifyDisplayMessagesRequest message. Default value when omitted is false.
     * 
     * 
     */
    @JsonProperty("tbc")
    public boolean isTbc() {
        return tbc;
    }

    /**
     * "to be continued" indicator. Indicates whether another part of the report follows in an upcoming NotifyDisplayMessagesRequest message. Default value when omitted is false.
     * 
     * 
     */
    @JsonProperty("tbc")
    public void setTbc(boolean tbc) {
        this.tbc = tbc;
    }

    public NotifyDisplayMessagesRequest withTbc(boolean tbc) {
        this.tbc = tbc;
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

    public NotifyDisplayMessagesRequest withCustomData(CustomData customData) {
        this.customData = customData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NotifyDisplayMessagesRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("messageInfo");
        sb.append('=');
        sb.append(((this.messageInfo == null)?"<null>":this.messageInfo));
        sb.append(',');
        sb.append("requestId");
        sb.append('=');
        sb.append(this.requestId);
        sb.append(',');
        sb.append("tbc");
        sb.append('=');
        sb.append(this.tbc);
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
        result = ((result* 31)+(this.tbc? 1 : 0));
        result = ((result* 31)+((this.messageInfo == null)? 0 :this.messageInfo.hashCode()));
        result = ((result* 31)+ this.requestId);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NotifyDisplayMessagesRequest) == false) {
            return false;
        }
        NotifyDisplayMessagesRequest rhs = ((NotifyDisplayMessagesRequest) other);
        return (((((this.customData == rhs.customData)||((this.customData!= null)&&this.customData.equals(rhs.customData)))&&(this.tbc == rhs.tbc))&&((this.messageInfo == rhs.messageInfo)||((this.messageInfo!= null)&&this.messageInfo.equals(rhs.messageInfo))))&&(this.requestId == rhs.requestId));
    }

}
