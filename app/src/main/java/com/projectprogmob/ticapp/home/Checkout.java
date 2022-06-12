package com.projectprogmob.ticapp.home;



import java.io.Serializable;

public class Checkout implements Serializable {
    String kursi, harga;

    public Checkout(String kursi, String harga){
        this.kursi = kursi;
        this.harga = harga;
    }
    public String getHarga() {
        return harga;
    }

    public String getKursi() {
        return kursi;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setKursi(String kursi) {
        this.kursi = kursi;
    }

}
