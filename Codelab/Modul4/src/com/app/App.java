package com.app;


import perpustakaan.*;

public class App {
    public static void main(String[] args) {
        // Buat objek buku
        Buku buku1 = new NonFiksi("Teknologi Masa Depan", "Dr. Irwan");
        Buku buku2 = new Fiksi("Legenda Batu Hitam", "Ayu Larasati");

        // Tampilkan informasi buku
        buku1.displayInfo();
        buku2.displayInfo();

        System.out.println();

        // Buat dua anggota
        Anggota anggota1 = new Anggota("Shofa Khafidin", "F276");
        Anggota anggota2 = new Anggota("Ibrahim Shadiwa", "F240");

        anggota1.tampilkanIdentitas();
        anggota2.tampilkanIdentitas();

        System.out.println();

        // Simulasikan peminjaman buku
        anggota1.pinjamBuku("Teknologi Masa Depan");
        anggota2.pinjamBuku("Legenda Batu Hitam", 10);

        System.out.println();

        // Simulasikan pengembalian buku
        anggota1.kembalikanBuku("Teknologi Masa Depan");
        anggota2.kembalikanBuku("Legenda Batu Hitam");
    }
}

