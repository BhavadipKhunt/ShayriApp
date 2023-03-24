package com.example.shayri_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BackgroundAdapter extends BaseAdapter
{

    Context context;
    int[] gradients;
    public BackgroundAdapter(Context context, int[] gradients) {
    this.context=context;
    this.gradients=gradients;
    }

    @Override
    public int getCount() {
        return gradients.length;
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
        TextView textView=view.findViewById(R.id.grid_item_text);
        textView.setBackgroundResource(gradients[i]);

        return view;
    }
}
