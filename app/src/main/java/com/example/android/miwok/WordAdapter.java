package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ceciliaHumlelu on 2017-12-17.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int textViewBackgroundColorId;

    public WordAdapter(@NonNull Context context, ArrayList<Word> words,int textViewBackgroundColorId) {
        super(context,R.layout.list_view, words);
        this.textViewBackgroundColorId = textViewBackgroundColorId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rootView = convertView;
        if (rootView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            rootView = inflater.inflate(R.layout.list_view,parent,false);
        }
        int color = ContextCompat.getColor(this.getContext(),textViewBackgroundColorId);

        TextView textView1 = (TextView) rootView.findViewById(R.id.miwork_word);
        textView1.setBackgroundColor(color);
        TextView textView2 = (TextView) rootView.findViewById(R.id.english_word);
        textView2.setBackgroundColor(color);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.image_view);
        textView1.setText(getItem(position).getMiwokTranslation());
        textView2.setText(getItem(position).getDefaultTranslation());
        if (getItem(position).hasImage()){
            imageView.setImageResource(getItem(position).getImage());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        return rootView;

    }
}
