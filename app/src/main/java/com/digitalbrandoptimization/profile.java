package com.digitalbrandoptimization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class profile extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();

        try {
            ((TextView) findViewById(R.id.txtEmail)).setText(firebaseAuth.getCurrentUser().getEmail());

            //((TextView) findViewById(R.id.txt_user_name)).setText(firebaseAuth.getCurrentUser().getDisplayName() + " " + firebaseAuth.getCurrentUser().getPhoneNumber());

        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
