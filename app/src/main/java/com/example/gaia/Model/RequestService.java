package com.example.gaia.Model;


import com.example.gaia.API.Service;
import com.example.gaia.Authentication.AuthD;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;

public class RequestService {
    // Define fields based on the response you expect from your API
    //@SerializedName("userId")
    @SerializedName("client_id")
    private String client_id;
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("force_login")
    private boolean force_login;

    @SerializedName("auth_data")
    private AuthD authD;

    public AuthD getAuthD(){
        return authD;
    }

    public RequestService(String client_id, String username, String password, boolean force_login) {
        this.client_id = client_id;
        this.username = username;
        this.password = password;
        this.force_login = force_login;
    }



    // Add any additional fields as needed
}

