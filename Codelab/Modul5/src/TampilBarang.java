import java.util.ArrayList;
import java.util.Scanner;

public class TampilBarang extends BaseService {

    public TampilBarang(Scanner scanner, ArrayList<Barang> daftar) {
        super(scanner, daftar);
    }

    @Override
    public void execute() {
        if (daftar.isEmpty()) {
            System.out.println("⚠️ Stok barang kosong.");
        } else {
            System.out.println("\n📦 Daftar Barang:");
            for (Barang b : daftar) {
                System.out.println("- " + b.getNama() + ": " + b.getStok() + " unit");
            }
        }
    }
}
