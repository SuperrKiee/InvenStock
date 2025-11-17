
package FileTest;


class Printer {

public static void tampilkanBiodata(String nama, int umur) {
        System.out.println("--- Profil Pengguna ---");
        System.out.println("Nama Lengkap: " + nama);
        System.out.println("Umur Saat Ini: " + umur + " tahun");
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        tampilkanBiodata("Bahlil Pertamax", 45);
        
        tampilkanBiodata("Mas Rusdi", 35);
    }
    
}
