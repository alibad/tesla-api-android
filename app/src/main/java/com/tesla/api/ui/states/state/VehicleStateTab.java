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
import com.tesla.api.data.model.VehicleState;

import java.io.Serializable;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VehicleStateTab.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class VehicleStateTab extends Fragment {
    private OnFragmentInteractionListener mListener;

    private VehicleState state;

    TableLayout vehicleStateTable;

    TextView apiVersionTextView;
    TextView autoparkStateTextView;
    TextView autoparkStateV2TextView;
    TextView autoparkStyleTextView;
    TextView calendarSupportedTextView;
    TextView carVersionTextView;
    TextView centerDisplayStateTextView;
    TextView dfTextView;
    TextView drTextView;
    TextView ftTextView;
    TextView homelinkDeviceCountTextView;
    TextView homelinkNearbyTextView;
    TextView lastAutoparkErrorTextView;
    TextView lockedTextView;
    TextView mediaStateTextView;
    TextView notificationsSupportedTextView;
    TextView odometerTextView;
    TextView parsedCalendarSupportedTextView;
    TextView pfTextView;
    TextView prTextView;
    TextView remoteStartTextView;
    TextView remoteStartSupportedTextView;
    TextView rtTextView;
    TextView sentryModeTextView;
    TextView softwareUpdateTextView;
    TextView sunRoofPercentOpenTextView;
    TextView sunRoofStateTextView;
    TextView valetModeTextView;
    TextView vehicleNameTextView;
    TextView speedLimitModeTextView;
    TextView fdWindowTextView;
    TextView fpWindowTextView;
    TextView rdWindowTextView;
    TextView rpWindowTextView;

    TextView timestampTextView;

    public VehicleStateTab() {
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
            state = (VehicleState) savedInstanceState.getSerializable("state");
            loadStateInTable(state);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_vehicle_state_tab, container, false);

        vehicleStateTable = (TableLayout) root.findViewById(R.id.vehicle_state_table);

        apiVersionTextView = (TextView) root.findViewById(R.id.api_version_text_view);
        autoparkStateTextView = (TextView) root.findViewById(R.id.autopark_state_text_view);
        autoparkStateV2TextView = (TextView) root.findViewById(R.id.autopark_state_v2_text_view);
        autoparkStyleTextView = (TextView) root.findViewById(R.id.autopark_style_text_view);
        calendarSupportedTextView = (TextView) root.findViewById(R.id.calendar_supported_text_view);
        carVersionTextView = (TextView) root.findViewById(R.id.car_version_text_view);
        centerDisplayStateTextView = (TextView) root.findViewById(R.id.center_display_text_view);
        dfTextView = (TextView) root.findViewById(R.id.df_text_view);
        drTextView = (TextView) root.findViewById(R.id.dr_text_view);
        ftTextView = (TextView) root.findViewById(R.id.ft_text_view);
        homelinkDeviceCountTextView = (TextView) root.findViewById(R.id.homelink_device_count_text_view);
        homelinkNearbyTextView = (TextView) root.findViewById(R.id.homelink_nearby_text_view);
        lastAutoparkErrorTextView = (TextView) root.findViewById(R.id.last_autopark_error_text_view);
        lockedTextView = (TextView) root.findViewById(R.id.locked_text_view);
        mediaStateTextView = (TextView) root.findViewById(R.id.media_state_text_view);
        notificationsSupportedTextView = (TextView) root.findViewById(R.id.notifications_supported_text_view);
        odometerTextView = (TextView) root.findViewById(R.id.odometer_text_view);
        parsedCalendarSupportedTextView = (TextView) root.findViewById(R.id.parsed_calendar_supported_text_view);
        pfTextView = (TextView) root.findViewById(R.id.pf_text_view);
        prTextView = (TextView) root.findViewById(R.id.pr_text_view);
        remoteStartTextView = (TextView) root.findViewById(R.id.remote_start_text_view);
        remoteStartSupportedTextView = (TextView) root.findViewById(R.id.remote_start_supported_text_view);
        rtTextView = (TextView) root.findViewById(R.id.rt_text_view);
        sentryModeTextView = (TextView) root.findViewById(R.id.sentry_mode_text_view);
        softwareUpdateTextView = (TextView) root.findViewById(R.id.software_update_text_view);
        sunRoofPercentOpenTextView = (TextView) root.findViewById(R.id.sun_roof_percent_open_text_view);
        sunRoofStateTextView = (TextView) root.findViewById(R.id.sunroof_state_text_view);
        valetModeTextView = (TextView) root.findViewById(R.id.valet_mode_text_view);
        vehicleNameTextView = (TextView) root.findViewById(R.id.vehicle_name_text_view);
        speedLimitModeTextView = (TextView) root.findViewById(R.id.speed_limit_mode_text_view);
        fdWindowTextView = (TextView) root.findViewById(R.id.fd_window_text_view);
        fpWindowTextView = (TextView) root.findViewById(R.id.fp_window_text_view);
        rdWindowTextView = (TextView) root.findViewById(R.id.rd_window_text_view);
        rpWindowTextView = (TextView) root.findViewById(R.id.rp_window_text_view);

        timestampTextView = (TextView) root.findViewById(R.id.timestamp_text_view);

        return root;
    }

    public void loadStateInTable(final VehicleState configState) {

        state = configState;

        if (state == null || vehicleStateTable == null) {
            return;
        }

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
            apiVersionTextView.setText(Objects.toString(state.getApiVersion(), ""));
            autoparkStateTextView.setText(Objects.toString(state.getAutoparkState(), ""));
            autoparkStateV2TextView.setText(Objects.toString(state.getAutoparkStateV2(), ""));
            autoparkStyleTextView.setText(Objects.toString(state.getAutoparkStyle(), ""));
            calendarSupportedTextView.setText(Objects.toString(state.isCalendarSupported(), ""));
            carVersionTextView.setText(Objects.toString(state.getCarVersion(), ""));
            centerDisplayStateTextView.setText(Objects.toString(state.getCenterDisplayState(), ""));
            dfTextView.setText(Objects.toString(state.getDf(), ""));
            drTextView.setText(Objects.toString(state.getDr(), ""));
            ftTextView.setText(Objects.toString(state.getFt(), ""));
            homelinkDeviceCountTextView.setText(Objects.toString(state.getHomelinkDeviceCount(), ""));
            homelinkNearbyTextView.setText(Objects.toString(state.isHomelinkNearby(), ""));
            lastAutoparkErrorTextView.setText(Objects.toString(state.getLastAutoparkError(), ""));
            lockedTextView.setText(Objects.toString(state.isLocked(), ""));
            mediaStateTextView.setText(Objects.toString(state.getMediaState(), ""));
            notificationsSupportedTextView.setText(Objects.toString(state.isNotificationsSupported(), ""));
            odometerTextView.setText(Objects.toString(state.getOdometer(), ""));
            parsedCalendarSupportedTextView.setText(Objects.toString(state.isParsedCalendarSupported(), ""));
            pfTextView.setText(Objects.toString(state.getPf(), ""));
            prTextView.setText(Objects.toString(state.getPr(), ""));
            remoteStartTextView.setText(Objects.toString(state.isRemoteStart(), ""));
            remoteStartSupportedTextView.setText(Objects.toString(state.isRemoteStartSupported(), ""));
            rtTextView.setText(Objects.toString(state.getRt(), ""));
            sentryModeTextView.setText(Objects.toString(state.isSentryMode(), ""));
            softwareUpdateTextView.setText(Objects.toString(state.getSoftwareUpdate(), ""));
            sunRoofPercentOpenTextView.setText(Objects.toString(state.getSunRoofPercentOpen(), ""));
            sunRoofStateTextView.setText(Objects.toString(state.getSunRoofState(), ""));
            valetModeTextView.setText(Objects.toString(state.isValetMode(), ""));
            vehicleNameTextView.setText(Objects.toString(state.getVehicleName(), ""));
            speedLimitModeTextView.setText(Objects.toString(state.getSpeedLimitMode(), ""));
            fdWindowTextView.setText(Objects.toString(state.getFdWindow(), ""));
            fpWindowTextView.setText(Objects.toString(state.getFpWindow(), ""));
            rdWindowTextView.setText(Objects.toString(state.getRdWindow(), ""));
            rpWindowTextView.setText(Objects.toString(state.getFpWindow(), ""));
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
