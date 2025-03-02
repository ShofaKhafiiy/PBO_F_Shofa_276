import java.util.Scanner;
import  java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//system in menunjukan bahwa input akan diterima keyboard

        //untuk menginput nama
        System.out.print("Masukan nama: ");
        String nama= scanner.nextLine(); //mengambil inputan nama dari pengguna

        //input jenis kelamin
        System.out.print("Masukan jenis kelamin(P/L): ");
        char JenisKelamin = scanner.next().charAt(0);
        scanner.nextLine(); //membersihkan newline dari inputan sebelumnya

        // input tahun lahir(harus berupa angka)
        System.out.print("Masukan tahun lahir: ");
        int Tahun_lahir = scanner.nextInt();
        scanner.close(); // menutup object scan unutk mencegah kebocoran memori
        //Menghitung Umur berdasarkan tahun lahir
        int tahunSekarang = LocalDate.now().getYear(); //Mengambil tahun ini dengan menggunakan API localDate
        int Umur = tahunSekarang - Tahun_lahir; //mengurangi tahun saat ini dengan inputan tahun lahir kita untuk mendapatkan umur kita

        //Menentukan jenis kelamin berdasarkan input
        //Menggunakan validasi
        String jenisKelaminStr = "";

        if (JenisKelamin == 'L'|| JenisKelamin == 'l'){
            jenisKelaminStr = "laki-laki";
        } else if (JenisKelamin == 'P' || JenisKelamin == 'p') {
            jenisKelaminStr = "Perempuan";

        }
        else {
            jenisKelaminStr = "Tidak Diketahui";
        }

        //Menampilkan output data diri
        System.out.println("\nData Diri:");
        System.out.println("Nama            : "+nama);
        System.out.println("Jenis Kelamin   : "+ jenisKelaminStr);
        System.out.println("Umur            : "+Umur+"tahun");
    }
}