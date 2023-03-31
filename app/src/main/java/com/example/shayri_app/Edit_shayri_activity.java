package com.example.shayri_app;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Edit_shayri_activity extends AppCompatActivity implements View.OnClickListener
{
    String shayriget;
    SeekBar seekBar;
    TextView textView1;

    GridView gridView,gridView1,gridView2;
    ListView listView;
    Button textcolor,backcolor,change,zoom,font,emoji,textsize,share;
    BottomSheetDialog dialog;
    BackgroundAdapter adapter;
    String type;
    File localFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_shayri);
        shayriget=getIntent().getStringExtra("shayri");
        textView1=findViewById(R.id.Edit_text_1);
        textView1.setText(shayriget);
        share=findViewById(R.id.Share_button_2);

        textcolor=findViewById(R.id.Textcolor_button);
        textcolor.setOnClickListener(this);
        backcolor=findViewById(R.id.Background_Button);
        backcolor.setOnClickListener(this);
        change=findViewById(R.id.Change_button_1);
        change.setOnClickListener(this);
        zoom=findViewById(R.id.Zoom_button_2);
        zoom.setOnClickListener(this);
        font=findViewById(R.id.Font_button);
        font.setOnClickListener(this);
        emoji=findViewById(R.id.Emoji_button);
        textsize=findViewById(R.id.Textsize_button);
        textsize.setOnClickListener(this);
        emoji.setOnClickListener(this);
        share.setOnClickListener(this);
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
        if(v.getId()==font.getId()) {
            BottomSheetDialog dialog1 = new BottomSheetDialog(this);
            dialog1.setContentView(R.layout.font_gride_text);
            listView = dialog1.findViewById(R.id.list_item_view_emoji);
            type="font";
            fontadapter fontadapter = new fontadapter(Edit_shayri_activity.this,config.fonts,type);

            listView.setAdapter(fontadapter);
            dialog1.show();
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Typeface typeface = Typeface.createFromAsset(getAssets(), config.fonts[i]);
                   // textView1.setText("bhavadip");
                    textView1.setTypeface(typeface);
                }
            });
        }
        if(v.getId()==emoji.getId()) {
            BottomSheetDialog dialog1 = new BottomSheetDialog(this);
            dialog1.setContentView(R.layout.font_gride_text);
            listView = dialog1.findViewById(R.id.list_item_view_emoji);
            type="emoji";
            fontadapter fontadapter = new fontadapter(Edit_shayri_activity.this,config.emoji, type);

            listView.setAdapter(fontadapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    textView1.setText(""+config.emoji[i]+"\n"+
                            shayriget+"\n"+config.emoji[i]);
                }
            });
            dialog1.show();
        }

        if(v.getId()==textsize.getId()) {
            BottomSheetDialog dialog1 = new BottomSheetDialog(this);
            dialog1.setContentView(R.layout.text_size_view);
            seekBar = dialog1.findViewById(R.id.seekbar_text);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    textView1.setTextSize(2,i);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            dialog1.show();
        }
        if(v.getId()==share.getId())
        {
            Bitmap icon = getBitmapFromView(textView1);
            //Intent share = new Intent(Intent.ACTION_SEND);
            Intent share =new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            int num=new Random().nextInt(2000);//20230331110105
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            String currentDateandTime = sdf.format(new Date());

            localFile= new File(config.file.getAbsolutePath() + "/IMG_"+currentDateandTime+".jpg");
            try
            {
                localFile.createNewFile();
                FileOutputStream fo = new FileOutputStream(localFile);
                fo.write(bytes.toByteArray());
                Toast.makeText(Edit_shayri_activity.this,"File Downloaded",Toast.LENGTH_SHORT).show();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            share.putExtra(Intent.EXTRA_STREAM, Uri.parse(localFile.getAbsolutePath()));
            startActivity(Intent.createChooser(share, "Share Image"));
        }
    }
    private Bitmap getBitmapFromView(View view1)
    {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view1.getWidth(), view1.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = view1.getBackground();
        if (bgDrawable != null)
        {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }
        else
        {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        view1.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }
}