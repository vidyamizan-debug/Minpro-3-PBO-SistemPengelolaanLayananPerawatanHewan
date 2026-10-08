# **Sistem Pengelolaan Layanan Perawatan Hewan - Kya's Pet Care**

# Vidya Khansa Mizan |  2509116052 | Sistem Informasi B 2025

## Deskripsi Program
Sistem Pengelolaan Layanan Perawatan Hewan adalah sebuah program berbasis bahasa pemrograman Java yang digunakan untuk mengelola data layanan perawatan hewan secara sederhana. Program ini berfokus pada layanan perawatan kebersihan dan penampilan hewan, yaitu Perawatan (mandi, potong kuku, perawatan bulu) dan Penitipan (jasa menitipkan hewan selama jangka waktu tertentu). Program ini memungkinkan pengguna untuk melakukan CRUD (Create, Read, Update, Delete) sederhana terhadap data layanan tersebut.

## Class yang ada di Program ini
**1. Minpro2PBOKyaPetCare.java**\
Merupakan class utama atau entry point yang digunakan untuk menjalankan program. Class ini menampilkan menu utama, menerima input pilihan dari pengguna, dan memanggil fungsi yang sesuai dari class CRUDLayananKyaPetCare.java.

**2. Layanan.java**\
Merupakan class entitas (superclass) yang menyimpan informasi umum mengenai layanan perawatan hewan, seperti ID layanan, nama layanan, deskripsi, harga, serta data hewan terkait (nama hewan, nama pemilik, jenis hewan, ras hewan, umur hewan). Class ini menerapkan constructor, getter, setter, dan encapsulation.

**3. Perawatan.java**\
Merupakan class entitas (subclass dari Layanan) yang menambahkan atribut khusus jenisPerawatan, digunakan untuk data layanan yang berfokus pada kebersihan dan penampilan hewan.

**4. Penitipan.java**\
Merupakan class entitas (subclass dari Layanan) yang menambahkan atribut khusus lamaPenitipan, digunakan untuk data layanan jasa menitipkan hewan selama jangka waktu tertentu.

**5. CekKyaPetCare.java**\
Merupakan class yang menangani validasi seluruh input dari pengguna, seperti validasi angka, validasi angka harus lebih dari 0, validasi string tidak boleh kosong, validasi pilihan menu, dan validasi jawaban ya atau tidak.

**6. CRUDLayananKyaPetCare.java**\
Merupakan class yang menangani proses CRUD pada program. Class ini menggunakan ArrayList untuk menyimpan data layanan. Class ini menyediakan fungsi untuk menambah, menampilkan, mengubah, dan menghapus data layanan.

**7. Menu.java**
Merupakan class yang menampilkan tampilan menu utama program ke layar.

## Alur Perencanaan Program
Alur program dimulai ketika program dijalankan melalui class Minpro2PBOKyaPetCare.java. Program akan menampilkan menu utama yang berisi lima pilihan, yaitu Tambah Data Layanan, Tampilkan Data Layanan, Update Data Layanan, Hapus Data Layanan, dan Keluar.

Pengguna memilih menu dengan memasukkan angka sesuai pilihan. Program kemudian menggunakan percabangan untuk menentukan proses yang akan dijalankan berdasarkan pilihan pengguna. Pada menu Tambah Data, Tampilkan Data, Hapus Data, dan Update Data. Berbeda dengan pengerjaan sebelumnya yang memisahkan data Pemilik, Hewan, dan Layanan, pada Minpro 2 ini data hewan dan pemilik digabungkan menjadi atribut di dalam data Layanan itu sendiri, sehingga satu data layanan sudah mewakili satu transaksi lengkap untuk satu hewan. Pengguna cukup memilih jenis layanannya (Perawatan atau Penitipan) saat menambah data.

## Penerapan Encapsulation
Encapsulation diterapkan pada seluruh class di package model, yaitu class Layanan, Perawatan, Penitipan.

<img width="207" height="133" alt="image" src="https://github.com/user-attachments/assets/4cc0280c-653f-47b7-83c7-df127387cc68" />

Seperti yang dapt dilihat pada gambar di atas, seluruh atribut yang berada di dalam class Layanan, yang nantinya akan diturunkan ke subclass, dibuat menjadi protected. Sehingga data tidak dapat diakses langsung dari luar class. Untuk atribut id dibuat menjadi private final, sehingga hanya bisa sekali lewat di constructor dan tidak memiliki setter.

<img width="197" height="39" alt="image" src="https://github.com/user-attachments/assets/2da2dd8a-66f9-4905-8c74-412623e2c69d" />

<img width="293" height="41" alt="image" src="https://github.com/user-attachments/assets/e8027d65-d902-427f-816c-925a32c743d0" />

