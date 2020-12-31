package com.tesla.api.data.model.commands;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class CmdResponse implements Serializable {
    @SerializedName("result")
    private Boolean result = null;

    @SerializedName("reason")
    private String reason = null;

    public CmdResponse result(Boolean result) {
        this.result = result;
        return this;
    }

    /**
     * Get result
     * @return result
     **/
    public Boolean isResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public CmdResponse reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     * @return reason
     **/
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CmdResponse commandResponseResponse = (CmdResponse) o;
        return Objects.equals(this.result, commandResponseResponse.result) &&
                Objects.equals(this.reason, commandResponseResponse.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, reason);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommandResponseResponse {\n");

        sb.append("    result: ").append(toIndentedString(result)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}