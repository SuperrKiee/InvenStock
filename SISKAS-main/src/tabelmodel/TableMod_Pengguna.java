
package tabelmodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_Pengguna;

public class TableMod_Pengguna extends AbstractTableModel {
    
     private List<Model_Pengguna> list = new ArrayList<>();
     
      public Model_Pengguna getData(int index){
        return list.get(index);
    }
      
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    public void setData(List<Model_Pengguna> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
     public void insertData (Model_Pengguna model_Pengguna){
        list.add(model_Pengguna);
        fireTableRowsInserted(list.size() -1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
     }
     
      public void updateData (int row, Model_Pengguna model){
        list.set(row, model);
        fireTableDataChanged();
       JOptionPane.showMessageDialog(null, "Data Berhasil Di Perbarui");
        
    }
      
    public void deleteData (int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }
    private final String[] columnnames = {"ID", "Nama Karyawan", "USername", "Telepon", "Alamat", "Role"};
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    

    @Override
    public int getColumnCount() {
        return columnnames.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Model_Pengguna model = list.get(rowIndex);
        switch (columnIndex){
            case 0:
                return model.getId_pengguna();
            case 1:
                return model.getNama_pengguna();
            case 2:
                return model.getUsername();
            case 3:
                return model.getTelepon();
            case 4:
                return model.getAlamat();
            case 5:
                return model.getRole();
            default:
                return null;
                
        }    
    }       
}

    
    

 