package FileTes;

import java.util.Scanner;

public class OperasiMatrix {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Jumlah Baris: ");
        int baris = input.nextInt();
        System.out.print("Masukkan Jumlah Kolom: ");
        int kolom = input.nextInt();

        int[][] matriksA = new int[baris][kolom];
        int[][] matriksB = new int[baris][kolom];
        int[][] hasil = new int[baris][kolom];

        System.out.println("\nMasukkan Nilai untuk Matriks Pertama:");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print("Elemen [" + i + "][" + j + "]: ");
                matriksA[i][j] = input.nextInt();
            }
        }

        System.out.println("\nMasukkan Nilai untuk Matriks Kedua:");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print("Elemen [" + i + "][" + j + "]: ");
                matriksB[i][j] = input.nextInt();
            }
        }

        System.out.println("\n--- Hasil Matriks ---");

        System.out.println("Matriks Pertama (A):");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(matriksA[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nMatriks Kedua (B):");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(matriksB[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\n--- Hasil Operasi Matriks ---");

        System.out.println("Hasil Penjumlahan Matriks (A + B):");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                hasil[i][j] = matriksA[i][j] + matriksB[i][j];
                System.out.print(hasil[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nHasil Pengurangan Matriks (A - B):");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                hasil[i][j] = matriksA[i][j] - matriksB[i][j];
                System.out.print(hasil[i][j] + "\t");
            }
            System.out.println();
        }

        input.close();
    }
}