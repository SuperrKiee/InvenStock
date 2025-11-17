package view;

import view.DashboardForm;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import config.KoneksiDB; // koneksi dari package config
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.BorderStyle;

//Document
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Laporan extends javax.swing.JFrame {
    private JTable tableLaporan;
    private DefaultTableModel tableModel;
    
    // Ganti JDateChooser menjadi JTextField
    private JTextField txtTanggalMulai;
    private JTextField txtTanggalSelesai;
    
    private JComboBox<String> comboJenisTransaksi;
    private JButton btnTerapkan;
    private JButton btnExport;
    private JButton btnCetak;
    // --- AKHIR VARIABEL KOMPONEN ---
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Laporan.class.getName());


    public Laporan() {
// --- MULAI KODE MANUAL ---
        
        setTitle("Laporan Transaksi Masuk & Keluar");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Penting!

        Container contentPane = getContentPane();
        // Hapus setBackground(Color.WHITE) karena Nimbus akan mengaturnya
        contentPane.setLayout(new BorderLayout(10, 10)); 
        ((JPanel) contentPane).setBorder(new EmptyBorder(15, 20, 15, 20));

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS)); 
        // Hapus setBackground(Color.WHITE)
        panelTop.setOpaque(false); // Biarkan L&F Nimbus yang mengatur background

        JLabel lblJudul = new JLabel("Laporan Transaksi Masuk & Keluar");
        lblJudul.setFont(new Font("Segoe UI", Font.BOLD, 24));
        // Hapus setForeground() agar mengikuti L&F
        lblJudul.setBorder(new EmptyBorder(0, 0, 10, 0)); 
        lblJudul.setAlignmentX(Component.LEFT_ALIGNMENT); 
        panelTop.add(lblJudul);
        
        JPanel panelFilter = createFilterPanel();
        panelFilter.setAlignmentX(Component.LEFT_ALIGNMENT); 
        panelTop.add(panelFilter);

        contentPane.add(panelTop, BorderLayout.NORTH);

        JScrollPane scrollPane = createTablePanel();
        contentPane.add(scrollPane, BorderLayout.CENTER); 
        
        // Jadikan tombol Terapkan sebagai tombol default (enter)
        this.getRootPane().setDefaultButton(btnTerapkan);
        
        mulaiMuatData();
        
        setLocationRelativeTo(null);
        // --- AKHIR KODE MANUAL ---
    }
    
    // --- HELPER METHOD ---

    /**
     * Membuat panel filter.
     */
    private JPanel createFilterPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panel.setOpaque(false); // Biarkan L&F Nimbus yang mengatur background
        
        Dimension dateFieldSize = new Dimension(120, 28);
        Dimension comboSize = new Dimension(150, 28);
        
        // Format tanggal default
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tglHariIni = sdf.format(new Date());

        // Ganti JDateChooser ke JTextField
        panel.add(new JLabel("Dari (YYYY-MM-DD):"));
        txtTanggalMulai = new JTextField(tglHariIni); 
        txtTanggalMulai.setPreferredSize(dateFieldSize);
        panel.add(txtTanggalMulai);

        panel.add(new JLabel("Sampai (YYYY-MM-DD):"));
        txtTanggalSelesai = new JTextField(tglHariIni); 
        txtTanggalSelesai.setPreferredSize(dateFieldSize);
        panel.add(txtTanggalSelesai);

        panel.add(new JLabel("Jenis:"));
        String[] jenis = {"Semua", "Barang Masuk", "Barang Keluar"};
        comboJenisTransaksi = new JComboBox<>(jenis);
        comboJenisTransaksi.setPreferredSize(comboSize);
        panel.add(comboJenisTransaksi);

        btnTerapkan = new JButton("Terapkan");
        // Hapus properti FlatLaf
        // btnTerapkan.putClientProperty("JButton.buttonType", "primary");
        
        panel.add(btnTerapkan);
        
        btnExport = new JButton("Export Excel");
        panel.add(btnExport);

        btnCetak = new JButton("Cetak");
        panel.add(btnCetak);
        
        JButton btnKembali = new JButton("Kembali");

        btnTerapkan.addActionListener(e -> mulaiMuatData());

        btnExport.addActionListener(e -> exportKeExcel());

        btnKembali.addActionListener(e -> {
        new DashboardForm().setVisible(true);
        dispose(); 
        });
        
        return panel;
    }


    private JScrollPane createTablePanel() {
        String[] columnNames = {"ID Transaksi", "Tanggal", "Nama Barang", "Jenis", "Jumlah", "Harga Modal", "Harga Jual", "Subtotal"};
        
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableLaporan = new JTable(tableModel);
        tableLaporan.setFillsViewportHeight(true);
        tableLaporan.setRowHeight(25); // Ketinggian baris
        tableLaporan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tableLaporan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Kustomisasi header agar tetap terlihat bagus di Nimbus
        JTableHeader header = tableLaporan.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        // Hapus pengaturan warna agar Nimbus yang mengatur
        // header.setBackground(new Color(236, 240, 241)); 
        // header.setForeground(new Color(44, 62, 80)); 

        JScrollPane scrollPane = new JScrollPane(tableLaporan);
        return scrollPane;
    }

    private void exportKeExcel() {
    // 1. Buat Workbook (file Excel) baru
    Workbook workbook = new XSSFWorkbook();

    // 2. Buat Sheet (lembar kerja) baru di dalam workbook
    Sheet sheet = workbook.createSheet("DataBarang");

    // 3. Buat Baris Header (Judul Kolom)
    Row headerRow = sheet.createRow(0);

    // Ambil nama kolom dari tableModel Anda
    for (int col = 0; col < tableModel.getColumnCount(); col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(tableModel.getColumnName(col));
        
        // (Opsional) Beri style pada header
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerRow.getCell(col).setCellStyle(headerStyle);
    }

    // 4. Masukkan Data dari JTable ke Sheet
    for (int row = 0; row < tableModel.getRowCount(); row++) {
        Row dataRow = sheet.createRow(row + 1); // Mulai dari baris ke-1

        for (int col = 0; col < tableModel.getColumnCount(); col++) {
            Object value = tableModel.getValueAt(row, col);
            Cell cell = dataRow.createCell(col);

            // Set nilai cell berdasarkan tipe datanya
            if (value instanceof String) {
                cell.setCellValue((String) value);
            } else if (value instanceof Integer) {
                cell.setCellValue((Integer) value);
            } else if (value instanceof Double) {
                cell.setCellValue((Double) value);
            } else if (value instanceof Long) {
                cell.setCellValue((Long) value);
            } else if (value != null) {
                cell.setCellValue(value.toString());
            }
        }
    }
    
    // (Opsional) Auto-size semua kolom
    for (int col = 0; col < tableModel.getColumnCount(); col++) {
        sheet.autoSizeColumn(col);
    }

    // 5. Tampilkan dialog "Save File"
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Simpan Laporan Excel");
    fileChooser.setFileFilter(new FileNameExtensionFilter("File Excel (*.xlsx)", "xlsx"));
    
    int userSelection = fileChooser.showSaveDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        
        // Pastikan file memiliki ekstensi .xlsx
        String filePath = fileToSave.getAbsolutePath();
        if (!filePath.endsWith(".xlsx")) {
            fileToSave = new File(filePath + ".xlsx");
        }

        // 6. Tulis Workbook ke File
        try (FileOutputStream outputStream = new FileOutputStream(fileToSave)) {
            workbook.write(outputStream);
            workbook.close();
            
            JOptionPane.showMessageDialog(this,
                "Laporan berhasil diekspor ke:\n" + fileToSave.getAbsolutePath(),
                "Ekspor Berhasil",
                JOptionPane.INFORMATION_MESSAGE);
                
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Gagal menyimpan file: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            }
        }
    }    
    
    private void mulaiMuatData(){
        if (txtTanggalMulai == null || tableModel == null) {
            return; 
        }
        
        // Ambil data dari JTextField
        String tglMulai = txtTanggalMulai.getText();
        String tglSelesai = txtTanggalSelesai.getText();
        String jenis = (String) comboJenisTransaksi.getSelectedItem();
        
        // Validasi sederhana (bisa Anda kembangkan)
        if (tglMulai.isEmpty() || tglSelesai.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Format tanggal tidak boleh kosong. Harap isi (YYYY-MM-DD).", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        btnTerapkan.setEnabled(false);
        btnTerapkan.setText("Memuat...");
        btnExport.setEnabled(false);
        btnCetak.setEnabled(false);
        
        tableModel.setRowCount(0); 
        
        // Kirim filter (sebagai String) ke Worker
        DataWorker worker = new DataWorker(tglMulai, tglSelesai, jenis);
        worker.execute();
    }
    

    class DataWorker extends SwingWorker<List<Object[]>, Void> {
        
        // Menerima tanggal sebagai String
        private final String tglMulai;
        private final String tglSelesai;
        private final String jenis;

        DataWorker(String tglMulai, String tglSelesai, String jenis) {
            this.tglMulai = tglMulai;
            this.tglSelesai = tglSelesai;
            this.jenis = jenis;
        }


        @Override
    protected List<Object[]> doInBackground() throws Exception {
    logger.info("Memuat data dari " + tglMulai + " sampai " + tglSelesai);

    List<Object[]> hasil = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    try (Connection conn = config.KoneksiDB.getKoneksi()) {

        // ========== TRANSAKSI MASUK ==========
        if (jenis.equals("Semua") || jenis.equals("Barang Masuk")) {
            String sqlMasuk = """
                SELECT tm.id_masuk AS id_transaksi,
                       tm.tanggal_masuk AS tanggal,
                       b.nama_barang,
                       'Barang Masuk' AS jenis,
                       tm.jumlah,
                       tm.harga_beli AS harga_modal,
                       0 AS harga_jual,
                       (tm.jumlah * tm.harga_beli) AS subtotal
                FROM transaksi_masuk tm
                JOIN barang b ON tm.id_barang = b.id_barang
                WHERE DATE(tm.tanggal_masuk) BETWEEN ? AND ?
            """;

            try (PreparedStatement ps = conn.prepareStatement(sqlMasuk)) {
                ps.setString(1, tglMulai);
                ps.setString(2, tglSelesai);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    hasil.add(new Object[]{
                        rs.getString("id_transaksi"),
                        rs.getString("tanggal"),
                        rs.getString("nama_barang"),
                        rs.getString("jenis"),
                        rs.getInt("jumlah"),
                        rs.getDouble("harga_modal"),
                        rs.getDouble("harga_jual"),
                        rs.getDouble("subtotal")
                    });
                }
            }
        }

        // ========== TRANSAKSI KELUAR ==========
        if (jenis.equals("Semua") || jenis.equals("Barang Keluar")) {
            String sqlKeluar = """
                SELECT tk.id_keluar AS id_transaksi,
                       tk.tanggal_keluar AS tanggal,
                       b.nama_barang,
                       'Barang Keluar' AS jenis,
                       tk.jumlah,
                       0 AS harga_modal,
                       tk.harga_jual,
                       (tk.jumlah * tk.harga_jual) AS subtotal
                FROM transaksi_keluar tk
                JOIN barang b ON tk.id_barang = b.id_barang
                WHERE DATE(tk.tanggal_keluar) BETWEEN ? AND ?
            """;

            try (PreparedStatement ps = conn.prepareStatement(sqlKeluar)) {
                ps.setString(1, tglMulai);
                ps.setString(2, tglSelesai);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    hasil.add(new Object[]{
                        rs.getString("id_transaksi"),
                        rs.getString("tanggal"),
                        rs.getString("nama_barang"),
                        rs.getString("jenis"),
                        rs.getInt("jumlah"),
                        rs.getDouble("harga_modal"),
                        rs.getDouble("harga_jual"),
                        rs.getDouble("subtotal")
                    });
                }
            }
        }

    } catch (SQLException e) {
        logger.severe("Error saat mengambil data dari database: " + e.getMessage());
        JOptionPane.showMessageDialog(null,
            "Terjadi kesalahan saat mengambil data dari database:\n" + e.getMessage(),
            "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    return hasil;
}


        @Override
    protected void done() {
        try {
            List<Object[]> hasil = get();
            tableModel.setRowCount(0);

            // --- Format angka dengan ribuan (10.000, 5.500, dll) ---
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator('.');
            symbols.setDecimalSeparator(',');
            DecimalFormat df = new DecimalFormat("#,##0", symbols);

            for (Object[] row : hasil) {
                String hargaModal = df.format((double) row[5]);
                String hargaJual = df.format((double) row[6]);
                String subtotal = df.format((double) row[7]);

                tableModel.addRow(new Object[]{
                    row[0], // ID
                    row[1], // Tanggal
                    row[2], // Nama Barang
                    row[3], // Jenis
                    row[4], // Jumlah
                    hargaModal,
                    hargaJual,
                    subtotal
                });
            }

            logger.info("Pemuatan data selesai, " + hasil.size() + " baris ditambahkan.");
        } catch (InterruptedException | ExecutionException e) {
            logger.severe("Error saat memuat data: " + e.getMessage());
            JOptionPane.showMessageDialog(Laporan.this,
                "Gagal memuat data: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            btnTerapkan.setEnabled(true);
            btnTerapkan.setText("Terapkan");
            btnExport.setEnabled(true);
            btnCetak.setEnabled(true);
            }
        }
    }
    
    // --- AKHIR DARI OPTIMISASI ---
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Laporan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
