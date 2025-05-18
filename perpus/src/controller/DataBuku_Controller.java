/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import DAO_DataBuku.DataBuku_DAO;
import DAO_Implement.DataBuku_Implement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.*;
import view.MainView;

/**
 *
 * @author User
 */
public class DataBuku_Controller {
    MainView form;
    DataBuku_Implement implement_dataBuku;
    List<DataBuku> data;
    
    public DataBuku_Controller(MainView form){
        this.form = form;
        implement_dataBuku = new DataBuku_DAO();
        data = implement_dataBuku.getAll();
    }
    
    public void isiTabel(){
        data = implement_dataBuku.getAll();
        ModelTabelDataBuku mt = new ModelTabelDataBuku(data);
        form.getTable_data().setModel(mt);
    }
    
    public void insert(){
        DataBuku Buku = new DataBuku();
        
        //Supaya gausa make or or or or
        JTextField[] dataBuku = {
            form.getjTextJUDUL(),
            form.getjTextGENRE(),
            form.getjTextPENULIS(),
            form.getjTextPENERBIT(),
            form.getjTextLOKASI(),
            form.getjTextSTOK()
        };
        
        for(JTextField input : dataBuku){
            if(input.getText().trim().isEmpty()){ //disini maksud saya
                JOptionPane.showMessageDialog(form, "Tolong Isi Semua Data!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        Buku.setJudul_buku(form.getjTextJUDUL().getText());
        Buku.setGenre_buku(form.getjTextGENRE().getText());
        Buku.setPenulis_buku(form.getjTextPENULIS().getText());
        Buku.setPenerbit_buku(form.getjTextPENERBIT().getText());
        Buku.setLokasi_buku(form.getjTextLOKASI().getText());
        
        try{
            int StokBuku = Integer.parseInt(form.getjTextSTOK().getText());
            Buku.setStok_buku(StokBuku);
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(form, "Stok harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        implement_dataBuku.insert(Buku);
    }
    
    public void update(){
        DataBuku Buku = new DataBuku();
        Buku.setJudul_buku(form.getjTextJUDUL().getText());
        Buku.setGenre_buku(form.getjTextGENRE().getText());
        Buku.setPenulis_buku(form.getjTextPENULIS().getText());
        Buku.setPenerbit_buku(form.getjTextPENERBIT().getText());
        Buku.setLokasi_buku(form.getjTextLOKASI().getText());
        
        try{
            int StokBuku = Integer.parseInt(form.getjTextSTOK().getText());
            Buku.setStok_buku(StokBuku);
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(form, "Stok harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        int IdBuku = Integer.parseInt(form.getjTextID().getText());
        Buku.setId_buku(IdBuku); 
        
        implement_dataBuku.update(Buku);
    }
    
    public void delete(){
        String id = form.getjTextID().getText().trim();
        
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(form, "Tolong Pilih Data yang Ingin Dihapus!"); //Supaya kalau engga milih salah satu data dan mencet button hapus ga muncul error
            return;
        }
        
        int id_buku = Integer.parseInt(form.getjTextID().getText());
        
        int confirm = JOptionPane.showConfirmDialog(form, "Yakin Ingin Menghapus Data Ini?");
        if(confirm == JOptionPane.YES_OPTION){
            implement_dataBuku.delete(id_buku);
            JOptionPane.showMessageDialog(form, "Data Berhasil Dihapus.");
        }
    }
    
    public void search(String kategori, String cari) {
        try {
            if (cari.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tolong Masukkan Kata Kunci!");
            } else {
                List<DataBuku> searched = implement_dataBuku.search(kategori, cari);

                ModelTabelDataBuku mt = new ModelTabelDataBuku(searched);
                form.getTable_data().setModel(mt); //Ini supaya tabel tetep muncul meskipun data yang dicari gaada

                if (searched.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data dengan Kata Kunci Tersebut Tidak Ada."); //baru munculin messagedialog
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Terdapat Kesalahan." + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
