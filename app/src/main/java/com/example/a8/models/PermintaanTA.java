package com.example.a8.models;

public class PermintaanTA {

    String gambar;
    String namaMhs;
    String waktu;
    String judul;
    int status;

    public PermintaanTA(){ }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public PermintaanTA(String gambar, String namaMhs, String waktu, String judul, int status) {
        this.gambar = gambar;
        this.namaMhs = namaMhs;
        this.waktu = waktu;
        this.judul = judul;
        this.status = status;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
