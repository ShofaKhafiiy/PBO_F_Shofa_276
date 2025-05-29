package com.praktikum.main;

import com.praktikum.users.*;
import com.praktikum.storage.SystemStorage;

import java.util.Scanner;

public class Opration {
    static final Scanner sc = new Scanner(System.in);
    static final int MaxPercobaan = 3;

    public static void main(String[] args) {
        SystemStorage.userList.add(new Admin("Admin", "Password123"));
        SystemStorage.userList.add(new Mahasiswa("Shofa Khaifidn", 202410370110276L)); //
        while (true) {
            System.out.println("\nLogin sebagai:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            int pilih = getValidChoice();
            switch (pilih) {
                case 1 -> loginAdmin();
                case 2 -> loginMahasiswa();
                case 3 -> System.exit(0);
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static int getValidChoice() {
        while (!sc.hasNextInt()) {
            System.out.println("Harus angka!");
            sc.next();
        }
        return sc.nextInt();
    }

    static void loginAdmin() {
        sc.nextLine();
        for (int i = 0; i < MaxPercobaan; i++) {
            System.out.print("Username: ");
            String user = sc.nextLine();
            System.out.print("Password: ");
            String pass = sc.nextLine();
            Admin admin = new Admin(user, pass);
            if (admin.login()) {
                admin.afterLogin();
                return;
            }
            System.out.println("Gagal login.");
        }
    }

    static void loginMahasiswa() {
        sc.nextLine();
        for (int i = 0; i < MaxPercobaan; i++) {
            System.out.print("Nama: ");
            String nama = sc.nextLine();
            System.out.print("NIM: ");
            try {
                long nim = Long.parseLong(sc.nextLine());
                Mahasiswa m = new Mahasiswa(nama, nim);
                if (m.login()) {
                    m.afterLogin();
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("NIM harus angka.");
            }
            System.out.println("Gagal login.");
        }
    }
}
