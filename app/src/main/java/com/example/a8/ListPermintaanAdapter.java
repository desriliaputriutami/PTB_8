package com.example.a8;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.datamodels.PembimbingResponse;
import com.example.a8.datamodels.PermintaanItem;

import java.util.ArrayList;
import java.util.List;

public class ListPermintaanAdapter extends RecyclerView.Adapter<ListPermintaanAdapter.ListViewHolder>{

    private List<PermintaanItem> listPermintaan = new ArrayList<>();

    public void setListPermintaan(List<PermintaanItem> listPermintaan){
        this.listPermintaan = listPermintaan;
        notifyDataSetChanged();

    }

    public ListPermintaanAdapter(){
        this.listPermintaan = listPermintaan;
    }



    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListPermintaanAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_permintaan_ta, parent, false);
        return new ListViewHolder(view);
    }

    public List<PembimbingResponse> list = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        PermintaanItem permintaan = listPermintaan.get(position);
        holder.tvName.setText(permintaan.getStudent().getName());
        holder.tvDescription.setText(permintaan.getStudent().getNim());
//        Glide.with(holder.imgPhoto)
//                .load(permintaan.getStudent().getPhoto())
//                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, PembimbingActivity.class);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPermintaan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imageMhs);
            tvName = itemView.findViewById(R.id.textRujukan);
            tvDescription = itemView.findViewById(R.id.textTA);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(PermintaanItem data);

    }

}
