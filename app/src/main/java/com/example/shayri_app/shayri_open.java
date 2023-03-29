package com.example.shayri_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Random;

public class shayri_open extends AppCompatActivity implements View.OnClickListener
{

        TextView textView,textView1;
        String shayri;
        String[] shayriarr;
        int k,position;
        Button Zoom,swipeleft,swipright,edit,change,share,copy;
        GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayri_open);
        Zoom=findViewById(R.id.Zoom_In_button);
        textView=findViewById(R.id.shayri_show_txt);
        swipeleft=findViewById(R.id.swiplefr_botton);
        change=findViewById(R.id.color_change_icon);
        textView1=findViewById(R.id.shayri_count_txt);
        swipright=findViewById(R.id.swipright_button);
        k=getIntent().getIntExtra("i1",0);
        shayri=getIntent().getStringExtra("shayri");
        share=findViewById(R.id.share_button_1);
        share.setOnClickListener(this);
        System.out.println(""+k);
        shayriarr=getIntent().getStringArrayExtra("s");
        textView.setText(""+shayri);
        edit=findViewById(R.id.Edit_button);
        textView1.setText(""+(k+1)+"/"+shayriarr.length);
        edit.setOnClickListener(this);
        change.setOnClickListener(this);
        swipright.setOnClickListener(this);
        swipeleft.setOnClickListener(this);
        Zoom.setOnClickListener(this);
        copy=findViewById(R.id.copy_button);
        copy.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
                if(view.getId()==Zoom.getId())
                {
                    BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
                    bottomSheetDialog.setContentView(R.layout.activity_shayri_grid_view);
                    gridView=bottomSheetDialog.findViewById(R.id.grid_gradient);
                    BackgroundAdapter backgroundAdapter=new BackgroundAdapter(shayri_open.this,config.gradients);

                    gridView.setAdapter(backgroundAdapter);
                    bottomSheetDialog.show();
                    gridView.setOnItemClickListener((adapterView, view1, i, l) -> {
                        textView.setBackgroundResource(config.gradients[i]);
                        position=i;
                        bottomSheetDialog.cancel();

                    });
                }
                if(view.getId()==change.getId())
                {
                    int max=9;
                    int min=0;
                    int m=new Random().nextInt(max-min)+min;
                    textView.setBackgroundResource(config.gradients[m]);

                }
                    if (view.getId() == swipeleft.getId()) {
                        if(k>0) {
                            k--;

                            textView.setText(shayriarr[k]);
                            textView1.setText(""+(k+1)+"/"+shayriarr.length);
                        }
                    }



                    if(view.getId()==swipright.getId())
                    {
                        if(k<shayriarr.length-1) {
                            k++;
                            textView.setText(shayriarr[k]);
                            textView1.setText(""+(k+1)+"/"+shayriarr.length);
                        }
                    }
                if(view.getId()==edit.getId())
                {
                    Intent intent2=new Intent(shayri_open.this,Edit_shayri_activity.class);
                    intent2.putExtra("shayri",shayri);
                    intent2.putExtra("i",position);
                    startActivity(intent2);
                }
                if(view.getId()==share.getId())
                {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT,textView.getText());
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Shayri");
                    startActivity(Intent.createChooser(shareIntent, "Share..."));
                }
                if(view.getId()==copy.getId())
                {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("Copy",textView.getText());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(this, "Copied..", Toast.LENGTH_SHORT).show();

                }


    }
}