package com.example.unmesh.kalpana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profileactivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rfirst;
    RadioButton rplumb;
    RadioButton rtech;
    RadioButton rauto;
    Button confirm;
    EditText username;
    FirebaseDatabase Adduserinfo = FirebaseDatabase.getInstance();
    DatabaseReference myRef = Adduserinfo.getReference("Users");
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);

        //Buttons and radio buttons

        rfirst = (RadioButton) findViewById(R.id);
        rplumb = (RadioButton) findViewById(R.id);
        rauto = (RadioButton) findViewById(R.id);
        rtech = (RadioButton) findViewById(R.id);
        confirm = (Button) findViewById(R.id);
        username = (EditText) findViewById(R.id);

        confirm.setOnClickListener(this);


    }

    private void addUser() {
        String setusername = username.getText().toString().trim();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (!TextUtils.isEmpty(setusername)) {
            myRef.child(user.getUid()).child("Username").setValue(setusername);
            if (rfirst.isSelected()) {
                myRef.child(user.getUid()).child("First Aid").setValue("True");
            }
            if (rtech.isSelected()) {
                myRef.child(user.getUid()).child("Tech").setValue("True");
            }
            if (rauto.isSelected()) {
                myRef.child(user.getUid()).child("Automobile").setValue("true");
            }
            if (rplumb.isSelected()) {
                myRef.child(user.getUid()).child("Plumbing").setValue("true");
            }
        } else {
            Toast.makeText(this, "Fill in username", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View view) {
        if (view == confirm) {
            addUser();
            finish();
            startActivity(new Intent(this, sendreq.class));
        }
    }
}
