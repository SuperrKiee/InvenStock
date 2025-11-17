package FileTes;

import java.util.Scanner;

public class prosedur_func {

    // Method untuk menghitung dan menampilkan properti persegi panjang
    static void ProsedurPersegiPanjang() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Masukkan Panjang:");
        int panjang = input.nextInt();
        
        System.out.println("Masukkan Lebar:");
        int lebar = input.nextInt();
        
        int keliling = 2 * (panjang + lebar);
        int luas = hitungLuas(panjang, lebar);
        
        
        // Menampilkan hasil
        System.out.println("===== Hasil Perhitungan Persegi Panjang =====");
        System.out.println("Panjang = " + panjang);
        System.out.println("Lebar = " + lebar);
        System.out.println("Keliling = " + keliling);
        System.out.println("Luas = " + luas);
        System.out.println("=========================================");
    }
    
    // Method terpisah untuk menghitung luas
    static int hitungLuas(int panjang, int lebar) {
        return panjang * lebar;
    }
    
    public static void main(String[] args) {
        // Memanggil method utama untuk menjalankan program
        ProsedurPersegiPanjang();
        
    }
}
