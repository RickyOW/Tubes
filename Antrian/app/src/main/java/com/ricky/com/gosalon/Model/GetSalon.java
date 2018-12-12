package com.ricky.com.gosalon.Model;

import com.google.gson.annotations.SerializedName;

public class GetSalon {
    @SerializedName("id_salon")
    private String id_salon;
    @SerializedName("nama_salon")
    private String nama_salon;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("koordinat_x")
    private String koorx;
    @SerializedName("koordinat_y")
    private String koory;
    @SerializedName("photo")
    private String photo;


    public GetSalon() {

    }

    public String getId_salon() {
        return id_salon;
    }

    public void setId_salon(String id_salon) {
        this.id_salon = id_salon;
    }

    public String getNama_salon() {
        return nama_salon;
    }

    public void setNama_salon(String nama_salon) {
        this.nama_salon = nama_salon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKoorx() {
        return koorx;
    }

    public void setKoorx(String koorx) {
        this.koorx = koorx;
    }

    public String getKoory() {
        return koory;
    }

    public void setKoory(String koory) {
        this.koory = koory;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}