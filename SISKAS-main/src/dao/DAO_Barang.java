
package dao;


import model.Model_Barang;
import config.Koneksi;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.ResultSet;
import model.Model_Barang;
import service.Service_Barang;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.List;
import model.Model_Jenis_Barang;

public class DAO_Barang implements Service_Barang{
    private Connection conn;
    
    public DAO_Barang(){
    conn = Koneksi.getConnection();
}
    
    @Override
    public void tambahData(Model_Barang mod_bar) {
      PreparedStatement st = null;
      String sql = "INSERT INTO produk (id_produk, id_kategori, nama_produk, satuan, harga, stok) VALUES (?,?,?,?,?,?)";
      try{
          st = conn.prepareStatement(sql);
          
          st.setString(1, mod_bar.getId_produk());
          st.setString(2, mod_bar.getJns_barang().getId_kategori());
          st.setString(3, mod_bar.getNama_produk());
          st.setString(4, mod_bar.getSatuan());
          st.setDouble(5, mod_bar.getHarga());
          st.setInt(6, mod_bar.getStok());
          
          st.executeUpdate();

      }catch(SQLException ex){
          Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(st!=null){
              try{
                  st.close();
              }catch (SQLException ex){
                  Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      }
    }

    @Override
public void perbaruiData(Model_Barang mod_bar) {
    PreparedStatement st = null;
    String sql = "UPDATE produk SET id_kategori=?, nama_produk=?, satuan=?, harga=?, stok=? WHERE id_produk=?";
    try {
        st = conn.prepareStatement(sql);
        
        st.setString(1, mod_bar.getJns_barang().getId_kategori());
        st.setString(2, mod_bar.getNama_produk());
        st.setString(3, mod_bar.getSatuan());
        st.setDouble(4, mod_bar.getHarga());
        st.setInt(5, mod_bar.getStok());
        st.setString(6, mod_bar.getId_produk()); // Menetapkan nilai parameter ke-6
        
        st.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if(st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
}

    @Override
    public void hapusData(Model_Barang mod_bar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM produk WHERE id_produk=?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_bar.getId_produk());
            
            st.executeUpdate();
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level. SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


    @Override
    public List<Model_Barang> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT bg.id_produk,bg.id_kategori,jb.nama_kategori,bg.nama_produk,bg.satuan,bg.harga,bg.stok FROM produk bg INNER JOIN kategori jb ON jb.id_kategori=bg.id_kategori";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Model_Barang mobar = new Model_Barang();
                Model_Jenis_Barang jbr = new Model_Jenis_Barang();
                
                mobar.setId_produk(rs.getString("id_produk"));
                jbr.setId_kategori(rs.getString("id_kategori"));
                jbr.setNama_kategori(rs.getString("nama_kategori"));
                mobar.setNama_produk(rs.getString("nama_produk"));
                mobar.setSatuan(rs.getString("satuan"));
                mobar.setHarga(rs.getInt("harga"));
                mobar.setStok(rs.getInt("stok"));
                
                mobar.setJns_barang(jbr);
                
                list.add(mobar);

            }

        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level. SEVERE, null, ex);
            return null;
        }
        finally {
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
                 }
                }
                if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    return list;
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
        
        String sql ="SELECT RIGHT (id_produk, 3) AS Nomor " +
                    "From produk " +
                    "WHERE id_produk LIKE 'B" + no + "%' " +
                    "ORDER BY id_produk DESC " +
                    "LIMIT 1";
        

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
         java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
         if (st != null) {
        try {
            st.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        }
         return urutan;
    }
    
    @Override
    public int hitungTotalBarang() {
       List<Model_Barang> data = getData();
        return data.size();
    }
    
}
