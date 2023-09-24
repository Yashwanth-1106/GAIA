package com.example.gaia.Adapter;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gaia.Home.CompletedFragment;
import com.example.gaia.Home.UpcomingFragment;
import com.example.gaia.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPager extends FragmentPagerAdapter {

    private final List<String> tabTitles = new ArrayList<>();
    private final int[] tabTitleColors = {R.color.custom_color_1, R.color.custom_color_2}; // Define your custom text colors in resources
    private Context context;

    public ViewPager(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
        // Add custom tab titles here
        tabTitles.add("Upcoming");
        tabTitles.add("Completed");
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
        return tabTitles.size(); // Number of tabs
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Create a SpannableString to set custom text color for tab names
        SpannableString spannableString = new SpannableString(tabTitles.get(position));
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, tabTitleColors[position])), 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }
}