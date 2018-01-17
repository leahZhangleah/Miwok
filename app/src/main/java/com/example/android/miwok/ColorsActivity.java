package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private AudioManager.OnAudioFocusChangeListener aChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_GAIN){
                mediaPlayer.start();
            }else if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT){
                mediaPlayer.pause();
            }else if (i == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }else if(i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mediaPlayer.pause();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_view);

        //set up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //list view data
        final ArrayList<Word> colors = new ArrayList<Word>();
        colors.add(new Word("weṭeṭṭi","red",R.drawable.color_red,R.raw.color_red));
        colors.add(new Word("chokokki","green",R.drawable.color_green,R.raw.color_green));
        colors.add(new Word("ṭakaakki","brown",R.drawable.color_brown,R.raw.color_brown));
        colors.add(new Word("ṭopoppi","gray",R.drawable.color_gray,R.raw.color_gray));

        //list view
        ListView listView = (ListView) findViewById(R.id.word_list_view);
        //set adapter for list view
        WordAdapter arrayAdapter = new WordAdapter(this,colors, R.color.category_colors);
        listView.setAdapter(arrayAdapter);

        //play audio file on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();

                //audio focus
                audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

                int result = audioManager.requestAudioFocus(aChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    //related audio file
                    mediaPlayer = MediaPlayer.create(ColorsActivity.this,colors.get(i).getSoundId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            releaseMediaPlayer();
                        }
                    });
                }

            }
        });




    }
    //When app stops
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();


    }

    private void releaseMediaPlayer(){
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(aChangeListener);
        }
    }
}
