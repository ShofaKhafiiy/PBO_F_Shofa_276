package com.praktikum.main;

import com.praktikum.users.*;




import java.util.Scanner;




public class Opration {
    private static final Scanner InputPengguna = new Scanner(System.in);
    private static final int MaxPercobaan = 5;



    public static void main(String[] args) {
        User admin = new Admin("Admin", "Password123");

        User maha = new Mahasiswa("Shofa Khaifidn", 202410370110276L);


        while (true) {
            System.out.println("Pilih login:");
            System.out.println("1. Admin.");
            System.out.println("2. Mahasiswa.");
            System.out.println("3. Keluar Menu.");
            System.out.print("Pilih menu (1-3): ");

            int pilih = getValidChoice();

            switch (pilih){
                case 1 -> {
                    handleLoginAdmin(admin);
                    return;
                }
                case 2 ->{
                    handleLoginMahasiswa(maha);
                    return;
                }
                case 3 -> {
                    System.out.println("Keluar dari sistem. Terima Kasih!");
                    InputPengguna.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid");
            }

        }
    }


    private static  int getValidChoice() {
            while (!InputPengguna.hasNextInt()){
                InputPengguna.nextLine();
                System.out.println("Inputan anda harus berupa angka (1-3)\nSilahkan masukan kembali pilahan anda :)");

            }

            int val = InputPengguna.nextInt();
            InputPengguna.nextLine();
            return val;

    }


    private static void handleLoginMahasiswa(User mahasiswa){
        for (int i = 1; i <=MaxPercobaan; i++){
            System.out.print("Masukan Nama Mahasiswa: ");
            String nama= InputPengguna.nextLine().trim();
            System.out.print("Masukan NIM anda: ");
            String nim = InputPengguna.nextLine().trim();


            if (!isNumeric(nim)){
                System.out.printf("Nim harus berupa angka. Percobaan tersisa: %d\n", MaxPercobaan-i);
                continue;
            }

            if (nim.length()>15){
                System.out.printf("Nim maksimal 15 digit! Percobaan tersisa: %d\n", MaxPercobaan-i);
                continue;
            }

            long nimInput = Long.parseLong(nim);
            mahasiswa.setName(nama);
            ((Mahasiswa) mahasiswa).setNim(nimInput);

            if (mahasiswa.login()){
                System.out.println("Login mahasiswa berhasil");
                mahasiswa.afterLogin();
                return;
            }
            else{
                System.out.printf("Login gagal. Percobaan tersisa: %d", MaxPercobaan - i);
            }
        }

        System.out.println("Kesempatan anda habis. Silahkan coba lagi nanti.");
    }

    private static void handleLoginAdmin(User admin) {

        for (int i = 1; i <= MaxPercobaan; i++) {
            System.out.print("Masukan Username: ");
            String inputAdmin = InputPengguna.nextLine().trim();
            System.out.print("Masukan Password: ");
            String passAdmin = InputPengguna.nextLine().trim(); 

            ((Admin) admin).setPassAdmin(passAdmin);
            
            admin.setName(inputAdmin);

            if (admin.login()) {
                System.out.println("Login Admin berhasil!");
                admin.afterLogin();
                return;
            } else {
                System.out.printf("Login gagal. Percobaan tersisa: %d\n", MaxPercobaan - i);
            }

        }
        System.out.println("Kesempatan habis. silahkan coba lagi nanti");
    }

    private static boolean isNumeric(String str){
        return str.matches("\\d+");
    }




        }
