package com.example.a8;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.adapters.DataAdapter;
import com.example.a8.models.Data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private Data dataTA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.list_mahasiswa);


        DataAdapter adapter = new DataAdapter(getData());
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);

        rvData.setLayoutManager(LayoutManager);
        rvData.setAdapter(adapter);
    }
    public ArrayList<Data>getData(){
        ArrayList<Data>ListData = new ArrayList<>();
        ListData.add(new Data(
                null,
                "Dwi Sasongko",
                "Ini tuh judul TA nya"
        ));
        ListData.add(new Data(
                null,
                "Putri",
                "Ini tuh judul TA nya"
        ));
        ListData.add(new Data(
                null,
                "Putra",
                "Ini tuh judul TA nya"
        ));
        ListData.add(new Data(
                null,
                "Putra",
                "Ini tuh judul TA nya"
        ));
        ListData.add(new Data(
                null,
                "Putra",
                "Ini tuh judul TA nya"
        ));
        ListData.add(new Data(
                null,
                "Putra",
                "Ini tuh judul TA nya"
        ));
        ListData.add(new Data(
                null,
                "Putra",
                "Ini tuh judul TA nya"
        ));
        ListData.add(new Data(
                null,
                "Putra",
                "Ini tuh judul TA nya"
        ));
        ListData.add(new Data(
                null,
                "Putra",
                "Ini tuh judul TA nya"
        ));

        return ListData;

    }

}