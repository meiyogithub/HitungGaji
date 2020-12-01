package com.rfa.hitunggaji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class HitungGaji extends AppCompatActivity {
    EditText bulan1, namaKaryawan1, gajiPokok1, lembur1, golongan1, hariMasukKerja1, tunjanganGolongan, tunjanganTransport, uangMakan, gajiKotor, pajak, gajiBersih;
    Integer totalTunjanganGolongan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_gaji);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bulan1 = findViewById(R.id.et_bulan1);
        namaKaryawan1 = findViewById(R.id.et_namaKaryawan1);
        gajiPokok1 = findViewById(R.id.et_gajiPokok1);
        lembur1 = findViewById(R.id.et_lembur1);
        golongan1 = findViewById(R.id.et_golongan1);
        hariMasukKerja1 = findViewById(R.id.et_hariMasukKerja1);
        tunjanganGolongan = findViewById(R.id.et_tunjanganGolongan);
        tunjanganTransport = findViewById(R.id.et_tunjanganTransport);
        uangMakan = findViewById(R.id.et_uangMakan);
        gajiKotor = findViewById(R.id.et_gajiKotor);
        pajak = findViewById(R.id.et_pajak);
        gajiBersih = findViewById(R.id.et_gajiBersih);


        bulan1.setText(getIntent().getStringExtra("Bulan"));

        namaKaryawan1.setText(getIntent().getStringExtra("Nama Karyawan"));

        Integer gaji = getIntent().getIntExtra("Gaji Pokok",0);
        gajiPokok1.setText(String.valueOf(gaji));

        Integer lembur = getIntent().getIntExtra("Lembur",0);
        lembur1.setText(String.valueOf(lembur));

        Integer golongan = getIntent().getIntExtra("Golongan",0);
        golongan1.setText(String.valueOf(golongan));

        Integer hari = getIntent().getIntExtra("Hari Masuk Kerja",0);
        hariMasukKerja1.setText(String.valueOf(hari));

        if (golongan == 1){
            totalTunjanganGolongan = 250000;
        } else if(golongan == 2){
            totalTunjanganGolongan = 500000;
        } else if(golongan == 3){
            totalTunjanganGolongan = 750000;
        } else if (golongan == 4){
            totalTunjanganGolongan = 1000000;
        }
        tunjanganGolongan.setText(String.valueOf(totalTunjanganGolongan));

        Integer totalTunjanganTransport = hari * 25000;
        tunjanganTransport.setText(String.valueOf(totalTunjanganTransport));

        Integer totalUangMakan = hari * 20000;
        uangMakan.setText(String.valueOf(totalUangMakan));

        Integer totalGajiKotor = gaji + lembur + totalTunjanganTransport + totalTunjanganGolongan + totalUangMakan;
        gajiKotor.setText(String.valueOf(totalGajiKotor));

        Integer totalPajak = totalGajiKotor / 10;
        pajak.setText(String.valueOf(totalPajak));

        Integer totalGajiBersih = totalGajiKotor - totalPajak;
        gajiBersih.setText(String.valueOf(totalGajiBersih));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}