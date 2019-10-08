package com.example.hp.isthree;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.jar.Manifest;

public class Home extends AppCompatActivity {
ImageView userimg;
DatabaseReference reference;
Button myorderbtn;
Button orderbtn,profilebtn,changadd,sharebtn,feedbtn,logoutbtn;
TextView usernametxt;
private int STORAGE_PERMISSION_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (!isConnected(Home.this))buildDialog(Home.this).show();
        else {


        profilebtn=(Button)findViewById(R.id.profile);//c//
        changadd=(Button)findViewById(R.id.changeadd);//c//
        sharebtn=(Button)findViewById(R.id.share);//c//
        feedbtn=(Button)findViewById(R.id.feedback);//c//
        myorderbtn=(Button)findViewById(R.id.myorder);//c//
        logoutbtn=(Button)findViewById(R.id.logoutbtn);//c//
        orderbtn=(Button)findViewById(R.id.order);//c//
        usernametxt=(TextView)findViewById(R.id.username);
        reference=FirebaseDatabase.getInstance().getReference().child("User_Address").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue().toString();
                usernametxt.setText("Welcome: \n"+name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // failed to load name
                Toast.makeText(Home.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
        changadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,ChangeAddress.class);
                startActivity(i);

            }
        });
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,Profile.class);
                startActivity(i);

            }
        });
        feedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,Feedback.class);
                startActivity(i);

            }
        });
        myorderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,Myorder.class);
                startActivity(i);

            }
        });
        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,Order.class);
                startActivity(i);

            }
        });
        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent=new Intent(Intent.ACTION_SEND);
                myintent.setType("text/plain");
                String sharebody="chaitanyamunje@gmail.com";
                String sharesub="Isthree";
                myintent.putExtra(Intent.EXTRA_SUBJECT,sharesub);
                myintent.putExtra(Intent.EXTRA_TEXT,sharebody);
                startActivity(Intent.createChooser(myintent,"Share Using"));

            }
        });logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthUI.getInstance()
                        .signOut(Home.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(Home.this, "User Signed Out", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
            }
        });
    }}
    public boolean isConnected(Context context){
        ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=cm.getActiveNetworkInfo();
        if (networkInfo!=null && networkInfo.isConnectedOrConnecting()){
            android.net.NetworkInfo mobile=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            android.net.NetworkInfo wifi=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

            if (mobile!=null && mobile.isConnectedOrConnecting() || (wifi!=null && wifi.isConnectedOrConnecting()))
                return true;
            else return false;
        }else
            return false;
    }
    public AlertDialog.Builder buildDialog (Context c){
        AlertDialog.Builder builder=new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("Please connect to mobile data or wifi");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        return builder;
    }
}
