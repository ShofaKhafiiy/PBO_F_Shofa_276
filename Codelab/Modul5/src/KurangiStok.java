import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KurangiStok extends BaseService {

    public KurangiStok(Scanner scanner, ArrayList<Barang> daftar) {
        super(scanner, daftar);
    }

    @Override
    public void execute() {
        try {
            if (daftar.isEmpty()) {
                System.out.println("⚠️ Tidak ada barang untuk dikurangi.");
                return;
            }

            System.out.println("\nPilih barang untuk dikurangi:");
            for (int i = 0; i < daftar.size(); i++) {
                System.out.println((i) + ". " + daftar.get(i).getNama() + " (Stok: " + daftar.get(i).getStok() + ")");
            }

            System.out.print("Masukkan indeks barang: ");
            int indeks = scanner.nextInt();

            System.out.print("Jumlah pengurangan stok: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();

            Barang barang = daftar.get(indeks);
            if (jumlah > barang.getStok()) {
                throw new StokTidakCukupException("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
            }

            barang.setStok(barang.getStok() - jumlah);
            System.out.println("✅ Stok berhasil dikurangi. Barang sisa: " + barang.getStok());
        } catch (InputMismatchException e) {
            System.out.println("❌ Input harus berupa angka!");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("❌ Indeks barang tidak valid.");
        } catch (StokTidakCukupException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}
