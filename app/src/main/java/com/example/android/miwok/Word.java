package com.example.android.miwok;

import android.media.Image;

/**
 * Created by ceciliaHumlelu on 2017-12-17.
 */

public class Word {
    private String miwokWord;
    private String defaultWord;
    private int wordImage = -1;
    private int soundId;

    public Word(String miwokWord,String defaultWord, int wordImage,int soundId){
        this.miwokWord = miwokWord;
        this.defaultWord = defaultWord;
        this.wordImage = wordImage;
        this.soundId = soundId;
    }

    public Word(String miwokWord,String defaultWord,int soundId){
        this.miwokWord = miwokWord;
        this.defaultWord = defaultWord;
        this.soundId = soundId;
    }


    public String getMiwokTranslation(){
        return miwokWord;
    }

    public String getDefaultTranslation(){
        return defaultWord;
    }
    public int getImage(){
        return wordImage;
    }
    public boolean hasImage(){
        return wordImage != -1;
    }

    public int getSoundId(){
        return soundId;
    }

    @Override
    public String toString() {
        return "Word{"
                + "miwokWord='"
                + miwokWord + '\''
                + ", defaultWord='"
                + defaultWord + '\''
                + ", wordImage="
                + wordImage
                + ", soundId="
                + soundId + '}';
    }
}
