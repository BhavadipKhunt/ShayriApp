package com.example.shayri_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    String shayri[]={"लव शायरी","ईश्वर भक्ति शायरी","दोस्ती शायरी","भाई शायरी"," सैड शायरी","जीवन शायरी","मजेदार शायरी "
            ,"राजस्थानी शायरी","राजनीति शायरी","यादें शायरी "};
    int image[]={R.drawable.love,R.drawable.god,R.drawable.friend,R.drawable.brother,R.drawable.sad,R.drawable.life,R.drawable.comedy,
            R.drawable.rajashthani,R.drawable.rajniti,R.drawable.yade};
    Custom_adapter customAdapter;

    ListView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.list_view_main_activity);

        customAdapter=new Custom_adapter(MainActivity.this,image,shayri);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("i",i);
            intent.putExtra("image",image[i]);
            startActivity(intent);


        });
    }
}