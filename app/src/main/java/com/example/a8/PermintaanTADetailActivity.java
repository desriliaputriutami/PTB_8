package com.example.a8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PermintaanTADetailActivity extends AppCompatActivity {

    String namaMhs;
    TextView textNamaMhsDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permintaan_tadetail);

        Intent detailIntent = getIntent();
        if(detailIntent!=null){
            namaMhs=detailIntent.getStringExtra("NAMA_MHS");
            textNamaMhsDetail = findViewById(R.id.textRujukan);
            textNamaMhsDetail.setText(namaMhs);
        }
    }

    public void onButtonKirimClick(View view) {
        Intent i = new Intent(this, ConfirmActivity.class);
        startActivity(i);
    }
}