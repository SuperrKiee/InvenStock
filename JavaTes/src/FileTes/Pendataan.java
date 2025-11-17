package FileTes;

import java.util.Scanner;

public class Pendataan {
     
    static String Nama;
    static String Alamat;
    static int Usia;
    static String Minat;
     
    // Data Identitas
    static void Identitas(){
        Scanner Input = new Scanner(System.in);
        System.out.println("==== Pendataan Minat & Bakat ====");
        System.out.println("Masukkan Nama: ");
        Nama = Input.nextLine();
        System.out.println("Masukkan Alamat: ");
        Alamat = Input.nextLine();
        System.out.println("Masukkan Usia: ");
        Usia = Input.nextInt();
        Input.nextLine();
        System.out.println("=================================");
    }
     
    // Minat
    static void Minat(){
        Scanner Input = new Scanner(System.in);
        
        System.out.println("==== Bakat ====");
        System.out.println("1.Matematika");
        System.out.println("2.Ngoding");
        System.out.println("3.Olahraga");
        System.out.println("4.Melukis");
        System.out.println("===============");
        Minat = Input.nextLine();
        
    // Tampilan Akhir
        System.out.println("==== Data Identitas ====");
        System.out.println("Nama    : "+Nama);
        System.out.println("Alamat  : "+Alamat);
        System.out.println("Usia    : "+Usia);
        System.out.println("Bakat   : "+Minat);
        System.out.println("========================");
    }
     
    public static void main(String[]args){
        Identitas();
        Minat();
    }
}