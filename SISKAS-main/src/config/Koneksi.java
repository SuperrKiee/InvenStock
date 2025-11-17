/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Koneksi {
    public static void main(String[] args) {
        
    }
    private static Connection connection;
    public static Connection getConnection(){
        if (connection==null) {
            try{
                String url = "jdbc:mysql://localhost:3306/siskas";
                String user = "root";
                String pass = "andrean211004";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
                
                
            }catch  (SQLException ex){
                JOptionPane.showMessageDialog(null, "Data Base Tidak Ditemukan!" );
                ex.printStackTrace(); // Melihat trace kesalahan pada konsolSQLException ex){
               
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
    
}
