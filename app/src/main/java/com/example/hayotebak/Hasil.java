package com.example.hayotebak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Hasil extends AppCompatActivity {
    Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        home = findViewById(R.id.btnHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hasil.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void onBackPressed() {
        Toast.makeText(this, "Tidak bisa kembali, silakan tekan tombol home", Toast.LENGTH_SHORT).show();
    }
}
