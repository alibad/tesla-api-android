package com.tesla.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tesla.api.ui.auth.AppAuthLoginActivity;

public class MainEmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent activityIntent;

        // go straight to main if a token is stored
        if (AppSettings.isLoggedIn()) {
            activityIntent = new Intent(this, MainActivity.class);
        } else {
            activityIntent = new Intent(this, AppAuthLoginActivity.class);
        }

        startActivity(activityIntent);
        finish();
    }
}
