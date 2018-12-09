package com.ricky.com.gosalon.Customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ricky.com.gosalon.R;

public class CustomerGetSalonActivity extends AppCompatActivity {
    Button btPesan,btMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_getsalon);
        btPesan = findViewById(R.id.btnCustPesan);
        btMap = findViewById(R.id.btnCustMap);

        btPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CustomerLayananActivity.class);
                startActivity(i);
            }
        });
        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),CustomerMapActivity.class);
                startActivity(i);
            }
        });


    }
}