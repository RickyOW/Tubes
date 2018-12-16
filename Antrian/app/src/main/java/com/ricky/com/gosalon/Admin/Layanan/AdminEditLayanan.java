package com.ricky.com.gosalon.Admin.Layanan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ricky.com.gosalon.Model.ResultLayanan;
import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.ricky.com.gosalon.Rest.ApiInterface;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminEditLayanan extends AppCompatActivity {
    TextView tvEditMessage, tvIdLay, tvNamaLay,tvDeskripLay, tvHargaLay, tvStatusLay, tvId_salon;
    ImageView imgLay;
    Button btnDelLay, btnAddImg;
    String imagePath = "";
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit_layanan);
        tvIdLay = findViewById(R.id.txtAdminEditIdLayanan);
        tvNamaLay = findViewById(R.id.txtAdminEditNamaLayanan);
        tvDeskripLay = findViewById(R.id.txtAdminEditDeskripsiLayanan);
        tvHargaLay = findViewById(R.id.txtAdminEditHargaLayanan);
        tvStatusLay = findViewById(R.id.txtAdminEditStatusLayanan);
        tvEditMessage = findViewById(R.id.txtAdminMessageEdit);
        imgLay = findViewById(R.id.imgAdminEditLayanan);
        btnDelLay = findViewById(R.id.btnAdminHapusLayanan);

        Intent mIntent = getIntent();
        tvIdLay.setText(mIntent.getStringExtra("id_layanan"));
        tvNamaLay.setText(mIntent.getStringExtra("nama_layanan"));
        tvDeskripLay.setText(mIntent.getStringExtra("deskripsi"));
        tvHargaLay.setText(mIntent.getStringExtra("harga"));
        tvStatusLay.setText(mIntent.getStringExtra("status"));
        imagePath = mIntent.getStringExtra("photo");
        if (imagePath.length()>0){
            Glide.with(mContext).load(ApiClient.IMGLayanan + imagePath).into(imgLay);
        }
        else{
            Glide.with(mContext).load(R.drawable.ic_spa_black).into(imgLay);
        }

        setListener();

    }
    private void setListener() {
        final ApiInterface mApiInterface =  ApiClient.getClient().create(ApiInterface.class);
        btnDelLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody reqIdLayanan =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (tvIdLay.getText().toString().isEmpty()==true)?"":tvIdLay.getText().toString());
                RequestBody reqAction =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),"delete");
                Call<ResultLayanan> callDelete = mApiInterface.deleteLayanan(reqIdLayanan,reqAction);
                callDelete.enqueue(new Callback<ResultLayanan>() {
                    @Override
                    public void onResponse(Call<ResultLayanan> call,
                                           Response<ResultLayanan> response)
                    { tvEditMessage.setText("Retrofit Delete \n Status = "+response.body().getStatus() +"\n"+ "Message = "+response.body().getMessage()+"\n");
                    }
                    @Override
                    public void onFailure(Call<ResultLayanan> call, Throwable t) {
                        tvEditMessage.setText("Retrofit Delete \n Status = "+ t.getMessage());
                    }
                });
            }
        });
    }
}
