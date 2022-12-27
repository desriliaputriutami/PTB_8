package com.example.a8.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.example.a8.data.AuthData;

public class AuthClass {

    @SerializedName("user")
    @Expose
    private AuthData authData;
    @SerializedName("message")
    @Expose
    private String message;

    public AuthData getUser() {
        return authData;
    }

    public void setUser(AuthData authData) {
        this.authData = authData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
