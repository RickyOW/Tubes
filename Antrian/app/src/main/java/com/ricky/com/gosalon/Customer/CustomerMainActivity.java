package com.ricky.com.gosalon.Customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.ricky.com.gosalon.Adapter.ClickListener;
import com.ricky.com.gosalon.Adapter.RVAdapterHome;
import com.ricky.com.gosalon.Adapter.RecyclerTouchListener;
import com.ricky.com.gosalon.Model.GetSalon;
import com.ricky.com.gosalon.Model.ResultSalon;
import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.ricky.com.gosalon.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerMainActivity extends AppCompatActivity {
    private RecyclerView rvView;
    private List<GetSalon> dataSet = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
        rvView = (RecyclerView)findViewById(R.id.recyCustHome);
        rvView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvView.setLayoutManager(layoutManager);
//        adapter = new RVAdapterHome(dataSet);
//        rvView.setAdapter(adapter);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultSalon> call = mApiInterface.GetSalon();

        call.enqueue(new Callback<ResultSalon>() {
            @Override
            public void onResponse(Call<ResultSalon> call, Response<ResultSalon> response) {
                dataSet = response.body().getResult();


                adapter = new RVAdapterHome(dataSet);
                rvView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResultSalon> call, Throwable t) {
                Log.e("error",t.toString());
            }
        });


        rvView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rvView, new ClickListener() {
            @Override
            public void onClick(View view, int posi) {
                Intent i = new Intent(getApplicationContext(),CustomerGetSalonActivity.class);
                startActivity(i);

            }

            @Override
            public void onLongClick(View view, int posi) {

            }
        }));


    }

}
