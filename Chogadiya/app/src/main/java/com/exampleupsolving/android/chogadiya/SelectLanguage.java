package com.exampleupsolving.android.chogadiya;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class SelectLanguage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language);

        if(Utility.getLanguageId(this) >= 0) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void btnEnglishHandler(View view) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.edit().putString(getString(R.string.pref_language_key), "english").apply();

        startActivity(new Intent(this, MainActivity.class));
    }

    public void btnHindiHandler(View view) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.edit().putString(getString(R.string.pref_language_key), "hindi").apply();

        startActivity(new Intent(this, MainActivity.class));
    }
}
