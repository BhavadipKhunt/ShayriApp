package com.example.shayri_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Random;

public class Edit_shayri_activity extends AppCompatActivity implements View.OnClickListener
{
    String shayriget;
    TextView textView1;
    GridView gridView,gridView1;
    Button textcolor,backcolor,change,zoom,share;
    BottomSheetDialog dialog;
    BackgroundAdapter adapter;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_shayri);
        shayriget=getIntent().getStringExtra("shayri");
        i=getIntent().getIntExtra("i",0);
        textView1=findViewById(R.id.Edit_text_1);
        textView1.setText(shayriget);
        textcolor=findViewById(R.id.Textcolor_button);
        textcolor.setOnClickListener(this);
        backcolor=findViewById(R.id.Background_Button);
        backcolor.setOnClickListener(this);
        change=findViewById(R.id.Change_button_1);
        change.setOnClickListener(this);
        zoom=findViewById(R.id.Zoom_button_2);
        textView1.setBackgroundResource(config.gradients[i]);
        zoom.setOnClickListener(this);
        share=findViewById(R.id.Share_button_2);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==textcolor.getId())
        {

            dialog=new BottomSheetDialog(this);
            dialog.setContentView(R.layout.color_background);
            gridView=dialog.findViewById(R.id.backgroun_color_gridview);
            adapter=new BackgroundAdapter(Edit_shayri_activity.this,config.textcolor);
            gridView.setAdapter(adapter);
            dialog.show();
            gridView.setOnItemClickListener((adapterView, view, i, l) -> {
                textView1.setTextColor(getResources().getColor(config.textcolor[i]));
                dialog.cancel();
            });




        }
          if(v.getId()==backcolor.getId())
        {

            dialog=new BottomSheetDialog(this);
            dialog.setContentView(R.layout.color_background);
            gridView=dialog.findViewById(R.id.backgroun_color_gridview);

            adapter=new BackgroundAdapter(Edit_shayri_activity.this,config.color);
            gridView.setAdapter(adapter);
            dialog.show();
            gridView.setOnItemClickListener((adapterView, view, i, l) -> {
                textView1.setBackgroundResource(config.color[i]);
                dialog.cancel();
            });


        }
          if(v.getId()==zoom.getId())
          {
              BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
              bottomSheetDialog.setContentView(R.layout.activity_shayri_grid_view);
              gridView1=bottomSheetDialog.findViewById(R.id.grid_gradient);
              BackgroundAdapter backgroundAdapter=new BackgroundAdapter(Edit_shayri_activity.this,config.gradients);

              gridView1.setAdapter(backgroundAdapter);
              bottomSheetDialog.show();
              gridView1.setOnItemClickListener((adapterView, view1, i, l) -> {
                  textView1.setBackgroundResource(config.gradients[i]);
                  bottomSheetDialog.cancel();

              });
          }
        if(v.getId()==change.getId())
        {
            int max=9;
            int min=0;
            int m=new Random().nextInt(max-min)+min;
            textView1.setBackgroundResource(config.gradients[m]);
        }
    }
}