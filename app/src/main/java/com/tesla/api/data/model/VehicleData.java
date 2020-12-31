package com.tesla.api.data.model;

import java.io.Serializable;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VehicleData implements Serializable {
    @SerializedName("color")
    private String color = null;

    @SerializedName("display_name")
    private String displayName = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("option_codes")
    private String optionCodes = null;

    @SerializedName("vehicle_id")
    private String vehicleId = null;

    @SerializedName("vin")
    private String vin = null;

    @SerializedName("user_id")
    private BigDecimal userId = null;

    @SerializedName("tokens")
    private List<String> tokens = null;

    @SerializedName("state")
    private String state = null;

    @SerializedName("in_service")
    private Boolean inService = null;

    @SerializedName("id_s")
    private String idS = null;

    @SerializedName("calendar_enabled")
    private Boolean calendarEnabled = null;

    @SerializedName("backseat_token")
    private String backseatToken = null;

    @SerializedName("backseat_token_updated_at")
    private BigDecimal backseatTokenUpdatedAt = null;

    @SerializedName("gui_settings")
    private GuiState guiSettings = null;

    @SerializedName("climate_state")
    private ClimateState climateState = null;

    @SerializedName("drive_state")
    private DriveState driveState = null;

    @SerializedName("vehicle_state")
    private VehicleState vehicleState = null;

    @SerializedName("charge_state")
    private ChargeState chargeState = null;

    @SerializedName("vehicle_config")
    private VehicleConfig vehicleConfig = null;

    public VehicleData color(String color) {
        this.color = color;
        return this;
    }

    /**
     * Get color
     * @return color
     **/
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleData displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get displayName
     * @return displayName
     **/
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public VehicleData id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleData optionCodes(String optionCodes) {
        this.optionCodes = optionCodes;
        return this;
    }

    /**
     * Get optionCodes
     * @return optionCodes
     **/
    public String getOptionCodes() {
        return optionCodes;
    }

    public void setOptionCodes(String optionCodes) {
        this.optionCodes = optionCodes;
    }

    public VehicleData vehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    /**
     * Get vehicleId
     * @return vehicleId
     **/
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleData vin(String vin) {
        this.vin = vin;
        return this;
    }

    /**
     * Get vin
     * @return vin
     **/
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public VehicleData userId(BigDecimal userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get userId
     * @return userId
     **/
    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public VehicleData tokens(List<String> tokens) {
        this.tokens = tokens;
        return this;
    }

    public VehicleData addTokensItem(String tokensItem) {
        if (this.tokens == null) {
            this.tokens = new ArrayList<String>();
        }
        this.tokens.add(tokensItem);
        return this;
    }

    /**
     * Get tokens
     * @return tokens
     **/
    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    public VehicleData state(String state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     * @return state
     **/
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public VehicleData inService(Boolean inService) {
        this.inService = inService;
        return this;
    }

    /**
     * Get inService
     * @return inService
     **/
    public Boolean isInService() {
        return inService;
    }

    public void setInService(Boolean inService) {
        this.inService = inService;
    }

    public VehicleData idS(String idS) {
        this.idS = idS;
        return this;
    }

    /**
     * Get idS
     * @return idS
     **/
    public String getIdS() {
        return idS;
    }

    public void setIdS(String idS) {
        this.idS = idS;
    }

    public VehicleData calendarEnabled(Boolean calendarEnabled) {
        this.calendarEnabled = calendarEnabled;
        return this;
    }

    /**
     * Get calendarEnabled
     * @return calendarEnabled
     **/
    public Boolean isCalendarEnabled() {
        return calendarEnabled;
    }

    public void setCalendarEnabled(Boolean calendarEnabled) {
        this.calendarEnabled = calendarEnabled;
    }

    public VehicleData backseatToken(String backseatToken) {
        this.backseatToken = backseatToken;
        return this;
    }

    /**
     * Get backseatToken
     * @return backseatToken
     **/
    public String getBackseatToken() {
        return backseatToken;
    }

    public void setBackseatToken(String backseatToken) {
        this.backseatToken = backseatToken;
    }

    public VehicleData backseatTokenUpdatedAt(BigDecimal backseatTokenUpdatedAt) {
        this.backseatTokenUpdatedAt = backseatTokenUpdatedAt;
        return this;
    }

    /**
     * Get backseatTokenUpdatedAt
     * @return backseatTokenUpdatedAt
     **/
    public BigDecimal getBackseatTokenUpdatedAt() {
        return backseatTokenUpdatedAt;
    }

    public void setBackseatTokenUpdatedAt(BigDecimal backseatTokenUpdatedAt) {
        this.backseatTokenUpdatedAt = backseatTokenUpdatedAt;
    }

    public VehicleData guiSettings(GuiState guiSettings) {
        this.guiSettings = guiSettings;
        return this;
    }

    /**
     * Get guiSettings
     * @return guiSettings
     **/
    public GuiState getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiState guiSettings) {
        this.guiSettings = guiSettings;
    }

    public VehicleData climateState(ClimateState climateState) {
        this.climateState = climateState;
        return this;
    }

    /**
     * Get climateState
     * @return climateState
     **/
    public ClimateState getClimateState() {
        return climateState;
    }

    public void setClimateState(ClimateState climateState) {
        this.climateState = climateState;
    }

    public VehicleData driveState(DriveState driveState) {
        this.driveState = driveState;
        return this;
    }

    /**
     * Get driveState
     * @return driveState
     **/
    public DriveState getDriveState() {
        return driveState;
    }

    public void setDriveState(DriveState driveState) {
        this.driveState = driveState;
    }

    public VehicleData vehicleState(VehicleState vehicleState) {
        this.vehicleState = vehicleState;
        return this;
    }

    /**
     * Get vehicleState
     * @return vehicleState
     **/
    public VehicleState getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(VehicleState vehicleState) {
        this.vehicleState = vehicleState;
    }

    public VehicleData chargeState(ChargeState chargeState) {
        this.chargeState = chargeState;
        return this;
    }

    /**
     * Get chargeState
     * @return chargeState
     **/
    public ChargeState getChargeState() {
        return chargeState;
    }

    public void setChargeState(ChargeState chargeState) {
        this.chargeState = chargeState;
    }

    public VehicleData vehicleConfig(VehicleConfig vehicleConfig) {
        this.vehicleConfig = vehicleConfig;
        return this;
    }

    /**
     * Get vehicleConfig
     * @return vehicleConfig
     **/
    public VehicleConfig getVehicleConfig() {
        return vehicleConfig;
    }

    public void setVehicleConfig(VehicleConfig vehicleConfig) {
        this.vehicleConfig = vehicleConfig;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VehicleData VehicleData = (VehicleData) o;
        return Objects.equals(this.color, VehicleData.color) &&
                Objects.equals(this.displayName, VehicleData.displayName) &&
                Objects.equals(this.id, VehicleData.id) &&
                Objects.equals(this.optionCodes, VehicleData.optionCodes) &&
                Objects.equals(this.vehicleId, VehicleData.vehicleId) &&
                Objects.equals(this.vin, VehicleData.vin) &&
                Objects.equals(this.userId, VehicleData.userId) &&
                Objects.equals(this.tokens, VehicleData.tokens) &&
                Objects.equals(this.state, VehicleData.state) &&
                Objects.equals(this.inService, VehicleData.inService) &&
                Objects.equals(this.idS, VehicleData.idS) &&
                Objects.equals(this.calendarEnabled, VehicleData.calendarEnabled) &&
                Objects.equals(this.backseatToken, VehicleData.backseatToken) &&
                Objects.equals(this.backseatTokenUpdatedAt, VehicleData.backseatTokenUpdatedAt) &&
                Objects.equals(this.guiSettings, VehicleData.guiSettings) &&
                Objects.equals(this.climateState, VehicleData.climateState) &&
                Objects.equals(this.driveState, VehicleData.driveState) &&
                Objects.equals(this.vehicleState, VehicleData.vehicleState) &&
                Objects.equals(this.chargeState, VehicleData.chargeState) &&
                Objects.equals(this.vehicleConfig, VehicleData.vehicleConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, displayName, id, optionCodes, vehicleId, vin, userId, tokens, state, inService, idS, calendarEnabled, backseatToken, backseatTokenUpdatedAt, guiSettings, climateState, driveState, vehicleState, chargeState, vehicleConfig);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VehicleData {\n");

        sb.append("    color: ").append(toIndentedString(color)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    optionCodes: ").append(toIndentedString(optionCodes)).append("\n");
        sb.append("    vehicleId: ").append(toIndentedString(vehicleId)).append("\n");
        sb.append("    vin: ").append(toIndentedString(vin)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    tokens: ").append(toIndentedString(tokens)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    inService: ").append(toIndentedString(inService)).append("\n");
        sb.append("    idS: ").append(toIndentedString(idS)).append("\n");
        sb.append("    calendarEnabled: ").append(toIndentedString(calendarEnabled)).append("\n");
        sb.append("    backseatToken: ").append(toIndentedString(backseatToken)).append("\n");
        sb.append("    backseatTokenUpdatedAt: ").append(toIndentedString(backseatTokenUpdatedAt)).append("\n");
        sb.append("    guiSettings: ").append(toIndentedString(guiSettings)).append("\n");
        sb.append("    climateState: ").append(toIndentedString(climateState)).append("\n");
        sb.append("    driveState: ").append(toIndentedString(driveState)).append("\n");
        sb.append("    vehicleState: ").append(toIndentedString(vehicleState)).append("\n");
        sb.append("    chargeState: ").append(toIndentedString(chargeState)).append("\n");
        sb.append("    vehicleConfig: ").append(toIndentedString(vehicleConfig)).append("\n");
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

