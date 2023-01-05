package com.example.a8.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a8.R;
import com.example.a8.data.Thesis;

import java.util.ArrayList;

public class ListMahasiswaTAAdapter extends RecyclerView.Adapter<ListMahasiswaTAAdapter.MahasiswaTAViewHolder> {

    ArrayList<Thesis> listMahasiswaTA = new ArrayList<>();   //tempat nyimpan data yang akan ditampilkan ke recycleview
    ItemMahasiswaTAClickListener listener;

    public ListMahasiswaTAAdapter(ArrayList<Thesis> listMahasiswaTA) {
        this.listMahasiswaTA = listMahasiswaTA;
    }

    public void setListMahasiswaTA(ArrayList<Thesis> listMahasiswaTA) {
        this.listMahasiswaTA = listMahasiswaTA;
    }

    public void setListener(ItemMahasiswaTAClickListener listener) {
        this.listener = listener;
    }




    @NonNull
    @Override
    public MahasiswaTAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {           //method yang akan digunakan untuk membuat viewholder yang nanti akan digunakan untuk menampilkan MahasiswaTA
        View view = LayoutInflater.from(parent.getContext())        //layout inflatter adalah class yang digunakan untuk load layout ke dalam recycle kita
                .inflate(R.layout.item_mahasiswa_ta, parent, false);
        return new MahasiswaTAViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaTAViewHolder holder, int position) {     //method yang digunakan untuk menempatkan data ke dalam recycleview nya
        Thesis mahasiswaTA = listMahasiswaTA.get(position);
        //holder.imageView4.setImageDrawable(R.drawable.profile);
        holder.nama_mahasiswa_ta.setText(mahasiswaTA.getStudentName());
        holder.judul_ta.setText(mahasiswaTA.getTitle());
    }



    @Override
    public int getItemCount() {
        return listMahasiswaTA.size();
    }
    public interface ItemMahasiswaTAClickListener{
        void onItemMahasiswaTAClick(Thesis mahasiswaTA);
    }

    public class MahasiswaTAViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageView4;
        public TextView nama_mahasiswa_ta, judul_ta;

        public MahasiswaTAViewHolder(@NonNull View itemview) {
            super(itemview);
            imageView4 = itemview.findViewById(R.id.imageView4);
            nama_mahasiswa_ta = itemview.findViewById(R.id.nama_mahasiswa_ta);
            judul_ta = itemview.findViewById(R.id.judul_ta);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Thesis mahasiswaTA = listMahasiswaTA.get(getAdapterPosition());
            listener.onItemMahasiswaTAClick(mahasiswaTA);

        }
    }
}