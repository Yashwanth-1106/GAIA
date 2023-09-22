package com.example.gaia.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gaia.API.MissionClient;
import com.example.gaia.API.RetrofitClient;
import com.example.gaia.API.Service;
import com.example.gaia.API.UpService;
import com.example.gaia.Adapter.MissionAdapter;
import com.example.gaia.Authentication.SPHelper;
import com.example.gaia.Home.Mission.Mission;
import com.example.gaia.Model.MissionResponse;
import com.example.gaia.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class UpcomingFragment extends Fragment {
    private SPHelper spHelper;

    private MissionAdapter adapter;
    private RecyclerView recyclerView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inside onCreateView method
// Make the API call and populate the RecyclerView


        return inflater.inflate(R.layout.fragment_upcoming, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spHelper = new SPHelper(getContext());
        String accessT = spHelper.getAccessToken();

        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("offset", "0");  // Replace with your desired offset
        queryParameters.put("limit", "10");   // Replace with your desired limit
        queryParameters.put("status", "upcoming");
        queryParameters.put("customer_id", "1186");  // Replace with your customer ID
        queryParameters.put("sort", "DESC");

        // Create the RecyclerView and adapter
        recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new MissionAdapter(new ArrayList<>()); // Initialize with an empty list

        // Set the adapter to the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Call the API to fetch upcoming missions and update the adapter
        fetchUpcomingMissions(accessT, queryParameters);
    }

    private void fetchUpcomingMissions(String accessToken, Map<String, String> queryParameters) {
        // Create a Retrofit instance and API service
        Retrofit retrofit = MissionClient.getClient();
        UpService apiService = retrofit.create(UpService.class);

        // Add the authorization header with the accessToken
        String authorizationHeader = "Bearer " + accessToken;
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", authorizationHeader);

        // Make the API request to get upcoming missions with headers
        Call<MissionResponse> call = apiService.getUpcomingMissions(
                headers,
                Integer.parseInt(Objects.requireNonNull(queryParameters.get("offset"))),
                Integer.parseInt(Objects.requireNonNull(queryParameters.get("limit"))),
                queryParameters.get("status"),
                Integer.parseInt(Objects.requireNonNull(queryParameters.get("customer_id"))),
                queryParameters.get("sort")
        );

        // Execute the API call (enqueue it)
        call.enqueue(new Callback<MissionResponse>() {
            @Override
            public void onResponse(Call<MissionResponse> call, Response<MissionResponse> response) {
                if (response.isSuccessful()) {
                    // Retrieve the list of missions from the response
                    List<Mission> missionsList = response.body().getMissions();
                    Log.d("API Response", "Success: " + missionsList.toString());

                    // Update your existing RecyclerView adapter with the missionsList
                    adapter.setMissions(missionsList);
                } else {
                    // Handle the error response
                    // You can display an error message or handle it as needed
                    Toast.makeText(getContext(), "Failed to fetch missions", Toast.LENGTH_SHORT).show();
                    Log.e("API Response", "Error: " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<MissionResponse> call, Throwable t) {
                // Handle network or other errors here
                Toast.makeText(getContext(), "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }



}