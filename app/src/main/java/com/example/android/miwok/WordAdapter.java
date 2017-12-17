package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ceciliaHumlelu on 2017-12-17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(@NonNull Context context, ArrayList<Word> words) {
        super(context,R.layout.list_view, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rootView = convertView;
        if (rootView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            rootView = inflater.inflate(R.layout.list_view,parent,false);
        }


        TextView textView1 = (TextView) rootView.findViewById(R.id.miwork_word);
        TextView textView2 = (TextView) rootView.findViewById(R.id.english_word);

        textView1.setText(getItem(position).getMiwokTranslation());
        textView2.setText(getItem(position).getDefaultTranslation());

        return rootView;

    }
}
