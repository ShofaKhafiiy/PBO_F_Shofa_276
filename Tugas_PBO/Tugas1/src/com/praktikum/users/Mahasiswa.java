package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    private long nim;
    final Scanner scanner = new Scanner(System.in);

    public Mahasiswa(String nama, long nim) {
        super(nama);
        this.nim = nim;
    }

    public void setNim(long nim) {
        this.nim = nim;
    }

    public long getNim() {
        return nim;
    }

    @Override
    public boolean login() {
        return getName().equals("Shofa Khaifidn") && this.nim == 202410370110276L;
    }

    @Override
    public void afterLogin() {
        displayInfo();
        displayMenu();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("NIM: " + getNim());
        System.out.println("Status: Mahasiswa Aktif");
    }

    @Override
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Laporkan Barang");
            System.out.println("2. Lihat Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Masukkan angka yang valid (0-2): ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> reportItem();
                case 2 -> viewReportedItems();
                case 0 -> System.out.println("Logout...");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    @Override
    public void reportItem() {
        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Deskripsi: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi: ");
        String lokasi = scanner.nextLine();

        System.out.println(">> Laporan Terkirim:");
        System.out.println("Nama: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Lokasi: " + lokasi);
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> (Simulasi) Tidak ada laporan tersimpan karena belum pakai ArrayList.");
    }
}
