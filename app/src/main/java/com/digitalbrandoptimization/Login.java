package com.digitalbrandoptimization;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login  extends AppCompatActivity implements View.OnClickListener {
    Button signin;
    EditText temail;
    EditText tpass;
    TextView treg;
    TextView forgot;
    private ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    DatabaseReference databasepatient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        databasepatient = FirebaseDatabase.getInstance().getReference("patients");
        signin.setOnClickListener(this);
        treg.setOnClickListener(this);
        findViewById(R.id.lblskip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.about:
//                Intent i = new Intent(getBaseContext(), About.class);
//                startActivity(i);
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflator = getMenuInflater();
//        inflator.inflate(R.menu.menu_about, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    private void init() {
        temail = (EditText) findViewById(R.id.editTextEmail);
        tpass = (EditText) findViewById(R.id.editTextPassword);
        signin = (Button) findViewById(R.id.buttonSignin);
        treg = (TextView) findViewById(R.id.textViewSignup);
        forgot=(TextView)findViewById(R.id.forgotpassword);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        if (user != null && user.isEmailVerified()) {
            //profile activity here
            finish();
            startActivity(new Intent(Login.this, MainActivity.class));

        }
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
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(Login.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login.this, "Recovery email sent to your inbox", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(Login.this, "Account does not exists. Please register", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    @Override
    public void onClick(View v) {
        if (v == signin) {
            userlogin();
        }
        if (v == treg) {

            startActivity(new Intent(getApplicationContext(), Registration.class));

        }
    }

    private void userlogin() {
        String email = temail.getText().toString().trim();
        String pass = tpass.getText().toString().trim();
        if (TextUtils.isEmpty(email)|| Patterns.EMAIL_ADDRESS.matcher(email).matches()==false) {
            //Email is empty
            //Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            temail.setError("Email address is not valid");
            return;
        }
        if (TextUtils.isEmpty(pass)|| pass.length()<6) {
            //password is empty
            //Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            tpass.setError("Password must atleast 6 digits long");
            return;
        }
        progressDialog.setMessage("Signing In User....");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    //start the profile activity

                    checkifemailverified();

                } else {
                    temail.setError("Email or password is wrong");
                    //tpass.setError("Email or password is wrong");

                    //Toast.makeText(signinactivity.this, "Account with given details not exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkifemailverified() {
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user.isEmailVerified() )//|| user.getEmail().equals(KEY_EMAIL)
        {
            startActivity(new Intent(Login.this,MainActivity.class));
            finish();
            Toast.makeText(this, "Successfully signed in", Toast.LENGTH_SHORT).show();
        }
        else
        {
            FirebaseAuth.getInstance().signOut();
            temail.setError("Email not verified");
        }

    }
}