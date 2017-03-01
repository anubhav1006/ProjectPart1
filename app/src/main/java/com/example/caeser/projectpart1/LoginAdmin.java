package com.example.caeser.projectpart1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.R.attr.button;

/**
 * Created by Caeser on 27-02-2017.
 */

public class LoginAdmin extends AppCompatActivity implements View.OnClickListener {

    private Button login;
    private EditText ETemail, ETpass;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), AdminPage.class));

        }
        progressDialog = new ProgressDialog(this);
        login = (Button) findViewById(R.id.login);
        ETemail = (EditText) findViewById(R.id.email);
        ETpass = (EditText) findViewById(R.id.password);

        login.setOnClickListener(this);


    }

    private void loginUser(){
        String email = ETemail.getText().toString().trim();
        String pass = ETpass.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }

        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }

        progressDialog.setMessage("Logging in....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                           String uid = firebaseAuth.getCurrentUser().getUid();
                            finish();
                           startActivity(new Intent(getApplicationContext(), AdminPage.class));

                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Login Error. Please try again!",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {
        if(v == login){
            loginUser();
        }
    }
}
