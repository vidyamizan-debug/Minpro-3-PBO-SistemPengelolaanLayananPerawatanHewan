# **Sistem Pengelolaan Layanan Perawatan Hewan - Kya's Pet Care**

# Vidya Khansa Mizan |  2509116052 | Sistem Informasi B 2025

## Deskripsi Program
Sistem Pengelolaan Layanan Perawatan Hewan adalah sebuah program berbasis bahasa pemrograman Java yang digunakan untuk mengelola data layanan perawatan hewan secara sederhana. Program ini berfokus pada layanan perawatan kebersihan dan penampilan hewan, yaitu Perawatan (mandi, potong kuku, perawatan bulu) dan Penitipan (jasa menitipkan hewan selama jangka waktu tertentu). Program ini memungkinkan pengguna untuk melakukan CRUD (Create, Read, Update, Delete) sederhana terhadap data layanan tersebut.

## Class yang ada di Program ini
**1. KyaPetCareMinpro3.java**\
Merupakan class utama atau entry point yang digunakan untuk menjalankan program. Class ini hanya memanggil satu method, yaitu 'jalankan()' dari class CRUDKyaPetCare.java, sehingga seluruh alur menu dan logika program terpusat di satu tempat.

**2. Layanan.java**\
Merupakan abstract class (superclass) yang menyimpan informasi umum mengenai layanan perawatan hewan, seperti ID layanan, nama layanan, catatan untuk petugas, harga, serta data hewan terkait (nama hewan, nama pemilik, jenis hewan, umur hewan). Class ini menerapkan constructor, getter, setter dengan validasi, encapsulation, serta memiliki satu abstract method yaitu 'getKategori()'.

**3. Perawatan.java**\
Merupakan class entitas (subclass dari Layanan, implements Evalutable) yang digunakan untuk data layanan yang berfokus pada kebersihan dan penampilan hewan (Mandi, Potong Kuku, atau Bulu).

**4. Penitipan.java**\
Merupakan class entitas (subclass dari Layanan, implements Evalutable) yang menambahkan atribut khusus lamaPenitipan, digunakan untuk data layanan jasa menitipkan hewan selama jangka waktu tertentu.

**5. CekKyaPetCare.java**\
Merupakan class yang menangani validasi seluruh input dari pengguna, seperti validasi angka, validasi angka harus lebih dari 0, validasi string tidak boleh kosong, validasi pilihan menu, validasi jawaban ya atau tidak, serta validasi ID dengan opsi pembatalan jika input dikosongkan.

**6. CRUDKyaPetCare.java**\
Merupakan class yang menangani proses CRUD pada program sekaligus menjalankan alur menu utama melalui method 'jalankan()'. Class ini menggunakan ArrayList untuk menyimpan data layanan, dan menyediakan fungsi untuk menambah, menampilkan, mengubah, dan menghapus data layanan.

**7. Menu.java**\
Merupakan class yang menampilkan tampilan menu utama program ke layar.

**8. Evalutable.java**\
Merupakan interface yang mendeklarasikan method 'hitungDiskon()'. Interface ini diimplementasikan oleh class Perawatan dan Penitipan, masing-masing dengan aturan diskon yang berbeda.

## Penerapan Polymorphism
Berikut ini ialah penerapan kedua jenis polymorphism yang saya gunakan:

### Override

<img width="401" height="153" alt="image" src="https://github.com/user-attachments/assets/e00ee4f1-3ea2-4142-a4c6-04b11dc7b896" />

<img width="377" height="69" alt="image" src="https://github.com/user-attachments/assets/6090509c-5bfa-406f-beca-d9989e601d38" />

<img width="417" height="83" alt="image" src="https://github.com/user-attachments/assets/95e6786e-d896-48c0-b30b-73fe5449a0e8" />

Salah satunya yang menggunakan Override adalah method 'tampilkanInfo()' yang ada di superclass Layanan di-override oleh subclass Perawatan dan Penitipan. Masing-masing subclass memanggil 'super.tampilkanInfo()' terlebih dahulu untuk menampilkan info umum, lalu menambahkan baris info khusus miliknya sendiri (diskon untuk Perawatan, lama penitipan dan diskon untuk Penitipan). Dengan begitu, meskipun dipanggil dengan cara yang sama lewat satu ArrayList bertipe Layanan, hasil tampilannya berbeda tergantung jenis objeknya.

### Overload

<img width="484" height="93" alt="image" src="https://github.com/user-attachments/assets/302eb1bb-652a-4dbf-886d-c6fbb89bce42" />

