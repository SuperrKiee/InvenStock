package dao;

import config.Koneksi;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Model_Pengguna;



public class Pengguna_DAO implements service.Service_Pengguna{
    
    private Connection conn;
    
    public Pengguna_DAO(){
        
    conn = Koneksi.getConnection();
    
    }

    @Override
    public void tambahData(Model_Pengguna model) {
        PreparedStatement st = null;
        String sql = "INSERT INTO pengguna (nama_pengguna, username, password, alamat, telepon, role) VALUES (?, ?, ?, ?, ?, ?)";
      try{
          st = conn.prepareStatement(sql);
          st.setString(1,  model.getNama_pengguna());
          st.setString(2, model.getUsername());
          st.setString(3, generateSHA256(model.getPassword()));
          st.setString(4, model.getAlamat());
          st.setString(5, model.getTelepon());
          st.setString(6, model.getRole());
       
          
          st.executeUpdate(); 
          st.close();
      }catch(SQLException e){
          e.printStackTrace();
      }
    }

    @Override
    public void perbaruiData(Model_Pengguna model) {
        PreparedStatement st = null;
        String sql = "UPDATE pengguna SET nama_pengguna=?, username=?, alamat=?, telepon=?, role=? WHERE id_pengguna=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1,  model.getNama_pengguna());
          st.setString(2, model.getUsername());
          st.setString(3, model.getAlamat());
          st.setString(4, model.getTelepon());
          st.setString(5, model.getRole());
          st.setString(6, model.getId_pengguna());


            st.executeUpdate(); 
            
        }catch(SQLException e){
            e.printStackTrace();   
        }
      }

    @Override
    public void hapusData(Model_Pengguna model) {
        PreparedStatement st = null;
      String sql = "DELETE From pengguna WHERE id_pengguna=?";
      try{
          st = conn.prepareStatement(sql);
          st.setString(1, model.getId_pengguna());       
          
          st.executeUpdate(); 
          
      }catch(SQLException e){
          e.printStackTrace();
      }
    }
    
    @Override
    public List<Model_Pengguna> tampilData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM pengguna";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Model_Pengguna mokat = new Model_Pengguna();
                mokat.setId_pengguna    (rs.getString("id_pengguna"));
                mokat.setNama_pengguna  (rs.getString("nama_pengguna"));
                mokat.setUsername       (rs.getString("username"));
                mokat.setAlamat         (rs.getString("alamat"));
                mokat.setTelepon        (rs.getString("telepon"));
                mokat.setRole           (rs.getString("role"));

                list.add(mokat);

            }

        }catch (SQLException e){
            e.printStackTrace();
            
        }
        return list;
            
    }

    @Override
    public String generateSHA256(String password) {
       try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodehash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder(2 * encodehash.length);

            for (byte b : encodehash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Model_Pengguna> PencarianData(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
