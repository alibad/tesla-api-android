package com.tesla.api.data;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.tesla.api.AppSettings;
import com.tesla.api.CtrlApp;
import com.tesla.api.JsonUtil;
import com.tesla.api.data.model.LoggedInUser;
import com.tesla.api.data.model.LoginSuccess;
import com.tesla.api.data.model.Vehicle;
import com.tesla.api.data.model.VehicleDataResponse;
import com.tesla.api.data.model.VehicleList;
import com.tesla.api.data.model.VehicleResponse;
import com.tesla.api.data.model.commands.CommandResponse;
import com.tesla.api.data.model.commands.CmdResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class TeslaAPIWrapper {
    private String basePath = "https://owner-api.teslamotors.com/";
    private String authPath = basePath + "oauth/token";
    private String vehiclesPath = basePath + "api/1/vehicles";

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static TeslaAPIWrapper instance = null;

    OkHttpClient client = new OkHttpClient();

    public static TeslaAPIWrapper getInstance() {
        synchronized(TeslaAPIWrapper.class) {
            if (instance == null) {
                instance = new TeslaAPIWrapper();
            }

            return instance;
        }
    }

    public Result<LoginSuccess> refreshToken() {
        String refreshToken = AppSettings.get(AppSettings.REFRESH_TOKEN);

        JSONObject jObjectType = new JSONObject();
        try {
            jObjectType.put("grant_type", "refresh_token");
            jObjectType.put("client_id", "81527cff06843c8634fdc09e8ac0abefb46ac849f38fe1e431c2ef2106796384");
            jObjectType.put("client_secret", "c7257eb71a564034f9419ee651c7d0e5f7aa6bfbd18bafb5c5c033b093bb2fa3");
            jObjectType.put("refresh_token", refreshToken);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> future = post(authPath, jObjectType.toString(), false);

        try {
            String resultJson = future.get();

            LoginSuccess result = JsonUtil.getGson().fromJson(resultJson, LoginSuccess.class);

            String accessToken = result.getAccessToken();

            if(accessToken == null) {
                throw new Exception(resultJson);
            }

            AppSettings.put(AppSettings.ACCESS_TOKEN, accessToken);
            AppSettings.put(AppSettings.TOKEN_REFRESH_DATE, Long.toString(System.currentTimeMillis()));

            String newRefreshToken = result.getRefreshToken();
            AppSettings.put(AppSettings.REFRESH_TOKEN, newRefreshToken);

            return new Result.Success<LoginSuccess>(result);
        } catch (Exception e) {
            return new Result.Error(e);
        }
    }

    public Result<VehicleList> getVehicleList() {
        CompletableFuture<String> future = get(vehiclesPath);

        try {

            String resultsJson = future.get();

            VehicleList result = JsonUtil.getGson().fromJson(resultsJson, VehicleList.class);

            if(result.getCount() > 0) {
                String selectedVehicleId = result.getResponse().get(0).getId();
                AppSettings.put(AppSettings.SELECTED_VEHICLE_ID, selectedVehicleId);
            }

            return new Result.Success<VehicleList>(result);
        } catch (Exception e) {
            return new Result.Error(e);
        }
    }

    public interface VehicleInterface {
        void onCompletion(Result<Vehicle> result);
    }

    public void wakeUpVehicleUtilOnlineAsync(final VehicleInterface vehicleCallback, final int retries) {
        int maxRetries = 15;

        if(retries >= maxRetries) {
            vehicleCallback.onCompletion(new Result.Error(new Exception("Vehicle is just not waking up!")));
            return;
        }

        // Make sure the vehicle is woken up
        TeslaAPIWrapper.getInstance().wakeUpVehicleAsync(new TeslaAPIWrapper.VehicleInterface() {
            @Override
            public void onCompletion(Result<Vehicle> result) {
                if (result instanceof Result.Success) {
                    Vehicle data = ((Result.Success<Vehicle>) result).getData();

                    if(data.getState().equals("online")) {
                        vehicleCallback.onCompletion(new Result.Success<Vehicle>(data));
                        return;
                    } else {
                        wakeUpVehicleUtilOnlineAsync(vehicleCallback, retries + 1);
                    }
                } else {

                    if (result instanceof Result.Error) {
                        int httpStatusCode = ((Result.Error) result).getHttpStatusCode();

                        // If not authorized, try to refresh the token
                        if(httpStatusCode == 401) {
                            Result<LoginSuccess> r = TeslaAPIWrapper.getInstance().refreshToken();

                            if (r instanceof Result.Success) {
                                LoginSuccess s = ((Result.Success<LoginSuccess>) r).getData();

                                AppSettings.put(AppSettings.ACCESS_TOKEN, s.getAccessToken());
                                AppSettings.put(AppSettings.REFRESH_TOKEN, s.getRefreshToken());
                                AppSettings.put(AppSettings.TOKEN_REFRESH_DATE, Long.toString(System.currentTimeMillis()));

                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(CtrlApp.getAppContext(), "Successfully refreshed token!", Toast.LENGTH_LONG).show();
                                        wakeUpVehicleUtilOnlineAsync(vehicleCallback, retries + 1);
                                    }
                                });
                            } else {
                                AppSettings.put(AppSettings.ACCESS_TOKEN, null);

                                // route to login screen
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                    Toast.makeText(CtrlApp.getAppContext(), "Token expired. Re-open the app to log back in", Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        } else {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    wakeUpVehicleUtilOnlineAsync(vehicleCallback, retries + 1);
                                }
                            }, 100);
                        }
                    }
                }
            }
        });
    }

    public void wakeUpVehicleAsync(final VehicleInterface vehicleCallback) {
        String selectedVehicle = AppSettings.get(AppSettings.SELECTED_VEHICLE_ID);

        if (selectedVehicle == null) {
            Result<VehicleList> result2 = getVehicleList();
            if (result2 instanceof Result.Success) {
                selectedVehicle = AppSettings.get(AppSettings.SELECTED_VEHICLE_ID);
            } else {
                return;
            }
        }

        String url = Paths.get(vehiclesPath, selectedVehicle , "wake_up").toString();

        postAsync(url, new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                vehicleCallback.onCompletion(new Result.Error(e));
            }

            @Override public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {

                    try {
                        String resultJson = response.body().string();
                        VehicleResponse responseResult = (VehicleResponse) JsonUtil.deserialize(resultJson, "", VehicleResponse.class);
                        Vehicle result = responseResult.getResponse();

                        vehicleCallback.onCompletion(new Result.Success<Vehicle>(result));
                    } catch (Exception e) {
                        vehicleCallback.onCompletion(new Result.Error(e));
                    }
                } else {
                    vehicleCallback.onCompletion(new Result.Error(new IOException("Error waking up vehicle"), response.code()));
                }
            }
        });
    }

    public interface VehicleDataInterface {
        void onCompletion(Result<VehicleDataResponse> result);
    }

    public void getVehicleDataAsync(final VehicleDataInterface vehicleDataCallback) {
        String url = Paths.get(vehiclesPath, AppSettings.get(AppSettings.SELECTED_VEHICLE_ID), "vehicle_data").toString();

        getAsync(url, new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                vehicleDataCallback.onCompletion(new Result.Error(e));
            }

            @Override public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {

                    try {
                        String resultJson = response.body().string();
                        AppSettings.put(AppSettings.VEHICLE_DATA, resultJson);

                        VehicleDataResponse result = (VehicleDataResponse) JsonUtil.deserialize(resultJson, "", VehicleDataResponse.class);

                        vehicleDataCallback.onCompletion(new Result.Success<VehicleDataResponse>(result));
                    } catch (Exception e) {
                        vehicleDataCallback.onCompletion(new Result.Error(e));
                    }
                } else {
                    vehicleDataCallback.onCompletion(new Result.Error(new IOException("Error getting vehicle data")));
                }
            }
        });
    }

    private Result<VehicleDataResponse> getVehicleData() {
        CompletableFuture<String> future = get(Paths.get(vehiclesPath, AppSettings.get(AppSettings.SELECTED_VEHICLE_ID), "vehicle_data").toString());

        try {

            String resultJson = future.get();

            AppSettings.put(AppSettings.VEHICLE_DATA, resultJson);

            VehicleDataResponse result = (VehicleDataResponse) JsonUtil.deserialize(resultJson, "", VehicleDataResponse.class);

            return new Result.Success<VehicleDataResponse>(result);

        } catch (Exception e) {
            return new Result.Error(e);
        }
    }

    public interface CommandInterface {
        void onCompletion(Result<CmdResponse> result);
    }

    public void executeCommandAsync(final String commandName,
                                    final CommandInterface commandCallback) {
        executeCommandAsync(commandName, null, commandCallback);
    }

    public void executeCommandAsync(final String commandName,
                                    final JSONObject body,
                                    final CommandInterface commandCallback) {
        String url = Paths.get(vehiclesPath, AppSettings.get(AppSettings.SELECTED_VEHICLE_ID), "command/" + commandName).toString();

        String jsonBodyStr = (body == null) ? "" : body.toString();

        postAsync(url, jsonBodyStr, new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                commandCallback.onCompletion(new Result.Error(e));
            }

            @Override public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {

                    try {
                        String resultJson = response.body().string();
                        CommandResponse responseResult = (CommandResponse) JsonUtil.deserialize(resultJson, "", CommandResponse.class);
                        CmdResponse result = responseResult.getResponse();

                        commandCallback.onCompletion(new Result.Success<CmdResponse>(result));
                    } catch (Exception e) {
                        commandCallback.onCompletion(new Result.Error(e));
                    }
                } else {
                    commandCallback.onCompletion(new Result.Error(new IOException("Error executing command: " + commandName)));
                }
            }
        });
    }

    private Callback toCallback(final CompletableFuture<String> future) {
        return new Callback() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override public void onFailure(Call call, IOException e) {
                future.completeExceptionally(e);
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override public void onResponse(Call call, Response response) {
                try {
                    future.complete(response.body().string());
                } catch (Exception e) {
                    future.completeExceptionally(e);
                }
            }
        };
    }

    private Map<String, String> getHeaderWithAccessToken() {
        Map<String, String> headerParams = new HashMap<String, String>();

        headerParams.put("Authorization", String.format("Bearer %s", AppSettings.get(AppSettings.ACCESS_TOKEN)));

        addUserAgentHeader(headerParams);

        return headerParams;
    }

    private void addUserAgentHeader(Map<String, String> headerParams) {
        String userAgent = "cTrl";

        headerParams.put("user-agent", userAgent.toString());
    }

    private CompletableFuture<String> get(String url) {
        return makeRequest(url, getHeaderWithAccessToken(), false, null);
    }

    private void getAsync(String url, Callback callback) {
        makeRequestAsync(url, getHeaderWithAccessToken(), false, null, callback);
    }

    private void postAsync(String url, Callback callback) {
        postAsync(url, "", callback);
    }

    private void postAsync(String url, String jsonBody, Callback callback) {
        makeRequestAsync(url, getHeaderWithAccessToken(), true, jsonBody, callback);
    }

    private CompletableFuture<String> post(String url, String jsonBody) {
        return post(url, jsonBody, true);
    }

    private CompletableFuture<String> post(String url, String jsonBody, Boolean includeAuthHeaders) {
        return makeRequest(url, includeAuthHeaders ? getHeaderWithAccessToken() : null, true, jsonBody);
    }

    private CompletableFuture<String> makeRequest(String url, Map<String, String> headerParams, Boolean isPostRequest, String jsonBody) {
        Request.Builder builder = new Request.Builder()
                .url(url);

        if (headerParams != null) {
            for (String header : headerParams.keySet()) {
                builder.addHeader(header, headerParams.get(header));
            }
        }

        Request request = null;

        if (isPostRequest) {
            request = builder.post(RequestBody.create(jsonBody, JSON)).build();
        } else {
            request = builder.get().build();
        }

        Call call = client.newCall(request);

        CompletableFuture<String> future = new CompletableFuture<String>();
        call.enqueue(toCallback(future));

        return future;
    }

    private void makeRequestAsync(String url, Map<String, String> headerParams, Boolean isPostRequest, String jsonBody, Callback callback) {
        Request.Builder builder = new Request.Builder()
                .url(url);

        if (headerParams != null) {
            for (String header : headerParams.keySet()) {
                builder.addHeader(header, headerParams.get(header));
            }
        }

        Request request = null;

        if (isPostRequest) {
            request = builder.post(RequestBody.create(jsonBody, JSON)).build();
        } else {
            request = builder.get().build();
        }

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
