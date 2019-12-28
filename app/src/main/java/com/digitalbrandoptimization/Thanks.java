package com.digitalbrandoptimization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Thanks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);
        Globals g = Globals.getInstance();
        ((TextView)findViewById(R.id.txtLocation)).setText(g.getvLocation());
        ((TextView)findViewById(R.id.txtVenuDate)).setText(g.getvDate());
        ((TextView)findViewById(R.id.txtVenuOccasion)).setText(g.getvOccasion());
    }
}
