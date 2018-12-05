package com.ricky.com.gosalon.Customer;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.ricky.com.gosalon.Adapter.RVPelayanan;
import com.ricky.com.gosalon.Model.JenisPelayanan;
import com.ricky.com.gosalon.R;


import java.util.ArrayList;

public class CustomerLayananActivity extends AppCompatActivity {
    private RecyclerView rvLayanan;
    private ArrayList<JenisPelayanan> dataSetLayanan;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapterLayanan;
    Button btGetLayanan;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_layanan);
        dataSetLayanan = new ArrayList<JenisPelayanan>();
        btGetLayanan = findViewById(R.id.btnGetLayanan);
        rvLayanan = (RecyclerView) findViewById(R.id.recyLayanan);

        rvLayanan.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);;

        rvLayanan.setLayoutManager(layoutManager);
        adapterLayanan = new RVPelayanan(dataSetLayanan);
        rvLayanan.setAdapter(adapterLayanan);
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
        dataSetLayanan.add(new JenisPelayanan("Cuci Muka","10000","On",R.drawable.ic_scis));
        dataSetLayanan.add(new JenisPelayanan("Rawat Kuku","10000","On",R.drawable.ic_scis));
        dataSetLayanan.add(new JenisPelayanan("Rawat Inap","10000","On",R.drawable.ic_scis));
        dataSetLayanan.add(new JenisPelayanan("Rawat Jalan","10000","On",R.drawable.ic_scis));
    }
}
