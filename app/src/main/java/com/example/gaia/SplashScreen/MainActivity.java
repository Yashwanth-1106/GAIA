package com.example.gaia.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.example.gaia.Authentication.AuthenticationActivity;
import com.example.gaia.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, AuthenticationActivity.class);
                    startActivity(intent);
                    finish();

                }
            },3000);
        }








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