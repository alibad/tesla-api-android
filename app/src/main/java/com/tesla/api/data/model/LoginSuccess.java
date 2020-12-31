package com.tesla.api.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginSuccess implements Serializable {

    @SerializedName("access_token")
    private String accessToken = null;

    @SerializedName("token_type")
    private String tokenType = null;

    @SerializedName("expires_in")
    private Long expiresIn = null;

    @SerializedName("refresh_token")
    private String refreshToken = null;

    /**
     **/
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     **/
    public String getTokenType() {
        return tokenType;
    }
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    /**
     **/
    public Long getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     **/
    public String getRefreshToken() {
        return refreshToken;
    }
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoginSuccess loginSuccess = (LoginSuccess) o;
        return (this.accessToken == null ? loginSuccess.accessToken == null : this.accessToken.equals(loginSuccess.accessToken)) &&
                (this.tokenType == null ? loginSuccess.tokenType == null : this.tokenType.equals(loginSuccess.tokenType)) &&
                (this.expiresIn == null ? loginSuccess.expiresIn == null : this.expiresIn.equals(loginSuccess.expiresIn));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (this.accessToken == null ? 0: this.accessToken.hashCode());
        result = 31 * result + (this.tokenType == null ? 0: this.tokenType.hashCode());
        result = 31 * result + (this.expiresIn == null ? 0: this.expiresIn.hashCode());
        return result;
    }

    @Override
    public String toString()  {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoginSuccess {\n");

        sb.append("  accessToken: ").append(accessToken).append("\n");
        sb.append("  tokenType: ").append(tokenType).append("\n");
        sb.append("  expiresIn: ").append(expiresIn).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
