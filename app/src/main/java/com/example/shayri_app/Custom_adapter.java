package com.example.shayri_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom_adapter extends BaseAdapter
{
    MainActivity mainActivity;
    int[] image;
    String[] shayri;
    ImageView imageView;
    TextView textView;

    public Custom_adapter(MainActivity mainActivity, int[] image, String[] shayri)
    {
        this.mainActivity=mainActivity;
        this.image=image;
        this.shayri=shayri;
    }

    @Override
    public int getCount() {
        return shayri.length;
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
        view= LayoutInflater.from(mainActivity).inflate(R.layout.list_view_main_activity,viewGroup,false);
        imageView=view.findViewById(R.id.List_view_image);
        textView=view.findViewById(R.id.List_view_txt1);
        imageView.setImageResource(image[i]);
        textView.setText(""+shayri[i]);
        return view;
    }
}
