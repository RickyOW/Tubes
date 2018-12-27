package com.ricky.com.gosalon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ricky.com.gosalon.Admin.Layanan.AdminEditLayanan;
import com.ricky.com.gosalon.Model.GetLayanan;
import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;

import java.util.List;

public class RVAdminLayanan extends RecyclerView.Adapter<RVAdminLayanan.ViewHolder> {
    List<GetLayanan> layanan;
    private Context mCon;

    public RVAdminLayanan(List<GetLayanan> input, Context con){
        layanan =input;
        mCon = con;
    }

    public RVAdminLayanan() {

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiapitem
        public TextView tvNama, tvHarga, tvStatus;
        public ImageView ivLayanan;

        public ViewHolder(View v) {
            super(v);
            tvNama = (TextView) v.findViewById(R.id.txtAdminNamaLayanan);
            tvHarga = v.findViewById(R.id.txtAdminHargaLayanan);
            tvStatus = v.findViewById(R.id.txtAdminStatusLayanan);
            ivLayanan =(ImageView) v.findViewById(R.id.imgLayananAdmin);
        }
    }



    @Override
    public RVAdminLayanan.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // membuat view baru
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layanan_admin, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter kelas_card lainnya
        RVAdminLayanan.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        GetLayanan k = layanan.get(position);
        holder.tvNama.setText(k.getNama());
        holder.tvHarga.setText(k.getHarga());
        holder.tvStatus.setText(k.getStatusLay());
        if (k.getPhoto().length()>0){
            Glide.with(holder.itemView.getContext()).load(ApiClient.BASE_upload+layanan.get(position).getPhoto()).into(holder.ivLayanan);
            //Glide.with(holder.itemView.getContext()).load(ApiClient.BASE_upload+listPembeli.get(position).getPhotoId()).into(holder.mPhotoid);

        }else{
            Glide.with(holder.itemView.getContext()).load(R.drawable.ic_spa_black).into(holder.ivLayanan);
            //Glide.with(holder.itemView.getContext()).load(R.drawable.ic_launcher_background).into(holder.mPhotoid);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),AdminEditLayanan.class);
                intent.putExtra("id_layanan",layanan.get(position).getId_layanan());
                intent.putExtra("id_salon",layanan.get(position).getId_salon());
                intent.putExtra("nama_layanan",layanan.get(position).getNama());
                intent.putExtra("deskripsi",layanan.get(position).getDeskripsi());
                intent.putExtra("harga",layanan.get(position).getHarga());
                intent.putExtra("status",layanan.get(position).getStatusLay());
                intent.putExtra("photo", layanan.get(position).getPhoto());
                view.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return layanan.size();
    }

}
