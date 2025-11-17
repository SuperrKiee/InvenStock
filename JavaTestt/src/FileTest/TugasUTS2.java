package FileTest;

import java.util.Scanner;

public class TugasUTS2 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Meminta input nilai dari pengguna
        System.out.print("Masukkan nilai: ");
        //Untuk nilai Desimal
        double nilai = input.nextDouble();
        
        // Variabel untuk menyimpan hasil
        String hasil;
        
        // Struktur pengkondisian IF-ELSE IF-ELSE
        
        if (nilai >= 80) {
            hasil = "Lulus dengan Predikat A";
        } 
        else if (nilai >= 70) {
            hasil = "Lulus dengan Predikat B";
        } 
        else if (nilai >= 60) {
            hasil = "Lulus dengan Predikat C";
        } 
        else {
            hasil = "Tidak Lulus";
        }
        // Menampilkan hasil
        System.out.println("Hasil: " + hasil);
    }
    
}
