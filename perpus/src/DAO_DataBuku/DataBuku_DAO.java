/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_DataBuku;

import DAO_Implement.DataBuku_Implement;
import java.sql.*;
import java.util.*;
import koneksi.Connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DataBuku_DAO implements DataBuku_Implement{
    Connection connection;
    
    //Query-query yang akan dipake dibawah
    final String query_select = "SELECT * FROM data_buku";
    final String query_insert = "INSERT INTO data_buku (judul_buku, genre_buku, penulis_buku, penerbit_buku, lokasi_buku, stok_buku) VALUES (?, ?, ?, ?, ?, ?)";
    final String query_update = "UPDATE data_buku SET judul_buku=?, genre_buku=?, penulis_buku=?, penerbit_buku=?, lokasi_buku=?, stok_buku=? WHERE id_buku=?";
    final String query_delete = "DELETE FROM data_buku WHERE id_buku=?";
    
    public DataBuku_DAO(){
        connection = Connector.connection();
    }

    @Override
    public void insert(DataBuku Buku) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(query_insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, Buku.getJudul_buku());
            statement.setString(2, Buku.getGenre_buku());
            statement.setString(3, Buku.getPenulis_buku());
            statement.setString(4, Buku.getPenerbit_buku());
            statement.setString(5, Buku.getLokasi_buku());
            statement.setInt(6, Buku.getStok_buku());
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                Buku.setId_buku(rs.getInt(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(DataBuku Buku) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(query_update);
            statement.setString(1, Buku.getJudul_buku());
            statement.setString(2, Buku.getGenre_buku());
            statement.setString(3, Buku.getPenulis_buku());
            statement.setString(4, Buku.getPenerbit_buku());
            statement.setString(5, Buku.getLokasi_buku());
            statement.setInt(6, Buku.getStok_buku());
            statement.setInt(7, Buku.getId_buku());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id_buku) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(query_delete);
            
            statement.setInt(1, id_buku);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataBuku> getAll() {
        List<DataBuku> data = null;
        
        try{
            data = new ArrayList<DataBuku>();
            Statement st = connection.createStatement();
            
            ResultSet rs = st.executeQuery(query_select);
            while(rs.next()){
                DataBuku buku = new DataBuku();
                buku.setId_buku(rs.getInt("id_buku"));
                buku.setJudul_buku(rs.getString("judul_buku"));
                buku.setGenre_buku(rs.getString("genre_buku"));
                buku.setPenulis_buku(rs.getString("penulis_buku"));
                buku.setPenerbit_buku(rs.getString("penerbit_buku"));
                buku.setLokasi_buku(rs.getString("lokasi_buku"));
                buku.setStok_buku(rs.getInt("stok_buku"));
                data.add(buku);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(DataBuku_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    //Ini buat di kategori biar kalo milih Judul nanti di query-nya bakal jadi judul_buku, begitu juga dengan Genre, Penulis, dan Penerbit
    private String getDatabaseColumn(String kategori) {
        switch(kategori) {
            case "Judul":
                return "judul_buku";
            case "Genre":
                return "genre_buku";
            case "Penulis":
                return "penulis_buku";
            case "Penerbit":
                return "penerbit_buku";
            default:
                return "";
        }
    }

    @Override
    public List<DataBuku> search(String kategori, String cari) {
        List<DataBuku> data = new ArrayList<>();
        String column = getDatabaseColumn(kategori);
        
        String query_select = "SELECT * FROM data_buku WHERE " + column + " LIKE ?";
        
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(query_select);
            statement.setString(1, "%" + cari + "%");
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                DataBuku Buku = new DataBuku();
                Buku.setId_buku(rs.getInt("id_buku"));
                Buku.setJudul_buku(rs.getString("judul_buku"));
                Buku.setGenre_buku(rs.getString("genre_buku"));
                Buku.setPenulis_buku(rs.getString("penulis_buku"));
                Buku.setPenerbit_buku(rs.getString("penerbit_buku"));
                Buku.setLokasi_buku(rs.getString("lokasi_buku"));
                Buku.setStok_buku(rs.getInt("stok_buku"));
                data.add(Buku);
            }
        }catch(SQLException ex){
            Logger.getLogger(DataBuku_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
