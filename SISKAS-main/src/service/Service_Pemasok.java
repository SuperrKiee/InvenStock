/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Model_Pemasok;

/**
 *
 * @author UsEr
 */
public interface Service_Pemasok {
    void tambahData (Model_Pemasok mod_pemasok);
    void perbaruiData (Model_Pemasok mod_Pemasok);
    void hapusData (Model_Pemasok mod_pemasok);
    
    Model_Pemasok getByid (String id);
    List<Model_Pemasok>getData();
    List<Model_Pemasok>pencarian(String id);
    
    String nomor();
}
