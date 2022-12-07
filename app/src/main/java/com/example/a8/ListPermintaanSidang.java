package com.example.a8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a8.adapters.PermintaanSidangAdapter;
import com.example.a8.models.PermintaanSidang;

import java.util.ArrayList;

public class ListPermintaanSidang extends AppCompatActivity implements PermintaanSidangAdapter.ItemPermintaanSidangClickListener{

    private RecyclerView rvSidang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_permintaan_sidang);

        rvSidang = findViewById(R.id.rvSidang);

        PermintaanSidangAdapter adapter = new PermintaanSidangAdapter(getMhs());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvSidang.setLayoutManager(layoutManager);
        rvSidang.setAdapter(adapter);

    }

    public ArrayList<PermintaanSidang> getMhs(){
        ArrayList<PermintaanSidang> ListPermintaanSidang = new ArrayList<>();
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        ListPermintaanSidang.add(new PermintaanSidang(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));



        return ListPermintaanSidang;
    }

    @Override
    public void onItemAgendaClick(PermintaanSidang permintaan) {
        Intent detailIntent = new Intent (this,PermintaanSidangDetailActivity.class);
        detailIntent.putExtra("NAMA_MHS", permintaan.getNamaMhs());
        startActivity(detailIntent);
    }

    public void backClick(View view) {
        Intent detailIntent = new Intent (this,MainActivity.class);
        startActivity(detailIntent);
    }

    public void logoutClick(View view) {
        Intent detailIntent = new Intent (this,Login.class);
        startActivity(detailIntent);
    }

}