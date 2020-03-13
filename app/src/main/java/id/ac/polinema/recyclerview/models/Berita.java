package id.ac.polinema.recyclerview.models;

public class Berita {
    String gambar, judul, kategori;

    public Berita(String gambar, String judul, String kategori) {
        this.gambar = gambar;
        this.judul = judul;
        this.kategori = kategori;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
