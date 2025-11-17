package FileTest;

import java.util.Scanner;
import java.util.Locale;

public class SoalUTS5 {


    public static void main(String[] args) {
        // 1. Setup Scanner
        // Menggunakan Locale.US agar input desimal (seperti 1.75) 
        // konsisten menggunakan titik ('.') bukan koma (',')
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        
        // 2. Input jumlah anggota (Langkah 1)
        System.out.print("Masukkan jumlah anggota yang akan dihitung: ");
        int jumlahAnggota = input.nextInt();
        
        // Membersihkan buffer scanner setelah nextInt()
        // Ini penting agar input.nextLine() (untuk nama) berfungsi di dalam loop
        input.nextLine(); 
        
        System.out.println("----------------------------------------");

        // 3. Perulangan for (Langkah 1)
        // Loop akan berjalan sebanyak 'jumlahAnggota'
        for (int i = 1; i <= jumlahAnggota; i++) {
            
            System.out.println("--- Data Anggota ke-" + i + " ---");

            // 4. Input data untuk setiap anggota (Langkah 2)
            System.out.print("Masukkan Nama: ");
            String nama = input.nextLine();
            
            System.out.print("Masukkan Berat (kg): ");
            double berat = input.nextDouble();
            
            System.out.print("Masukkan Tinggi (meter, cth: 1.65): ");
            double tinggi = input.nextDouble();
            
            // Membersihkan buffer lagi setelah nextDouble() 
            // untuk persiapan input 'nama' di loop berikutnya (jika ada)
            input.nextLine(); 

            // 5. Hitung IMT (Langkah 3)
            // IMT = berat / (tinggi * tinggi)
            double imt = berat / (tinggi * tinggi);

            // 6. Tentukan Kategori (Langkah 4)
            String kategori;
            
            if (imt < 18.5) {
                kategori = "Kurus";
            } else if (imt <= 24.9) {
                // (Otomatis berarti imt >= 18.5)
                kategori = "Normal";
            } else if (imt <= 29.9) {
                // (Otomatis berarti imt >= 25.0)
                kategori = "Gemuk";
            } else {
                // (Otomatis berarti imt >= 30.0)
                kategori = "Obesitas";
            }

            // 7. Tampilkan hasil untuk anggota ini (Langkah 5)
            // Format output ini disesuaikan agar sama persis
            // dengan contoh output yang diminta.
            
            System.out.println("Nama: " + nama);
            System.out.println("Berat: " + berat);
            System.out.println("Tinggi: " + tinggi);
            
            // Menggunakan System.out.printf untuk memformat IMT 
            // (%.2f) agar hanya menampilkan 2 angka di belakang koma
            System.out.printf("IMT: %.2f (%s)", imt, kategori);
            System.out.println("----------------------------------------");
        }
        
        System.out.println("Semua data anggota telah diproses.");
    }
    
}
