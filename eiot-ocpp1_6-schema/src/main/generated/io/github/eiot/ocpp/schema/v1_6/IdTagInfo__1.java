
package io.github.eiot.ocpp.schema.v1_6;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "expiryDate",
    "parentIdTag",
    "status"
})
public class IdTagInfo__1 {

    @JsonProperty("expiryDate")
    private ZonedDateTime expiryDate;
    @JsonProperty("parentIdTag")
    @Size(max = 20)
    private String parentIdTag;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @NotNull
    private IdTagInfo__1 .Status status;

    @JsonProperty("expiryDate")
    public ZonedDateTime getExpiryDate() {
        return expiryDate;
    }

    @JsonProperty("expiryDate")
    public void setExpiryDate(ZonedDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public IdTagInfo__1 withExpiryDate(ZonedDateTime expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    @JsonProperty("parentIdTag")
    public String getParentIdTag() {
        return parentIdTag;
    }

    @JsonProperty("parentIdTag")
    public void setParentIdTag(String parentIdTag) {
        this.parentIdTag = parentIdTag;
    }

    public IdTagInfo__1 withParentIdTag(String parentIdTag) {
        this.parentIdTag = parentIdTag;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public IdTagInfo__1 .Status getStatus() {
        return status;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(IdTagInfo__1 .Status status) {
        this.status = status;
    }

    public IdTagInfo__1 withStatus(IdTagInfo__1 .Status status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IdTagInfo__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("expiryDate");
        sb.append('=');
        sb.append(((this.expiryDate == null)?"<null>":this.expiryDate));
        sb.append(',');
        sb.append("parentIdTag");
        sb.append('=');
        sb.append(((this.parentIdTag == null)?"<null>":this.parentIdTag));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
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
        result = ((result* 31)+((this.expiryDate == null)? 0 :this.expiryDate.hashCode()));
        result = ((result* 31)+((this.parentIdTag == null)? 0 :this.parentIdTag.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IdTagInfo__1) == false) {
            return false;
        }
        IdTagInfo__1 rhs = ((IdTagInfo__1) other);
        return ((((this.expiryDate == rhs.expiryDate)||((this.expiryDate!= null)&&this.expiryDate.equals(rhs.expiryDate)))&&((this.parentIdTag == rhs.parentIdTag)||((this.parentIdTag!= null)&&this.parentIdTag.equals(rhs.parentIdTag))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

    public enum Status {

        ACCEPTED("Accepted"),
        BLOCKED("Blocked"),
        EXPIRED("Expired"),
        INVALID("Invalid"),
        CONCURRENT_TX("ConcurrentTx");
        private final String value;
        private final static Map<String, IdTagInfo__1 .Status> CONSTANTS = new HashMap<String, IdTagInfo__1 .Status>();

        static {
            for (IdTagInfo__1 .Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Status(String value) {
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
        public static IdTagInfo__1 .Status fromValue(String value) {
            IdTagInfo__1 .Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
