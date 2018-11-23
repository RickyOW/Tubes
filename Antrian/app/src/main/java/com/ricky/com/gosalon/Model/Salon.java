package com.ricky.com.gosalon.Model;

public class Salon {
    private String nama;
    int gambar;

    public Salon(String nama, int gambar){
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
