package com.example.a8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a8.adapters.MahasiswaAdapter;
import com.example.a8.models.Mahasiswa;

import java.util.ArrayList;

public class ListMahasiswa extends AppCompatActivity {

    private RecyclerView rvMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        rvMhs = findViewById(R.id.rv_mhs);

        MahasiswaAdapter adapter = new MahasiswaAdapter(getMhs());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvMhs.setLayoutManager(layoutManager);
        rvMhs.setAdapter(adapter);

    }

    public ArrayList<Mahasiswa> getMhs(){
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        listMahasiswa.add(new Mahasiswa(
                null,
                1,
                "Kuliah Pemrograman eknologi Bergerak",
                "12.00-15.00",
                "H2.4",
                1
        ));
        listMahasiswa.add(new Mahasiswa(
                null,
                1,
                "Kuliah Inovasi Sistem Informasi",
                "12.00-15.00",
                "H2.4",
                1
        ));
        return listMahasiswa;
    }
}