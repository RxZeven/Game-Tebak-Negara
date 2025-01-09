import java.io.*;
import java.util.*;

class Negara {
    // === Enkapsulasi ===
    // Atribut bersifat private untuk melindungi data, dengan akses melalui getter
    private String nama;
    private String bendera;
    private String fakta;
    private String benua;

    public Negara(String nama, String bendera, String fakta, String benua) {
        this.nama = nama;
        this.bendera = bendera;
        this.fakta = fakta;
        this.benua = benua;
    }

    public String getNama() {
        return nama;
    }

    public String getBendera() {
        return bendera;
    }

    public String getFakta() {
        return fakta;
    }

    public String getBenua() {
        return benua;
    }

    public String getAcakHuruf() {
        // === Polimorfisme ===
        // Metode ini dapat di-override jika ada subclass Negara dengan logika acak berbeda
        List<Character> hurufList = new ArrayList<>();
        for (char c : nama.toCharArray()) {
            hurufList.add(c);
        }
        Collections.shuffle(hurufList);

        StringBuilder acakHuruf = new StringBuilder();
        for (char c : hurufList) {
            acakHuruf.append(c);
        }
        return acakHuruf.toString();
    }
}

// === Pewarisan ===
class NegaraBenua extends Negara {
    private String benua;

    public NegaraBenua(String nama, String bendera, String fakta, String benua) {
        super(nama, bendera, fakta, benua);
        this.benua = benua;
    }

    public String getBenua() {
        return benua;
    }

    @Override
    public String getAcakHuruf() {
        // Polimorfisme: logika acak huruf yang berbeda jika negara dari benua tertentu
        String original = super.getNama();
        if (benua.equalsIgnoreCase("Asia")) {
            return original.toUpperCase(); // Huruf diacak dengan format uppercase untuk benua Asia
        }
        return super.getAcakHuruf();
    }
}
