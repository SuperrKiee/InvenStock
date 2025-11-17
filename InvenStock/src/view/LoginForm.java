package view;

import javax.swing.*;       
import java.awt.*;          
import java.awt.event.*;
import config.KoneksiDB; // Untuk memanggil kelas koneksi Anda
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.Border;
import java.util.logging.Level;

public class LoginForm extends javax.swing.JFrame {
// Komponen-komponen panel login
    private JPanel panelForm;
    private JPanel panelTombol;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JTextField inputUsername;
    private JPasswordField inputPassword;
    private JButton tombolLogin;
    private JButton tombolBatal;
    private JPanel panelLoginBox; // Panel yang membungkus form login
    
    // --- BARU: Panel untuk split-screen ---
    private JPanel panelKiri; //(Sisi Gambar)
    private JPanel panelKanan; //(Sisi Login)
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginForm.class.getName());


    public LoginForm() {
        this.setTitle("InvenStock");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Tetap full screen
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, 2));
        
        ImageIcon bgImage = null;
        try {
            bgImage = new ImageIcon(getClass().getResource("/resources/BackgroundLogin.png"));
            
            if (bgImage.getImage() == null || bgImage.getIconWidth() == -1) {
                 throw new NullPointerException("Image data not found or failed to load.");
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "File gambar /resources/BackgroundLogin.png tidak ditemukan!", e);
            
        }

        if (bgImage != null && bgImage.getIconWidth() > 0) { 
            panelKiri = new ImagePanel(bgImage.getImage());
        } else { 
            // Fallback (juran penyelamat) ke warna solid jika gambar tidak ditemukan
            panelKiri = new JPanel();
            panelKiri.setBackground(new Color(44, 62, 80)); // Warna biru gelap
        }
        
        panelKiri.setLayout(new GridBagLayout()); 
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 30, 10, 30); // Padding (top, left, bottom, right)
        gbc.anchor = GridBagConstraints.CENTER; // Teks akan di tengah

        // --- 3. KONFIGURASI PANEL KANAN (Sisi Login) ---
        panelKanan = new JPanel();
        panelKanan.setBackground(new Color(0x333436)); // <-- Warna gelap dari Figma
        panelKanan.setLayout(new GridBagLayout()); // Untuk menengahkan konten
        panelKanan.setBorder(new javax.swing.border.EmptyBorder(20, 50, 50, 50)); // Padding

        
        // --- 4. BUAT PANEL KONTEN KANAN ---
        // Panel ini akan menampung semua (logo, teks, form) secara vertikal
        JPanel panelKananKonten = new JPanel();
        panelKananKonten.setLayout(new BoxLayout(panelKananKonten, BoxLayout.Y_AXIS));
        panelKananKonten.setOpaque(false); // Transparan, agar menyatu dengan panelKanan
        panelKananKonten.setMaximumSize(new Dimension(700, Integer.MAX_VALUE));

        JLabel labelLogo = new JLabel(new ImageIcon(getClass().getResource("/resources/logo_gabungan.png")));
        labelLogo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // --- Elemen 2: Teks "Welcome" ---
        JLabel labelWelcome = new JLabel("Welcome to InvenStock");
        labelWelcome.setFont(new Font("SansSerif", Font.BOLD, 28));
        labelWelcome.setForeground(Color.WHITE);
        labelWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        // --- Elemen 3: Teks "Silahkan login" ---
        JLabel labelSubtext = new JLabel("Silahkan login untuk mengakses");
        labelSubtext.setFont(new Font("SansSerif", Font.PLAIN, 16));
        labelSubtext.setForeground(Color.LIGHT_GRAY);
        labelSubtext.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        int desiredHeight = 70; 
        Dimension fieldSize = new Dimension(Integer.MAX_VALUE, desiredHeight);
        
        // --- Elemen 4: Form Username ---
        inputUsername = new JTextField(20){
        @Override
            public Dimension getMinimumSize() {
                return new Dimension(super.getMinimumSize().width, 36);
            }
            @Override
            public Dimension getMaximumSize() {
                return new Dimension(super.getMaximumSize().width, 50);
            }
        };
        inputUsername.setBackground(Color.WHITE); // Latar belakang jadi putih
        inputUsername.setForeground(Color.BLACK); // Font jadi hitam
        inputUsername.setFont(new Font("SansSerif", Font.PLAIN, 14));
        // Properti FlatLaf untuk placeholder dan ikon
        inputUsername.putClientProperty("FlatLaf.styleClass", "x-large");
        inputUsername.putClientProperty("JTextField.placeholderText", "Username");
        inputUsername.putClientProperty("JTextField.leadingIcon", resizeIcon("/resources/user_icon.png", 30, 30));
        inputUsername.setPreferredSize(fieldSize);
        inputUsername.setMaximumSize(fieldSize);


        // --- Elemen 5: Form Password ---
        inputPassword = new JPasswordField(20){
        @Override
            public Dimension getMinimumSize() {
                return new Dimension(super.getMinimumSize().width, 36);
            }
            @Override
            public Dimension getMaximumSize() {
                return new Dimension(super.getMaximumSize().width, 50);
            }
        };   
        inputPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
        inputPassword.setBackground(Color.WHITE); // Latar belakang jadi putih
        inputPassword.setForeground(Color.BLACK); // Font jadi hitam
        // Properti FlatLaf untuk placeholder dan ikon
        inputPassword.putClientProperty("FlatLaf.styleClass", "x-large");
        inputPassword.putClientProperty("JTextField.placeholderText", "Password");
        inputPassword.putClientProperty("JTextField.leadingIcon", resizeIcon("/resources/key_icon.png", 30, 30));
        inputPassword.putClientProperty("JTextField.trailingIcon", resizeIcon("/resources/eye_icon.png", 30, 30));
        inputPassword.setPreferredSize(fieldSize);
        inputPassword.setMaximumSize(fieldSize);
        
        // --- Elemen 6: Panel Tombol ---
        // (Pastikan 'tombolLogin' & 'tombolBatal' sudah dideklarasi di atas)
        panelTombol = new JPanel(new GridLayout(1, 2, 10, 0)); // 1 baris, 2 kolom, 10px spasi
        panelTombol.setOpaque(false); // Transparan

        tombolLogin = new JButton("Login"){
        @Override
            public Dimension getMinimumSize() {
                return new Dimension(super.getMinimumSize().width, 38); 
            }
            @Override
            public Dimension getMaximumSize() {
                return new Dimension(super.getMaximumSize().width, 70); 
            }
        };    
        tombolLogin.setFont(new Font("SansSerif", Font.BOLD, 14));
        tombolLogin.setBackground(new Color(0x3498DB)); // Warna Biru
        tombolLogin.setForeground(Color.WHITE);
        tombolLogin.setPreferredSize(new Dimension(100, 45)); // Atur tinggi

        tombolBatal = new JButton("Batal"){
        @Override
            public Dimension getMinimumSize() {
                return new Dimension(super.getMinimumSize().width, 38); 
            }
            @Override
            public Dimension getMaximumSize() {
                return new Dimension(super.getMaximumSize().width, 70); 
            }
        };
        tombolBatal.setFont(new Font("SansSerif", Font.BOLD, 14));
        tombolBatal.setBackground(Color.WHITE); // Warna Putih
        tombolBatal.setForeground(new Color(0x333436)); // Teks warna gelap
        tombolBatal.setPreferredSize(new Dimension(100, 45)); // Atur tinggi

        panelTombol.add(tombolLogin);
        panelTombol.add(tombolBatal);
        panelTombol.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45)); // Atur tinggi maks


        // --- 5. SUSUN SEMUA ELEMEN DI KANAN ---
        // Gunakan Box.createRigidArea untuk memberi spasi
        panelKananKonten.add(Box.createRigidArea(new Dimension(0, 150)));
        panelKananKonten.add(labelLogo);
        panelKananKonten.add(Box.createRigidArea(new Dimension(0, 50)));
        panelKananKonten.add(labelWelcome);
        panelKananKonten.add(Box.createRigidArea(new Dimension(0, 5)));
        panelKananKonten.add(labelSubtext);
        panelKananKonten.add(Box.createRigidArea(new Dimension(0, 30)));
        panelKananKonten.add(inputUsername);
        panelKananKonten.add(Box.createRigidArea(new Dimension(0, 25)));
        panelKananKonten.add(inputPassword);
        panelKananKonten.add(Box.createRigidArea(new Dimension(0, 30)));
        panelKananKonten.add(panelTombol);

        
        // --- 6. MASUKKAN SEMUA KE FRAME UTAMA ---
           GridBagConstraints gbcKanan = new GridBagConstraints();
           gbcKanan.anchor = GridBagConstraints.NORTH; 
           gbcKanan.fill = GridBagConstraints.HORIZONTAL; 
           gbcKanan.weightx = 1.0; // Mengambil ruang horizontal
           gbcKanan.weighty = 0.0; // Konten login (panelKananKonten) tidak mengambil ruang vertikal ekstra

           panelKanan.add(panelKananKonten, gbcKanan); // Gunakan constraints baru

           JPanel filler = new JPanel();
           filler.setOpaque(false); // Pastikan ini transparan
           GridBagConstraints gbcFiller = new GridBagConstraints();
           gbcFiller.gridy = 1; // Posisikan di bawah panelKananKonten (baris kedua)
           gbcFiller.weighty = 1.0; // <-- Kunci: Mengambil SEMUA ruang vertikal sisa
           gbcFiller.fill = GridBagConstraints.BOTH; // Mengisi ruang yang diberikan
           panelKanan.add(filler, gbcFiller);

        this.add(panelKiri);
        this.add(panelKanan);
        
        tombolLogin.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
                String username = inputUsername.getText();
                String password = new String(inputPassword.getPassword());

                // Pastikan nama kolom di database Anda sesuai (misal: username dan password)
                String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

                // Menggunakan try-with-resources agar koneksi, statement, 
                // dan resultset otomatis tertutup setelah dipakai.
                try (Connection conn = KoneksiDB.getKoneksi(); // 1. Ambil Koneksi
                     PreparedStatement ps = conn.prepareStatement(sql)) {

                    // 2. Set parameter query (mencegah SQL Injection)
                    ps.setString(1, username);
                    ps.setString(2, password); // PERINGATAN: Lihat catatan keamanan di bawah

                    // 3. Eksekusi query
                    try (ResultSet rs = ps.executeQuery()) {
                        
                        // 4. Cek hasil
                        if (rs.next()) {
                            // --- LOGIN BERHASIL ---
                            // Jika rs.next() bernilai true, berarti user ditemukan
                            
                            // Ganti nama 'DshboardForm' jika nama kelas Anda beda
                            DashboardForm formDsh = new DashboardForm(); 
                            formDsh.setVisible(true);
                            LoginForm.this.dispose(); // Tutup jendela login

                        } else {
                            // --- LOGIN GAGAL ---
                            // Jika rs.next() bernilai false, user tidak ditemukan
                            JOptionPane.showMessageDialog(LoginForm.this,
                                "Username atau Password salah.",
                                "Gagal Login",
                                JOptionPane.ERROR_MESSAGE);
                        }
                    }

                } catch (SQLException ex) {
                    // --- KESALAHAN DATABASE ---
                    // Ini terjadi jika ada masalah koneksi atau query salah
                    logger.log(java.util.logging.Level.SEVERE, "Gagal login DB", ex);
                    JOptionPane.showMessageDialog(LoginForm.this,
                        "Terjadi kesalahan pada database: " + ex.getMessage(),
                        "Error Database",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
            });

            tombolBatal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        
        
    }
    
    private ImageIcon resizeIcon(String path, int width, int height) {
        try {
            java.net.URL imgURL = getClass().getResource(path);
            if (imgURL != null) {
                ImageIcon icon = new ImageIcon(imgURL);
                Image img = icon.getImage();
                // Mengubah ukuran gambar secara paksa
                Image resizedImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); 
                return new ImageIcon(resizedImg);
            } else {
                logger.log(Level.WARNING, "Resource file not found: " + path);
                return null;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error resizing icon: " + path, e);
            return null;
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
        try {
            com.formdev.flatlaf.FlatDarkLaf.setup();
            
            UIManager.put("Component.arc", 100);
            UIManager.put("Button.arc", 70);
            UIManager.put("TextComponent.arc", 70); 
            UIManager.put("TextComponent.padding", new Insets(15, 15, 15, 15)); 
            UIManager.put("Button.iconTextGap", 4);

            
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, "Gagal Inisialisasi FlatLaf", ex);
        }

        // Jalankan aplikasi
        java.awt.EventQueue.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    class ImagePanel extends JPanel {
        private Image img;

        public ImagePanel(Image img) {
            this.img = img;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                // Gambar akan diskalakan agar pas dengan ukuran panel
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
