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

    ArrayList<Data> listData = new ArrayList<>();   //tempat nyimpan data yang akan ditampilkan ke recycleview
    ItemDataClickListener listener;

    public DataAdapter(ArrayList<Data> listData) {
        this.listData = listData;
    }

    public void setListData(ArrayList<Data> listData) {
        this.listData = listData;
    }

    public void setListener(ItemDataClickListener listener) {
        this.listener = listener;
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
        Data data = listData.get(position);
        //holder.imageView4.setImageDrawable(R.drawable.profile);
        holder.nama_mahasiswa_ta.setText(data.getNama().toString());
        holder.judul_ta.setText(data.getJudul().toString());
    }



    @Override
    public int getItemCount() {
        return listData.size();
    }
    public interface ItemDataClickListener{
        void onItemDataClick(Data data);
    }

    public class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageView4;
        public TextView nama_mahasiswa_ta, judul_ta;

        public DataViewHolder(@NonNull View itemview) {
            super(itemview);
            imageView4 = itemview.findViewById(R.id.imageView4);
            nama_mahasiswa_ta = itemview.findViewById(R.id.nama_mahasiswa_ta);
            judul_ta = itemview.findViewById(R.id.judul_ta);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Data data = listData.get(getAdapterPosition());
            listener.onItemDataClick(data);

        }
    }
}

