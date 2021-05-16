package com.tesla.api.ui.states;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.tesla.api.R;
import com.google.android.material.tabs.TabLayout;
import com.tesla.api.CtrlApp;
import com.tesla.api.data.Result;
import com.tesla.api.data.TeslaAPIWrapper;
import com.tesla.api.data.model.Vehicle;
import com.tesla.api.data.model.VehicleDataResponse;

public class StatesFragment extends Fragment {

    private TabLayout stateTableLayout;
    private ViewPager viewPager;
    private CtrlPageAdapter pageAdapter;
    private ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_states, container, false);

        progressBar = (ProgressBar)  root.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        pageAdapter = new CtrlPageAdapter(getFragmentManager());
        viewPager = (ViewPager) root.findViewById(R.id.viewPager);
        viewPager.setAdapter(pageAdapter);

        stateTableLayout = (TabLayout) root.findViewById(R.id.stateTableLayout);
        stateTableLayout.setupWithViewPager(viewPager);
        stateTableLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        stateTableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                pageAdapter.loadState(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        TeslaAPIWrapper.getInstance().wakeUpVehicleUtilOnlineAsync(new TeslaAPIWrapper.VehicleInterface() {
            @Override
            public void onCompletion(Result<Vehicle> result) {
                if (result instanceof Result.Success) {
                    Vehicle data = ((Result.Success<Vehicle>) result).getData();

                    if(data.getState().equals("online")) {
                        // Get vehicle Data
                        TeslaAPIWrapper.getInstance().getVehicleDataAsync(new TeslaAPIWrapper.VehicleDataInterface() {
                            @Override
                            public void onCompletion(Result<VehicleDataResponse> result) {
                                if (result instanceof Result.Success) {
                                    // Funnel the data into each state tab
                                    pageAdapter.loadState(0);

                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(CtrlApp.getAppContext(), "Successfully loaded state data!", Toast.LENGTH_LONG).show();
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    });
                                } else {
                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(CtrlApp.getAppContext(), "Could not load state from Vehicle!", Toast.LENGTH_LONG).show();
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    });
                                }
                            }
                        });

                        return;
                    } else {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(CtrlApp.getAppContext(), "Could not bring the car online!", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        });
                    }
                } else {
                    final Result.Error error = (Result.Error) result;

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(error.toString());
                            Toast.makeText(CtrlApp.getAppContext(), "Error making request to wake up car!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    });
                }
            }
        }, 1);

        return root;
    }

}