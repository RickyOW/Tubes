package com.ricky.com.gosalon.Admin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ricky.com.gosalon.Adapter.RVAdminUser;
import com.ricky.com.gosalon.Model.GetCustomer;
import com.ricky.com.gosalon.Model.ResultCustomer;
import com.ricky.com.gosalon.Model.SalonReponse;
import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.ricky.com.gosalon.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {
    private RecyclerView rv;
    private RVAdminUser mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List <GetCustomer> dataCustomer;
    private ApiInterface mApiInterface;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_user, container, false);
        rv = (RecyclerView) view.findViewById(R.id.RvFragmantUser);
        rv.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultCustomer> getCustomer = mApiInterface.getCustomer();
        getCustomer.enqueue(new Callback<ResultCustomer>() {

            @Override
            public void onResponse(Call<ResultCustomer> call, Response<ResultCustomer> response) {
                dataCustomer = response.body().getResult();
                mAdapter =  new RVAdminUser(dataCustomer,getContext());
                rv.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ResultCustomer> call, Throwable t) {

            }
        });

        return view;
    }

}
