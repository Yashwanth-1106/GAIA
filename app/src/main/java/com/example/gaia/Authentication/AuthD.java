package com.example.gaia.Authentication;

import com.google.gson.annotations.SerializedName;

public class AuthD {

    @SerializedName("access_token")
    private String accessToken;

    public String getAccessToken(){
        return accessToken;
    }
}
