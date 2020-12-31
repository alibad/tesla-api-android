package com.tesla.api.data;

import com.tesla.api.data.model.LoggedInUser;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
        return TeslaAPIWrapper.getInstance().login(username, password);
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
