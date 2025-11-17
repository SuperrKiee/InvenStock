package FileTes;

import java.util.Scanner;

public class BilanganGanjilGenap {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        
        System.out.println("Masukkan Angka: ");
        int angka = Input.nextInt();
        
        if (angka > 0) {
            System.out.println("Bilangan Positif");
        } else if (angka < 0) {
            System.out.println("Bilangan Negatif");
        } else {
            System.out.println("Angka Nol");
        }
        
        Input.close();
    }
}
