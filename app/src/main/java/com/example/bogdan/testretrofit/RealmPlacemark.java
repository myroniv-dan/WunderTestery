package com.example.bogdan.testretrofit;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class RealmPlacemark extends RealmObject{

    private String address, engineType, exterior, interior, name, vin;
    private int fuel;
    //private double[] coordinates;

    //RealmList<Placemark> realmList;

//    public void setRealmList(RealmList<Placemark> realmList) {
//        this.realmList = realmList;
//    }
//
//    public RealmList<Placemark> getRealmList() {
//
//        return realmList;
//    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
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

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

//    public void setCoordinates(double[] coordinates) {
//        this.coordinates = coordinates;
//    }

    public String getAddress() {
        return address;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getExterior() {
        return exterior;
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

    public int getFuel() {
        return fuel;
    }

//    public double[] getCoordinates() {
//        return coordinates;
//    }
}
