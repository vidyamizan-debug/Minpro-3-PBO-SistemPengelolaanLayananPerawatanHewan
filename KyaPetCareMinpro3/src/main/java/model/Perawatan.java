/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vidya
 */
public class Perawatan extends Layanan implements Evalutable {
    public Perawatan(String namaLayanan, String catatan, int harga,
            String namaHewan, String namaPemilik, String jenisHewan, int umurHewan) {
        super(namaLayanan, catatan, harga, namaHewan, namaPemilik, jenisHewan, umurHewan);
    }

    @Override
    public String getKategori() {
        return "Perawatan";
    }

    @Override
    public double hitungDiskon() {
        if (getNamaLayanan().equalsIgnoreCase("Perawatan Bulu")) {
            return harga * 0.1;
        }
        return 0;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Diskon        : Rp" + hitungDiskon());
    }
}
