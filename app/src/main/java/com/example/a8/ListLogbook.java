package com.example.a8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.adapters.LogbookAdapter;
import com.example.a8.models.Logbook;

import java.util.ArrayList;

public class ListLogbook extends AppCompatActivity{

    private RecyclerView rvData;
    private Logbook logbookTA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_logbook);

        rvData = findViewById(R.id.list_logbok);


        LogbookAdapter adapter = new LogbookAdapter(getData());

        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);

        rvData.setLayoutManager(LayoutManager);
        rvData.setAdapter(adapter);
    }
    public ArrayList<Logbook>getData(){
        ArrayList<Logbook> listData = new ArrayList<>();
        listData.add(new Logbook(
                null,
                "Dwi Sasongko",
                "Implementation Android blablabla"




        ));
        listData.add(new Logbook(
                null,
                "Putri Andini",
                "Membuat Website dengan Smadav"

        ));
        listData.add(new Logbook(
                null,
                "Abigail Louis",
                "Ini tuh judul TA nya si Abigail"

        ));
        listData.add(new Logbook(
                null,
                "Fatimah Azzahra",
                "Implementasi Machine Learning pada data foreign exchange"

        ));
        listData.add(new Logbook(
                null,
                "Andini Putri",
                "Implementasi IoT pada kegiatan perkuliahan"

        ));
        listData.add(new Logbook(
                null,
                "Amirah Nasution",
                "Membuat website"

        ));
        listData.add(new Logbook(
                null,
                "Erika Prihadi",
                "Ini tuh judul TA nya"

        ));
        listData.add(new Logbook(
                null,
                "Putra",
                "Ini tuh judul TA nya"

        ));
        listData.add(new Logbook(
                null,
                "Putra",
                "Ini tuh judul TA nya"

        ));

        return listData;

    }

}