package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.models.Item;
import com.praktikum.storage.SystemStorage;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private final Scanner scanner = new Scanner(System.in);
    private String passAdmin;

    public Admin(String username, String passAdmin) {
        super(username);
        this.passAdmin = passAdmin;
    }

    public String getPassAdmin() {
        return passAdmin;
    }

    public void setPassAdmin(String password) {
        if (password != null && !password.isEmpty()) {
            this.passAdmin = password;
        }
    }

    @Override
    public boolean login() {
        for (User user : SystemStorage.userList) {
            if (user instanceof Admin admin) {
                return this.getName().equals(admin.getName()) &&
                        this.getPassAdmin().equals(admin.getPassAdmin());
            }
        }
        return false;
    }

    @Override
    public void afterLogin() {
        displayInfo();
        displayMenu();
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin: " + getName());
    }

    @Override
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("3. Lihat Daftar Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Input harus angka!");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> manageItems();
                case 2 -> manageUsers();
                case 3 -> viewAllMahasiswa();
                case 0 -> System.out.println("Logout...");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    @Override
    public void manageItems() {
        while (true) {
            System.out.println("\n=== Kelola Laporan Barang ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Diambil");
            System.out.println("3. Hapus Barang yang Sudah Diambil"); //
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 -> tampilkanSemuaBarang();
                case 2 -> tandaiBarangDiambil();
                case 3 -> hapusBarangClaimed(); //
                case 0 -> {
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void tampilkanSemuaBarang() {
        if (SystemStorage.reportedItems.isEmpty()) {
            System.out.println("Belum ada barang dilaporkan.");
            return;
        }

        System.out.printf("%-4s | %-20s | %-30s | %-20s | %-10s\n", "No", "Nama Barang", "Deskripsi", "Lokasi", "Status");
        System.out.println("---------------------------------------------------------------------------------------------");
        int index = 1;
        for (Item item : SystemStorage.reportedItems) {
            System.out.printf("%-4d | %-20s | %-30s | %-20s | %-10s\n",
                    index++, item.getItemName(), item.getDescription(), item.getLocation(), item.getStatus());
        }
    }

    private void tandaiBarangDiambil() {
        tampilkanSemuaBarang();

        System.out.print("\nMasukkan nomor item yang ingin ditandai sebagai 'Claimed': ");
        try {
            int idx = scanner.nextInt() - 1;
            scanner.nextLine();
            if (idx >= 0 && idx < SystemStorage.reportedItems.size()) {
                Item item = SystemStorage.reportedItems.get(idx);
                item.setStatus("Claimed");
                System.out.println("Status berhasil diubah menjadi 'Claimed'.");
            } else {
                System.out.println("Indeks tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka.");
            scanner.next();
        }
    }

    private void hapusBarangClaimed() { //
        if (SystemStorage.reportedItems.isEmpty()) {
            System.out.println("Tidak ada barang untuk dihapus.");
            return;
        }

        Iterator<Item> iterator = SystemStorage.reportedItems.iterator();
        int totalHapus = 0;

        while (iterator.hasNext()) {
            Item item = iterator.next();
            if ("Claimed".equalsIgnoreCase(item.getStatus())) {
                iterator.remove();
                totalHapus++;
            }
        }

        if (totalHapus > 0) {
            System.out.println("Berhasil menghapus " + totalHapus + " barang yang sudah diambil.");
        } else {
            System.out.println("Tidak ada barang dengan status 'Claimed'.");
        }
    }

    @Override
    public void manageUsers() {
        System.out.println("\n=== Kelola Mahasiswa ===");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa");

        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1 -> {
                System.out.print("Nama Mahasiswa: ");
                String nama = scanner.nextLine();
                System.out.print("NIM Mahasiswa: ");
                long nim = scanner.nextLong();
                scanner.nextLine();

                SystemStorage.userList.add(new Mahasiswa(nama, nim));
                System.out.println("Mahasiswa berhasil ditambahkan.");
            }
            case 2 -> {
                System.out.print("Masukkan NIM yang ingin dihapus: ");
                long targetNim = scanner.nextLong();
                scanner.nextLine();

                boolean found = false;
                for (int i = 0; i < SystemStorage.userList.size(); i++) {
                    User user = SystemStorage.userList.get(i);
                    if (user instanceof Mahasiswa mhs && mhs.getNim() == targetNim) {
                        SystemStorage.userList.remove(i);
                        found = true;
                        System.out.println("Mahasiswa berhasil dihapus.");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                }
            }
            default -> System.out.println("Pilihan tidak valid.");
        }
    }

    private void viewAllMahasiswa() {
        System.out.println("\n=== Daftar Mahasiswa Terdaftar ===");
        System.out.printf("%-4s | %-25s | %-15s\n", "No", "Nama", "NIM");
        System.out.println("-----------------------------------------------");

        int no = 1;
        for (User user : SystemStorage.userList) {
            if (user instanceof Mahasiswa mhs) {
                System.out.printf("%-4d | %-25s | %-15d\n", no++, mhs.getName(), mhs.getNim());
            }
        }
    }
}
