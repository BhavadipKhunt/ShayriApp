package com.example.shayri_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Frist_page extends AppCompatActivity {
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist_page);
        start=findViewById(R.id.Start_button);
        start.setOnClickListener(view -> {
            Intent in = new Intent(Frist_page.this,MainActivity.class);
            startActivity(in);
        });
    }
}