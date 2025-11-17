/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Model_Barang;
import model.Model_Detai_penjualan;
import model.Model_SemPenjualan;

/**
 *
 * @author UsEr
 */
public class DAO_semPenjualan implements service.Service_Sem_Penjualan{
    private Connection conn;
    
    public DAO_semPenjualan(){
    conn = Koneksi.getConnection();
    }

    @Override
    public void tambahData(Model_SemPenjualan mod_semPenjualan) {
        PreparedStatement st = null;
        String sql = "INSERT INTO sementara_penjualan (id_produk, nama_produk, harga, jumlah, sub_total) VALUES (?,?,?,?,?)";
      try{
           st = conn.prepareStatement(sql); 
           st.setString(1, mod_semPenjualan.getMod_barang().getId_produk());
           st.setString(2, mod_semPenjualan.getMod_barang().getNama_produk());
           st.setDouble(3, mod_semPenjualan.getMod_barang().getHarga());
           st.setInt(4, mod_semPenjualan.getMod_detkeluar().getJumlah());
           st.setLong(5, mod_semPenjualan.getMod_detkeluar().getSub_total());
           
           
           st.executeUpdate(); 
      }catch(SQLException ex){
          Logger.getLogger(DAO_Det_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(st!=null){
              try{
                  st.close();
              }catch (SQLException ex){
                  Logger.getLogger(DAO_Det_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
    }


    @Override
    public void hapusData(Model_SemPenjualan mod_semPenjualan) {
      PreparedStatement st = null;
      String sql = "UPDATE sementara_penjualan SET nama_produk=?, harga=?, jumlah=?, sub_total=? WHERE id_produk='"+mod_semPenjualan.getMod_barang().getId_produk()+"'";
      try{
          st = conn.prepareStatement(sql);
          
           st.setString(1, mod_semPenjualan.getMod_barang().getNama_produk());
           st.setDouble(2, mod_semPenjualan.getMod_barang().getHarga());
           st.setInt(3, mod_semPenjualan.getMod_detkeluar().getJumlah());
           st.setLong(4, mod_semPenjualan.getMod_detkeluar().getSub_total());
          
          st.executeUpdate();
                 
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
          Logger.getLogger(DAO_semPenjualan.class.getName()).log(Level.SEVERE, null, ex);
              
      }finally{
          if(st!=null){
              try{
                  st.close();
              }catch (SQLException ex){
                  Logger.getLogger(DAO_semPenjualan.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
    }

    @Override
    public Model_SemPenjualan getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_SemPenjualan> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM sementara_penjualan";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                
                Model_SemPenjualan sem_jual = new Model_SemPenjualan();
                Model_Barang brg = new Model_Barang();
                Model_Detai_penjualan det_jual = new Model_Detai_penjualan();
                
                brg.setId_produk(rs.getString("id_produk"));
                brg.setNama_produk(rs.getString("nama_produk"));
                brg.setHarga(rs.getDouble("harga"));
                
                
                det_jual.setJumlah(rs.getInt("jumlah_pesan"));
                det_jual.setSub_total(rs.getLong("sub_total"));
                
                sem_jual.setMod_bararang(brg);
                sem_jual.setMod_detpenjualan(det_jual);
           
                list.add(sem_jual);

            }
            return list;

        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_semPenjualan.class.getName()).log(Level. SEVERE, null, ex);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_semPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
              if(rs!=null){
                try{
                  rs.close();
                }catch (SQLException ex){
                   java.util.logging.Logger.getLogger(DAO_semPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                
              }
          }
      }
    }

    @Override
    public void perbaruiData(Model_SemPenjualan mod_semPenjualan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }

    

