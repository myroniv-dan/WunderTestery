package com.example.bogdan.testretrofit;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Placemark{

    @SerializedName("address")
    private String address;

    @SerializedName("coordinates")
    private double[] coordinates;

    @SerializedName("engineType")
    private String engineType;

    @SerializedName("exterior")
    private String exterior;

    @SerializedName("fuel")
    private int fuel;

    @SerializedName("interior")
    private String interior;

    @SerializedName("name")
    private String name;

    @SerializedName("vin")
    private String vin;

    public Placemark(String address, double[] coordinates, String engineType, String exterior, int fuel, String interior, String name, String vin) {
        this.address = address;
        this.coordinates = coordinates;
        this.engineType = engineType;
        this.exterior = exterior;
        this.fuel = fuel;
        this.interior = interior;
        this.name = name;
        this.vin = vin;
    }

    public String getAddress() {
        return address;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public double getLatitude() {
        return coordinates[0];
    }

    public double getLongitude() {
        return coordinates[1];
    }

    public String getEngineType() {
        return engineType;
    }

    public String getExterior() {
        return exterior;
    }

    public int getFuel() {
        return fuel;
    }

    public String getInterior() {
        return interior;
    }

    public String getName() {
        return name;
    }

    public String getVin() {
        return vin;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
