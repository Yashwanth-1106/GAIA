package com.example.gaia.Authentication;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gaia.API.RetrofitClient;
import com.example.gaia.API.Service;
import com.example.gaia.Model.PasswordEditText;
import com.example.gaia.Model.RequestService;
import com.example.gaia.Model.UserData;
import com.example.gaia.R;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login_, container, false);
        return rootView;
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextEmail = view.findViewById(R.id.etdEmail);
        editTextPassword = view.findViewById(R.id.etdPass);
        buttonLogin = view.findViewById(R.id.lgnBtn);



        buttonLogin.setOnClickListener(view1 -> performLogin());
    }

    private void performLogin() {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        RequestService request = new RequestService("ga-pilot-app", email, password, true);
        Service apiService = RetrofitClient.getClient().create(Service.class);

        Call<RequestService> call = apiService.Login(request);

        call.enqueue(new Callback<RequestService>() {
            @Override
            public void onResponse(@NonNull Call<RequestService> call, @NonNull Response<RequestService> response) {
                if (response.isSuccessful()) {
                    RequestService apiResponse = response.body();
                    Log.d("API Response", "Success: " + apiResponse.toString());

                    AuthD authD = apiResponse.getAuthD();
                    UserData userData = apiResponse.getUserData();
                    SPHelper spHelper = new SPHelper(getContext());
                    spHelper.saveData(authD);
                    spHelper.saveUser(userData);

                    NavController navController = Navigation.findNavController(getView());
                    navController.navigate(R.id.action_loginFragment_to_missionFragment);
                } else {
                    Log.e("API Response", "Error: " + response.errorBody().toString());
                    // Handle API error (e.g., invalid credentials)
                    // You may want to display an error message to the user here
                }
            }

            @Override
            public void onFailure(@NonNull Call<RequestService> call, @NonNull Throwable t) {
                Log.e("API Response", "Error: " + t.getMessage());
                // Handle network or other errors
                // You may want to display an error message to the user here
            }
        });
    }

    public void onBackPressed(){
        // Show a confirmation dialog before exiting the app
        new AlertDialog.Builder(requireContext())
                .setTitle("Exit App")
                .setMessage("Are you sure you want to exit the app?")
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    // If the user confirms, exit the app
                    requireActivity().finish();
                })
                .setNegativeButton("No", (dialogInterface, i) -> {
                    // If the user cancels, dismiss the dialog
                    dialogInterface.dismiss();
                })
                .show();
    }
    }

