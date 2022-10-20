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
                "Implementation Android blablabla"




        ));
        ListData.add(new Data(
                null,
                "Putri Andini",
                "Membuat Website dengan Smadav"

        ));
        ListData.add(new Data(
                null,
                "Abigail Louis",
                "Ini tuh judul TA nya si Abigail"

        ));
        ListData.add(new Data(
                null,
                "Fatimah Azzahra",
                "Implementasi Machine Learning pada data foreign exchange"

        ));
        ListData.add(new Data(
                null,
                "Andini Putri",
                "Implementasi IoT pada kegiatan perkuliahan"

        ));
        ListData.add(new Data(
                null,
                "Amirah Nasution",
                "Membuat website"

        ));
        ListData.add(new Data(
                null,
                "Erika Prihadi",
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
        detailIntent.putExtra("nama_mahasiswa", data.getNama().toString());   //buat nge load data nama nya ke halaman detail mahasiswa TA
        detailIntent.putExtra("isi_judul_tugas_akhir", data.getJudul().toString());  //buat nge load data judul nya ke halaman detail mahasiswa TA
        startActivity(detailIntent);



    }
}