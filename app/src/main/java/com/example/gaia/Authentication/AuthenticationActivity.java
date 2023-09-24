package com.example.gaia.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.app.AlertDialog;
import android.os.Bundle;

import com.example.gaia.R;

public class AuthenticationActivity extends AppCompatActivity {

    private NavController navController;
    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        NavHostFragment navHostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        navController=navHostFragment.getNavController();
        navController.navigate(R.id.loginFragment);


    }

    @Override
    public void onBackPressed() {
        // Show a confirmation dialog before exiting the app
        new AlertDialog.Builder(this)
                .setTitle("Exit App")
                .setMessage("Are you sure you want to exit the app?")
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    // If the user confirms, exit the app
                    finish();
                })
                .setNegativeButton("No", (dialogInterface, i) -> {
                    // If the user cancels, dismiss the dialog
                    dialogInterface.dismiss();
                })
                .show();
    }




}