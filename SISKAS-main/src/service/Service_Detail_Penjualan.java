/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Model_Detai_penjualan;

/**
 *
 * @author UsEr
 */
public interface Service_Detail_Penjualan {
    void tambahData (Model_Detai_penjualan mod_detPenjualan);
    void sumTotal (Model_Detai_penjualan mod_detPenjualan);
    void hapusSementara (Model_Detai_penjualan mod_detPenjualan);
    

    
    Model_Detai_penjualan getById (String id);
    List<Model_Detai_penjualan> getData(String id);
    List<Model_Detai_penjualan> pencarian(String id);
    
    boolean validasiStok (Model_Detai_penjualan mod_detPenjualan);
    
    
    
}
