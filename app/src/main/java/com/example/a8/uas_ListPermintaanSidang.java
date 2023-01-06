package com.example.a8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a8.adapters.uas_PermintaanSidangAdapter;
//import com.example.a8.models.uas_PermintaanSidang;
import com.example.a8.models.PSidangResponse;
import com.example.a8.models.SeminarsItem;
import com.example.a8.route.Route;

import java.util.ArrayList;

import retrofit2.Retrofit;
//import com.example.a8.models.loginResponse;
import com.example.a8.route.Route;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class uas_ListPermintaanSidang extends AppCompatActivity /*implements uas_pSidangAdapter.ItemPermintaanSidangClickListener*/ {

    private RecyclerView rvSidang;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");


        //abis tu, kita perlu buat handler untuk, ketika di click maka dia akan cek login


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ptb-api.husnilkamil.my.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        Route route = retrofit.create(Route.class);

        Call<PSidangResponse> call = route.getPsidang("Bearer" + token );
        call.enqueue(new Callback<PSidangResponse>() {
            @Override
            public void onResponse(Call<PSidangResponse> call, Response<PSidangResponse> response) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.remove("TOKEN");
                editor.apply();
                finish();
                Toast.makeText( uas_ListPermintaanSidang.this, "Permintaan sidang selesai", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(uas_ListPermintaanSidang.this, MainActivity.class);
                startActivity(intent);

                PSidangResponse getPSidang = response.body();
                if (getPSidang != null) {
                    List<SeminarsItem> getSeminars = getPSidang.getSeminars();
                }
            }

            @Override
            public void onFailure(Call<PSidangResponse> call, Throwable t) {
                Toast.makeText(uas_ListPermintaanSidang.this, "gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
