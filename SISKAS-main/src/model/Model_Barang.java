/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author UsEr
 */
public class Model_Barang {

    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public Model_Jenis_Barang getJns_barang() {
        return jns_barang;
    }

    public void setJns_barang(Model_Jenis_Barang jns_barang) {
        this.jns_barang = jns_barang;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public static String getGet() {
        return get;
    }

    public static void setGet(String get) {
        Model_Barang.get = get;
    }
     
    private String id_produk;
    private Model_Jenis_Barang jns_barang;
    private String nama_produk;
    private String satuan;
    private Double harga;
    private Integer stok;

    public static String get;


    
}