Setiap atribut yang boleh diubah memiliki getter dan setter, sehingga perubahan data hanya bisa dilakukan lewat method yang sudah disediakan. Hal ini berlaku untuk semua atribut kecuali atribut id.

## Penerapan Inheritance
Inheritance diterapkan pada class yang berada di package model.

<img width="619" height="310" alt="image" src="https://github.com/user-attachments/assets/116dd1b4-bb86-4c20-af6c-3b10657240e7" />

Seperti yang dapat dilihat pada gambar di atas, class Layanan merupakan superclass yang menyimpan atribut umum (idLayanan, namaLayanan, deskripsi, harga) beserta data hewan terkait (namaHewan, namaPemilik, jenisHewan, rasHewan, umurHewan).

<img width="685" height="119" alt="image" src="https://github.com/user-attachments/assets/094c72b7-b78b-48ac-b155-92ae59613c92" />

<img width="683" height="121" alt="image" src="https://github.com/user-attachments/assets/6ed64378-fbcd-45e5-8aba-e471bc3c494c" />

Kedua gambar di atas menunjukkan bahwa class  Perawatan dan Penitipan merupakan subclass yang menggunakan extends Layanan, sehingga mewarisi seluruh atribut dan method dari Layanan, ditambah atribut khusus masing-masing (jenisPerawatan untuk Perawatan, lamaPenitipan untuk Penitipan). Kedua subclass tersebut memanggil constructor superclass menggunakan super(...) untuk mengisi atribut umum sebelum mengisi atribut khususnya sendiri.

## Penerapan Nilai Tambah
Penerapan nilai tambah yang saya gunakan ada dua, yaitu penerapan pola MVC (Model-View-Controller) dan Polymorphism.

### MVC (Model-View-Controller)
MVC digunakan agar kode program tidak tercampur dalam satu class besar. Dengan MVC, tampilan menu, penyimpanan data, dan proses logika program dipisah menjadi tiga bagian dengan tanggung jawabnya masing-masing, sehingga program lebih rapi, lebih mudah ditelusuri kalau ada kesalahan, dan lebih mudah dikembangkan tanpa mengganggu bagian lain.

<img width="214" height="175" alt="image" src="https://github.com/user-attachments/assets/fb50137a-1166-4d8c-95ad-b6d226aec9b8" />

Dapat dilihat dari gambar di atas, package model berisi class Layanan, Perawatan, dan Penitipan. Bagian ini murni menyimpan data dan perilaku dasar objek, tanpa ada kode input/output menu di dalamnya. Selanjutnya ada package view berisi class Menu, yang tugasnya hanya menampilkan tampilan menu ke layar tanpa menyimpan data atau logika pemrosesan. Dan yang terakhir ialah package controller berisi class CekKyaPetCare (khusus validasi input) dan CRUDLayananKyaPetCare (khusus proses tambah, tampil, update, dan hapus data). Bagian ini menghubungkan Model dan View, yaitu mengambil input dari pengguna, memvalidasinya, memproses data pada objek Model, lalu meminta View menampilkan tampilan.

### Polymorphism
Polymorphism digunakan agar satu ArrayList bertipe Layanan bisa menampung objek Perawatan maupun Penitipan sekaligus, dan cukup dipanggil dengan cara yang sama (disini saya menggunakan 'tampilkanInfo()') tanpa harus membuat banyak percabangan untuk mengecek jenis objeknya satu per satu.

<img width="403" height="149" alt="image" src="https://github.com/user-attachments/assets/3f28de75-8da7-4068-a808-e0a91be43d4e" />

Pada gambar di atas, dapat dilihat bahwa polymorphism diterapkan melalui method overriding pada method tampilkanInfo() yang ada di superclass Layanan. Method ini di-override oleh subclass Perawatan dan Penitipan, sehingga meskipun dipanggil dengan cara yang sama, hasil tampilan informasinya berbeda tergantung jenis objeknya.

<img width="422" height="83" alt="image" src="https://github.com/user-attachments/assets/055bee08-fa8c-482e-8669-bf60bde53ce9" />

Jika objeknya Penitipan, tampilkanInfo() akan menampilkan info umum layanan ditambah baris lama penitipan.

<img width="378" height="86" alt="image" src="https://github.com/user-attachments/assets/54673b9b-885d-4d9b-ac7e-d0da1ec08223" />

Jika objeknya Perawatan, tampilkanInfo() akan menampilkan info umum layanan ditambah baris jenis perawatan.

## Tampilan Output Sistem

**1. Menu Utama**

<img width="167" height="127" alt="image" src="https://github.com/user-attachments/assets/11045686-6b2e-4e70-b837-f01c74818ee4" />

