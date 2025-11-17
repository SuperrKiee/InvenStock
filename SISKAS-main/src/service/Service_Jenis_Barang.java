/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Model_Jenis_Barang;

/**
 *
 * @author UsEr
 */
public interface Service_Jenis_Barang {
    void tambahData (Model_Jenis_Barang mod_jenbar);
    void perbaruiData (Model_Jenis_Barang mod_jenbar);
    void hapusData (Model_Jenis_Barang mod_jenbar);
    
    Model_Jenis_Barang getById (String id);
    
    List<Model_Jenis_Barang> getData();
    
    List<Model_Jenis_Barang> pencarian(String id);
    
    String nomor();
    
    boolean validasiNamaJenisBarang (Model_Jenis_Barang mod_jenbar);
    
    int hitungTotalJenisBarang();
}
