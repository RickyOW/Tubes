package com.ricky.com.gosalon.Admin.Layanan;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ricky.com.gosalon.Model.ResultLayanan;
import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.ricky.com.gosalon.Rest.ApiInterface;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminAddlayananActivity extends AppCompatActivity {
    EditText edIdSalonlay, edNamaLay,edDeskripLay, edHargaLay, edStatusLay;
    ImageView imgLay;
    Button btnAddLay, btnAddImg;
    String imagePath = "";
    Context mContext;
    TextView tvAddMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_addlayanan);
        mContext = getApplicationContext();
        edIdSalonlay = findViewById(R.id.editAdminAddIdSalon);
        edNamaLay = findViewById(R.id.editAdminAddNamaLayanan);
        edDeskripLay = findViewById(R.id.editAdminAddDeskripsi);
        edHargaLay = findViewById(R.id.editAdminAddHarga);
        edStatusLay = findViewById(R.id.editAdminAddStatus);
        tvAddMessage = (TextView) findViewById(R.id.txtAdminMessageAddLayanan);
        imgLay = findViewById(R.id.imgAdminAddlayanan);
        btnAddLay = findViewById(R.id.btnAdminAddlayanan);
        btnAddImg  = findViewById(R.id.btnAdminAddImgLayanan);

        btnAddLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                MultipartBody.Part body = null;
                if (!imagePath.isEmpty()){
//File creating from selected URL
                    File file = new File(imagePath);
// create RequestBody instance from file
                    RequestBody requestFile =  RequestBody.create(MediaType.parse("multipart/form-data"), file);
// MultipartBody.Part is used to send also the actual file name
                    body = MultipartBody.Part.createFormData("photo", file.getName(), requestFile);
                }
                RequestBody reqIdSalon = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edIdSalonlay.getText().toString().isEmpty())?"":edIdSalonlay.getText().toString());
                RequestBody reqNama = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edNamaLay.getText().toString().isEmpty())?"":edNamaLay.getText().toString());
                RequestBody reqDeskripsi = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edNamaLay.getText().toString().isEmpty())?"":edDeskripLay.getText().toString());
                RequestBody reqHarga = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edNamaLay.getText().toString().isEmpty())?"":edHargaLay.getText().toString());
                RequestBody reqStatus= MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edNamaLay.getText().toString().isEmpty()==true)?"":edStatusLay.getText().toString());
                RequestBody reqAction = MultipartBody.create(MediaType.parse("multipart/form-data"), "post");
                Call<ResultLayanan> mLayananCall = mApiInterface.postLayanan(body, reqIdSalon, reqNama, reqDeskripsi, reqHarga, reqStatus, reqAction );

                mLayananCall.enqueue(new Callback<ResultLayanan>() {
                    @Override
                    public void onResponse(Call<ResultLayanan> call, Response<ResultLayanan> response) {
//                     Log.d("Insert Retrofit",response.body().getStatus());
                        if (response.body().getStatus().equals("failed")){
                            tvAddMessage.setText("Retrofit Update1 \n Status = "+response.body().getStatus() +"\n"+ "Message ="+response.body().getMessage()+"\n");
                        }else{
                            String detail = "\n"+
                                    "nama = "+response.body().getResult().get(0).getNama()
                                    +"\n"+ "deskripsi = "+response.body().getResult().get(0).getDeskripsi()
                                    +"\n"+ "harga = "+response.body().getResult().get(0).getHarga()
                                    +"\n"+ "photo = "+response.body().getResult().get(0).getPhoto()
                                    +"\n"+ "status = "+response.body().getResult().get(0).getStatusLay()
                                    +"\n";tvAddMessage.setText("Retrofit Update \n Status = "+response.body().getStatus()
                                    +"\n"+ "Message = "+response.body().getMessage()+detail);
                        }
                    }
                    @Override
                    public void onFailure(Call<ResultLayanan> call, Throwable t) {
// Log.d("Insert Retrofit", t.getMessage());
                        tvAddMessage.setText("Retrofit Update \n Status = "+ t.getMessage());
                    }
                });
            }
        });

        btnAddImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_PICK);
                Intent intentChoose = Intent.createChooser(galleryIntent, "Pilih Gambar Untuk Di upload");
                startActivityForResult(intentChoose, 10);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode ==10){
            if (data==null){
                Toast.makeText(mContext, "Gambar Gagal Di load", Toast.LENGTH_LONG).show();
                return;
            }
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imagePath =cursor.getString(columnIndex);
                //Picasso.with(mContext).load(new File(imagePath)).fit().into(mImageView);
                Glide.with(mContext).load(new File(imagePath)).into(imgLay);
                cursor.close();
            }else{
                Toast.makeText(mContext, "Gambar Gagal Di load", Toast.LENGTH_LONG).show();
            }
        }
    }
}


