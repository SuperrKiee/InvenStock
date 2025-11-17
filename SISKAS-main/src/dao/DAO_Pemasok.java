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
import model.Model_Jenis_Barang;
import model.Model_Pemasok;
import service.Service_Pemasok;

/**
 *
 * @author UsEr
 */
public class DAO_Pemasok implements Service_Pemasok{
    private Connection conn;
    
    public DAO_Pemasok(){
        
    conn = Koneksi.getConnection();
    }

    @Override
    public void tambahData(Model_Pemasok mod_pemasok) {
        PreparedStatement st = null;
        String sql = "INSERT INTO pemasok (id_pemasok, nama_pemasok, alamat, no_telp) VALUES (?, ?, ?, ?)";
      try{
          st = conn.prepareStatement(sql);
          st.setString(1,  mod_pemasok.getId_pemasok());
          st.setString(2, mod_pemasok.getNama_pemasok());
          st.setString(3, mod_pemasok.getAlamat());
          st.setString(4, mod_pemasok.getNo_telp());
       
          
          st.executeUpdate(); 
      }catch(SQLException ex){
          Logger.getLogger(DAO_Pemasok.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(st!=null){
              try{
                  st.close();
              }catch (SQLException ex){
                  Logger.getLogger(DAO_Pemasok.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
    }

    @Override
    public void perbaruiData(Model_Pemasok mod_pemasok) {
        PreparedStatement st = null;
        String sql = "UPDATE pemasok SET id_pemasok=?, nama_pemasok=?, alamat=?, no_telp=? WHERE id_pemasok=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1,  mod_pemasok.getId_pemasok());
            st.setString(2, mod_pemasok.getNama_pemasok());
            st.setString(3, mod_pemasok.getAlamat());
            st.setString(4, mod_pemasok.getNo_telp());


            st.executeUpdate(); 
            
        }catch(SQLException ex){
            Logger.getLogger(DAO_Pemasok.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch (SQLException ex){
                    Logger.getLogger(DAO_Pemasok.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void hapusData(Model_Pemasok mod_pemasok) {
        PreparedStatement st = null;
        String sql = "DELETE From pemasok WHERE id_pemasok=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_pemasok.getId_pemasok());       

            st.executeUpdate(); 
        }catch(SQLException ex){
            Logger.getLogger(DAO_Pemasok.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch (SQLException ex){
                    Logger.getLogger(DAO_Pemasok.class.getName()).log(Level.SEVERE, null, ex);
                }
          }
      }
    }

    @Override
    public Model_Pemasok getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_Pemasok> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM pemasok";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Model_Pemasok model = new Model_Pemasok();
                model.setId_pemasok(rs.getString("id_pemasok"));
                model.setNama_pemasok(rs.getString("nama_pemasok"));
                model.setAlamat(rs.getString("alamat"));
                model.setNo_telp(rs.getString("no_telp"));

                list.add(model);

            }
            return list;

        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Pemasok.class.getName()).log(Level. SEVERE, null, ex);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Pemasok.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
              if(rs!=null){
                try{
                  rs.close();
                }catch (SQLException ex){
                    Logger.getLogger(DAO_Pemasok.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
    }

    @Override
    public List<Model_Pemasok> pencarian(String id) {
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
        
        String sql ="SELECT RIGHT (id_pemasok, 3) AS Nomor From pemasok WHERE id_pemasok LIKE 'PMS" + no + "%' ORDER BY id_pemasok DESC LIMIT 1";
        

        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
                 
            if(rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "B"+ no + String.format("%03d", nomor);
            }else{
                urutan = "B" + no + "001"; 
            }
        }catch (SQLException ex) {
         java.util.logging.Logger.getLogger(DAO_Pemasok.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
         if (st != null) {
        try {
            st.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Pemasok.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        }
         return urutan;
    }
    
}
