package com.digitalbrandoptimization;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class CorpoarteEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corpoarte_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        WebView webView;
        String content="\n" +
                " \n" +
                "Corpoarte Events\n" +
                "We at Sero, specialize in Corporate Events and offer turnkey B2B event solutions to corporates who aspire to pamper their customers and present a great show. We not only provide end to end solutions, but also a memorable experience which our clients cherish forever.\n" +
                "\n" +
                "Our belief, “your event is our event”. We treat it like our own baby and handle it with the utmost care. Irrespective of the scale of the event, all events are treated with equal importance. These are some of the values we inculcate which makes us one of the best event companies in Delhi, NCR and in India.\n" +
                "\n" +
                "The kind of events we can handle for you are:\n" +
                "\n" +
                "Conferences\n" +
                "Seminars\n" +
                "Dealer Meets\n" +
                "Customer meet\n" +
                "Product Launches\n" +
                "“Location no bar”, we can handle these events for you all across India.\n" +
                "\n" +
                "We do this through our extremely efficient team and cost effective resources which can handle various aspects of events for you like venue selection, menu planning, event layout, stage design, backdrop, sound, light, audio visual, entertainment, security etc.\n" +
                "\n" +
                "We are passionate about our work and this shows with each event we deliver. It’s in our DNA.\n" +
                "  Copyright © Sero Corporate Solutions Pvt. Ltd. 2014. All Rights Reserved.";
        webView = (WebView) findViewById(R.id.simpleWebView);
        // displaying text in WebView

        webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);

    }
}
