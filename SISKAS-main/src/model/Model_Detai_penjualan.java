/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author UsEr
 */
public class Model_Detai_penjualan {

    public Model_Penjualan getMod_keluar() {
        return mod_keluar;
    }

    public void setMod_keluar(Model_Penjualan mod_keluar) {
        this.mod_keluar = mod_keluar;
    }

    public Model_Barang getMod_barang() {
        return mod_barang;
    }

    public void setMod_barang(Model_Barang mod_barang) {
        this.mod_barang = mod_barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Long getSub_total() {
        return sub_total;
    }

    public void setSub_total(Long sub_total) {
        this.sub_total = sub_total;
    }
    private Model_Penjualan mod_keluar;
    private Model_Barang mod_barang;
    private int jumlah;
    private Long sub_total;  
}
