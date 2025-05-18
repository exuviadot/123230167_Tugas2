/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;

/**
 *
 * @author User
 */
public class Connector {
    static Connection conn;
    
    public static Connection connection(){
        if(conn == null){
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setDatabaseName("perpus");
            dataSource.setUser("root");
            dataSource.setPassword("");
            
            try{
                conn = dataSource.getConnection();
                System.out.println("Koneksi Berhasil");
            }catch(SQLException ex){
                ex.printStackTrace();
                System.err.println("Koneksi Gagal: " + ex.getMessage());
                System.out.println("Koneksi Gagal");
            }
        }
        return conn;
    }
}
