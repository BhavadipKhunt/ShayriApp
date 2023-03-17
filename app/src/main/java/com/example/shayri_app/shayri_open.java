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
        String[] shayri1;
        int k;
        Button Zoom,swipeleft,swipright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayri_open);
        Zoom=findViewById(R.id.Zoom_In_button);
        textView=findViewById(R.id.shayri_show_txt);
        swipeleft=findViewById(R.id.swiplefr_botton);
        swipright=findViewById(R.id.swipright_button);
        k=getIntent().getIntExtra("i1",0);
        shayri=getIntent().getStringExtra("shayri");
        System.out.println(""+k);
        shayri1=getIntent().getStringArrayExtra("shayri");
        textView.setText(""+shayri);
        swipright.setOnClickListener(this);
        swipeleft.setOnClickListener(this);
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
                if(view.getId()==swipeleft.getId()) {
                    k--;
                            textView.setText(shayri);
                }
    }
}