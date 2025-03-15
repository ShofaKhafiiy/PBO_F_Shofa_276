import java.util.Scanner;
import  java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);//system in menunjukan bahwa input akan diterima keyboard

        //Mengambil data menggunakan function/Method
        String nama = GetName(Input);
        char JenisKelamin = InputKelamin(Input);
        int TahunLahir = InputTahunLahir(Input);
        Input.close();

        //Menghitung Umur
        int umur = HitungUmur(TahunLahir);

        //Menentukan Jenis kelamin

        String JenisKelaminStr = PilihjenisKelamin(JenisKelamin);

        //menampilkan data

        TampilkanData(nama, JenisKelamin, TahunLahir);


    }
    private static String GetName(Scanner input){
        System.out.print("Masukan Nama: ");
        return input.nextLine();
    }
    private static char InputKelamin(Scanner input){
        System.out.print("Masukan jenis kelamin (P/L): ");
        char JenisKelamin = input.next().charAt(0);
        input.nextLine();
        return  JenisKelamin;
    }

    private static int InputTahunLahir(Scanner Input){
        System.out.print("Masukan tahun lahir: ");
        return Input.nextInt();
    }

    //fungsi untuk mengambil inputan tahun lahir kita
    private static  int HitungUmur(int TahunLahir){
        int TahunSekarang = LocalDate.now().getYear();
        return TahunSekarang - TahunLahir;
    }

    //fungsi menentukan jenis kelamin
    private static String PilihjenisKelamin(char JenisKelamin){
        if (JenisKelamin == 'L' || JenisKelamin == 'l'){
            return "Laki-laki";
        } else if (JenisKelamin == 'P' || JenisKelamin == 'p') {
            return "Perempuan";
        }
        else {
            return "Tidak diketahui";
        }
    }

    //fungsi menampilkan nama
    private static void TampilkanData(String nama, char kelamin, int umur){
        System.out.println("\nData Diri:");
        System.out.println("Nama            : " + nama);
        System.out.println("Jenis Kelamin   : " + kelamin);
        System.out.println("Umur            : " + umur + " tahun");
    }
}