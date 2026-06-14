# UAS Kualitas Perangkat Lunak – GradeEvaluator Automation

Repositori ini berisi proyek **Ujian Akhir Semester (UAS)** mata kuliah **Kualitas Perangkat Lunak**. Proyek ini mendemonstrasikan implementasi **Automated UI Testing** pada aplikasi Android **GradeEvaluator** menggunakan framework **Appium**.

## 👨‍🎓 Disusun Oleh

| Keterangan    | Detail                  |
| ------------- | ----------------------- |
| Nama          | Yafi Hidayatullah       |
| NPM           | 2308107010059           |


---

## 📁 Struktur Repositori

Repositori ini terdiri dari tiga komponen utama:

| Folder/File                 | Deskripsi                                                                       |
| --------------------------- | ------------------------------------------------------------------------------- |
| `GradeEvaluator/`           | Source code aplikasi Android yang diuji.                                        |
| `GradeEvaluatorAutomation/` | Script otomatisasi pengujian berbasis Java menggunakan Maven dan IntelliJ IDEA. |
| `GradeEvaluator.apk`        | File APK hasil build yang digunakan sebagai objek pengujian Appium.             |

---

## 🛠️ Teknologi dan Environment

* **Platform Target:** Android Emulator (Pixel 9 Pro – API 37)
* **Framework Automation:** Appium Java Client v8.6.0
* **WebDriver:** Selenium v4.13.0
* **Testing Framework:** TestNG v7.10.2
* **Build Tool:** Maven
* **IDE:** IntelliJ IDEA & Android Studio

---

## 🧪 Skenario Pengujian (Test Cases)

Pengujian difokuskan pada validasi logika konversi nilai angka menjadi nilai huruf (*grade*) serta penerapan *Boundary Value Analysis*.

### 1. Positive Testing (`testValidGradeInput`)

**Aksi:**

* Memasukkan nilai `85`
* Menekan tombol kalkulasi

**Ekspektasi:**

* Aplikasi menampilkan hasil:

```text
Grade: A
```

### 2. Negative Testing (`testInvalidGradeInput`)

**Aksi:**

* Memasukkan nilai `150` (di luar rentang yang valid)

**Ekspektasi:**

* Aplikasi menampilkan pesan error:

```text
Grade: Nilai tidak valid (0-100)
```

### Hasil Eksekusi

```text
Total tests run: 2
Passes: 2
Failures: 0
```

✅ Seluruh pengujian berhasil dijalankan tanpa kegagalan.

---

## 🚀 Cara Menjalankan Pengujian

### 1. Prasyarat (Prerequisites)

Pastikan perangkat telah terinstal:

* Java Development Kit (JDK) versi 11 atau lebih baru
* Node.js
* Appium Server (diinstal melalui NPM)
* Android Studio
* Android Emulator (minimal Android 8.0 / API Level 26)
* IntelliJ IDEA atau IDE Java lain yang mendukung Maven

---

### 2. Langkah Eksekusi

#### a. Clone Repository

```bash
git clone https://github.com/[Username-GitHub-Kamu]/UAS-Kualitas-Perangkat-Lunak.git
cd UAS-Kualitas-Perangkat-Lunak
```

#### b. Jalankan Appium Server

Buka Terminal atau Command Prompt, kemudian jalankan:

```bash
appium
```

Secara default Appium akan berjalan pada:

```text
http://127.0.0.1:4723
```

Biarkan proses ini tetap aktif selama pengujian berlangsung.

#### c. Jalankan Android Emulator

1. Buka **Android Studio**
2. Masuk ke **Device Manager**
3. Jalankan salah satu **Virtual Device (AVD)** yang tersedia

#### d. Sesuaikan Lokasi File APK

1. Buka folder `GradeEvaluatorAutomation` menggunakan IntelliJ IDEA.
2. Buka file:

```text
src/test/java/GradeEvaluatorTest.java
```

3. Cari baris:

```java
options.setApp("...");
```

4. Ganti dengan **absolute path** menuju file `GradeEvaluator.apk` pada komputer Anda.

Contoh:

```java
options.setApp("D:/Project/UAS-Kualitas-Perangkat-Lunak/GradeEvaluator.apk");
```

#### e. Jalankan Pengujian

1. Tunggu Maven menyelesaikan proses pengunduhan seluruh dependensi dari `pom.xml`.
2. Klik tombol **Run** (▶) pada class `GradeEvaluatorTest`, atau jalankan melalui panel **TestNG** di IntelliJ IDEA.

Jika konfigurasi telah benar, Appium akan membuka emulator, menjalankan aplikasi, dan mengeksekusi seluruh test case secara otomatis.

---

## ✅ Output yang Diharapkan

Setelah proses selesai, TestNG akan menampilkan hasil serupa berikut:

```text
===============================================
Default Suite
Total tests run: 2
Passes: 2
Failures: 0
Skips: 0
===============================================
```

---

## 📌 Catatan

* Pastikan emulator telah aktif sebelum menjalankan test.
* Pastikan Appium Server berjalan pada port default (`4723`).
* Pastikan lokasi file APK telah sesuai dengan konfigurasi pada `GradeEvaluatorTest.java`.
* Pengujian dilakukan menggunakan pendekatan *Black Box Testing* dan *Boundary Value Analysis (BVA)*.
