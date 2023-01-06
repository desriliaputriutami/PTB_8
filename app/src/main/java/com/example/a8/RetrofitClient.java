package com.example.a8;

import okhttp3.OkHttpClient;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";
    private static Route service;

    public static Route getService() {

        if (service == null){
            String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder().build())
                    .build();

            service = retrofit.create(Route.class);

        }
        return service;

    }
}