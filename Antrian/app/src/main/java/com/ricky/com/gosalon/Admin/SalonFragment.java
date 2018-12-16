package com.ricky.com.gosalon.Admin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ricky.com.gosalon.Adapter.RVAdminSalon;
import com.ricky.com.gosalon.Adapter.RVAdminUser;
import com.ricky.com.gosalon.Model.GetCustomer;
import com.ricky.com.gosalon.Model.GetSalon;
import com.ricky.com.gosalon.Model.ResultSalon;
import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.ricky.com.gosalon.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalonFragment extends Fragment {
    private RecyclerView rv;
    private RVAdminSalon mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<GetSalon> dataSalon;
    private ApiInterface mApiInterface;


    public SalonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_salon, container, false);

        rv = (RecyclerView) view.findViewById(R.id.fragmen_admin_salon);
        rv.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getContext(),2);
        rv.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultSalon> getSalon = mApiInterface.GetSalon();
        getSalon.enqueue(new Callback<ResultSalon>() {
            @Override
            public void onResponse(Call<ResultSalon> call, Response<ResultSalon> response) {
                dataSalon = response.body().getResult();
                mAdapter = new RVAdminSalon(dataSalon,getContext());
                rv.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResultSalon> call, Throwable t) {

            }
        });

        return view;
    }

}
