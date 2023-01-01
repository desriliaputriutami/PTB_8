package com.example.a8.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.R;
import com.example.a8.models.ListMahasiswaSidang;

import java.util.ArrayList;

public class ListMahasiswaSidangAdapter extends RecyclerView.Adapter<ListMahasiswaSidangAdapter.MahasiswaSidangViewHolder> {

    ArrayList<ListMahasiswaSidang> listMahasiswaSidang = new ArrayList<>();   //tempat nyimpan data yang akan ditampilkan ke recycleview
    ItemMahasiswaSidangClickListener listener;

    public ListMahasiswaSidangAdapter(ArrayList<ListMahasiswaSidang> listMahasiswaSidang) {
        this.listMahasiswaSidang = listMahasiswaSidang;
    }

    public void setListMahasiswaSidang(ArrayList<ListMahasiswaSidang> listMahasiswaSidang) {
        this.listMahasiswaSidang = listMahasiswaSidang;
    }

    public void setListener(ItemMahasiswaSidangClickListener listener) {
        this.listener = listener;
    }




    @NonNull
    @Override
    public MahasiswaSidangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {           //method yang akan digunakan untuk membuat viewholder yang nanti akan digunakan untuk menampilkan MahasiswaSidang
        View view = LayoutInflater.from(parent.getContext())        //layout inflatter adalah class yang digunakan untuk load layout ke dalam recycle kita
                .inflate(R.layout.item_mahasiswa_sidang, parent, false);
        return new MahasiswaSidangViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaSidangViewHolder holder, int position) {     //method yang digunakan untuk menempatkan data ke dalam recycleview nya
        ListMahasiswaSidang mahasiswaSidang = listMahasiswaSidang.get(position);
        //holder.imageView4.setImageDrawable(R.drawable.profile);
        holder.nama_mahasiswa_sidang.setText(mahasiswaSidang.getNama().toString());
        holder.judul_sidang.setText(mahasiswaSidang.getJudul().toString());
    }



    @Override
    public int getItemCount() {
        return listMahasiswaSidang.size();
    }
    public interface ItemMahasiswaSidangClickListener{
        void onItemMahasiswaSidangClick(ListMahasiswaSidang mahasiswaSidang);
    }

    public class MahasiswaSidangViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageView4;
        public TextView nama_mahasiswa_sidang, judul_sidang;

        public MahasiswaSidangViewHolder(@NonNull View itemview) {
            super(itemview);
            imageView4 = itemview.findViewById(R.id.imageView4);
            nama_mahasiswa_sidang = itemview.findViewById(R.id.nama_mahasiswa_sidang);
            judul_sidang = itemview.findViewById(R.id.judul_sidang);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ListMahasiswaSidang mahasiswaSidang = listMahasiswaSidang.get(getAdapterPosition());
            listener.onItemMahasiswaSidangClick(mahasiswaSidang);

        }
    }
}