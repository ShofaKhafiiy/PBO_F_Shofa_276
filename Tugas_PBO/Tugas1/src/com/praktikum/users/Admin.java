package com.praktikum.users;

import java.util.Scanner;

import com.praktikum.actions.AdminActions;


public class Admin extends User implements AdminActions{

    

    final Scanner scanner = new Scanner(System.in);

    private  String passAdmin;

    public Admin(String username, String passAdmin){
        super(username);
        this.passAdmin = passAdmin;

    }



    public String getPassAdmin(){
        return this.passAdmin;
    }

    public void setPassAdmin(String password){
       if (password != null && !password.isEmpty()){
            this.passAdmin = password;
       }
    }



    @Override
    public boolean login(){
        return getName().equals("Admin") && getPassAdmin().equals("Password123");
    }


    public void aksesPanel(){
        System.out.println("Admin dapat akses penuh ke sistem kampus");
    }

    @Override
    public void afterLogin(){
        displayInfo();
        aksesPanel();

    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Admin akses");
    }

  @Override
    public void displayMenu() {
        
        int choice;
        do {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
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
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }



    }



