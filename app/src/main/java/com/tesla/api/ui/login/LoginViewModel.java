package com.tesla.api.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.tesla.api.data.LoginRepository;
import com.tesla.api.data.Result;
import com.tesla.api.data.TeslaAPIWrapper;
import com.tesla.api.data.model.LoggedInUser;
import com.tesla.api.R;
import com.tesla.api.data.model.Vehicle;
import com.tesla.api.data.model.VehicleList;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        // can be launched in a separate asynchronous job
        Result<LoggedInUser> result = loginRepository.login(username, password);

        System.out.println("After login repository returns from login attempt");

        if (result instanceof Result.Success) {
            LoggedInUser user = ((Result.Success<LoggedInUser>) result).getData();

            // On successful login, make a call to get the list of vehicles
            // TODO: refactor with VehicleRepository
            Result<VehicleList> result2 = TeslaAPIWrapper.getInstance().getVehicleList();
            if (result2 instanceof Result.Success) {
                VehicleList list = ((Result.Success<VehicleList>) result2).getData();
                for (Vehicle vehicle:
                     list.getResponse()) {

                    System.out.println(vehicle.getDisplayName());
                }
            }

            loginResult.setValue(new LoginResult(new LoggedInUserView(user.getDisplayName())));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
