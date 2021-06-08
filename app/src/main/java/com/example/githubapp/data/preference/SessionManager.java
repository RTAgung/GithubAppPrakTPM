package com.example.githubapp.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    public static final String KEY_LOGIN = "isLogin";
    public static final String KEY_USERNAME = "username";

    private Context context;
    private SharedPreferences pref = context.getSharedPreferences("Session", Context.MODE_PRIVATE);
    private SharedPreferences.Editor editor = pref.edit();

    public void createLoginSession() {
        editor.putBoolean(KEY_LOGIN, true)
                .commit();
    }

    public void logout() {
        editor.clear();
        editor.commit();
    }

    public boolean isLogin() {
        return pref.getBoolean(KEY_LOGIN, false);
    }

    public void saveToPreference(String key, String value) {
        editor.putString(key, value).commit();
    }

    public String getFromPreference(String key) {
        return pref.getString(key, "");
    }

    private SessionManager(Context context) {
        this.context = context;
    }

    private static SessionManager instance;

    public static SessionManager getInstance(Context context) {
        if (instance == null)
            instance = new SessionManager(context);
        return instance;
    }
}
