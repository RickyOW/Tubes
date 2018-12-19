package com.ricky.com.gosalon.Customer;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.ricky.com.gosalon.Rest.ApiInterface;
import com.squareup.picasso.Picasso;

public class CustomerGetSalonActivity extends AppCompatActivity {
    FloatingActionButton btMap;
    TextView btPesan;
    String x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_getsalon);
        btPesan = findViewById(R.id.btnCustPesan);
        btMap = findViewById(R.id.btnCustMap);

        TextView nama = findViewById(R.id.tvDetailNama);
        TextView alamat = findViewById(R.id.tvDetailAlamat);
        ImageView photo = findViewById(R.id.imgDetailSalon);


        final Intent in = getIntent();
        nama.setText(in.getStringExtra("nama"));
        alamat.setText(in.getStringExtra("alamat"));
        Picasso.get().load(ApiClient.IMG+in.getStringExtra("Image")).into(photo);

        Intent i = getIntent();
        nama.setText(i.getStringExtra("nama"));
        alamat.setText(i.getStringExtra("alamat"));
        x = i.getStringExtra("x");
        y = i.getStringExtra("y");
        Picasso.get().load(ApiClient.IMG+i.getStringExtra("Image")).into(photo);


        btPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CustomerLayananActivity.class);
                i.putExtra("id", in.getStringExtra("id"));
                startActivity(i);
            }
        });
        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("x",x);
                i.putExtra("y",y);
                startActivity(i);
            }
        });


    }
}
