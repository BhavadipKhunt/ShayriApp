package com.example.shayri_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custome_adapter_2 extends BaseAdapter
{
    String[] loveshayri;
    TextView textView;
    ImageView imageView;
    MainActivity2 mainActivity2;
    int image;
    public Custome_adapter_2(MainActivity2 mainActivity2, String[] loveshayri, int image) {
        this.mainActivity2=mainActivity2;
        this.loveshayri=loveshayri;
        this.image=image;
    }

    @Override
    public int getCount() {
        return loveshayri.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(mainActivity2).inflate(R.layout.list_view_main_activity,viewGroup,false);
        textView=view.findViewById(R.id.List_view_txt1);
        imageView=view.findViewById(R.id.List_view_image);
        textView.setText(""+loveshayri[i]);
        imageView.setImageResource(image);
        return view;
    }
}
