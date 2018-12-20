package com.ricky.com.gosalon.Customer;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ricky.com.gosalon.R;


public class CustomerDetailLayananActivity extends AppCompatActivity {
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail_layanan);
        i = getIntent();


        TextView nama = findViewById(R.id.txtCustDtlLayNama);
        nama.setText(i.getStringExtra("nama"));

        TextView deskripsi = findViewById(R.id.txtCustDtlLayDeskripsi);
        deskripsi.setText(i.getStringExtra("deskripsi"));

        TextView harga = findViewById(R.id.txtCustDtlLayHarga);
        harga.setText(i.getStringExtra("harga"));

        ImageView foto = findViewById(R.id.ImgCustDetlayanan);
        Glide.with(getApplicationContext()).load("").into(foto);
    }
}
