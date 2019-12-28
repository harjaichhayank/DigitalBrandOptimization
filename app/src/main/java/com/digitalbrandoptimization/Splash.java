package com.digitalbrandoptimization;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    private final int SPLASH_SCREEN_TIME = 1000;
    private static boolean isFirstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (!isFirstTime) {
            /* New Handler to start the MainActivity
             * & close this Splash-Screen after some seconds.*/
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    /* Create an Intent that will start the Menu-Activity. */
                    Intent mainIntent = new Intent(Splash.this, Welcome.class);
                    startActivity(mainIntent);
                    finish();
                }
            }, SPLASH_SCREEN_TIME);
        }
        else {
            /* New Handler to start the MainActivity
             * & close this Splash-Screen after some seconds.*/
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    /* Create an Intent that will start the Menu-Activity. */
                    isFirstTime = false;
                    Intent mainIntent = new Intent(getApplicationContext(), Welcome.class);
                    startActivity(mainIntent);
                    finish();
                }
            }, SPLASH_SCREEN_TIME);
        }

    }
}
