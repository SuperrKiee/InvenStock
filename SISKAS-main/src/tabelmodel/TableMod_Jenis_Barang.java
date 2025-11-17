
package tabelmodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_Jenis_Barang;

public class TableMod_Jenis_Barang extends AbstractTableModel {
     private List<Model_Jenis_Barang> list = new ArrayList<>();
     public void tambahData (Model_Jenis_Barang mod_jenbar){
        list.add(mod_jenbar);
        fireTableRowsInserted(list.size() -1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
     }
      public void perbaruiData (int row, Model_Jenis_Barang mod_jenbar){
         list.set(row, mod_jenbar);
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
    public void setData(List<Model_Jenis_Barang> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData(int index, Model_Jenis_Barang mod_jenbar){
        list.set(index, mod_jenbar);
        fireTableRowsUpdated(index, index);
    }
    public Model_Jenis_Barang getData(int index){
        return list.get(index);
    }
 
    @Override
    public int getRowCount() {
        return list.size();
    }
    private final String[] columnnames = {"No", "Kode Jenis Barang", "Nama Jenis Barang"};

    @Override
    public int getColumnCount() {
        return columnnames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
        case 0: return "   " + (rowIndex + 1);  // Kolom "Nomor"
        case 1: return list.get(rowIndex).getId_kategori();  // Kolom "Kode Jenis Barang"
        case 2: return list.get(rowIndex).getNama_kategori();  // Kolom "Nama Jenis Barang"
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
 