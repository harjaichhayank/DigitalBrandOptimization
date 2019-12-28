package com.digitalbrandoptimization;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class forgotpassword extends AppCompatActivity {

    EditText temail;

    Button forgot;
    private ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        temail = (EditText) findViewById(R.id.editTextEmail);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = temail.getText().toString().trim();
                if (TextUtils.isEmpty(email)|| Patterns.EMAIL_ADDRESS.matcher(email).matches()==false) {
                    //Email is empty
                    //Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    temail.setError("Email address is not valid");
                    return;
                }
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(forgotpassword.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(forgotpassword.this, "Recovery email sent to your inbox", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(forgotpassword.this, "Account does not exists. Please register", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
