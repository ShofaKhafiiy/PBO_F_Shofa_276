import java.util.ArrayList;
import java.util.Scanner;

public abstract class BaseService {
    protected Scanner scanner;
    protected ArrayList<Barang> daftar;

    public BaseService(Scanner scanner, ArrayList<Barang> daftar) {
        this.scanner = scanner;
        this.daftar = daftar;
    }

    public abstract void execute(); // abstrak: harus dioverride
}
