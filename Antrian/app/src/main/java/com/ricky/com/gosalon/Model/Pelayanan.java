package com.ricky.com.gosalon.Model;

public class Pelayanan {
    private String nama;
    private int gambar;
    private String harga;
    private String status;


    public Pelayanan(String nama, String harga, String status, int gambar){
        this.nama = nama;
        this.harga = harga;
        this.status = status;
        this.gambar = gambar;
    }


    public String getNama() {
        return nama;
    }

    public int getGambar() {
        return gambar;
    }

    public String getHarga() {
        return harga;
    }

    public String getStatus() {
        return status;
    }
}
