/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author UsEr
 */
public class Model_SemPenjualan {

    public Model_Barang getMod_barang() {
        return mod_barang;
    }

    public void setMod_bararang(Model_Barang mod_barang) {
        this.mod_barang = mod_barang;
    }

    public Model_Detai_penjualan getMod_detkeluar() {
        return mod_detkeluar;
    }

    public void setMod_detpenjualan(Model_Detai_penjualan mod_detkeluar) {
        this.mod_detkeluar = mod_detkeluar;
    }
    private Model_Barang mod_barang;
    private Model_Detai_penjualan mod_detkeluar;
}
