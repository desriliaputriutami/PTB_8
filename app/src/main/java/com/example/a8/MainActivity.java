package com.example.a8;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.adapters.DataAdapter;
import com.example.a8.models.Data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DataAdapter.ItemDataClickListener{

    private RecyclerView rvData;
    private Data dataTA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.list_mahasiswa);


        DataAdapter adapter = new DataAdapter(getData());
        adapter.setListener(this);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);

        rvData.setLayoutManager(LayoutManager);
        rvData.setAdapter(adapter);
    }
    public ArrayList<Data>getData(){
        ArrayList<Data>ListData = new ArrayList<>();
        ListData.add(new Data(
                null,
                "Dwi Sasongko",
                "Ini tuh judul TA nya si Sasongko"
        ));
        ListData.add(new Data(
                null,
                "Putri Andini",
                "Ini tuh judul TA nya si Putri"
        ));
        ListData.add(new Data(
                null,
                "Abigail Louis",
                "Ini tuh judul TA nya si Abigail"
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

    @Override
    public void onItemDataClick(Data data) {
        Intent detailIntent = new Intent(this, detail_TA_Activity2.class); //buat pindah ke halaman berikutnya :)
        detailIntent.putExtra("nama_mahasiswa", data.getNama().toString());   //buat nge load data nya ke halaman detail mahasiswa TA
        startActivity(detailIntent);


    }
}