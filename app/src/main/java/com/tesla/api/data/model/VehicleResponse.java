package com.tesla.api.data.model;

import java.io.Serializable;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

public class VehicleResponse implements Serializable {
    @SerializedName("response")
    private Vehicle response = null;

    public VehicleResponse response(Vehicle response) {
        this.response = response;
        return this;
    }

    /**
     * Get response
     * @return response
     **/
    public Vehicle getResponse() {
        return response;
    }

    public void setResponse(Vehicle response) {
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
        VehicleResponse vehicleResponse = (VehicleResponse) o;
        return Objects.equals(this.response, vehicleResponse.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VehicleResponse {\n");

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
