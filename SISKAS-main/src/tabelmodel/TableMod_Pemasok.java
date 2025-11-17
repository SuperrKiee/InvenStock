
package tabelmodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_Pemasok;

public class TableMod_Pemasok extends AbstractTableModel {
     private List<Model_Pemasok> list = new ArrayList<>();
     public void tambahData (Model_Pemasok mod_Pemasok){
        list.add(mod_Pemasok);
        fireTableRowsInserted(list.size() -1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
     }
     
      public void perbaruiData (int row, Model_Pemasok mod_pemasok){
         if (row >= 0 && row < list.size()) {
        list.set(row, mod_pemasok);
        fireTableRowsUpdated(row, row);
        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
    } else {
        JOptionPane.showMessageDialog(null, "Indeks baris tidak valid");
    }
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
    public void setData(List<Model_Pemasok> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, Model_Pemasok mod_pemasok){
        list.set(index, mod_pemasok);
        fireTableRowsUpdated(index, index);
    }
    public Model_Pemasok getData(int index){
        return list.get(index);
    }
 
    @Override
    public int getRowCount() {
        return list.size();
    }
    private final String[] columnnames = {"No", "Id Pemasok", "Nama Pemasok", "No Telepon", "Alamat"};

    @Override
    public int getColumnCount() {
        return columnnames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
        case 0: return "   " + (rowIndex + 1);  
        case 1: return list.get(rowIndex).getId_pemasok(); 
        case 2: return list.get(rowIndex).getNama_pemasok(); 
        case 3: return list.get(rowIndex).getNo_telp();  
        case 4: return list.get(rowIndex).getAlamat();  
        default: return null;
    }
    }   
       
        
    @Override
    public String getColumnName(int column) {
    if (column == 0) {
        return "No.";
    } else {
        return columnnames[column];
    }
    }
    
}
 