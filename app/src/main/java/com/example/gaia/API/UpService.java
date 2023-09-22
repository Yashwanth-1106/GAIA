package com.example.gaia.API;

import com.example.gaia.Model.MissionResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface UpService {

    @GET("castor/Mission/v2/pilot/missions")
    Call<MissionResponse> getUpcomingMissions(
                @HeaderMap Map<String, String> headers,
                @Query("offset") int offset,
                @Query("limit") int limit,
                @Query("status") String status,
                @Query("customer_id") int customerId,
                @Query("sort") String sort
        );

}
