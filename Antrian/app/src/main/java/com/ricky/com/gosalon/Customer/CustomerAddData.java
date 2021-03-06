package com.ricky.com.gosalon.Customer;

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
import com.ricky.com.gosalon.LoginActivity;
import com.ricky.com.gosalon.Model.ResultCustomer;
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

public class CustomerAddData extends AppCompatActivity {
    Context mContext;
    ImageView mImageView;
    Button btAddPhoto, btAddBack, btAddData;
    EditText edtPassword, edtAddNamaCustomer, edtAddAlamatCustomer;
    EditText edtAddJnsKel;
    TextView tvAddMessage;
    String imagePath = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_daftar);
        mContext = getApplicationContext();
        mImageView = (ImageView) findViewById(R.id.ImgCustDaftar);
        btAddPhoto = (Button) findViewById(R.id.btnCustTmbhImgDaftar);
        edtPassword = (EditText) findViewById(R.id.editCustDaftarPass);
        edtAddNamaCustomer = (EditText) findViewById(R.id.editCustDaftarUsername);
        edtAddAlamatCustomer = (EditText) findViewById(R.id.editCustDaftarAlamat);
        edtAddJnsKel = (EditText) findViewById(R.id.editCustJenisKelamin);
        btAddData = (Button) findViewById(R.id.btnCustTmbhDaftar);
        btAddBack = (Button) findViewById(R.id.btnCustCancelDaftar);
        tvAddMessage = (TextView) findViewById(R.id.txtMessage);
        btAddData.setOnClickListener(new View.OnClickListener() {
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
                RequestBody reqNama = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddNamaCustomer.getText().toString().isEmpty())?"":edtAddNamaCustomer.getText().toString());
                RequestBody reqAlamat = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddNamaCustomer.getText().toString().isEmpty())?"":edtAddAlamatCustomer.getText().toString());
                RequestBody reqJnsKel = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddNamaCustomer.getText().toString().isEmpty())?"":edtAddJnsKel.getText().toString());
                RequestBody reqPass= MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtPassword.getText().toString().isEmpty()==true)?"":edtPassword.getText().toString());
                RequestBody reqAction = MultipartBody.create(MediaType.parse("multipart/form-data"), "post");
                Call<ResultCustomer> mCustomerCall = mApiInterface.postCustomer(body, reqNama, reqAlamat, reqJnsKel, reqPass, reqAction );

                mCustomerCall.enqueue(new Callback<ResultCustomer>() {
                    @Override
                    public void onResponse(Call<ResultCustomer> call, Response<ResultCustomer> response) {
//                     Log.d("Insert Retrofit",response.body().getStatus());
                        if (response.body().getStatus().equals("failed")){
                            tvAddMessage.setText("Retrofit Update1 \n Status = "+response.body().getStatus() +"\n"+ "Message ="+response.body().getMessage()+"\n");
                        }else{
                            String detail = "\n"+
                                    "nama = "+response.body().getResult().get(0).getNama()
                                    +"\n"+ "alamat = "+response.body().getResult().get(0).getAlamat()
                                    +"\n"+ "jenis_kelamin = "+response.body().getResult().get(0).getJenis_kelamin()
                                    +"\n"+ "photo = "+response.body().getResult().get(0).getPhoto()
                                    +"\n"+ "password = "+response.body().getResult().get(0).getPass()
                                    +"\n";tvAddMessage.setText("Retrofit Update \n Status = "+response.body().getStatus()
                                    +"\n"+ "Message = "+response.body().getMessage()+detail);
                        }
                    }
                    @Override
                    public void onFailure(Call<ResultCustomer> call, Throwable t) {
// Log.d("Insert Retrofit", t.getMessage());
                        //tvAddMessage.setText("Retrofit Update \n Status = "+ t.getMessage());
                    }
                });
            }
        });
        btAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_PICK);
                Intent intentChoose = Intent.createChooser(galleryIntent, "Pilih Gambar Untuk Di upload");
                startActivityForResult(intentChoose, 10);
            }
        });
        btAddBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
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
                Glide.with(mContext).load(new File(imagePath)).into(mImageView);
                cursor.close();
            }else{
                Toast.makeText(mContext, "Gambar Gagal Di load", Toast.LENGTH_LONG).show();
            }
        }
    }
}