package com.ricky.com.gosalon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ricky.com.gosalon.Adapter.RVAdapterHome;
import com.ricky.com.gosalon.Model.JenisSalon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvView;
    private ArrayList<JenisSalon> dataSet;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);dataSet = new ArrayList<JenisSalon>();
        initDataset();
        rvView = (RecyclerView) findViewById(R.id.recy);
        rvView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvView.setLayoutManager(layoutManager);
        adapter = new RVAdapterHome(dataSet);
        rvView.setAdapter(adapter);


    }

    private void initDataset(){
        dataSet.add(new JenisSalon("Rawat ",R.drawable.ic_scis));
        dataSet.add(new JenisSalon("Rawat2 ",R.drawable.ic_scis));
        dataSet.add(new JenisSalon("Rawat3",R.drawable.ic_scis));
        dataSet.add(new JenisSalon("Rawat4 ",R.drawable.ic_scis));
        dataSet.add(new JenisSalon("Rawat5 ",R.drawable.ic_scis));
        dataSet.add(new JenisSalon("Rawat6 ",R.drawable.ic_scis));
        dataSet.add(new JenisSalon("Rawat7 ",R.drawable.ic_scis));


    }
}
