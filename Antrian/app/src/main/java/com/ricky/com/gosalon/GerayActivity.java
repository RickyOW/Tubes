package com.ricky.com.gosalon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GerayActivity extends AppCompatActivity {
    Button btPesan,btMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geray);
        btPesan = findViewById(R.id.btnPesan);
        btMap = findViewById(R.id.btnMap);

        btPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LayananActivity.class);
                startActivity(i);
            }
        });
        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(),);
//                startActivity(i);
            }
        });


    }
}
