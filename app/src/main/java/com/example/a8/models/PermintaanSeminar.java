package com.example.a8.models;

public class PermintaanSeminar {

    String gambar;
    String namaMhs;
    String judul;
    String waktu;
    int status;

    public PermintaanSeminar(){ }

    public PermintaanSeminar(String gambar, String namaMhs, String judul, String waktu, int status) {
        this.gambar = gambar;
        this.namaMhs = namaMhs;
        this.judul = judul;
        this.waktu = waktu;
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

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
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
