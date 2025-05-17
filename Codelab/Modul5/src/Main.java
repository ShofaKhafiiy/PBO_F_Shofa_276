import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    private static final BaseService tambahBarang = new TambahBarang(scanner, daftarBarang);
    private static final BaseService tampilBarang = new TampilBarang(scanner, daftarBarang);
    private static final BaseService kurangiStok = new KurangiStok(scanner, daftarBarang);

    public static void main(String[] args) {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = ambilPilihan();
            prosesMenu(pilihan);
        } while (pilihan != 0);

        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\n===== MENU MANAJEMEN STOK =====");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Tampilkan Barang");
        System.out.println("3. Kurangi Stok");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static int ambilPilihan() {
        while (!scanner.hasNextInt()) {
            System.out.println("❗ Harus angka!");
            scanner.next();
        }
        int angka = scanner.nextInt();
        scanner.nextLine(); // bersihkan newline
        return angka;
    }

    private static void prosesMenu(int pilihan) {
        switch (pilihan) {
            case 1 -> tambahBarang.execute();
            case 2 -> tampilBarang.execute();
            case 3 -> kurangiStok.execute();
            case 0 -> System.out.println("👋 Terima kasih!");
            default -> System.out.println("❌ Menu tidak tersedia.");
        }
    }
}
