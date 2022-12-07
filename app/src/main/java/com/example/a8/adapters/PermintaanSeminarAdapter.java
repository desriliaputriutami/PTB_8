package com.example.a8.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.models.PermintaanSeminar;
import com.example.a8.models.PermintaanTA;

import java.util.ArrayList;

public class PermintaanSeminarAdapter extends RecyclerView.Adapter<PermintaanSeminarAdapter.SeminarViewHolder> {

    ArrayList<PermintaanSeminar> listPermintaanSeminar = new ArrayList<>();

    public PermintaanSeminarAdapter(ArrayList<PermintaanSeminar> listPermintaanSeminar) {
        this.listPermintaanSeminar = listPermintaanSeminar;
    }

    public void setListPermintaanSeminar(ArrayList<PermintaanSeminar> listPermintaanSeminar) {
        this.listPermintaanSeminar = listPermintaanSeminar;
    }

    @NonNull
    @Override
    public SeminarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SeminarViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listPermintaanSeminar.size();
    }

    public class SeminarViewHolder extends RecyclerView.ViewHolder {
        public SeminarViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
