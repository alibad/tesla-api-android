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
import com.tesla.api.data.model.VehicleConfig;

import java.io.Serializable;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConfigStateTab.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ConfigStateTab extends Fragment {
    private OnFragmentInteractionListener mListener;

    private VehicleConfig state;

    TableLayout configStateTable;

    TextView canAcceptNavigationRequestsTextView;
    TextView canAcuateTrunksTextView;
    TextView carSpecialTypeTextView;
    TextView carTypeTextView;
    TextView chargePortTypeTextView;
    TextView eceRestrictionsTextView;
    TextView euVehicleTextView;
    TextView exteriorColorTextView;
    TextView hasAirSuspensionTextView;
    TextView hasLudicrousModeTextView;
    TextView keyVersionTextView;
    TextView motorizedChargePortTextView;
    TextView plgTextView;
    TextView rearSeatHeatersTextView;
    TextView rearSeatTypeTextView;
    TextView rhdTextView;
    TextView roofColorTextView;
    TextView seatTypeTextView;
    TextView spoilerTypeTextView;
    TextView sunRoofInstalledTextView;
    TextView thirdRowSeatsTextView;
    TextView useRangeBadgingTextView;
    TextView wheelTypeTextView;

    TextView timestampTextView;

    public ConfigStateTab() {
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
            state = (VehicleConfig) savedInstanceState.getSerializable("state");
            loadStateInTable(state);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_config_state_tab, container, false);

        configStateTable = (TableLayout) root.findViewById(R.id.config_state_table);

        canAcceptNavigationRequestsTextView = (TextView) root.findViewById(R.id.can_accept_navigation_requests_text_view);
        canAcuateTrunksTextView = (TextView) root.findViewById(R.id.can_actuate_trunks_text_view);
        carSpecialTypeTextView = (TextView) root.findViewById(R.id.car_special_type_text_view);
        carTypeTextView = (TextView) root.findViewById(R.id.car_type_text_view);
        chargePortTypeTextView = (TextView) root.findViewById(R.id.charge_port_type_text_view);
        eceRestrictionsTextView = (TextView) root.findViewById(R.id.ece_restrictions_text_view);
        euVehicleTextView = (TextView) root.findViewById(R.id.eu_vehicle_text_view);
        exteriorColorTextView = (TextView) root.findViewById(R.id.exterior_color_text_view);
        hasAirSuspensionTextView = (TextView) root.findViewById(R.id.has_air_suspension_text_view);
        hasLudicrousModeTextView = (TextView) root.findViewById(R.id.has_ludicrous_mode_text_view);
        keyVersionTextView = (TextView) root.findViewById(R.id.key_version_text_view);
        motorizedChargePortTextView = (TextView) root.findViewById(R.id.motorized_charge_port_text_view);
        plgTextView = (TextView) root.findViewById(R.id.plg_text_view);
        rearSeatHeatersTextView = (TextView) root.findViewById(R.id.rear_seat_heaters_text_view);
        rearSeatTypeTextView = (TextView) root.findViewById(R.id.rear_seat_type_text_view);
        rhdTextView = (TextView) root.findViewById(R.id.rhd_text_view);
        roofColorTextView = (TextView) root.findViewById(R.id.roof_color_text_view);
        seatTypeTextView = (TextView) root.findViewById(R.id.seat_type_text_view);
        spoilerTypeTextView = (TextView) root.findViewById(R.id.spoiler_type_text_view);
        sunRoofInstalledTextView = (TextView) root.findViewById(R.id.sun_roof_installed_text_view);
        thirdRowSeatsTextView = (TextView) root.findViewById(R.id.third_row_seats_text_view);
        useRangeBadgingTextView = (TextView) root.findViewById(R.id.use_range_badging_text_view);
        wheelTypeTextView = (TextView) root.findViewById(R.id.wheel_type_text_view);
        timestampTextView = (TextView) root.findViewById(R.id.timestamp_text_view);

        return root;
    }

    public void loadStateInTable(final VehicleConfig configState) {

        state = configState;

        if (state == null || configStateTable == null) {
            return;
        }

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                canAcceptNavigationRequestsTextView.setText(Objects.toString(state.isCanAcceptNavigationRequests(), ""));
                canAcuateTrunksTextView.setText(Objects.toString(state.isCanActuateTrunks(), ""));
                carSpecialTypeTextView.setText(Objects.toString(state.getCarSpecialType(), ""));
                carTypeTextView.setText(Objects.toString(state.getCarType(), ""));
                chargePortTypeTextView.setText(Objects.toString(state.getChargePortType(), ""));
                eceRestrictionsTextView.setText(Objects.toString(state.hasEceRestrictions(), ""));
                euVehicleTextView.setText(Objects.toString(state.isEuVehicle(), ""));
                exteriorColorTextView.setText(state.getExteriorColor());
                hasAirSuspensionTextView.setText(Objects.toString(state.isHasAirSuspension(), ""));
                hasLudicrousModeTextView.setText(Objects.toString(state.isHasLudicrousMode(), ""));
                keyVersionTextView.setText(Objects.toString(state.getKeyVersion(), ""));
                motorizedChargePortTextView.setText(Objects.toString(state.isMotorizedChargePort(), ""));
                plgTextView.setText(Objects.toString(state.isPlg(), ""));
                rearSeatHeatersTextView.setText(Objects.toString(state.getRearSeatHeaters(), ""));
                rearSeatTypeTextView.setText(Objects.toString(state.getRearSeatType(), ""));
                rhdTextView.setText(Objects.toString(state.isRhd(), ""));
                roofColorTextView.setText(Objects.toString(state.getRoofColor(), ""));
                seatTypeTextView.setText(Objects.toString(state.getSeatType(), ""));
                spoilerTypeTextView.setText(Objects.toString(state.getSpoilerType(), ""));
                sunRoofInstalledTextView.setText(Objects.toString(state.getSunRoofInstalled(), ""));
                thirdRowSeatsTextView.setText(Objects.toString(state.getThirdRowSeats(), ""));
                useRangeBadgingTextView.setText(Objects.toString(state.isUseRangeBadging(), ""));
                wheelTypeTextView.setText(Objects.toString(state.getWheelType(), ""));

                timestampTextView.setText(Objects.toString(state.getTimestamp(), ""));
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
