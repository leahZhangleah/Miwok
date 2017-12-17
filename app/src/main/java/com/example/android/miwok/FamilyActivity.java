package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_view);
        ArrayList<Word> familyMembers = new ArrayList<Word>();
        familyMembers.add(new Word("әpә","father"));
        familyMembers.add(new Word("әṭa","mother"));
        familyMembers.add(new Word("angsi","son"));
        familyMembers.add(new Word("tune","daughter"));


        ListView listView = (ListView) findViewById(R.id.word_list_view);
        WordAdapter arrayAdapter = new WordAdapter(this,familyMembers);
        listView.setAdapter(arrayAdapter);
    }
}

