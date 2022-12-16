package com.example.a8.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.R;
import com.example.a8.models.Logbook;

import java.util.ArrayList;

public class LogbookAdapter extends RecyclerView.Adapter<LogbookAdapter.LogbookViewHolder> {

    ArrayList<Logbook> listLogbook = new ArrayList<>();   //tempat nyimpan data yang akan ditampilkan ke recycleview
    ItemLogbookClickListener listener;

    public LogbookAdapter(ArrayList<Logbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    public void setListLogbook(ArrayList<Logbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    public void setListener(ItemLogbookClickListener listener) {
        this.listener = listener;
    }



    @NonNull
    @Override
    public LogbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {           //method yang akan digunakan untuk membuat viewholder yang nanti akan digunakan untuk menampilkan data
        View view = LayoutInflater.from(parent.getContext())        //layout inflatter adalah class yang digunakan untuk load layout ke dalam recycle kita
                .inflate(R.layout.item_logbook, parent, false);
        return new LogbookViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull LogbookViewHolder holder, int position) {     //method yang digunakan untuk menempatkan data ke dalam recycleview nya
        Logbook logbook = listLogbook.get(position);
        //holder.imageView4.setImageDrawable(R.drawable.profile);
        holder.nama_mahasiswa_ta.setText(logbook.getNama().toString());
        holder.judul_ta.setText(logbook.getJudul().toString());
    }



    @Override
    public int getItemCount() {
        return listLogbook.size();
    }
    public interface ItemLogbookClickListener{
        void onItemLogbookClick(Logbook logbook);
    }

    public class LogbookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageView4;
        public TextView nama_mahasiswa_ta, judul_ta;

        public LogbookViewHolder(@NonNull View itemview) {
            super(itemview);
            imageView4 = itemview.findViewById(R.id.imageView4);
            nama_mahasiswa_ta = itemview.findViewById(R.id.nama_mahasiswa_ta);
            judul_ta = itemview.findViewById(R.id.judul_ta);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Logbook logbook = listLogbook.get(getAdapterPosition());
            listener.onItemLogbookClick(logbook);

        }
    }
}