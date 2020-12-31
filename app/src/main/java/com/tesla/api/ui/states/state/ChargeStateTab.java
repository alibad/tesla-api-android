package com.tesla.api.ui.states.state;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.tesla.api.R;
import com.tesla.api.data.model.ChargeState;

import java.io.Serializable;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChargeStateTab.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ChargeStateTab extends Fragment {
    private OnFragmentInteractionListener mListener;

    private ChargeState state;

    TableLayout chargeStateTable;
    TextView batteryHeaterOnTextView;
    TextView batteryLevelTextView;
    TextView batteryRangeTextView;
    TextView chargeCurrentRequestTextView;
    TextView chargeCurrentRequestMaxTextView;
    TextView chargeEnableRequestTextView;
    TextView chargeEnergyAddedTextView;
    TextView chargeLimitSocTextView;
    TextView chargeLimitSocMaxTextView;
    TextView chargeLimitSocMinTextView;
    TextView chargeLimitSocStdTextView;
    TextView chargeMilesAddedIdealTextView;
    TextView chargeMilesAddedRatedTextView;
    TextView chargePortColdWeatherModeTextView;
    TextView chargePortDoorOpenTextView;
    TextView chargePortLatchTextView;
    TextView chargeRateTextView;
    TextView chargeToMaxRangeTextView;
    TextView chargerActualCurrentTextView;
    TextView chargerPhasesTextView;
    TextView chargerPilotCurrentTextView;
    TextView chargerPowerTextView;
    TextView chargerVoltageTextView;
    TextView chargingStateTextView;
    TextView connChargeCableTextView;
    TextView estBatteryRangeTextView;
    TextView fastChargerBrandTextView;
    TextView fastChargerPresentTextView;
    TextView fastChargerTypeTextView;
    TextView idealBatteryRangeTextView;
    TextView managedChargingActiveTextView;
    TextView managedChargingStartTimeTextView;
    TextView managedChargingUserCanceledTextView;
    TextView maxRangeChargeCounterTextView;
    TextView minutesToFullChargeTextView;
    TextView notEnoughPowerToHeatTextView;
    TextView scheduledChargingPendingTextView;
    TextView scheduledChargingStartTimeTextView;
    TextView timeToFullChargeTextView;
    TextView timestampTextView;
    TextView tripChargingTextView;
    TextView usableBatteryLevelTextView;
    TextView userChargeEnableRequestTextView;

    public ChargeStateTab() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("state", (Serializable) state);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            state = (ChargeState) savedInstanceState.getSerializable("state");
            loadStateInTable(state);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_charge_state_tab, container, false);

        chargeStateTable = (TableLayout) root.findViewById(R.id.charge_state_table);

        batteryHeaterOnTextView = (TextView) root.findViewById(R.id.battery_heater_on_text_view);
        batteryLevelTextView = (TextView) root.findViewById(R.id.battery_level_text_view);
        batteryRangeTextView = (TextView) root.findViewById(R.id.battery_range_text_view);
        chargeCurrentRequestTextView = (TextView) root.findViewById(R.id.charge_current_request_text_view);
        chargeCurrentRequestMaxTextView = (TextView) root.findViewById(R.id.charge_current_request_max_text_view);
        chargeEnableRequestTextView = (TextView) root.findViewById(R.id.charge_enable_request_text_view);
        chargeEnergyAddedTextView = (TextView) root.findViewById(R.id.charge_energy_added_text_view);
        chargeLimitSocTextView = (TextView) root.findViewById(R.id.charge_limit_soc_text_view);
        chargeLimitSocMaxTextView = (TextView) root.findViewById(R.id.charge_limit_soc_max_text_view);
        chargeLimitSocMinTextView = (TextView) root.findViewById(R.id.charge_limit_soc_min_text_view);
        chargeLimitSocStdTextView = (TextView) root.findViewById(R.id.charge_limit_soc_std_text_view);
        chargeMilesAddedIdealTextView = (TextView) root.findViewById(R.id.charge_miles_added_ideal_text_view);
        chargeMilesAddedRatedTextView = (TextView) root.findViewById(R.id.charge_miles_added_rated_text_view);
        chargePortColdWeatherModeTextView = (TextView) root.findViewById(R.id.charge_port_cold_weather_mode_text_view);
        chargePortDoorOpenTextView = (TextView) root.findViewById(R.id.charge_port_door_open_text_view);
        chargePortLatchTextView = (TextView) root.findViewById(R.id.charge_port_latch_text_view);
        chargeRateTextView = (TextView) root.findViewById(R.id.charge_rate_text_view);
        chargeToMaxRangeTextView = (TextView) root.findViewById(R.id.charge_to_max_range_text_view);
        chargerActualCurrentTextView = (TextView) root.findViewById(R.id.charger_actual_current_text_view);
        chargerPhasesTextView = (TextView) root.findViewById(R.id.charger_phases_text_views);
        chargerPilotCurrentTextView = (TextView) root.findViewById(R.id.charger_pilot_current_text_view);
        chargerPowerTextView = (TextView) root.findViewById(R.id.charger_power_text_view);
        chargerVoltageTextView = (TextView) root.findViewById(R.id.charger_voltage_text_view);
        chargingStateTextView = (TextView) root.findViewById(R.id.charging_state_text_view);
        connChargeCableTextView = (TextView) root.findViewById(R.id.conn_charge_cable_text_view);
        estBatteryRangeTextView = (TextView) root.findViewById(R.id.est_battery_range_text_view);
        fastChargerBrandTextView = (TextView) root.findViewById(R.id.fast_charger_brand_text_view);
        fastChargerPresentTextView = (TextView) root.findViewById(R.id.fast_charger_present_text_view);
        fastChargerTypeTextView = (TextView) root.findViewById(R.id.fast_charger_type_text_view);
        idealBatteryRangeTextView = (TextView) root.findViewById(R.id.ideal_battery_range_text_view);
        managedChargingActiveTextView = (TextView) root.findViewById(R.id.managed_charging_active_text_view);
        managedChargingStartTimeTextView = (TextView) root.findViewById(R.id.managed_charging_start_time_text_view);
        managedChargingUserCanceledTextView = (TextView) root.findViewById(R.id.managed_charging_user_canceled_text_view);
        maxRangeChargeCounterTextView = (TextView) root.findViewById(R.id.max_range_charge_counter_text_view);
        minutesToFullChargeTextView = (TextView) root.findViewById(R.id.minutes_to_full_charge_text_view);
        notEnoughPowerToHeatTextView = (TextView) root.findViewById(R.id.not_enough_power_to_heat_text_view);
        scheduledChargingPendingTextView = (TextView) root.findViewById(R.id.scheduled_charging_pending_text_view);
        scheduledChargingStartTimeTextView = (TextView) root.findViewById(R.id.scheduled_charging_start_time_text_view);
        timeToFullChargeTextView = (TextView) root.findViewById(R.id.time_to_full_charge_text_view);
        timestampTextView = (TextView) root.findViewById(R.id.timestamp_text_view);
        tripChargingTextView = (TextView) root.findViewById(R.id.trip_charging_text_view);
        usableBatteryLevelTextView = (TextView) root.findViewById(R.id.usable_battery_level_text_view);
        userChargeEnableRequestTextView = (TextView) root.findViewById(R.id.user_charge_enable_request_text_view);

        return root;
    }

    public void loadStateInTable(final ChargeState chargeState) {
        state = chargeState;

        if (state == null || chargeStateTable == null) {
            return;
        }

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
            batteryHeaterOnTextView.setText(Objects.toString(state.isBatteryHeaterOn(), ""));
            batteryLevelTextView.setText(Objects.toString(state.getBatteryLevel(), ""));
            batteryRangeTextView.setText(Objects.toString(state.getBatteryRange(), ""));
            chargeCurrentRequestTextView.setText(Objects.toString(state.getChargeCurrentRequest(), ""));
            chargeCurrentRequestMaxTextView.setText(Objects.toString(state.getChargeCurrentRequestMax(), ""));
            chargeEnableRequestTextView.setText(Objects.toString(state.isChargeEnableRequest(), ""));
            chargeEnergyAddedTextView.setText(Objects.toString(state.getChargeEnergyAdded(), ""));
            chargeLimitSocTextView.setText(Objects.toString(state.getChargeLimitSoc(), ""));
            chargeLimitSocMaxTextView.setText(Objects.toString(state.getChargeLimitSocMax(), ""));
            chargeLimitSocMinTextView.setText(Objects.toString(state.getChargeLimitSocMin(), ""));
            chargeLimitSocStdTextView.setText(Objects.toString(state.getChargeLimitSocStd(), ""));
            chargeMilesAddedIdealTextView.setText(Objects.toString(state.getChargeMilesAddedIdeal(), ""));
            chargeMilesAddedRatedTextView.setText(Objects.toString(state.getChargeMilesAddedRated(), ""));
            chargePortColdWeatherModeTextView.setText(Objects.toString(state.isChargePortColdWeatherMode(), ""));
            chargePortDoorOpenTextView.setText(Objects.toString(state.isChargePortDoorOpen(), ""));
            chargePortLatchTextView.setText(Objects.toString(state.getChargePortLatch(), ""));
            chargeRateTextView.setText(Objects.toString(state.getChargeRate(), ""));
            chargeToMaxRangeTextView.setText(Objects.toString(state.isChargeToMaxRange(), ""));
            chargerActualCurrentTextView.setText(Objects.toString(state.getChargerActualCurrent(), ""));
            chargerPhasesTextView.setText(Objects.toString(state.getChargerPhases(), ""));
            chargerPilotCurrentTextView.setText(Objects.toString(state.getChargerPilotCurrent(), ""));
            chargerPowerTextView.setText(Objects.toString(state.getChargerPower(), ""));
            chargerVoltageTextView.setText(Objects.toString(state.getChargerVoltage(), ""));
            chargingStateTextView.setText(Objects.toString(state.getChargingState(), ""));
            connChargeCableTextView.setText(Objects.toString(state.getConnChargeCable(), ""));
            estBatteryRangeTextView.setText(Objects.toString(state.getEstBatteryRange(), ""));
            fastChargerBrandTextView.setText(Objects.toString(state.getFastChargerBrand(), ""));
            fastChargerPresentTextView.setText(Objects.toString(state.isFastChargerPresent(), ""));
            fastChargerTypeTextView.setText(Objects.toString(state.getFastChargerType(), ""));
            idealBatteryRangeTextView.setText(Objects.toString(state.getIdealBatteryRange(), ""));
            managedChargingActiveTextView.setText(Objects.toString(state.isManagedChargingActive(), ""));
            managedChargingStartTimeTextView.setText(Objects.toString(state.getManagedChargingStartTime(), ""));
            managedChargingUserCanceledTextView.setText(Objects.toString(state.isManagedChargingUserCanceled(), ""));
            maxRangeChargeCounterTextView.setText(Objects.toString(state.getMaxRangeChargeCounter(), ""));
            minutesToFullChargeTextView.setText(Objects.toString(state.getMinutesToFullCharge(), ""));
            notEnoughPowerToHeatTextView.setText(Objects.toString(state.isNotEnoughPowerToHeat(), ""));
            scheduledChargingPendingTextView.setText(Objects.toString(state.isScheduledChargingPending(), ""));
            scheduledChargingStartTimeTextView.setText(Objects.toString(state.getScheduledChargingStartTime(), ""));
            timeToFullChargeTextView.setText(Objects.toString(state.getTimeToFullCharge(), ""));
            timestampTextView.setText(Objects.toString(state.getTimestamp(), ""));
            tripChargingTextView.setText(Objects.toString(state.isTripCharging(), ""));
            usableBatteryLevelTextView.setText(Objects.toString(state.getUsableBatteryLevel(), ""));
            userChargeEnableRequestTextView.setText(Objects.toString(state.isUserChargeEnableRequest(), ""));
            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else if (true) {
            return; // just ignore for now
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