Gambar di atas merupakan tampilan awal atau yang biasa disebut menu utama dari program yang telah saya rancang dan jalankan. Dapat dilihat bahwa menu utamanya memiliki 5 pilihan utama, yaitu Tambah Data Layanan, Tampilkan Data Layanan, Update Data Layanan, Hapus Data Layanan, dan Keluar.

**2. Tambah Data Layanan**

<img width="152" height="92" alt="image" src="https://github.com/user-attachments/assets/d1d88541-d2fa-4090-8894-ce8b0db8ac4a" />

Setelah memilih menu nomor pertama, maka kita akan dialihkan ke pilihan menu untuk menambahkan jenis layanan. Dapat dilihat bahwa pada submenu Tambah Data Layanan terdapat 2 pilihan, yaitu Perawatan dan Penitipan.

* Tambah Data Layanan Perawatan

<img width="221" height="233" alt="image" src="https://github.com/user-attachments/assets/6522e991-ec21-42dc-a2f8-34185e95074b" />

Jika memilih opsi nomor 1 (perawatan), kita diminta mengisi formulir data layanan seperti pada gambar. Setelah diisi, muncul notifikasi "Horee! data sudah berhasil ditambahkan." yang menandakan data telah tersimpan.

* Tambah Data Layanan Penitipan

<img width="215" height="233" alt="image" src="https://github.com/user-attachments/assets/54259fbe-ba41-4a36-84f8-f202f5b28887" />

Jika memilih opsi nomor 2 (penitipan), kita diminta mengisi formulir data layanan seperti pada gambar. Setelah diisi, muncul notifikasi "Horee! data sudah berhasil ditambahkan." yang menandakan data telah tersimpan.

**3. Tampilkan Data Layanan**

<img width="169" height="130" alt="image" src="https://github.com/user-attachments/assets/54ed4e76-4d8f-4d8a-8861-ccb157958328" />

Selanjutnya, jika memilih menu nomor 2 pada menu utama, maka kita akan dialihkan ke tampilan halaman untuk menampilkan data layanan.

<img width="246" height="382" alt="image" src="https://github.com/user-attachments/assets/feab7ca1-1d49-4fb5-8784-1499ce420ba1" />

<img width="228" height="341" alt="image" src="https://github.com/user-attachments/assets/66c67345-4b39-489e-a6ac-2ec49f8b9e7d" />

Kedua gambar di atas merupakan tampilan daftar Data Layanan yang berfungsi untuk menampilkan seluruh data layanan yang telah tersimpan di dalam sistem.

**4. Update Data Layanan**

<img width="170" height="128" alt="image" src="https://github.com/user-attachments/assets/93035bc0-dd49-46c3-aa63-b3a0fc0f9fa4" />

Selanjutnya, jika memilih menu nomor 3 pada menu utama, maka kita akan dialihkan ke tampilan halaman untuk mengupdate data layanan.

<img width="227" height="196" alt="image" src="https://github.com/user-attachments/assets/5b98a945-81e3-4394-bcd5-b420f366170a" />

Pada menu Update Data Layanan, kita diminta untuk memasukkan ID Layanan yang ingin diubah, lalu mengisi formulir data baru seperti pada gambar di atas. Setelah seluruh data diisi, sistem akan menampilkan notifikasi "Horee! data sudah berhasil diupdate." yang menandakan data telah diperbarui.

**5. Hapus Data Layanan**

<img width="169" height="131" alt="image" src="https://github.com/user-attachments/assets/a741f413-3cd0-4d9d-81b6-fbde05743352" />

Selanjutnya, jika memilih menu nomor 4 pada menu utama, maka kita akan dialihkan ke tampilan halaman untuk menghapus data layanan.

<img width="265" height="244" alt="image" src="https://github.com/user-attachments/assets/fb248c43-09d8-478d-9f8e-c799e4abc9b8" />

Pada menu Hapus Data Layanan, kita diminta untuk memasukkan ID Layanan yang ingin dihapus terlebih dahulu. Setelah detail data ditampilkan, sistem akan meminta konfirmasi penghapusan (ya/tidak). Jika memilih "ya", maka sistem akan menampilkan notifikasi "Data layanan berhasil dihapus!" yang menandakan data telah terhapus dari sistem.

<img width="276" height="242" alt="image" src="https://github.com/user-attachments/assets/e5abb47b-a181-4066-90f4-7ea706f8f2ec" />

Jika memilih "tidak" pada konfirmasi penghapusan data, maka sistem akan menampilkan notifikasi "Penghapusan data dibatalkan." yang menandakan data tidak jadi dihapus dari sistem.

**6. Keluar**

<img width="173" height="190" alt="image" src="https://github.com/user-attachments/assets/17035eca-7f41-4a98-8e5c-842a60611d23" />

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
