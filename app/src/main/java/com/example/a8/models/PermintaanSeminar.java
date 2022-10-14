package com.example.a8.models;

public class PermintaanSeminar {

    String gambar;
    int tipeMhs;
    String namaMhs;
    String waktu;
    String tempat;
    int status;

    public PermintaanSeminar(){ }
    public PermintaanSeminar(String gambar, int tipeMhs, String namaMhs, String waktu, String tempat, int status) {
        this.gambar = gambar;
        this.tipeMhs = tipeMhs;
        this.namaMhs = namaMhs;
        this.waktu = waktu;
        this.tempat = tempat;
        this.status = status;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getTipeMhs() {
        return tipeMhs;
    }

    public void setTipeMhs(int tipeMhs) {
        this.tipeMhs = tipeMhs;
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

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
