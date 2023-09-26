package com.example.gaia.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.gaia.Home.HomeActivity;
import com.example.gaia.R;

public class AuthenticationActivity extends AppCompatActivity {


    private NavController navController;
    private LoginFragment loginFragment;
    private SPHelper spHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        NavHostFragment navHostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();

        Log.d("AuthenticationActivity", "onCreate");

        // Initialize SPHelper
        spHelper = new SPHelper(this);

        // Check if the user is logged in
        if (isLoggedIn()) {
            Log.d("AuthenticationActivity", "User is logged in");
            // User is logged in, navigate to HomeActivity or any other destination
            navigateToHomeActivity();
        } else {
            Log.d("AuthenticationActivity", "User is not logged in");
            // User is not logged in, navigate to the login screen
            navigateToLoginFragment();
        }
    }

    // Check if the user is logged in
    private boolean isLoggedIn() {
        // Use SPHelper to get the access token or any other indicator of login state
        String accessToken = spHelper.getAccessToken();
        return accessToken != null && !accessToken.isEmpty();
    }

    // Navigate to the HomeActivity
    private void navigateToHomeActivity() {
        Log.d("AuthenticationActivity", "Navigating to HomeActivity");
        // You should replace HomeActivity.class with the actual class of your HomeActivity
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish(); // Finish the AuthenticationActivity so that the user cannot navigate back to it
    }

    // Navigate to the login screen (LoginFragment)
    private void navigateToLoginFragment() {
        Log.d("AuthenticationActivity", "Navigating to LoginFragment");
        navController.navigate(R.id.loginFragment);
    }

    public NavController getNavController() {
        if (navController == null) {
            NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
            navController = navHostFragment.getNavController();
        }
        return navController;
    }




}