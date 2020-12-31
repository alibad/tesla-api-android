package com.tesla.api.data.model;

import java.io.Serializable;
import java.util.*;
import com.google.gson.annotations.SerializedName;

public class VehicleDataResponse implements Serializable {
    @SerializedName("response")
    private VehicleData response = null;

    public VehicleDataResponse response(VehicleData response) {
        this.response = response;
        return this;
    }

    /**
     * Get response
     * @return response
     **/
    public VehicleData getResponse() {
        return response;
    }

    public void setResponse(VehicleData response) {
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
        VehicleDataResponse vehicleDataResponse = (VehicleDataResponse) o;
        return Objects.equals(this.response, vehicleDataResponse.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VehicleDataResponse {\n");

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
