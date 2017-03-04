package com.example.caeser.projectpart1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.caeser.projectpart1.Model.UserData;
import com.example.caeser.projectpart1.Utils.Constants;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserList extends AppCompatActivity {

    private RecyclerView rv_user;
    private FirebaseRecyclerAdapter<UserData, UserDataViewHolder> user_adapter;
    private DatabaseReference userRef;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        
        initializeScreen();


    }

    private void initializeScreen() {
        rv_user = (RecyclerView)findViewById(R.id.rv_user);
        rv_user.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        userRef = FirebaseDatabase.getInstance().getReference(Constants.POSTS);
        setupAdapter();
    }

    private void setupAdapter() {
        user_adapter = new FirebaseRecyclerAdapter<UserData, UserDataViewHolder>(
                UserData.class,
                R.layout.user_card,
                UserDataViewHolder.class,
                userRef
        ) {
            @Override
            protected void populateViewHolder(UserDataViewHolder viewHolder, UserData model, int position) {


                viewHolder.setCardName(model.getName());
                viewHolder.setCardCollege(model.getCollege());
                viewHolder.setCardContact(model.getContact());
                viewHolder.setCardCanteen(model.getCanteen());
                viewHolder.setCardEmail(model.getEmail());
                viewHolder.setCardID(model.getID());

            }
        };
    }

    public static class UserDataViewHolder extends RecyclerView.ViewHolder {

        public static TextView cardName;
        public static TextView cardCollege;
        public static TextView cardContact;
        public static TextView cardCanteen;
        public static TextView cardEmail;
        public static TextView cardID;

        public UserDataViewHolder(View itemView) {
            super(itemView);

            cardName = (TextView)itemView.findViewById(R.id.user_name);
            cardCollege = (TextView)itemView.findViewById(R.id.user_college);
            cardContact = (TextView)itemView.findViewById(R.id.user_contact);
            cardCanteen = (TextView)itemView.findViewById(R.id.user_canteen);
            cardEmail = (TextView)itemView.findViewById(R.id.user_email);
            cardID = (TextView)itemView.findViewById(R.id.user_ID);

        }

        public void setCardName(String cardName1){
            cardName.setText(cardName1);
        }
        public void setCardCollege(String cardCollege1){
            cardName.setText(cardCollege1);
        }
        public void setCardContact(String cardContact1){
            cardName.setText(cardContact1);
        }
        public void setCardCanteen(String cardCanteen1){
            cardName.setText(cardCanteen1);
        }
        public void setCardEmail(String cardEmail1){
            cardName.setText(cardEmail1);
        }
        public void setCardID(String cardID1){
            cardName.setText(cardID1);
        }
    }
}
