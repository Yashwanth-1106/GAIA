package com.example.gaia.Model;
import com.example.gaia.Authentication.AuthD;
import com.example.gaia.Model.UserData;
import com.google.gson.annotations.SerializedName;

public class RequestService {

    @SerializedName("client_id")
    private String clientId;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("force_login")
    private boolean forceLogin;

    @SerializedName("auth_data")
    private AuthD authData;

    @SerializedName("user_data")
    private UserData userData;

    public RequestService(String clientId, String username, String password, boolean forceLogin) {
        this.clientId = clientId;
        this.username = username;
        this.password = password;
        this.forceLogin = forceLogin;
    }


    public AuthD getAuthD() {
        return authData;
    }

    public UserData getUserData() {
        return userData;
    }
}
