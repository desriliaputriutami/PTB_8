package com.example.a8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detail_TA_Activity2 extends AppCompatActivity {

    String namaData;
    String judulData;

    TextView nama_mahasiswa;         //id dari nama yang ada di halaman detail mahasiswa TA
    TextView isi_judul_tugas_akhir;   //id dari judul yang ada di halaman detail mahasiswa TA

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ta2);

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
}