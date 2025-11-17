/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelmodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_Detai_penjualan;

/**
 *
 * @author UsEr
 */
public class Tablemod_DetPenjualan extends AbstractTableModel{
    private List<Model_Detai_penjualan> list = new ArrayList<>();
    
    public void tambahData (Model_Detai_penjualan mod_detkeluar){
        list.add(mod_detkeluar);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    public void perbaruiData (int row, Model_Detai_penjualan mod_detkeluar){
        list.add(row, mod_detkeluar);
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
    public void setData(List<Model_Detai_penjualan>List){
        clear();
        this.list.addAll(List);
        fireTableDataChanged();
    }
    public void setData(int index, Model_Detai_penjualan mod_detkeluar){
        list.set(index, mod_detkeluar);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Detai_penjualan getData(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex){
           case 0 :return list.get(rowIndex).getMod_keluar().getId_penjualan();
           case 1 :return list.get(rowIndex).getMod_barang().getId_produk();
           case 2 :return list.get(rowIndex).getMod_barang().getNama_produk();
           case 3 :return list.get(rowIndex).getMod_barang().getHarga();
           case 4 :return list.get(rowIndex).getJumlah();
           case 5 :return list.get(rowIndex).getSub_total();
           
           
           
           default:return null;
       } 
    }
    
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id Penjualan";
            case 1 : return "Id Produk";
            case 2 : return "Nama Produk";
            case 3: return "Harga";
            case 4 : return "Jumlah";
            case 5 : return "Subtotal";
            
            default:return null; 
        }
    
    }
    
}
