package com.ricky.com.gosalon.Model;

import com.google.gson.annotations.SerializedName;

public class GetTranksaksi {
    @SerializedName("id_pesanan")
    private String id_pesanan;
    @SerializedName("id_cust")
    private String id_cut;
    @SerializedName("status")
    private int status;
    @SerializedName("nama_salon")
    private String nama_salon;
    @SerializedName("nama_layanan")
    private String nama_layanan;
    @SerializedName("total")
    private  String total;
    @SerializedName("tanggal")
    private  String tanggal;

    public GetTranksaksi(){
    }
    public GetTranksaksi(String id_pesanan, String id_cut, int status, String nama_salon, String nama_layanan, String total, String tanggal) {
        this.id_pesanan = id_pesanan;
        this.id_cut = id_cut;
        this.status = status;
        this.nama_salon = nama_salon;
        this.nama_layanan = nama_layanan;
        this.total = total;
        this.tanggal = tanggal;
    }

    public String getId_pesanan() {
        return id_pesanan;
    }

    public void setId_pesanan(String id_pesanan) {
        this.id_pesanan = id_pesanan;
    }

    public String getId_cut() {
        return id_cut;
    }

    public void setId_cut(String id_cut) {
        this.id_cut = id_cut;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNama_salon() {
        return nama_salon;
    }

    public void setNama_salon(String nama_salon) {
        this.nama_salon = nama_salon;
    }

    public String getNama_layanan() {
        return nama_layanan;
    }

    public void setNama_layanan(String nama_layanan) {
        this.nama_layanan = nama_layanan;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
