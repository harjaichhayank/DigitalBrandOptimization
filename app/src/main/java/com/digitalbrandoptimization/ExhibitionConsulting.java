package com.digitalbrandoptimization;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class ExhibitionConsulting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibition_consulting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        WebView webView;
        String content="\n" +
                " \n" +
                "Exhibition Consulting\n" +
                "The reason we consult :\n" +
                "Having run a full-fledged event, exhibition design and fabrication company which is still going strong, we realised that a lot of Business Owners were approaching us with the willingness to do some great exhibitions. We also understood that they wanted to be cost efficient and value for money was of utmost importance. The SeroCorp Consultancy model was created to take care of that need.\n" +
                "\n" +
                "Who should consult :\n" +
                "All Business Owners who are starting to participate in the exhibitions or have been participating in exhibitions for some time now.\n" +
                "\n" +
                "A Partner or a Vendor :\n" +
                "We also realised that at such important juncture of a company’s life cycle where a business needs to go out and show it to the world, getting the right advice is very important. While a vendor can just do what is asked, a partner / consultant can help you with some great suggestions and innovative ways of exhibiting.\n" +
                "\n" +
                "The reason we consult :\n" +
                "Having run a full-fledged event, exhibition design and fabrication company which is still going strong, we realised that a lot of Business Owners were approaching us with the willingness to do some great exhibitions. We also understood that they wanted to be cost efficient and value for money was of utmost importance. The SeroCorp Consultancy model was created to take care of that need.\n" +
                "\n" +
                "Why was it possible for us to do it :\n" +
                "\n" +
                "Why was it possible for us to do it\n" +
                "Experience of more than 17 years\n" +
                "More than 2000 projects in exhibitions and events\n" +
                "A portfolio of more than 70% of customers as multinationals or Foreign companies\n" +
                "Completed projects in more than 32 cities in India\n" +
                "Project Experience in Asia, Europe & Americas\n" +
                "What all can we do:\n" +
                "\n" +
                "Make you self-sufficient in doing exhibitions\n" +
                "Access to direct vendors across all these cities and countries where you participate\n" +
                "Help you book the right locations\n" +
                "Deal with organisers on your behalf\n" +
                "Design the right stand / booth designs for you\n" +
                "Graphics conceptualisation and designing\n" +
                "Negotiate with vendors for you to get the best price\n" +
                "Making sure that right elements and materials are given by the vendor\n" +
                "Site inspections for quality checks\n" +
                "  Copyright © Sero Corporate Solutions Pvt. Ltd. 2014. All Rights Reserved.";
        webView = (WebView) findViewById(R.id.simpleWebView);
        // displaying text in WebView

        webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
    }
}
