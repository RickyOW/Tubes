package com.ricky.com.antrian;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<JenisSalon> show;

    public RecyclerViewAdapter (ArrayList<JenisSalon> input){
        show=input;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiapitem
        public TextView tvNama;
        public ImageView img;

        public ViewHolder(View v) {
            super(v);
            tvNama = (TextView) v.findViewById(R.id.txNama);
            img =(ImageView) v.findViewById(R.id.imgHome);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // membuat view baru
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu,
                        parent, false);
        // mengeset ukuran view, margin, padding, dan parameter kelas_card lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        JenisSalon k = show.get(position);
        holder.tvNama.setText(k.getNama());
        holder.img.setImageResource(k.getGambar());


    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return show.size();
    }
}
