package com.tesla.api.data.model;

import java.io.Serializable;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

public class VehicleConfig implements Serializable {
    @SerializedName("can_actuate_trunks")
    private Boolean canActuateTrunks = null;

    @SerializedName("can_accept_navigation_requests")
    private Boolean canAcceptNavigationRequests = null;

    @SerializedName("car_special_type")
    private String carSpecialType = null;

    @SerializedName("car_type")
    private String carType = null;

    @SerializedName("charge_port_type")
    private String chargePortType = null;

    @SerializedName("ece_restrictions")
    private Boolean eceRestrictions = null;

    @SerializedName("eu_vehicle")
    private Boolean euVehicle = null;

    @SerializedName("exterior_color")
    private String exteriorColor = null;

    @SerializedName("has_air_suspension")
    private Boolean hasAirSuspension = null;

    @SerializedName("has_ludicrous_mode")
    private Boolean hasLudicrousMode = null;

    @SerializedName("key_version")
    private String keyVersion = null;

    @SerializedName("motorized_charge_port")
    private Boolean motorizedChargePort = null;

    @SerializedName("perf_config")
    private String perfConfig = null;

    @SerializedName("plg")
    private Boolean plg = null;

    @SerializedName("rear_seat_heaters")
    private BigDecimal rearSeatHeaters = null;

    @SerializedName("rear_seat_type")
    private BigDecimal rearSeatType = null;

    @SerializedName("rhd")
    private Boolean rhd = null;

    @SerializedName("roof_color")
    private String roofColor = null;

    @SerializedName("seat_type")
    private BigDecimal seatType = null;

    @SerializedName("spoiler_type")
    private String spoilerType = null;

    @SerializedName("sun_roof_installed")
    private BigDecimal sunRoofInstalled = null;

    @SerializedName("third_row_seats")
    private String thirdRowSeats = null;

    @SerializedName("timestamp")
    private BigDecimal timestamp = null;

    @SerializedName("trim_badging")
    private String trimBadging = null;

    @SerializedName("use_range_badging")
    private Boolean useRangeBadging = null;

    @SerializedName("wheel_type")
    private String wheelType = null;

    public VehicleConfig canActuateTrunks(Boolean canActuateTrunks) {
        this.canActuateTrunks = canActuateTrunks;
        return this;
    }

    /**
     * Get canActuateTrunks
     * @return canActuateTrunks
     **/
    public Boolean isCanActuateTrunks() {
        return canActuateTrunks;
    }

    public void setCanActuateTrunks(Boolean canActuateTrunks) {
        this.canActuateTrunks = canActuateTrunks;
    }

    public VehicleConfig canAcceptNavigationRequests(Boolean canAcceptNavigationRequests) {
        this.canAcceptNavigationRequests = canAcceptNavigationRequests;
        return this;
    }

    /**
     * Get canAcceptNavigationRequests
     * @return canAcceptNavigationRequests
     **/
    public Boolean isCanAcceptNavigationRequests() {
        return canAcceptNavigationRequests;
    }

    public void setCanAcceptNavigationRequests(Boolean canAcceptNavigationRequests) {
        this.canAcceptNavigationRequests = canAcceptNavigationRequests;
    }

    public VehicleConfig carSpecialType(String carSpecialType) {
        this.carSpecialType = carSpecialType;
        return this;
    }

    /**
     * Get carSpecialType
     * @return carSpecialType
     **/
    public String getCarSpecialType() {
        return carSpecialType;
    }

    public void setCarSpecialType(String carSpecialType) {
        this.carSpecialType = carSpecialType;
    }

    public VehicleConfig carType(String carType) {
        this.carType = carType;
        return this;
    }

    /**
     * Get carType
     * @return carType
     **/
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public VehicleConfig chargePortType(String chargePortType) {
        this.chargePortType = chargePortType;
        return this;
    }

    /**
     * Get chargePortType
     * @return chargePortType
     **/
    public String getChargePortType() { return chargePortType; }

    public void setChargePortType(String chargePortType) {
        this.chargePortType = chargePortType;
    }

    public VehicleConfig eceRestrictions(Boolean eceRestrictions) {
        this.eceRestrictions = eceRestrictions;
        return this;
    }

