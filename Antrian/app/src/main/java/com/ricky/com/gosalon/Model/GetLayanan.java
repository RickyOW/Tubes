package com.ricky.com.gosalon.Model;

import com.google.gson.annotations.SerializedName;

public class GetLayanan {
    @SerializedName("id_layanan")
    private String id_layanan;
    @SerializedName("id_salon")
    private String id_salon;
    @SerializedName("nama_layanan")
    private String nama;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("harga")
    private String harga;
    @SerializedName("status")
    private  String statusLay;
    @SerializedName("photo")
    private  String photo;

    public String getId_layanan() {
        return id_layanan;
    }

    public void setId_layanan(String id_layanan) {
        this.id_layanan = id_layanan;
    }

    public String getId_salon() {
        return id_salon;
    }

    public void setId_salon(String id_salon) {
        this.id_salon = id_salon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStatusLay() {
        return statusLay;
    }

    public void setStatusLay(String statusLay) {
        this.statusLay = statusLay;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
