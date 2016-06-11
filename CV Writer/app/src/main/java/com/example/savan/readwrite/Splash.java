package com.example.savan.readwrite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/KrinkesDecorPERSONAL.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );

        int secondsDelayed=1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(getBaseContext(), TemplateSelection.class));
                finish();
            }
        }, secondsDelayed * 1300);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}