Salah satunya yang menggunakan Overload ialah method 'cetakStatus()' pada class Layanan yang memiliki dua versi, yaitu tanpa parameter (menampilkan status "Layanan Aktif") dan dengan parameter String (menampilkan status "Layanan Aktif" ditambah catatan tertentu, misalnya "Dapat Diskon").

## Penerapan Abstraction
Abstraction pada program ini diterapkan melalui abstract class dan abstract method pada class Layanan.

<img width="229" height="27" alt="image" src="https://github.com/user-attachments/assets/b3e93624-ae58-4bb8-a2f8-29f092f426f6" />

Class Layanan dideklarasikan sebagai abstract class, sehingga tidak dapat dibuat objeknya secara langsung (tidak bisa menulis 'new Layanan(...)'). Hal ini memastikan setiap objek yang dibuat harus berupa subclass yang jelas jenisnya, yaitu Perawatan atau Penitipan.

<img width="230" height="16" alt="image" src="https://github.com/user-attachments/assets/c50ac496-7db8-4104-bb9c-057f205341db" />

<img width="181" height="57" alt="image" src="https://github.com/user-attachments/assets/222fff43-c462-484f-8163-17aacca22148" />

<img width="181" height="60" alt="image" src="https://github.com/user-attachments/assets/0f6ba0d3-59b8-434d-9e9d-7e5d948d64ab" />

Class Layanan memiliki satu abstract method, yaitu 'getKategori()' yang tidak memiliki isi di superclass dan wajib diisi oleh setiap subclass. Class Perawatan mengembalikan nilai "Perawatan" dan class Penitipan mengembalikan nilai "Penitipan". Method ini kemudian dipanggil di dalam 'tampilkanInfo()' milik Layanan, sehingga superclass tidak perlu tahu detail bagaimana kategori ditentukan, cukup tahu bahwa method tersebut pasti tersedia di setiap subclass-nya.

## Penerapan MVC (Model-View-Controller)

<img width="189" height="176" alt="image" src="https://github.com/user-attachments/assets/d803c128-8276-4e40-87c2-186ce367842f" />

* **Model** (package model): berisi class Layanan, Evalutable, Perawatan, dan Penitipan. Bagian ini murni menyimpan data dan perilaku dasar objek, tanpa ada kode input/output menu di dalamnya.
* **View** (package View): berisi class Menu, yang tugasnya hanya menampilkan tampilan menu ke layar tanpa menyimpan data atau logika pemrosesan.
* **Controller** (package Controller): berisi class CekKyaPetCare (khusus validasi input) dan CRUDKyaPetCare (khusus proses tambah, tampil, update, hapus data, sekaligus menjalankan alur menu utama). Bagian ini menghubungkan Model dan View, yaitu mengambil input dari pengguna, memvalidasinya, memproses data pada objek Model, lalu meminta View menampilkan tampilan.

## Penerapan Nilai Tambah
Penerapan nilai tambah yang terapkan ialah penggunaan Interface.

### Interface

<img width="181" height="39" alt="image" src="https://github.com/user-attachments/assets/937b0021-780e-40bc-9035-801485d4e77a" />

Interface Evalutable mendeklarasikan satu method, yaitu 'hitungDiskon()'. Interface ini digunakan agar logika perhitungan diskon dapat diterapkan secara seragam pada beberapa class yang berbeda, tanpa harus mewariskannya lewat superclass.

<img width="185" height="95" alt="image" src="https://github.com/user-attachments/assets/bfac9928-b519-4da9-bc14-3916210837bd" />

<img width="379" height="95" alt="image" src="https://github.com/user-attachments/assets/edc90797-96f4-4cd2-b2ea-7a36441bc5d1" />

Class Perawatan dan Penitipan sama-sama mengimplementasikan interface Evalutable, namun dengan aturan perhitungan diskon yang berbeda. Pada Perawatan, diskon sebesar 10% dari harga diberikan jika nama layanannya adalah "Perawatan Bulu". Pada Penitipan, diskon tetap sebesar Rp20.000 diberikan jika lama penitipan sudah mencapai 5 hari atau lebih.

## Alur Program
Alur program dimulai ketika program dijalankan melalui class KyaPetCareMinpro3.java, yang langsung memanggil method 'jalankan()' pada class CRUDKyaPetCare.java. Program akan menampilkan menu utama yang berisi lima pilihan, yaitu Tambah Data Layanan, Tampilkan Data Layanan, Update Data Layanan, Hapus Data Layanan, dan Keluar.

