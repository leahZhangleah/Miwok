package com.example.android.miwok;

/**
 * Created by ceciliaHumlelu on 2017-12-17.
 */

public class Word {
    private String miwokWord;
    private String defaultWord;

    public Word(String miwokWord,String defaultWord){
        miwokWord = miwokWord;
        defaultWord = defaultWord;
    }

    public String getMiwokTranslation(){
        return miwokWord;
    }

    public String getDefaultTranslation(){
        return defaultWord;
    }
}
