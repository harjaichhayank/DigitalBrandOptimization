package com.digitalbrandoptimization;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class Awards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awards);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView webView;
        String content="\n" +
                " \n" +
                "Awards & Testimonials\n" +
                "Awards\n" +
                "To get recognition is motivating and we are proud of our team which has helped win awards for our clients in some of the most prestigious exhibitions.\n" +
                "\n" +
                "Host India 2011, Mumbai – Gold Award for Best stand design for Del Monte Foods\n" +
                "Aahar 2011, New Delhi – Best Stand Design for Del Monte Foods\n" +
                "Elecrama 2012, Mumbai – Best Stand Design for Honeywell Safety Products\n" +
                "Mining Mazma 2012, Mumbai – Second Best stand design for Sandvik Asia\n" +
                "Municipalika 2013, Greater Noida, NCR Delhi – Best Stand Design for Honeywell Gas Detection\n" +
                "Automation India 2014, Mumbai – Silver award for the second best stand design for Staubli India\n" +
                "World Book Fair 2015, New Delhi – Silver award for the second best stand design for Macaw Books\n" +
                "Testimonials\n" +
                "Our clients just love us. Getting a pat on the back from them is most rewarding for us and we would do anything to make their exhibition or event a great success. This is what some of our clients have to say about us:\n" +
                "\n" +
                "Aditya Sharma, Marcom Manager, Honeywell Life Safety\n" +
                "“Sero did an exceptional job by completing our stall at Fire India 2011 in just 2 days and delivering the stall with perfect quality, one day prior to the scheduled delivery date. Our technical team has never been so happy; we got one full day to install our products, which rarely happens in a time pressed scenario like this”\n" +
                "\n" +
                "Swastika Mukherjee, Marcom Manager, Sandvik Asia\n" +
                "“The setup at our recently held event at ISM Dhanbad had turned out to be excellent. This is not the first time the Sero team has given more than 100% in ensuring that we have a successful event. Thanks again and we shall look forward to many more such fantastic outcomes”\n" +
                "  Copyright © Sero Corporate Solutions Pvt. Ltd. 2014. All Rights Reserved.";
        webView = (WebView) findViewById(R.id.simpleWebView);
        // displaying text in WebView

        webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
    }
}
