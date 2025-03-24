package com.Codelab2;

import java.util.Scanner;

// Kelas RekeningBank
class RekeningBank {
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    // Konstruktor
    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // Metode untuk menampilkan informasi rekening
    public void tampilkanInfo() {
        System.out.println("\nNomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        System.out.println();
    }

    // Metode untuk menyetor uang
    public void setorUang(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println("Jumlah setor harus lebih dari 0!");
        }
    }

    // Metode untuk menarik uang
    public void tarikUang(double jumlah) {
        if (jumlah > saldo) {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + " (Gagal, saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
        } else if (jumlah > 0) {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + " (Berhasil) Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println("Jumlah tarik harus lebih dari 0!");
        }
    }
}

// Kelas Main untuk menjalankan program
public class Code2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat dua objek RekeningBank dengan input dari pengguna
        System.out.print("Masukkan nomor rekening pertama: ");
        String norek1 = input.nextLine();
        System.out.print("Masukkan nama pemilik rekening pertama: ");
        String nama1 = input.nextLine();
        System.out.print("Masukkan saldo awal rekening pertama: ");
        double saldo1 = input.nextDouble();

        RekeningBank rekening1 = new RekeningBank(norek1, nama1, saldo1);

        input.nextLine(); // Membuang karakter newline setelah nextDouble()

        System.out.print("\nMasukkan nomor rekening kedua: ");
        String norek2 = input.nextLine();
        System.out.print("Masukkan nama pemilik rekening kedua: ");
        String nama2 = input.nextLine();
        System.out.print("Masukkan saldo awal rekening kedua: ");
        double saldo2 = input.nextDouble();

        RekeningBank rekening2 = new RekeningBank(norek2, nama2, saldo2);

        // Menampilkan informasi awal
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // Melakukan transaksi lebih dari satu kali
        while (true) {
            System.out.println("\nPilih transaksi: ");
            System.out.println("1. Setor Uang");
            System.out.println("2. Tarik Uang");
            System.out.println("3. Tampilkan Informasi");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan: ");
            int pilihan = input.nextInt();

            if (pilihan == 1) {
                // Transaksi setor uang
                System.out.print("Pilih rekening (1 atau 2): ");
                int pilihRek = input.nextInt();
                System.out.print("Masukkan jumlah setor: Rp");
                double jumlah = input.nextDouble();

                if (pilihRek == 1) {
                    rekening1.setorUang(jumlah);
                } else if (pilihRek == 2) {
                    rekening2.setorUang(jumlah);
                } else {
                    System.out.println("Rekening tidak valid!");
                }
            } else if (pilihan == 2) {
                // Transaksi tarik uang
                System.out.print("Pilih rekening (1 atau 2): ");
                int pilihRek = input.nextInt();
                System.out.print("Masukkan jumlah tarik: Rp");
                double jumlah = input.nextDouble();

                if (pilihRek == 1) {
                    rekening1.tarikUang(jumlah);
                } else if (pilihRek == 2) {
                    rekening2.tarikUang(jumlah);
                } else {
                    System.out.println("Rekening tidak valid!");
                }
            } else if (pilihan == 3) {
                // Menampilkan informasi rekening
                rekening1.tampilkanInfo();
                rekening2.tampilkanInfo();
            } else if (pilihan == 4) {
                // Keluar dari program
                System.out.println("Terima kasih telah menggunakan layanan kami!");
                break;
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }

        input.close();
    }
}
