package view;

import view.Laporan;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JLabel;

// --- IMPOR BARU UNTUK DATABASE 
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

// --- IMPORT FOTO ---

// --- IMPOR BARU UNTUK DATABASE ---
import config.KoneksiDB; // 





public class DashboardForm extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JPanel navPanel;
    private javax.swing.table.TableRowSorter<DefaultTableModel> sorter; 
    private JTextField searchField;
    // Warna tema
    private Color sidebarBgColor = new Color(34, 40, 49);     // Dark Grey Blue (hampir hitam)
    private Color menuHoverColor = new Color(57, 62, 70);     // Medium Grey
    private Color menuSelectedColor = new Color(0, 173, 181);  // Teal (Aksen Cerah)
    private Color contentBgColor = new Color(235, 235, 235);  // Abu-abu muda (BG utama)
    private Color headerBgColor = new Color(245, 245, 245);
    //private Color headerBgColor = Color.WHITE;
    private Color originalBg; // Dihapus karena logika hover/select di-handle di createMenuItem
    private JButton logoutButton;


    public DashboardForm() {
        setTitle("Dashboard Manajemen InvenStock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- Panel Utama (Content Pane) ---
        JPanel mainContentPane = (JPanel) getContentPane();
        mainContentPane.setLayout(new BorderLayout());
        mainContentPane.setBackground(contentBgColor); // Background utama putih

        // --- Left Sidebar (WEST) ---
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BorderLayout());
        sidebarPanel.setBackground(sidebarBgColor);
        sidebarPanel.setPreferredSize(new Dimension(250, getHeight())); // Lebar sidebar
        // mainContentPane.add(sidebarPanel, BorderLayout.WEST); // Akan ditambahkan nanti setelah semua bagian sidebar siap

        // --- Logo Area di Sidebar (NORTH) ---
        JPanel logoPanel = new JPanel(new GridBagLayout()); // Menggunakan GridBagLayout untuk centering
        logoPanel.setBackground(sidebarBgColor);
        logoPanel.setBorder(new EmptyBorder(20, 0, 20, 0)); // Padding atas-bawah
        JLabel logoLabel = new JLabel("InvenStock", SwingConstants.CENTER);
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        logoPanel.add(logoLabel); // Tambahkan logo ke panel logo
        sidebarPanel.add(logoPanel, BorderLayout.NORTH);

        // --- Navigation Menu in Sidebar (CENTER) ---
        navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS)); // Susun menu secara vertikal
        navPanel.setBackground(sidebarBgColor);
        navPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        // Tambahkan Menu Items
        navPanel.add(createMenuItem("DASHBOARDS", null, true)); // Header
        navPanel.add(createMenuItem("Overview", "dashboard", false)); // Default selected
        navPanel.add(createMenuItem("Manajemen Stok", "stock", false));
        navPanel.add(createMenuItem("Laporan", "report", false));
      
        navPanel.add(createMenuItem("ADMINISTRATOR", null, true)); // Header
        navPanel.add(createMenuItem("Pengguna", "users", false));
        navPanel.add(createMenuItem("Pengaturan", "settings", false));

        navPanel.add(Box.createVerticalGlue()); // Untuk mendorong item logout ke bawah

        navPanel.add(createMenuItem("Log Out", "logout", false));
        
        sidebarPanel.add(navPanel, BorderLayout.CENTER);

        // --- Content Area (CENTER) ---
        JPanel contentArea = new JPanel();
        contentArea.setLayout(new BorderLayout());
        contentArea.setBackground(contentBgColor);

        // --- Header Content Area (NORTH of contentArea) ---
        JPanel headerContentPanel = new JPanel(new BorderLayout());
        headerContentPanel.setBackground(headerBgColor);
        headerContentPanel.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel headerTitleLabel = new JLabel("Manajemen Stok Barang");
        headerTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22)); // Font lebih modern
        headerTitleLabel.setForeground(new Color(34, 40, 49)); // Warna teks gelap

        headerContentPanel.add(headerTitleLabel, BorderLayout.WEST);
        
        try {
            // 1. Di header
            int photoSize = 40; // Ukuran 40x40 pixel

            // 2. Lokasi Gambar
            java.net.URL imgUrl = getClass().getResource("/resources/Users.png");
            if (imgUrl == null) {
                throw new IOException("File gambar tidak ditemukan: /Users.png");
            }
            BufferedImage originalImage = ImageIO.read(imgUrl);

            // 3. Ukuran
            Image scaledImage = originalImage.getScaledInstance(photoSize, photoSize, Image.SCALE_SMOOTH);
            
            // 4. Buat JLabel untuk FOTO
            ImageIcon profileIcon = new ImageIcon(scaledImage);
            JLabel profileLabel = new JLabel(profileIcon);
            
            // 5. BARU: Buat JLabel untuk TEKS "Hello, Admin"
            JLabel welcomeLabel = new JLabel("Hello, Admin");
            welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Font lebih besar
            welcomeLabel.setForeground(new Color(34, 40, 49)); // Warna teks gelap
            // Beri jarak 10px antara foto dan teks
            welcomeLabel.setBorder(new EmptyBorder(0, 10, 0, 0)); 

            // 6. BARU: Buat Panel Container untuk FOTO + TEKS
            // Gunakan FlowLayout.RIGHT agar isinya (foto, teks) menempel di kanan
            JPanel userProfilePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
            userProfilePanel.setOpaque(false); // BUAT TRANSPARAN!
            
            // 7. Masukkan foto dan teks ke panel container
            userProfilePanel.add(profileLabel); // Foto dulu
            userProfilePanel.add(welcomeLabel); // Teks di kanannya

            // 8. DIUBAH: Tambahkan userProfilePanel (bukan hanya profileLabel) ke header
            headerContentPanel.add(userProfilePanel, BorderLayout.EAST);

        } catch (IOException e) {
            e.printStackTrace();
            JLabel welcomeLabelError = new JLabel("Hello, Admin");
            welcomeLabelError.setFont(new Font("Segoe UI", Font.BOLD, 16));
            welcomeLabelError.setForeground(new Color(34, 40, 49));
            headerContentPanel.add(welcomeLabelError, BorderLayout.EAST);
        }
        
        contentArea.add(headerContentPanel, BorderLayout.NORTH);

        // --- Main Content Panel (CENTER of contentArea) ---
        JPanel mainContentPanel = new JPanel(new BorderLayout());
        mainContentPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Padding di sekitar konten
        mainContentPanel.setBackground(contentBgColor);

        // --- Panel Kontrol Tombol Aksi (di atas tabel) ---
        JPanel actionButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5)); // Spasi antar tombol
        actionButtonPanel.setOpaque(false); // Transparan
        
        JButton addButton = new JButton("Tambah Barang");
        JButton editButton = new JButton("Edit Barang");
        JButton deleteButton = new JButton("Hapus Barang");
        JButton refreshButton = new JButton("Refresh Data"); // Tambah tombol refresh
        
        actionButtonPanel.add(addButton);
        actionButtonPanel.add(editButton);
        actionButtonPanel.add(deleteButton);
        actionButtonPanel.add(refreshButton);
        
        styleButton(addButton);
        styleButton(editButton);
        styleButton(deleteButton);
        styleButton(refreshButton);
        
        actionButtonPanel.add(Box.createHorizontalStrut(30)); // Memberi jarak
        actionButtonPanel.add(new JLabel("Cari Data:"));
        searchField = new JTextField(25); // Inisialisasi searchField (lebar 25 char)
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchField.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(200, 200, 200)),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        actionButtonPanel.add(searchField);
        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            applyFilter();
        }
        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            applyFilter();
        }
        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            applyFilter();
        }
    });
        

        // --- Tabel Data ---
        String[] columnNames = {"ID Barang", "Nama Barang", "Stok", "Harga Modal (Rp)", "Harga Jual (Rp)"};
        
        tableModel = new DefaultTableModel(columnNames, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Membuat sel tidak bisa diedit
                    }
                };
                sorter = new javax.swing.table.TableRowSorter<>(tableModel);

                table = new JTable(tableModel);
                // 1. Buat Number Formatter untuk format Indonesia (misal: 10.000)
                DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("id", "ID"));
                symbols.setGroupingSeparator('.'); // Titik sebagai pemisah ribuan
                final DecimalFormat formatter = new DecimalFormat("#,###", symbols);

                // 2. Buat Custom Renderer
                DefaultTableCellRenderer numberRenderer = new DefaultTableCellRenderer() {
                    @Override
                    public void setValue(Object value) {
                        // Cek jika nilainya adalah angka (Integer, Double, Long, dll)
                        if (value instanceof Number) {
                            // Format angka tersebut
                            setText(formatter.format(value));
                        } else {
                            // Jika bukan angka (misal String), biarkan apa adanya
                            super.setValue(value);
                        }
                        // Selalu buat angka rata kanan
                        setHorizontalAlignment(JLabel.RIGHT);
                    }
                };

                // 3. Terapkan Renderer ini ke kolom yang berisi angka
                // Kolom 2 = "Stok"
                table.getColumnModel().getColumn(2).setCellRenderer(numberRenderer);
                // Kolom 3 = "Harga Modal (Rp)"
                table.getColumnModel().getColumn(3).setCellRenderer(numberRenderer);
                // Kolom 4 = "Harga Jual (Rp)"
                table.getColumnModel().getColumn(4).setCellRenderer(numberRenderer);
        table.setRowSorter(sorter);
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(30); // <--- Tinggi baris 30 (lebih lega)
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(Color.WHITE); 
        table.getTableHeader().setForeground(new Color(34, 40, 49)); 
        table.getTableHeader().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        table.setGridColor(new Color(230, 230, 230));
        table.setBackground(Color.WHITE);
        

        // === MEMANGGIL DATA DARI DATABASE ===
        loadData(); 

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); // Border scroll pane

        mainContentPanel.add(actionButtonPanel, BorderLayout.NORTH);
        mainContentPanel.add(scrollPane, BorderLayout.CENTER);

        contentArea.add(mainContentPanel, BorderLayout.CENTER);

        // --- Gabungkan Sidebar dan Content Area ke mainContentPane ---
        mainContentPane.add(sidebarPanel, BorderLayout.WEST);
        mainContentPane.add(contentArea, BorderLayout.CENTER);

        // --- Tambahkan Aksi Tombol ---
        tambahkanAksiTombol(addButton, editButton, deleteButton, refreshButton, logoutButton);
    }
    
    private void styleButton(JButton button) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(Color.WHITE); // Latar belakang PUTIH
        button.setForeground(new Color(0, 173, 181)); // Teks TEAL
        
        button.setOpaque(true); // Tetap diperlukan
        button.setFocusPainted(false);
        // Beri border tipis agar terlihat
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)), // Border abu-abu tipis
            BorderFactory.createEmptyBorder(9, 19, 9, 19) // Padding (dikurangi 1)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Efek hover untuk tombol
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(240, 240, 240)); // Abu-abu muda saat hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE); // Kembali putih
            }
        });
    }
    
    private void loadData() {
        // 1. Kosongkan tabel
        tableModel.setRowCount(0);
        
        // 2. Buat query SQL (JOIN tabel barang dan harga)
        String sql = "SELECT b.id_barang, b.nama_barang, b.stok, h.harga_modal, h.harga_jual " +
                     "FROM barang b " +
                     "LEFT JOIN harga h ON b.id_barang = h.id_barang"; // Left join agar barang tanpa harga tetap tampil
        
        try {
            // 3. Ambil koneksi dan eksekusi query
            Connection conn = KoneksiDB.getKoneksi(); // <-- Menggunakan KoneksiDB
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            // 4. Looping untuk mengisi tabel
            while (rs.next()) {
                String idBarang = rs.getString("id_barang");
                String namaBarang = rs.getString("nama_barang");
                int stok = rs.getInt("stok");
                double hargaModal = rs.getDouble("harga_modal");
                double hargaJual = rs.getDouble("harga_jual");
                
                tableModel.addRow(new Object[]{idBarang, namaBarang, stok, hargaModal, hargaJual});
            }
            
            rs.close();
            stm.close();
            // Jangan tutup koneksi di sini agar bisa dipakai lagi
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil data dari database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    private JPanel createMenuItem(String text, String actionCommand, boolean isHeader) {
    JPanel menuItemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0)); 
        menuItemPanel.setBackground(sidebarBgColor);
        menuItemPanel.setBorder(new EmptyBorder(12, 15, 12, 15));
        
        JLabel iconLabel = new JLabel();
        // Tentukan ukuran ikon yang kita inginkan (misalnya 24x24)
        int iconSize = 24; 
        iconLabel.setPreferredSize(new Dimension(iconSize, iconSize)); 
        
        JLabel itemLabel = new JLabel(text);
        itemLabel.setForeground(new Color(170, 170, 170)); 
        itemLabel.setFont(new Font("Segoe UI", isHeader ? Font.BOLD : Font.PLAIN, 14));
        itemLabel.setBorder(new EmptyBorder(0, 5, 0, 0)); 

        if (isHeader) {
            itemLabel.setForeground(new Color(100, 100, 100)); 
            itemLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            menuItemPanel.setBorder(new EmptyBorder(25, 15, 8, 15)); 
            menuItemPanel.add(itemLabel);
        } else {
            // --- MULAI LOGIKA IKON ---
            String iconPath = "";
            
            // 1. Switch case diubah untuk MENGATUR PATH GAMBAR
            switch (actionCommand) {
                case "overview": iconPath = "/resources/overview.png"; break;
                case "stock":    iconPath = "/resources/stock.png"; break;
                case "report":   iconPath = "/resources/report.png"; break;
                case "users":    iconPath = "/resources/user.png"; break;
                case "settings": iconPath = "/resources/setting.png"; break;
                case "logout":   iconPath = "/resources/logout.png"; break;
                default:         iconPath = ""; break; // Kosong jika default
            }

            try {
                if (!iconPath.isEmpty()) {
                    // 2. Muat gambar dari resource
                    URL imgUrl = getClass().getResource(iconPath);
                    if (imgUrl == null) {
                        throw new Exception("Icon not found: " + iconPath);
                    }
                    ImageIcon originalIcon = new ImageIcon(imgUrl);
                    
                    // 3. Ubah ukuran gambar (scaling)
                    Image image = originalIcon.getImage();
                    Image scaledImage = image.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH);
                    
                    // 4. Set ikon ke JLabel
                    iconLabel.setIcon(new ImageIcon(scaledImage));
                } else {
                    // 5. Fallback jika tidak ada path (kasus default)
                    iconLabel.setText("•"); 
                    iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
                }
            } catch (Exception e) {
                e.printStackTrace();
                // 6. Fallback jika gambar gagal dimuat
                iconLabel.setText("•"); 
                iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
            }
            // --- SELESAI LOGIKA IKON ---

            iconLabel.setForeground(new Color(170, 170, 170)); // Warna default ikon/teks fallback
            
            menuItemPanel.add(iconLabel);
            menuItemPanel.add(itemLabel);
            menuItemPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // --- INI ADALAH MOUSE LISTENER YANG BENAR ---
            menuItemPanel.addMouseListener(new MouseAdapter() {
                private Color originalBg = sidebarBgColor;

                @Override
                public void mouseEntered(MouseEvent e) {
                    originalBg = menuItemPanel.getBackground();
                    menuItemPanel.setBackground(menuHoverColor);
                    itemLabel.setForeground(Color.WHITE); 
                    // Hanya ubah warna ikon jika itu TEKS (fallback)
                    if (iconLabel.getIcon() == null) {
                        iconLabel.setForeground(Color.WHITE); 
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Hanya reset jika tidak sedang terpilih
                    if (!menuItemPanel.getBackground().equals(menuSelectedColor)) {
                        menuItemPanel.setBackground(originalBg);
                        itemLabel.setForeground(new Color(170, 170, 170));
                        // Hanya ubah warna ikon jika itu TEKS (fallback)
                        if (iconLabel.getIcon() == null) {
                            iconLabel.setForeground(new Color(170, 170, 170));
                        }
                    }
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    resetMenuSelection(navPanel); 
                    menuItemPanel.setBackground(menuSelectedColor); 
                    itemLabel.setForeground(Color.WHITE); 
                    // Hanya ubah warna ikon jika itu TEKS (fallback)
                    if (iconLabel.getIcon() == null) {
                        iconLabel.setForeground(Color.WHITE);
                    }
                    originalBg = menuSelectedColor; 

                    if (actionCommand != null) {
                        handleMenuItemClick(actionCommand);
                    }
                }
            });
        }
        return menuItemPanel;
    }
    
    private void resetMenuSelection(JPanel parentPanel) {
    for (Component comp : parentPanel.getComponents()) {
            if (comp instanceof JPanel) {
                JPanel panel = (JPanel) comp;
                // Hanya reset jika bukan header
                if (panel.getComponentCount() > 1 && panel.getComponent(1) instanceof JLabel) {
                    JLabel label = (JLabel) panel.getComponent(1);
                    if (!label.getFont().isBold()) { // Hanya untuk item non-header
                        panel.setBackground(sidebarBgColor);
                        
                        // Ambil label ikon dan teks
                        JLabel iconLabel = (JLabel) panel.getComponent(0);
                        JLabel textLabel = (JLabel) panel.getComponent(1);

                        // Selalu reset warna teks
                        textLabel.setForeground(new Color(170, 170, 170)); 
                        
                        // Hanya reset warna ikon jika itu TEKS (fallback)
                        if (iconLabel.getIcon() == null) {
                            iconLabel.setForeground(new Color(170, 170, 170));
                        }
                    }
                }
            }
        }
    }

    private void handleMenuItemClick(String actionCommand) {
        switch (actionCommand) {
            case "overview":
                JOptionPane.showMessageDialog(this, "Anda mengklik Overview!");
                // Ganti konten di mainContentPanel
                break;
            case "stock":
                JOptionPane.showMessageDialog(this, "Anda mengklik Manajemen Stok!");
                // Ganti konten di mainContentPanel
                break;
            case "report":
                //JOptionPane.showMessageDialog(this, "Anda mengklik Laporan!");
                // Ganti konten di mainContentPanel
                new Laporan().setVisible(true);
                break;
            case "users":
                JOptionPane.showMessageDialog(this, "Anda mengklik Pengguna!");
                break;
            case "settings":
                JOptionPane.showMessageDialog(this, "Anda mengklik Pengaturan!");
                // Ganti konten di mainContentPanel
                break;
            case "logout":
            int confirm = JOptionPane.showConfirmDialog(this,
                        "Anda yakin ingin logout?",
                        "Konfirmasi Logout",
                        JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        //System.exit(0); // <--- INI YANG AKAN KITA GANTI
                        new LoginForm().setVisible(true); // Tampilkan lagi form login
                        this.dispose(); // Tutup dashboard
                    }
                break;
            default:
                break;
        }
    }


    private void tambahkanAksiTombol(JButton add, JButton edit, JButton delete, JButton refresh, JButton logout) {
        add.addActionListener(e -> {
            // Menambah data ke DB memerlukan form input baru
            JOptionPane.showMessageDialog(this, "Fungsi 'Tambah Barang' memerlukan form input baru untuk diisi.\nSilakan buat form terpisah untuk INSERT data ke database.");
            // Contoh: new FormTambahBarang(this).setVisible(true); 
            // Setelah form itu selesai, panggil loadData()
        });

        edit.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { 
                // Mengedit data ke DB memerlukan form input baru
                // Ambil ID-nya (kolom 0)
                String idBarang = tableModel.getValueAt(table.convertRowIndexToModel(selectedRow), 0).toString();
                JOptionPane.showMessageDialog(this, "Fungsi 'Edit Barang' (ID: " + idBarang + ") memerlukan form input baru.\nSilakan buat form terpisah untuk UPDATE data ke database.");
                // Contoh: new FormEditBarang(this, idBarang).setVisible(true);
                // Setelah form itu selesai, panggil loadData()
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data di tabel yang ingin diubah!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });

        delete.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                // Konfirmasi
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Anda yakin ingin menghapus data ini?",
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    // Ambil ID Barang dari baris yang dipilih (ada di kolom 0)
                    // Gunakan convertRowIndexToModel untuk keamanan jika ada sorting
                    String idBarang = tableModel.getValueAt(table.convertRowIndexToModel(selectedRow), 0).toString();
                    
                    try {
                        Connection conn = KoneksiDB.getKoneksi(); // <-- Menggunakan KoneksiDB
                        
                        // PENTING: Hapus dari tabel anak (harga) dulu
                        String sqlHarga = "DELETE FROM harga WHERE id_barang = ?";
                        PreparedStatement pstmHarga = conn.prepareStatement(sqlHarga);
                        pstmHarga.setString(1, idBarang);
                        pstmHarga.executeUpdate();
                        pstmHarga.close();

                        // Baru hapus dari tabel induk (barang)
                        String sqlBarang = "DELETE FROM barang WHERE id_barang = ?";
                        PreparedStatement pstmBarang = conn.prepareStatement(sqlBarang);
                        pstmBarang.setString(1, idBarang);
                        pstmBarang.executeUpdate();
                        pstmBarang.close();
                        
                        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                        
                        // Muat ulang data tabel
                        loadData(); 
                        
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data di tabel yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        refresh.addActionListener(e -> {
            // Implementasi refresh data: panggil loadData()
            loadData();
            JOptionPane.showMessageDialog(this, "Data berhasil di-refresh dari database!");
        });
        
        // Logout button di header (jika diperlukan, tapi sudah ada di sidebar)
        // logout.addActionListener(e -> { ... }); // Kode ini dipindah ke handleMenuItemClick
    }
    private void applyFilter() {
    String text = searchField.getText();
    if (text.trim().length() == 0) {
        // Jika kotak pencarian kosong, tampilkan semua data
        sorter.setRowFilter(null);
    } else {
        // Jika ada teks:
        // (?i) = membuat pencarian tidak case-sensitive (huruf besar/kecil sama)
        // text = teks yang dicari
        // Ini akan mencari di SEMUA kolom
        sorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text));
    }
}

    private void selectDefaultMenuItem() {
        for (Component comp : navPanel.getComponents()) {
            if (comp instanceof JPanel) {
                JPanel panel = (JPanel) comp;
                if (panel.getComponentCount() > 1 && panel.getComponent(1) instanceof JLabel) {
                    JLabel itemLabel = (JLabel) panel.getComponent(1);
                    if (itemLabel.getText().equals("Overview")) {
                        // Secara manual panggil logic mouseClicked untuk "Overview"
                        resetMenuSelection(navPanel);
                        panel.setBackground(menuSelectedColor);
                        ((JLabel) panel.getComponent(0)).setForeground(Color.WHITE);
                        itemLabel.setForeground(Color.WHITE);
                        break;
                    }
                }
            }
        }
    }
    
    
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
    SwingUtilities.invokeLater(() -> {
            new DashboardForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
