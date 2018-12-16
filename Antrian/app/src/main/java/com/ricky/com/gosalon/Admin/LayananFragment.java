package com.ricky.com.gosalon.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ricky.com.gosalon.Adapter.RVAdminLayanan;
import com.ricky.com.gosalon.Admin.Layanan.AdminAddlayananActivity;
import com.ricky.com.gosalon.Model.GetLayanan;
import com.ricky.com.gosalon.Model.ResultLayanan;
import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.ricky.com.gosalon.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayananFragment extends Fragment {
    private Button btnAdd;
    private RecyclerView rv;
    private RVAdminLayanan mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<GetLayanan> dataLayanan;
    private ApiInterface mApiInterface;


    public LayananFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_layanan_admin, container, false);

        rv = (RecyclerView) view.findViewById(R.id.recy_lay_admin);
        rv.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);
        btnAdd = view.findViewById(R.id.btnAdminNewLayanan);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AdminAddlayananActivity.class);
                startActivity(i);
            }
        });

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultLayanan> getLayanan = mApiInterface.GetLayanan();
        getLayanan.enqueue(new Callback<ResultLayanan>() {
            @Override
            public void onResponse(Call<ResultLayanan> call, Response<ResultLayanan> response) {
                dataLayanan = response.body().getResult();
                mAdapter = new RVAdminLayanan(dataLayanan,getContext());
                rv.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResultLayanan> call, Throwable t) {

            }
        });

        return view;

    }


}
