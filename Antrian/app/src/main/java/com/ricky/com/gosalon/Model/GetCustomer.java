package com.ricky.com.gosalon.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alhamdulillah on 11/2/16.
 */
public class GetCustomer {
//    @SerializedName("id_cust")
//    private String idCust;

    @SerializedName("nama_cust")
    private String nama;

    @SerializedName("alamat")
    private String alamat;

    @SerializedName("jenis_kelamin")
    private String jenis_kelamin;

    @SerializedName("photo")
    private String photo;

    @SerializedName("password")
    private String pass;

    @SerializedName("level")
    private String level;

    private String action;

    public GetCustomer() {}


    public GetCustomer(String nama, String alamat, String photo, String jenis_kelamin, String password, String action) {
        //this.idCust = idCust;
        this.nama = nama;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
        this.photo = photo;
        this.pass = password;
        this.action = action;
        this.level= level;
    }
//    public String getIdCust() {
//        return idCust;
//    }
//    public void setIdCust(String idCust) {
//        this.idCust = idCust;
//    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}