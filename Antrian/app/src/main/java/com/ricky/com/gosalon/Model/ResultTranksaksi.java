package com.ricky.com.gosalon.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultTranksaksi {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<GetTranksaksi> result = new ArrayList<GetTranksaksi>();
    @SerializedName("message")
    private String message;

    public String getStatus() {
        return status;
    }

    public List<GetTranksaksi> getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