Pengguna memilih menu dengan memasukkan angka sesuai pilihan. Saat menambah data, pengguna cukup memilih jenis layanannya (Perawatan atau Penitipan), lalu mengisi data umum (catatan untuk petugas, harga, data hewan) serta data khusus sesuai jenisnya. ID layanan dibuat otomatis oleh sistem sehingga pengguna tidak perlu menginputnya sendiri. Saat update atau hapus data, jika pengguna mengosongkan input ID, sistem akan otomatis membatalkan proses dan kembali ke menu utama.

Berikut adalah dokumentasi tampilan output sistem saat program dijalankan:

**1. Menu Utama**

<img width="167" height="127" alt="image" src="https://github.com/user-attachments/assets/11045686-6b2e-4e70-b837-f01c74818ee4" />

Gambar di atas merupakan tampilan awal atau yang biasa disebut menu utama dari program yang telah saya rancang dan jalankan. Dapat dilihat bahwa menu utamanya memiliki 5 pilihan utama, yaitu Tambah Data Layanan, Tampilkan Data Layanan, Update Data Layanan, Hapus Data Layanan, dan Keluar.

**2. Tambah Data Layanan**

<img width="152" height="92" alt="image" src="https://github.com/user-attachments/assets/d1d88541-d2fa-4090-8894-ce8b0db8ac4a" />

Setelah memilih menu nomor pertama, maka kita akan dialihkan ke pilihan menu untuk menambahkan jenis layanan. Dapat dilihat bahwa pada submenu Tambah Data Layanan terdapat 2 pilihan, yaitu Perawatan dan Penitipan.

* Tambah Data Layanan Perawatan

<img width="290" height="299" alt="image" src="https://github.com/user-attachments/assets/f7441e3a-f1dd-47a2-bec5-e90e55aecb92" />

Jika memilih opsi nomor 1 (perawatan), kita diminta mengisi formulir data layanan seperti pada gambar. Setelah mengisi formulir data umum, kita diminta memilih jenis perawatan (1-3) seperti pada gambar. Setelah diisi, muncul notifikasi "Horee! data sudah berhasil ditambahkan dengan ID 3." yang menandakan data telah tersimpan.

* Tambah Data Layanan Penitipan

<img width="322" height="195" alt="Screenshot 2026-10-08 203850" src="https://github.com/user-attachments/assets/a3d7a6f3-a2ed-4a24-ae03-92d324e5c8f5" />

Jika memilih opsi nomor 2 (penitipan), kita diminta mengisi formulir data layanan seperti pada gambar. Setelah mengisi formulir data umum, kita diminta memasukkan lama penitipan dalam hitungan hari seperti pada gambar. Setelah diisi, muncul notifikasi "Horee! data sudah berhasil ditambahkan dengan ID 4." yang menandakan data telah tersimpan.

**3. Tampilkan Data Layanan**

<img width="169" height="130" alt="image" src="https://github.com/user-attachments/assets/54ed4e76-4d8f-4d8a-8861-ccb157958328" />

Selanjutnya, jika memilih menu nomor 2 pada menu utama, maka kita akan dialihkan ke tampilan halaman untuk menampilkan data layanan.

<img width="415" height="368" alt="image" src="https://github.com/user-attachments/assets/92bbb694-6c2a-4308-92dd-942e79a29ee6" />

<img width="284" height="328" alt="image" src="https://github.com/user-attachments/assets/fdc4bf52-4d4e-4974-9e04-2a2feb40fdf7" />

Kedua gambar di atas merupakan tampilan daftar Data Layanan yang berfungsi untuk menampilkan seluruh data layanan yang telah tersimpan di dalam sistem.

**4. Update Data Layanan**

<img width="170" height="128" alt="image" src="https://github.com/user-attachments/assets/93035bc0-dd49-46c3-aa63-b3a0fc0f9fa4" />

Selanjutnya, jika memilih menu nomor 3 pada menu utama, maka kita akan dialihkan ke tampilan halaman untuk mengupdate data layanan.

<img width="357" height="383" alt="image" src="https://github.com/user-attachments/assets/c5025b18-3fa1-4df6-8102-cdb23d447f1c" />

Pada menu Update Data Layanan, kita diminta untuk memasukkan ID Layanan yang ingin diubah, lalu mengisi formulir data baru seperti pada gambar di atas. Setelah seluruh data diisi, sistem akan menampilkan notifikasi "Horee! data sudah berhasil diupdate." yang menandakan data telah diperbarui, lalu menampilkan rincian data layanan terbaru untuk ID tersebut.

