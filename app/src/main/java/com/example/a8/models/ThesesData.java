
package com.example.a8.models;

import java.util.ArrayList;
import java.util.List;

import com.example.a8.data.Thesis;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ThesesData {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("theses")
    @Expose
    private ArrayList<Thesis> theses = new ArrayList();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Thesis> getTheses() {
        return theses;
    }

    public void setTheses(ArrayList<Thesis> theses) {
        this.theses = theses;
    }

}