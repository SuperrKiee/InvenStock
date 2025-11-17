/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author UsEr
 */
public class Model_Penjualan {
    private String  id_penjualan;
    private String tanggal;
    private Long total_harga;

    public String getId_penjualan() {
        return id_penjualan;
    }

    public void setId_penjualan(String id_penjualan) {
        this.id_penjualan = id_penjualan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Long getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(Long total_harga) {
        this.total_harga = total_harga;
    }
}
