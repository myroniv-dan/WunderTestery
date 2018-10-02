package com.example.bogdan.testretrofit;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    PlacemarkAdapter placemarkAdapter;
    RecyclerView recyclerView;

    RealmResults<RealmPlacemark> realmPlacemarks;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Realm.init(getContext());
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                .initialData(realm -> {
                    // Load from file "cities.json" first time
                    List<RealmPlacemark> cities = loadCities();
                    if (cities != null) {
                        // Use insertOrUpdate() to convert the objects into proper RealmObjects managed by Realm.
                        realm.insertOrUpdate(cities);
                        placemarkAdapter = new PlacemarkAdapter(getContext(),realmPlacemarks);
                        
                        recyclerView = getView().findViewById(R.id.recyclerView);

                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

                        recyclerView.setLayoutManager(layoutManager);

                        recyclerView.setAdapter(placemarkAdapter);
                        initShit();
                    }
                })
                .deleteRealmIfMigrationNeeded()
                .build()
        );





        GetPlacemarkDataService service = RetrofitInstance.getRetrofitInstance().create(GetPlacemarkDataService.class);
        Call<PlacemarksList> call = service.getPlacemarkData();

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<PlacemarksList>() {

            @Override
            public void onResponse(Call<PlacemarksList> call, Response<PlacemarksList> response) {

                makePlacemarksList(response.body().getPlacemarkList());
            }

            @Override
            public void onFailure(Call<PlacemarksList> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void makePlacemarksList(ArrayList<Placemark> placemarkList) {

        recyclerView = getView().findViewById(R.id.recyclerView);

        //placemarkAdapter = new PlacemarkAdapter(placemarkList,getContext(),);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(placemarkAdapter);
    }

    private void initShit(){

        recyclerView = getView().findViewById(R.id.recyclerView);

        //placemarkAdapter = new PlacemarkAdapter(placemarkList,getContext(),);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(placemarkAdapter);

    }

    private List<RealmPlacemark> loadCities() {
        // In this case we're loading from local assets.
        // NOTE: could alternatively easily load from network.
        // However, that would need to happen on a background thread.
        InputStream stream;
        try {
            stream = getActivity().getAssets().open("cities.json");
        } catch (IOException e) {
            return null;
        }

        Gson gson = new GsonBuilder().create();

        JsonElement json = new JsonParser().parse(new InputStreamReader(stream));

        return gson.fromJson(json, new TypeToken<List<RealmPlacemark>>() {
        }.getType());
    }
}
