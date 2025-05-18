/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class DataBuku {
    private int id_buku;
    private String judul_buku;
    private String genre_buku;
    private String penulis_buku;
    private String penerbit_buku;
    private String lokasi_buku;
    private int stok_buku;

    public int getId_buku() {
        return id_buku;
    }

    public void setId_buku(int id_buku) {
        this.id_buku = id_buku;
    }

    public String getJudul_buku() {
        return judul_buku;
    }

    public void setJudul_buku(String judul_buku) {
        this.judul_buku = judul_buku;
    }

    public String getGenre_buku() {
        return genre_buku;
    }

    public void setGenre_buku(String genre_buku) {
        this.genre_buku = genre_buku;
    }

    public String getPenulis_buku() {
        return penulis_buku;
    }

    public void setPenulis_buku(String penulis_buku) {
        this.penulis_buku = penulis_buku;
    }

    public String getPenerbit_buku() {
        return penerbit_buku;
    }

    public void setPenerbit_buku(String penerbit_buku) {
        this.penerbit_buku = penerbit_buku;
    }

    public String getLokasi_buku() {
        return lokasi_buku;
    }

    public void setLokasi_buku(String lokasi_buku) {
        this.lokasi_buku = lokasi_buku;
    }

    public int getStok_buku() {
        return stok_buku;
    }

    public void setStok_buku(int stok_buku) {
        this.stok_buku = stok_buku;
    }
}
