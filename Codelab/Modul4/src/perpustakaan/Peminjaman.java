package perpustakaan;

// Interface berisi kontrak method terkait proses peminjaman buku
public interface Peminjaman {
    void pinjamBuku(String judul); // Method pinjam tanpa durasi
    void pinjamBuku(String judul, int durasi); // Method pinjam dengan durasi
    void kembalikanBuku(String judul); // Method pengembalian
}