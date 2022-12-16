package com.example.a8;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.a8.adapters.LogbookAdapter;
import com.example.a8.models.Logbook;

import java.util.ArrayList;

public class ListLogbook extends AppCompatActivity implements LogbookAdapter.ItemLogbookClickListener{

    private RecyclerView rvLogbook;
    private Logbook logbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_logbook);

        rvLogbook = findViewById(R.id.list_logbook);


        LogbookAdapter adapter = new LogbookAdapter(getLogbook());
        adapter.setListener(this);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(LayoutManager);
        rvLogbook.setAdapter(adapter);
    }
    public ArrayList<Logbook>getLogbook(){
        ArrayList<Logbook>ListLogbook = new ArrayList<>();
        ListLogbook.add(new Logbook(
                null,
                "Dwi Sasongko",
                "Implementation Android blablabla"




        ));
        ListLogbook.add(new Logbook(
                null,
                "Putri Andini",
                "Membuat Website dengan Smadav"

        ));
        ListLogbook.add(new Logbook(
                null,
                "Abigail Louis",
                "Ini tuh judul TA nya si Abigail"

        ));
        ListLogbook.add(new Logbook(
                null,
                "Fatimah Azzahra",
                "Implementasi Machine Learning pada data foreign exchange"

        ));
        ListLogbook.add(new Logbook(
                null,
                "Andini Putri",
                "Implementasi IoT pada kegiatan perkuliahan"

        ));
        ListLogbook.add(new Logbook(
                null,
                "Amirah Nasution",
                "Membuat website"

        ));
        ListLogbook.add(new Logbook(
                null,
                "Erika Prihadi",
                "Ini tuh judul TA nya"

        ));
        ListLogbook.add(new Logbook(
                null,
                "Putra",
                "Ini tuh judul TA nya"

        ));
        ListLogbook.add(new Logbook(
                null,
                "Putra",
                "Ini tuh judul TA nya"

        ));

        return ListLogbook;

    }

    @Override
    public void onItemLogbookClick(Logbook logbook) {
        Intent detailIntent = new Intent(this, detail_TA_Activity.class); //buat pindah ke halaman berikutnya :)
        detailIntent.putExtra("nama_mahasiswa", logbook.getNama().toString());   //buat nge load data nama nya ke halaman detail mahasiswa TA
        detailIntent.putExtra("isi_judul_tugas_akhir", logbook.getJudul().toString());  //buat nge load data judul nya ke halaman detail mahasiswa TA
        startActivity(detailIntent);



    }
}