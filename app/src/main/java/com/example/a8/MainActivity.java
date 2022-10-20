package com.example.a8;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.adapters.DataAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.list_mahasiswa);

        DataAdapter adapter = new DataAdapter(new ArrayList<>());
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);

        rvData.setLayoutManager(LayoutManager);





    }
}