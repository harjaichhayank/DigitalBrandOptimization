package com.digitalbrandoptimization;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class Partners extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partners);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        WebView webView;
        String content="\n" +
                " \n" +
                "Partners\n" +
                "We have always believed that a task should be taken up by a team who knows it the best. We know our work in Exhibitions, Events and Branding the best, but there are so many other aspects of marketing which need to be handled by the best teams. Here are some of our trusted partners who are masters in their trade and help a lot of our customers in their marketing initiatives with their specialized services. All of them have been carefully chosen after testing them over and over again with their services and competency.\n" +
                "\n" +
                "Their specialization and names are as below:\n" +
                "\n" +
                "Public Relations\n" +
                "Communications Inc.\n" +
                "Abhinav Sood\n" +
                "\n" +
                "Web Development \n" +
                "Detecvision Technologies Pvt. Ltd.\n" +
                "Avdhesh Sharma\n" +
                "\n" +
                "Corporate Gifting\n" +
                "Consortiumgifts Pvt. Ltd.\n" +
                "Gaurav Bhagat\n" +
                "\n" +
                "Digital / Offset Printing\n" +
                "Color Dots Pre Press Studio\n" +
                "Tarun Chopra\n" +
                "\n" +
                "  Copyright © Sero Corporate Solutions Pvt. Ltd. 2014. All Rights Reserved.";
        webView = (WebView) findViewById(R.id.simpleWebView);
        // displaying text in WebView

        webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
    }
}
