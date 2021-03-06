package com.ricky.com.gosalon.Model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alhamdulillah on 11/2/16.
 */
public class  ResultCustomer {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<GetCustomer> result = new ArrayList<GetCustomer>();
    @SerializedName("message")
    private String message;

    public ResultCustomer() {}

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<GetCustomer> getResult() {
        return result;
    }
    public void setResult(List<GetCustomer> result) {
        this.result = result;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}