
package FileTes;

import java.util.Scanner;

public class OperatorAritmatika {
    
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Data Bangun Ruang
        System.out.println("Masukkan Panjang ");
        int panjang = input.nextInt ();
        
        System.out.println("Masukkan Lebar");
        int lebar = input.nextInt ();
        
        int jumlah = panjang * lebar;
        int Keliling = 2 * jumlah;
        
        // Tampilan Keliling
        System.out.println("===== Data Keliling Persegi Panjang ===== ");
        System.out.println("rumus Keliling = 2 x (" + panjang + " + " + lebar + ")");
        System.out.println("Keliling = " + (panjang + lebar));
        System.out.println("Keliling = 2 x " + (panjang + lebar));
        System.out.println("Keliling = " + Keliling);
        System.out.println("========================================= ");
        
        //Tampilan Luas
        int luas = panjang * lebar;
        System.out.println("===== Data Luas Persegi Panjang ========= ");
        System.out.println("Luas = " + panjang + " x " + lebar);
        System.out.println("Luas = " + luas);
        System.out.println("========================================= ");
        
        }
}
