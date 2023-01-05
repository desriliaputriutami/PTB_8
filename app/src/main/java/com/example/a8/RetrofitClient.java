package com.example.a8;

import okhttp3.OkHttpClient;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";
    private static Route service;

    public static Route getService() {

        if (service == null) {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.client(httpClient.build()).build();

            service = retrofit.create(Route.class);
        }
        return service;

    }
    public Route configRetrofit () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Route Route = retrofit.create(Route.class);
        return Route;
    }
}