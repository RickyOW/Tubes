package com.ricky.com.gosalon.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultPegawai {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<GetPegawai> result = new ArrayList<GetPegawai>();
    @SerializedName("message")
    private String message;

    public String getStatus() {
        return status;
    }

    public List<GetPegawai> getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
