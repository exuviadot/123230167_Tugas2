/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabelDataBuku extends AbstractTableModel{

    List<DataBuku> data;
    public ModelTabelDataBuku(List<DataBuku>data){
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 7; //Karena kolom yang mau ditampilin di tabel ada 7
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "JUDUL";
            case 2:
                return "GENRE";
            case 3:
                return "PENULIS";
            case 4:
                return "PENERBIT";
            case 5:
                return "LOKASI";
            case 6:
                return "STOK";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return data.get(row).getId_buku();
            case 1:
                return data.get(row).getJudul_buku();
            case 2:
                return data.get(row).getGenre_buku();
            case 3:
                return data.get(row).getPenulis_buku();
            case 4:
                return data.get(row).getPenerbit_buku();
            case 5:
                return data.get(row).getLokasi_buku();
            case 6:
                return data.get(row).getStok_buku();
            default:
                return null;
        }
    }
    
}
