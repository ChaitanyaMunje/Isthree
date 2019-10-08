package com.example.hp.isthree;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
TextView nametxt,addresstxt,phno,altphno,emailtxt;
DatabaseReference ref;
Button callusbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nametxt=(TextView)findViewById(R.id.username);
        addresstxt=(TextView)findViewById(R.id.useraddresstxt);
        altphno=(TextView)findViewById(R.id.textaltmobileno);
        phno=(TextView)findViewById(R.id.mobileno);
        emailtxt=(TextView)findViewById(R.id.emailtxt);
        callusbtn=(Button)findViewById(R.id.callusbtn);
        callusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(Profile.this, "Call Us", Toast.LENGTH_SHORT).show();
                Intent call=new Intent(Intent.ACTION_DIAL);
                String p="tel :"+getString(R.string.phno);
                call.setData(Uri.parse(p));
                //startActivity(call);
            }
        });
        ref=FirebaseDatabase.getInstance().getReference().child("User_Address").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue().toString();
                String email=dataSnapshot.child("state").getValue().toString();
                String add = dataSnapshot.child("address").getValue().toString();
                String ph = dataSnapshot.child("mobileno").getValue().toString();
                String altphnno=dataSnapshot.child("altmobileno").getValue().toString();
                altphno.setText("Alternate Phone Number: \n "+altphnno);
                emailtxt.setText("Email Address:\n"+email);
                nametxt.setText("Name: \n"+name);
                addresstxt.setText("Address: \n"+add);
                phno.setText("Phone number: \n"+ph);

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Profile.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
