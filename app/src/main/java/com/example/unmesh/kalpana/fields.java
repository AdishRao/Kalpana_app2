package com.example.unmesh.kalpana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class fields extends AppCompatActivity implements View.OnClickListener{

    //Declaring the variables
    private CheckBox achk;
    private CheckBox tchk;
    private CheckBox pchk;
    private CheckBox fchk;
    private Button subbtn;
    private Button skbtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fields);

        //Getting an instance of the db on create
        //mAuth = FirebaseAuth.getInstance();


        //Assigning the variables to their respective elements
        achk = (CheckBox)findViewById(R.id.autobx);
        tchk = (CheckBox)findViewById(R.id.techbx);
        pchk = (CheckBox)findViewById(R.id.plumbx);
        fchk = (CheckBox)findViewById(R.id.faidbx);
        subbtn = (Button)findViewById(R.id.submitbtn);
        skbtn = (Button)findViewById(R.id.skipbtn);

        subbtn.setOnClickListener(this);
        skbtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v == subbtn){
            String temp = new String();
            if (achk.isChecked()){
                temp = "Automobile";
            }
            if (tchk.isChecked()){
                temp = "Technology";
            }
            if (pchk.isChecked()){
                temp = "Plumbing";
            }
            if (fchk.isChecked()){
                temp = "First Aid";
            }
            finish();
            startActivity(new Intent(this, Profileactivity.class));

        }
        if (v == skbtn){
            finish();
            startActivity(new Intent(this, Profileactivity.class));
        }

    }
}
