package com.example.unmesh.kalpana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sendreq extends AppCompatActivity implements View.OnClickListener {
    RadioButton rfirst;
    RadioButton rplumb;
    RadioButton rtech;
    RadioButton rauto;
    Button confirm;
    Button sos;
    int flag;
    FirebaseDatabase Adduserinfo = FirebaseDatabase.getInstance();
    DatabaseReference myRef = Adduserinfo.getReference();
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendreq);

        rfirst = (RadioButton) findViewById(R.id);
        rplumb = (RadioButton) findViewById(R.id);
        rauto = (RadioButton) findViewById(R.id);
        rtech = (RadioButton) findViewById(R.id);
        confirm = (Button) findViewById(R.id);
        sos = (Button) findViewById(R.id);
        confirm.setOnClickListener(this);


    }

    public void sendreq() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();


        if (rfirst.isSelected()) {
            myRef.child("Experts").child("First Aid").child(user.getUid()).setValue("true");
            myRef.child("Users").child(user.getUid()).child("location").setValue("true");
            Toast.makeText(this, "Request Sent", Toast.LENGTH_LONG).show();
            flag = 0;
        } else if (rtech.isSelected()) {
            myRef.child("Experts").child("Tech").child(user.getUid()).setValue("true");
            myRef.child("Users").child(user.getUid()).child("location").setValue("true");
            Toast.makeText(this, "Request Sent", Toast.LENGTH_LONG).show();
            flag = 1;

        } else if (rauto.isSelected()) {
            myRef.child("Experts").child("Automobile").child(user.getUid()).setValue("true");
            myRef.child("Users").child(user.getUid()).child("location").setValue("true");
            Toast.makeText(this, "Request Sent", Toast.LENGTH_LONG).show();
            flag = 2;

        } else if (rplumb.isSelected()) {
            myRef.child("Experts").child("Plumbing").child(user.getUid()).setValue("true");
            myRef.child("Users").child(user.getUid()).child("location").setValue("true");
            Toast.makeText(this, "Request Sent", Toast.LENGTH_LONG).show();
            flag = 3;

        } else {
            Toast.makeText(this, "Select a field", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void sosreq() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        myRef.child("Experts").child("SOS").child(user.getUid()).setValue("true");
        myRef.child("Users").child(user.getUid()).child("location").setValue("true");
        flag = 4;

    }

    @Override
    public void onClick(View view) {
        if (view == confirm) {
            //Add method
            sendreq();
            finish();
            Intent intent = new Intent(this, activerequest.class);
            intent.putExtra("Flag", flag);
            startActivity(intent);
        }
        if (view == sos) {
            //send SOS
            sosreq();
            finish();
            Intent intent = new Intent(this, activerequest.class);
            intent.putExtra("Flag", flag);
            startActivity(intent);
        }
    }


}
