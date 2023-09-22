package com.example.gaia.Home.Mission;

import com.google.gson.annotations.SerializedName;

public class Field {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("area_claimed")
    private int areaClaimed;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAreaClaimed() {
        return areaClaimed;
    }

}
