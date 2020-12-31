package com.tesla.api.data.model;

import java.io.Serializable;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

public class GuiState implements Serializable {
    @SerializedName("gui_distance_units")
    private String guiDistanceUnits = null;

    @SerializedName("gui_temperature_units")
    private String guiTemperatureUnits = null;

    @SerializedName("gui_charge_rate_units")
    private String guiChargeRateUnits = null;

    @SerializedName("gui_24_hour_time")
    private Boolean gui24HourTime = null;

    @SerializedName("gui_range_display")
    private String guiRangeDisplay = null;

    @SerializedName("show_range_units")
    private Boolean showRangeUnits = null;

    @SerializedName("timestamp")
    private BigDecimal timestamp = null;

    public GuiState guiDistanceUnits(String guiDistanceUnits) {
        this.guiDistanceUnits = guiDistanceUnits;
        return this;
    }

    /**
     * Get guiDistanceUnits
     * @return guiDistanceUnits
     **/
    public String getGuiDistanceUnits() {
        return guiDistanceUnits;
    }

    public void setGuiDistanceUnits(String guiDistanceUnits) {
        this.guiDistanceUnits = guiDistanceUnits;
    }

    public GuiState guiTemperatureUnits(String guiTemperatureUnits) {
        this.guiTemperatureUnits = guiTemperatureUnits;
        return this;
    }

    /**
     * Get guiTemperatureUnits
     * @return guiTemperatureUnits
     **/
    public String getGuiTemperatureUnits() {
        return guiTemperatureUnits;
    }

    public void setGuiTemperatureUnits(String guiTemperatureUnits) {
        this.guiTemperatureUnits = guiTemperatureUnits;
    }

    public GuiState guiChargeRateUnits(String guiChargeRateUnits) {
        this.guiChargeRateUnits = guiChargeRateUnits;
        return this;
    }

    /**
     * Get guiChargeRateUnits
     * @return guiChargeRateUnits
     **/
    public String getGuiChargeRateUnits() {
        return guiChargeRateUnits;
    }

    public void setGuiChargeRateUnits(String guiChargeRateUnits) {
        this.guiChargeRateUnits = guiChargeRateUnits;
    }

    public GuiState gui24HourTime(Boolean gui24HourTime) {
        this.gui24HourTime = gui24HourTime;
        return this;
    }

    /**
     * Get gui24HourTime
     * @return gui24HourTime
     **/
    public Boolean isGui24HourTime() {
        return gui24HourTime;
    }

    public void setGui24HourTime(Boolean gui24HourTime) {
        this.gui24HourTime = gui24HourTime;
    }

    public GuiState guiRangeDisplay(String guiRangeDisplay) {
        this.guiRangeDisplay = guiRangeDisplay;
        return this;
    }

    /**
     * Get guiRangeDisplay
     * @return guiRangeDisplay
     **/
    public String getGuiRangeDisplay() {
        return guiRangeDisplay;
    }

    public void setGuiRangeDisplay(String guiRangeDisplay) {
        this.guiRangeDisplay = guiRangeDisplay;
    }

    public GuiState showRangeUnits(Boolean showRangeUnits) {
        this.showRangeUnits = showRangeUnits;
        return this;
    }

    /**
     * Get showRangeUnits
     * @return showRangeUnits
     **/
    public Boolean doesShowRangeUnits() {
        return showRangeUnits;
    }

    public void setShowRangeUnits(Boolean showRangeUnits) {
        this.showRangeUnits = showRangeUnits;
    }

    public GuiState timestamp(BigDecimal timestamp) {
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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GuiState guiState = (GuiState) o;
        return Objects.equals(this.guiDistanceUnits, guiState.guiDistanceUnits) &&
                Objects.equals(this.guiTemperatureUnits, guiState.guiTemperatureUnits) &&
                Objects.equals(this.guiChargeRateUnits, guiState.guiChargeRateUnits) &&
                Objects.equals(this.gui24HourTime, guiState.gui24HourTime) &&
                Objects.equals(this.guiRangeDisplay, guiState.guiRangeDisplay) &&
                Objects.equals(this.showRangeUnits, guiState.showRangeUnits) &&
                Objects.equals(this.timestamp, guiState.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiDistanceUnits, guiTemperatureUnits, guiChargeRateUnits, gui24HourTime, guiRangeDisplay, showRangeUnits, timestamp);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GuiState {\n");

        sb.append("    guiDistanceUnits: ").append(toIndentedString(guiDistanceUnits)).append("\n");
        sb.append("    guiTemperatureUnits: ").append(toIndentedString(guiTemperatureUnits)).append("\n");
        sb.append("    guiChargeRateUnits: ").append(toIndentedString(guiChargeRateUnits)).append("\n");
        sb.append("    gui24HourTime: ").append(toIndentedString(gui24HourTime)).append("\n");
        sb.append("    guiRangeDisplay: ").append(toIndentedString(guiRangeDisplay)).append("\n");
        sb.append("    guiRangeUnits: ").append(toIndentedString(showRangeUnits)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
