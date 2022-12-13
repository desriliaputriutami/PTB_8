package com.example.a8;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.adapters.ListMahasiswaTAAdapter;

import java.util.ArrayList;

public class ListMahasiswaTA extends AppCompatActivity implements ListMahasiswaTAAdapter.ItemMahasiswaTAClickListener{

    private RecyclerView rvMahasiswaTA;
    private com.example.a8.models.ListMahasiswaTA mahasiswaTATA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mahasiswata);

        rvMahasiswaTA = findViewById(R.id.list_mahasiswa);


        ListMahasiswaTAAdapter adapter = new ListMahasiswaTAAdapter(getMahasiswaTA());
        adapter.setListener(this);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);

        rvMahasiswaTA.setLayoutManager(LayoutManager);
        rvMahasiswaTA.setAdapter(adapter);
    }
    public ArrayList<com.example.a8.models.ListMahasiswaTA>getMahasiswaTA(){
        ArrayList<com.example.a8.models.ListMahasiswaTA>ListMahasiswaTA = new ArrayList<>();
        ListMahasiswaTA.add(new com.example.a8.models.ListMahasiswaTA(
                null,
                "Dwi Sasongko",
                "Implementation Android blablabla"




        ));
        ListMahasiswaTA.add(new com.example.a8.models.ListMahasiswaTA(
                null,
                "Putri Andini",
                "Membuat Website dengan Smadav"

        ));
        ListMahasiswaTA.add(new com.example.a8.models.ListMahasiswaTA(
                null,
                "Abigail Louis",
                "Ini tuh judul TA nya si Abigail"

        ));
        ListMahasiswaTA.add(new com.example.a8.models.ListMahasiswaTA(
                null,
                "Fatimah Azzahra",
                "Implementasi Machine Learning pada MahasiswaTA foreign exchange"

        ));
        ListMahasiswaTA.add(new com.example.a8.models.ListMahasiswaTA(
                null,
                "Andini Putri",
                "Implementasi IoT pada kegiatan perkuliahan"

        ));
        ListMahasiswaTA.add(new com.example.a8.models.ListMahasiswaTA(
                null,
                "Amirah Nasution",
                "Membuat website"

        ));
        ListMahasiswaTA.add(new com.example.a8.models.ListMahasiswaTA(
                null,
                "Erika Prihadi",
                "Ini tuh judul TA nya"

        ));
        ListMahasiswaTA.add(new com.example.a8.models.ListMahasiswaTA(
                null,
                "Putra",
                "Ini tuh judul TA nya"

        ));
        ListMahasiswaTA.add(new com.example.a8.models.ListMahasiswaTA(
                null,
                "Putra",
                "Ini tuh judul TA nya"

        ));

        return ListMahasiswaTA;

    }

    @Override
    public void onItemMahasiswaTAClick(com.example.a8.models.ListMahasiswaTA mahasiswaTA) {
        Intent detailIntent = new Intent(this, detail_TA_Activity.class); //buat pindah ke halaman berikutnya :)
        detailIntent.putExtra("nama_mahasiswa", mahasiswaTA.getNama().toString());   //buat nge load data nama nya ke halaman detail mahasiswa TA
        detailIntent.putExtra("isi_judul_tugas_akhir", mahasiswaTA.getJudul().toString());  //buat nge load data judul nya ke halaman detail mahasiswa TA
        startActivity(detailIntent);



    }
}