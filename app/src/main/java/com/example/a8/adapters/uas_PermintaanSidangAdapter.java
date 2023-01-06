package com.example.a8.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.R;
import com.example.a8.models.PSidangResponse;
import com.example.a8.models.PermintaanSidang;
import com.example.a8.models.SeminarsItem;
import com.example.a8.models.Thesis;

import java.util.ArrayList;
import java.util.List;

public class uas_PermintaanSidangAdapter extends RecyclerView.Adapter<uas_PermintaanSidangAdapter.MahasiswaViewHolder>{

    private List<SeminarsItem> itemThesis = new ArrayList<>();
    ItemPermintaanSidangClickListener listener;

    public void setItemThesis(List<SeminarsItem> itemThesis) {
        this.itemThesis = itemThesis;
        notifyDataSetChanged();
    }

    public void setListener(ItemPermintaanSidangClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public uas_PermintaanSidangAdapter.MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_permintaan_sidang, parent, false);
        return new uas_PermintaanSidangAdapter.MahasiswaViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return itemThesis.size();
    }

    public interface ItemPermintaanSidangClickListener {
        void onItemPermintaanClick(SeminarsItem permintaanSidang);
    }

    @Override
    public void onBindViewHolder(@NonNull uas_PermintaanSidangAdapter.MahasiswaViewHolder holder, int position) {
        SeminarsItem thesis = itemThesis.get(position);
        holder.imageMhs.setImageResource(R.drawable.logounand);
        holder.textNamaMhs.setText(thesis.getThesisId());
        holder.textWaktu.setText(thesis.getCreatedAt());
        holder.textTA.setText((CharSequence) thesis.getThesis());
    }





    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageMhs, imageStatus;
        public TextView textNamaMhs, textWaktu, textTA;


        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMhs = itemView.findViewById(R.id.imageMhs);
            imageStatus =itemView.findViewById(R.id.imageStatus);
            textNamaMhs =itemView.findViewById(R.id.textRujukan);
            textWaktu =itemView.findViewById(R.id.textWaktu);
            textTA =itemView.findViewById(R.id.textTA);

                    }
    }
}