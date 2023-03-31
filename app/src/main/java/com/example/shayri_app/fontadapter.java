package com.example.shayri_app;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class fontadapter extends BaseAdapter
{
    Context context;
    String[] font;
    TextView textView;
    String type;
    public fontadapter(Context context, String[] fonts, String type)
    {
        this.context=context;
        this.font=fonts;
        this.type=type;
    }

    @Override
    public int getCount() {
        return font.length;
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
        view= LayoutInflater.from(context).inflate(R.layout.grid_item,viewGroup,false);
        textView=view.findViewById(R.id.grid_item_text);
        if(type.equals("font")) {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), config.fonts[i]);
            textView.setText("bhavadip");
            textView.setTypeface(typeface);
        }
        else {
                textView.setText(""+config.emoji[i]);
        }
        return view;
    }
}
