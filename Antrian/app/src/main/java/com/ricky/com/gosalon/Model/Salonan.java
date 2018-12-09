package com.ricky.com.gosalon.Model;

public class Salonan {
    private String nama;
    int gambar;

    public Salonan(String nama, int gambar){
        this.nama = nama;
        this.gambar = gambar;
    }
    public String getNama() {
        return nama;
    }

    public int getGambar() {
        return gambar;
    }

}
