package com.example.a8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.adapters.PesertaSeminarAdapter;
import com.example.a8.models.PesertaSeminar;

import java.util.ArrayList;

public class ListPesertaSeminar extends AppCompatActivity implements PesertaSeminarAdapter.ItemDataClickListener{

    private RecyclerView rvData;
    private PesertaSeminar pesertaSeminarTA;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_peserta_seminar);

        rvData = findViewById(R.id.list_peserta_seminar);


        PesertaSeminarAdapter adapter = new PesertaSeminarAdapter(getData());
        adapter.setListener(this);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);

        rvData.setLayoutManager(LayoutManager);
        rvData.setAdapter(adapter);


    }
    public ArrayList<PesertaSeminar>getData(){
        ArrayList<PesertaSeminar> listData = new ArrayList<>();
        listData.add(new PesertaSeminar(
                null,
                "Dwi Sasongko",
                "Implementation Android blablabla"




        ));
        listData.add(new PesertaSeminar(
                null,
                "Putri Andini",
                "Membuat Website dengan Smadav"

        ));
        listData.add(new PesertaSeminar(
                null,
                "Abigail Louis",
                "Ini tuh judul TA nya si Abigail"

        ));
        listData.add(new PesertaSeminar(
                null,
                "Fatimah Azzahra",
                "Implementasi Machine Learning pada data foreign exchange"

        ));
        listData.add(new PesertaSeminar(
                null,
                "Andini Putri",
                "Implementasi IoT pada kegiatan perkuliahan"

        ));
        listData.add(new PesertaSeminar(
                null,
                "Amirah Nasution",
                "Membuat website"

        ));
        listData.add(new PesertaSeminar(
                null,
                "Erika Prihadi",
                "Ini tuh judul TA nya"

        ));
        listData.add(new PesertaSeminar(
                null,
                "Putra",
                "Ini tuh judul TA nya"

        ));
        listData.add(new PesertaSeminar(
                null,
                "Putra",
                "Ini tuh judul TA nya"

        ));

        return listData;

    }

    @Override
    public void onItemDataClick(PesertaSeminar pesertaSeminar) {
        Intent detailIntent = new Intent(this, detail_TA_Activity.class); //buat pindah ke halaman berikutnya :)
        detailIntent.putExtra("nama_mahasiswa", pesertaSeminar.getNama().toString());   //buat nge load data nama nya ke halaman detail mahasiswa TA
        detailIntent.putExtra("isi_judul_tugas_akhir", pesertaSeminar.getJudul().toString());  //buat nge load data judul nya ke halaman detail mahasiswa TA
        startActivity(detailIntent);
    }

    public void onbutton_back_list_peserta_seminarClick(View view) {
        Intent i = new Intent(this, detail_TA_Activity.class);
        startActivity(i);
    }



}