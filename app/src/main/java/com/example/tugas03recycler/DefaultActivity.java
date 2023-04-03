package com.example.tugas03recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DefaultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);


        ImageView imageView = findViewById(R.id.iv_default);
        TextView nameTxt = findViewById(R.id.tv_default);
        TextView emailTxt = findViewById(R.id.tv_emaildefault);


        String nama = "Nama tidak Di set";
        String email ="";
        int image = 0;

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            image = extras.getInt("gambar");
            nama = extras.getString("nama");
            email = extras.getString("email");
        }

        imageView.setImageResource(image);
        nameTxt.setText(nama);
        emailTxt.setText(email);
    }
}