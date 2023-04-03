package com.example.tugas03recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DefaultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        ImageView ivDefault = findViewById(R.id.iv_default);
        TextView tvDefault = findViewById(R.id.tv_default);

        Intent intent = getIntent();

        int logoAplikasi = intent.getIntExtra("GAMBAR_DEFAULT",0);
        String namaAplikasi = intent.getStringExtra("TEXT_DEFAULT");

        ivDefault.setImageResource(logoAplikasi);
        tvDefault.setText(namaAplikasi);
    }
}