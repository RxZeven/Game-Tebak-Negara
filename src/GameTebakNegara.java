import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

// Kelas GameTebakNegara
class GameTebakNegara {
    private List<Negara> daftarNegaraMudah;
    private List<Negara> daftarNegaraSedang;
    private List<Negara> daftarNegaraSusah;
    private Random random;
    Leaderboard leaderboard; // Instance leaderboard

    public GameTebakNegara() {
        daftarNegaraMudah = new ArrayList<>();
        daftarNegaraSedang = new ArrayList<>();
        daftarNegaraSusah = new ArrayList<>();
        random = new Random();
        leaderboard = new Leaderboard("leaderboard.txt"); // Inisialisasi leaderboard
        initData();
    }

    private void initData() {

        // Negara untuk level Mudah (tetap seperti sebelumnya)
        daftarNegaraMudah.add(new Negara("indonesia", "Merah dan Putih", "Negara terbesar di Asia Tenggara.", "Asia"));
        daftarNegaraMudah.add(new Negara("jepang", "Merah dan Putih", "Negara matahari terbit.","Asia"));
        daftarNegaraMudah.add(new Negara("korea", "Putih, Biru, Merah, dan Hitam", "Negara yang terkenal dengan K-Pop.", "Asia"));
        daftarNegaraMudah.add(new Negara("india", "Oranye, Putih, dan Hijau", "Negara dengan populasi terbesar kedua.", "Asia"));
        daftarNegaraMudah.add(new Negara("china", "Merah dan Kuning", "Negara dengan populasi terbesar di dunia.", "Asia"));
        daftarNegaraMudah.add(new Negara("mesir", "Merah, Putih, dan Hitam", "Negara dengan piramida.", "Asia"));
        daftarNegaraMudah.add(new Negara("brunei", "Kuning, Putih, dan Hitam", "Negara kecil kaya di Asia Tenggara.", "Asia"));
        daftarNegaraMudah.add(new Negara("samoa", "Biru, Merah, dan Putih", "Negara pulau di Pasifik.", "Asia Pasifik"));
        daftarNegaraMudah.add(new Negara("laos", "Merah, Biru, dan Putih", "Negara tanpa laut di Asia Tenggara.", "Asia"));
        daftarNegaraMudah.add(new Negara("chile", "Merah, Biru, dan Putih", "Negara panjang di Amerika Selatan.","Amerika Selatan"));
        daftarNegaraMudah.add(new Negara("italia", "Hijau, Putih, dan Merah", "Negara berbentuk sepatu bot.", "Eropa"));
        daftarNegaraMudah.add(new Negara("peru", "Merah dan Putih", "Negara Andes dengan Machu Picchu.","Amerika Selatan"));
        daftarNegaraMudah.add(new Negara("yunani", "Biru dan Putih", "Negara asal filosofi barat.","Eropa"));
        daftarNegaraMudah.add(new Negara("spanyol", "Merah dan Kuning", "Negara matador.","Eropa"));
        daftarNegaraMudah.add(new Negara("fiji", "Biru Muda, Merah, dan Putih", "Negara pulau di Pasifik.","Asia Pasifik"));

        // Negara untuk level Sedang (tetap seperti sebelumnya)
        daftarNegaraSedang.add(new NegaraBenua("norwegia", "Merah, Putih, dan Biru", "Negara di Skandinavia.", "Eropa"));
        daftarNegaraSedang.add(new NegaraBenua("kanada", "Merah dan Putih", "Negara dengan daun maple.", "Amerika Utara"));
        daftarNegaraSedang.add(new NegaraBenua("rusia", "Putih, Biru, dan Merah", "Negara terbesar di dunia.", "Eropa/Asia"));
        daftarNegaraSedang.add(new NegaraBenua("meksiko", "Hijau, Putih, dan Merah", "Negara dengan sombrero.", "Amerika Utara"));
        daftarNegaraSedang.add(new NegaraBenua("turki", "Merah dan Putih", "Negara yang terletak di dua benua.", "Eropa/Asia"));
        daftarNegaraSedang.add(new NegaraBenua("iran", "Hijau, Putih, dan Merah", "Negara dengan sejarah Persia.", "Asia"));
        daftarNegaraSedang.add(new NegaraBenua("portugal", "Merah dan Hijau", "Negara penjelajah laut.", "Eropa"));
        daftarNegaraSedang.add(new NegaraBenua("belgia", "Merah, Kuning, dan Hitam", "Negara dengan cokelat terbaik.", "Eropa"));
        daftarNegaraSedang.add(new NegaraBenua("polandia", "Merah dan Putih", "Negara di Eropa Timur.", "Eropa"));
        daftarNegaraSedang.add(new NegaraBenua("jerman", "Hitam, Merah, dan Kuning", "Negara dengan bir Oktoberfest.", "Eropa"));
        daftarNegaraSedang.add(new NegaraBenua("swedia", "Kuning dan Biru", "Negara di Skandinavia.", "Eropa"));
        daftarNegaraSedang.add(new NegaraBenua("hungaria", "Merah, Putih, dan Hijau", "Negara dengan sejarah kerajaan.", "Eropa"));
        daftarNegaraSedang.add(new NegaraBenua("irlandia", "Hijau, Putih, dan Oranye", "Negara dengan leprechaun.", "Eropa"));
        daftarNegaraSedang.add(new NegaraBenua("kroasia", "Merah, Putih, dan Biru", "Negara dengan garis pantai indah.", "Eropa"));
        daftarNegaraSedang.add(new NegaraBenua("finlandia", "Putih dan Biru", "Negara dengan banyak danau.", "Eropa"));

        // Negara untuk level Sulit
        daftarNegaraSusah.add(new NegaraBenua("mozambik", "Hijau, Hitam, Kuning, dan Merah", "Negara di Afrika Timur.", "Afrika"));
        daftarNegaraSusah.add(new NegaraBenua("botswana", "Biru, Hitam, dan Putih", "Negara dengan banyak satwa liar.", "Afrika"));
        daftarNegaraSusah.add(new NegaraBenua("suriname", "Hijau, Merah, Putih, dan Kuning", "Negara kecil di Amerika Selatan.", "Amerika Selatan"));
        daftarNegaraSusah.add(new NegaraBenua("kolombia", "Kuning, Biru, dan Merah", "Negara di Amerika Selatan.", "Amerika Selatan"));
        daftarNegaraSusah.add(new NegaraBenua("selandia baru", "Biru, Putih, dan Merah", "Negara pulau di Oceania.", "Oceania"));
        daftarNegaraSusah.add(new NegaraBenua("argentina", "Biru Muda dan Putih", "Negara asal tango.", "Amerika Selatan"));
        daftarNegaraSusah.add(new NegaraBenua("uruguay", "Biru Muda dan Putih", "Negara kecil di Amerika Selatan.", "Amerika Selatan"));
        daftarNegaraSusah.add(new NegaraBenua("bhutan", "Kuning dan Oranye", "Negara Himalaya kecil.", "Asia"));
        daftarNegaraSusah.add(new NegaraBenua("mongolia", "Merah, Biru, dan Kuning", "Negara di Asia Tengah.", "Asia"));
        daftarNegaraSusah.add(new NegaraBenua("pakistan", "Hijau dan Putih", "Negara tetangga India.", "Asia"));
        daftarNegaraSusah.add(new NegaraBenua("islandia", "Biru, Merah, dan Putih", "Negara Nordik dengan geyser.", "Eropa"));
        daftarNegaraSusah.add(new NegaraBenua("azerbaijan", "Hijau, Merah, Biru, dan Putih", "Negara di Kaukasus.", "Asia"));
        daftarNegaraSusah.add(new NegaraBenua("kyrgyzstan", "Merah dan Kuning", "Negara di Asia Tengah.", "Asia"));
        daftarNegaraSusah.add(new NegaraBenua("malta", "Putih dan Merah", "Negara kecil di Laut Mediterania.", "Eropa"));
        daftarNegaraSusah.add(new NegaraBenua("panama", "Merah, Putih, dan Biru", "Negara dengan kanal terkenal.", "Amerika Tengah"));

    }

