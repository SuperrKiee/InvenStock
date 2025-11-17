package FileTest;

import java.util.Scanner;

public class NyobaLooping {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
                System.out.print("Masukkan warna (merah/kuning/hijau): ");
        String warna = input.nextLine().toLowerCase(); // biar tidak case-sensitive

        switch (warna) {
            case "merah":
                System.out.println("Anda harus berhenti");
                break;
            case "kuning":
                System.out.println("Persiapan berhenti");
                break;
            case "hijau":
                System.out.println("Silahkan jalan");
                break;
            default:
                System.out.println("Warna salah");
                break;
        }
        
        input.close();
        
    }
    
}
