package com.example.hayotebak;

public class Pertanyaan_Kuis {
    public String pertanyaan[]= {
                "2 + 4 = ?",
                "4 - 2 = ?",
                "2 x 4 = ?",
                "4 : 2 = ?",
                "2 log 4 = ?",
    };

    private String jawabanBenar[]= {
        "6", "2", "8", "2", "2",
    };

    public String getPertanyaan(int x) {
        String soal = pertanyaan[x];
        return soal;
    }
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
