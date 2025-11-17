/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Model_SemPenjualan;

/**
 *
 * @author UsEr
 */
public interface Service_Sem_Penjualan {
    void tambahData (Model_SemPenjualan mod_semPenjualan);
    void perbaruiData (Model_SemPenjualan mod_semPenjualan);
    void hapusData (Model_SemPenjualan mod_semPenjualan);

    Model_SemPenjualan getById (String id);
    List<Model_SemPenjualan> getData();

    
}
