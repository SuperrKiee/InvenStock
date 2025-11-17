/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelmodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_Penjualan;

/**
 *
 * @author UsEr
 */
public class Tablemod_Penjualan extends AbstractTableModel{
    private List<Model_Penjualan> list = new ArrayList<>();
    
    public void tambahData (Model_Penjualan mod_keluar){
        list.add(mod_keluar);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    public void perbaruiData (int row, Model_Penjualan mod_keluar){
        list.add(row, mod_keluar);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
    }
    public void hapusData (int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    public void setData(List<Model_Penjualan>List){
        clear();
        this.list.addAll(List);
        fireTableDataChanged();
    }
    public void setData(int index, Model_Penjualan mod_keluar){
        list.set(index, mod_keluar);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Penjualan getData(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex){
           case 0 :return list.get(rowIndex).getId_penjualan();
           case 1 :return list.get(rowIndex).getTanggal();
           case 2 :return list.get(rowIndex).getTotal_harga();
           default:return null;
       } 
    }
    
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id Penjualan";
            case 1 : return "Tanggal Penjualan";
            case 2 : return "Total Penjualan";
            
            default:return null; 
        }
    
    }
    
}
