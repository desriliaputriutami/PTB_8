package com.example.a8.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.R;
import com.example.a8.models.Data;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    ArrayList<Data> ListData = new ArrayList<>();   //tempat nyimpan data yang akan ditampilkan ke recycleview

    public DataAdapter(ArrayList<Data> listData) {
        ListData = listData;
    }



    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {           //method yang akan digunakan untuk membuat viewholder yang nanti akan digunakan untuk menampilkan data
        View view = LayoutInflater.from(parent.getContext())        //layout inflatter adalah class yang digunakan untuk load layout ke dalam recycle kita
                .inflate(R.layout.list_permintaan_ta, parent, false);
        return new DataViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {     //method yang digunakan untuk menempatkan data ke dalam recycleview nya
        Data data = ListData.get(position);
        //holder.imageView4.setImageDrawable(R.drawable.profile);
        holder.nama_mahasiswa_ta.setText(data.getNama());
        holder.judul_ta.setText(data.getJudul());

    }



    @Override
    public int getItemCount() {
        return ListData.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView4;
        public TextView nama_mahasiswa_ta,judul_ta;

        public DataViewHolder(@NonNull View itemview) {
            super(itemview);
            imageView4 = itemview.findViewById(R.id.imageView4);
            nama_mahasiswa_ta = itemview.findViewById(R.id.nama_mahasiswa_ta);
            judul_ta = itemview.findViewById(R.id.judul_ta);


        }
    }
}