    public void tampilkanMenuUtama() {
        Scanner scanner = new Scanner(System.in);
        boolean keluar = false;

        while (!keluar) {
            System.out.println("\n========================================");
            System.out.println("            === Menu Utama ===          ");
            System.out.println("========================================");
            System.out.println("1. Mulai Permainan");
            System.out.println("2. Lihat Leaderboard");
            System.out.println("3. Keluar");
            System.out.println("----------------------------------------");
            System.out.print("Pilih opsi (1/2/3): ");


            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    mulaiPermainan();
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    leaderboard.displayLeaderboard();
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Terima kasih telah bermain! Sampai jumpa!");
                    keluar = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public void mulaiPermainan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n===============================================");
        System.out.println("   === Selamat Datang di Game Tebak Negara! ===");
        System.out.println("===============================================");
        System.out.println("               Pilih Mode Permainan:");
        System.out.println("------------------------------------------------");
        System.out.println("1. Mudah (300 detik)");
        System.out.println("2. Sedang (240 detik)");
        System.out.println("3. Sulit (180 detik)");
        System.out.println("------------------------------------------------");
        System.out.print("Masukkan pilihan Anda (1/2/3): ");



        int mode = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int totalWaktu = (mode == 1) ? 300 : (mode == 2) ? 240 : 180;
        List<Negara> daftarNegara = (mode == 1) ? daftarNegaraMudah
                : (mode == 2) ? daftarNegaraSedang
                : daftarNegaraSusah;

        int skor = 0;
        long waktuMulai = System.currentTimeMillis();
        Set<String> negaraSudahMuncul = new HashSet<>(); // Untuk memastikan negara tidak berulang

        System.out.println("\n=== Mulai Permainan! ===");
        for (int i = 1; i <= 10; i++) {
            long waktuSekarang = System.currentTimeMillis();
            if ((waktuSekarang - waktuMulai) / 1000 > totalWaktu) {
                System.out.println("\u23f0 Waktu habis!");
                break;
            }

            Negara negaraSekarang;
            do {
                negaraSekarang = daftarNegara.get(random.nextInt(daftarNegara.size()));
            } while (negaraSudahMuncul.contains(negaraSekarang.getNama())); // Hindari duplikasi negara

            negaraSudahMuncul.add(negaraSekarang.getNama()); // Tambahkan negara ke daftar yang sudah muncul

            String hurufAcak = negaraSekarang.getAcakHuruf();

            System.out.println("\nPertanyaan #" + i + ":");
            System.out.println("Huruf Acak: " + hurufAcak);

            boolean sudahMenjawabBenar = false;
            while (!sudahMenjawabBenar) {
                System.out.print("Jawaban Anda (atau ketik 'hint'): ");
                String jawaban = scanner.nextLine().trim();

                if (jawaban.equalsIgnoreCase("hint")) {
                    System.out.println("Hint Level 1: Warna Bendera - " + negaraSekarang.getBendera());
                    skor -= 3;

                    System.out.print("Jawaban Anda (atau ketik 'hint2'): ");
                    jawaban = scanner.nextLine().trim();

                    if (jawaban.equalsIgnoreCase("hint2")) {
                        System.out.println("Hint Level 2: Fakta - " + negaraSekarang.getFakta());
                        skor -= 2;

                        System.out.print("Jawaban Anda (atau ketik 'hint3'): ");
                        jawaban = scanner.nextLine().trim();

                        if (jawaban.equalsIgnoreCase("hint3")) {
                            System.out.println("Hint level 3: Benua - "+negaraSekarang.getBenua());
                            skor -= 1;
                        }
                     }
                }

                if (jawaban.equalsIgnoreCase(negaraSekarang.getNama())) {
                    System.out.println("\uD83C\uDF89 Benar!");
                    skor += 10;
                    sudahMenjawabBenar = true;
                }
                // Jika jawaban tidak benar dan tidak merupakan hint
                else if (!jawaban.equalsIgnoreCase("hint") &&
                        !jawaban.equalsIgnoreCase("hint2") &&
                        !jawaban.equalsIgnoreCase("hint3")) {
                    System.out.println("\u274C Salah! Jawaban yang benar adalah: " + negaraSekarang.getNama());
                    break;  // Keluar dari loop jika jawabannya salah
                }
            }
        }

        System.out.println("\n=== Permainan Selesai ===");
        System.out.println("Skor Akhir Anda: " + skor);
        updateLeaderboard(skor);
        System.out.println("Terima kasih telah bermain!");
    }

    private void updateLeaderboard(int skor) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama Anda untuk leaderboard: ");
        String nama = scanner.nextLine().trim();

        leaderboard.addScore(nama, skor); // Gunakan class Leaderboard
        leaderboard.displayLeaderboard(); // Tampilkan leaderboard
    }

}


