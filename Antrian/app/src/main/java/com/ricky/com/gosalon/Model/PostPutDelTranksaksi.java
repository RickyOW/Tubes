package com.ricky.com.gosalon.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelTranksaksi {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    GetTranksaksi Tranksaksi;
    @SerializedName("message")
    private String message;

    public String getStatus() {
        return status; }

    public void setStatus(String status) {
        this.status = status;
    }

    public GetTranksaksi getTranksaksi() {
        return Tranksaksi;
    }

    public void setTranksaksi(GetTranksaksi tranksaksi) {
        Tranksaksi = tranksaksi;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
