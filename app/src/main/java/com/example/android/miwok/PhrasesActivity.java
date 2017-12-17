package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_view);
        ArrayList<Word> phrases = new ArrayList<Word>();
        phrases.add(new Word("minto wuksus","Where are you going?"));
        phrases.add(new Word("tinnә oyaase'nә","What is your name?"));
        phrases.add(new Word("oyaaset...","My name is..."));
        phrases.add(new Word("michәksәs?","How are you feeling?"));


        ListView listView = (ListView) findViewById(R.id.word_list_view);
        WordAdapter arrayAdapter = new WordAdapter(this,phrases);
        listView.setAdapter(arrayAdapter);
    }
}

