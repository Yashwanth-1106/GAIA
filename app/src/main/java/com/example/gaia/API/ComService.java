package com.example.gaia.API;

import com.example.gaia.Model.UserData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ComService {

    @GET("User/v2/login")
    Call<UserData> getUserData(@Path("userId") String userId);
}


