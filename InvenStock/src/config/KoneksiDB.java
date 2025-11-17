package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiDB {
    
    private static Connection conn = null; 
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_gudang";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    public static Connection getKoneksi() {
        
        try {
            if (conn == null || conn.isClosed()) {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            }
        
        } catch (SQLException | ClassNotFoundException e) { 
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal: " + e.getMessage());
            System.exit(0); 
        }
        
        return conn;
    }

    /*public static void main(String[] args){
        System.out.println("Mencoba mengambil koneksi...");
        Connection tesKoneksi = KoneksiDB.getKoneksi();
        
        if (tesKoneksi != null) {
            System.out.println("Tes Koneksi via getKoneksi() BERHASIL!");
        } else {
            System.out.println("Tes Koneksi GAGAL.");
        }
    }*/ //buat nyoba

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}