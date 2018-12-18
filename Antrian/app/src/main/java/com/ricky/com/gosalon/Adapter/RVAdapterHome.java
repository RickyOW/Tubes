package com.ricky.com.gosalon.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.com.gosalon.Customer.CustomerGetSalonActivity;
import com.ricky.com.gosalon.Model.GetSalon;
import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVAdapterHome extends RecyclerView.Adapter<RVAdapterHome.ViewHolder> {

    List<GetSalon> salonan;
    private Context mContext;

    public RVAdapterHome(List<GetSalon> salonan, Context mContext) {
        this.salonan = salonan;
        this.mContext = mContext;
    }

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
        final GetSalon k = salonan.get(position);
        holder.tvNama.setText(k.getNama_salon());
        Picasso.get().load(ApiClient.IMG+salonan.get(position).getPhoto()).into(holder.ivHome);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext,CustomerGetSalonActivity.class);
                i.putExtra("nama",k.getNama_salon());
                i.putExtra("alamat",k.getAlamat());
                i.putExtra("Image",k.getPhoto());
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return salonan.size();
    }
}
