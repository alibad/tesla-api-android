package com.tesla.api;

import android.app.Application;
import android.content.Context;

public class CtrlApp extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        CtrlApp.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return CtrlApp.context;
    }
}
