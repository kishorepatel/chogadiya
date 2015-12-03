package com.exampleupsolving.android.chogadiya;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class SettingsActivity extends PreferenceActivity
        implements Preference.OnPreferenceChangeListener,
        SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.pref_general);
        bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_language_key)));
    }

    private void bindPreferenceSummaryToValue(Preference pref){
        pref.setOnPreferenceChangeListener(this);

        setPreferenceSummary(pref, PreferenceManager.getDefaultSharedPreferences(pref.getContext()).getString(pref.getKey(), ""));
    }

    private void setPreferenceSummary(Preference pref, Object value){
        String stringValue = value.toString();
        String key = pref.getKey();

        if(pref instanceof ListPreference){
            ListPreference listPreference = (ListPreference) pref;
            int prefIndex = listPreference.findIndexOfValue(stringValue);
            if(prefIndex >= 0){
                pref.setSummary(listPreference.getEntries()[prefIndex]);
            }
        }
        else{
            pref.setSummary(stringValue);
        }
    }

    @Override
    protected void onResume() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.registerOnSharedPreferenceChangeListener(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        setPreferenceSummary(preference, newValue);
        return true;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}