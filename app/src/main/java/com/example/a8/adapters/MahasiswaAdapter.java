package com.example.a8.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.R;
import com.example.a8.models.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>{

    ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();

    public MahasiswaAdapter(ArrayList<Mahasiswa> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;
    }

    public void setListMahasiswa(ArrayList<Mahasiswa> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mhs, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        Mahasiswa mahasiswa = listMahasiswa.get(position);
        //holder.imageMhs.setImageResource(R.drawable.logounand);
        holder.textNamaMhs.setText(mahasiswa.getNamaMhs());
        holder.textMhsType.setText(Integer.toString(mahasiswa.getTipeMhs()));
        holder.textWaktu.setText(mahasiswa.getWaktu());
        holder.textTempat.setText(mahasiswa.getTempat());
    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageMhs, imageStatus;
        public TextView textMhsType, textNamaMhs, textWaktu, textTempat;


        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMhs = itemView.findViewById(R.id.imageMhs);
            imageStatus =itemView.findViewById(R.id.imageStatus);
            textMhsType =itemView.findViewById(R.id.textMhsType);
            textNamaMhs =itemView.findViewById(R.id.textNamaMhs);
            textWaktu =itemView.findViewById(R.id.textWaktu);
            textTempat =itemView.findViewById(R.id.textTempat);
        }
    }
}
