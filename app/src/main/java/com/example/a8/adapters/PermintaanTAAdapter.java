package com.example.a8.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.R;
import com.example.a8.models.PermintaanTA;

import java.util.ArrayList;

public class PermintaanTAAdapter extends RecyclerView.Adapter<PermintaanTAAdapter.MahasiswaViewHolder>{

    ArrayList<PermintaanTA> listPermintaanTA = new ArrayList<>();


    ItemPermintaanTAClickListener listener;

    public PermintaanTAAdapter(ArrayList<PermintaanTA> listPermintaanTA) {
        this.listPermintaanTA = listPermintaanTA;
    }

    public void setListMahasiswa(ArrayList<PermintaanTA> listPermintaanTA) {
        this.listPermintaanTA = listPermintaanTA;
    }

    public void setListener(ItemPermintaanTAClickListener listener) {
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
        PermintaanTA permintaanTA = listPermintaanTA.get(position);
        //holder.imageMhs.setImageResource(R.drawable.logounand);
        holder.textNamaMhs.setText(permintaanTA.getNamaMhs());
        holder.textMhsType.setText(Integer.toString(permintaanTA.getTipeMhs()));
        holder.textWaktu.setText(permintaanTA.getWaktu());
        holder.textTempat.setText(permintaanTA.getTempat());
    }

    @Override
    public int getItemCount() {

        return listPermintaanTA.size();
    }

    public interface ItemPermintaanTAClickListener{
       void onItemAgendaClick (PermintaanTA permintaan);
    }
    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageMhs, imageStatus;
        public TextView textMhsType, textNamaMhs, textWaktu, textTempat;


        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMhs = itemView.findViewById(R.id.imageMhs);
            imageStatus =itemView.findViewById(R.id.imageStatus);
            textMhsType =itemView.findViewById(R.id.textMhsType);
            textNamaMhs =itemView.findViewById(R.id.textRujukan);
            textWaktu =itemView.findViewById(R.id.textWaktu);
            textTempat =itemView.findViewById(R.id.textTempat);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            PermintaanTA permintaanta =listPermintaanTA.get(getAdapterPosition());
            listener.onItemAgendaClick(permintaanta);
        }
    }
}
