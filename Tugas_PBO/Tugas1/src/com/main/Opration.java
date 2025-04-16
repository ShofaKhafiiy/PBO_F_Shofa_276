package com.main;

import com.user.*;


import java.util.Scanner;




public class Opration {
    private static final Scanner InputPengguna = new Scanner(System.in);
    private static final int MaxPercobaan = 3;


    private static  int getValidChoice() {
            while (!InputPengguna.hasNextInt()){
                InputPengguna.nextLine();
                System.out.println("Inputan anda harus berupa angka (1-3)\nSilahkan masukan kembali pilahan anda :)");

            }

            int val = InputPengguna.nextInt();
            InputPengguna.nextLine();
            return val;

    }


    private static void handleLogin(User user){

        for(int i = 1; i <= MaxPercobaan; i++){
            if (user.login()){
                System.out.println("Login berhasil");
                user.afterLogin();
                return;
            }

            else{
                System.out.printf("Login gagal. Percobaan tersisa: %d\n", MaxPercobaan-i);
            }
        }

    }


    public static void main(String[] args) {
        Admin admin = new Admin("Admin276", "Password276");
        Mahasiswa maha = new Mahasiswa("Shofa Khaifidn", 202410370110276L);

        int i;
        while (true) {
            System.out.println("Pilih login:");
            System.out.println("1. Admin.");
            System.out.println("2. Mahasiswa.");
            System.out.println("3. Keluar Menu.");
            System.out.print("Pilih menu (1-3): ");

            int pilih = getValidChoice();

                switch (pilih){
                    case 1 -> handleLogin(admin);
                    case 2 -> handleLogin(maha);
                    case 3 -> {
                        System.out.println("Keluar dari sistem. Terima Kasih!");
                        InputPengguna.close();
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid");
                }

                }
            }

        }
