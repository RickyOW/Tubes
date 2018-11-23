package com.ricky.com.gosalon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ricky.com.gosalon.Adapter.ClickListener;
import com.ricky.com.gosalon.Adapter.RVAdapterHome;
import com.ricky.com.gosalon.Adapter.RecyclerTouchListener;
import com.ricky.com.gosalon.Model.Salon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvView;
    private ArrayList<Salon> dataSet;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dataSet = new ArrayList<Salon>();
        initDataset();
        rvView = (RecyclerView) findViewById(R.id.recy);
        rvView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvView.setLayoutManager(layoutManager);
        adapter = new RVAdapterHome(dataSet);
        rvView.setAdapter(adapter);

        rvView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rvView, new ClickListener() {
            @Override
            public void onClick(View view, int posi) {
                Salon s = dataSet.get(posi);
                Intent i = new Intent(getApplicationContext(),LayananActivity.class);
                startActivity(i);

            }

            @Override
            public void onLongClick(View view, int posi) {

            }
        }));


    }

    private void initDataset(){
        dataSet.add(new Salon("Rawat ",R.drawable.ic_scis));
        dataSet.add(new Salon("Rawat2 ",R.drawable.ic_scis));
        dataSet.add(new Salon("Rawat3",R.drawable.ic_scis));
        dataSet.add(new Salon("Rawat4 ",R.drawable.ic_scis));
        dataSet.add(new Salon("Rawat5 ",R.drawable.ic_scis));
        dataSet.add(new Salon("Rawat6 ",R.drawable.ic_scis));
        dataSet.add(new Salon("Rawat7 ",R.drawable.ic_scis));


    }
}
