package com.example.a8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a8.adapters.PermintaanTAAdapter;
import com.example.a8.models.PermintaanTA;

import java.util.ArrayList;

public class ListPermintaanTA extends AppCompatActivity implements PermintaanTAAdapter.ItemPermintaanTAClickListener{

    private RecyclerView rvMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_permintaan_ta);

        rvMhs = findViewById(R.id.rv_mhs);

        PermintaanTAAdapter adapter = new PermintaanTAAdapter(getMhs());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvMhs.setLayoutManager(layoutManager);
        rvMhs.setAdapter(adapter);

    }

    public ArrayList<PermintaanTA> getMhs(){
        ArrayList<PermintaanTA> listPermintaanTA = new ArrayList<>();
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Mardana Dulas",
                "8m ago",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                "Divo Pratama",
                "20 Oktober 2022",
                "PENERAPAN LOGIKA FUZZY TSUKAMOTO BERBASIS WEB UNTUK...",
                1
        ));



        return listPermintaanTA;
    }

    @Override
    public void onItemAgendaClick(PermintaanTA permintaan) {
        Intent detailIntent = new Intent (this,PermintaanTADetailActivity.class);
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