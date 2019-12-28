package com.digitalbrandoptimization;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.yarolegovich.lovelydialog.LovelyInfoDialog;
import com.yarolegovich.lovelydialog.LovelyProgressDialog;

import java.util.Calendar;
import java.util.HashMap;

public class Feedback extends AppCompatActivity {
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        init();

        findViewById(R.id.btnSendReview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendReview();
            }
        });
    }

    LovelyProgressDialog dialogWait;

    private void sendReview() {
        final Button btnSendReview = (Button) findViewById(R.id.btnSendReview);
        final EditText editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        final EditText editTextDesc = (EditText) findViewById(R.id.editTextDesc);
        if (TextUtils.isEmpty(editTextTitle.getText().toString().trim())) {
            //Email is empty
            //Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            editTextTitle.setError("Should be value");
            return;
        }
        if (TextUtils.isEmpty(editTextDesc.getText().toString().trim())) {
            //password is empty
            //Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            editTextDesc.setError("Description of reviews should be String");
            return;
        }

        HashMap<String, Object> objpayment = new HashMap<String, Object>();
        objpayment.put("Title", editTextTitle.getText().toString().trim());
        objpayment.put("Review", editTextDesc.getText().toString().trim());
        objpayment.put("DateTime", Calendar.getInstance().getTime().toString());

        addData(objpayment);

    }

    public void addData(final HashMap object) {
        dialogWait = new LovelyProgressDialog(Feedback.this);
        dialogWait.show();

        FirebaseDatabase.getInstance().getReference().child("feedback/" + firebaseAuth.getCurrentUser().getUid()).push().setValue(object)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            ((EditText) findViewById(R.id.editTextTitle)).setText("");
                            ((EditText) findViewById(R.id.editTextDesc)).setText("");
                            dialogWait.dismiss();
                            new LovelyInfoDialog(Feedback.this)
                                    .setTopColorRes(R.color.colorPrimary)
                                    .setIcon(R.drawable.ic_feedback)
                                    .setTitle("Success")
                                    .setMessage("Thank you ")
                                    .show();

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        dialogWait.dismiss();
                        new LovelyInfoDialog(Feedback.this)
                                .setTopColorRes(R.color.colorAccent)
                                // .setIcon(R.drawable.ic_add_friend)
                                .setTitle("False")
                                .setMessage("False to add Data success")
                                .show();
                    }
                });


    }


    private void init() {

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        if (firebaseAuth.getCurrentUser() == null) {
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), Login.class));
            return;
        }
    }
}
