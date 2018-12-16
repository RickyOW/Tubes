package com.ricky.com.gosalon.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultLayanan {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<GetLayanan> result;
    @SerializedName("message")
    private String message;

    public String getStatus() {
        return status;
    }

    public List<GetLayanan> getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
