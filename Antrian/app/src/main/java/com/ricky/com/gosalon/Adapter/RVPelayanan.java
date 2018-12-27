package com.ricky.com.gosalon.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.com.gosalon.Customer.CustomerDetailLayananActivity;
import com.ricky.com.gosalon.Customer.CustomerGetSalonActivity;
import com.ricky.com.gosalon.Model.GetLayanan;
import com.ricky.com.gosalon.Model.Pelayanan;
import com.ricky.com.gosalon.R;

import java.util.ArrayList;
import java.util.List;

public class RVPelayanan extends RecyclerView.Adapter<RVPelayanan.ViewHolder> {

    List<GetLayanan> layanan;
    Context m;

    public RVPelayanan(List<GetLayanan> input,Context m){
        layanan=input;
        this.m= m;
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
        final GetLayanan k = layanan.get(position);

        holder.tvNama.setText(k.getNama());
        holder.tvHarga.setText(k.getHarga());
        holder.tvStatus.setText(k.getStatusLay());
       holder.ivLayanan.setImageResource(R.drawable.ic_scis);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(m,CustomerDetailLayananActivity.class);
                i.putExtra("idlayanan",k.getId_layanan());
                i.putExtra("idsalon",k.getId_salon());
                i.putExtra("namalayanan",k.getNama());
                i.putExtra("deskripsi",k.getDeskripsi());
                i.putExtra("harga",k.getHarga());
                i.putExtra("Image",k.getPhoto());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                m.startActivity(i);
            }
        });
        };





    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return layanan.size();
    }
}
