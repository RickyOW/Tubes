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
    private  String koorx;
    @SerializedName("koordinat_y")
    private String koory;

    public GetSalon() {

    }

    public GetSalon(String id_salon, String nama_salon, String alamat, String koorx, String koory) {
        this.id_salon = id_salon;
        this.nama_salon = nama_salon;
        this.alamat = alamat;
        this.koorx = koorx;
        this.koory = koory;
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
}
