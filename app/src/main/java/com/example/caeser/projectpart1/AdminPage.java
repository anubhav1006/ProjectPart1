package com.example.caeser.projectpart1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminPage extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    Button logout;
    TextView userName;
   private FirebaseDatabase database;
   private DatabaseReference myRef;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");
        firebaseAuth = FirebaseAuth.getInstance();

        user = firebaseAuth.getCurrentUser();
        logout = (Button) findViewById(R.id.logout);

        userName = (TextView) findViewById(R.id.userName);

        logout.setOnClickListener(this);

        if(user == null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
               String value = dataSnapshot.getValue(String.class).toString();
                Toast.makeText(getApplicationContext(), value , Toast.LENGTH_LONG).show();
              }

          @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });



        //if(!(userName==null))
        //userName.setText(user.getEmail().toString().trim());
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
