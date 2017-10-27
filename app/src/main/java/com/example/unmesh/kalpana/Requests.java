package com.example.unmesh.kalpana;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Requests extends AppCompatActivity {
    ListView listView;
    String uida[] = new String[100];
    String uidt[] = new String[100];
    String uidp[] = new String[100];
    String uidf[] = new String[100];
    String uidso[] = new String[100];
    int ip = 0, fp;
    int ia = 0, fa;
    int is = 0, fs;
    int it = 0, ft;
    int iff = 0, ff;


    FirebaseDatabase Adduserinfo = FirebaseDatabase.getInstance();
    DatabaseReference myRef = Adduserinfo.getReference();
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        listView = (ListView) findViewById(R.id.displayreq);

    }

    @Override
    protected void onStart() {
        super.onStart();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getUidsa(dataSnapshot);
                getUidsp(dataSnapshot);
                getUidss(dataSnapshot);
                getUidst(dataSnapshot);
                getUidsf(dataSnapshot);

                displayInfo(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void displayInfo(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.child("Users").getChildren()) {

        }

    }

    private void getUidsa(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.child("Experts").getChildren()) {
            uida[ia] = ds.child("Automobile").getKey();
            ia++;
            fa = ia;
        }
    }

    private void getUidsp(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.child("Experts").getChildren()) {
            uidp[ip] = ds.child("Plumbing").getKey();
            ip++;
            fp = ip;
        }
    }

    private void getUidss(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.child("Experts").getChildren()) {
            uidso[is] = ds.child("SOS").getKey();
            is++;
            fs = is;
        }
    }

    private void getUidst(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.child("Experts").getChildren()) {
            uidt[it] = ds.child("Tech").getKey();
            it++;
            ft = it;
        }
    }

    private void getUidsf(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.child("Experts").getChildren()) {
            uida[iff] = ds.child("First Aid").getKey();
            iff++;
            ff = iff;
        }
    }

}
