package FileTes;

import java.util.Scanner;

public class PerkenalanVariabel {
    public static void main(String[] args) {
        String nama="Muhammad Rifki Nizami";
        String prodi="Teknik Informatika PSDKU Sidoarjo";
        String jurusan="Teknologi Informasi";
        String nim="E41250169";
        System.out.println("Halo Perkenalkan Namaku adalah "+nama);
        System.out.println("Dari Jurusan "+jurusan);
        System.out.println("Prodi "+prodi);
        System.out.println("Dengan nim "+nim);
        
        
        //perubahan isi variabel
        Scanner s1=new Scanner(System.in);
        System.out.print("Masukkan data jumlah");
        int jumlah=s1.nextInt();
        System.out.println("Jumlahnya ada "+jumlah);
        
        
        
    
    }
}
