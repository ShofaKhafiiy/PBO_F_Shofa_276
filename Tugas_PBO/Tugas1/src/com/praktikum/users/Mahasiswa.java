package com.praktikum.users;

import java.util.ArrayList;
import java.util.Scanner;

import com.praktikum.actions.MahasiswaActions;

public class Mahasiswa extends User implements MahasiswaActions {
    final ArrayList<String> laporan = new ArrayList<>();
    final Scanner scanner = new Scanner(System.in);
    private long nim;
    private String namaBarang ,deskripsi,   lokasi;
    
   




    public Mahasiswa(String userMaha, long nim) {
        super(userMaha);
        this.nim = nim;

    }


    //memberikan getter dan setter


    public long getNim() {
        return this.nim;
    }
    
    public String getNamaBarang(){
        return this.namaBarang;
    }

    public String getDeskripsi(){
        return this.deskripsi;
    }

    public String getLokasi(){
        return this.lokasi;
    }

    public void setNim(long nim) {
        this.nim = nim;}

    
    public void setNamaBarang(String newNamaBarang){
        this.namaBarang = newNamaBarang;
    }

    public void setDeskripsi(String newDeskripsi){
        this.deskripsi = newDeskripsi;
    }

    public void setLokasi(String newLokasi){
        this.lokasi = newLokasi;
    }

    
//getter setter selesai


   @Override
    public boolean login(){
        return getName().equals("Shofa Khafidin") && this.nim == 202410370110276L;
    }



    @Override
    public void afterLogin(){
        displayInfo();
        displayMenu();

    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("NIM: "+ getNim());
        System.out.println("Status Mahasiswa Aktif");
    }

    @Override
    public void displayMenu() {
        
        int choice;
        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    @Override
    public void reportItem() {
        
        System.out.print("Nama Barang: ");
         String namaBarang= scanner.nextLine();
         setNamaBarang(namaBarang);
        System.out.print("Deskripsi Barang: ");
         deskripsi = scanner.nextLine();
         setDeskripsi(deskripsi);
        System.out.print("Lokasi Terakhir/Ditemukan: ");
         lokasi = scanner.nextLine();
         setLokasi(lokasi);

         String laporanBaru = "Nama: " + namaBarang + ", Deskripsi: " + deskripsi + ", Lokasi: " + lokasi;
        laporan.add(laporanBaru);


        System.out.println(">> Laporan berhasil dikirim. <<");
    }

    @Override
    public  void viewReportedItems() {
        if (laporan.isEmpty()) {
            System.out.println("Belum ada laporan.");
        } else {
            System.out.println(">> Daftar Laporan <<");
            for (String lapor : laporan) {
                System.out.println("- " + lapor);
            }
        }
    }

    /* private static String laporanBaru(){
        System.out.println(">> Laporan Anda. <<");
    } */

    }


