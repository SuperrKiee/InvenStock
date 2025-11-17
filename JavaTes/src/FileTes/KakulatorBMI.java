package FileTes;

import java.util.Scanner;

public class KakulatorBMI {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input BB
        System.out.println("==== Kalkulator BMI ====");
        System.out.print("Masukkan Berat Badan (kg): ");
        double beratBadan = input.nextDouble();
        
        // Input TB
        System.out.print("Masukkan Tinggi Badan (cm): ");
        double tinggiCm = input.nextDouble();

        double tinggiMeter = tinggiCm / 100.0;
        double bmi = beratBadan / (tinggiMeter * tinggiMeter);
        String kategori;

        if (bmi < 18.5) {
            kategori = "BB Kurang";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            kategori = "BB Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            kategori = "Kelebihan BB";
        } else {
            kategori = "Obesitas";
        }
        
        System.out.println("\n--- HASIL ANALISA BMI ---");
        System.out.println("Berat Badan  : " + beratBadan + " kg");
        System.out.println("Tinggi Badan : " + tinggiCm + " cm (" + tinggiMeter + " m)");
        System.out.printf("Nilai BMI Anda : %.2f\n", bmi);
        System.out.println("Kategori     : " + kategori);

        input.close();
    }
}