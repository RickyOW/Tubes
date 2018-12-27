package com.ricky.com.gosalon.Admin;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Session.SeessionManagement;

import java.util.HashMap;


public class AdminProfil extends Fragment {
    Button btnLogout;
    SeessionManagement mSesi;
    HashMap<String,String> user;

    public AdminProfil(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_profil, container, false);

        btnLogout = view.findViewById(R.id.btnAdminLogout);
        mSesi = new SeessionManagement(getContext());
        user = mSesi.getUserInformation();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSesi.logoutUser();
//                finish();
            }
        });
        return view;
    }
}
