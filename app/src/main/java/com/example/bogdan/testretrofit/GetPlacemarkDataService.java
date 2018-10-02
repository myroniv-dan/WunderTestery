package com.example.bogdan.testretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetPlacemarkDataService {

    @GET("wunderbucket/locations.json")
    Call<PlacemarksList> getPlacemarkData();
}
