package com.digitalbrandoptimization;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class Branding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branding);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
String content="\n" +
        " \n" +
        "Branding\n" +
        "Branding is one of the key features in the marketing function of any organization. We understand that adhering to the brand guidelines is of utmost importance for any corporate. We help our customers in the managing this most important part of their portfolio by managing the key branding initiatives.\n" +
        "\n" +
        "Whether it is Instore branding, office branding, Dealer showroom branding or any other related service, we can handle it all for you and that too in any part of the country. You name it, and we can help you there.\n" +
        "\n" +
        "Some of the key services which we provide under this segement are: :\n" +
        "\n" +
        "3D Signages\n" +
        "Large format printing\n" +
        "Customised product units\n" +
        "Branding instruments like rollup standees, scrollers etc\n" +
        "Flex or vinyl digital print banners\n" +
        "Backlit panels\n" +
        "All this is accompanied by “In-House Graphic Design Facility” so you don’t have to take multiple stops in your journey for a world class branding for your facility.\n" +
        "\n" +
        "A lot of people are creative, but the real art is how to show your creativity keeping in the limits of the brand guidelines. Our concept designers understand this fact and that is the reason so many multinationals entrust us with their design work.\n" +
        "\n" +
        "Come to us and we will create wonders for you!\n" +
        "\n" +
        "  Copyright © Sero Corporate Solutions Pvt. Ltd. 2014. All Rights Reserved.";
        WebView webView;
        webView = (WebView) findViewById(R.id.simpleWebView);
        // displaying text in WebView
        webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
    }
}
