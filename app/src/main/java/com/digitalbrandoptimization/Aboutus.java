package com.digitalbrandoptimization;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class Aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     String   content="\n" +
             " \n" +
             "About Us\n" +
             "Incorporated in 2010, Sero Corporate Solutions is offering services in Exhibition Management, Corporate Events & Branding. It provides exhibitions, events and branding solutions for companies who desire to have an edge over its competitors.\n" +
             "\n" +
             "Firstly, Sero provides customised stand building services for companies who are participating in various exhibitions. This includes turnkey management of the stand which includes layout planning, 3D visualisation, stand fabrication, and installation. Second, we undertake turnkey specialised Corporate Events like product launches, dealer meet, seminars and conferences. Last but not the least, we provide Branding Solutions to Multi nationals.\n" +
             "\n" +
             "We undertake projects all over India & abroad and are now currently catering to 36 cities. Sero has a highly motivated team of designers, executives and production staff which ensures that your product attracts eyeballs and desired results.\n" +
             "\n" +
             "Excelled by the presence of its own production unit, Sero has the advantage of serving anytime, anywhere. We make stunning stands, do amazing events, provide great quality with a memorable experience which brings you back to us again and again.\n" +
             "  Copyright © Sero Corporate Solutions Pvt. Ltd. 2014. All Rights Reserved.";

        WebView webView;
        webView = (WebView) findViewById(R.id.simpleWebView);
        // displaying text in WebView
        webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);

    }
}
