package com.Codelab2;
// Kelas Hewan dengan atribut dan metode tampilkanInfo()
class Hewan {
    // Atribut
    String nama;
    String jenis;
    String suara;

    // Konstruktor
    Hewan(String nama, String jenis, String suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    // Metode untuk menampilkan informasi hewan
    void tampilkanInfo() {
        System.out.println("Nama : " + nama);
        System.out.println("Jenis : " + jenis);
        System.out.println("Suara : " + suara);
        System.out.println();
    }
}

// Kelas Main untuk menjalankan program
public class Code1 {
    public static void main(String[] args) {
        // Membuat dua objek Hewan
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~");
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Wooff!!");

        // Memanggil metode tampilkanInfo() dari kedua objek
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}
