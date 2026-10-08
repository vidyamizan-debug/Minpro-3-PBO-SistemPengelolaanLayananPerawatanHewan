/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.util.Scanner;

/**
 *
 * @author vidya
 */
public class CekKyaPetCare {
    public int inputAngka(Scanner scanner, String pesan, String namaField) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Mohon maaf, " + namaField + " harus berupa angka yaa!");
            }
        }
    }

    public int inputAngkaPositif(Scanner scanner, String pesan, String namaField) {
        while (true) {
            int angka = inputAngka(scanner, pesan, namaField);

            if (angka > 0) {
                return angka;
            }

            System.out.println("Mohon maaf, " + namaField + " harus lebih dari 0 yaa!");
        }
    }

    public String inputString(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine();

            if (!input.trim().isEmpty()) {
                return input;
            }

            System.out.println("Data tidak boleh kosong yaa!");
        }
    }

    public int inputPilihan(Scanner scanner, String pesan, int min, int max) {
        while (true) {
            int pilihan = inputAngka(scanner, pesan, "Pilihan");

            if (pilihan >= min && pilihan <= max) {
                return pilihan;
            }

            System.out.println("Pilihan anda hanya dari " + min + " sampai dengan " + max + "!");
        }
    }

    public boolean inputYaTidak(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("ya")) {
                return true;
            } else if (input.equalsIgnoreCase("tidak")) {
                return false;
            }

            System.out.println("Jawaban anda harus diantara 'ya' atau 'tidak'!");
        }
    }

    public Integer inputIdBatal(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                return null;
            }

            try {
                int id = Integer.parseInt(input.trim());

                if (id > 0) {
                    return id;
                }

                System.out.println("ID harus lebih dari 0!");
            } catch (NumberFormatException e) {
                System.out.println("ID harus berupa angka!");
            }
        }
    }
}