    /**
     * Get eceRestrictions
     * @return eceRestrictions
     **/
    public Boolean hasEceRestrictions() {
        return eceRestrictions;
    }

    public void setEceRestrictions(Boolean eceRestrictions) {
        this.eceRestrictions = eceRestrictions;
    }

    public VehicleConfig euVehicle(Boolean euVehicle) {
        this.euVehicle = euVehicle;
        return this;
    }

    /**
     * Get euVehicle
     * @return euVehicle
     **/
    public Boolean isEuVehicle() {
        return euVehicle;
    }

    public void setEuVehicle(Boolean euVehicle) {
        this.euVehicle = euVehicle;
    }


    public VehicleConfig hasAirSuspension(Boolean hasAirSuspension) {
        this.hasAirSuspension = hasAirSuspension;
        return this;
    }

    /**
     * Get hasAirSuspension
     * @return hasAirSuspension
     **/
    public Boolean isHasAirSuspension() {
        return hasAirSuspension;
    }

    public void setHasAirSuspension(Boolean hasAirSuspension) { this.hasAirSuspension = hasAirSuspension; }


    public VehicleConfig exteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
        return this;
    }

    /**
     * Get exteriorColor
     * @return exteriorColor
     **/
    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public VehicleConfig hasLudicrousMode(Boolean hasLudicrousMode) {
        this.hasLudicrousMode = hasLudicrousMode;
        return this;
    }

    /**
     * Get hasLudicrousMode
     * @return hasLudicrousMode
     **/
    public Boolean isHasLudicrousMode() {
        return hasLudicrousMode;
    }

    public void setHasLudicrousMode(Boolean hasLudicrousMode) {
        this.hasLudicrousMode = hasLudicrousMode;
    }




    public VehicleConfig keyVersion(String keyVersion) {
        this.keyVersion = keyVersion;
        return this;
    }

    /**
     * Get keyVersion
     * @return keyVersion
     **/
    public String getKeyVersion() {
        return keyVersion;
    }

    public void setKeyVersion(String keyVersion) {
        this.keyVersion = keyVersion;
    }




    public VehicleConfig motorizedChargePort(Boolean motorizedChargePort) {
        this.motorizedChargePort = motorizedChargePort;
        return this;
    }

    /**
     * Get motorizedChargePort
     * @return motorizedChargePort
     **/
    public Boolean isMotorizedChargePort() {
        return motorizedChargePort;
    }

    public void setMotorizedChargePort(Boolean motorizedChargePort) {
        this.motorizedChargePort = motorizedChargePort;
    }

    public VehicleConfig perfConfig(String perfConfig) {
        this.perfConfig = perfConfig;
        return this;
    }

    /**
     * Get perfConfig
     * @return perfConfig
     **/
    public String getPerfConfig() {
        return perfConfig;
    }

    public void setPerfConfig(String perfConfig) {
        this.perfConfig = perfConfig;
    }

    public VehicleConfig plg(Boolean plg) {
        this.plg = plg;
        return this;
    }

    /**
     * Get plg
     * @return plg
     **/
    public Boolean isPlg() {
        return plg;
    }

    public void setPlg(Boolean plg) {
        this.plg = plg;
    }

    public VehicleConfig rearSeatHeaters(BigDecimal rearSeatHeaters) {
        this.rearSeatHeaters = rearSeatHeaters;
        return this;
    }

    /**
     * Get rearSeatHeaters
     * @return rearSeatHeaters
     **/
    public BigDecimal getRearSeatHeaters() {
        return rearSeatHeaters;
    }

    public void setRearSeatHeaters(BigDecimal rearSeatHeaters) {
        this.rearSeatHeaters = rearSeatHeaters;
    }

    public VehicleConfig rearSeatType(BigDecimal rearSeatType) {
        this.rearSeatType = rearSeatType;
        return this;
    }

    /**
     * Get rearSeatType
     * @return rearSeatType
     **/
    public BigDecimal getRearSeatType() {
        return rearSeatType;
    }

    public void setRearSeatType(BigDecimal rearSeatType) {
        this.rearSeatType = rearSeatType;
    }

    public VehicleConfig rhd(Boolean rhd) {
        this.rhd = rhd;
        return this;
    }

    /**
     * Get rhd
     * @return rhd
     **/
    public Boolean isRhd() {
        return rhd;
    }

    public void setRhd(Boolean rhd) {
        this.rhd = rhd;
    }

    public VehicleConfig roofColor(String roofColor) {
        this.roofColor = roofColor;
        return this;
    }

    /**
     * Get roofColor
     * @return roofColor
     **/
    public String getRoofColor() {
        return roofColor;
    }

    public void setRoofColor(String roofColor) {
        this.roofColor = roofColor;
    }

    public VehicleConfig seatType(BigDecimal seatType) {
        this.seatType = seatType;
        return this;
    }

    /**
     * Get seatType
     * @return seatType
     **/
    public BigDecimal getSeatType() {
        return seatType;
    }

    public void setSeatType(BigDecimal seatType) {
        this.seatType = seatType;
    }

    public VehicleConfig spoilerType(String spoilerType) {
        this.spoilerType = spoilerType;
        return this;
    }

    /**
     * Get spoilerType
     * @return spoilerType
     **/
    public String getSpoilerType() {
        return spoilerType;
    }

    public void setSpoilerType(String spoilerType) {
        this.spoilerType = spoilerType;
    }

    public VehicleConfig sunRoofInstalled(BigDecimal sunRoofInstalled) {
        this.sunRoofInstalled = sunRoofInstalled;
        return this;
    }

    /**
     * Get sunRoofInstalled
     * @return sunRoofInstalled
     **/
    public BigDecimal getSunRoofInstalled() {
        return sunRoofInstalled;
    }

    public void setSunRoofInstalled(BigDecimal sunRoofInstalled) {
        this.sunRoofInstalled = sunRoofInstalled;
    }

    public VehicleConfig thirdRowSeats(String thirdRowSeats) {
        this.thirdRowSeats = thirdRowSeats;
        return this;
    }

    /**
     * Get thirdRowSeats
     * @return thirdRowSeats
     **/
    public String getThirdRowSeats() {
        return thirdRowSeats;
    }

    public void setThirdRowSeats(String thirdRowSeats) {
        this.thirdRowSeats = thirdRowSeats;
    }

    public VehicleConfig timestamp(BigDecimal timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get timestamp
     * @return timestamp
     **/
    public BigDecimal getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public VehicleConfig trimBadging(String trimBadging) {
        this.trimBadging = trimBadging;
        return this;
    }

    /**
     * Get trimBadging
     * @return trimBadging
     **/
    public String getTrimBadging() {
        return trimBadging;
    }

    public void setTrimBadging(String trimBadging) {
        this.trimBadging = trimBadging;
    }


    public VehicleConfig useRangeBadging(Boolean useRangeBadging) {
        this.useRangeBadging = useRangeBadging;
        return this;
    }

    /**
     * Get useRangeBadging
     * @return useRangeBadging
     **/
    public Boolean isUseRangeBadging() {
        return useRangeBadging;
    }

    public void setUseRangeBadging(Boolean useRangeBadging) { this.useRangeBadging = useRangeBadging; }


    public VehicleConfig wheelType(String wheelType) {
        this.wheelType = wheelType;
        return this;
    }

    /**
     * Get wheelType
     * @return wheelType
     **/
    public String getWheelType() {
        return wheelType;
    }

    public void setWheelType(String wheelType) {
        this.wheelType = wheelType;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VehicleConfig vehicleConfig = (VehicleConfig) o;
        return Objects.equals(this.canActuateTrunks, vehicleConfig.canActuateTrunks) &&
                Objects.equals(this.canAcceptNavigationRequests, vehicleConfig.canAcceptNavigationRequests) &&
                Objects.equals(this.carSpecialType, vehicleConfig.carSpecialType) &&
                Objects.equals(this.carType, vehicleConfig.carType) &&
                Objects.equals(this.chargePortType, vehicleConfig.chargePortType) &&
                Objects.equals(this.euVehicle, vehicleConfig.euVehicle) &&
                Objects.equals(this.exteriorColor, vehicleConfig.exteriorColor) &&
                Objects.equals(this.hasAirSuspension, vehicleConfig.hasAirSuspension) &&
                Objects.equals(this.hasLudicrousMode, vehicleConfig.hasLudicrousMode) &&
                Objects.equals(this.keyVersion, vehicleConfig.keyVersion) &&
                Objects.equals(this.motorizedChargePort, vehicleConfig.motorizedChargePort) &&
                Objects.equals(this.perfConfig, vehicleConfig.perfConfig) &&
                Objects.equals(this.plg, vehicleConfig.plg) &&
                Objects.equals(this.rearSeatHeaters, vehicleConfig.rearSeatHeaters) &&
                Objects.equals(this.rearSeatType, vehicleConfig.rearSeatType) &&
                Objects.equals(this.rhd, vehicleConfig.rhd) &&
                Objects.equals(this.roofColor, vehicleConfig.roofColor) &&
                Objects.equals(this.seatType, vehicleConfig.seatType) &&
                Objects.equals(this.spoilerType, vehicleConfig.spoilerType) &&
                Objects.equals(this.sunRoofInstalled, vehicleConfig.sunRoofInstalled) &&
                Objects.equals(this.thirdRowSeats, vehicleConfig.thirdRowSeats) &&
                Objects.equals(this.timestamp, vehicleConfig.timestamp) &&
                Objects.equals(this.trimBadging, vehicleConfig.trimBadging) &&
                Objects.equals(this.useRangeBadging, vehicleConfig.useRangeBadging) &&
                Objects.equals(this.wheelType, vehicleConfig.wheelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(canActuateTrunks, canAcceptNavigationRequests, carSpecialType, carType, chargePortType, euVehicle, exteriorColor, hasLudicrousMode, motorizedChargePort, perfConfig, plg, rearSeatHeaters, rearSeatType, rhd, roofColor, seatType, spoilerType, sunRoofInstalled, thirdRowSeats, timestamp, trimBadging, wheelType);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VehicleConfig {\n");

        sb.append("    canActuateTrunks: ").append(toIndentedString(canActuateTrunks)).append("\n");
        sb.append("    canAcceptNavigationRequests: ").append(toIndentedString(canAcceptNavigationRequests)).append("\n");
        sb.append("    carSpecialType: ").append(toIndentedString(carSpecialType)).append("\n");
        sb.append("    carType: ").append(toIndentedString(carType)).append("\n");
        sb.append("    chargePortType: ").append(toIndentedString(chargePortType)).append("\n");
        sb.append("    eceRestrictions: ").append(toIndentedString(eceRestrictions)).append("\n");
        sb.append("    euVehicle: ").append(toIndentedString(euVehicle)).append("\n");
        sb.append("    exteriorColor: ").append(toIndentedString(exteriorColor)).append("\n");
        sb.append("    hasAirSuspension: ").append(toIndentedString(hasAirSuspension)).append("\n");
        sb.append("    hasLudicrousMode: ").append(toIndentedString(hasLudicrousMode)).append("\n");
        sb.append("    motorizedChargePort: ").append(toIndentedString(motorizedChargePort)).append("\n");
        sb.append("    perfConfig: ").append(toIndentedString(perfConfig)).append("\n");
        sb.append("    plg: ").append(toIndentedString(plg)).append("\n");
        sb.append("    rearSeatHeaters: ").append(toIndentedString(rearSeatHeaters)).append("\n");
        sb.append("    rearSeatType: ").append(toIndentedString(rearSeatType)).append("\n");
        sb.append("    rhd: ").append(toIndentedString(rhd)).append("\n");
        sb.append("    roofColor: ").append(toIndentedString(roofColor)).append("\n");
        sb.append("    seatType: ").append(toIndentedString(seatType)).append("\n");
        sb.append("    spoilerType: ").append(toIndentedString(spoilerType)).append("\n");
        sb.append("    sunRoofInstalled: ").append(toIndentedString(sunRoofInstalled)).append("\n");
        sb.append("    thirdRowSeats: ").append(toIndentedString(thirdRowSeats)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    trimBadging: ").append(toIndentedString(trimBadging)).append("\n");
        sb.append("    useRangeBadging: ").append(toIndentedString(useRangeBadging)).append("\n");
        sb.append("    wheelType: ").append(toIndentedString(wheelType)).append("\n");
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
