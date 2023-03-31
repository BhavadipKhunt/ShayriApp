package com.example.shayri_app;

import android.os.Environment;

import java.io.File;

public class config
{
    public static int gradients[]={R.drawable.bg_gradient1,R.drawable.bg_gradient2,R.drawable.bg_gradient3,R.drawable.bg_gradient4,R.drawable.bg_gradient5,R.drawable.bg_gradient6,R.drawable.bg_gradient7,R.drawable.bg_gradient8,R.drawable.bg_gradient9,R.drawable.bg_gradient10};
    public static int color[]={R.drawable.color_1,R.drawable.color_2,R.drawable.color_3,R.drawable.color_4,R.drawable.color_5,R.drawable.color_6,R.drawable.color_7,R.drawable.color_8,R.drawable.color_9,R.drawable.color_10};
    public static int textcolor[]={R.color.grey,R.color.darkforest,R.color.red,R.color.blue,R.color.pink,R.color.brown,R.color.purple,R.color.yellow,R.color.mightgreen,R.color.black};
    public static String[] emoji={"😂😅🤣😂😅","😍🥰😘😋😍🥰😘😋","🎂🎂🎂👏👏👏🎂🎂🎂","💥💢💥💢💥💢","👨‍❤️‍👨👧👧👧👧👨‍❤️‍👨"};
    public static String[] fonts={"constan.ttf","constanb.ttf","constani.ttf","constanz.ttf","Inkfree.ttf"};
    public static File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);;
}
