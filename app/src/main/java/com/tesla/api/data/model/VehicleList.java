package com.tesla.api.data.model;

import java.io.Serializable;
import java.util.*;
import com.google.gson.annotations.SerializedName;

public class VehicleList implements Serializable {
    @SerializedName("response")
    private List<Vehicle> response = null;

    @SerializedName("count")
    private Long count = null;

    /**
     **/
    public List<Vehicle> getResponse() {
        return response;
    }
    public void setResponse(List<Vehicle> response) {
        this.response = response;
    }

    /**
     **/
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VehicleList vehicleList = (VehicleList) o;
        return (this.response == null ? vehicleList.response == null : this.response.equals(vehicleList.response)) &&
                (this.count == null ? vehicleList.count == null : this.count.equals(vehicleList.count));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (this.response == null ? 0: this.response.hashCode());
        result = 31 * result + (this.count == null ? 0: this.count.hashCode());
        return result;
    }

    @Override
    public String toString()  {
        StringBuilder sb = new StringBuilder();
        sb.append("class VehiclesResponse {\n");

        sb.append("  response: ").append(response).append("\n");
        sb.append("  count: ").append(count).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
