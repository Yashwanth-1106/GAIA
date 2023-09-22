package com.example.gaia.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.gaia.Adapter.ViewPager;
import com.example.gaia.R;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

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
        ImageView profileImageView = rootView.findViewById(R.id.profileImageView);
        TabLayout tabLayout = rootView.findViewById(R.id.tabLayout);
        androidx.viewpager.widget.ViewPager viewPager = rootView.findViewById(R.id.viewPager);

        // Set up the ViewPager with the adapter
      ViewPager adapter = new ViewPager(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_missionFragment_to_profileFragment);

            }
        });

        return rootView;



    }


}
