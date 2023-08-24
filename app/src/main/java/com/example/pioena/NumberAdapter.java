package com.example.pioena;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NumberAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    String[] arrNumberWord;
    int[] arrNumberImage;

    public NumberAdapter(Context context, String[] arrNumberWord, int[] arrNumberImage) {

        this.context = context;
        this.arrNumberWord = arrNumberWord;
        this.arrNumberImage = arrNumberImage;
    }

    @Override
    public int getCount() {
        return arrNumberWord.length;
    }

    @Override
    public Object getItem(int position) {
        return arrNumberWord[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        if(view == null){
            view = inflater.inflate(R.layout.number_layout, null);
        }

        ImageView numberImage =  view.findViewById(R.id.numberImage);
        TextView numberWord = view.findViewById(R.id.numberText);

        numberImage.setImageResource(arrNumberImage[position]);
        numberWord.setText(arrNumberWord[position]);

        return view;
    }
}