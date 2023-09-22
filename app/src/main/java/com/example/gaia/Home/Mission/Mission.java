package com.example.gaia.Home.Mission;

import com.google.gson.annotations.SerializedName;

public class Mission {
    @SerializedName("scheduled_date")
    private String scheduledDate;

    @SerializedName("uuid")
    private String uuid;

    @SerializedName("customer")
    private Customer customer;

    @SerializedName("field")
    private Field field;

    public String getScheduledDate() {
        return scheduledDate;
    }

    public String getUuid() {
        return uuid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Field getField() {
        return field;
    }
}

