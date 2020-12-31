package com.tesla.api.data.model.commands;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class CommandResponse implements Serializable {
    @SerializedName("response")
    private CmdResponse response = null;

    public CommandResponse response(CmdResponse response) {
        this.response = response;
        return this;
    }

    /**
     * Get response
     * @return response
     **/
    public CmdResponse getResponse() {
        return response;
    }

    public void setResponse(CmdResponse response) {
        this.response = response;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommandResponse commandResponse = (CommandResponse) o;
        return Objects.equals(this.response, commandResponse.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommandResponse {\n");

        sb.append("    response: ").append(toIndentedString(response)).append("\n");
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
