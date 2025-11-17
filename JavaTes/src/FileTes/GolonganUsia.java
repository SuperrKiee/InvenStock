package FileTes;

import java.util.Scanner;

public class GolonganUsia {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Usia: ");

        int Umur = input.nextInt();
        int Usia;
        
        if (Umur < 0) { 
            System.out.println("Usia tidak boleh negatif!");
            input.close(); 
            return; 
        }

        if (Umur <= 3) {
            Usia = 1;
        } else if (Umur <= 5) {
            Usia = 2;
        } else if (Umur <= 11) {
            Usia = 3;
        } else if (Umur <= 18) {
            Usia = 4;
        } else {
            Usia = 5;
        }
        
        switch(Usia){
            case 1:
                System.out.println("Batita"); break;
            case 2:
                System.out.println("Balita"); break;
            case 3:
                System.out.println("Anak"); break;
            case 4:
                System.out.println("Remaja"); break;
            case 5:
                System.out.println("Dewasa"); break;
            default:
                System.out.println("Golongan usia tidak valid."); break;
        }
        
        input.close();
    }
}
