package com.tesla.api;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tesla.api.auth.AuthStateManager;
import com.tesla.api.auth.Configuration;
import com.tesla.api.ui.login.LoginActivity;
import com.tesla.api.ui.auth.AppAuthLoginActivity;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import net.openid.appauth.AppAuthConfiguration;
import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.EndSessionRequest;

import static com.tesla.api.ui.auth.TokenActivity.END_SESSION_REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.action_toolbar);
        setSupportActionBar(myToolbar);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_states, R.id.navigation_commands)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(myToolbar, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top_nav_app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_log_out:

                AppSettings.clear();

                endSession();

                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @MainThread
    private void endSession() {
        AuthStateManager mStateManager = AuthStateManager.getInstance(this);
        AuthState currentState = mStateManager.getCurrent();
        Configuration mConfiguration = Configuration.getInstance(this);
        AuthorizationService mAuthService = new AuthorizationService(
                this,
                new AppAuthConfiguration.Builder()
                        .setConnectionBuilder(mConfiguration.getConnectionBuilder())
                        .build());

        AuthorizationServiceConfiguration config =
                currentState.getAuthorizationServiceConfiguration();
        if (config.endSessionEndpoint != null) {
            Intent endSessionIntent = mAuthService.getEndSessionRequestIntent(
                    new EndSessionRequest.Builder(
                            config,
                            currentState.getIdToken(),
                            mConfiguration.getEndSessionRedirectUri()).build());
            startActivityForResult(endSessionIntent, END_SESSION_REQUEST_CODE);
        } else {
            signOut();
        }
    }

    @MainThread
    private void signOut() {
        AuthStateManager mStateManager = AuthStateManager.getInstance(this);

        // discard the authorization and token state, but retain the configuration and
        // dynamic client registration (if applicable), to save from retrieving them again.
        AuthState currentState = mStateManager.getCurrent();
        AuthState clearedState =
                new AuthState(currentState.getAuthorizationServiceConfiguration());
        if (currentState.getLastRegistrationResponse() != null) {
            clearedState.update(currentState.getLastRegistrationResponse());
        }
        mStateManager.replace(clearedState);

        Intent mainIntent = new Intent(this, AppAuthLoginActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(mainIntent);
        finish();
    }
}
