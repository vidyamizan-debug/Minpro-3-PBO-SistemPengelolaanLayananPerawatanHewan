/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Layanan;
import model.Perawatan;
import model.Penitipan;
import model.Evalutable;
import View.Menu;

/**
 *
 * @author vidya
 */
public class CRUDKyaPetCare {

    private ArrayList<Layanan> daftarLayanan;
    private Scanner scanner;
    private CekKyaPetCare cek;
    private Menu menu;

    public CRUDKyaPetCare() {
        this.scanner = new Scanner(System.in);
        this.cek = new CekKyaPetCare();
        this.menu = new Menu();
        this.daftarLayanan = new ArrayList<>();

        daftarLayanan.add(new Perawatan("Perawatan Mandi", "Hati-hati yach dia agak ngereog kalo kena air..", 120000, "Kiya", "Kansa", "Kucing Himalayan", 3));
        daftarLayanan.add(new Penitipan("Anas harus dielus dulu baru mau tidur, disayang yaa dianya", 150000, "Anas", "Vidi", "Anjing Golden Retriever", 2, 3));
    }

    public void jalankan() {
        boolean berjalan = true;

        while (berjalan) {
            menu.tampilkanMenuUtama();

            int pilihan = cek.inputPilihan(scanner, "Pilih menu (1-5): ", 1, 5);

            switch (pilihan) {
                case 1:
                    tambahLayanan();
                    break;

                case 2:
                    tampilkanLayanan();
                    break;

                case 3:
                    updateLayanan();
                    break;

                case 4:
                    hapusLayanan();
                    break;

                case 5:
                    berjalan = false;
                    System.out.println("\nOkeey sampai jumpa lagi nanti userku!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia!");
                    break;
            }
        }

        scanner.close();
    }

    private String pilihNamaPerawatan() {
        System.out.println("\n+-------------------------+");
        System.out.println("|  Pilih Jenis Perawatan  |");
        System.out.println("+-------------------------+");
        System.out.println("| 1. Mandi                |");
        System.out.println("| 2. Potong Kuku          |");
        System.out.println("| 2. Bulu                 |");
        System.out.println("+-------------------------+");
        int pilihanJenis = cek.inputPilihan(scanner, "Pilihan (1-3): ", 1, 3);

        if (pilihanJenis == 1) {
            return "Perawatan Mandi";
        } else if (pilihanJenis == 2) {
            return "Perawatan Potong Kuku";
        } else {
            return "Perawatan Bulu";
        }
    }

