package com.example.unmesh.kalpana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activerequest extends AppCompatActivity implements View.OnClickListener {

    Button cancelreq;
    int flag = getIntent().getExtras().getInt("Flag");
    FirebaseDatabase Adduserinfo = FirebaseDatabase.getInstance();
    DatabaseReference myRef = Adduserinfo.getReference("Experts");
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activerequest);

        cancelreq = (Button) findViewById(R.id);


        cancelreq.setOnClickListener(this);
    }

    public void cancelrequest() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (flag == 0) {
            myRef.child("Experts").child("First Aid").child(user.getUid()).removeValue();
            Toast.makeText(this, "Request Removed", Toast.LENGTH_LONG).show();
        }
        if (flag == 1) {
            myRef.child("Experts").child("Tech").child(user.getUid()).removeValue();
            Toast.makeText(this, "Request Removed", Toast.LENGTH_LONG).show();
        }
        if (flag == 2) {
            myRef.child("Experts").child("Automobile").child(user.getUid()).removeValue();
            Toast.makeText(this, "Request Removed", Toast.LENGTH_LONG).show();
        }
        if (flag == 3) {
            myRef.child("Experts").child("Plumbing").child(user.getUid()).removeValue())
            Toast.makeText(this, "Request Removed", Toast.LENGTH_LONG).show();
        }
        if (flag == 4) {
            myRef.child("Experts").child("SOS").child(user.getUid()).removeValue();
            Toast.makeText(this, "Request Removed", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View v) {
        if (v == cancelreq) {
            cancelrequest();
            finish();
            startActivity(new Intent(this, sendreq.class));
        }
    }
}
