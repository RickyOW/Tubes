package com.ricky.com.gosalon.Customer;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.ricky.com.gosalon.Adapter.RVPelayanan;
import com.ricky.com.gosalon.Model.GetLayanan;
import com.ricky.com.gosalon.Model.Pelayanan;
import com.ricky.com.gosalon.Model.ResultLayanan;
import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.ricky.com.gosalon.Rest.ApiInterface;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerLayananActivity extends AppCompatActivity {
    private RecyclerView rvLayanan;
    private List<GetLayanan> dataSetLayanan;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapterLayanan;
    private ApiInterface mApiInterface;
    Button btGetLayanan;



    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_layanan);
        btGetLayanan = findViewById(R.id.btnCustPesan);
        rvLayanan = (RecyclerView) findViewById(R.id.recyCustLayanan);

        initDataset();

        btGetLayanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CustomerDetailLayananActivity.class);
                startActivity(i);
            }
        });

    }

    public void initDataset(){

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultLayanan> getLayanan = mApiInterface.GetLayanan();
        getLayanan.enqueue(new Callback<ResultLayanan>() {
            @Override
            public void onResponse(Call<ResultLayanan> call, Response<ResultLayanan> response) {
                dataSetLayanan = response.body().getResult();

                layoutManager = new LinearLayoutManager(CustomerLayananActivity.this,LinearLayoutManager.VERTICAL,false);;
                rvLayanan.setLayoutManager(layoutManager);
                adapterLayanan = new RVPelayanan(dataSetLayanan);
                rvLayanan.setAdapter(adapterLayanan);
            }

            @Override
            public void onFailure(Call<ResultLayanan> call, Throwable t) {

            }
        });


    }


}
