package com.example.gaia.Home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.gaia.Adapter.ViewPager;
import com.example.gaia.Authentication.AuthenticationActivity;
import com.example.gaia.R;
import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;

public class MissionFragment extends Fragment {

    public MissionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mission, container, false);

        // Find views


        return rootView;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView profileImageView = view.findViewById(R.id.profileImageView);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        androidx.viewpager.widget.ViewPager viewPager = view.findViewById(R.id.viewPager);

        // Set up the ViewPager with the adapter
        ViewPager adapter = new ViewPager(getChildFragmentManager(), getContext());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = NavHostFragment.findNavController(MissionFragment.this);

                // Navigate to another fragment (replace YourDestinationFragment with the actual destination)
                navController.navigate(R.id.action_missionFragment_to_profileFragment2);
            }


        });
    }
}

