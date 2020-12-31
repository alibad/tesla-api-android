package com.tesla.api.ui.states;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.tesla.api.AppSettings;
import com.tesla.api.CtrlApp;
import com.tesla.api.R;
import com.tesla.api.SmartFragmentStatePagerAdapter;
import com.tesla.api.data.model.VehicleData;
import com.tesla.api.ui.states.state.ChargeStateTab;
import com.tesla.api.ui.states.state.ClimateStateTab;
import com.tesla.api.ui.states.state.ConfigStateTab;
import com.tesla.api.ui.states.state.DriveStateTab;
import com.tesla.api.ui.states.state.GuiStateTab;
import com.tesla.api.ui.states.state.VehicleStateTab;

public class CtrlPageAdapter extends SmartFragmentStatePagerAdapter {
    public CtrlPageAdapter(FragmentManager fm) {
        super(fm);
    }

    private Fragment driveStateTab;
    private Fragment climateStateTab;
    private Fragment chargeStateTab;
    private Fragment guiStateTab;
    private Fragment vehicleStateTab;
    private Fragment configStateTab;

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return getDriveStateTab();
            case 1:
                return getClimateStateTab();
            case 2:
                return getChargeStateTab();
            case 3:
                return getGuiStateTab();
            case 4:
                return getVehicleStateTab();
            case 5:
                return getConfigStateTab();
        }

        return null;
    }

    public void loadState(int position) {
        VehicleData state = AppSettings.getVehicleState();

        if (state != null) {
            switch(position) {
                case 0:
                    getDriveStateTab().loadStateInTable(state.getDriveState());
                    break;
                case 1:
                    getClimateStateTab().loadStateInTable(state.getClimateState());
                    break;
                case 2:
                    getChargeStateTab().loadStateInTable(state.getChargeState());
                    break;
                case 3:
                    getGuiStateTab().loadStateInTable(state.getGuiSettings());
                    break;
                case 4:
                    getVehicleStateTab().loadStateInTable(state.getVehicleState());
                    break;
                case 5:
                    getConfigStateTab().loadStateInTable(state.getVehicleConfig());
                    break;
            }
        }
    }

    public DriveStateTab getDriveStateTab() {
        if(driveStateTab == null) {
            driveStateTab = new DriveStateTab();
        }

        return (DriveStateTab) driveStateTab;
    }

    public ClimateStateTab getClimateStateTab() {
        if(climateStateTab == null) {
            climateStateTab = new ClimateStateTab();
        }

        return (ClimateStateTab) climateStateTab;
    }

    public ChargeStateTab getChargeStateTab() {
        if(chargeStateTab == null) {
            chargeStateTab = new ChargeStateTab();
        }

        return (ChargeStateTab) chargeStateTab;
    }

    public GuiStateTab getGuiStateTab() {
        if(guiStateTab == null) {
            guiStateTab = new GuiStateTab();
        }

        return (GuiStateTab) guiStateTab;
    }

    public VehicleStateTab getVehicleStateTab() {
        if(vehicleStateTab == null) {
            vehicleStateTab = new VehicleStateTab();
        }

        return (VehicleStateTab) vehicleStateTab;
    }

    public ConfigStateTab getConfigStateTab() {
        if(configStateTab == null) {
            configStateTab = new ConfigStateTab();
        }

        return (ConfigStateTab) configStateTab;
    }


    @Override
    public int getCount() {
        return 6;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return  CtrlApp.getAppContext().getString(R.string.state_tab_drive_text);

            case 1:
                return CtrlApp.getAppContext().getString(R.string.state_tab_climate_text);

            case 2:
                return CtrlApp.getAppContext().getString(R.string.state_tab_charge_text);

            case 3:
                return CtrlApp.getAppContext().getString(R.string.state_tab_gui_text);

            case 4:
                return CtrlApp.getAppContext().getString(R.string.state_tab_vehicle_text);

            case 5:
                return CtrlApp.getAppContext().getString(R.string.state_tab_config_text);

            default:
                return "WTF";
        }
    }
}
