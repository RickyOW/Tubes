package com.ricky.com.gosalon.Adapter;

import android.content.Context;
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

public class RVAdminSalon extends RecyclerView.Adapter<RVAdminSalon.ViewHolder> {
    List<GetSalon> datasalon;
    private Context mContext;

    public RVAdminSalon(List<GetSalon> input, Context mContext){
        datasalon =input;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiapitem
        public TextView tvNama;
        public ImageView ivHome;

        public ViewHolder(View v) {
            super(v);
            tvNama = (TextView) v.findViewById(R.id.txtTempatAdmin);
            ivHome =(ImageView) v.findViewById(R.id.imgSalonAdmin);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // membuat view baru
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_admin_salon, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter kelas_card lainnya
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GetSalon k = datasalon.get(position);
        holder.tvNama.setText(k.getNama_salon());
        Picasso.get().load(ApiClient.IMG+datasalon.get(position).getPhoto()).into(holder.ivHome);


    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return datasalon.size();
    }
}
