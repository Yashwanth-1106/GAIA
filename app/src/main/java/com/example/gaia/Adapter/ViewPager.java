package com.example.gaia.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gaia.Home.CompletedFragment;
import com.example.gaia.Home.UpcomingFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPager extends FragmentPagerAdapter{



        public ViewPager(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new UpcomingFragment();
                case 1:
                    return new CompletedFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2; // Number of tabs
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Upcoming";
                case 1:
                    return "Completed";
                default:
                    return null;
            }
        }
    }



