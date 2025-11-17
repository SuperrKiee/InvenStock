
package contoh.pkg1;
import java.util.Scanner;
public class RobinTugas {

    
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
               
       System.out.println("Masukkan Nama: ");
       String Nama = Input.nextLine();
       
       System.out.println("Masukkan Nim: ");
       String Nim = Input.nextLine();
       
       System.out.println("Masukkan Usia: ");
       int Usia = Input.nextInt();
       
       System.out.println("Masukkan Rata-Rata Nilai: ");
       double Nilai = Input.nextDouble();
       
       System.out.println("Nama: "+Nama);
       System.out.println("Nim: "+Nim);
       System.out.println("Usia: "+Usia);
       System.out.println("Rata-Rata: "+Nilai);
       

        
    }
    
}
