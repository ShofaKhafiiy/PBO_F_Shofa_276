package perpustakaan;

public class Fiksi extends Buku {
    private final String genre = "Legenda"; // Kategori spesifik untuk buku Fiksi

    public Fiksi(String judul, String penulis) {
        super(judul, penulis);
    }

    // Implementasi displayInfo untuk menampilkan detail buku fiksi
    @Override
    public void displayInfo() {
        System.out.println("[FIKSI] Judul: " + judul + ", Penulis: " + penulis + ", Genre: " + genre);
    }
}
