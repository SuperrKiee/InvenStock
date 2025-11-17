package FileTes;
import java.util.Scanner;
public class Tugas_Looping {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            System.out.println("--- PROGRAM Looping ---");
            System.out.print("Masukkan jumlah yang diinginkan: ");
            int jumlah = input.nextInt();
            
            System.out.print("Masukkan arah (horizontal / vertikal): ");
            String arah = input.next();
            
            System.out.println("\n--- HASIL ---");
            if (arah.equalsIgnoreCase("horizontal")) {
            for (int i = 1; i <= jumlah; i++) {
                
            System.out.print("* "); 
            }
            System.out.println(); 
            } else if (arah.equalsIgnoreCase("vertikal")) {
            for (int i = 1; i <= jumlah; i++) {
            System.out.println("*");
            }
            } else {
            System.out.println("Maaf, arah yang Anda masukkan tidak valid.");
            }

            input.close();
    }
}
