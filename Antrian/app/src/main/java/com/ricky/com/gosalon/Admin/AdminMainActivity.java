package com.ricky.com.gosalon.Admin;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.ricky.com.gosalon.R;

public class AdminMainActivity extends AppCompatActivity {

    //private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_user_admin:
                    UserFragment userFragment = new UserFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container_admin, userFragment);
                    fragmentTransaction.commit();
                    return true;

                case R.id.nav_salon_admin:
                    SalonFragment salonFragment = new SalonFragment();
                    FragmentTransaction fragmentSalonTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentSalonTransaction.replace(R.id.fragment_container_admin, salonFragment);
                    fragmentSalonTransaction.commit();
                    return true;

                case R.id.nav_transaksi_admin:
                    TransaksiFragment transaksiFragment = new TransaksiFragment();
                    FragmentTransaction fragmentTransaksiTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaksiTransaction.replace(R.id.fragment_container_admin, transaksiFragment);
                    fragmentTransaksiTransaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        UserFragment userFragment = new UserFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_admin,userFragment);
        fragmentTransaction.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
