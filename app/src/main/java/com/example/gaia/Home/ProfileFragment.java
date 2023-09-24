package com.example.gaia.Home;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaia.Authentication.SPHelper;
import com.example.gaia.Model.UserData;
import com.example.gaia.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;


public class ProfileFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    ImageView imageView = view.findViewById(R.id.imageView);
        TextView username = view.findViewById(R.id.tv);
        TextView mobile = view.findViewById(R.id.tvv);
        TextView email = view.findViewById(R.id.tvvv);
        ImageView profileImg = view.findViewById(R.id.iv);

        SPHelper sharedPreferencesHelper = new SPHelper(requireContext());

        // Retrieve user data from SharedPreferences
        UserData userData = sharedPreferencesHelper.getUseData();



        if (userData != null) {
            // Now you have access to userData, and you can update your UI with it
            username.setText(userData.getUsername());
            mobile.setText(userData.getMobile());
            email.setText(userData.getEmail());

            // Check if profileImg is null
            if (profileImg != null) {
                // Load the user's profile image using Picasso
                String imageUrl = userData.getImage();
                Log.d("ImageURL", imageUrl); // Log the image URL for debugging
                Picasso.get().load(imageUrl).into(profileImg);
            } else {
                Log.e("ProfileFragment", "profileImg is null");
            }
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_profileFragment_to_missionFragment);
            }
        });

        Button button = view.findViewById(R.id.ltbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_profileFragment_to_loginFragment);
            }
        });







    }
}