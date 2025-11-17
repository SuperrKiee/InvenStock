package FileTest;

import java.util.Scanner;

public class TugasUTS4 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int totalHarga = 0;
        
        System.out.println("--- MENU RESTORAN ---");
        System.out.println("1. Nasi Goreng  (Rp15000)");
        System.out.println("2. Mie Ayam     (Rp12000)");
        System.out.println("3. Soto Ayam    (Rp14000)");
        System.out.println("4. Ayam Bakar   (Rp18000)");
        System.out.println("5. Es Teh       (Rp5000)");
        System.out.println("---------------------");
        
        //Perulangan for untuk 3 pesanan
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n--- Pesanan ke-" + i + " ---");
            
            // Input nomor menu dan jumlah
            System.out.print("Pilih menu (1-5): ");
            int pilihanMenu = input.nextInt();
            
            System.out.print("Jumlah porsi: ");
            int jumlahPorsi = input.nextInt();

            // Variabel untuk menyimpan harga satuan per menu
            int hargaSatuan = 0;

            // Menentukan harga satuan menggunakan switch-case
            switch (pilihanMenu) {
                case 1:
                    hargaSatuan = 15000;
                    break;
                case 2:
                    hargaSatuan = 12000;
                    break;
                case 3:
                    hargaSatuan = 14000;
                    break;
                case 4:
                    hargaSatuan = 18000;
                    break;
                case 5:
                    hargaSatuan = 5000;
                    break;
                default:
                    // Jika menu tidak valid, harga tetap 0
                    System.out.println("Menu tidak valid, pesanan ini diabaikan.");
                    break;
            }

            // 6. Akumulasi total harga
            // Subtotal pesanan saat ini = hargaSatuan * jumlahPorsi
            totalHarga += (hargaSatuan * jumlahPorsi);
        }
        double diskon = 0.0;
        double totalBayar = totalHarga;
       
        // Cek kondisi diskon (Jika total > 50000)
        if (totalHarga > 50000) {
            // Hitung diskon 10% (0.10)
            diskon = (double)totalHarga * 0.10;
            // Hitung total bayar setelah diskon
            totalBayar = (double)totalHarga - diskon;
        
        System.out.println("--- Rincian Pembayaran ---");
        System.out.println("Total Sebelum Diskon: Rp" + totalHarga);
        
        // (int) digunakan agar tampilan diskon dan total bayar menjadi bilangan bulat
        System.out.println("Diskon 10%: Rp" + (int)diskon);
        System.out.println("Total Bayar: Rp" + (int)totalBayar);
        }
    }
    
}
