package FileTes;

import java.util.Scanner;

public class GradeNilaiMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai mahasiswa (0-100): ");
        int nilai = input.nextInt();
        String grade;
        
        if (nilai < 0) {
            System.out.println("Nilai tidak boleh negatif!");
        } else if (nilai > 100) {
            System.out.println("Nilai tidak boleh lebih dari 100!");
        } else {

            int nilaiGrade = nilai / 10;

            switch (nilaiGrade) {
                case 10:
                case 9:
                    grade = "A";
                    break;
                case 8:
                    grade = "B";
                    break;
                case 7:
                    grade = "C";
                    break;
                case 6:
                    grade = "D";
                    break;
                default:
                    grade = "E";
                    break;
            }

            System.out.println("Nilai Anda adalah: " + nilai);
            System.out.println("Grade yang Anda dapatkan adalah: " + grade);
        }

        input.close();
    }
}
