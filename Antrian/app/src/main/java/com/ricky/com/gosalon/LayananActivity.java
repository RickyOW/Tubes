package com.ricky.com.gosalon;

import android.os.Bundle;
import android.os.PersistableBundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ricky.com.gosalon.Adapter.RVPelayanan;
import com.ricky.com.gosalon.Model.JenisPelayanan;


import java.util.ArrayList;

public class LayananActivity extends AppCompatActivity {
    private RecyclerView rvLayanan;
    private ArrayList<JenisPelayanan> dataSetLayanan;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapterLayanan;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layanan);
        dataSetLayanan = new ArrayList<JenisPelayanan>();

        rvLayanan = (RecyclerView) findViewById(R.id.recyLayanan);
        rvLayanan.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);;

        rvLayanan.setLayoutManager(layoutManager);
        adapterLayanan = new RVPelayanan(dataSetLayanan);
        rvLayanan.setAdapter(adapterLayanan);
        initDataset();



    }

    public void initDataset(){
        dataSetLayanan.add(new JenisPelayanan("Cuci Muka","10000","On",R.drawable.ic_scis));
        dataSetLayanan.add(new JenisPelayanan("Rawat Kuku","10000","On",R.drawable.ic_scis));
        dataSetLayanan.add(new JenisPelayanan("Rawat Inap","10000","On",R.drawable.ic_scis));
        dataSetLayanan.add(new JenisPelayanan("Rawat Jalan","10000","On",R.drawable.ic_scis));
    }
}
