package perpustakaan;

public class NonFiksi extends Buku {
    private final String bidang = "Teknologi dan Sains"; // Kategori untuk buku NonFiksi

    public NonFiksi(String judul, String penulis) {
        super(judul, penulis);
    }

    // Implementasi displayInfo untuk menampilkan detail buku non-fiksi
    @Override
    public void displayInfo() {
        System.out.println("[NON-FIKSI] Judul: " + judul + ", Penulis: " + penulis + ", Bidang: " + bidang);
    }
}
