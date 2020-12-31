package com.tesla.api;

import android.content.Context;
import android.content.SharedPreferences;

import com.tesla.api.data.model.VehicleData;
import com.tesla.api.data.model.VehicleDataResponse;

public class AppSettings {
    public static final String USER_EMAIL = "userEmail";
    public static final String ACCESS_TOKEN = "accessToken";
    public static final String REFRESH_TOKEN = "refreshToken";
    public static final String SELECTED_VEHICLE_ID = "selectedVehicleId";
    public static final String TOKEN_REFRESH_DATE = "tokenRefreshDate";
    public static final String VEHICLE_DATA = "vehicleData";

    private static SharedPreferences GetPreferences() {
        Context c = CtrlApp.getAppContext();
        return c.getSharedPreferences(c.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    public static void put(String key, String value) {
        SharedPreferences.Editor editor = GetPreferences().edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String get(String key) {
        return GetPreferences().getString(key, null);
    }

    public static void clear() {
        GetPreferences().edit().clear().commit();
    }

    public static Boolean isLoggedIn() {
        String token = get(ACCESS_TOKEN);

        return token != null;
    }

    public static VehicleData getVehicleState() {
        VehicleData vehicleData = null;

        String stateJson = AppSettings.get(AppSettings.VEHICLE_DATA);

        if (stateJson != null) {
            VehicleDataResponse result = (VehicleDataResponse) JsonUtil.deserialize(stateJson, "", VehicleDataResponse.class);

            if(result != null) {
                vehicleData = result.getResponse();
            }
        }

        return vehicleData;
    }
}
