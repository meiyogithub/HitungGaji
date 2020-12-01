package com.rfa.hitunggaji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText bulan, namaKaryawan, gajiPokok, lembur, golongan, hariMasukKerja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bulan = findViewById(R.id.et_bulan);
        namaKaryawan = findViewById(R.id.et_namaKaryawan);
        gajiPokok = findViewById(R.id.et_gajiPokok);
        lembur = findViewById(R.id.et_lembur);
        golongan = findViewById(R.id.et_golongan);
        hariMasukKerja = findViewById(R.id.et_hariMasukKerja);
    }

    public void HitungGaji(View view) {
        Intent hitung = new Intent(MainActivity.this,HitungGaji.class);
        hitung.putExtra("Bulan", bulan.getText().toString());
        hitung.putExtra("Nama Karyawan", namaKaryawan.getText().toString());
        hitung.putExtra("Gaji Pokok", Integer.parseInt(gajiPokok.getText().toString()));
        hitung.putExtra("Lembur", Integer.parseInt(lembur.getText().toString()));
        hitung.putExtra("Golongan", Integer.parseInt(golongan.getText().toString()));
        hitung.putExtra("Hari Masuk Kerja", Integer.parseInt(hariMasukKerja.getText().toString()));
        startActivity(hitung);

    }
}