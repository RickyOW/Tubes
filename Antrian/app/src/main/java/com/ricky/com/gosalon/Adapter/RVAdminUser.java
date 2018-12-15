package com.ricky.com.gosalon.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.com.gosalon.Model.GetCustomer;
import com.ricky.com.gosalon.Model.GetSalon;
import com.ricky.com.gosalon.R;
import com.ricky.com.gosalon.Rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVAdminUser extends RecyclerView.Adapter<RVAdminUser.ViewHolder>{

    List<GetCustomer> daftarcustomer;
    private Context mContext;

    public RVAdminUser (List<GetCustomer> input, Context mContext){
        daftarcustomer =input;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiapitem
        public TextView TvNama,TvAlamat,TVJenisKelamin;

        public ViewHolder(View v) {
            super(v);
            TvNama = (TextView) v.findViewById(R.id.txt_nama);
            TvAlamat =(TextView) v.findViewById(R.id.txt_alamat);
            TVJenisKelamin=(TextView) v.findViewById(R.id.txt_jenis_kelamin);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // membuat view baru
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_admin_user, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter kelas_card lainnya
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GetCustomer k = daftarcustomer.get(position);
        holder.TvNama.setText(k.getNama());
        holder.TvAlamat.setText(k.getAlamat());
        holder.TVJenisKelamin.setText(k.getJenis_kelamin());


    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return daftarcustomer.size();
    }
}
