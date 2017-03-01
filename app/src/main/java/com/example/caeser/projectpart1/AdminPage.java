package com.example.caeser.projectpart1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminPage extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    Button logout;
    TextView userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        logout = (Button) findViewById(R.id.logout);
        userName = (TextView) findViewById(R.id.userName);

        logout.setOnClickListener(this);

        userName.setText(user.getEmail().toString().trim());
    }

    @Override
    public void onClick(View v) {
        if(v==logout){

            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }
    }
}
