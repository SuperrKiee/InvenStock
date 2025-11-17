package FileTest;

import java.util.Scanner;

public class TugasUTS1 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Meminta input dari pengguna
        System.out.print("Masukkan batas bilangan: "); 
        int batas = input.nextInt();
        
        // Menampilkan label output
        System.out.print("Bilangan ganjil: "); 
        
        // Perulangan for
        // - Dimulai dari i = 1 (bilangan ganjil pertama)
        // - Berlanjut selama i <= n (sampai batas N)
        // - Setiap iterasi, i ditambah 2 (i += 2) untuk langsung ke bilangan ganjil berikutnya
        for (int i = 1; i <= batas; i += 2) {
            // Menampilkan bilangan ganjil diikuti spasi
            System.out.print(i + " "); 
        }
    }
    
}
