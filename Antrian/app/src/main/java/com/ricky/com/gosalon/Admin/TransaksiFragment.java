package com.ricky.com.gosalon.Admin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ricky.com.gosalon.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransaksiFragment extends Fragment {


    public TransaksiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragmenta_admin_transaksi, container, false);
    }

}
