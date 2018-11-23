package com.ricky.com.gosalon.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.com.gosalon.Model.JenisPelayanan;
import com.ricky.com.gosalon.Model.Salon;
import com.ricky.com.gosalon.R;

import java.util.ArrayList;

public class RVPelayanan extends RecyclerView.Adapter<RVPelayanan.ViewHolder> {

    ArrayList<JenisPelayanan> layanan;

    public RVPelayanan(ArrayList<JenisPelayanan> input){
        layanan=input;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiapitem
        public TextView tvNama,tvHarga,tvStatus;
        public ImageView ivLayanan;

        public ViewHolder(View v) {
            super(v);
            tvNama = (TextView) v.findViewById(R.id.txtNamaLayanan);
            tvHarga = v.findViewById(R.id.txtHarga);
            tvStatus = v.findViewById(R.id.txtStatus);
            ivLayanan =(ImageView) v.findViewById(R.id.imgLayanan);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // membuat view baru
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layanan,
                        parent, false);
        // mengeset ukuran view, margin, padding, dan parameter kelas_card lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RVPelayanan.ViewHolder holder, int position) {
        JenisPelayanan k = layanan.get(position);
        holder.tvNama.setText(k.getNama());
        holder.tvHarga.setText(k.getHarga());
        holder.tvStatus.setText(k.getStatus());
        holder.ivLayanan.setImageResource(k.getGambar());


    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return layanan.size();
    }
}
