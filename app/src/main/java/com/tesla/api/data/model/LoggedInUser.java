package com.tesla.api.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;

    private LoginSuccess loginResult;

    public LoggedInUser(String userId, String displayName, LoginSuccess loginResult) {
        this.userId = userId;
        this.displayName = displayName;
        this.loginResult = loginResult;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public LoginSuccess getLoginResult() {
        return loginResult;
    }
}
