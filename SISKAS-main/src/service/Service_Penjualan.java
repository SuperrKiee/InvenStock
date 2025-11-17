/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Model_Penjualan;

/**
 *
 * @author UsEr
 */
public interface Service_Penjualan {
    void tambahData (Model_Penjualan mod_penjualan);
    void hapusData (Model_Penjualan mod_penjualan);

    
    Model_Penjualan getById (String id);
    
    List<Model_Penjualan> getData();
    
    List<Model_Penjualan> pencarian(String id);
    
    String nomor();
    
    
}