**5. Hapus Data Layanan**

<img width="169" height="131" alt="image" src="https://github.com/user-attachments/assets/a741f413-3cd0-4d9d-81b6-fbde05743352" />

Selanjutnya, jika memilih menu nomor 4 pada menu utama, maka kita akan dialihkan ke tampilan halaman untuk menghapus data layanan.

<img width="295" height="245" alt="image" src="https://github.com/user-attachments/assets/ab95fe65-3007-47b0-ae70-968391bbd15a" />

Pada menu Hapus Data Layanan, kita diminta untuk memasukkan ID Layanan yang ingin dihapus terlebih dahulu. Setelah detail data ditampilkan, sistem akan meminta konfirmasi penghapusan (ya/tidak). Jika memilih "ya", maka sistem akan menampilkan notifikasi "Data layanan berhasil dihapus!" yang menandakan data telah terhapus dari sistem.

<img width="296" height="245" alt="image" src="https://github.com/user-attachments/assets/bc31aa49-56a6-47f5-b8ab-6ec4c2cef461" />

Jika memilih "tidak" pada konfirmasi penghapusan data, maka sistem akan menampilkan notifikasi "Penghapusan data dibatalkan." yang menandakan data tidak jadi dihapus dari sistem.

**6. Keluar**

<img width="209" height="155" alt="image" src="https://github.com/user-attachments/assets/6d57d27f-1682-47ef-98e1-f83c369af947" />

Jika jita memilih menu nomor kelima, maka kita akan dikeluarkan dari sistem.

**7. Input Validasi**

* Input Harus Berupa Angka

<img width="218" height="142" alt="Screenshot 2026-09-24 094039" src="https://github.com/user-attachments/assets/50e11c4d-a453-4a81-96a6-9e46bdf090cb" />

Pada gambar di atas, dapat dilihat bahwa jika pengguna memasukkan input selain angka, maka sistem akan menampilkan "ID yang dimasukkan harus berupa angka!" untuk memastikan input yang dimasukkan valid.
  
* Input Harus Lebih dari 0

<img width="231" height="65" alt="Screenshot 2026-09-24 095106" src="https://github.com/user-attachments/assets/8b24c49b-9615-463a-9395-100ff37cfceb" />

Pada gambar di atas, dapat dilihat bahwa jika pengguna memasukkan ID Layanan bernilai 0 atau diluar angka positif, maka sistem akan menampilkan "ID yang dimasukkan harus lebih dari 0!" untuk memastikan input yang dimasukkan valid.

* Input Tidak Boleh Kosong

<img width="164" height="130" alt="Screenshot 2026-09-24 095558" src="https://github.com/user-attachments/assets/04f3387f-f0c6-434c-b317-9f17218b0257" />

Pada gambar di atas, dapat dilihat bahwa jika pengguna mengosongkan inputan data, maka sistem akan menampilkan "Data tidak boleh kosong!" untuk memastikan input yang dimasukkan valid.

* Input Min & Max Pilihan

<img width="171" height="144" alt="Screenshot 2026-09-24 094917" src="https://github.com/user-attachments/assets/67b2cc55-2334-46a0-8179-896f444a653a" />

Pada gambar di atas, dapat dilihat bahwa jika pengguna memasukkan angka di luar jangkauan pilihan menu, maka sistem akan menampilkan "Pilihan hanya 1 sampai 5!" untuk memastikan input yang dimasukkan valid.

* Input Harus Berupa Ya/Tidak

<img width="281" height="233" alt="Screenshot 2026-09-24 100002" src="https://github.com/user-attachments/assets/dc186648-3a42-4c76-9e6d-2da8083cd75f" />

Pada gambar di atas, dapat dilihat bahwa jika pengguna memasukkan jawaban selain "ya" atau "tidak" pada konfirmasi penghapusan, maka sistem akan menampilkan "Jawaban harus 'ya' atau 'tidak'!" untuk memastikan input yang dimasukkan valid.

* ID Kosong saat Update/Hapus

<img width="251" height="68" alt="image" src="https://github.com/user-attachments/assets/60071f03-7055-4366-bfbf-1948751e7ae0" />

<img width="251" height="68" alt="image" src="https://github.com/user-attachments/assets/5b1a7a40-1a33-4cfd-9f0c-2dee25db036d" />

Jika pengguna mengosongkan input ID pada menu Update atau Hapus, sistem akan langsung membatalkan proses dan menampilkan "Dibatalkan, kembali ke menu." tanpa perlu melanjutkan proses update/hapus.
