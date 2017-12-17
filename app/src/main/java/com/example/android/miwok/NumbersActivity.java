package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_view);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("lutti","one"));
        words.add(new Word("otiiko","two"));
        words.add(new Word("tolookosu","three"));
        words.add(new Word("oyyisa","four"));


        ListView listView = (ListView) findViewById(R.id.word_list_view);
        WordAdapter arrayAdapter = new WordAdapter(this,words);
        listView.setAdapter(arrayAdapter);
    }


}