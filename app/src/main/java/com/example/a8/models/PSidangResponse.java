package com.example.a8.models;

import java.util.List;

public class PSidangResponse{
    private List<SeminarsItem> seminars;
    private int count;
    private String status;

    public List<SeminarsItem> getSeminars(){
        return seminars;
    }

    public int getCount(){
        return count;
    }

    public String getStatus(){
        return status;
    }
}