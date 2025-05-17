import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TambahBarang extends BaseService {

    public TambahBarang(Scanner scanner, ArrayList<Barang> daftar) {
        super(scanner, daftar);
    }

    @Override
    public void execute() {
        try {
            System.out.print("Masukkan nama barang: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan stok awal: ");
            int stok = scanner.nextInt();
            scanner.nextLine();

            daftar.add(new Barang(nama, stok));
            System.out.println("✅ Barang berhasil ditambahkan.");
        } catch (InputMismatchException e) {
            System.out.println("❌ Input stok harus berupa angka!");
            scanner.nextLine();
        }
    }
}
