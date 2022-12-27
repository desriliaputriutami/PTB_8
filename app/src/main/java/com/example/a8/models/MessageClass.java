package com.example.a8.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageClass {

    @SerializedName("message")
    @Expose
    private String message;

    public String getMessage(){
        return message;
    }
}
