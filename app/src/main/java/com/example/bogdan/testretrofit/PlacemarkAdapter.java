package com.example.bogdan.testretrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

public class PlacemarkAdapter extends RecyclerView.Adapter<PlacemarkAdapter.ViewHolder> {

    private ArrayList<Placemark> placemarkList;
    private Context context;
    private List<RealmPlacemark> realmPlacemarkList;

    public PlacemarkAdapter(ArrayList<Placemark> placemarkList, Context context, List<RealmPlacemark> realmPlacemarkList) {
        this.placemarkList = placemarkList;
        this.context = context;
        this.realmPlacemarkList = realmPlacemarkList;
    }

    public PlacemarkAdapter(Context context, RealmResults<RealmPlacemark> realmPlacemarks) {
        this.context =context;
        this.realmPlacemarkList = realmPlacemarks;
    }

    public void setData(List<RealmPlacemark> details) {
        if (details == null) {
            details = Collections.emptyList();
        }
        this.realmPlacemarkList = details;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlacemarkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.rv_part, viewGroup, false);
        return new PlacemarkAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacemarkAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tvName.setText(realmPlacemarkList.get(i).getName());
        viewHolder.tvAddress.setText(placemarkList.get(i).getAddress());

        viewHolder.tvExterior.setText(String.valueOf(placemarkList.get(i).getLatitude()));
        viewHolder.tvInterior.setText(String.valueOf(placemarkList.get(i).getLongitude()));

        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment carMapFragment = CarMapFragment.newInstance();
                FragmentTransaction fragmentTransaction = ((MainActivity)context).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment, carMapFragment);
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return placemarkList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvAddress) TextView tvAddress;
        @BindView(R.id.tvName) TextView tvName;
        @BindView(R.id.tvVin) TextView tvVin;
        @BindView(R.id.tvExterior) TextView tvExterior;
        @BindView(R.id.tvInterior) TextView tvInterior;
        @BindView(R.id.tvEngineType) TextView tvEngineType;
        @BindView(R.id.tvFuel) TextView tvFuel;
        @BindView(R.id.rvConLay) ConstraintLayout cv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
