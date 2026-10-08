/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vidya
 */
public class Penitipan extends Layanan implements Evalutable {
    private int lamaPenitipan;

    public Penitipan(String catatan, int harga, String namaHewan, String namaPemilik,
            String jenisHewan, int umurHewan, int lamaPenitipan) {
        super("Penitipan " + lamaPenitipan + " Hari", catatan, harga,
                namaHewan, namaPemilik, jenisHewan, umurHewan);
        setLamaPenitipan(lamaPenitipan);
    }

    public int getLamaPenitipan() {
        return lamaPenitipan;
    }

    public void setLamaPenitipan(int lamaPenitipan) {
        if (lamaPenitipan <= 0) {
            throw new IllegalArgumentException("Lama penitipan harus lebih dari 0!");
        }
        this.lamaPenitipan = lamaPenitipan;
        setNamaLayanan("Penitipan " + lamaPenitipan + " Hari");
    }

    @Override
    public String getKategori() {
        return "Penitipan";
    }

    @Override
    public double hitungDiskon() {
        if (lamaPenitipan >= 5) {
            return 20000;
        }
        return 0;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Lama Penitipan: " + lamaPenitipan + " hari");
        System.out.println("Diskon        : Rp" + hitungDiskon());
    }
}
