/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_Implement;

import java.util.List;
import model.*;

/**
 *
 * @author User
 */
public interface DataBuku_Implement {
    public void insert(DataBuku Buku);
    public void update(DataBuku Buku);
    public void delete(int id_buku);
    public List<DataBuku> getAll();
    public List<DataBuku> search(String kategori, String cari);
}
