package com.example.gaia.Authentication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gaia.API.RetrofitClient;
import com.example.gaia.API.Service;
import com.example.gaia.Home.HomeActivity;
import com.example.gaia.Model.RequestService;
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

    // Perform the login API call (replace with your API call logic)



    private void navigateToHomeActivity(View view) {
        // Navigate to HomeActivity (replace with your navigation logic)

        // Close the current activity (LoginActivity or MainActivity)
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextEmail = view.findViewById(R.id.etdEmail);
        editTextPassword = view.findViewById(R.id.etdPass);
        buttonLogin = view.findViewById(R.id.lgnBtn);

        buttonLogin.setOnClickListener(view1 -> {
            // Validate email and password

                   Toast.makeText(getContext(),"Magdgfdgdsss",Toast.LENGTH_LONG).show();
//                boolean isValid = true;
//
//                if(email.isEmpty()){
//                    editTextEmail.setError("Enter the Email Address");
//                }
//                if(password.isEmpty()){
//                    editTextPassword.setError("Enter the Password");
//                }
//
//                if (!isValidEmail(email)) {
//                    editTextEmail.setError("Invalid email");
//                    isValid = false;
//                } else {
//                    editTextEmail.setText(""); // Clear error
//                }
//
//
//                if(password.length() < 8 && password.length()>=1)
//                {
//                    editTextPassword.setError("Password must have minimum 8 characters");
//
//
//                    isValid = false;
//                } else {
//                    editTextPassword.setText(""); // Clear error
//                }

            performLogin();
        });
    }
    private void performLogin() {
        // Implement your login API call here
        // If successful, navigate to HomeActivity and store user data in SharedPreferences
        // If not, show an error message
        // Create a Retrofit instance
        //Toast.makeText(getContext(),"basfnasivns",Toast.LENGTH_LONG).show();

        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        RequestService request = new RequestService("ga-pilot-app",email, password,true);
        Service apiService = RetrofitClient.getClient().create(Service.class);

        // Create the login request model


        // Make the API call
        Call<RequestService> call = apiService.Login(request);


        call.enqueue(new Callback<RequestService>() {

            @Override
            public void onResponse(@NonNull Call<RequestService> call, @NonNull Response<RequestService> response) {
                if (response.isSuccessful()) {
                    RequestService apiResponse = response.body();
                    Log.d("API Response", "Success: " + apiResponse.toString());


                    // Store user data in SharedPreferences
                    AuthD authD = apiResponse.getAuthD();
                    SPHelper spHelper = new SPHelper(getContext());
                    spHelper.saveData(authD);


//                        // Navigate to HomeActivity
                    NavController navController = Navigation.findNavController(getView());
                    navController.navigate(R.id.action_loginFragment_to_missionFragment);
//                       Intent intent = new Intent(getContext(), HomeActivity.class);
//                       startActivity(intent);


                }
                else{
                    // Handle API error (e.g., invalid credentials)
                    Log.e("API Response", "Error: " + response.errorBody().toString());
                }
                // Display an error message to the user

            }




            @Override
            public void onFailure(Call<RequestService> call, Throwable t) {
                Log.e("API Response", "Error: " + t.getMessage());

            }
        });
    }
}

