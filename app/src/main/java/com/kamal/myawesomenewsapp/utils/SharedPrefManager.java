package com.kamal.myawesomenewsapp.utils;

import android.content.Context;

/**
 * Created by Kamal Marcus.
 * kamalmarcus94@gmail.com
 * +201015793659
 */

public class SharedPrefManager {
    final String SHARED_PREF_NAME = SharedPrefManager.class.getName() + "_shared_pref";
    final String SEARCH_WORD = SharedPrefManager.class.getName() + "_search_word";
    Context context;
    static SharedPrefManager sharedPrefManager;

    private SharedPrefManager(Context context) {
        this.context = context;
    }

    public static SharedPrefManager getInstance(Context context) {
        if (sharedPrefManager == null)
            sharedPrefManager = new SharedPrefManager(context);
        return sharedPrefManager;
    }

    public void saveSearchWord(String searchWord) {
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE).edit().putString(SEARCH_WORD, searchWord).commit();
    }

    public String getSearchWord() {
        return context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE).getString(SEARCH_WORD, "");
    }
}
