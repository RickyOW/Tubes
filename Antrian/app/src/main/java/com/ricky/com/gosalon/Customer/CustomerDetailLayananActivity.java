package com.ricky.com.gosalon.Customer;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ricky.com.gosalon.Model.PostPutDelTranksaksi;
import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.ricky.com.gosalon.Rest.ApiInterface;
import com.ricky.com.gosalon.Session.SeessionManagement;

import java.util.HashMap;

import retrofit2.Call;


public class CustomerDetailLayananActivity extends AppCompatActivity {
    Intent i;
    Button btKonfir;
    HashMap<String,String> user;
    SeessionManagement mSesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail_layanan);
        btKonfir = findViewById(R.id.btnCustDtlKonfirmasiPesan);
        mSesi = new SeessionManagement(getApplicationContext());
        user = mSesi.getUserInformation();
        i = getIntent();

        final String salon = i.getStringExtra("idsalon");
        //i.putExtra("idsalon",salon);
        final String layanan = i.getStringExtra("namalayanan");
        String idlayanan = i.getStringExtra("idlayanan");
        String deskripsi = i.getStringExtra("deskripsi");
        final String harga = i.getStringExtra("harga");


        TextView nama = findViewById(R.id.txtCustDtlLayNama);
        nama.setText(layanan);

        TextView tvdeskripsi = findViewById(R.id.txtCustDtlLayDeskripsi);
        tvdeskripsi.setText(deskripsi);

        TextView tvharga = findViewById(R.id.txtCustDtlLayHarga);
        tvharga.setText(harga);

        ImageView foto = findViewById(R.id.ImgCustDetlayanan);
        Glide.with(getApplicationContext()).load("").into(foto);
        btKonfir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<PostPutDelTranksaksi> tran = mApiInterface.postTranksaksi(user.get(SeessionManagement.KEY_ID),
                        1,
                        salon,
                        layanan,
                        harga);
            }
        });
    }
}