    public void tambahLayanan() {
        System.out.println("\n+---------------------+");
        System.out.println("| Tambah Data Layanan |");
        System.out.println("+---------------------+");
        System.out.println("| 1. Perawatan        |");
        System.out.println("| 2. Penitipan        |");
        System.out.println("+---------------------+");
        int jenis = cek.inputPilihan(scanner, "Pilih jenis layanan (1-2): ", 1, 2);

        String catatan = cek.inputString(scanner, "Catatan untuk Petugas: ");
        int harga = cek.inputAngkaPositif(scanner, "Harga: ", "Harga");
        String namaHewan = cek.inputString(scanner, "Nama Hewan: ");
        String namaPemilik = cek.inputString(scanner, "Nama Pemilik: ");
        String jenisHewan = cek.inputString(scanner, "Jenis Hewan (contoh: Kucing Persia): ");
        int umurHewan = cek.inputAngkaPositif(scanner, "Umur Hewan: ", "Umur Hewan");

        try {
            if (jenis == 1) {
                String namaLayanan = pilihNamaPerawatan();

                Perawatan layanan = new Perawatan(namaLayanan, catatan, harga,
                        namaHewan, namaPemilik, jenisHewan, umurHewan);

                daftarLayanan.add(layanan);
                System.out.println("Horee! data sudah berhasil ditambahkan dengan ID " + layanan.getIdLayanan() + ".");
            } else {
                int lamaPenitipan = cek.inputAngkaPositif(scanner, "Lama Penitipan (hari): ", "Lama Penitipan");

                Penitipan layanan = new Penitipan(catatan, harga, namaHewan, namaPemilik,
                        jenisHewan, umurHewan, lamaPenitipan);

                daftarLayanan.add(layanan);
                System.out.println("Horee! data sudah berhasil ditambahkan dengan ID " + layanan.getIdLayanan() + ".");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampilkanLayanan() {
        System.out.println("\n+--------------------------------------+");
        System.out.println("|             Data Layanan             |");
        System.out.println("+--------------------------------------+");

        if (daftarLayanan.isEmpty()) {
            System.out.println("Belum ada data layanan.");
            return;
        }

        for (Layanan layanan : daftarLayanan) {
            cetakSatuLayanan(layanan);
        }

        System.out.println("+--------------------------------------+");
    }

    public void tampilkanLayanan(int id) {
        Layanan layanan = cariLayanan(id);

        if (layanan == null) {
            System.out.println("Maaff, data tidak berhasil untuk ditemukan!");
            return;
        }

        System.out.println("\n+--------------------------------------+");
        System.out.println("|             Data Layanan             |");
        System.out.println("+--------------------------------------+");
        cetakSatuLayanan(layanan);
        System.out.println("+--------------------------------------+");
    }

    private void cetakSatuLayanan(Layanan layanan) {
        System.out.println("----------------------------------------");
        layanan.tampilkanInfo();

        if (layanan instanceof Evalutable) {
            Evalutable diskon = (Evalutable) layanan;

            if (diskon.hitungDiskon() > 0) {
                layanan.cetakStatus("Dapat Diskon");
            } else {
                layanan.cetakStatus();
            }
        } else {
            layanan.cetakStatus();
        }
    }

    public void updateLayanan() {
        System.out.println("\n+--------------------------------------+");
        System.out.println("|          Update Data Layanan         |");
        System.out.println("+--------------------------------------+");

        Integer id = cek.inputIdBatal(scanner, "Masukkan ID Layanan (kosongkan untuk batal): ");

        if (id == null) {
            System.out.println("Dibatalkan, kembali ke menu.");
            return;
        }

        Layanan layanan = cariLayanan(id);

        if (layanan == null) {
            System.out.println("Maaff, data tidak berhasil untuk ditemukan!");
            return;
        }

        try {
            String catatan = cek.inputString(scanner, "Catatan Baru untuk Petugas: ");
            int harga = cek.inputAngkaPositif(scanner, "Harga Baru: ", "Harga");
            String namaHewan = cek.inputString(scanner, "Nama Hewan Baru: ");
            String namaPemilik = cek.inputString(scanner, "Nama Pemilik Baru: ");
            String jenisHewan = cek.inputString(scanner, "Jenis Hewan Baru (contoh: Kucing Persia): ");
            int umurHewan = cek.inputAngkaPositif(scanner, "Umur Hewan Baru: ", "Umur Hewan");

            layanan.setCatatan(catatan);
            layanan.setHarga(harga);
            layanan.setNamaHewan(namaHewan);
            layanan.setNamaPemilik(namaPemilik);
            layanan.setJenisHewan(jenisHewan);
            layanan.setUmurHewan(umurHewan);

            if (layanan instanceof Perawatan) {
                String namaLayananBaru = pilihNamaPerawatan();
                layanan.setNamaLayanan(namaLayananBaru);
            } else if (layanan instanceof Penitipan) {
                Penitipan penitipan = (Penitipan) layanan;
                int lamaPenitipan = cek.inputAngkaPositif(scanner, "Lama Penitipan Baru (hari): ", "Lama Penitipan");
                penitipan.setLamaPenitipan(lamaPenitipan);
            }

            System.out.println("Horee! data sudah berhasil diupdate.");
            tampilkanLayanan(id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void hapusLayanan() {
        System.out.println("\n+--------------------------------------+");
        System.out.println("|          Hapus Data Layanan          |");
        System.out.println("+--------------------------------------+");

        Integer id = cek.inputIdBatal(scanner, "Masukkan ID Layanan (kosongkan untuk batal): ");

        if (id == null) {
            System.out.println("Dibatalkan, kembali ke menu.");
            return;
        }

        Layanan layanan = cariLayanan(id);

        if (layanan == null) {
            System.out.println("Maaff, data tidak berhasil untuk ditemukan!");
            return;
        }

        cetakSatuLayanan(layanan);
        boolean yakin = cek.inputYaTidak(scanner, "Yakin ingin menghapus data ini? (ya/tidak): ");

        if (yakin) {
            daftarLayanan.remove(layanan);
            System.out.println("Data layanan berhasil dihapus!");
        } else {
            System.out.println("Penghapusan data dibatalkan.");
        }
    }

    private Layanan cariLayanan(int id) {
        for (Layanan layanan : daftarLayanan) {
            if (layanan.getIdLayanan() == id) {
                return layanan;
            }
        }

        return null;
    }
}
