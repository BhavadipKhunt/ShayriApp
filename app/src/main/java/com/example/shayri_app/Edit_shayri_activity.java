package com.example.shayri_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Edit_shayri_activity extends AppCompatActivity implements View.OnClickListener
{
    String shaytiget;
    TextView textView1;
    Button textcolor,backcolor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_shayri);
        shaytiget=getIntent().getStringExtra("shayri");
        textView1=findViewById(R.id.Edit_text_1);
        textView1.setText(""+shaytiget);
        textcolor=findViewById(R.id.Textcolor_button);
        textcolor.setOnClickListener(this);
        backcolor=findViewById(R.id.Background_Button);
        backcolor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==textcolor.getId())
        {

        }
        if(v.getId()==backcolor.getId())

        {

        }
    }
}