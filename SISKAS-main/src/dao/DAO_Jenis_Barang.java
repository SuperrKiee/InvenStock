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
import model.Model_Jenis_Barang;
import service.Service_Jenis_Barang;

public class DAO_Jenis_Barang implements Service_Jenis_Barang{
    
    private Connection conn;
    
    public DAO_Jenis_Barang(){
        
    conn = Koneksi.getConnection();
    
    }

    @Override
    public void tambahData(Model_Jenis_Barang mod_jenbar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO kategori (id_kategori, nama_kategori) VALUES (?, ?)";
      try{
          st = conn.prepareStatement(sql);
          st.setString(1,  mod_jenbar.getId_kategori());
          st.setString(2, mod_jenbar.getNama_kategori());
       
          
          st.executeUpdate(); 
      }catch(SQLException ex){
          Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(st!=null){
              try{
                  st.close();
              }catch (SQLException ex){
                  Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
    }

    @Override
    public void perbaruiData(Model_Jenis_Barang mod_jenbar) {
        PreparedStatement st = null;
        String sql = "UPDATE kategori SET nama_kategori=? WHERE id_kategori=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_jenbar.getId_kategori());
            st.setString(2, mod_jenbar.getNama_kategori());


            st.executeUpdate(); 
            
        }catch(SQLException ex){
            Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch (SQLException ex){
                    Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      }

    @Override
    public void hapusData(Model_Jenis_Barang mod_jenbar) {
        PreparedStatement st = null;
      String sql = "DELETE From kategori WHERE id_kategori=?";
      try{
          st = conn.prepareStatement(sql);
          st.setString(1, mod_jenbar.getId_kategori());       
          
          st.executeUpdate(); 
      }catch(SQLException ex){
          Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(st!=null){
              try{
                  st.close();
              }catch (SQLException ex){
                  Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
    }

    @Override
    public Model_Jenis_Barang getById(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Model_Jenis_Barang mokat = null;
        String sql = "SELECT * FROM kategori WHERE id_kategori=?";
        
        try{
            st = conn.prepareStatement(sql);
            Model_Jenis_Barang ndr = new Model_Jenis_Barang();
            st.setString(1, ndr.getId_kategori());
            st.setString(2, ndr.getNama_kategori());
            
            rs = st.executeQuery();
            while(rs.next()){
                mokat = new Model_Jenis_Barang();
                mokat.setId_kategori(rs.getString("kode_jenis"));
                mokat.setNama_kategori(rs.getString("nama_jenis"));
            }
             return mokat;
        }catch(SQLException ex){
             Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
             return null;
      }finally{
          if(st!=null){
              try{
                  st.close();
                 }catch (SQLException ex){
                  Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
                 }
              }
              if(rs!=null){
              try{
                   rs.close();
                    }catch (SQLException ex){
                  Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
      
    }

    @Override
    public List<Model_Jenis_Barang> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM kategori";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Model_Jenis_Barang mokat = new Model_Jenis_Barang();
                mokat.setId_kategori(rs.getString("id_kategori"));
                mokat.setNama_kategori(rs.getString("nama_kategori"));

                list.add(mokat);

            }
            return list;

        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level. SEVERE, null, ex);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
              if(rs!=null){
                try{
                  rs.close();
                }catch (SQLException ex){
                    Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
            
    }

    @Override
    public List<Model_Jenis_Barang> pencarian(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        String sql = "SELECT RIGHT (id_kategori,3) AS Nomor FROM kategori ORDER BY Nomor DESC LIMIT 1";
        
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;                                            
                urutan = String.format("%03d", nomor);  
            }else{
                urutan = "001";
            }
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            if(st!=null){
                try{
                   st.close(); 
                }catch(SQLException ex){
                 java.util.logging.Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE,null,ex);
                }
            }     
        
        }
        return urutan;
    }
    

    @Override
    public boolean validasiNamaJenisBarang(Model_Jenis_Barang mod_jenbar) {
    PreparedStatement st = null;
    ResultSet rs = null;
    boolean valid = false;
    String sql = "SELECT nama_kategori FROM kategori WHERE id_kategori != ? AND nama_kategori LIKE BINARY ?";
    try {
        st = conn.prepareStatement(sql);
        st.setString(1, mod_jenbar.getId_kategori());
        st.setString(2, mod_jenbar.getNama_kategori());
        rs = st.executeQuery();
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Nama Jenis Barang Telah ada\nSilahkan pilih nama jenis barang yang lain", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            valid = true;
        }
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Jenis_Barang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    return valid;
}

    @Override
    public int hitungTotalJenisBarang() {
        List<Model_Jenis_Barang> data = getData();
        return data.size();
    }
    
}
