package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.models.Item;
import com.praktikum.storage.SystemStorage;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    private long nim;
    private final Scanner scanner = new Scanner(System.in);

    public Mahasiswa(String name, long nim) {
        super(name);
        this.nim = nim;
    }

    public long getNim() {
        return this.nim;
    }

    public void setNim(long nim) {
        this.nim = nim;
    }

    @Override
    public boolean login() {
        for (User u : SystemStorage.userList) {
            if (u instanceof Mahasiswa m) {
                if (m.getName().equals(getName()) && m.getNim() == getNim()) return true;
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
        super.displayInfo();
        System.out.println("NIM: " + this.nim);
    }

    @Override
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Laporkan Barang");
            System.out.println("2. Lihat Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus angka!");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> reportItem();
                case 2 -> viewReportedItems();
                case 0 -> System.out.println("Logout berhasil.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    @Override
    public void reportItem() {
        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        Item item = new Item(nama, deskripsi, lokasi);
        SystemStorage.reportedItems.add(item);

        System.out.println(">> Laporan berhasil dikirim.");
    }

    @Override
    public void viewReportedItems() {
        System.out.println("\n=== Daftar Barang Ditemukan ===");
        if (SystemStorage.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        System.out.printf("%-4s | %-20s | %-30s | %-20s\n", "No", "Nama Barang", "Deskripsi", "Lokasi");
        System.out.println("---------------------------------------------------------------------------------");

        int index = 1;
        for (Item item : SystemStorage.reportedItems) {
            if (item.getStatus().equalsIgnoreCase("Reported")) {
                System.out.printf("%-4d | %-20s | %-30s | %-20s\n", index++, item.getItemName(), item.getDescription(), item.getLocation());
            }
        }
    }

}
