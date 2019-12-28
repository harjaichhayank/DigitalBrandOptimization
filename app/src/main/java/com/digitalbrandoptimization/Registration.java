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


public class Registration extends AppCompatActivity implements View.OnClickListener {
    Button buttonRegister;
    EditText editTextEmail;
    EditText editTextPassword;
    TextView textViewSignin;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        init();
        mAuth = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                FirebaseAuth.getInstance().signOut();
                                startActivity(new Intent(Registration.this, Login.class));
                                finish();
                            } else {
                                overridePendingTransition(0, 0);
                                finish();
                                overridePendingTransition(0, 0);
                                startActivity(getIntent());
                            }
                        }
                    });
                } else {

                }
            }
        };
        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuth);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuth != null) {
            firebaseAuth.removeAuthStateListener(mAuth);
        }
    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId())
//        {
//            case R.id.about:
//                Intent i=new Intent(getBaseContext(),About.class);
//                startActivity(i);
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflator = getMenuInflater();
//        inflator.inflate(R.menu.menu_about, menu);
//        return super.onCreateOptionsMenu(menu);
//    }


    private void init() {
        firebaseAuth = FirebaseAuth.getInstance();
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignin = (TextView) findViewById(R.id.textViewSignin);
        progressDialog = new ProgressDialog(this);
        if (firebaseAuth.getCurrentUser() != null) {
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), Login.class));
            return;
        }
    }

    @Override
    public void onClick(View v) {
        if (v == buttonRegister) {
            registerUser();
        }
        if (v == textViewSignin) {
            signin();
        }
    }

    private void signin() {
        finish();
        startActivity(new Intent(getApplicationContext(), Login.class));

    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if (TextUtils.isEmpty(email) || Patterns.EMAIL_ADDRESS.matcher(email).matches() == false) {
            //Email is empty
            //Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            editTextEmail.setError("Email address is not valid");
            return;
        }
        if (TextUtils.isEmpty(password) || password.length() < 6) {
            //password is empty
            //Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            editTextPassword.setError("Password must atleast 6 digits long");
            return;
        }
        progressDialog.setMessage("Registering User....");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    Toast.makeText(Registration.this, "Email verification send to your inbox", Toast.LENGTH_SHORT).show();
                    //finish();
                    //startActivity(new Intent(getApplicationContext(),bookactivity.class));
                } else {
                    Toast.makeText(Registration.this, "Could not register. Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}