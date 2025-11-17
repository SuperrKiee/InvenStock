package FileTes; 

import java.util.Scanner;

public class InputanMatrix {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("==== Input Matrix ====");
        System.out.print("Masukkan jumlah baris: ");
        int baris = input.nextInt();

        System.out.print("Masukkan jumlah kolom: ");
        int kolom = input.nextInt();
        System.out.println("---------------------------------");

        int[][] matrix = new int[baris][kolom];

        
        System.out.println("Masukkan matriks:");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print("Masukkan data untuk posisi (" + i + ", " + j + "): ");
                matrix[i][j] = input.nextInt();
            }
        }

        System.out.println("\n---------------------------------");
        System.out.println("Matriks yang telah diinput:");

        
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        
        input.close();
    }
}