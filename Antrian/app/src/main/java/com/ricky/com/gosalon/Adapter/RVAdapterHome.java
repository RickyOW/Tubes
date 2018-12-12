package com.ricky.com.gosalon.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.com.gosalon.Model.GetSalon;
import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVAdapterHome extends RecyclerView.Adapter<RVAdapterHome.ViewHolder> {

    List<GetSalon> salonan;

    public RVAdapterHome(List<GetSalon> input){
        salonan =input;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiapitem
        public TextView tvNama;
        public ImageView ivHome;

        public ViewHolder(View v) {
            super(v);
            tvNama = (TextView) v.findViewById(R.id.txtTempat);
            ivHome =(ImageView) v.findViewById(R.id.imgHome);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // membuat view baru
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter kelas_card lainnya
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GetSalon k = salonan.get(position);
        holder.tvNama.setText(k.getNama_salon());
        Picasso.get().load(ApiClient.IMG+salonan.get(position).getPhoto()).into(holder.ivHome);


    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return salonan.size();
    }
}
