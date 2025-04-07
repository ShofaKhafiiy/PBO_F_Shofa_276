package com.main;

import com.admin.Admin;
import com.admin.Mahasiswa;

import java.util.Scanner;




public class Tugas1 {
    public static void main(String[] args) {

        Scanner InputPengguna = new Scanner(System.in);
        Admin admin = new Admin("Admin276", "Password276");
        Mahasiswa maha = new Mahasiswa("Shofa Khaifidn",202410370110276L );


        int MaxPercobaan = 3;
        int pilih = 0;
        int i;

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



        if (pilih == 1){
            for (i = 1; i <= MaxPercobaan ; i++){
                System.out.print("Masukan Username: ");
                String adminuser = InputPengguna.nextLine();

                System.out.print("Masukan Password: ");
                String adminPass = InputPengguna.nextLine();

                if (admin.login(adminuser,adminPass)){
                    System.out.println("Login Berhasil :)");
                    admin.display();
                    InputPengguna.close();
                    return;
                }
                else {
                    System.out.println("Kata sandi atau username salah!\nulangi lagi!\nAnda memiliki" + (MaxPercobaan -i) + "kesempatan");
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
               String UserMaha = InputPengguna.nextLine();
                System.out.print("Masukan NIM: ");
                if(InputPengguna.hasNextLong()) {
                    long PassMaha = InputPengguna.nextLong();
                    InputPengguna.nextLine();


                    if (maha.login(UserMaha,PassMaha)) {
                        System.out.println("Login Mahasiswa berhasil");
                        maha.displayMaha();
                        break;
                    } else {
                        System.out.println("Kata sandi atau username salah!\nulangi lagi!\nAnda memiliki " + (MaxPercobaan - 1) + " kesempatan");
                    }
                }
                else {
                    System.out.println("Nim harus berupa angka!");
                    System.out.println("ulangi lagi!\nAnda memiliki " + (MaxPercobaan - i) + " kesempatan");
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