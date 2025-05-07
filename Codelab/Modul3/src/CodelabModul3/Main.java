package CodelabModul3;

import java.util.Random;
import java.util.Scanner;

// Kelas dasar (Superclass) untuk karakter dalam game
class KarakterGame {
    private String nama;
    private int kesehatan;

    // Konstruktor untuk inisialisasi karakter
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    // Getter untuk mendapatkan nama karakter
    public String getNama() {
        return nama;
    }

    // Getter untuk mendapatkan kesehatan karakter
    public int getKesehatan() {
        return kesehatan;
    }

    // Setter untuk memperbarui kesehatan karakter
    public void setKesehatan(int kesehatan) {
        this.kesehatan = Math.max(kesehatan, 0); // Tidak bisa kurang dari 0
    }

    // Metode serang yang akan di-override oleh subclass
    public void serang(KarakterGame target) {
        System.out.printf("%s menyerang %s!%n", nama, target.getNama());
    }
}

// Kelas Pahlawan yang merupakan subclass dari KarakterGame
class Pahlawan extends KarakterGame {
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        Random rand = new Random();
        int damage = rand.nextInt(15, 26); // Damage antara 15-25

        System.out.printf("%s menyerang %s dengan Pedang dan memberikan %d damage!%n",
                getNama(), target.getNama(), damage);
        target.setKesehatan(target.getKesehatan() - damage);
        System.out.printf("Kesehatan %s sekarang: %d%n", target.getNama(), target.getKesehatan());
    }
}

// Kelas Musuh yang merupakan subclass dari KarakterGame
class Musuh extends KarakterGame {
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        Random rand = new Random();
        int damage = rand.nextInt(10, 21); // Damage antara 10-20

        System.out.printf("%s menyerang %s dengan Sihir dan memberikan %d damage!%n",
                getNama(), target.getNama(), damage);
        target.setKesehatan(target.getKesehatan() - damage);
        System.out.printf("Kesehatan %s sekarang: %d%n", target.getNama(), target.getKesehatan());
    }
}

// Kelas utama untuk menjalankan game
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi karakter
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        // Menampilkan status awal
        System.out.println("\n=== Status Awal ===");
        System.out.printf("%s memiliki kesehatan: %d%n", brimstone.getNama(), brimstone.getKesehatan());
        System.out.printf("%s memiliki kesehatan: %d%n", viper.getNama(), viper.getKesehatan());

        // Simulasi pertarungan
        System.out.println("\n=== Pertarungan Dimulai ===");
        brimstone.serang(viper);
        if (viper.getKesehatan() > 0) {
            viper.serang(brimstone);
        }

        // Menampilkan status akhir
        System.out.println("\n=== Status Akhir ===");
        System.out.printf("%s memiliki kesehatan: %d%n", brimstone.getNama(), brimstone.getKesehatan());
        System.out.printf("%s memiliki kesehatan: %d%n", viper.getNama(), viper.getKesehatan());
    }
}
