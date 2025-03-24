package Tugas_1;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Tugas1 {
    public static void main(String[] args) {
        int pilih, MaxPercobaan, i;
        String UserAdmin,PassAdmin,UserMaha;
        Long PassMaha;

        Scanner InputPengguna = new Scanner(System.in);
        while (true) {
            System.out.println("Pilih login:");
            System.out.println("1. Admin.");
            System.out.println("2. Mahasiswa.");
            System.out.println("3. Keluar Menu.");
            System.out.print("Pilih menu (1-3): ");

            if (InputPengguna.hasNextInt()) {

                pilih = InputPengguna.nextInt();
                InputPengguna.nextLine();
                if (pilih >= 1 && pilih <= 3) {
                    break;
                } else {
                    System.out.println("Input anda salah silahkan ulangi lagi!");
                }


            } else {
                System.out.println("Input anda salah, harap masukan angka 1,2 atau 3.");
                InputPengguna.nextLine();

            }
        }
        if (pilih ==3){
            System.out.println("Terimakasih telah menggunakan program saya :)");
            InputPengguna.close();
            return;
        }

        MaxPercobaan = 3;

        if (pilih == 1){
            for (i = 1; i <= MaxPercobaan ; i++){
                System.out.print("Masukan Username: ");
                UserAdmin = InputPengguna.nextLine();

                System.out.print("Masukan Password: ");
                PassAdmin = InputPengguna.nextLine();

                if (UserAdmin.startsWith("Admin276") && PassAdmin.startsWith("Password276") ){
                    System.out.println("Login Berhasil :)");
                    InputPengguna.close();
                    return;
                }
                else {
                    System.out.println("Kata sandi atau username salah!\nulangi lagi!\nAnda memiliki" + (MaxPercobaan -1) + "kesempatan");
                }
                if( i == MaxPercobaan){
                    System.out.println("Kesempatan anda habis!\nUlangi lagi nanti!");
                    InputPengguna.close();
                    return;
                }
            }
        } else if (pilih == 2) {
            for (i =1; i<=MaxPercobaan; i++){
                System.out.println("Login mahasiswa berhasil");
                System.out.print("Masukan Nama: ");
                UserMaha = InputPengguna.nextLine();
                System.out.print("Masukan NIM: ");
                if(InputPengguna.hasNextLong()) {
                    PassMaha = InputPengguna.nextLong();
                    InputPengguna.nextLine();

                    long validPass = 202410370110276L;
                    if (UserMaha.startsWith("Shofa Khafidin") && PassMaha == validPass) {
                        System.out.println("Nama anda: " + UserMaha);
                        System.out.println("Nim anda: " + PassMaha);
                        break;
                    } else {
                        System.out.println("Kata sandi atau username salah!\nulangi lagi!\nAnda memiliki " + (MaxPercobaan - 1) + " kesempatan");
                    }
                }
                else {
                    System.out.println("Nim harus berupa angka!");
                    System.out.println("ulangi lagi!\nAnda memiliki " + (MaxPercobaan - 1) + " kesempatan");
                    InputPengguna.nextLine();
                }

                if (i == MaxPercobaan){
                    System.out.println("Kesempatan anda habis!\nUlangi lagi nanti!");
                    return;
                }
            }
        }

    }
}