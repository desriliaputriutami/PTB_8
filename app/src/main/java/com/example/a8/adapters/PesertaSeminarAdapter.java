package com.example.a8.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.R;
import com.example.a8.models.PesertaSeminar;

import java.util.ArrayList;

public class PesertaSeminarAdapter extends RecyclerView.Adapter<PesertaSeminarAdapter.DataViewHolder> {

    ArrayList<PesertaSeminar> listData = new ArrayList<>();   //tempat nyimpan data yang akan ditampilkan ke recycleview
    ItemDataClickListener listener;

    public PesertaSeminarAdapter(ArrayList<PesertaSeminar> listData) {
        this.listData = listData;
    }

    public void setListData(ArrayList<PesertaSeminar> listData) {
        this.listData = listData;
    }

    public void setListener(ItemDataClickListener listener) {
        this.listener = listener;
    }




    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {           //method yang akan digunakan untuk membuat viewholder yang nanti akan digunakan untuk menampilkan data
        View view = LayoutInflater.from(parent.getContext())        //layout inflatter adalah class yang digunakan untuk load layout ke dalam recycle kita
                .inflate(R.layout.item_peserta_seminar, parent, false);
        return new DataViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {     //method yang digunakan untuk menempatkan data ke dalam recycleview nya
        PesertaSeminar pesertaSeminar = listData.get(position);
        //holder.imageView4.setImageDrawable(R.drawable.profile);
        holder.nama_mahasiswa_ta.setText(pesertaSeminar.getNama().toString());
        holder.judul_ta.setText(pesertaSeminar.getJudul().toString());
    }



    @Override
    public int getItemCount() {
        return listData.size();
    }
    public interface ItemDataClickListener{
        void onItemDataClick(PesertaSeminar pesertaSeminar);
    }

    public class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageView4;
        public TextView nama_mahasiswa_ta, judul_ta;

        public DataViewHolder(@NonNull View itemview) {
            super(itemview);
            imageView4 = itemview.findViewById(R.id.foto_peserta_seminar);
            nama_mahasiswa_ta = itemview.findViewById(R.id.nama_mahasiswa_ta);
            judul_ta = itemview.findViewById(R.id.judul_ta);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            PesertaSeminar pesertaSeminar = listData.get(getAdapterPosition());
            listener.onItemDataClick(pesertaSeminar);

        }
    }
}