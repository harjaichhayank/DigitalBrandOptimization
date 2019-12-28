package com.digitalbrandoptimization;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class ExhibitionsManagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibitions_management);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        WebView webView;
        String content="\n" +
                " \n" +
                "Exhibitions Management\n" +
                "We have now undertaken exhibitions in all parts of country with Delhi NCR, Mumbai, Bangalore, Chennai, Kolkata and Hyderabad seeing the bulk of them. Apart from that we also have the capability to manage exhibitions in smaller cities as well.\n" +
                "\n" +
                "We specialise in B2B exhibition management. We offer turnkey exhibition management solutions for our companies participating in exhibitions throughout India & abroad. Come to us with a bare space in an exhibition and we will create a customized stand out of it, which is high on brand visibility, creativity and quality, and Yes, this all is delivered at the site, Well In Time.\n" +
                "\n" +
                "Our own production unit helps us deliver you a quality product even at a short notice and its proximity to the various exhibition centres in Delhi and NCR makes us deliver some amazing stands at lightening speeds. Not only we are able to deliver a qualitative product but we manage to complete it on time every time and have now an impeccable record of stand delivery with all our customers.\n" +
                "\n" +
                "We believe that doing an exhibition is a journey and we provide you a memorable experience throughout that journey.\n" +
                "\n" +
                "We offer the following Exhibition services :\n" +
                "\n" +
                "3D stand designs and visualisation\n" +
                "Customised stand fabrication\n" +
                "Installation on site\n" +
                "Audio Visual support\n" +
                "Furniture & fixtures\n" +
                "Graphic design and printing\n" +
                "Liaison with exhibition organisers\n" +
                "Getting necessary approvals\n" +
                "Value added services\n" +
                "We have now undertaken exhibitions in all parts of country with Delhi NCR, Mumbai, Bangalore, Chennai, Kolkata and Hyderabad seeing the bulk of them. Apart from that we also have the capability to manage exhibitions in smaller cities as well.\n" +
                "\n" +
                "International Exhibitions\n" +
                "For the past 3 years, we have aggressively handled exhibitions outside India having covered most of Asia & Europe. With strong tie-ups with our partners in locations like Singapore, Thailand, Vietnam, Hong Kong, China, Germany, Amsterdam, Italy, Belgium & Sweden, we can handle your exhibitions across all these locations seamlessly.\n" +
                "  Copyright © Sero Corporate Solutions Pvt. Ltd. 2014. All Rights Reserved.";
        webView = (WebView) findViewById(R.id.simpleWebView);
        // displaying text in WebView

        webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
    }
}
