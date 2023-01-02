package com.example.a8;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class detail_Sidang_Activity extends AppCompatActivity {
    String namaData;
    String judulData;

    TextView nama_mahasiswa;         //id dari nama yang ada di halaman detail mahasiswa Sidang
    TextView isi_judul_tugas_akhir;   //id dari judul yang ada di halaman detail mahasiswa Sidang


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sidang);

        Intent detailIntent = getIntent();
        if (detailIntent != null) {
            namaData = detailIntent.getStringExtra("nama_mahasiswa");
            judulData = detailIntent.getStringExtra("isi_judul_tugas_akhir");

            nama_mahasiswa = findViewById(R.id.nama_mahasiswa);
            isi_judul_tugas_akhir = findViewById(R.id.isi_judul_tugas_akhir);

            nama_mahasiswa.setText(namaData);
            isi_judul_tugas_akhir.setText((judulData));
        }
    }


    public void onbutton_back_detail_SidangClick(View view) {
        Intent i = new Intent(this, ListMahasiswaSidang.class);
        startActivity(i);
    }

    public void onbuttonListLogbookClick(View view) {
        Intent i = new Intent(this, ListLogbook.class);
        startActivity(i);
    }
    public void onbuttonListPesertaSeminarClick(View view) {
        Intent i = new Intent(this, ListPesertaSeminar.class);
        startActivity(i);
    }

}