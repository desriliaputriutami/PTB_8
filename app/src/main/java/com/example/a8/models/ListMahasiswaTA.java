package com.example.a8.models;

public class ListMahasiswaTA {

    String gambar;
    String nama;
    String judul;

    public ListMahasiswaTA(){ }

    public ListMahasiswaTA(String gambar, String nama, String judul) {
        this.gambar = gambar;
        this.nama = nama;
        this.judul = judul;
    }

    public String getGambar() {
        return gambar;
    }
    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJudul() {
        return judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }


}
