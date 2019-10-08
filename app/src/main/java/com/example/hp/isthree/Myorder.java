package com.example.hp.isthree;

import android.content.Intent;
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

public class Myorder extends AppCompatActivity {
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,statustxt;
    Button cancelbtn;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        txt1=(TextView)findViewById(R.id.txt);
        txt2=(TextView)findViewById(R.id.txt2);
        txt3=(TextView)findViewById(R.id.txt3);
        txt4=(TextView)findViewById(R.id.txt4);
        txt5=(TextView)findViewById(R.id.txt5);
        txt6=(TextView)findViewById(R.id.txt6);
        txt7=(TextView)findViewById(R.id.txt7);
        txt8=(TextView)findViewById(R.id.txt8);
        txt9=(TextView)findViewById(R.id.txt9);
        txt10=(TextView)findViewById(R.id.txt10);
        txt11=(TextView)findViewById(R.id.txt11);
        statustxt=(TextView)findViewById(R.id.status);
        cancelbtn=(Button)findViewById(R.id.cancelbtn);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Myorder.this,Cancel.class);
                startActivity(i);
            }
        });
        ref=FirebaseDatabase.getInstance().getReference().child("User_Order").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String shirt=dataSnapshot.child("shorts").getValue().toString();
                String tshirt=dataSnapshot.child("pants").getValue().toString();
                String pants=dataSnapshot.child("suit").getValue().toString();
                String gown=dataSnapshot.child("amount").getValue().toString();
                String skirt=dataSnapshot.child("gown").getValue().toString();
                String saree=dataSnapshot.child("salwar").getValue().toString();
                String top=dataSnapshot.child("saree").getValue().toString();
                String salwar=dataSnapshot.child("shirt").getValue().toString();
                String suit=dataSnapshot.child("skirt").getValue().toString();
                String shorts=dataSnapshot.child("top").getValue().toString();
                String total=dataSnapshot.child("tshirt").getValue().toString();
               // String status=dataSnapshot.child("status").getValue().toString();
                    txt1.setText(shirt);
                    txt2.setText(tshirt);
                    txt3.setText(pants);
                    txt4.setText(gown);
                    txt5.setText(skirt);
                    txt6.setText(saree);
                    txt7.setText(top);
                    txt8.setText(salwar);
                    txt9.setText(suit);
                    txt10.setText(shorts);
                    txt11.setText(total);
                    //statustxt.setText(status);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Myorder.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ref(View view) {
        Intent i=new Intent(Myorder.this,Feedback.class);
        startActivity(i);

    }
}
