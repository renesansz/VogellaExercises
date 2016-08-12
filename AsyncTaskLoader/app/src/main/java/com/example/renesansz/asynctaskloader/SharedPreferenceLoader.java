package com.example.renesansz.asynctaskloader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceLoader extends AsyncTaskLoader<SharedPreferences> implements SharedPreferences.OnSharedPreferenceChangeListener {

    private SharedPreferences prefs = null;

    public SharedPreferenceLoader(Context context) {
        super(context);
    }

    public static void persist(final SharedPreferences.Editor editor) {
        editor.apply();
    }


    @Override
    public SharedPreferences loadInBackground() {
        prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        prefs.registerOnSharedPreferenceChangeListener(this);

        return (prefs);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        onContentChanged();
    }

    @Override
    protected void onStartLoading() {
        if (prefs != null) {
            deliverResult(prefs);
        }
        if (takeContentChanged() || prefs == null) {
            forceLoad();
        }
    }
}
