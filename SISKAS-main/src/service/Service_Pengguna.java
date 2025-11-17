/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Model_Pengguna;


public interface Service_Pengguna {
    void tambahData (Model_Pengguna model);
    void perbaruiData (Model_Pengguna model);
    void hapusData (Model_Pengguna model);
    

    List<Model_Pengguna> tampilData();
    
    List<Model_Pengguna> PencarianData(String id);
    String generateSHA256(String password);
}
