package com.example.a8.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.R;
import com.example.a8.models.PermintaanSidang;

import java.util.ArrayList;

public class PermintaanSidangAdapter extends RecyclerView.Adapter<PermintaanSidangAdapter.MahasiswaViewHolder>{

    ArrayList<PermintaanSidang> listPermintaanSidang = new ArrayList<>();


    ItemPermintaanSidangClickListener listener;

    public PermintaanSidangAdapter(ArrayList<PermintaanSidang> listPermintaanSidang) {
        this.listPermintaanSidang = listPermintaanSidang;
    }

    public void setListMahasiswa(ArrayList<PermintaanSidang> listPermintaanSidang) {
        this.listPermintaanSidang = listPermintaanSidang;
    }

    public void setListener(ItemPermintaanSidangClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_permintaan_ta, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        PermintaanSidang PermintaanSidang = listPermintaanSidang.get(position);
        holder.imageMhs.setImageResource(R.drawable.logounand);
        holder.textNamaMhs.setText(PermintaanSidang.getNamaMhs());
        holder.textWaktu.setText(PermintaanSidang.getWaktu());
        holder.textTA.setText(PermintaanSidang.getJudul());
    }

    @Override
    public int getItemCount() {

        return listPermintaanSidang.size();
    }

    public interface ItemPermintaanSidangClickListener{
        void onItemAgendaClick (PermintaanSidang permintaan);
    }
    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageMhs, imageStatus;
        public TextView textNamaMhs, textWaktu, textTA;


        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMhs = itemView.findViewById(R.id.imageMhs);
            imageStatus =itemView.findViewById(R.id.imageStatus);
            textNamaMhs =itemView.findViewById(R.id.textRujukan);
            textWaktu =itemView.findViewById(R.id.textWaktu);
            textTA =itemView.findViewById(R.id.textTA);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            PermintaanSidang PermintaanSidang =listPermintaanSidang.get(getAdapterPosition());
            listener.onItemAgendaClick(PermintaanSidang);
        }
    }
}