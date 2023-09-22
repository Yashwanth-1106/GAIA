package com.example.gaia.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.gaia.API.Service;
import com.example.gaia.Adapter.ViewPager;
import com.example.gaia.Model.RequestService;
import com.example.gaia.R;

import java.util.ArrayList;
import java.util.List;

public class CardViewFragment extends Fragment {

    private ViewPager adapter;
    private List<Service> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cardview, container, false);


        // Initialize your itemList with data (e.g., from an API response or mock data)
        //itemList = createMockData();

        // Create and set the RecyclerView adapter
        adapter = new ViewPager((FragmentManager) itemList);




        return rootView;
    }

//    private List<Service> createMockData() {
//        // Create and return a list of mock data items
//        List<RequestService> mockDataList = new ArrayList<>();
//        mockDataList.add(new YourModel("Item 1", R.drawable.item1));
//        mockDataList.add(new YourModel("Item 2", R.drawable.item2));
//        // Add more items as needed
//        return mockDataList;
//    }
}

