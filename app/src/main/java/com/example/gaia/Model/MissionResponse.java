package com.example.gaia.Model;

import com.example.gaia.Home.Mission.Mission;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MissionResponse {

    @SerializedName("missions")
    private List<Mission> mission;

    public List<Mission> getMissions() {
        return mission;
    }
}
