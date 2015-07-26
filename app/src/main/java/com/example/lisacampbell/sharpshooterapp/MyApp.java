package com.example.lisacampbell.sharpshooterapp;
import android.content.Context;
import android.graphics.drawable.Drawable;
/**
 * Created by lisacampbell on 7/25/15.
 */
public class MyApp extends FirstLoginActivity {
    private static MyApp instance;

    public MyApp () {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }
}
