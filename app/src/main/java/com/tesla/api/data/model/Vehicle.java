package com.tesla.api.data.model;

import java.io.Serializable;
import java.util.*;
import com.google.gson.annotations.SerializedName;

public class Vehicle implements Serializable {
    @SerializedName("color")
    private String color = null;
    @SerializedName("display_name")
    private String displayName = null;
    @SerializedName("vehicle_id")
    private String vehicleId = null;
    @SerializedName("user_id")
    private String userId = null;
    @SerializedName("state")
    private String state = null;
    @SerializedName("tokens")
    private List<String> tokens = null;
    @SerializedName("vin")
    private String vin = null;
    @SerializedName("id")
    private String id = null;
    @SerializedName("option_codes")
    private String optionCodes = null;

    /**
     **/
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    /**
     **/
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     **/
    public String getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     **/
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     **/
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    /**
     **/
    public List<String> getTokens() {
        return tokens;
    }
    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    /**
     **/
    public String getVin() {
        return vin;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     **/
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    /**
     * comma-separated list of options
     **/
    public String getOptionCodes() {
        return optionCodes;
    }
    public void setOptionCodes(String optionCodes) {
        this.optionCodes = optionCodes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return (this.color == null ? vehicle.color == null : this.color.equals(vehicle.color)) &&
                (this.displayName == null ? vehicle.displayName == null : this.displayName.equals(vehicle.displayName)) &&
                (this.vehicleId == null ? vehicle.vehicleId == null : this.vehicleId.equals(vehicle.vehicleId)) &&
                (this.userId == null ? vehicle.userId == null : this.userId.equals(vehicle.userId)) &&
                (this.state == null ? vehicle.state == null : this.state.equals(vehicle.state)) &&
                (this.tokens == null ? vehicle.tokens == null : this.tokens.equals(vehicle.tokens)) &&
                (this.vin == null ? vehicle.vin == null : this.vin.equals(vehicle.vin)) &&
                (this.id == null ? vehicle.id == null : this.id.equals(vehicle.id)) &&
                (this.optionCodes == null ? vehicle.optionCodes == null : this.optionCodes.equals(vehicle.optionCodes));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (this.color == null ? 0: this.color.hashCode());
        result = 31 * result + (this.displayName == null ? 0: this.displayName.hashCode());
        result = 31 * result + (this.vehicleId == null ? 0: this.vehicleId.hashCode());
        result = 31 * result + (this.userId == null ? 0: this.userId.hashCode());
        result = 31 * result + (this.state == null ? 0: this.state.hashCode());
        result = 31 * result + (this.tokens == null ? 0: this.tokens.hashCode());
        result = 31 * result + (this.vin == null ? 0: this.vin.hashCode());
        result = 31 * result + (this.id == null ? 0: this.id.hashCode());
        result = 31 * result + (this.optionCodes == null ? 0: this.optionCodes.hashCode());
        return result;
    }

    @Override
    public String toString()  {
        StringBuilder sb = new StringBuilder();
        sb.append("class Vehicle {\n");

        sb.append("  color: ").append(color).append("\n");
        sb.append("  displayName: ").append(displayName).append("\n");
        sb.append("  vehicleId: ").append(vehicleId).append("\n");
        sb.append("  userId: ").append(userId).append("\n");
        sb.append("  state: ").append(state).append("\n");
        sb.append("  tokens: ").append(tokens).append("\n");
        sb.append("  vin: ").append(vin).append("\n");
        sb.append("  id: ").append(id).append("\n");
        sb.append("  optionCodes: ").append(optionCodes).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
