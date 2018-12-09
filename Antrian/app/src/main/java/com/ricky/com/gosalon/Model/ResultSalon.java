package com.ricky.com.gosalon.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultSalon {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<GetSalon> result = new ArrayList<GetSalon>();
    @SerializedName("message")
    private String message;

    public String getStatus() {
        return status;
    }

    public List<GetSalon> getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
