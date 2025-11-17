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
import model.Model_Barang;
import model.Model_Detai_penjualan;
import model.Model_Penjualan;

/**
 *
 * @author UsEr
 */
public class DAO_Det_Penjualan implements service.Service_Detail_Penjualan{
     private Connection conn;
    
    public DAO_Det_Penjualan(){
    conn = Koneksi.getConnection();
    }

    @Override
    public void tambahData(Model_Detai_penjualan mod_detPenjualan) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_penjualan (id_penjualan, id_produk, jumlah, sub_total)SELECT '"+mod_detPenjualan.getMod_keluar().getId_penjualan()+"', id_produk, jumlah, sub_total FROM sementara_penjualan";
      try{
          st = conn.prepareStatement(sql); 
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
    public void sumTotal(Model_Detai_penjualan mod_detPenjualan) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(sub_total) FROM sementara_penjualan";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                mod_detPenjualan.setSub_total(rs.getLong(1));
            }

        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Det_Penjualan.class.getName()).log(Level. SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Det_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
      }
    }

    @Override
    public void hapusSementara(Model_Detai_penjualan mod_detPenjualan) {
        PreparedStatement st = null;
        String sql = "DELETE From sementara_penjualan";
        try{
          st = conn.prepareStatement(sql);   
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
    public Model_Detai_penjualan getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_Detai_penjualan> getData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT det_mdl.id_penjualan, det_mdl.id_produk, brg.nama_produk,"
            + " brg.harga, det_mdl.jumlah, det_mdl.sub_total"
            + " FROM detail_penjualan det_mdl "
            + " INNER JOIN penjualan mp ON mp.id_penjualan = det_mdl.id_penjualan"
            + " INNER JOIN produk brg ON brg.id_produk = det_mdl.id_produk"
            + " WHERE det_mdl.id_penjualan = '" + id + "' ORDER BY id_penjualan ASC";

        
            try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Model_Penjualan jual = new Model_Penjualan();
                Model_Detai_penjualan det_jual = new Model_Detai_penjualan();
                Model_Barang brg = new Model_Barang();
                
                jual.setId_penjualan(String.valueOf(rs.getString("det_mdl.id_penjualan")));
                det_jual.setMod_keluar(jual);
                
                brg.setId_produk(rs.getString("id_produk"));
                brg.setNama_produk(rs.getString("nama_produk"));
                brg.setHarga(rs.getInt("harga"));
                det_jual.setJumlah(rs.getInt("jumlah"));
                det_jual.setSub_total(rs.getLong("sub_total"));
                
                det_jual.setMod_barang(brg);
                
                list.add(det_jual);

            }
            return list;

        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Det_Penjualan.class.getName()).log(Level. SEVERE, null, ex);
            return null;
        }
        finally {
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Det_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Det_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    
    }

    @Override
    public List<Model_Detai_penjualan> pencarian(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validasiStok(Model_Detai_penjualan mod_detPenjualan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
