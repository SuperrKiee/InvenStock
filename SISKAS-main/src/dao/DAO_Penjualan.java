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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model_Barang;
import model.Model_Jenis_Barang;
import model.Model_Penjualan;

/**
 *
 * @author UsEr
 */
public class DAO_Penjualan implements service.Service_Penjualan{
     private Connection conn;
    
    public DAO_Penjualan(){
    conn = Koneksi.getConnection();
    }
    
    @Override
    public void tambahData(Model_Penjualan mod_penjualan) {
        PreparedStatement st = null;
      String sql = "INSERT INTO penjualan (id_penjualan, tanggal, total_harga) VALUES (?,?,?)";
      try{
          st = conn.prepareStatement(sql);
          
          st.setString(1, mod_penjualan.getId_penjualan());
          st.setString(2, mod_penjualan.getTanggal());
          st.setLong(3, mod_penjualan.getTotal_harga());
          
 
          st.executeUpdate();

      }catch(SQLException ex){
          Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(st!=null){
              try{
                  st.close();
              }catch (SQLException ex){
                  Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
    }
    
    @Override
    public void hapusData(Model_Penjualan mod_penjualan) {
        PreparedStatement st = null;
        String sql = "DELETE FROM penjualan WHERE id_penjualan=?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_penjualan.getId_penjualan());
            
            st.executeUpdate();
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level. SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Model_Penjualan getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_Penjualan> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * From penjualan";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Model_Penjualan jual = new Model_Penjualan();
                
               jual.setId_penjualan(rs.getString("id_penjualan"));
               jual.setTanggal(rs.getString("tanggal"));
               jual.setTotal_harga(rs.getLong("total_harga"));
                
                
               list.add(jual);

            }

        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level. SEVERE, null, ex);
            return null;
        }
        finally {
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
                 }
                }
                if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    return list;
    }
    
 

    @Override
    public List<Model_Penjualan> pencarian(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        
        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat noformat = new SimpleDateFormat("yyMM");
        String tgl = tanggal.format(now);
        String no = noformat.format(now);
        
        String sql ="SELECT RIGHT (id_penjualan, 3) AS Nomor " +
                    "From penjualan " +
                    "WHERE id_penjualan LIKE 'PJ" + no + "%' " +
                    "ORDER BY id_penjualan DESC " +
                    "LIMIT 1";
        

        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
                 
            if(rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "PJ"+ no + String.format("%03d", nomor);
            }else{
                urutan = "PJ" + no + "001"; 
            }
        }catch (SQLException ex) {
         java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
         if (st != null) {
        try {
            st.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        }
         return urutan;
    }

   
    
}
