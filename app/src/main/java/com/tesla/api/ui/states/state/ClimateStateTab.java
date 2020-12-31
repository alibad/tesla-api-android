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
import com.tesla.api.data.model.ClimateState;

import java.io.Serializable;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClimateStateTab.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ClimateStateTab extends Fragment {
    private OnFragmentInteractionListener mListener;

    private ClimateState state;

    TableLayout climateStateTable;

    TextView batteryHeaterTextView;
    TextView batteryHeaterNoPowerTextView;
    TextView climateKeeperModeTextView;
    TextView defrostModeTextView;
    TextView driverTempSettingTextView;
    TextView fanStatusTextView;
    TextView insideTempTextView;
    TextView isAutoConditioningOnTextView;
    TextView isClimateOnTextView;
    TextView isFrontDefrosterOnTextView;
    TextView isPreconditioningTextView;
    TextView isRearDefrosterOnTextView;
    TextView leftTempDirectionTextView;
    TextView maxAvailTempTextView;
    TextView minAvailTempTextView;
    TextView outsideTempTextView;
    TextView passengerTempSettingTextView;
    TextView remoteHeaterControlEnabledTextView;
    TextView rightTempDirectionTextView;
    TextView seatHeaterLeftTextView;
    TextView seatHeaterRightTextView;
    TextView sideMirrorHeatersTextView;
    TextView timestampTextView;
    TextView wiperBladeHeaterTextView;

    public ClimateStateTab() {
        // Required empty public constructor
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
            state = (ClimateState) savedInstanceState.getSerializable("state");
            loadStateInTable(state);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_climate_state_tab, container, false);

        climateStateTable = (TableLayout) root.findViewById(R.id.climate_state_table);

        batteryHeaterTextView = (TextView) root.findViewById(R.id.battery_heater_text_view);
        batteryHeaterNoPowerTextView = (TextView) root.findViewById(R.id.battery_heater_no_power_text_view);
        climateKeeperModeTextView = (TextView) root.findViewById(R.id.climate_keeper_mode_text_view);
        defrostModeTextView = (TextView) root.findViewById(R.id.defrost_mode_text_view);
        driverTempSettingTextView = (TextView) root.findViewById(R.id.driver_temp_setting_text_view);
        fanStatusTextView = (TextView) root.findViewById(R.id.fan_status_text_view);
        insideTempTextView = (TextView) root.findViewById(R.id.inside_temp_text_view);
        isAutoConditioningOnTextView = (TextView) root.findViewById(R.id.is_auto_conditioning_on_text_view);
        isClimateOnTextView = (TextView) root.findViewById(R.id.is_climate_on_text_view);
        isFrontDefrosterOnTextView = (TextView) root.findViewById(R.id.is_front_defroster_on_text_view);
        isPreconditioningTextView = (TextView) root.findViewById(R.id.is_preconditioning_text_view);
        isRearDefrosterOnTextView = (TextView) root.findViewById(R.id.is_rear_defroster_on_text_view);
        leftTempDirectionTextView = (TextView) root.findViewById(R.id.left_temp_direction_text_view);
        maxAvailTempTextView = (TextView) root.findViewById(R.id.max_avail_temp_text_view);
        minAvailTempTextView = (TextView) root.findViewById(R.id.min_avail_temp_text_view);
        outsideTempTextView = (TextView) root.findViewById(R.id.outside_temp_text_view);
        passengerTempSettingTextView = (TextView) root.findViewById(R.id.passenger_temp_setting_text_view);
        remoteHeaterControlEnabledTextView = (TextView) root.findViewById(R.id.remote_heater_control_enabled_text_view);
        rightTempDirectionTextView = (TextView) root.findViewById(R.id.right_temp_direction_text_view);
        seatHeaterLeftTextView = (TextView) root.findViewById(R.id.seat_heater_left_text_view);
        seatHeaterRightTextView = (TextView) root.findViewById(R.id.seat_heater_right_text_view);
        sideMirrorHeatersTextView = (TextView) root.findViewById(R.id.side_mirror_heaters_text_view);
        wiperBladeHeaterTextView = (TextView) root.findViewById(R.id.wiper_blade_heater_text_view);
        timestampTextView = (TextView) root.findViewById(R.id.timestamp_text_view);
        return root;
    }

    public void loadStateInTable(final ClimateState climateState) {
        state = climateState;

        if (state == null || climateStateTable == null) {
            return;
        }

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
            batteryHeaterTextView.setText(Objects.toString(state.isBatteryHeater(), ""));
            batteryHeaterNoPowerTextView.setText(Objects.toString(state.isBatteryHeaterNoPower(), ""));
            climateKeeperModeTextView.setText(Objects.toString("", "")); // TODO: update this
            defrostModeTextView.setText(Objects.toString(state.getDefrostMode(), ""));
            driverTempSettingTextView.setText(Objects.toString(state.getDriverTempSetting(), ""));
            fanStatusTextView.setText(Objects.toString(state.getFanStatus(), ""));
            insideTempTextView.setText(Objects.toString(state.getInsideTemp(), ""));
            isAutoConditioningOnTextView.setText(Objects.toString(state.isIsAutoConditioningOn(), ""));
            isClimateOnTextView.setText(Objects.toString(state.isIsClimateOn(), ""));
            isFrontDefrosterOnTextView.setText(Objects.toString(state.isIsFrontDefrosterOn(), ""));
            isPreconditioningTextView.setText(Objects.toString(state.isIsPreconditioning(), ""));
            isRearDefrosterOnTextView.setText(Objects.toString(state.isIsRearDefrosterOn(), ""));
            leftTempDirectionTextView.setText(Objects.toString(state.getLeftTempDirection(), ""));
            maxAvailTempTextView.setText(Objects.toString(state.getMaxAvailTemp(), ""));
            minAvailTempTextView.setText(Objects.toString(state.getMinAvailTemp(), ""));
            outsideTempTextView.setText(Objects.toString(state.getOutsideTemp(), ""));
            passengerTempSettingTextView.setText(Objects.toString(state.getPassengerTempSetting(), ""));
            remoteHeaterControlEnabledTextView.setText(Objects.toString("", "")); // TODO: update this
            rightTempDirectionTextView.setText(Objects.toString(state.getRightTempDirection(), ""));
            seatHeaterLeftTextView.setText(Objects.toString(state.getSeatHeaterLeft(), ""));
            seatHeaterRightTextView.setText(Objects.toString(state.getSeatHeaterRearRight(), ""));
            sideMirrorHeatersTextView.setText(Objects.toString(state.isSideMirrorHeaters(), ""));
            timestampTextView.setText(Objects.toString(state.getTimestamp(), ""));
            wiperBladeHeaterTextView.setText(Objects.toString(state.isWiperBladeHeater(), ""));
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
