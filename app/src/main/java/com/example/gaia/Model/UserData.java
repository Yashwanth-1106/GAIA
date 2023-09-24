package com.example.gaia.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserData implements Serializable {

    @SerializedName("full_name")
    private String username;

    @SerializedName("mobile")
    private String mobile;
    @SerializedName("user_data")
    private String userToken;
    @SerializedName("email")
    private String email;

    private String image;

    public String getUseData(){
        return userToken;
    }

    public String getUsername() {
        return username;
    }

    public String getMobile() {
        return mobile;
    }

    public String getUserToken() {
        return userToken;
    }

    public String getEmail() {
        return email;
    }

    public UserData(String username, String mobile, String email, String image){
        this.username = username;
        this.mobile = mobile;
        this.email = email;
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
