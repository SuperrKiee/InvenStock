/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelmodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_SemPenjualan;

/**
 *
 * @author UsEr
 */
public class Tablemod_SemPenjualan extends AbstractTableModel{
    private List<Model_SemPenjualan> list = new ArrayList<>();
    
    public void tambahData (Model_SemPenjualan Model_SemPenjualan){
        list.add(Model_SemPenjualan);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    public void perbaruiData (int row, Model_SemPenjualan Model_SemPenjualan){
        list.add(row, Model_SemPenjualan);
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
    public void setData(List<Model_SemPenjualan>List){
        clear();
        this.list.addAll(List);
        fireTableDataChanged();
    }
    public void setData(int index, Model_SemPenjualan Model_SemPenjualan){
        list.set(index, Model_SemPenjualan);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_SemPenjualan getData(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex){
           case 0 :return list.get(rowIndex).getMod_barang().getId_produk();
           case 1 :return list.get(rowIndex).getMod_barang().getNama_produk();
           case 2 :return list.get(rowIndex).getMod_barang().getHarga();
           case 3 :return list.get(rowIndex).getMod_detkeluar().getJumlah();
           case 4 :return list.get(rowIndex).getMod_detkeluar().getSub_total();       
           
           
           default:return null;
       } 
    }
    
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id Produk";
            case 1 : return "Nama Produk";
            case 2 : return "Harga";
            case 3: return "Jumlah";
            case 4 : return "Subtotal";
           
            default:return null; 
        }
    
    }
    
}
