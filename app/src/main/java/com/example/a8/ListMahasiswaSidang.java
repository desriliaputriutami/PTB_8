package com.example.a8;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.adapters.ListMahasiswaSidangAdapter;

import java.util.ArrayList;

public class ListMahasiswaSidang extends AppCompatActivity implements ListMahasiswaSidangAdapter.ItemMahasiswaSidangClickListener{

    private RecyclerView rvMahasiswaSidang;
    private com.example.a8.models.ListMahasiswaSidang mahasiswaSidangSidang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mahasiswa_sidang);

        rvMahasiswaSidang = findViewById(R.id.list_mahasiswa);


        ListMahasiswaSidangAdapter adapter = new ListMahasiswaSidangAdapter(getMahasiswaSidang());
        adapter.setListener(this);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);

        rvMahasiswaSidang.setLayoutManager(LayoutManager);
        rvMahasiswaSidang.setAdapter(adapter);
    }
    public ArrayList<com.example.a8.models.ListMahasiswaSidang>getMahasiswaSidang(){
        ArrayList<com.example.a8.models.ListMahasiswaSidang>ListMahasiswaSidang = new ArrayList<>();
        ListMahasiswaSidang.add(new com.example.a8.models.ListMahasiswaSidang(
                null,
                "Dwi Sasongko",
                "Implementation Android blablabla"




        ));
        ListMahasiswaSidang.add(new com.example.a8.models.ListMahasiswaSidang(
                null,
                "Putri Andini",
                "Membuat Website dengan Smadav"

        ));
        ListMahasiswaSidang.add(new com.example.a8.models.ListMahasiswaSidang(
                null,
                "Abigail Louis",
                "Ini tuh judul Sidang nya si Abigail"

        ));
        ListMahasiswaSidang.add(new com.example.a8.models.ListMahasiswaSidang(
                null,
                "Fatimah Azzahra",
                "Implementasi Machine Learning pada MahasiswaSidang foreign exchange"

        ));
        ListMahasiswaSidang.add(new com.example.a8.models.ListMahasiswaSidang(
                null,
                "Andini Putri",
                "Implementasi IoT pada kegiatan perkuliahan"

        ));
        ListMahasiswaSidang.add(new com.example.a8.models.ListMahasiswaSidang(
                null,
                "Amirah Nasution",
                "Membuat website"

        ));
        ListMahasiswaSidang.add(new com.example.a8.models.ListMahasiswaSidang(
                null,
                "Erika Prihadi",
                "Ini tuh judul Sidang nya"

        ));
        ListMahasiswaSidang.add(new com.example.a8.models.ListMahasiswaSidang(
                null,
                "Putra",
                "Ini tuh judul Sidang nya"

        ));
        ListMahasiswaSidang.add(new com.example.a8.models.ListMahasiswaSidang(
                null,
                "Putra",
                "Ini tuh judul Sidang nya"

        ));

        return ListMahasiswaSidang;

    }

    @Override
    public void onItemMahasiswaSidangClick(com.example.a8.models.ListMahasiswaSidang mahasiswaSidang) {
        Intent detailIntent = new Intent(this, detail_Sidang_Activity.class); //buat pindah ke halaman berikutnya :)
        detailIntent.putExtra("nama_mahasiswa", mahasiswaSidang.getNama().toString());   //buat nge load data nama nya ke halaman detail mahasiswa Sidang
        detailIntent.putExtra("isi_judul_tugas_akhir", mahasiswaSidang.getJudul().toString());  //buat nge load data judul nya ke halaman detail mahasiswa Sidang
        startActivity(detailIntent);



    }
}