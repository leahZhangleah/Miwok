package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_view);


        //set up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Word> familyMembers = new ArrayList<Word>();
        familyMembers.add(new Word("әpә","father",R.drawable.family_father,R.raw.family_father));
        familyMembers.add(new Word("әṭa","mother",R.drawable.family_mother,R.raw.family_mother));
        familyMembers.add(new Word("angsi","son",R.drawable.family_son,R.raw.family_son));
        familyMembers.add(new Word("tune","daughter",R.drawable.family_daughter,R.raw.family_daughter));


        ListView listView = (ListView) findViewById(R.id.word_list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(FamilyActivity.this,familyMembers.get(i).getSoundId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
        WordAdapter arrayAdapter = new WordAdapter(this,familyMembers, R.color.category_family);
        listView.setAdapter(arrayAdapter);
    }
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

