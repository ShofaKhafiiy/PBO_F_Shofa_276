package perpustakaan;

// Kelas abstrak Buku menjadi blueprint bagi buku jenis Fiksi dan NonFiksi
public abstract class Buku {
    protected String judul;
    protected String penulis;

    // Konstruktor untuk mengatur judul dan penulis
    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    // Method abstrak yang harus diimplementasikan oleh subclass
    public abstract void displayInfo();
}