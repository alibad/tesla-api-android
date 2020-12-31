package com.tesla.api.ui.states.state;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.tesla.api.R;
import com.tesla.api.data.model.DriveState;

import java.io.Serializable;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DriveStateTab.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class DriveStateTab extends Fragment {
    private OnFragmentInteractionListener mListener;

    private DriveState state;

    TableLayout driveStateTable;
    TextView gpsTextView;
    TextView headingTextView;
    TextView latitudeTextView;
    TextView longitudeTextView;
    TextView nativeLocationSupportedTextView;
    TextView nativeLatitudeTextView;
    TextView nativeLongitudeTextView;
    TextView nativeTypeTextView;
    TextView powerTextView;
    TextView shiftStateTextView;
    TextView speedTextView;
    TextView timestampTextView;

    public DriveStateTab() {
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
            state = (DriveState) savedInstanceState.getSerializable("state");
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
        View root = inflater.inflate(R.layout.fragment_drive_state_tab, container, false);

        driveStateTable = (TableLayout) root.findViewById(R.id.drive_state_table);

        gpsTextView = (TextView) root.findViewById(R.id.gps_text_view);
        headingTextView = (TextView) root.findViewById(R.id.heading_text_view);
        latitudeTextView = (TextView) root.findViewById(R.id.latitude_text_view);
        longitudeTextView = (TextView) root.findViewById(R.id.longitude_text_view);
        nativeLocationSupportedTextView = (TextView) root.findViewById(R.id.native_location_supported_text_view);
        nativeLatitudeTextView = (TextView) root.findViewById(R.id.native_latitude_text_view);
        nativeLongitudeTextView = (TextView) root.findViewById(R.id.native_longitude_text_view);
        nativeTypeTextView = (TextView) root.findViewById(R.id.native_type_text_view);
        powerTextView = (TextView) root.findViewById(R.id.power_text_view);
        shiftStateTextView = (TextView) root.findViewById(R.id.shift_state_text_view);
        speedTextView = (TextView) root.findViewById(R.id.speed_text_view);
        timestampTextView = (TextView) root.findViewById(R.id.timestamp_text_view);

        return root;
    }

    public void loadStateInTable(final DriveState driveState) {
        state = driveState;

        if (state == null || driveStateTable == null) {
            return;
        }

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
            gpsTextView.setText(Objects.toString(state.getGpsAsOf(), ""));
            headingTextView.setText(Objects.toString(state.getHeading(), ""));
            latitudeTextView.setText(Objects.toString(state.getLatitude(), ""));
            longitudeTextView.setText(Objects.toString(state.getLongitude(), ""));
            nativeLocationSupportedTextView.setText(Objects.toString(state.getNativeLocationSupported(), ""));
            nativeLatitudeTextView.setText(Objects.toString(state.getNativeLatitude(), ""));
            nativeLongitudeTextView.setText(Objects.toString(state.getNativeLongitude(), ""));
            nativeTypeTextView.setText(state.getNativeType());
            powerTextView.setText(Objects.toString(state.getPower(), ""));
            shiftStateTextView.setText(state.getShiftState());
            speedTextView.setText(Objects.toString(state.getSpeed(), ""));
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
