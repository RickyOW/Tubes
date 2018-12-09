package com.ricky.com.gosalon.Model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alhamdulillah on 11/2/16.
 */
public class PostPutDelCustomer {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
     GetCustomer Customer;
    @SerializedName("message")
    private String message;

    public String getStatus() {
        return status; }

    public void setStatus(String status) {
        this.status = status;
    }

    public GetCustomer getCustomer() {
        return Customer;
    }

    public void setCustomer(GetCustomer customer) {
        Customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}