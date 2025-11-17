package FileTes;

import java.util.Scanner;

public class imputan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Imput dari user
        System.out.println("Masukkan nama: ");
        String nama = input.next();
        
        System.out.println("Masukkan berat badan (kg): ");
        double berat = input.nextDouble();
        
        System.out.println("Masukan tinggi badan (cm): ");
        double tinggi = input.nextDouble();
        
        // Tampilan data user
        System.out.println("\n==== Data Diri Anda ===");
        System.out.println("Nama            : "+ nama);
        System.out.println("Berat badan     : "+ berat + " Kg");
        System.out.println("Tinggi badan    : "+ tinggi + " Cm");
        System.out.println("=======================");
    }
}