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
            System.out.println("\n=== Sistem Login ===");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");

            int pilih = getValidChoice();

            switch (pilih) {
                case 1 -> handleLogin(admin);
                case 2 -> handleLogin(maha);
                case 3 -> {
                    System.out.println("Keluar dari sistem. Terima Kasih!");
                    InputPengguna.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static int getValidChoice() {
        while (!InputPengguna.hasNextInt()) {
            System.out.print("Inputan harus angka (1-3): ");
            InputPengguna.next();
        }
        int val = InputPengguna.nextInt();
        InputPengguna.nextLine(); // clear buffer
        return val;
    }

    private static void handleLogin(User user) {
        for (int i = 1; i <= MaxPercobaan; i++) {
            System.out.print("Masukkan Nama: ");
            String nama = InputPengguna.nextLine().trim();
            if (nama.isEmpty()) {
                System.out.printf("Nama tidak boleh kosong! Sisa percobaan: %d\n", MaxPercobaan - i);
                continue;
            }
            user.setName(nama);

            if (user instanceof Admin admin) {
                System.out.print("Masukkan Password: ");
                String pass = InputPengguna.nextLine().trim();
                admin.setPassAdmin(pass);
            }

            if (user instanceof Mahasiswa mahasiswa) {
                System.out.print("Masukkan NIM: ");
                String nimStr = InputPengguna.nextLine().trim();
                if (!nimStr.matches("\\d+") || nimStr.length() > 15) {
                    System.out.printf("NIM tidak valid! Sisa percobaan: %d\n", MaxPercobaan - i);
                    continue;
                }
                mahasiswa.setNim(Long.parseLong(nimStr));
            }

            if (user.login()) {
                System.out.println("Login berhasil.");
                user.afterLogin();
                return;
            } else {
                System.out.printf("Login gagal. Sisa percobaan: %d\n", MaxPercobaan - i);
            }
        }
        System.out.println("Kesempatan habis. Coba lagi nanti.");
    }
}
