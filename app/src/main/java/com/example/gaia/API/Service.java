package com.example.gaia.API;
import com.example.gaia.Model.RequestService;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Service {

    @POST("login") // Replace with your API endpoint
    Call<RequestService> Login(@Body RequestService request);


}
