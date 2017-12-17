package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_view);
        ArrayList<Word> colors = new ArrayList<Word>();
        colors.add(new Word("weṭeṭṭi","red"));
        colors.add(new Word("chokokki","green"));
        colors.add(new Word("ṭakaakki","brown"));
        colors.add(new Word("ṭopoppi","gray"));


        ListView listView = (ListView) findViewById(R.id.word_list_view);
        WordAdapter arrayAdapter = new WordAdapter(this,colors);
        listView.setAdapter(arrayAdapter);
    }
}
