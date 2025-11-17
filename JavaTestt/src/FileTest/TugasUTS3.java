package FileTest;

import java.util.Scanner;

public class TugasUTS3 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        
        System.out.println("--- DAFTAR MINUMAN ---");
        System.out.println("1. Kopi Hitam - Rp8000");
        System.out.println("2. Teh Manis  - Rp5000");
        System.out.println("3. Jus Jeruk  - Rp10000");
        System.out.println("4. Air Mineral- Rp4000");
        System.out.println("----------------------");
        
        // Meminta input pilihan
        System.out.print("Pilih minuman (1-4): ");
        int pilihan = input.nextInt();
        
        // Siapkan variabel untuk menyimpan hasil
        String namaMinuman;
        int harga;
        
        // Struktur Switch-Case untuk menentukan nama dan harga
        switch (pilihan) {
            case 1:
                namaMinuman = "Kopi Hitam";
                harga = 8000;
                break; // 'break' menghentikan eksekusi case
            case 2:
                namaMinuman = "Teh Manis";
                harga = 5000;
                break;
            case 3:
                namaMinuman = "Jus Jeruk";
                harga = 10000;
                break; 
            case 4:
                namaMinuman = "Air Mineral";
                harga = 4000;
                break;
            default: // 'default' dijalankan jika tidak ada case yang cocok
                namaMinuman = "Pilihan tidak valid";
                harga = 0;
                break;
        }
        
        // Menampilkan hasil
        // Menambah baris baru (\n) agar rapi
        System.out.println(); 
        
        // Hanya tampilkan harga jika pilihan valid (harga > 0)
        if (harga > 0) {
            System.out.println("Anda memilih: " + namaMinuman);
            System.out.println("Harga: Rp" + harga);
        } else {
            System.out.println("Maaf, pilihan tidak tersedia.");
        }
        
    }
}
