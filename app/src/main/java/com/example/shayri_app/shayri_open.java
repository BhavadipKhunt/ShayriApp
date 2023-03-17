package com.example.shayri_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class shayri_open extends AppCompatActivity implements View.OnClickListener
{

        TextView textView;
        String shayri;
        Button Zoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayri_open);
        Zoom=findViewById(R.id.Zoom_In_button);
        textView=findViewById(R.id.shayri_show_txt);
        shayri=getIntent().getStringExtra("shayri");
        textView.setText(""+shayri);
        Zoom.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
                if(view.getId()==Zoom.getId())
                {
                    Intent intent = new Intent(shayri_open.this,shayri_grid_view.class);
                    startActivity(intent);
                }
    }
}