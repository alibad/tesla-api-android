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
import com.tesla.api.data.model.GuiState;

import java.io.Serializable;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GuiStateTab.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class GuiStateTab extends Fragment {
    private OnFragmentInteractionListener mListener;

    private GuiState state;

    TableLayout guiStateTable;
    TextView guiDistanceUnitsTextView;
    TextView guiTemperatureUnitsTextView;
    TextView guiChargeRateUnitsTextView;
    TextView gui24HourTimeTextView;
    TextView guiRangeDisplayTextView;
    TextView showRangeUnitsTextView;
    TextView timestampTextView;

    public GuiStateTab() {
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
            state = (GuiState) savedInstanceState.getSerializable("state");
            loadStateInTable(state);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gui_state_tab, container, false);

        guiStateTable = (TableLayout) root.findViewById(R.id.gui_state_table);

        guiDistanceUnitsTextView = (TextView) root.findViewById(R.id.gui_distance_units_text_view);
        guiTemperatureUnitsTextView = (TextView) root.findViewById(R.id.gui_temperature_units_text_view);
        guiChargeRateUnitsTextView = (TextView) root.findViewById(R.id.gui_charge_rate_units_text_view);
        gui24HourTimeTextView = (TextView) root.findViewById(R.id.gui_24_hour_time_text_view);
        guiRangeDisplayTextView = (TextView) root.findViewById(R.id.gui_range_display_text_view);
        showRangeUnitsTextView = (TextView) root.findViewById(R.id.gui_range_units_text_view);
        timestampTextView = (TextView) root.findViewById(R.id.timestamp_text_view);

        return root;
    }

    public void loadStateInTable(final GuiState guiState) {
        state = guiState;

        if (state == null || guiStateTable == null) {
            return;
        }

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
            guiDistanceUnitsTextView.setText(Objects.toString(state.getGuiDistanceUnits(), ""));
            guiTemperatureUnitsTextView.setText(Objects.toString(state.getGuiTemperatureUnits(), ""));
            guiChargeRateUnitsTextView.setText(Objects.toString(state.getGuiChargeRateUnits(), ""));
            gui24HourTimeTextView.setText(Objects.toString(state.isGui24HourTime(), ""));
            guiRangeDisplayTextView.setText(Objects.toString(state.getGuiRangeDisplay(), ""));
            showRangeUnitsTextView.setText(Objects.toString(state.doesShowRangeUnits(), ""));
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
