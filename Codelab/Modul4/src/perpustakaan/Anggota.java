package perpustakaan;

public class Anggota implements Peminjaman {
    private final String nama;
    private final String idAnggota;

    // Konstruktor menerima nama dan ID anggota
    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    // Menampilkan informasi anggota
    public void tampilkanIdentitas() {
        System.out.println("Anggota: " + nama + " [" + idAnggota + "]");
    }

    // Implementasi pinjamBuku tanpa durasi
    @Override
    public void pinjamBuku(String judul) {
        System.out.println(nama + " meminjam buku \"" + judul + "\".");
    }

    // Overload pinjamBuku dengan parameter durasi
    @Override
    public void pinjamBuku(String judul, int durasi) {
        System.out.println(nama + " meminjam buku \"" + judul + "\" selama " + durasi + " hari.");
    }

    // Implementasi method pengembalian buku
    @Override
    public void kembalikanBuku(String judul) {
        System.out.println(nama + " telah mengembalikan buku \"" + judul + "\".");
    }
}