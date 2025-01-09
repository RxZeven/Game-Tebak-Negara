import java.io.*;
import java.util.*;

// Kelas Leaderboard
class Leaderboard {
    private String leaderboardFile;

    public Leaderboard(String fileName) {
        this.leaderboardFile = fileName;
    }

    // Tambahkan skor baru dengan username
    public void addScore(String username, int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(leaderboardFile, true))) {
            writer.write(username + " - " + score);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data leaderboard.");
        }
    }

    // Menampilkan leaderboard dengan sorting berdasarkan skor
    public void displayLeaderboard() {
        System.out.println("\n=== Leaderboard ===");
        List<String> entries = getLeaderboardEntries();

        // Sorting skor secara menurun
        entries.sort((a, b) -> {
            int scoreA = Integer.parseInt(a.split(" - ")[1]);
            int scoreB = Integer.parseInt(b.split(" - ")[1]);
            return Integer.compare(scoreB, scoreA);
        });

        if (entries.isEmpty()) {
            System.out.println("Belum ada data leaderboard.");
        } else {
            for (String entry : entries) {
                System.out.println(entry);
            }
        }
    }

    // Membaca semua data leaderboard dari file
    private List<String> getLeaderboardEntries() {
        List<String> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(leaderboardFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                entries.add(line);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca data leaderboard.");
        }
        return entries;
    }


}