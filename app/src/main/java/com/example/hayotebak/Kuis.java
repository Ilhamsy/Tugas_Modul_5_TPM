package com.example.hayotebak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Kuis extends AppCompatActivity {
    TextView viewSoal_;
    EditText edtJawaban_;
    Button btnSubmit_;
    int array, i = 0;
    String jawaban;

    Pertanyaan_Kuis pertanyaanKuis = new Pertanyaan_Kuis();
    NotificationViewActivity notificationViewActivity = new NotificationViewActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

        viewSoal_ = findViewById(R.id.viewSoal);
        edtJawaban_ = findViewById(R.id.edtJawaban);
        btnSubmit_ = findViewById(R.id.btnSubmit);
        setKonten();

        btnSubmit_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekJawaban();
            }
        });
    }

    private void cekJawaban() {
        if (edtJawaban_.getText().toString().isEmpty()) {
            if (edtJawaban_.getText().toString().equalsIgnoreCase(jawaban)) {
                Toast.makeText(this, "Jawaban Benar!!!", Toast.LENGTH_SHORT).show();
                setKonten();
            } else {
                notificationViewActivity.onCreate();
                //Toast.makeText(this, "Jawaban Salah!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setKonten() {
        edtJawaban_.setText(null);
        array = pertanyaanKuis.pertanyaan.length;
        if (i >= array) {
            Intent in = new Intent(Kuis.this, Hasil.class);
            in.putExtra("activity_kuis","pertanyaanKuis");
            startActivity(in);
        } else {
            viewSoal_.setText(pertanyaanKuis.getPertanyaan(i));
            jawaban = pertanyaanKuis.getJawabanBenar(i);
        }
        i++;
    }

    public void onBackPressed() {
        Toast.makeText(this, "Selesaikan kuis", Toast.LENGTH_SHORT).show();
    }
}
