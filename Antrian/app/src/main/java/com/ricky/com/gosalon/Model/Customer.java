package com.ricky.com.gosalon.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alhamdulillah on 11/2/16.
 */
public class Customer {
    @SerializedName("id_cust")
    private String idCust;

    @SerializedName("nama_cust")
    private String nama;

    @SerializedName("alamat")
    private String alamat;

    @SerializedName("sex")
    private String sex;

    @SerializedName("photo")
    private String photo;

    @SerializedName("password")
    private String pass;

    private String action;

    public Customer() {}

    public Customer(String nama, String alamat, String photo, String sex, String password, String action) {
        //this.idCust = idCust;
        this.nama = nama;
        this.alamat = alamat;
        this.sex = sex;
        this.photo = photo;
        this.pass = password;
        this.action = action;
    }
    public String getIdCust() {
        return idCust;
    }
    public void setIdCust(String idCust) {
        this.idCust = idCust;
    }
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
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
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
}