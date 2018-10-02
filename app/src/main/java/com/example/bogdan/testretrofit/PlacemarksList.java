package com.example.bogdan.testretrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PlacemarksList {

    @SerializedName("placemarks")
    private ArrayList<Placemark> placemarkList;

    public ArrayList<Placemark> getPlacemarkList() {
        return placemarkList;
    }

    public void setPlacemarkList(ArrayList<Placemark> placemarkList) {
        this.placemarkList = placemarkList;
    }
}
