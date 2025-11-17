/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dao.DAO_Pemasok;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import model.Model_Pemasok;
import service.Service_Pemasok;
import tabelmodel.TableMod_Pemasok;


/**
 *
 * @author UsEr
 */
public class Menu_Pemasok extends javax.swing.JPanel {
    private Service_Pemasok servis = new DAO_Pemasok();
    private TableMod_Pemasok tblModel = new TableMod_Pemasok();
    
       

    public Menu_Pemasok() {
        initComponents();
        setPreferredWidth();
        this.tbl_barang.setModel(tblModel);
        loadData();
        btn_tambah.setBackground(new Color(60,211,173));
        btn_hapus.setBackground(new Color(60,211,173));
        btn_batal.setBackground(new Color(60,211,173));
        btn_tambah1.setBackground(new Color(60,211,173));
        btn_batal1.setBackground(new Color(60,211,173));
//        btn_batal1.setBackground(new Color(60,211,173));
        //.setBackground(new Color(0,167,98));
        
        tbl_barang.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tbl_barang.getTableHeader().setForeground(Color.WHITE);
        tbl_barang.getTableHeader().setOpaque(false);
        tbl_barang.getTableHeader().setBackground(new Color(60,211,173));
        tbl_barang.setRowHeight(28);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        TampilanData = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_barang = new javax.swing.JTable();
        TambahData = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_tambah1 = new javax.swing.JButton();
        t_namapemasok = new javax.swing.JTextField();
        btn_batal1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        t_idDis = new javax.swing.JTextField();
        t_telpDis = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        t_alamatDis = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        TampilanData.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 167, 98));
        jLabel2.setText("Data Pemasok");

        btn_tambah.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tambah.png"))); // NOI18N
        btn_tambah.setText(" Tambah");
        btn_tambah.setBorder(null);
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hapus.png"))); // NOI18N
        btn_hapus.setText(" Hapus");
        btn_hapus.setBorder(null);
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_batal.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-cancel-30.png"))); // NOI18N
        btn_batal.setText("Batal");
        btn_batal.setBorder(null);
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        tbl_barang.setBackground(new java.awt.Color(255, 255, 255));
        tbl_barang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Kode Jenis Barang", "Nama Jenis Barang"
            }
        ));
        tbl_barang.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_barang.setRowHeight(35);
        tbl_barang.getTableHeader().setReorderingAllowed(false);
        tbl_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_barangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_barang);

        javax.swing.GroupLayout TampilanDataLayout = new javax.swing.GroupLayout(TampilanData);
        TampilanData.setLayout(TampilanDataLayout);
        TampilanDataLayout.setHorizontalGroup(
            TampilanDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TampilanDataLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(TampilanDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(TampilanDataLayout.createSequentialGroup()
                        .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        TampilanDataLayout.setVerticalGroup(
            TampilanDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TampilanDataLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(TampilanDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2)
                .addGap(30, 30, 30))
        );

        mainPanel.add(TampilanData, "card2");

        TambahData.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 167, 98));
        jLabel3.setText("Tambah Data Pemasok");

        btn_tambah1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btn_tambah1.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tambah.png"))); // NOI18N
        btn_tambah1.setText(" Tambah");
        btn_tambah1.setBorder(null);
        btn_tambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah1ActionPerformed(evt);
            }
        });

        t_namapemasok.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        t_namapemasok.setForeground(new java.awt.Color(0, 0, 0));
        t_namapemasok.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        t_namapemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_namapemasokActionPerformed(evt);
            }
        });

        btn_batal1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btn_batal1.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-cancel-30.png"))); // NOI18N
        btn_batal1.setText("Batal");
        btn_batal1.setBorder(null);
        btn_batal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Id Pemasok");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nama Pemasok");

        t_idDis.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        t_idDis.setForeground(new java.awt.Color(0, 0, 0));
        t_idDis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        t_idDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_idDisActionPerformed(evt);
            }
        });

        t_telpDis.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        t_telpDis.setForeground(new java.awt.Color(0, 0, 0));
        t_telpDis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        t_telpDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_telpDisActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Telepon");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Alamat");

        t_alamatDis.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        t_alamatDis.setForeground(new java.awt.Color(0, 0, 0));
        t_alamatDis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        t_alamatDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_alamatDisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TambahDataLayout = new javax.swing.GroupLayout(TambahData);
        TambahData.setLayout(TambahDataLayout);
        TambahDataLayout.setHorizontalGroup(
            TambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahDataLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(TambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addGroup(TambahDataLayout.createSequentialGroup()
                        .addComponent(btn_tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_batal1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(t_namapemasok, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                    .addComponent(t_idDis)
                    .addComponent(t_telpDis)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(t_alamatDis))
                .addGap(30, 30, 30))
        );
        TambahDataLayout.setVerticalGroup(
            TambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahDataLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(TambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(t_idDis, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addGap(15, 15, 15)
                .addComponent(t_namapemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addGap(15, 15, 15)
                .addComponent(t_telpDis, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addGap(15, 15, 15)
                .addComponent(t_alamatDis, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        mainPanel.add(TambahData, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(TambahData);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        btn_tambah1.setText("SIMPAN");
        t_idDis.setText(servis.nomor());
        t_idDis.setEnabled(false);
        
        if(btn_tambah.getText().equals("UBAH")){
            dataTabel(); 
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        hapusData();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        tampilPanel();
        loadData();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah1ActionPerformed
        if(btn_tambah1.getText().equals("TAMBAH"))
        {
            btn_tambah1.setText("SIMPAN");
            t_idDis.setText(servis.nomor());
            
        }else if (btn_tambah1.getText().equals("SIMPAN"))
        
        {
            simpanData();
            
        }
        else if (btn_tambah1.getText().equals("PERBARUI"))
        {
            perbaruiData(); 
        }
    }//GEN-LAST:event_btn_tambah1ActionPerformed

    private void btn_batal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal1ActionPerformed
        tampilPanel();
        loadData();
        resetForm();
    }//GEN-LAST:event_btn_batal1ActionPerformed

    private void tbl_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_barangMouseClicked
        if(btn_tambah.getText().equals("TAMBAH")){
           
        }
        btn_tambah.setText("UBAH");
        btn_hapus.setVisible(true);
        btn_batal.setVisible(true);
    }//GEN-LAST:event_tbl_barangMouseClicked

    private void t_namapemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_namapemasokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_namapemasokActionPerformed

    private void t_idDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_idDisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_idDisActionPerformed

    private void t_telpDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_telpDisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_telpDisActionPerformed

    private void t_alamatDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_alamatDisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_alamatDisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TambahData;
    private javax.swing.JPanel TampilanData;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_batal1;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_tambah1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField t_alamatDis;
    private javax.swing.JTextField t_idDis;
    private javax.swing.JTextField t_namapemasok;
    private javax.swing.JTextField t_telpDis;
    private javax.swing.JTable tbl_barang;
    // End of variables declaration//GEN-END:variables

    private void dataTabel() {
        TampilanData.setVisible(false);
        TambahData.setVisible(true);
        
        int row = tbl_barang.getSelectedRow();
        jLabel2.setText("Perbarui Data Jenis Barang");
        
        t_idDis.setEnabled(false);
        t_namapemasok.setEnabled(true);
        t_alamatDis.setEnabled(true);
        t_telpDis.setEnabled(true);
        
        
        t_idDis.setText(tbl_barang.getModel().getValueAt(row, 1).toString());
        t_namapemasok.setText(tbl_barang.getModel().getValueAt(row, 2).toString());
        t_alamatDis.setText(tbl_barang.getModel().getValueAt(row, 3).toString());
        t_telpDis.setText(tbl_barang.getModel().getValueAt(row, 4).toString());
     
        btn_tambah1.setText("PERBARUI");
        btn_batal.setVisible(true);
    }

    private void hapusData() {
        int index = tbl_barang.getSelectedRow();
        if(index !=-1){
            Model_Pemasok model = tblModel.getData(tbl_barang.convertRowIndexToModel(index));
            if(JOptionPane.showConfirmDialog(null, "Yakin data akan dihapus?", "Konfirmasi",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                servis.hapusData(model);
                tblModel.hapusData(index);
                loadData();
                resetForm();
            }   
        }else{
            JOptionPane.showMessageDialog(null, "Pilih dulu record yang akan diupdate");
        }
    }

    private void tampilPanel() {
         mainPanel.removeAll();
       mainPanel.add(new Menu_Pemasok());
       mainPanel.repaint();
       mainPanel.revalidate();
    }

    private void loadData() {
        btn_hapus.setVisible(false);
        btn_batal.setVisible(false);
        List<Model_Pemasok> list = servis.getData();
        tblModel.setData(list);
        setPreferredWidth(); 
        tbl_barang.revalidate();  
        tbl_barang.repaint();  
    }

    private void simpanData() {
        if (validasiInput()==true) {
                
            String ID = t_idDis.getText();
            String nama_pem = t_namapemasok.getText();
            String telp_pem = t_telpDis.getText();
            String alamat = t_alamatDis.getText();



            Model_Pemasok model = new Model_Pemasok();
            model.setId_pemasok(ID);
            model.setNama_pemasok(nama_pem);
            model.setNo_telp(telp_pem);
            model.setAlamat(alamat);    

            servis.tambahData(model);
            tblModel.tambahData(model);
                
            tampilPanel();
            loadData();
            resetForm();
            btn_tambah.setText("TAMBAH");
        } 
    }

    private void perbaruiData() {
        int index = tbl_barang.getSelectedRow();
        if(index!=-1){
            Model_Pemasok model_Pemasok = tblModel.getData(tbl_barang.convertRowIndexToModel(index));
            if (validasiInput()==true) {
                
                String ID = t_idDis.getText();
                String nama_pem = t_namapemasok.getText();
                String telp_pem = t_telpDis.getText();
                String alamat = t_alamatDis.getText();



                Model_Pemasok model = new Model_Pemasok();
                model.setId_pemasok(ID);
                model.setNama_pemasok(nama_pem);
                model.setNo_telp(telp_pem);
                model.setAlamat(alamat);    

                servis.tambahData(model);
                tblModel.tambahData(model);

                tampilPanel();
                loadData();
                resetForm();
//                btn_tambah.setText("TAMBAH");
            }                   
        }
    }

    private void resetForm() {
        btn_tambah.requestFocus();
        btn_tambah.setText("TAMBAH");
        t_idDis.setText("");
        t_namapemasok.setText("");
        
    }

    private boolean setPreferredWidth() {
        if (tbl_barang.getColumnCount() > 0) {
            tbl_barang.getColumnModel().getColumn(0).setPreferredWidth(20);
            tbl_barang.getColumnModel().getColumn(1).setPreferredWidth(269);
            tbl_barang.getColumnModel().getColumn(2).setPreferredWidth(269);
        }
         return false;
    }
  

    private boolean validasiInput() {
        boolean valid = false;
    if (t_idDis.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "ID Pemasok Tidak Boleh Kosong");
    } else if (t_namapemasok.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nama Pemasok Tidak Boleh Kosong");
    } else if (t_telpDis.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nomer Telepon Tidak Boleh Kosong");
    } else if (t_alamatDis.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Alamat Tidak Boleh Kosong");
    }
    else {
        valid = true;
    }
    return valid;
        
        
    }
    
    
}
