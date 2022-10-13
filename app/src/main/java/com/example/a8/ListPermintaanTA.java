package com.example.a8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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
                1,
                "Kuliah Pemrograman Teknologi Bergerak",
                "12.00-15.00",
                "H2.4",
                1
        ));
        listPermintaanTA.add(new PermintaanTA(
                null,
                1,
                "Kuliah Inovasi Sistem Informasi",
                "12.00-15.00",
                "H2.4",
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
}