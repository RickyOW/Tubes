package com.ricky.com.gosalon;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ricky.com.gosalon.Admin.AdminMainActivity;
import com.ricky.com.gosalon.Customer.CustomerAddData;
import com.ricky.com.gosalon.Customer.CustomerMainActivity;
import com.ricky.com.gosalon.Model.GetCustomer;
import com.ricky.com.gosalon.Customer.PostPutDelCustomer;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.ricky.com.gosalon.Rest.ApiInterface;
import com.ricky.com.gosalon.Session.SeessionManagement;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button btLogin,btDaftar;
    ApiInterface mApiInterface;
    SeessionManagement mSesi;
    RelativeLayout lay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btLogin = findViewById(R.id.btnLogin);
        btDaftar = findViewById(R.id.btnDaftarLogin);
        lay = findViewById(R.id.layLogin);
        final EditText nama_cust = findViewById(R.id.editLoginUsername);
        final EditText password = findViewById(R.id.editLoginPass);
        mSesi = new SeessionManagement(getApplicationContext());
        //lay.setBackgroundColor(Color.rgb(102, 255, 51));

        if (mSesi.isLoggedIn()){
            HashMap<String,String> user = mSesi.getLevelInformation();

            if (user.get(mSesi.KEY_LEVEL).equals("0")){
                Intent i = new Intent(getApplicationContext(),CustomerMainActivity.class);
                startActivity(i);
                finish();
            }else if (user.get(mSesi.KEY_LEVEL).equals("1")) {
                Intent i = new Intent(getApplicationContext(),AdminMainActivity.class);
                startActivity(i);
                finish();
            }
        }

    btLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Call<PostPutDelCustomer> t = mApiInterface.getLogin(nama_cust.getText().toString(),password.getText().toString());
            t.enqueue(new Callback<PostPutDelCustomer>() {
                @Override
                public void onResponse(Call<PostPutDelCustomer> call, Response<PostPutDelCustomer> response) {
                    String status = response.body().getStatus();

                    if (status.equals("Berhasil")) {
                        GetCustomer cstmr = response.body().getCustomer();
                        mSesi.createLoginSession(cstmr.getIdCust(),cstmr.getLevel());

                        if (cstmr.getLevel().equals("0")) {
                            Intent i = new Intent(getApplicationContext(), CustomerMainActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Intent i =new Intent(getApplicationContext(), AdminMainActivity.class);
                            startActivity(i);
                            finish();

                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Fail Login", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<PostPutDelCustomer> call, Throwable t) {

                    Toast.makeText(getApplicationContext(),"error"+t,Toast.LENGTH_SHORT).show();

                }
            });
        }
    });

        btDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CustomerAddData.class);
                startActivity(i);
            }
        });

    }
}
